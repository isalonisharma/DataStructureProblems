package problems;

import java.util.Stack;

public class NearestSmallerElementLeftSide {
	public static void main(String[] args) {
		int arr[] = { 11, 13, 3, 21 };
		int output[] = nsl(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i] + ": " + output[i]);
		}
	}

	static int[] nsl(int[] nums) {
		int[] lb = new int[nums.length];
		Stack<Integer> st = new Stack<>();
		st.push(0);
		lb[0] = -1;
		for (int i = 1; i < nums.length; i++) {
			while (st.size() > 0 && nums[i] <= nums[st.peek()]) {
				st.pop();
			}
			if (st.size() == 0) {
				lb[i] = -1;
			} else {
				lb[i] = nums[st.peek()];
			}
			st.push(i);
		}
		return lb;
	}
}