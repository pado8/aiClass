package Test0311;

import java.util.Scanner;

class Circle {
	void circle(int r) {
		int result3 = (int) (r*r*3.14);
		System.out.print("3번 :" + result3);
	}
}

class Student {
	String name;
	String korean;
	String english;
	String math;
	
	void print(String name, String korean, String english, String math) {
        int numKorean = Integer.parseInt(korean);
        int numEnglish = Integer.parseInt(english);
        int numMath = Integer.parseInt(math);
		       
        
		System.out.print("4번 : 이름 : " + name +" / 평균 : "+ (numKorean+numEnglish+numMath)/3);
	}
}


public class Test0311 {

	public static void main(String[] args) {
//		1. 원의 면적을 구하는 프로그램을 작성하시오.
//		   반지름은 10
		int r = 10;
		int result = (int) (r*r*3.14);
		System.out.print("1번 :" + result);
		System.out.println();
//		2. 1번을 함수를 만들어서 구현하시오.
		circle(10);
		System.out.println();
//		3. 2번을 클래스로 만들어서 구현하시오.
//		Circle Class를 만들어서 구현해보세요.
		Circle a = new Circle();
		a.circle(10);
		System.out.println();
//		4. 학생의 이름, 국어,영어,수학 을 키보드 입력을 받아서
//		평균을 출력하기.
//		=> Student Class를 만들어서 구현해보세요
		Scanner s = new Scanner(System.in);
		Student b = new Student();
		System.out.println("이름, 국어점수, 영어점수, 수학점수를 입력하세요.(enter로 구분하고 중지하고싶으면 quit를 입력하세요)");
//		번외. 무한반복하다가 quit을 입력하면 프로그램이 종료되게 하기.
		while(true){
			b.name = s.nextLine();
			if(b.name.equals("quit")){
				System.out.println("번외 : 종료되었습니다.");
				break;
			}
			b.korean = s.nextLine();
			if(b.korean.equals("quit")){
				System.out.println("번외 : 종료되었습니다.");
				break;
			}
			b.english = s.nextLine();
			if(b.english.equals("quit")){
				System.out.println("번외 : 종료되었습니다.");
				break;
			}
			b.math = s.nextLine();
			if(b.math.equals("quit")){
				System.out.println("번외 : 종료되었습니다.");
				break;
			}
			b.print(b.name, b.korean, b.english, b.math);
			System.out.println();
		}
		s.close();
	}
	
	public static void circle(int r) {
		int result2 = (int) (r*r*3.14);
		System.out.print("2번 :" + result2);
	}
}
