import java.util.ArrayList;

class Stack {

	private ArrayList<String> arrayStack = new ArrayList<String>();
	public void push(String data) {
		arrayStack.add(data);
	}
    
	public String pop() {
		if(arrayStack.size()==0) {
			System.out.println("데이터가 존재 하지 않습니다.");
			return null;
		}
		return arrayStack.remove(arrayStack.size()-1);
	}
}
public class StackTest {

	public static void main(String[] args) {
		Stack stack = new Stack();
		stack.push("A");
		stack.push("B");
		stack.push("C");
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
	}

}