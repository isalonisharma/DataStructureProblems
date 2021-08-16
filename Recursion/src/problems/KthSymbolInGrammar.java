package problems;

/**
 *  n = 1	0
 *  n = 2	0	1
 *  n = 3	0	1	1	0
 *  n = 4	0	1	1	0	1	0	0 	1
 *  
 *  k		1	2	3	4	5	6	7	8
 *  
 *  if asked for n = 4 & k = 3 meaning nth row & kth column 
 *  
 * @author saloni.sharma
 */
public class KthSymbolInGrammar {
	public static void main(String args[]) {
		System.out.println(permutationFind(4, 3));
	}

	private static int permutationFind(int n, int k) {
		if (n == 1 && k == 1) {
			return 0;
		}
		int mid = (int) Math.pow(2, n - 1) / 2;
		if (k <= mid) {
			return permutationFind(n - 1, k);
		} else {
			return permutationFind(n - 1, k - mid) == 0 ? 1 : 0;
		}
	}
}