package problems;

class StackArray {
	int top, size;
	int a[];

	StackArray(int size) {
		this.top = -1;
		this.size = size;
		this.a = new int[size];
	}

	boolean isEmpty() {
		return (top < 0);
	}

	boolean push(int x) {
		if (top >= (size - 1)) {
			System.out.println("Stack Overflow");
			return false;
		} else {
			a[++top] = x;
			System.out.println(x + " pushed into stack");
			return true;
		}
	}

	int pop() {
		if (top < 0) {
			System.out.println("Stack Underflow");
			return 0;
		} else {
			return a[top--];
		}
	}

	int peek() {
		if (top < 0) {
			System.out.println("Stack Underflow");
			return 0;
		} else {
			return a[top];
		}
	}
}

public class StackArrayImplementation {
	public static void main(String args[]) {
		StackArray s = new StackArray(100);
		s.push(10);
		s.push(20);
		s.push(30);
		System.out.println(s.pop() + " Popped from stack");
		System.out.println("Top element is : " + s.peek());
	}
}
