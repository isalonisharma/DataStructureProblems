package problems;

class C_Node {
	int data;
	C_Node left, right;

	C_Node(int data) {
		this.data = data;
		this.left = this.right = null;
	}
}

public class CeilFromBinarySearchTree {
	private C_Node root;

	int Ceil(C_Node C_Node, int input) {
		if (C_Node == null) {
			return -1;
		} else if (C_Node.data == input) {
			return C_Node.data;
		} else if (C_Node.data < input) {
			return Ceil(C_Node.right, input);
		} else {
			int ceil = Ceil(C_Node.left, input);
			return (ceil >= input) ? ceil : C_Node.data;
		}
	}

	public static void main(String[] args) {
		CeilFromBinarySearchTree tree = new CeilFromBinarySearchTree();
		tree.root = new C_Node(8);
		tree.root.left = new C_Node(4);
		tree.root.right = new C_Node(12);
		tree.root.left.left = new C_Node(2);
		tree.root.left.right = new C_Node(6);
		tree.root.right.left = new C_Node(10);
		tree.root.right.right = new C_Node(14);
		for (int i = 0; i < 16; i++) {
			System.out.println(i + " " + tree.Ceil(tree.root, i));
		}
	}
}