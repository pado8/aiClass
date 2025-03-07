import java.util.Scanner;

public class SwitchTest {

	public static void main(String[] args) {
		int value1 = 2;
		switch(value1) { // value1은 char or int or String 가능
		    case 1:
		        System.out.println("A");
		        break;
		    case 2:
		        System.out.println("B");
		        break;
		    case 3:
		        System.out.println("C");
		        break;
	        default:
	        	System.out.println("D");
		}

		int score = 77;
		switch(score / 10) {
		    case 10:
		    case 9:
		        System.out.println("A");
		        break;
		    case 8:
		        System.out.println("B");
		        break;
		    case 7:
		        System.out.println("C");
		        break;
		    case 6:
		        System.out.println("D");
		        break;
		    default:
		        System.out.println("F");
		}

		Scanner s = new Scanner(System.in);
		System.out.print("점수를 입력하세요 : ");
		int score2 = s.nextInt(); //정수를 받아서 변수에 저장
		switch(score2 / 10) {
	    case 10:
	    case 9:
	        System.out.println("A");
	        break;
	    case 8:
	        System.out.println("B");
	        break;
	    case 7:
	        System.out.println("C");
	        break;
	    case 6:
	        System.out.println("D");
	        break;
	    default:
	        System.out.println("F");
	}
	}

}
