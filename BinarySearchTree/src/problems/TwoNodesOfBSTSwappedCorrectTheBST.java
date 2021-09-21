package problems;

class S_Node {
	int data;
	S_Node left, right;

	S_Node(int data) {
		this.data = data;
		this.left = this.right = null;
	}
}

public class TwoNodesOfBSTSwappedCorrectTheBST {
	S_Node first, middle, last, prev;

	/*
	 * This function does in-order traversal to find out the two swapped S_Nodes. It
	 * sets three pointers, first, middle and last. If the swapped S_Nodes are
	 * adjacent to each other, then first and middle contain the resultant S_Nodes
	 * Else, first and last contain the resultant S_Nodes
	 */
	void correctBSTUtil(S_Node root) {
		if (root != null) {
			correctBSTUtil(root.left);
			if (prev != null && root.data < prev.data) {
				if (first == null) {
					first = prev;
					middle = root;
				} else {
					last = root;
				}
			}
			prev = root;
			correctBSTUtil(root.right);
		}
	}

	void correctBST(S_Node root) {
		first = middle = last = prev = null;
		correctBSTUtil(root);

		/* Fix (or correct) the tree */
		if (first != null && last != null) {
			int temp = first.data;
			first.data = last.data;
			last.data = temp;
		}
		/* Adjacent S_Nodes swapped */
		else if (first != null && middle != null) {
			int temp = first.data;
			first.data = middle.data;
			middle.data = temp;
		}
		/* else passed tree is already BST. */
	}

	void printInorder(S_Node S_Node) {
		if (S_Node == null)
			return;
		printInorder(S_Node.left);
		System.out.print(" " + S_Node.data);
		printInorder(S_Node.right);
	}

	public static void main(String[] args) {
		/*   6
        	/ \
       	   10  2
      	   / \ / \
     	  1  3 7 12
     
    	10 and 2 are swapped
		
		*/
		S_Node root = new S_Node(6);
		root.left = new S_Node(10);
		root.right = new S_Node(2);
		root.left.left = new S_Node(1);
		root.left.right = new S_Node(3);
		root.right.right = new S_Node(12);
		root.right.left = new S_Node(7);

		System.out.println("Inorder Traversal" + " of the original tree");
		TwoNodesOfBSTSwappedCorrectTheBST tree = new TwoNodesOfBSTSwappedCorrectTheBST();
		tree.printInorder(root);

		tree.correctBST(root);

		System.out.println("\nInorder Traversal" + " of the fixed tree");
		tree.printInorder(root);
	}
}