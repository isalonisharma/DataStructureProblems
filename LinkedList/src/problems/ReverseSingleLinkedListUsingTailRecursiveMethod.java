package problems;

public class ReverseSingleLinkedListUsingTailRecursiveMethod {
	static Node head;

	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	static void reverse(Node currentNode, Node previousNode) {
		if (head != null) {
			if (currentNode.next == null) {
				/* If last node mark it head */
				head = currentNode;
				currentNode.next = previousNode;
			} else {
				Node nextNode = currentNode.next;
				currentNode.next = previousNode;
				reverse(nextNode, currentNode);
			}
		}
	}

	static void print() {
		Node movingNode = head;
		while (movingNode != null) {
			System.out.print(movingNode.data + " ");
			movingNode = movingNode.next;
		}
	}

	static void addLast(int data) {
		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
		} else {
			Node lastNode = head;
			while (lastNode.next != null) {
				lastNode = lastNode.next;
			}
			lastNode.next = newNode;
		}
	}

	public static void main(String[] args) {
		addLast(1);
		addLast(2);
		addLast(3);
		addLast(4);
		addLast(5);
		addLast(6);
		addLast(7);
		addLast(8);
		System.out.print("Original Linked List: ");
		print();
		reverse(head, null);
		System.out.print("\nReversed Linked List: ");
		print();
	}
}