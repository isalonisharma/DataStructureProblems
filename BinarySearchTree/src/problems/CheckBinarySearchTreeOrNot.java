package problems;

class Node {
	int data;
	Node left, right;

	public Node(int item) {
		data = item;
		left = right = null;
	}
}

public class CheckBinarySearchTreeOrNot {
	Node root;

	boolean isBST() {
		return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	/*
	 * Returns true if the given tree is a BST and its values are >= min and <= max.
	 */
	boolean isBSTUtil(Node node, int min, int max) {
		/* an empty tree is BST */
		if (node == null)
			return true;

		/* false if this node violates the min/max constraints */
		if (node.data <= min || node.data >= max)
			return false;

		/*
		 * otherwise check the subtrees recursively tightening the min/max constraints
		 */
		/* Allow only distinct values */
		return (isBSTUtil(node.left, min, node.data) && isBSTUtil(node.right, node.data, max));
	}

	public static void main(String args[]) {
		CheckBinarySearchTreeOrNot tree = new CheckBinarySearchTreeOrNot();
		tree.root = new Node(4);
		tree.root.left = new Node(2);
		tree.root.right = new Node(5);
		tree.root.left.left = new Node(1);
		tree.root.left.right = new Node(3);

		if (tree.isBST()) {
			System.out.println("IS BST");
		} else {
			System.out.println("Not a BST");
		}
	}
}
