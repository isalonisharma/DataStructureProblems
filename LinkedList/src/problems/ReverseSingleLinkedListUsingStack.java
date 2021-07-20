package problems;

import java.util.*;

public class ReverseSingleLinkedListUsingStack {
	static Node head = null;

	static class Node {
		int data;
		Node next;

		public Node(int data) {
			super();
			this.data = data;
			this.next = null;
		}
	};

	static void reverse() {
		Stack<Node> stackNode = new Stack<>();
		Node movingNode = head;
		
		while (movingNode.next != null) {
			stackNode.add(movingNode);
			movingNode = movingNode.next;
		}
		
		head = movingNode;
		
		while (!stackNode.isEmpty()) {
			movingNode.next = stackNode.pop();
			movingNode = movingNode.next;
		}
		
		movingNode.next = null;
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
		System.out.print("Linked List:\n");
		print();
		reverse();
		System.out.print("\nReversed Linked List:\n");
		print();
	}
}