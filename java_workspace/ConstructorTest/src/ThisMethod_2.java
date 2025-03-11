class A {
	int m1, m2, m3, m4;
	//기본값
	A(){
		this.m1 = 1;
		this.m2 = 2;
		this.m3 = 3;
		this.m4 = 4;
	}
	//생성자오버로딩
	A(int a) {
		this(); //기본값을 세팅
		this.m1 = a; //m1만 변경
	}
	//생성자오버로딩
	A(int a, int b){
		this(a);
		m2=b; //m2만 변경
	}
	void print() {
		System.out.print(m1 + " ");
		System.out.print(m2 + " ");
		System.out.print(m3 + " ");
		System.out.print(m4);
		System.out.println();
	}
}

public class ThisMethod_2 {

	public static void main(String[] args) {
		A a = new A();
		System.out.println(a.m1);
		
		A a1 = new A();
		A a2 = new A(10);
		A a3 = new A(10, 20);
		a1.print();
		a2.print();
		a3.print();
	}

}
