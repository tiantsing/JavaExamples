package Synchronizeds;

public class synchronizedTest {
	
	public static void main(String[] args) {
	    SynchronizedDemo synDemo = new SynchronizedDemo();
	    Thread thread1 = new Thread(() -> {
	        //调用普通方法
	        synDemo.method();
	    });
	    Thread thread2 = new Thread(() -> {
	        //调用同步方法
	        synDemo.synMethod();
	    });
	    thread1.start();
	    thread2.start();
	}


}
