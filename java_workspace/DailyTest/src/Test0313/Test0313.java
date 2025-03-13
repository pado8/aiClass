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
			System.out.println("3번. 책제목 : " + b.title + ", 저자 : " + b.name + ", 출판사 : " + b.publisher + ", 가격 : " + b.price);
		}
//		4. HashMap에 ArrayList<Book>을 넣어서 처리하기.
//		HashMap의 key는 "철학", "언어", "컴퓨터공학"
//		
		Map<String, ArrayList<Book>> books = new HashMap<>();
		books.put("철학", new ArrayList<Book>());
		books.put("언어", new ArrayList<Book>());
		books.put("컴퓨터공학", new ArrayList<Book>());
		
		System.out.println("4번. 책의 카테고리(철학, 언어, 컴퓨터공학), 책제목, 저자, 출판사, 가격을 입력하세요.");
        for (int i = 0; i < 3; i++) {
            System.out.println("책의 카테고리를 입력하세요:");
            String category = s.nextLine();
            if (!books.containsKey(category)) {
                System.out.println("잘못된 카테고리입니다. (철학, 언어, 컴퓨터공학 중 하나를 입력하세요.)");
                i--;
                continue;
            }
            System.out.println("책제목을 입력하세요:");
            String title = s.nextLine();
            System.out.println("저자를 입력하세요:");
            String name = s.nextLine();
            System.out.println("출판사를 입력하세요:");
            String publisher = s.nextLine();
            System.out.println("가격을 입력하세요:");
            String price = s.nextLine();
            
            Book book = new Book(title, name, publisher, price);
            books.get(category).add(book);
        }
        for (String cat : books.keySet()) {
            System.out.println("카테고리: " + cat);
            for (Book b : books.get(cat)) {
                System.out.println("책제목: " + b.title + ", 저자: " + b.name + ", 출판사: " + b.publisher + ", 가격: " + b.price);
            }
        }
		
	}
}
