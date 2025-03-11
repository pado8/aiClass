package com.naver.ex01;

import abc.A;
import abc.B;
import def.C;
import def.D;

public class AccessModifierOfMomber {

	public static void main(String[] args) {
		A a = new A();
		B b = new B();
		C c = new C();
		D d = new D();
		
		a.print();
		b.print();
		c.print();
		d.print();
	}

}
