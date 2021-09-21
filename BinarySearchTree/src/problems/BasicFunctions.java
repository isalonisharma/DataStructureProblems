package problems;

public class BasicFunctions {
	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		/*
        	    50
     		  /     \
    		 30      70
   			/  \    /  \
 			20   40  60   80 
 		*/
		tree.insert(50);
		tree.insert(30);
		tree.insert(20);
		tree.insert(40);
		tree.insert(70);
		tree.insert(60);
		tree.insert(80);

		tree.inorder();

		System.out.println("\n10 present in tree: " + tree.search(10));
		System.out.println("\n80 present in tree: " + tree.search(80));

		System.out.println("\nDelete 20\n");
		tree.delete(20);
		System.out.println("Inorder traversal of the " + "modified tree");
		tree.inorder();

		System.out.println("\nDelete 30\n");
		tree.delete(30);
		System.out.println("Inorder traversal of the " + "modified tree");
		tree.inorder();

		System.out.println("\nDelete 50\n");
		tree.delete(50);
		System.out.println("Inorder traversal of the " + "modified tree");
		tree.inorder();
	}
}

class BinarySearchTree {

	class Node {
		int value;
		Node left, right;

		public Node(int value) {
			this.value = value;
			this.left = this.right = null;
		}
	}

	Node root;

	BinarySearchTree() {
		root = null;
	}

	void insert(int value) {
		root = insertNode(root, value);
	}

	Node insertNode(Node root, int value) {
		if (root == null) {
			root = new Node(value);
		} else {
			if (value < root.value) {
				root.left = insertNode(root.left, value);
			} else if (value > root.value) {
				root.right = insertNode(root.right, value);
			}
		}
		return root;
	}

	void delete(int value) {
		root = deleteNode(root, value);
	}

	Node deleteNode(Node root, int value) {
		if (root != null) {
			if (root.value > value) {
				root.left = deleteNode(root.left, value);
			} else if (root.value < value) {
				root.right = deleteNode(root.right, value);
			} else {
				/* case 1: no child */
				if (root.left == null && root.right == null) {
					root = null;
				}
				/* case 2: one child */
				else if (root.left == null) {
					root = root.right;
				} else if (root.right == null) {
					root = root.left;
				}
				/* case 3: two children */
				else {
					// (smallest in the right subtree)
					root.value = minValue(root.right);

					// Delete the successor
					root.right = deleteNode(root.right, root.value);
				}
			}
		}

		return root;
	}

	int minValue(Node root) {
		int minValue = root.value;
		while (root.left != null) {
			minValue = root.left.value;
			root = root.left;
		}
		return minValue;
	}

	void inorder() {
		inorderRec(root);
	}

	void inorderRec(Node root) {
		if (root != null) {
			inorderRec(root.left);
			System.out.println(root.value);
			inorderRec(root.right);
		}
	}

	boolean search(int value) {
		Node node = search(root, value);
		return node != null ? true : false;
	}

	Node search(Node root, int value) {
		if (root == null || root.value == value) {
			return root;
		} else if (root.value < value) {
			return search(root.right, value);
		} else {
			return search(root.left, value);
		}
	}
}