package problems;

import java.util.Stack;

public class InfixToPostfixAndPrefixConversion {
	static int precedence(char ch) {
		if (ch == '+' || ch == '-') {
			return 1;
		} else if (ch == '*' || ch == '/') {
			return 2;
		} else if (ch == '^') {
			return 3;
		} else {
			return 0;
		}
	}

	static String convertToPostfix(String input) {
		StringBuffer result = new StringBuffer();
		Stack<Character> s = new Stack<>();
		for (char c : input.toCharArray()) {
			int precedence = precedence(c);
			if (c == '(') {
				/* opening bracket */
				s.push(c);
			} else if (c == ')') {
				/* closing bracket */
				while (!s.isEmpty() && s.peek() != '(') {
					result.append(s.pop());
				}
				s.pop();
			} else if (precedence == 0) {
				/* operand */
				result.append(c);
			} else if (precedence > 0) {
				/* operator */
				while (!s.isEmpty() && precedence(s.peek()) >= precedence) {
					result.append(s.pop());
				}
				s.push(c);
			}
		}
		/* remaining operators */
		while (!s.isEmpty()) {
			result.append(s.pop());
		}
		return result.toString();
	}

	static String convertToPrefix(String input) {
		StringBuilder result = new StringBuilder();
		StringBuilder expression = new StringBuilder(input).reverse();
		Stack<Character> stack = new Stack<Character>();
		for (char c : expression.toString().toCharArray()) {
			if (precedence(c) > 0) {
				/* operator */
				while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(c)) {
					result.append(stack.pop());
				}
				stack.push(c);
			} else if (c == '(') {
				/* closing bracket */
				char x = stack.pop();
				while (x != ')') {
					result.append(x);
					x = stack.pop();
				}
			} else if (c == ')') {
				/* opening bracket */
				stack.push(c);
			} else {
				/* operand */
				result.append(c);
			}
		}

		while (!stack.isEmpty()) {
			result.append(stack.pop());
		}
		return result.reverse().toString();
	}

	public static void main(String[] args) {
		String input = "A+B*(C^D-E)";
		System.out.println("input prefix: " + input);
		System.out.println("postfix: " + convertToPostfix(input));
		System.out.println("prefix: " + convertToPrefix(input));
	}
}
