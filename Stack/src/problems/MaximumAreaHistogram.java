package problems;

import java.util.Stack;

public class MaximumAreaHistogram {
	public static void main(String[] args) {
		int[] heights = { 6, 2, 5, 4, 5, 1, 6 };
		int area = largestRectangleArea(heights);
		System.out.println("max area: " + area);
	}

	static int largestRectangleArea(int[] heights) {
		int[] rb = nsr(heights);// Finding index of next smaller to the right
		int[] lb = nsl(heights);// Finding index of next smaller to the left
		int maxArea = 0, n = heights.length;
		for (int i = 0; i < n; i++) {
			int w = rb[i] - lb[i] - 1;
			int area = w * heights[i];
			maxArea = Math.max(maxArea, area);
		}
		return maxArea;
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
				lb[i] = st.peek();
			}
			st.push(i);
		}
		return lb;
	}

	static int[] nsr(int[] nums) {
		int[] rb = new int[nums.length];
		Stack<Integer> st = new Stack<>();
		st.push(nums.length - 1);
		rb[nums.length - 1] = nums.length;
		for (int i = nums.length - 2; i >= 0; i--) {
			while (st.size() > 0 && nums[i] <= nums[st.peek()]) {
				st.pop();
			}
			if (st.size() == 0) {
				rb[i] = nums.length;
			} else {
				rb[i] = st.peek();
			}
			st.push(i);
		}
		return rb;
	}
}