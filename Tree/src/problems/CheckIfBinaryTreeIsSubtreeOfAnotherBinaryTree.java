package problems;

class C_Node {
	int data;
	C_Node left, right;

	C_Node(int data) {
		this.data = data;
		this.left = this.right = null;
	}
}

class C_BinaryTree {
	C_Node root;

	boolean areIdentical(C_Node root1, C_Node root2) {
		if (root1 == null && root2 == null) {
			return true;
		} else if (root1 == null || root2 == null) {
			return false;
		} else {
			return (root1.data == root2.data && areIdentical(root1.left, root2.left)
					&& areIdentical(root1.right, root2.right));
		}
	}

	boolean isSubtree(C_Node tree, C_Node subTree) {
		if (subTree == null) {
			return true;
		} else if (tree == null) {
			return false;
		} else if (areIdentical(tree, subTree)) {
			return true;
		} else {
			return isSubtree(tree.left, subTree) || isSubtree(tree.right, subTree);
		}
	}
}

public class CheckIfBinaryTreeIsSubtreeOfAnotherBinaryTree{
	public static void main(String args[])
	{
		
		/* Construct the following tree
					  26
					/    \
				   10	  3
				   / \	   \
				  4   6	    3
				   \
					30 
		*/
		
		C_BinaryTree tree1 = new C_BinaryTree();
		tree1.root = new C_Node(26);
		tree1.root.right = new C_Node(3);
		tree1.root.right.right = new C_Node(3);
		tree1.root.left = new C_Node(10);
		tree1.root.left.left = new C_Node(4);
		tree1.root.left.left.right = new C_Node(30);
		tree1.root.left.right = new C_Node(6);

		/* Construct the following sub tree
					10
					/ \
					4  6
					\
					30 
		*/
		
		C_BinaryTree tree2 = new C_BinaryTree();
		tree2.root = new C_Node(10);
		tree2.root.right = new C_Node(6);
		tree2.root.left = new C_Node(4);
		tree2.root.left.right = new C_Node(30);

		if (tree1.isSubtree(tree1.root, tree2.root)) {
			System.out.println("Tree 2 is subtree of Tree 1 ");
		} else {
			System.out.println("Tree 2 is not a subtree of Tree 1");
		}
	}
}