package Test0312;

import java.util.Scanner;

class AddressBook {
	String no;
	String name;
	String number;
	String email;
}

class Mouse {
	String button;
	void mouseMove() {
		System.out.println("마우스가 움직입니다.");
	}
}

class OpticalMouse extends Mouse {
	String Led;
	void opticalMove() {
		System.out.println("마우스가 LED를 이용하여 빠르게 움직입니다.");
	}
}
class WirelessMouse extends Mouse {
	String bluetooth;
	void bluetoothMove() {
		System.out.println("마우스가 선이 없이 움직일 수 있습니다.");
	}
}
class VerticalMouse extends Mouse {
	String ergonomics;
	void verticalMove() {
		System.out.println("인체공학적으로 만들어 손목에 무리 없이 마우스를 움직일 수 있습니다.");
	}
}
class PenMouse extends Mouse {
	String pen;
	void drawMove() {
		System.out.println("펜으로 그리듯이 마우스를 움직일 수 있습니다.");
	}
}
class TrackballMouse extends Mouse {
	String ball;
	void roillgMove() {
		System.out.println("볼을 움직여 마우스를 움직일 수 있습니다.");
	}
}

public class Test0312 {

	public static void main(String[] args) {
		//1번 
		Scanner s = new Scanner(System.in);
		
		AddressBook a = new AddressBook();
		AddressBook[] array = new AddressBook[15];
		System.out.println("15명의 번호, 이름, 전화번호,이메일 기입하세요.");
		for(AddressBook arr : array) {
			arr = new AddressBook();
			a.no = s.nextLine();
			a.name = s.nextLine();
			a.number = s.nextLine();
			a.email = s.nextLine();
			System.out.println("번호 : " + a.no);
			System.out.println("이름 : " + a.name);
			System.out.println("전화번호 : " + a.number);
			System.out.println("이메일 : " + a.email);
		}
		System.out.println("모두 입력 완료했습니다.");
		s.close();
		//2번 
		
		Mouse m = new Mouse();
		OpticalMouse Optical = new OpticalMouse();
		WirelessMouse Wireless = new WirelessMouse();
		VerticalMouse Vertical = new VerticalMouse();
		PenMouse Pen = new PenMouse();
		TrackballMouse Trackball = new TrackballMouse();
		
		m.mouseMove();
		Optical.opticalMove();
		Wireless.bluetoothMove();
		Vertical.verticalMove();
		Pen.drawMove();
		Trackball.roillgMove();
	}

}
