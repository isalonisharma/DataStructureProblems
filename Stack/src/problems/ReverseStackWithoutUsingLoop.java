package problems;

import java.util.Stack;

public class ReverseStackWithoutUsingLoop {

	static Stack<Character> st = new Stack<>();

	static void reverse() {
		/* remember this is a if condition if(!st.isEmpty()) */
		if (!st.isEmpty()) {
			char popped = st.pop();
			reverse();
			insertAtBottom(popped);
		}
	}

	static void insertAtBottom(char bottom) {
		if (st.isEmpty()) {
			st.push(bottom);
		} else {
			char popped = st.pop();
			insertAtBottom(bottom);
			st.push(popped);
		}
	}

	public static void main(String[] args) {
		st.push('1');
		st.push('2');
		st.push('3');
		st.push('4');
		System.out.println("Original Stack: " + st);
		reverse();
		System.out.println("Reversed Stack: " + st);
	}
}