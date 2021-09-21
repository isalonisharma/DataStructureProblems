package problems;

import java.util.ArrayList;

class Merge_Node {
	int data;
	Merge_Node left, right;

	Merge_Node(int data) {
		this.data = data;
		this.left = this.right = null;
	}
}

public class MergeTwoBalancedBinarySearchTrees {
	Merge_Node root = null;

	public static void main(String[] args) {
		MergeTwoBalancedBinarySearchTrees tree1 = new MergeTwoBalancedBinarySearchTrees();
		tree1.root = new Merge_Node(100);
		tree1.root.left = new Merge_Node(50);
		tree1.root.right = new Merge_Node(300);
		tree1.root.left.left = new Merge_Node(20);
		tree1.root.left.right = new Merge_Node(70);

		MergeTwoBalancedBinarySearchTrees tree2 = new MergeTwoBalancedBinarySearchTrees();
		tree2.root = new Merge_Node(80);
		tree2.root.left = new Merge_Node(40);
		tree2.root.right = new Merge_Node(120);

		MergeTwoBalancedBinarySearchTrees mergedTree = new MergeTwoBalancedBinarySearchTrees();
		mergedTree.root = mergedTree.mergeTrees(tree1.root, tree2.root);
		System.out.print("Inorder Traversal of Merged BST: ");
		mergedTree.inorder(mergedTree.root);
	}

	Merge_Node mergeTrees(Merge_Node node1, Merge_Node node2) {
		ArrayList<Integer> list1 = new ArrayList<>();
		storeInorder(node1, list1);
		ArrayList<Integer> list2 = new ArrayList<>();
		storeInorder(node2, list2);
		ArrayList<Integer> list3 = merge(list1, list2);
		return arrayListToBST(list3, 0, list3.size() - 1);
	}

	void storeInorder(Merge_Node node, ArrayList<Integer> list) {
		if (node != null) {
			storeInorder(node.left, list);
			list.add(node.data);
			storeInorder(node.right, list);
		}
	}

	ArrayList<Integer> merge(ArrayList<Integer> list1, ArrayList<Integer> list2) {
		ArrayList<Integer> list3 = new ArrayList<>();
		int list1Size = list1.size(), list2Size = list2.size(), i = 0, j = 0;

		while (i < list1Size && j < list2Size) {
			list3.add(list1.get(i) < list2.get(j) ? list1.get(i++) : list2.get(j++));
		}

		while (i < list1Size) {
			list3.add(list1.get(i++));
		}

		while (j < list2Size) {
			list3.add(list2.get(j++));
		}

		return list3;
	}

	Merge_Node arrayListToBST(ArrayList<Integer> list, int start, int end) {
		if (start > end) {
			return null;
		} else {
			int mid = (start + end) / 2;
			Merge_Node node = new Merge_Node(list.get(mid));
			node.left = arrayListToBST(list, start, mid - 1);
			node.right = arrayListToBST(list, mid + 1, end);
			return node;
		}
	}

	void inorder(Merge_Node node) {
		if (node != null) {
			inorder(node.left);
			System.out.print(node.data + " ");
			inorder(node.right);
		}
	}
}