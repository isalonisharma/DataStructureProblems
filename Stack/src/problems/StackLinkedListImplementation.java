package problems;

class StackLinkedListNode {
	int data;
	StackLinkedListNode next;

	StackLinkedListNode(int data) {
		this.data = data;
	}
}

public class StackLinkedListImplementation {
	StackLinkedListNode root;

	public boolean isEmpty() {
		if (root == null) {
			return true;
		} else {
			return false;
		}
	}

	public void push(int data) {
		StackLinkedListNode newNode = new StackLinkedListNode(data);
		if (root == null) {
			root = newNode;
		} else {
			StackLinkedListNode temp = root;
			root = newNode;
			newNode.next = temp;
		}
		System.out.println(data + " pushed to stack");
	}

	public int pop() {
		int popped = Integer.MIN_VALUE;
		if (root == null) {
			System.out.println("Stack is Empty");
		} else {
			popped = root.data;
			root = root.next;
		}
		return popped;
	}

	public int peek() {
		if (root == null) {
			System.out.println("Stack is empty");
			return Integer.MIN_VALUE;
		} else {
			return root.data;
		}
	}

	public static void main(String[] args) {
		StackLinkedListImplementation sll = new StackLinkedListImplementation();
		sll.push(10);
		sll.push(20);
		sll.push(30);
		System.out.println(sll.pop() + " popped from stack");
		System.out.println("Top element is " + sll.peek());
	}
}