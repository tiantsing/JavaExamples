
public class ExtendThread {
	public static void main(String[] args) {
		System.out.println("Main thread starting.");

		MyThread3 mt = new MyThread3("Child #1");

		for (int i = 0; i < 50; i++) {
			System.out.print(".");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				System.out.println("Main thread interrupted.");
			}
		}
		System.out.println("Main thread  terminating.");

	}
}
