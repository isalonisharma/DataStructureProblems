package problems;

class MyDoubleLinkedList {
	Node head;

	class Node {
		int data;
		Node prev, next;

		Node(int data) {
			this.data = data;
			this.prev = null;
			this.next = null;
		}
	}

	void show() {
		System.out.println("\nLinked List: ");
		if (head != null) {
			Node movingNode = head;
			while (movingNode != null) {
				String prevData = movingNode.prev != null ? String.valueOf(movingNode.prev.data) : "null";
				System.out.print("[{" + prevData + "} ");
				System.out.print(movingNode.data);
				String nextData = movingNode.next != null ? String.valueOf(movingNode.next.data) : "null";
				System.out.print(" {" + nextData + "}]" + " -> ");
				movingNode = movingNode.next;
			}
		}
		System.out.print("NULL");
	}

	void addFirst(int data) {
		Node newNode = new Node(data);
		if (head != null) {
			head.prev = newNode;
			newNode.next = head;
		}
		head = newNode;
	}

	void addLast(int data) {
		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
		} else {
			Node movingNode = head;
			while (movingNode.next != null) {
				movingNode = movingNode.next;
			}
			movingNode.next = newNode;
			newNode.prev = movingNode;
		}
	}

	void addMiddle(int data) {
		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
		} else {
			Node movingNode = head, previousMiddleNode = head;
			while (movingNode.next != null && movingNode.next.next != null) {
				previousMiddleNode = previousMiddleNode.next;
				movingNode = movingNode.next.next;
			}
			newNode.prev = previousMiddleNode;
			newNode.next = previousMiddleNode.next;
			previousMiddleNode.next = newNode;
		}
	}

	void deleteFirst() {
		Node newHead = head.next;
		newHead.prev = null;
		head = newHead;
	}

	void deleteLast() {
		Node movingNode = head;
		while (movingNode.next != null) {
			movingNode = movingNode.next;
		}
		movingNode.prev.next = null;
	}

	void deleteMiddle() {
		Node movingNode = head, middleNode = head;
		while (movingNode.next != null && movingNode.next.next != null) {
			movingNode = movingNode.next.next;
			middleNode = middleNode.next;
		}
		middleNode.prev.next = middleNode.next;
	}

	int length() {
		int length = 0;
		if (head != null) {
			Node movingNode = head;
			while (movingNode != null) {
				length++;
				movingNode = movingNode.next;
			}
		}
		return length;
	}

	void reverse() {
		Node movingNode = head, next = null, prev = null;
		while (movingNode != null) {
			next = movingNode.next;
			movingNode.prev = next;
			movingNode.next = prev;
			prev = movingNode;
			movingNode = next;
		}
		head = prev;
	}

	void swapNode(int nodePosition1, int nodePosition2) {
		if (head == null || nodePosition1 == nodePosition2 || nodePosition1 < 0 || nodePosition2 < 0) {
			return;
		}
		int position = 0;
		Node prevNode1 = null, node1 = head, prevNode2 = null, node2 = head;
		boolean nodePosition1Found = false, nodePosition2Found = false;
		if (nodePosition1 == 0) {
			nodePosition1Found = true;
			node1 = head;
		}
		if (nodePosition2 == 0) {
			nodePosition2Found = true;
			node2 = head;
		}

		if (!nodePosition1Found || !nodePosition2Found) {
			while (!nodePosition1Found || !nodePosition2Found) {
				if (!nodePosition1Found) {
					if (position != nodePosition1) {
						prevNode1 = node1;
						node1 = node1.next;
					} else {
						nodePosition1Found = true;
					}
				}
				if (!nodePosition2Found) {
					if (position != nodePosition2) {
						prevNode2 = node2;
						node2 = node2.next;
					} else {
						nodePosition2Found = true;
					}
				}
				position++;
			}
		}

		if (prevNode1 != null) {
			prevNode1.next = node2;
			node2.prev = prevNode1;
		}
		if (prevNode2 != null) {
			prevNode2.next = node1;
			node1.prev = prevNode2;
		}
		Node temp1Next = node1.next;
		node1.next = node2.next;
		node2.next = temp1Next;

		if (nodePosition1 == 0) {
			head = node2;
			head.prev = null;
			head.next.prev = head;
		}
		if (nodePosition2 == 0) {
			head = node1;
			head.prev = null;
			head.next.prev = head;
		}
	}
}

public class DoubleLinkedListFunctions {
	public static void main(String[] args) {
		MyDoubleLinkedList myDoubleLinkedList = new MyDoubleLinkedList();
		myDoubleLinkedList.show();
		myDoubleLinkedList.addFirst(1);
		myDoubleLinkedList.show();
		myDoubleLinkedList.addFirst(2);
		myDoubleLinkedList.show();
		myDoubleLinkedList.addFirst(3);
		myDoubleLinkedList.show();
		myDoubleLinkedList.addLast(11);
		myDoubleLinkedList.show();
		myDoubleLinkedList.addLast(12);
		myDoubleLinkedList.show();
		myDoubleLinkedList.addLast(13);
		myDoubleLinkedList.show();
		myDoubleLinkedList.addLast(14);
		myDoubleLinkedList.show();
		myDoubleLinkedList.addFirst(4);
		myDoubleLinkedList.show();
		myDoubleLinkedList.addMiddle(33);
		myDoubleLinkedList.show();
		myDoubleLinkedList.deleteFirst();
		myDoubleLinkedList.show();
		myDoubleLinkedList.deleteLast();
		myDoubleLinkedList.show();
		myDoubleLinkedList.deleteMiddle();
		myDoubleLinkedList.show();
		System.out.print("\nLength of Linked List: " + myDoubleLinkedList.length());
		myDoubleLinkedList.swapNode(1, 2);
		myDoubleLinkedList.show();
		myDoubleLinkedList.swapNode(0, 3);
		myDoubleLinkedList.show();
		myDoubleLinkedList.reverse();
		myDoubleLinkedList.show();
	}
}