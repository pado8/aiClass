class MyThread3 implements Runnable{
	@Override
	public void run() {
		// 쓰레드가 해야할 일
		for(int i=0;i<100;i++) {
			System.out.println("쓰레드1");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {				
				e.printStackTrace();
			}
		}
	}
}
class MyThread4 implements Runnable{
	@Override
	public void run() {
		//쓰레드가 해야할 일
		for(int j=0;j<100;j++) {
			System.out.println("쓰레드2");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {				
				e.printStackTrace();
			}
		}
	}
}


public class ThreadTest2 {

	public static void main(String[] args) {
		MyThread3 t1=new MyThread3();
		Thread mythread1 = new Thread(t1);
		mythread1.start(); // t1을 JVM에 등록. run()메서드가 바로 실행되는 것이 아님.
		MyThread4 t2=new MyThread4();
		Thread mythread2 = new Thread(t2);
		mythread2.start(); // t2을 JVM에 등록. run()메서드가 바로 실행되는 것이 아님.

	}

}
