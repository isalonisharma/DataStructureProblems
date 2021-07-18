package problems;

class MySingleLinkedList {
	Node head;

	class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	MySingleLinkedList() {
		this.head = null;
	}

	void show() {
		if (head != null) {
			System.out.println("\nLinked List:");
			Node tempNode = head;
			while (tempNode != null) {
				System.out.print(tempNode.data + " -> ");
				tempNode = tempNode.next;
			}
			System.out.print("NULL");
		}
	}

	void addFirst(int data) {
		Node newNode = new Node(data);
		if (head != null) {
			newNode.next = head;
		}
		head = newNode;
	}

	void deleteFirst() {
		if (head != null) {
			head = head.next;
		}
	}

	void addLast(int data) {
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

	void deleteLast() {
		if (head != null) {
			Node lastSecondNode = head;
			while (lastSecondNode.next.next != null) {
				lastSecondNode = lastSecondNode.next;
			}
			lastSecondNode.next = null;
		}
	}

	void addMiddle(int data) {
		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
		} else {
			Node halfPointer = head, fullPointer = head;
			while (fullPointer.next != null && fullPointer.next.next != null) {
				halfPointer = halfPointer.next;
				fullPointer = fullPointer.next.next;
			}
			newNode.next = halfPointer.next;
			halfPointer.next = newNode;
		}
	}

	void deleteMiddle() {
		Node beforeMiddlePointer = null, halfPointer = head, fullPointer = head;
		while (fullPointer.next != null && fullPointer.next.next != null) {
			beforeMiddlePointer = halfPointer;
			halfPointer = halfPointer.next;
			fullPointer = fullPointer.next.next;
		}
		beforeMiddlePointer.next = halfPointer.next;
	}

	void deleteData(int data) {
		Node previousNode = null, currentNode = head;
		if (head != null) {
			if (head.data == data) {
				head = head.next;
				return;
			}
			while (currentNode.data != data) {
				previousNode = currentNode;
				currentNode = currentNode.next;
			}
			if (previousNode != null) {
				previousNode.next = currentNode.next;
			}
		}
	}

	void deletePosition(int position) {
		if (position == 0) {
			head = head.next;
		} else if (position < 0) {
			return;
		} else {
			int count = 1;
			Node movingNode = head;
			while (count != position) {
				movingNode = movingNode.next;
				count++;
			}
			if (movingNode != null && movingNode.next != null) {
				movingNode.next = movingNode.next.next;
			}
		}
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
		}
		if (prevNode2 != null) {
			prevNode2.next = node1;
		}
		Node temp1Next = node1.next;
		node1.next = node2.next;
		node2.next = temp1Next;

		if (nodePosition1 == 0) {
			head = node2;
		}
		if (nodePosition2 == 0) {
			head = node1;
		}
	}

	void reverse() {
		if (head != null) {
			Node current = head, prev = null, next = null;
			while (current != null) {
				next = current.next;
				current.next = prev;
				prev = current;
				current = next;
			}
			head = prev;
		}
	}
}

public class SingleLinkedListFunctions {
	public static void main(String args[]) {
		MySingleLinkedList myLinkedList = new MySingleLinkedList();
		myLinkedList.show();
		myLinkedList.addFirst(1);
		myLinkedList.show();
		myLinkedList.addFirst(2);
		myLinkedList.show();
		myLinkedList.addFirst(3);
		myLinkedList.show();
		myLinkedList.addLast(11);
		myLinkedList.show();
		myLinkedList.addLast(12);
		myLinkedList.show();
		myLinkedList.addLast(13);
		myLinkedList.show();
		myLinkedList.addLast(14);
		myLinkedList.show();
		myLinkedList.addFirst(4);
		myLinkedList.show();
		myLinkedList.addMiddle(33);
		myLinkedList.show();
		myLinkedList.deleteFirst();
		myLinkedList.show();
		myLinkedList.deleteLast();
		myLinkedList.show();
		myLinkedList.deleteMiddle();
		myLinkedList.show();
		System.out.print("\nLength of Linked List: " + myLinkedList.length());
		myLinkedList.deleteData(11);
		myLinkedList.show();
		myLinkedList.deletePosition(2);
		myLinkedList.show();
		myLinkedList.swapNode(1, 2);
		myLinkedList.show();
		myLinkedList.swapNode(0, 3);
		myLinkedList.show();
		myLinkedList.reverse();
		myLinkedList.show();
	}
}