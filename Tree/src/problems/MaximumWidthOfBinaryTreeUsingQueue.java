package problems;

import java.util.LinkedList;
import java.util.Queue;

/* 
 https://youtu.be/tRH8RS99wPk 
 time complexity: O(n)
 */
public class MaximumWidthOfBinaryTreeUsingQueue {
	static class node {
		int data;
		node left, right;

		public node(int data) {
			this.data = data;
		}
	}

	static int maxwidth(node root) {
		if (root == null) {
			return 0;
		} else {
			int maxwidth = 0;
			Queue<node> queue = new LinkedList<>();
			queue.add(root);
			while (!queue.isEmpty()) {
				int count = queue.size();
				maxwidth = Math.max(maxwidth, count);
				while (count-- > 0) {
					node temp = queue.remove();
					if (temp.left != null) {
						queue.add(temp.left);
					}
					if (temp.right != null) {
						queue.add(temp.right);
					}
				}
			}
			return maxwidth;
		}
	}

	public static void main(String[] args) {
		node root = new node(1);
		root.left = new node(2);
		root.right = new node(3);
		root.left.left = new node(4);
		root.left.right = new node(5);
		root.right.right = new node(8);
		root.right.right.left = new node(6);
		root.right.right.right = new node(7);

		/*
		  
		  1
		/	 \
		2	  3
		/ \	 	\
		4 5	 	 8
				/ \
				6  7 
		*/

		System.out.println("Maximum width = " + maxwidth(root));
	}
}