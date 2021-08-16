package problems;

import java.util.Stack;

/* https://www.youtube.com/watch?v=VsxLHGUqAKs */
public class InorderTreeTraversalWithoutRecursion {
	
	public static void main(String args[]) {
		IT_BinaryTree tree = new IT_BinaryTree();
		tree.root = new IT_Node(1);
		tree.root.left = new IT_Node(2);
		tree.root.right = new IT_Node(3);
		tree.root.left.left = new IT_Node(4);
		tree.root.left.right = new IT_Node(5);
		tree.inorder();
	}
}

class IT_BinaryTree {
	IT_Node root;

	void inorder() {
		if (root == null) {
			return;
		} else {
			Stack<IT_Node> stack = new Stack<>();
			IT_Node currentNode = root;

			while (currentNode != null || stack.size() > 0) {
				while (currentNode != null) {
					stack.push(currentNode);
					currentNode = currentNode.left;
				}
				currentNode = stack.pop();
				System.out.print(currentNode.data + " ");
				currentNode = currentNode.right;
			}
		}
	}
}

class IT_Node {
	int data;
	IT_Node left, right;

	public IT_Node(int item) {
		data = item;
		left = right = null;
	}
}
