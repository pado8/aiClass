import java.util.Scanner;

class Student {
	Scanner s = new Scanner(System.in);
	String no = s.nextLine();
	String name = s.nextLine();
	String department = s.nextLine();
	void showinfo() {
		System.out.println("학번 : " + no + " 이름 : " + name + " 학과 : " + department);
	}
}


public class Test0310 {

	public static void main(String[] args) {
//		1. 주민등록번호(010101-123456)에서 생년월일을 추출하시오
		String rrn = "010101-940507";
		int hyphen = rrn.indexOf("-");
		System.out.println("1번 생년월일 : " + rrn.substring(hyphen+1));
//		2. 전화번호(010-1234-5678)에서 '-'을 제거하시오.
//		=>01012345678 로 변경하기.
		String phoneNum = "010-1234-5678";
		String[] result2 = phoneNum.split("-");
		System.out.print("2번 전화번호 : ");
		for (String word : result2) {
		    System.out.print(word);
		}
		System.out.println();
//		3. 상품코드(E20160001)에서 상품카테고리('E')를 추출하시오.
		String productCode = "E20160001";
		System.out.println("3번 상품카테고리 : " + productCode.substring(0, 1));
//		4. 상품코드(E20160001)에서 년도('2016')를 추출하시오.
		System.out.print("4번 년도 : " + productCode.substring(1, 5));
		System.out.println();
//		5. 주소록 csv데이터에서 데이터를 분리하시오.
//		홍길동,010-1111-2222,hkd@hkd.com
		String personalInformation = "홍길동,010-1111-2222,hkd@hkd.com";
		String[] result5 =personalInformation.split(",");
		System.out.println("5번 ");
		for (String word : result5) {
		    System.out.println(word);
		}
//		6. csv데이터에 다음과 같은 학번이 저장되어 있을 때.
//		EL201800001,CH201800021,EN12231
//		EL-전자공학과
//		CH-화학공학과
//		EN-영어영문학과
//		각 학번의 학과명을 출력하시오.
		String studentNumber = "EL201800001,CH201800021,EN12231";
		String[] result6 =studentNumber.split(",");
		System.out.println("6번 ");
		for (String word : result6) {
		    if(word.substring(0, 2).equals("EL")) {
		    	System.out.println("전자공학과");
		    }
		    if(word.substring(0, 2).equals("CH")) {
		    	System.out.println("화학공학과");
		    }
		    if(word.substring(0, 2).equals("EN")) {
		    	System.out.println("영어영문학과");
		    }
		}
//		------------------------------------------------------------------------------------
//		이하문제는 scanner를 사용하세요~
		Scanner s = new Scanner(System.in);
//		7. 아이디에 !,@,#,$,%,^가 포함된 경우
//		'아이디에 !,@,#,$,%,^가 포함되면 안됩니다.' 출력하기.
		System.out.println("7번 id를 입력하세요.(아이디에 !,@,#,$,%,^가 포함되면 안됩니다.)");
		String id = s.nextLine();
		String[] result7 = id.split("");
		for (String word : result7) {
			if(word.equals("!")) {
			    System.out.println("아이디에 !,@,#,$,%,^가 포함되면 안됩니다.");
			}
			if(word.equals("@")) {
			    System.out.println("아이디에 !,@,#,$,%,^가 포함되면 안됩니다.");
			}
			if(word.equals("#")) {
			    System.out.println("아이디에 !,@,#,$,%,^가 포함되면 안됩니다.");
			}
			if(word.equals("$")) {
			    System.out.println("아이디에 !,@,#,$,%,^가 포함되면 안됩니다.");
			}
			if(word.equals("%")) {
			    System.out.println("아이디에 !,@,#,$,%,^가 포함되면 안됩니다.");
			}
			if(word.equals("^")) {
			    System.out.println("아이디에 !,@,#,$,%,^가 포함되면 안됩니다.");
			}
		}
//		8. 학번,이름,학과를 입력받아 배열에 넣고 출력해보세요
		System.out.println("8번 학번,이름,학과를 입력하세요.");
		String studentInformation = s.nextLine();
		String[] result8 = studentInformation.split(",");
		for (String word : result8) {
			System.out.println(word);
		}
//		9. Student클래스를 만들고 instance를 생성해서 정보를 출력해보세요.
//		filed - no, name, department => 키보드로 입력받아서 저장
//		method - showinfo() => 출력
		System.out.println("9번 학번,이름,학과를 입력하세요.(엔터로 구분)");
		Student student = new Student();
		student.showinfo();
		s.close();
	}

}
