package Synchronizeds;

import java.util.concurrent.TimeUnit;
/**
 * �����ߡ�������ģʽ
 * @author tianq
 *
 */
public class ThreadTest {

	static final Object obj = new Object(); // ������

	private static boolean flag = false;

	public static void main(String[] args) throws Exception {

		Thread consume = new Thread(new Consume(), "Consume");
		Thread produce = new Thread(new Produce(), "Produce");
		consume.start();
		Thread.sleep(1000);
		produce.start();

		try {
			produce.join();
			consume.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// �������߳�
	static class Produce implements Runnable {

		@Override
		public void run() {

			synchronized (obj) {
				System.out.println("�����������߳�");
				System.out.println("����");
				try {
					TimeUnit.MILLISECONDS.sleep(2000); // ģ����������
					flag = true;
					obj.notify(); // ֪ͨ������
					TimeUnit.MILLISECONDS.sleep(1000); // ģ��������ʱ����
					System.out.println("�˳��������߳�");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	// �������߳�
	static class Consume implements Runnable {

		@Override
		public void run() {
			synchronized (obj) {
				System.out.println("�����������߳�");
				System.out.println("wait flag 1:" + flag);
				while (!flag) { // �ж������Ƿ����㣬����������ȴ�
					try {
						System.out.println("��û����������ȴ�");
						obj.wait();
						System.out.println("�����ȴ�");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("wait flag 2:" + flag);
				System.out.println("����");
				System.out.println("�˳��������߳�");
			}

		}
	}
}
