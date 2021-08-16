package problems;

import java.util.HashMap;

class Binary_Tree_Node {
	char data;
	Binary_Tree_Node left, right;

	Binary_Tree_Node(char item) {
		data = item;
		left = right = null;
	}
}

class Binary_Tree {

	private static Binary_Tree_Node root;
	/*  store indexes of inorder traversal in a hash table. So that search can be done O(1) time */
	static HashMap<Character, Integer> mp = new HashMap<>();
	static int preIndex = 0;

	public static Binary_Tree_Node buildTree(char[] inorder, char[] preorder, int start, int end) {
		if (start > end) {
			return null;
		} else {
			/* pick node from preorder using preIndex and increment preIndex */
			char current = preorder[preIndex++];
			Binary_Tree_Node node = new Binary_Tree_Node(current);

			if (start == end) {
				/* node has no children then return */
				return node;
			} else {
				/* find the index of this node in inorder */
				int index = mp.get(current);

				/* Using index in inorder, construct left and right subtree */
				node.left = buildTree(inorder, preorder, start, index - 1);
				node.right = buildTree(inorder, preorder, index + 1, end);
				return node;
			}
		}
	}

	/* creates an unordered_map, then calls buildTree() */
	public static Binary_Tree_Node buildTreeWrap(char[] inorder, char[] preorder, int length) {
		for (int i = 0; i < length; i++) {
			mp.put(inorder[i], i);
		}
		return buildTree(inorder, preorder, 0, length - 1);
	}

	static void printInorder(Binary_Tree_Node node) {
		if (node != null) {
			printInorder(node.left);
			System.out.print(node.data + " ");
			printInorder(node.right);
		}
	}

	public static Binary_Tree_Node getRoot() {
		return root;
	}

	public static void setRoot(Binary_Tree_Node root) {
		Binary_Tree.root = root;
	}
}

public class ConstructTreeFromInorderAndPreorderEffectiveApproach {
	
	public static void main(String args[]) {
		char[] inorder = { 'D', 'B', 'E', 'A', 'F', 'C' };
		char[] preorder = { 'A', 'B', 'D', 'E', 'C', 'F' };
		int length = inorder.length;
		Binary_Tree.setRoot(Binary_Tree.buildTreeWrap(inorder, preorder, length));

		System.out.print("Inorder traversal of the constructed tree is: ");
		Binary_Tree.printInorder(Binary_Tree.getRoot());
	}
}