package problems;

import java.util.Stack;
public class SingleDigitEvaluationOfExpression
{
    static int postfixEvaluation(String input){
        Stack<Integer> stack = new Stack<>();
        for(char c: input.toCharArray()){
            if(Character.isDigit(c)){
                stack.push(Character.getNumericValue(c));
            }
            else{
                int first = stack.pop();
                int second = stack.pop();
                stack.push(performOperation(c,second,first));
            }
        }
        return stack.pop();
    }
    
    static int prefixEvaluation(String input){
        input =  new StringBuilder(input).reverse().toString();
        Stack<Integer> stack = new Stack<>();
        for(char c: input.toCharArray()){
            if(Character.isDigit(c)){
                stack.push(Character.getNumericValue(c));
            }
            else{
                int first = stack.pop();
                int second = stack.pop();
                stack.push(performOperation(c,first,second));
            }
        }
        return stack.pop();
    }
    
    static int performOperation(char c, int op1, int op2){
        switch(c){
            case '*':
                return op1*op2;
            case '/':
                return op1/op2;
            case '+':
                return op1+op2;
            case '-':
                return op1-op2;
            default:
            	return 0;
        }
    }
    
	public static void main(String[] args) {
	    String input = "23*54*+9-";
	    System.out.println("postfix evaluation: " + postfixEvaluation(input));
	    input = "-+*23*549";
		System.out.println("prefix evaluation: " + prefixEvaluation(input));
	}
}
