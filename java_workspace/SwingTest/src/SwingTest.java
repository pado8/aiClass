import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

class MyFrame extends JFrame {
	MyFrame(){
		setTitle("채팅");
		
		setLayout(new FlowLayout());//레이아웃 flowlayout 으로 설정
		
		//버튼생성
		JButton btn1 = new JButton("send");
		//이벤트처리
		btn1.addActionListener(new ActionListener() {
			//버튼을 클릭하면 action 이벤트가 발생하고  actionlistster 에 의해서 엑션퍼포먼스 ㅎ
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("클릭");
				
			}
			
		});
		
		add(btn1);
		
		
		setSize(500, 500);
		setVisible(true);
	}
}


public class SwingTest {

	public static void main(String[] args) {
		new MyFrame(); 
	}

}
