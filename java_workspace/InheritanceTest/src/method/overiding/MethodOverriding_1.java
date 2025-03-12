package method.overiding;

class A {
	void print() {
		System.out.println("A 클래스");
	}
}
class B extends A {
	@Override
	void print() {
		System.out.println("B 클래스");
	}
}

class Animal {
	void cry() {}
}
class Bird extends Animal{
	@Override
	void cry() {
		System.out.println("짹짹");
	}
}
class Cat extends Animal{
	@Override
	void cry() {
		System.out.println("야옹");
	}
}
class Dog extends Animal{
	@Override
	void cry() {
		System.out.println("멍멍");
	}
}

public class MethodOverriding_1 {

	public static void main(String[] args) {
		A aa = new A();
		aa.print();
		
		B bb = new B();
		bb.print();
		A ab = new B();
		ab.print();
		
		// upcasting 시 override된 메서드를 호출하면
		// 자식 클래스가 override한 메서드가 호출됨
		
		
		// 클래스의 배열
		Animal[] animals2 = new Animal[3];
		animals2[0] = new Bird();
		animals2[1] = new Cat();
		animals2[2] = new Dog();
		for(Animal animal : animals2) {
			animal.cry();
		}
		
//		Animal[] animals=new Animal[3];
//		animals[0]=new Bird();
//		animals[1]=new Cat();
//		animals[2]=new Dog();
		
		//간단하게 한줄로
		Animal[] animals = new Animal[] {new Bird(), new Cat(), new Dog()};
		for(Animal animal : animals) {
			animal.cry();
		}
		
	}

}
