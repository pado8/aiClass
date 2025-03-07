import java.util.Iterator;
import java.util.Scanner;

public class LoopTest {

	public static void main(String[] args) {
//		for (int i = 1; i <= 10; i++) {
//			System.out.println(i);
//		}
//		for (int i = 10; i >= 1; i--) {
//			System.out.println(i);
//		}
//		
//		
//		int j=0;
//		while(j<=10) {
//			System.out.println(j);
//			j++;
//		}
//		
//		int k=0;
//		do {
//			System.out.println(k);
//			k++;
//		}while(k<=10);
//		
		
		
		
		
		
		
	// 무한루프
	//for(;;) {
	//    System.out.println("점심시간입니다.");
	//}

//	Scanner s = new Scanner(System.in);
//	for(;;) {
//	    System.out.print("정수를 입력하세요.중지는 - 1 : ");
//	    
//	    while(!s.hasNextInt() ) {  //정수면 true 아니면 false
//	    	System.out.println("정수를 올바르게 다시 입력해주세요!!!");
//	    	s.nextLine(); //방금 잘못 입력한 값을 문자열로 받아들여서 소멸.
//	    	
//	    	System.out.print("정수를 입력하세요.중지는 - 1 : ");
//	    }
//	    
//	    int number = s.nextInt();
//	    //-1이 탈출조건
//	    if(number == -1) {
//	    	System.out.println("종료되었습니다.");
//	    	break;
//	    }
//	    System.out.println(number);
//	}

//		for(int dan=2;dan<=9;dan++) {
//			for(int number=1;number<=9;number++) {
//				System.out.println(dan+"x"+number+"="+dan*number);
//			}
//		}
//		
//		for(int number = 1; number <= 9; number++) {
//		    for(int dan = 2; dan <= 9; dan++) {
//		        System.out.print(dan + "x" + number + "=" + (dan * number) + "\t");
//		    }
//		    System.out.println("\n"); // 한 줄 개행
//		}

		
//		무한 루프대신 do while 사용
		
//		Scanner s2=new Scanner(System.in);
//		int number;
//		do {
//			System.out.println
//			number = s2.nextInt();
//		}while(number != -1);
		
		
//		
//		
//		out: //label
//			for(int i = 0; i < 10; i++) {
//				for(int j = 0; j < 10; j++) {
//					if(j == 3) {
//						break out;
//					}
//					System.out.println(i+","+j);
//				}
//			}
//		System.out.println("끝");
//		
//		boolean flag = false; 
//			for(int i = 0; i < 10; i++) {
//				for(int j = 0; j < 10; j++) {
//					if(j == 3) {
//						flag=true;
//						break;
//					}
//					System.out.println(i+","+j);
//				}
//				if(flag) {
//					break;
//				}
//			}
//		System.out.println("끝");
		
		int z = 0;
		while(z <= 10) {
			z++;
			if(z%2 == 1) {
				continue;
			}
			System.out.println(z);
			
		}
		System.out.println("End");
		
	}
}
