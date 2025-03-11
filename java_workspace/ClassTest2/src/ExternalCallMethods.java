
class A1 {
	void print() {
		System.out.println("안녕");
	}
	
	int data() {
		return 3;
	}
	double sum(int a, double b) {
		return a + b;
	}
	void printMonth(int m) {
		if(m < 0 || m > 12) {
			System.out.println("잘못된 입력");
			return;
		}
		System.out.println(m + "월입니다.");
	}
}


public class ExternalCallMethods {

	public static void main(String[] args) {
		// A클래스를 사용해서 instance 생성
		A1 a = new A1();// a는 reference 변수. 참조값을 통해 A의 인스턴스를 찾을 수 있음
		a.print();
		int k = a.data();
		a.data();
		System.out.println(k);
		double result = a.sum(3, 5.2);
		System.out.println(result);
		a.printMonth(5);
		a.printMonth(15);
		
		 A a1; // a1은 reference 변수. A의 인스턴스를 가리킬 대상이나 아직 reference값이 없음
	}

}
