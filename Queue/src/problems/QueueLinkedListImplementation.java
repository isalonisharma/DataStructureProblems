package problems;

class QueueLinkedListNode {
	int key;
	QueueLinkedListNode next;

	public QueueLinkedListNode(int key) {
		this.key = key;
		this.next = null;
	}
}

public class QueueLinkedListImplementation {
	QueueLinkedListNode front, rear;

	public QueueLinkedListImplementation() {
		this.front = this.rear = null;
	}

	void enqueue(int key) {
		QueueLinkedListNode temp = new QueueLinkedListNode(key);
		if (this.rear == null) {
			this.front = this.rear = temp;
			return;
		} else {
			this.rear.next = temp;
			this.rear = temp;
		}
	}

	void dequeue() {
		if (this.front == null) {
			return;
		} else {
			this.front = this.front.next;
			if (this.front == null) {
				this.rear = null;
			}
		}
	}
	public static void main(String[] args) {
		QueueLinkedListImplementation q = new QueueLinkedListImplementation();
		q.enqueue(10); // 10
		q.enqueue(20); // 10 20
		q.dequeue(); // 20
		q.dequeue(); 
		q.enqueue(30); // 30
		q.enqueue(40); // 30 40
		q.enqueue(50); // 30 40 50
		q.enqueue(60); // 30 40 50 60
		q.dequeue(); // 40 50 60
		System.out.println("Queue Front : " + q.front.key);
		System.out.println("Queue Rear : " + q.rear.key);
	}
}