package problems;

class LCA_Node {
	int data;
	LCA_Node left, right;

	LCA_Node(int item) {
		data = item;
		left = right = null;
	}
}

public class LowestCommonAncestorInBinarySearchTree {
	LCA_Node root;

	/* The function assumes that both n1 and n2 are present in BST */
	LCA_Node lca(LCA_Node LCA_Node, int n1, int n2) {
		if (LCA_Node == null)
			return null;

		/* If both n1 and n2 are smaller than root, then LCA lies in left */
		if (LCA_Node.data > n1 && LCA_Node.data > n2)
			return lca(LCA_Node.left, n1, n2);

		/* If both n1 and n2 are greater than root, then LCA lies in right */
		if (LCA_Node.data < n1 && LCA_Node.data < n2)
			return lca(LCA_Node.right, n1, n2);

		return LCA_Node;
	}

	public static void main(String args[]) {
		/*
		 				20
		 			  /	   \
		 			 8	   22
		 		   /  \	
		 		  4   12
		 			 /	\
		 			10	 14
		 */
		LowestCommonAncestorInBinarySearchTree tree = new LowestCommonAncestorInBinarySearchTree();
		tree.root = new LCA_Node(20);
		tree.root.left = new LCA_Node(8);
		tree.root.right = new LCA_Node(22);
		tree.root.left.left = new LCA_Node(4);
		tree.root.left.right = new LCA_Node(12);
		tree.root.left.right.left = new LCA_Node(10);
		tree.root.left.right.right = new LCA_Node(14);

		int n1 = 10, n2 = 14;
		LCA_Node lcaNode = tree.lca(tree.root, n1, n2);
		System.out.println("LCA of " + n1 + " and " + n2 + " is " + lcaNode.data);

		n1 = 14;
		n2 = 8;
		lcaNode = tree.lca(tree.root, n1, n2);
		System.out.println("LCA of " + n1 + " and " + n2 + " is " + lcaNode.data);

		n1 = 10;
		n2 = 22;
		lcaNode = tree.lca(tree.root, n1, n2);
		System.out.println("LCA of " + n1 + " and " + n2 + " is " + lcaNode.data);
	}
}
