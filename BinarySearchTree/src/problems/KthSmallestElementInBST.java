package problems;

class K_Node {
	int data;
	K_Node left, right;

	K_Node(int x) {
		data = x;
		left = right = null;
	}
}

public class KthSmallestElementInBST {
	static int count = 0;

	public static K_Node insert(K_Node root, int x) {
		if (root == null) {
			return new K_Node(x);
		} else if (x < root.data) {
			root.left = insert(root.left, x);
		} else if (x > root.data) {
			root.right = insert(root.right, x);
		}
		return root;
	}

	public static K_Node kthSmallest(K_Node root, int k) {
		if (root == null) {
			return null;
		} else {
			K_Node left = kthSmallest(root.left, k);
			if (left != null) {
				return left;
			}
			count++;
			return count == k ? root : kthSmallest(root.right, k);
		}
	}

	public static void printKthSmallest(K_Node root, int k) {
		count = 0;
		K_Node res = kthSmallest(root, k);
		if (res == null) {
			System.out.println("There are less " + "than k K_Nodes in the BST");
		} else {
			System.out.println(k + " Smallest" + " Element is " + res.data);
		}
	}

	public static void main(String[] args) {
		K_Node root = null;
		int keys[] = { 20, 8, 22, 4, 12, 10, 14 };

		for (int x : keys) {
			root = insert(root, x);
		}

		int k = 3;
		printKthSmallest(root, k);
	}
}