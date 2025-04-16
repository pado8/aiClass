package com.naver.service;

public class Student extends Person {
	public String department;
	void study() {
		System.out.println("공부합니다.");
	}
	//오버라이딩
	@Override
	public void sleep() {
		System.out.println("하루에 4시간 잡니다.");
	}
	
	//생성자 오버로딩
	public Student() {}; //기본 생성자
	public Student(String name, String department) {
		//this.name = name; 부모에 이미 초기화를 한게 있으니 이것보다
		super(name); // 부모의 생성자를 호출해서 name을 초기화 권장
		this.department = department;
	};
}
