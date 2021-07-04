package problems;

public class ReverseStringUsingStack {
	static String reverse(String input) {
		Stack obj = new Stack();
		for (char c : input.toCharArray()) {
			obj.push(c);
		}
		StringBuffer result = new StringBuffer();
		while (!obj.isEmpty()) {
			result.append(obj.pop());
		}
		return result.toString();
	}

	public static void main(String[] args) {
		String result = reverse("amrahs inolas");
		System.out.println("Reversed string: " + result);

	}
}

class Stack {
	StackNode root;

	boolean isEmpty() {
		return root == null;
	}

	void push(char data) {
		StackNode temp = new StackNode(data);
		if (root == null) {
			root = temp;
		} else {
			temp.next = root;
			root = temp;
		}
	}

	char pop() {
		if (root == null) {
			System.out.println("Underflow");
			return 0;
		} else {
			char data = root.data;
			root = root.next;
			return data;
		}
	}
}

class StackNode {
	char data;
	StackNode next;

	StackNode(char data) {
		this.data = data;
	}
}
