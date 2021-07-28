package problems;

public class CircularLinkedListFunctions {
	Node last;

	static class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	};

	void addToEmpty(int data) {
		Node newNode = new Node(data);
		if (last == null) {
			last = newNode;
			last.next = last;
		}
	}

	void addBegin(int data) {
		Node newNode = new Node(data);
		if (last == null) {
			addToEmpty(data);
		} else {
			newNode.next = last.next;
			last.next = newNode;
		}
	}

	void addEnd(int data) {
		Node newNode = new Node(data);
		if (last == null) {
			addToEmpty(data);
		} else {
			newNode.next = last.next;
			last.next = newNode;
			last = newNode;
		}
	}

	void addAfter(int data, int afterFistFoundNode) {
		boolean found = false;
		if (last != null) {
			Node movingNode = last.next;
			do {
				if (movingNode.data == afterFistFoundNode) {
					found = true;
					Node newNode = new Node(data);
					newNode.next = movingNode.next;
					movingNode.next = newNode;
					if (movingNode == last) {
						last = newNode;
					}
					break;
				}
				movingNode = movingNode.next;
			} while (movingNode != last.next);
			if (!found) {
				System.out.println(afterFistFoundNode + " not present in the list.");
			}
		}
	}

	void traverse() {
		if (last == null) {
			System.out.println("List is empty.");
		}
		Node movingNode = last.next;
		do {
			System.out.print(movingNode.data + " ");
			movingNode = movingNode.next;
		} while (movingNode != last.next);
	}

	public static void main(String[] args) {
		CircularLinkedListFunctions myCircularLinkedList = new CircularLinkedListFunctions();
		myCircularLinkedList.addToEmpty(6);
		myCircularLinkedList.addBegin(4);
		myCircularLinkedList.addBegin(2);
		myCircularLinkedList.addEnd(8);
		myCircularLinkedList.addEnd(12);
		myCircularLinkedList.addAfter(10, 8);
		myCircularLinkedList.traverse();
	}
}