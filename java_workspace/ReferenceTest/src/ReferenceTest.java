class A{
	int m = 3; //멤버변수.  field
	//멤버변수. method
	void print() {
		System.out.println("객체 생성 및 활용");
	}
}

public class ReferenceTest {

	public static void main(String[] args) {
		int[] a= {1,2,3};
		int[] b;
		b=a;
		
		for(int j : a) {
			System.out.println(j);
		}
		for(int k : b) {
			System.out.println(k);
		}
		
		a[0]=100;
		for(int l : a) {
			System.out.println(l);
		}
		for(int m : b) {
			System.out.println(m);
		}
		
		
		String str1=new String("안녕");
		String str2=str1;
		System.out.println(str1);
		System.out.println(str2);
		
		str2="감사"; //"감사"를 새로 만들고 str2가 "감사"를 가리킴
		System.out.println(str1);
		System.out.println(str2);
		
		A a1 = new A();
		A a2;
		a2 = a1;
		System.out.println(a1.m);
		System.out.println(a2.m);
		a1.print();
		a2.print();
		
		a1.m = 100;
		System.out.println(a1.m);
		System.out.println(a2.m); //a2는 레퍼런스를 가져왔으니 인스턴스는 그대로라 100으로 나옴
	}

}
