

public class ClassTest3 {

	public static void main(String[] args) {
		// b는 reference변수. b가 가리키는 곳에 Book클래스의 instance가 있음
		// 2. instance생성
		Book b=new Book(); //instance생성
		// 3. instance명.멤버명 형식으로 사용
		b.author="홍길동";
		b.title="홍길동전";
		b.price=10000;
		b.showInfo();
		
		Book b2=new Book();
		b2.showInfo();
		
		Book b3=new Book("java의 기초","이순신",15000);
		b3.showInfo();
		
		Book b4=new Book("객체지향");
		b4.showInfo();
	}

}
