abstract class A {
	abstract void abc(); // 추상메서드
}
class B extends A {
	@Override
	void abc() {
		System.out.println("부모의 abc() 오버라이딩");
	}
	
}

public class AbstractClass_1 {

	public static void main(String[] args) {
		//A a = new A();//A로 인스턴스 생성 불가 A가 추상클래스라서
		A b1 = new B(); //upcasting
		b1.abc();
	}

}
