package problems;

import java.util.Stack;

/*
 * Postfix Expression: 100 200 + 2 / 5 * 7 +
 * 100 200 +
 * 			300 2 /
 * 					150 5 *
 * 							750 7 +
 * 									757
 * Value: 757
 */
public class MultipleDigitEvaluationOfPostfixExpression {
	static int evaluatePostfix(String exp) {
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < exp.length(); i++) {
			char c = exp.charAt(i);

			if (c == ' ') {
				continue;
			} else if (Character.isDigit(c)) {
				/*
				 * If the scanned character is an operand, extract the number Push it to the
				 * stack.
				 */
				int n = 0;

				/* extract the characters and store it in n */
				while (Character.isDigit(c)) {
					n = n * 10 + (int) (c - '0');
					i++;
					c = exp.charAt(i);
				}
				i--;

				stack.push(n);
			} else {
				/*
				 * If the scanned character is an operator, pop two elements from stack apply
				 * the operator
				 */
				int val1 = stack.pop();
				int val2 = stack.pop();

				switch (c) {
				case '+':
					stack.push(val2 + val1);
					break;

				case '-':
					stack.push(val2 - val1);
					break;

				case '/':
					stack.push(val2 / val1);
					break;

				case '*':
					stack.push(val2 * val1);
					break;
				}
			}
		}
		return stack.pop();
	}

	public static void main(String[] args) {
		String exp = "100 200 + 2 / 5 * 7 +";
		System.out.println("postfix evaluation: " + evaluatePostfix(exp));
	}
}