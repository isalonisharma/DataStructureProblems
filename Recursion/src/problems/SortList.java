package problems;

import java.util.ArrayList;
import java.util.List;

public class SortList {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(0);
		list.add(5);
		list.add(2);
		list = sort(list);
		list.forEach(i -> System.out.println(i));
	}

	private static List<Integer> sort(List<Integer> list) {
		// base condition
		if (list.size() == 1) {
			return list;
		}

		// hypothesis
		Integer lastValue = list.get(list.size() - 1);
		list.remove(list.size() - 1);
		list = sort(list);

		// induction
		return insert(list, lastValue);
	}

	private static List<Integer> insert(List<Integer> list, int temp) {
		// base condition
		if (list.isEmpty() || temp >= list.get(list.size() - 1)) {
			list.add(temp);
			return list;
		}
		
		// hypothesis
		int lastValue = list.get(list.size() - 1);
		list.remove(list.size() - 1);
		list = insert(list, temp);
		
		// induction
		list.add(lastValue);
		return list;
	}
}