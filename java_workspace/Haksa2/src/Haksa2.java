import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Haksa2 extends JFrame {
	
    JMenuBar mb = null;
    JMenu studentMenu = null;
    JMenuItem studentInfoMenuItem = null;

    public Haksa2() {
        this.setTitle("학사관리");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 메뉴바, 메뉴, 메뉴 아이템 생성 시 텍스트를 지정해줍니다.
        this.mb = new JMenuBar();
        this.studentMenu = new JMenu("학사관리");       // 메뉴 이름 설정
        this.studentInfoMenuItem = new JMenuItem("학생정보"); // 메뉴 아이템 이름 설정

        // 메뉴에 메뉴 아이템 추가
        this.studentMenu.add(this.studentInfoMenuItem);
        // 메뉴바에 메뉴 추가
        this.mb.add(this.studentMenu);
        // JFrame에 메뉴바 설정
        this.setJMenuBar(this.mb);

        // 크기 및 표시
        this.setSize(300, 500);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Haksa2();
    }
}
