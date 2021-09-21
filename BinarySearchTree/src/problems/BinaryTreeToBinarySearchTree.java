package problems;

import java.util.ArrayList;
import java.util.Collections;

public class BinaryTreeToBinarySearchTree {

	static class Node {
		int data;
		Node left, right;
		
		public Node(int data) {
			super();
			this.data = data;
			this.left = this.right = null;
		}
	};

	static int index;

	public static void main(String args[]) {
		Node root = null;
		/* 	10
			/ \
		   30 15
		   / \
		  20  5 */
		root = new Node(10);
		root.left = new Node(30);
		root.right = new Node(15);
		root.left.left = new Node(20);
		root.right.right = new Node(5);

		binaryTreeToBST(root);

		System.out.print("Inorder Traversal of Converted BST: ");
		printInorder(root);
	}
	
	static void binaryTreeToBST(Node root) {
		if (root != null) {
			ArrayList<Integer> traversalList = new ArrayList<>();

			storeInorder(root, traversalList);
			Collections.sort(traversalList);

			index = 0;
			arrayToBST(traversalList, root);
		}
	}

	static void storeInorder(Node node, ArrayList<Integer> traversalList) {
		if (node != null) {
			storeInorder(node.left, traversalList);

			traversalList.add(node.data);
			index++;

			storeInorder(node.right, traversalList);
		}
	}

	static void arrayToBST(ArrayList<Integer> traversalList, Node root) {
		if (root != null) {
			arrayToBST(traversalList, root.left);
			root.data = traversalList.get(index++);
			arrayToBST(traversalList, root.right);
		}
	}

	static void printInorder(Node node) {
		if (node != null) {
			printInorder(node.left);
			System.out.print(node.data + " ");
			printInorder(node.right);
		}
	}
}