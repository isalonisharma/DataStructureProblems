package problems;

import java.util.Queue;
import java.util.LinkedList;

/* https://youtu.be/kQ-aoKbGKSo */
public class BreadthFirstTraversalUsingQueue {
	public static void main(String args[]) {
		BTQ_BinaryTree treeLevel = new BTQ_BinaryTree();
		treeLevel.root = new BTQ_Node(1);
		treeLevel.root.left = new BTQ_Node(2);
		treeLevel.root.right = new BTQ_Node(3);
		treeLevel.root.left.left = new BTQ_Node(4);
		treeLevel.root.left.right = new BTQ_Node(5);

		System.out.print("level order traversal of binary tree is - ");
		treeLevel.printLevelOrder();
	}
}

class BTQ_Node {
	int data;
	BTQ_Node left, right;

	public BTQ_Node(int item) {
		data = item;
		left = right = null;
	}
}

class BTQ_BinaryTree {
	BTQ_Node root;

	void printLevelOrder() {
		Queue<BTQ_Node> queue = new LinkedList<BTQ_Node>();
		queue.add(root);
		while (!queue.isEmpty()) {
			BTQ_Node tempNode = queue.poll();
			System.out.print(tempNode.data + " ");

			if (tempNode.left != null) {
				queue.add(tempNode.left);
			}

			if (tempNode.right != null) {
				queue.add(tempNode.right);
			}
		}
	}
}