import java.util.Scanner;

public class TryCatchFinally {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		try {
			System.out.print("분자 : ");
			int num1 = s.nextInt();
			System.out.print("분모 : ");
			int num2 = s.nextInt();
			System.out.println(num1/num2);
		} catch (Exception e) {
			//System.out.println(e.getMessage());
			e.printStackTrace();
			//System.out.println("에러 발생 관리자에게 문의 해주세요.");
		}finally {
			s.close();
		}
		
		System.out.println("이부분이 실행될까요?");
	}

}
