package problems;

import java.util.*;

public class ReverseDoubleLinkedListUsingStack {
	static Node head;

	static class Node {
		int data;
		Node next, prev;

		Node(int data) {
			this.data = data;
			this.next = this.prev = null;
		}
	}

	void reverse() {
		Stack<Integer> stack = new Stack<>();
		Node movingNode = head;
		while (movingNode != null) {
			stack.push(movingNode.data);
			movingNode = movingNode.next;
		}
		movingNode = head;
		while (movingNode != null) {
			movingNode.data = stack.pop();
			movingNode = movingNode.next;
		}
	}

	void addFirst(int data) {
		Node newNode = new Node(data);
		newNode.next = head;
		if (head != null) {
			head.prev = newNode;
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
		ReverseDoubleLinkedListUsingStack list = new ReverseDoubleLinkedListUsingStack();
		list.addFirst(2);
		list.addFirst(4);
		list.addFirst(8);
		list.addFirst(10);

		System.out.println("Original Linked List:");
		list.print();

		list.reverse();
		System.out.println("\nReversed Linked List:");
		list.print();
	}
}