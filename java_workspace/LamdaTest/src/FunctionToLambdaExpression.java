interface A {  // 입력X, 출력X
    void method1();
}

interface B {  // 입력O, 출력X
    void method2(int a);
}

interface C {  // 입력X, 출력O
    int method3();
}

interface D {  // 입력O, 출력O
    double method4(int a, double b);
}

class AChild implements A{

	@Override
	public void method1() {
		System.out.println("method1()오버라이딩");
	}
	
}

public class FunctionToLambdaExpression {

	public static void main(String[] args) {
		// #1. 입력X, 출력X의 함수
		A aa = new AChild();
		aa.method1();
		
		//Anonymous Class
		// 01-1. 익명 이너 클래스 표현
		A a1 = new A() {
		    @Override
		    public void method1() {
		    	System.out.println("method1()오버라이딩");
		    }
		};
		a1.method1();
		// 01-2. 람다식 표현
		A a2 = () -> { System.out.println("입력X, 출력X의 함수"); };
		A a3 = () -> System.out.println("입력X, 출력X의 함수");
		
		a2.method1();
		a3.method1();

		// #2. 입력O, 출력X의 함수

		// 02-1. 익명 이너 클래스 표현
		B b1 = new B() {
		    public void method2(int a) {
		        System.out.println(a);
		    }
		};

		// 02-2. 람다식 표현
		B b2 = (int a) -> { System.out.println(a); };
		B b3 = (a) -> { System.out.println(a); };
		B b4 = (a) -> System.out.println(a);
		B b5 = a -> System.out.println(a);

	}

}
