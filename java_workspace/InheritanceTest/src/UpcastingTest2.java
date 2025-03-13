/**************************************************
 *  upcasting을 활용하는 예
 **************************************************/

interface Shape{
	public void draw();
}

class Line implements Shape {
	@Override
	public void draw() {
		System.out.println("Line");
	}
}

class Reactangle implements Shape {
	@Override
	public void draw() {
		System.out.println("Reactangle");
	}
}

public class UpcastingTest2 {
	
	public static void main(String[] args) {
		//paint(new Shape()); //interface 자신의 instance 생성 불가
		//upcasting 활용. 자식클래스를 계속 추가해도 코드의 변경을 줄일 수 있음.
		
		Shape line = new Line();
		line.draw();
		Shape rectangle = new Reactangle();
		rectangle.draw();
	}

}
