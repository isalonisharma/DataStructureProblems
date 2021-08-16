package problems;

class BTNode {
	int data;
	BTNode left, right;

	public BTNode(int item) {
		data = item;
		left = right = null;
	}
}

class BreadthFirstBinaryTree {
	BTNode root;

	public BreadthFirstBinaryTree() {
		root = null;
	}

	void printLevelOrder() {
		int height = height(root);
		int level;
		for (level = 1; level <= height; level++) {
			printCurrentLevel(root, level);
		}
	}

	int height(BTNode root) {
		if (root == null) {
			return 0;
		} else {
			int leftHeight = height(root.left);
			int rightHeight = height(root.right);
			return leftHeight > rightHeight ? (leftHeight + 1) : (rightHeight + 1);
		}
	}

	void printCurrentLevel(BTNode root, int level) {
		if (root == null) {
			return;
		} else if (level == 1) {
			System.out.print(root.data + " ");
		} else if (level > 1) {
			printCurrentLevel(root.left, level - 1);
			printCurrentLevel(root.right, level - 1);
		}
	}
}

public class BreadthFirstTraversal {
	
	public static void main(String args[]) {
		BreadthFirstBinaryTree tree = new BreadthFirstBinaryTree();
		tree.root = new BTNode(1);
		tree.root.left = new BTNode(2);
		tree.root.right = new BTNode(3);
		tree.root.left.left = new BTNode(4);
		tree.root.left.right = new BTNode(5);

		System.out.print("level order traversal of binary tree is: ");
		tree.printLevelOrder();
	}
}