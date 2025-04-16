package com.naver.service;

public class Student2 implements Person3{
	public String name;
	public String department;
	
	// interface를 상속받은 자식 클래스는 반드시 추상메서드를 overriding 해야 함.
	@Override
	public void sleep() {
		System.out.println("하루에 2시간 잡니다.");
	}
	
}
