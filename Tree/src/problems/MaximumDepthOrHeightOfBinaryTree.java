package problems;

class H_Node {
	int data;
	H_Node left, right;

	H_Node(int data) {
		this.data = data;
		this.left = this.right = null;
	}
}

class H_BinaryTree {
	H_Node root;

	/*
	 * Compute the "maxDepth" of a tree -- the number of nodes along the longest
	 * path from the root node down to the farthest leaf node.
	 * 
	 * Time Complexity - O(n)
	 */
	int maxDepth(H_Node node) {
		if (node == null) {
			return 0;
		} else {
			/* compute the depth of each subtree */
			int leftSubTreeDepth = maxDepth(node.left);
			int rightSubTreeDepth = maxDepth(node.right);

			/* use the larger one */
			if (leftSubTreeDepth > rightSubTreeDepth) {
				return (leftSubTreeDepth + 1);
			} else {
				return (rightSubTreeDepth + 1);
			}
		}
	}
}

public class MaximumDepthOrHeightOfBinaryTree {
	
	public static void main(String[] args) {
		H_BinaryTree tree = new H_BinaryTree();
		tree.root = new H_Node(1);
		tree.root.left = new H_Node(2);
		tree.root.right = new H_Node(3);
		tree.root.left.left = new H_Node(4);
		tree.root.left.right = new H_Node(5);
		System.out.println("Height of tree is : " + tree.maxDepth(tree.root));
	}
}