import java.util.HashSet;
import java.util.Set;

public class SetTest {

	public static void main(String[] args) {
		Set<String> hSet1 = new HashSet<>();
		hSet1.add("가");
		hSet1.add("나");
		hSet1.add("가");// 중복데이터는 입력되지 않음
		for(String s : hSet1) {
			System.out.println(s);
		}
		hSet1.add("다");
		for(String s : hSet1) {
			System.out.println(s); //입력된 순서대로 출력되지 않음
		}
		
		//set은 순서보다 종류가 한 개로 유지 하는게 중요
	}

}
