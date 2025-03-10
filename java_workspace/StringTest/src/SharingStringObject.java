
public class SharingStringObject {

	public static void main(String[] args) {
		String str1= new String("안녕");
		String str2= "안녕";
		String str3= "안녕"; //str2의 문자열과 같으므로 다시 생성하지 않음. 같은 데이터 공유
		String str4= new String("안녕"); //문자열이 같아도 다시 생서함. 별개의 메모리.
//		String 변수안에 저장된  reference 값을 비교
//		String 변수가 가리키는 실제 값이 같은지 비교할 때는 equals() 사용
		System.out.println(str1==str2);
		System.out.println(str2==str3);
		System.out.println(str3==str4);
		System.out.println(str4==str1);
		
		str2 = "안녕하세요";
		System.out.println(str2);   // 안녕하세요로 변경
		System.out.println(str3);   // 기존 "안녕"을 가리키는 값 유지
	}

}
