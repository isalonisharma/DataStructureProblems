package problems;

public class InorderSuccessorInBinarySearchTree {
	static class node {
		int data;
		node left, right;

		public node(int data) {
			super();
			this.data = data;
			this.left = this.right = null;
		}
	};

	static node minValue(node root) {
		node current = root;
		while (current.left != null) {
			current = current.left;
		}
		return current;
	}

	static node insert(node root, int data) {
		if (root == null) {
			/* 1. If the tree is empty, return a new, single node */
			return new node(data);
		} else {
			/* 2. Otherwise, recur down the tree */
			node temp;
			if (data <= root.data) {
				temp = insert(root.left, data);
				root.left = temp;
			} else {
				temp = insert(root.right, data);
				root.right = temp;
			}

			/* return the (unchanged) node pointer */
			return root;
		}
	}

	static node inOrderSuccessor(node root, node n) {
		/* case 1 node has right subtree */
		if (n.right != null) {
			return minValue(n.right);
		} else {
			/* case 2 node has no right subtree */
			node successor = null;
			while (root != null) {
				if (n.data < root.data) {
					successor = root;
					root = root.left;
				} else {
					root = root.right;
				}
			}
			return successor;
		}
	}

	public static void main(String[] args) {
		node root = null, temp, succ;
		root = insert(root, 20);
		root = insert(root, 8);
		root = insert(root, 22);
		root = insert(root, 4);
		root = insert(root, 12);
		root = insert(root, 10);
		root = insert(root, 14);
		temp = root.left.right.right;

		succ = inOrderSuccessor(root, temp);
		if (succ != null) {
			System.out.printf("Inorder Successor of %d is %d ", temp.data, succ.data);
		} else {
			System.out.printf("Inorder Successor doesn't exit");
		}
	}
}