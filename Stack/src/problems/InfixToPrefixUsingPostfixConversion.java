package problems;

import java.util.Stack;

public class InfixToPrefixUsingPostfixConversion {
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

	static String convertToPrefix(String expression) {
		StringBuilder result = new StringBuilder();
		StringBuilder input = new StringBuilder(expression);
		input.reverse();
		char[] charsExp = new String(input).toCharArray();
		for (int i = 0; i < charsExp.length; i++) {
			if (charsExp[i] == '(') {
				charsExp[i] = ')';
				i++;
			} else if (charsExp[i] == ')') {
				charsExp[i] = '(';
				i++;
			}
		}
		result = new StringBuilder(convertToPostfix(String.valueOf(charsExp)));
		return result.reverse().toString();
	}

	public static void main(String[] args) {
		String input = "A+B*(C^D-E)";
		System.out.println("input prefix: " + input);
		System.out.println("postfix: " + convertToPostfix(input));
		System.out.println("prefix: " + convertToPrefix(input));
	}
}
