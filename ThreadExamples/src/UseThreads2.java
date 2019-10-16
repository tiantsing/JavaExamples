
public class UseThreads2 {

	public static void main(String[] args) {
		System.out.println("Main thread starting.");

		MyThread2 mt = new MyThread2("Child #1");
		MyThread2 mt2 = new MyThread2("Child #2");
		MyThread2 mt3 = new MyThread2("Child #3");

		/*
		 * for (int i = 0; i < 50; i++) { System.out.print("."); try {
		 * Thread.sleep(100); } catch (InterruptedException e) {
		 * System.out.println("Main thread interrupted."); } }
		 */
		
		/*
		 * do { System.out.print("."); try { Thread.sleep(100); } catch
		 * (InterruptedException e) { System.out.println("Main thread interrupted."); }
		 * }while(mt.trd.isAlive()|| mt2.trd.isAlive()|| mt3.trd.isAlive());
		 */
		
		try {
			mt.trd.join();
			mt2.trd.join();
			mt3.trd.join();
			} catch (InterruptedException e) {
			System.out.println("Main thread interrupted."); 
			}
		System.out.println("Main thread  terminating.");

	}

}
