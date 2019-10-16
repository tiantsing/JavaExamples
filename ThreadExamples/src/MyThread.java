
public class MyThread implements Runnable {

	String threadName;

	MyThread(String name) {
		threadName = name;
	}

	@Override
	public void run() {
		System.out.println(threadName + " starting.");
		try {
			for (int count = 0; count < 10; count++) {
				Thread.sleep(400);
				System.out.println("In " + threadName + ", count is " + count);
			}
		} catch (InterruptedException e) {
			System.out.println(threadName + " interrupted.");
		}
		System.out.println(threadName + " terminating.");
	}

}
