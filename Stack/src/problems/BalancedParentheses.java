package problems;

public class BalancedParentheses {
	static boolean areBracketsBalanced(String input) {
		myStack obj = new myStack();
		for (char c : input.toCharArray()) {
			if (c == '(' || c == '{' || c == '[') {
				obj.push(c);
			} else {
				char popped;
				if (c == ')') {
					popped = obj.pop();
					if (popped == '}' && c == ']') {
						return false;
					}
				} else if (c == '}') {
					popped = obj.pop();
					if (popped == ')' && c == ']') {
						return false;
					}
				} else if (c == ']') {
					popped = obj.pop();
					if (popped == ')' && c == ']') {
						return false;
					}
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String input = "([{}])";
		if (areBracketsBalanced(input))
			System.out.println("Balanced ");
		else
			System.out.println("Not Balanced ");
	}
}

class myStack {
	int top;
	int MAX = 100;
	char[] a = new char[MAX];

	myStack() {
		top = -1;
	}

	boolean isEmpty() {
		return top < 0;
	}

	void push(char data) {
		if (top + 1 >= MAX) {
			System.out.println("Overflow");
		} else {
			top++;
			a[top] = data;
		}
	}

	char pop() {
		if (top < 0) {
			System.out.println("Underflow");
			return '0';
		} else {
			char data = a[top];
			top--;
			return data;
		}
	}
}