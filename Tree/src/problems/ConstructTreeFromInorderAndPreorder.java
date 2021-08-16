package problems;

class Node {
	char data;
	Node left, right;

	Node(char item) {
		data = item;
		left = right = null;
	}
}

class MyBinaryTree {
	Node root;
	static int preIndex = 0;

	Node buildTree(char inorder[], char preorder[], int start, int end) {
		if (start > end) {
			return null;
		} else {
			/* pick each node from preorder of position preIndex(static) and increment it */
			Node root = new Node(preorder[preIndex++]);

			/* if this node has no children then return */
			if (start == end) {
				return root;
			} else {
				/* else find the index of this node in inorder traversal */
				int dataIndex = search(inorder, start, end, root.data);

				/* using index in inorder traversal, construct left and right subtree */
				root.left = buildTree(inorder, preorder, start, dataIndex - 1);
				root.right = buildTree(inorder, preorder, dataIndex + 1, end);

				return root;
			}
		}
	}

	int search(char charArray[], int startingPosition, int endingPosition, char charSearch) {
		int i;
		for (i = startingPosition; i <= endingPosition; i++) {
			if (charArray[i] == charSearch) {
				return i;
			}
		}
		return i;
	}

	void printInorder(Node node) {
		if (node == null) {
			return;
		} else {
			printInorder(node.left);
			System.out.print(node.data + " ");
			printInorder(node.right);
		}
	}
}

public class ConstructTreeFromInorderAndPreorder {
	public static void main(String args[]) {
		MyBinaryTree tree = new MyBinaryTree();
		char inorder[] = new char[] { 'D', 'B', 'E', 'A', 'F', 'C' };
		char preorder[] = new char[] { 'A', 'B', 'D', 'E', 'C', 'F' };
		int length = inorder.length;
		Node root = tree.buildTree(inorder, preorder, 0, length - 1);
		System.out.println("Inorder traversal of constructed tree is : ");
		tree.printInorder(root);
	}
}