import java.util.ArrayList;
import java.util.List;

public class ArrayListTest {
	public static void main(String[] args) {
		List<String> aList = new ArrayList<>(); //upcasting
		System.out.println(aList.size()); // arrayList의 요소의 갯수
		aList.add("가");
		aList.add("나");
		aList.add("다");
		aList.add("라");
		aList.add("마");
		aList.add("바");
		aList.add("사");
		System.out.println(aList.size()); // arrayList의 요소의 갯수
		
		aList.remove("다");
		aList.remove("바");
		
		System.out.println(aList.size()); // arrayList의 요소의 갯수
		
		System.out.println(aList.get(0)); // 배열의 요소 읽기
		
		for(String s : aList) {
			System.out.println(s);
		}
		
		aList.set(0, "A"); // 0번 index의 값을 A로 변경
		
		for(String s : aList) {
			System.out.println(s);
		}
		
		aList.clear(); //모든 요소 삭제
		
		for(String s : aList) {
			System.out.println(s);
		}
		
		System.out.println(aList.isEmpty());
		
	}
}
