package problems;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

class BinaryTreeNode {
	private BinaryTreeNode left, right;
	private int data;

	public BinaryTreeNode(int data) {
		this.left = this.right = null;
		this.data = data;
	}

	public void setLeft(BinaryTreeNode left) {
		this.left = left;
	}

	public void setRight(BinaryTreeNode right) {
		this.right = right;
	}

	public BinaryTreeNode getLeft() {
		return this.left;
	}

	public BinaryTreeNode getRight() {
		return this.right;
	}

	public void setData(int data) {
		this.data = data;
	}

	public int getData() {
		return this.data;
	}
}

class BinaryTree {
	private BinaryTreeNode root;

	public BinaryTreeNode getRoot() {
		return this.root;
	}

	public void setRoot(BinaryTreeNode root) {
		this.root = root;
	}

	public boolean isEmpty() {
		return root == null;
	}

	public BinaryTreeNode insert(int data) {
		return new BinaryTreeNode(data);
	}

	public int countNodes(BinaryTreeNode node) {
		if (node == null)
			return 0;
		else {
			int count = 1;
			count += countNodes(node.getLeft());
			count += countNodes(node.getRight());
			return count;
		}
	}

	public boolean search(BinaryTreeNode node, int data) {
		if (node.getData() == data) {
			return true;
		} else if (node.getLeft() != null && search(node.getLeft(), data)) {
			return true;
		} else if (node.getRight() != null && search(node.getRight(), data)) {
			return true;
		} else {
			return false;
		}
	}

	public List<Integer> inorderTraversal(BinaryTreeNode node) {
		List<Integer> inorder = new LinkedList<>();
		if (node != null) {
			inorder.addAll(inorderTraversal(node.getLeft()));
			inorder.add(node.getData());
			inorder.addAll(inorderTraversal(node.getRight()));
		}
		return inorder;
	}

	public List<Integer> preorderTraversal(BinaryTreeNode node) {
		List<Integer> preorder = new LinkedList<>();
		if (node != null) {
			preorder.add(node.getData());
			preorder.addAll(preorderTraversal(node.getLeft()));
			preorder.addAll(preorderTraversal(node.getRight()));
			return preorder;
		}
		return preorder;
	}

	public List<Integer> postorderTraversal(BinaryTreeNode node) {
		List<Integer> postorder = new LinkedList<>();
		if (node != null) {
			postorder.addAll(postorderTraversal(node.getLeft()));
			postorder.addAll(postorderTraversal(node.getRight()));
			postorder.add(node.getData());
			return postorder;
		}
		return postorder;
	}
}

public class BinaryTreeFunctions {
	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		BinaryTree binaryTree = new BinaryTree();
		binaryTree.setRoot(binaryTree.insert(4));
		binaryTree.getRoot().setLeft(binaryTree.insert(5));
		binaryTree.getRoot().setRight(binaryTree.insert(10));
		binaryTree.getRoot().getLeft().setLeft(binaryTree.insert(7));
		binaryTree.getRoot().getLeft().setRight(binaryTree.insert(8));
		binaryTree.getRoot().getRight().setRight(binaryTree.insert(1));

		/* Display tree */
		System.out.println("In order : " + binaryTree.inorderTraversal(binaryTree.getRoot()).toString());
		System.out.println("Pre order : " + binaryTree.preorderTraversal(binaryTree.getRoot()).toString());
		System.out.println("Post order : " + binaryTree.postorderTraversal(binaryTree.getRoot()).toString());

		System.out.println("\ncount of nodes in tree: " + binaryTree.countNodes(binaryTree.getRoot()));
		System.out.println("tree is empty: " + binaryTree.isEmpty());
		System.out.println("Enter integer element to search: ");
		System.out.println("element found in tree : " + binaryTree.search(binaryTree.getRoot(), scan.nextInt()));
	}
}