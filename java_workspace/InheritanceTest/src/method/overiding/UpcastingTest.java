package method.overiding;

/**************************************************
 *  upcasting을 활용하는 예
 **************************************************/

class Shape{
	public void draw() {
		System.out.println("Shape");
	}
}

class Line extends Shape {
	@Override
	public void draw() {
		System.out.println("Line");
	}
}

class Reactangle extends Shape {
	@Override
	public void draw() {
		System.out.println("Reactangle");
	}
}

public class UpcastingTest {
	//paint() 메서드에서 draw() 메서드를 호출	=> upcasting 활용
	//parameter의 타입을 Shape으로 설정함으로써 upcasting을 활용하여 모든 자식 객체의 draw() 호출 가능
	//자식 클래스가 새로 추가되어도 paint()는 변경 없이 사용 가능 → 확장성 높음
	static void paint(Shape p) {
		p.draw();
	}
	
	public static void main(String[] args) {
		Line line = new Line();
		paint(line);  //upcasting. Line to Shape
		paint(new Reactangle()); //upcasting. Reactangle to Shape
		paint(new Shape());
	}

}
