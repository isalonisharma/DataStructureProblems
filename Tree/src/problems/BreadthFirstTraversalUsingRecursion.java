package problems;

import java.util.ArrayList;
import java.util.List;

class RBTNode {
	int data;
	RBTNode left, right;

	public RBTNode(int item) {
		data = item;
		left = right = null;
	}
}

class RBreadthFirstBinaryTree {
	RBTNode root;

	public RBreadthFirstBinaryTree() {
		root = null;
	}
	
	public List<List<Integer>> levelOrder(RBTNode root) {
		List<List<Integer>> output = new ArrayList<>();
		levelOrderHelper(output, root, 0);
		return output;
	}
	
	public void levelOrderHelper(List<List<Integer>> output, RBTNode root, int level) {
		if (root == null) {
            return;
        } else {
            if (level >= output.size()) {
                output.add(new ArrayList<>());
            }   
            output.get(level).add(root.data);
            levelOrderHelper(output, root.left, level + 1);
            levelOrderHelper(output, root.right, level + 1);
        }
	}

	void printLevelOrder() {
		List<List<Integer>> output = new ArrayList<>();
		output = levelOrder(root);
		for(List<Integer> level: output) {
			for(int data: level) {
				System.out.println(data + " ");
			}
			System.out.println();
		}
	}
}

public class BreadthFirstTraversalUsingRecursion {
	
	public static void main(String args[]) {
		RBreadthFirstBinaryTree tree = new RBreadthFirstBinaryTree();
		tree.root = new RBTNode(1);
		tree.root.left = new RBTNode(2);
		tree.root.right = new RBTNode(3);
		tree.root.left.left = new RBTNode(4);
		tree.root.left.right = new RBTNode(5);

		System.out.print("level order traversal of binary tree is:\n");
		tree.printLevelOrder();
	}
}