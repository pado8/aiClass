
public class MethodOverloading {

	public static void main(String[] args) {
		
	}
	//method overloading. parameter 갯수가 다르거나, 타입이 다르면 성립.
	public static void print() {
		System.out.println("데이터가 없습니다.");
	}
	public static void print(int a) {
		System.out.println(a);
	}
	public static void print(double a) {
		System.out.println(a);
	}
	public static void print(int a, int b) {
		System.out.println("a : "+a+"");
	}
}
