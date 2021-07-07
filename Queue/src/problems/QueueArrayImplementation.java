package problems;

class Queue {
	int front, rear, size;
	int array[];

	public Queue(int arraySize) {
		this.size = 0;
		this.rear = this.front = -1;
		this.array = new int[arraySize];
	}

	boolean isFull(Queue queue) {
		return queue.size == array.length;
	}

	boolean isEmpty(Queue queue) {
		return queue.size == 0;
	}

	void enqueue(int item) {
		if (isFull(this)) {
			System.out.println("Queue is full! Can not add more elements");
		} else {
			this.rear = (this.rear + 1) % array.length;
			this.array[this.rear] = item;
			this.size = this.size + 1;
			System.out.println(item + " enqueued to queue");
		}
	}

	int dequeue() {
		if (isEmpty(this)) {
			System.out.println("Queue is empty! Can not dequeue element");
			return Integer.MIN_VALUE;
		} else {
			this.front = (this.front + 1) % array.length;
			int item = this.array[this.front];
			this.size = this.size - 1;
			return item;
		}
	}

	int front() {
		if (isEmpty(this)) {
			return Integer.MIN_VALUE;
		} else {
			return this.array[(this.front + 1) % array.length];
		}
	}

	int rear() {
		if (isEmpty(this)) {
			return Integer.MIN_VALUE;
		} else {
			return this.array[this.rear];
		}
	}
}

public class QueueArrayImplementation {
	public static void main(String[] args) {
		Queue queue = new Queue(1000);
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		queue.enqueue(40);
		System.out.println(queue.dequeue() + " dequeued from queue\n");
		System.out.println("Front item is " + queue.front());
		System.out.println("Rear item is " + queue.rear());
	}
}