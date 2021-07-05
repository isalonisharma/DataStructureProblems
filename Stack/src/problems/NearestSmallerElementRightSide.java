package problems;

import java.util.Stack;

public class NearestSmallerElementRightSide {
	public static void main(String args[]) {
		int arr[] = { 21, 3, 13, 11 };
		int output[] = nsr(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i] + ": " + output[i]);
		}
	}

	static int[] nsr(int[] nums) {
		int[] rb = new int[nums.length];
		Stack<Integer> st = new Stack<>();
		st.push(nums.length - 1);
		rb[nums.length - 1] = -1;
		for (int i = nums.length - 2; i >= 0; i--) {
			while (st.size() > 0 && nums[i] <= nums[st.peek()]) {
				st.pop();
			}
			if (st.size() == 0) {
				rb[i] = -1;
			} else {
				rb[i] = nums[st.peek()];
			}
			st.push(i);
		}
		return rb;
	}
}