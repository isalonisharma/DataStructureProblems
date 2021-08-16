package problems;

class MW_Node {
	int data;
	MW_Node left, right;

	MW_Node(int data) {
		this.data = data;
		this.left = this.right = null;
	}
}

class MW_BinaryTree {
	MW_Node root;

	int getMaxWidth(MW_Node node) {
		int maxWidth = 0;
		int width;
		int h = height(node);
		for (int i = 1; i <= h; i++) {
			width = getWidth(node, i);
			if (width > maxWidth)
				maxWidth = width;
		}
		return maxWidth;
	}

	int getWidth(MW_Node node, int level) {
		if (node == null) {
			return 0;
		} else {
			if (level == 1) {
				return 1;
			} else if (level > 1) {
				return getWidth(node.left, level - 1) + getWidth(node.right, level - 1);
			} else {
				return 0;
			}
		}
	}

	int height(MW_Node node) {
		if (node == null) {
			return 0;
		} else {
			int leftSubTreeHeight = height(node.left);
			int rightSubTreeHeight = height(node.right);
			return (leftSubTreeHeight > rightSubTreeHeight) ? (leftSubTreeHeight + 1) : (rightSubTreeHeight + 1);
		}
	}
}

/* time complexity : O(n^2) */
public class MaximumWidthOfBinaryTree {
	
	public static void main(String args[]) {
		MW_BinaryTree tree = new MW_BinaryTree();
		/*
		Constructed bunary tree is:
			1
			/ \
			2 3
			/ \ \
			4 5	 8
				/ \
				6 7
		*/
		tree.root = new MW_Node(1);
		tree.root.left = new MW_Node(2);
		tree.root.right = new MW_Node(3);
		tree.root.left.left = new MW_Node(4);
		tree.root.left.right = new MW_Node(5);
		tree.root.right.right = new MW_Node(8);
		tree.root.right.right.left = new MW_Node(6);
		tree.root.right.right.right = new MW_Node(7);

		// Function call
		System.out.println("maximum width of tree: " + tree.getMaxWidth(tree.root));
	}
}