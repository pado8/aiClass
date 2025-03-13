import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {

	public static void main(String[] args) {
		Queue<Integer> queue2 = new LinkedList<Integer>(); //upcasting
		//enqueue 넣는거
		queue2.offer(3);
		queue2.offer(4);
		queue2.offer(5);
		for (int v : queue2) {
			System.out.println(v);
		}
		// dequeue
		queue2.poll();
		queue2.poll();
		queue2.poll();
		for (int v : queue2) {
			System.out.println(v);
		}
		queue2.poll(); // 값이 없음. null 리턴
		//queue2.remove(); // 값이 없음. 데이터없으면 에러생김
	}

}
