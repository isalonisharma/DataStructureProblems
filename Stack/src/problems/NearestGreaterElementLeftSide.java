package problems;

import java.util.Stack;

public class NearestGreaterElementLeftSide {
	public static void main(String[] args) {
		int arr[] = { 21, 3, 13, 11 };
		int output[] = ngl(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i] + ": " + output[i]);
		}
	}

	static int[] ngl(int[] nums) {
		int[] lb = new int[nums.length];
		/*
		 * stack maintain left side elements. loop iterates from left to right.
		 */
		Stack<Integer> st = new Stack<>();
		st.push(0);
		lb[0] = -1;
		for (int i = 1; i < nums.length; i++) {
			while (st.size() > 0 && nums[i] >= nums[st.peek()]) {
				st.pop();
			}
			if (st.size() == 0) {
				/* if stack is empty, then there is no left side elements so output -1 */
				lb[i] = -1;
			} else {
				/*
				 * popping till we find greater element & for next elements current will work as
				 * it is nearest greater one
				 */
				lb[i] = nums[st.peek()];
			}
			st.push(i);
		}
		return lb;
	}
}