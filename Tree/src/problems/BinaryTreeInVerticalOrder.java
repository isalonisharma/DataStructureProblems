package problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

class VNode {
	int data;
	VNode left;
	VNode right;

	VNode(int data) {
		this.data = data;
		this.left = this.right = null;
	}
}

public class BinaryTreeInVerticalOrder {
	VNode root;

	class Values {
		int maximum, minimum;
	}

	public static void main(String[] args) {
		BinaryTreeInVerticalOrder tree = new BinaryTreeInVerticalOrder();

		tree.root = new VNode(1);
		tree.root.left = new VNode(2);
		tree.root.right = new VNode(3);
		tree.root.left.left = new VNode(4);
		tree.root.left.right = new VNode(5);
		tree.root.right.left = new VNode(6);
		tree.root.right.right = new VNode(7);
		tree.root.right.left.right = new VNode(8);
		tree.root.right.right.right = new VNode(9);

		/*
				  1
		        /    \ 
		       2      3
		      / \   /   \
		     4   5  6   7
		               /  \ 
		              8   9 
		 */

		System.out.println("Vertical Order Traversal Of Tree: ");
		tree.verticalOrder(tree.root);
	}

	public void verticalOrder(VNode root) {
		Values defaultEmptyValues = new Values();
		int defaultHorizontalDistanceOfRoot = 0;
		Map<Integer, List<Integer>> map = new TreeMap<>();
		findHorizonatalDistance(root, defaultEmptyValues, defaultEmptyValues, defaultHorizontalDistanceOfRoot, map);
		for (List<Integer> list : map.values()) {
			System.out.println(list);
		}
	}

	public void findHorizonatalDistance(VNode node, Values minimumValues, Values maximumValues, int horizontalDistance,
			Map<Integer, List<Integer>> map) {
		if (node != null) {
			if (horizontalDistance < minimumValues.minimum) {
				minimumValues.minimum = horizontalDistance;
			}
			if (horizontalDistance > maximumValues.maximum) {
				maximumValues.maximum = horizontalDistance;
			}
			map.computeIfAbsent(horizontalDistance, k -> new ArrayList<Integer>()).add(node.data);
			findHorizonatalDistance(node.left, minimumValues, maximumValues, horizontalDistance - 1, map);
			findHorizonatalDistance(node.right, minimumValues, maximumValues, horizontalDistance + 1, map);
		}
	}
}