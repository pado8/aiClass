package Test0320;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class MyDialog extends JDialog {
	private TextField tf = new TextField(10);
	private JButton okButton = new JButton("OK");
	private String nickName;

	public MyDialog(JFrame frame, String title) {
		super(frame, title, true);// 모달
		this.setLayout(new FlowLayout());
		this.add(tf);
		this.add(okButton);

		okButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				nickName = tf.getText();
				MyDialog.this.dispose();
			}

		});

		this.setSize(300, 200);
	}

	public String getNickName() {
        return nickName;
    }
}

public class ChatServer extends JFrame implements ActionListener {
	private MyDialog dialog;
	private String nickName; 

	private BufferedReader in = null;
	private BufferedWriter out = null;
	private ServerSocket listener = null;
	private Socket socket = null;
	private Receiver receiver; // JTextArea를 상속받고 Runnable 인터페이스를 구현한 클래스로서 받은 정보를 담는 객체
	private JTextField sender; // JTextField 객체로서 보내는 정보를 담는 객체



	
	public ChatServer() {
		dialog = new MyDialog(this, "닉네임 설정 창");
		dialog.setVisible(true);
		nickName = dialog.getNickName();

		setTitle("서버 채팅 창"); // 프레임 타이틀
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //프레임 종료 버튼(X)을 클릭하면 프로그램 종료
		Container c = getContentPane();
		
		c.setLayout(new BorderLayout()); //BorderLayout 배치관리자의 사용
		receiver = new Receiver(); // 클라이언트에서 받은 메시지를 출력할 컴퍼넌트
		receiver.setEditable(false); // 편집 불가

		sender = new JTextField();
		sender.addActionListener(this);

		add(new JScrollPane(receiver),BorderLayout.CENTER); // 스크롤바를 위해  ScrollPane 이용
		add(sender,BorderLayout.SOUTH);
		
		setSize(400, 200); // 폭 400 픽셀, 높이 200 픽셀의 크기로 프레임 크기 설정
		setVisible(true); // 프레임이 화면에 나타나도록 설정
		
		try {
			setupConnection();
		} catch (IOException e) {
			handleError(e.getMessage());
		}
		
		Thread th = new Thread(receiver); // 상대로부터 메시지 수신을 위한 스레드 생성
		th.start();
	}
	private void setupConnection() throws IOException {
		listener = new ServerSocket(9999); // 서버 소켓 생성
		socket = listener.accept(); // 클라이언트로부터 연결 요청 대기
		//System.out.println("연결됨");
		receiver.append("클라이언트로부터 연결 완료");
		int pos = receiver.getText().length();
		receiver.setCaretPosition(pos); // caret 포지션을 가장 마지막으로 이동
		
		in = new BufferedReader(new InputStreamReader(socket.getInputStream())); // 클라이언트로부터의 입력 스트림
		out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())); // 클라이언트로의 출력 스트림
	}

	private static void handleError(String string) {
		System.out.println(string);
		System.exit(1);
	}
	
	private class Receiver extends JTextArea implements Runnable {
		@Override
		public void run() {
			String msg = null;
			while (true) {
				try {
					msg = in.readLine(); // 상대로부터 한 행의 문자열 받기
				} catch (IOException e) {
					handleError(e.getMessage());
				} 
				this.append("\n" + msg); // 받은 문자열을 JTextArea에 출력
				int pos = this.getText().length();
				this.setCaretPosition(pos); // caret 포지션을 가장 마지막으로 이동
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) { // JTextField에 <Enter> 키 처리
		if (e.getSource() == sender) {
			String msg = sender.getText(); // 텍스트 필드에서 문자열 얻어옴
			try {
				out.write(nickName+" : "+msg+"\n"); // 문자열 전송
				out.flush();
				
				receiver.append("\n"+nickName+" : " + msg);// JTextArea에 출력
				int pos = receiver.getText().length();
				receiver.setCaretPosition(pos); // caret 포지션을 가장 마지막으로 이동
				sender.setText(null); // 입력창의 문자열 지움
			} catch (IOException e1) {
				handleError(e1.getMessage());
			} 
		}
	}
	
	public static void main(String[] args) {
		new ChatServer();
	}

}
