import java.util.Stack;

public class StackTest {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		for (int a : stack) {
			System.out.println(a);
		}
		System.out.println(stack.pop()); //마지막 요소를 꺼냄
		for (int a : stack) {
			System.out.println(a);
		}
	}

}
