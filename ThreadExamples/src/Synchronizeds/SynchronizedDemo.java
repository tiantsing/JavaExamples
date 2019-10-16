package Synchronizeds;

/**
 * �ȶ���һ������ģ���� ���ﲹ��һ��֪ʶ�㣺Thread.sleep(long)�����ͷ��� ���߿ɲμ����ߵ�`������@Threadһ��ͨ`
 */
public class SynchronizedDemo {
	public static synchronized void staticMethod() {
		System.out.println(Thread.currentThread().getName() + "�����˾�̬ͬ������staticMethod");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + "�������ʾ�̬ͬ������staticMethod");
	}

	public static void staticMethod2() {
		System.out.println(Thread.currentThread().getName() + "�����˾�̬ͬ������staticMethod2");
		synchronized (SynchronizedDemo.class) {
			System.out.println(Thread.currentThread().getName() + "��staticMethod2�����л�ȡ��SynchronizedDemo.class");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public synchronized void synMethod() {
		System.out.println(Thread.currentThread().getName() + "������ͬ������synMethod");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + "��������ͬ������synMethod");
	}

	public synchronized void synMethod2() {
		System.out.println(Thread.currentThread().getName() + "������ͬ������synMethod2");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + "��������ͬ������synMethod2");
	}

	public void method() {
		System.out.println(Thread.currentThread().getName() + "��������ͨ����method");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + "����������ͨ����method");
	}

	private Object lock = new Object();

	public void chunkMethod() {
		System.out.println(Thread.currentThread().getName() + "������chunkMethod����");
		synchronized (lock) {
			System.out.println(Thread.currentThread().getName() + "��chunkMethod�����л�ȡ��lock");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void chunkMethod2() {
		System.out.println(Thread.currentThread().getName() + "������chunkMethod2����");
		synchronized (lock) {
			System.out.println(Thread.currentThread().getName() + "��chunkMethod2�����л�ȡ��lock");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void chunkMethod3() {
		System.out.println(Thread.currentThread().getName() + "������chunkMethod3����");
		// ͬ�������
		synchronized (this) {
			System.out.println(Thread.currentThread().getName() + "��chunkMethod3�����л�ȡ��this");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void stringMethod(String lock) {
		synchronized (lock) {
			while (true) {
				System.out.println(Thread.currentThread().getName());
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
