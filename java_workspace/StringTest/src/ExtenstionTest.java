import java.util.Scanner;

public class ExtenstionTest {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("파일명 : ");
		String fileName = s.nextLine(); // 공백 포함 한줄 전체 읽어들임
		System.out.println(fileName.lastIndexOf("."));
		int positionOfDot = fileName.lastIndexOf(".");
		System.out.println(fileName.substring(positionOfDot+1));
		
		String[] result = fileName.split("\\.");  // '.'를 정규 표현식에서 사용하므로 '\\.'로 이스케이프
		for (String word : result) {
		    System.out.println(word);
		}
		System.out.println(result[result.length - 1]); // 배열의 마지막 요소 출력

		
	}
}
