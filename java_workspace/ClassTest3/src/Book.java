
// 1. 클래스생성
public class Book {
	String title;
	String author;
	int price;
	
	Book(){
		this.title="미정";
		this.author="미정";
		this.price=0;
	}
//	Book(){}
	
	//생성자오버로딩
	Book(String title){
		this(); // Book()호출 기본값 세팅
		this.title=title; // 제목만 변경		
	}
	
	//생성자오버로딩
	Book(String title, String author, int price){
		this(title); // Book(String title)호출. 제목변경
		this.author=author; // 작성자변경
		this.price=price;   // 가격변경
	}
	
	void showInfo() {
//		System.out.println(title+","+author+","+price);
		System.out.println(this.title+","+this.author+","+this.price);
	}
}
