package problems;

import java.util.LinkedList;
import java.util.Queue;


class CSL_Node {
	int data;
	CSL_Node left, right, nextRight;

	CSL_Node(int data) {
		this.data = data;
		this.left = this.right = this.nextRight = null;
	}
}

class CSL_BinaryTree {
	CSL_Node root;

	void connect(CSL_Node p) {
		Queue<CSL_Node> queue = new LinkedList<>();
		queue.add(root);
		CSL_Node current = null;

		while (!queue.isEmpty()) {
			
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				CSL_Node prev = current;
				current = queue.poll();

				/*
				 * i > 0 because when i is 0 prev points the last CSL_Node of previous level, so
				 * we skip it
				 */
				if (i > 0) {
					prev.nextRight = current;
				}

				if (current.left != null) {
					queue.add(current.left);
				}

				if (current.right != null) {
					queue.add(current.right);
				}
			}

			/* pointing last CSL_Node of the nth level to null */
			current.nextRight = null;
			
		}
	}
}

public class ConnectNodesAtSameLevel{
	public static void main(String args[])
	{
		CSL_BinaryTree tree = new CSL_BinaryTree();

		/* Constructed binary tree is
			        10
			       /  \
			     8     2
			    /
			   3
			   
			   10 - null
			   8 - 2 - null
			   3 - null
		 */
		tree.root = new CSL_Node(10);
		tree.root.left = new CSL_Node(8);
		tree.root.right = new CSL_Node(2);
		tree.root.left.left = new CSL_Node(3);

		tree.connect(tree.root);

		Integer a = tree.root.nextRight != null ? tree.root.nextRight.data : null;
		System.out.println(tree.root.data + " -> " + a);

		Integer b = tree.root.left.nextRight != null ? tree.root.left.nextRight.data : null;
		System.out.println(tree.root.left.data + " -> " + b);

		Integer c = tree.root.right.nextRight != null ? tree.root.right.nextRight.data : null;
		System.out.println(tree.root.right.data + " -> " + c);

		Integer d = tree.root.left.left.nextRight != null ? tree.root.left.left.nextRight.data : null;
		System.out.println(tree.root.left.left.data + " -> " + d);
	}
}