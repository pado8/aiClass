class A{}
class B extends A {}
public class Typecasting_3 {

	public static void main(String[] args) {
		A aa = new A();
		A ab = new B(); // upcasting. 자동으로 변환
		
		System.out.println(aa instanceof A);
		System.out.println(ab instanceof A);
		System.out.println(aa instanceof B);
		System.out.println(ab instanceof B);
		
		
		B bb = (B) new A(); // downcasting. 강제로 변환
		
		
		
		
		if(aa instanceof B) {
			B b = (B) aa;
			System.out.println("aa를  B로 캐스팅했습니다.");
		} else {
			System.out.println("aa를 B 타입으로 캐스팅이 불가능!!!");
		}
		if(ab instanceof B) {
			B b = (B) ab;
			System.out.println("ab를  B로 캐스팅했습니다.");
		} else {
			System.out.println("ab를 B 타입으로 캐스팅이 불가능!!!");
		}
		if ("안녕" instanceof String) {
			//System.out.println("|"안녕|"은String 클래스입니다.);
		}
		
	}

}
