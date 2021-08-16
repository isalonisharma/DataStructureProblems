package problems;

public class PrintNodesAtKDistanceFromRoot {
	public static void main(String args[]) {
		
		PN_BinaryTree tree = new PN_BinaryTree();
		
		/* Constructed binary tree is
        	  	1
        	  /   \
    		2     	3
    		/ \     /
    		4 5 	8
		 */
		
		tree.root = new PN_Node(1);
		tree.root.left = new PN_Node(2);
		tree.root.right = new PN_Node(3);
		tree.root.left.left = new PN_Node(4);
		tree.root.left.right = new PN_Node(5);
		tree.root.right.left = new PN_Node(8);
		tree.printKDistant(tree.root, 2);
	}
}

class PN_Node {
	int data;
	PN_Node left, right;

	PN_Node(int data) {
		this.data = data;
		this.left = this.right = null;
	}
}

class PN_BinaryTree {
	PN_Node root;

	void printKDistant(PN_Node PN_Node, int k) {
		if (PN_Node == null || k < 0) {
			return;
		} else if (k == 0) {
			System.out.print(PN_Node.data + " ");
			return;
		} else {
			// recursively traversing
			printKDistant(PN_Node.left, k - 1);
			printKDistant(PN_Node.right, k - 1);
		}
	}
}