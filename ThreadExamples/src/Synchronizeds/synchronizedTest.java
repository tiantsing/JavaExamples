package Synchronizeds;

public class synchronizedTest {
	
	public static void main(String[] args) {
	    SynchronizedDemo synDemo = new SynchronizedDemo();
	    Thread thread1 = new Thread(() -> {
	        //������ͨ����
	        synDemo.method();
	    });
	    Thread thread2 = new Thread(() -> {
	        //����ͬ������
	        synDemo.synMethod();
	    });
	    thread1.start();
	    thread2.start();
	}


}
