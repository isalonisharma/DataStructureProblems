package problems;

import java.util.ArrayList;

public class JosephusProblem {
	public static void main(String args[]) {
		JosephusProblem josephusProblem = new JosephusProblem();
		System.out.println(josephusProblem.findTheWinner(40, 7));
	}

	public int findTheWinner(int n, int k) {
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			list.add(i + 1);
		}

		permutationFind(n, k - 1, 0, list);
		return ans;
	}
	
	int ans = -1;

	public void permutationFind(int n, int k, int index, ArrayList<Integer> list) {
		if (n == 1) {
			ans = list.get(0);
			return;
		}

		index = (index + k) % list.size();
		list.remove(index);

		permutationFind(n - 1, k, index, list);
	}
}