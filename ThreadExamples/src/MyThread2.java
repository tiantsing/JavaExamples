
public class MyThread2 implements Runnable {

	Thread trd;

	MyThread2(String name) {
		trd = new Thread(this,name);
		trd.start();
	}

	@Override
	public void run() {
		System.out.println(trd.getName() + " starting.");
		try {
			for (int count = 0; count < 10; count++) {
				Thread.sleep(400);
				System.out.println("In " + trd.getName() + ", count is " + count);
			}
		} catch (InterruptedException e) {
			System.out.println(trd.getName() + " interrupted.");
		}
		System.out.println(trd.getName() + " terminating.");
	}

}
