package problems;

public class PrintAncestorsOfGivenNodeInBinaryTree {
	public static void main(String args[]) {
		/* Construct the following binary tree
			        1
			      /   \
			     2     3
			    /  \
			   4    5
			  /
			 7
		*/
		PA_BinaryTree tree = new PA_BinaryTree();
		tree.root = new PA_Node(1);
		tree.root.left = new PA_Node(2);
		tree.root.right = new PA_Node(3);
		tree.root.left.left = new PA_Node(4);
		tree.root.left.right = new PA_Node(5);
		tree.root.left.left.left = new PA_Node(7);
		tree.printAncestors(tree.root, 7);
	}
}

class PA_Node {
	int data;
	PA_Node left, right, nextRight;

	PA_Node(int data) {
		this.data = data;
		this.left = this.right = this.nextRight = null;
	}
}

class PA_BinaryTree {
	PA_Node root;

	boolean printAncestors(PA_Node PA_Node, int target) {
		if (PA_Node == null) {
			return false;
		} else if (PA_Node.data == target) {
			return true;
		} else if (printAncestors(PA_Node.left, target) || printAncestors(PA_Node.right, target)) {
			System.out.print(PA_Node.data + " ");
			return true;
		} else {
			return false;
		}
	}
}