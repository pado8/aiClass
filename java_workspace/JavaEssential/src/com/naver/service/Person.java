package com.naver.service;

public class Person {
	public String name; // field
	// method
	public void sleep() {
		System.out.println("잠을 잡니다.");
	}
	
	// 생성자오버로딩
	public Person() {}; // 기본생성자
	public Person(String name) {
		this.name = name; // name 초기화
	}
}
