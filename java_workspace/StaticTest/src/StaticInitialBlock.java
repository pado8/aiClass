class A{
	int a;
	static int b = 10; // static은 공유 메모리. 하나만들어서 같이 사용
	A(){
		a = 3;
	}
}


public class StaticInitialBlock {

	public static void main(String[] args) {
		// 이게 실제로 더 많이 사용하는 기법
		System.out.println(A.b); //클래스명.필드명 형식으로 사용가능
		
		A a = new A();
		System.out.println(a.b);
		
		A.b = 20;
		System.out.println(A.b);
		System.out.println(a.b);
	}

}
