
public class LinkedQueue1 {
	Node front;// ��ͷָ�룬ָ���ͷ�ڵ�
	Node rail;// ��βָ�룬ָ���β�ڵ�

	int size = 0;// ��¼���г���

	// ���캯��
	public LinkedQueue1() {
		front = rail = null;
	}

	public boolean isEmpty() {
		return size == 0 ? true : false;

	}

	// ����
	public boolean enQueue(Object ele) {
		if (size == 0) {
			front = new Node(null, ele);
			rail = front;
			size++;
			return true;
		}
		Node s = new Node(null, ele);
		rail.setNext(s);
		rail = s;
		size++;
		return true;
	}

	// ����
	public boolean deQueue() {
		if (isEmpty()) {
			System.out.println("��ǰ����Ϊ��");
			return false;
		}

		front = front.next;
		size--;
		return true;
	}

	// ���������е�Ԫ��
	public void iterator() {
		for (Node node = front; node != null; node = node.getNext()) {
			System.out.println(node.getElement());
		}
	}

	public static void main(String[] args) {
		LinkedQueue1 queue = new LinkedQueue1();

		queue.enQueue(1);
		queue.enQueue(2);
		queue.enQueue(3);
		queue.deQueue();
		queue.iterator();
	}

	// �ڲ��ڵ���
	class Node {
		private Object element;
		private Node next;

		Node(Node next, Object element) {
			this.next = next;
			this.element = element;
		}

		public Object getElement() {
			return element;
		}

		public void setElement(Object element) {
			this.element = element;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

	}
}
