import java.util.Scanner;

public class Test0307 {

	public static void main(String[] args) {
//		1. scanner를 사용해서 학번,이름,학과를 입력 받아서 출력해보세요.
//	    무한반복하다가 exit를 입력하면 종료하게 하세요.
		Scanner s = new Scanner(System.in);
		for(;;) {
		    System.out.println("학번 이름 학과를 입력하세요.(중지하고싶으면 exit를 입력하세요.)");
		    String text = s.nextLine();
		    if(text.equals("exit")) {
		    	System.out.println("종료되었습니다.");
		    	break;
		    }
			s.close();
		}	
//	2.다음 모양을 for문 안에 for문을  하나만 사용해서 구현해보세요. if문은 사용 가능		
		for (int i = 1; i < 6; i++) {
			int space = i + 4;
			for (int j = 0; j <= space; j++) {
				if (j <= (5 - i)) {
					System.out.print(" ");
				} else {
					System.out.print("*");
				}
			}
			System.out.println("");
		}
//	3.
		for (int i = 0; i < 10; i++) {
			int count = 0;
			if (i < 5) {
				count = i;
			} else {
				count = 10 - i;
			}
			for (int j = 0; j < count; j++) {
//				System.out.print("i = "+ i +" j = "+ j +" c = "+ count + "\n");
				System.out.print("*");
			}
			System.out.println("");
		}
	}

}
