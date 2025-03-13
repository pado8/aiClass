package Test0313;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

class Book {
	String title;
	String name;
	String publisher;
	String price;
	Book(){}
	Book(String title, String name, String publisher, String price) {
		this.title = title;
		this.name = name;
		this.publisher = publisher;
		this.price = price;
	}
}

public class Test0313 {

	public static void main(String[] args) {
//		1. 책제목, 저자, 출판사, 가격을 
//		키보드 입력을 통해서 ArrayList에 저장하시오.
		List<String> bookList = new ArrayList<>();
		Scanner s = new Scanner(System.in);
		System.out.println("1번. 책제목, 저자, 출판사, 가격을 입력하세요.(Enter로 구분합니다.)");
		bookList.add(s.nextLine());
		bookList.add(s.nextLine());
		bookList.add(s.nextLine());
		bookList.add(s.nextLine());
//		for(String b : bookList) {
//			System.out.println(b);
//		}
//		2. 1번을 HashMap을 이용해서 저장하고 출력하시오.
//		key => 책제목, 저자, 출판사, 가격
		Map<String,String> bookHash = new HashMap<String,String>();
		bookHash.put("책제목", bookList.get(0));
		bookHash.put("저자", bookList.get(1));
		bookHash.put("출판사", bookList.get(2));
		bookHash.put("가격", bookList.get(3));
		Set<String> keySet = bookHash.keySet();
		System.out.println("2번. ");
		for(String k : keySet) {
			System.out.println(bookHash.get(k));
		}
//		3. 1번을 Book이라는 클래스를 만든 다음 
//		ArrayList에 Book객체를 넣어서 처리하기.
		ArrayList<Book> data=new ArrayList<Book>();
		System.out.println("3번. 책제목, 저자, 출판사, 가격을 입력하세요.(Enter로 구분합니다.)");
		data.add(new Book(s.nextLine(),s.nextLine(),s.nextLine(),s.nextLine()));
		for (Book b : data) {
			System.out.println("책제목 : " + b.title + ", 저자 : " + b.name + ", 출판사 : " + b.publisher + ", 가격 : " + b.price);
		}
//		4. HashMap에 ArrayList<Book>을 넣어서 처리하기.
//		HashMap의 key는 "철학", "언어", "컴퓨터공학"
		Map<String,Book> books = new HashMap<String,Book>();
		books.put("철학", new Book(s.nextLine(),s.nextLine(),s.nextLine(),s.nextLine()));
		books.put("언어", new Book(s.nextLine(),s.nextLine(),s.nextLine(),s.nextLine()));
		books.put("컴퓨터공학", new Book(s.nextLine(),s.nextLine(),s.nextLine(),s.nextLine()));
		//books.put("철학", new Book("철학에 대하여","김철학","아이언메이스","85억원"));
		//books.put("언어", new Book("0개국어","최언어","바디랭기지","65564원"));
		//books.put("컴퓨터공학", new Book("컴퓨터수리의 모든 것","마수리","매직키드","5090원"));
		Set<String> keySet2 = books.keySet();
		System.out.println("4번.");
		for (String k : keySet2) {
			Book s1 = books.get(k);
			System.out.println("책제목 : " + s1.title + ", 저자 : " + s1.name + ", 출판사 : " + s1.publisher + ", 가격 : " + s1.price);
		}
	}
}
