class MyThread7 extends Thread {
	@Override
	public void run() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			System.out.println("sleep() 진행 중 interrupted()발생");
			for(long i = 0; i < 10000000000L; i++) {
				
			}
		}
	}
}

public class TimeWating_Sleep {

	public static void main(String[] args) {
		 MyThread7 myThread = new MyThread7();
	        myThread.start();
	        try {
	            Thread.sleep(100);
	        } catch (InterruptedException e) {}
	        System.out.println("My Thread State = " + myThread.getState());
	        myThread.interrupt(); //Thread interrupt
	        try {
	            Thread.sleep(100);
	        } catch (InterruptedException e) {}
	        System.out.println("My Thread State = " + myThread.getState());
	}

}
