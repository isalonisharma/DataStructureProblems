package problems;

import java.util.Stack;

public class NearestGreaterElementRightSide {
	public static void main(String[] args) {
		int arr[] = { 11, 13, 3, 21 };
		int output[] = ngr(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i] + ": " + output[i]);
		}
	}

	static int[] ngr(int[] nums) {
		int[] rb = new int[nums.length];
		/*
		 * stack maintain right side elements. loop iterates from right to left.
		 */
		Stack<Integer> st = new Stack<>();
		st.push(nums.length - 1);
		rb[nums.length - 1] = -1;
		for (int i = nums.length - 2; i >= 0; i--) {
			/*
			 * if stack is not empty, then checking the element which is greater than
			 * current in stack as stack contains right side elements
			 */
			while (st.size() > 0 && nums[i] >= nums[st.peek()]) {
				/*
				 * popping the elements which are smaller as for new elements on left side
				 * current will be greater and it is closest
				 */
				st.pop();
			}
			if (st.size() == 0) {
				/* if stack is empty, then there is no right side elements so output -1 */
				rb[i] = -1;
			} else {
				rb[i] = nums[st.peek()];
			}
			st.push(i);
		}
		return rb;
	}
}