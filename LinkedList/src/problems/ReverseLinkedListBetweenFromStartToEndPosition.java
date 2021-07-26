package problems;

public class ReverseLinkedListBetweenFromStartToEndPosition {
	static Node head;

	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	void reverse(int start, int end) {
		if (head == null || head.next == null || start >= end || start < 1 || end < 1) {
			return;
		}

		Node current = head;
		Node prevNode = null;

		for (int i = 1; current != null && i < start; i++) {
			prevNode = current;
			current = current.next;
		}

		if (current == null) {
			return;
		}

		Node firstPartLastNode = prevNode;
		Node secondPartStartNode = current;
		Node next = null;

		for (int i = 0; current != null && i <= end - start; i++) {
			next = current.next;
			current.next = prevNode;
			prevNode = current;
			current = next;
		}

		if (start != 1) {
			firstPartLastNode.next = prevNode;
		}
		secondPartStartNode.next = current;

		head = start == 1 ? prevNode : head;
	}

	void addFirst(int data) {
		Node newNode = new Node(data);
		if (head != null) {
			newNode.next = head;
		}
		head = newNode;
	}

	void print() {
		Node movingNode = head;
		while (movingNode != null) {
			System.out.print(movingNode.data + " ");
			movingNode = movingNode.next;
		}
	}

	public static void main(String[] args) {
		ReverseLinkedListBetweenFromStartToEndPosition list = new ReverseLinkedListBetweenFromStartToEndPosition();
		list.addFirst(5);
		list.addFirst(4);
		list.addFirst(3);
		list.addFirst(2);
		list.addFirst(1);

		System.out.println("Original Linked List:");
		list.print();

		list.reverse(2, 4);
		System.out.println("\nReversed Linked List:");
		list.print();
	}
}