
public class LinkedQueue1 {
	Node front;// 队头指针，指向队头节点
	Node rail;// 队尾指针，指向队尾节点

	int size = 0;// 记录队列长度

	// 构造函数
	public LinkedQueue1() {
		front = rail = null;
	}

	public boolean isEmpty() {
		return size == 0 ? true : false;

	}

	// 入列
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

	// 出列
	public boolean deQueue() {
		if (isEmpty()) {
			System.out.println("当前队列为空");
			return false;
		}

		front = front.next;
		size--;
		return true;
	}

	// 遍历队列中的元素
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

	// 内部节点类
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
