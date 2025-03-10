class A{
	int m = 3; //멤버변수.  field
	//멤버변수. method
	void print() {
		System.out.println("객체 생성 및 활용");
	}
}

public class CreateObjectAndUsageOfMembers {

	public static void main(String[] args) {
		// a는 레퍼런스변수인데 a가 가리키는 곳에는 A타입의 인스턴스가 존재.
		A a = new A();
		System.out.println(a.m); // a의 m
		a.m = 5;
		System.out.println(a.m);
		a.print(); // a의 print() 호출
	}

}
