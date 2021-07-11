package problems;

import java.util.*;

public class DequeSimpleInJava {
	public static void main(String[] args) {
		Deque<String> deque = new LinkedList<String>();

		// Add at the last
		deque.add("Element 1 (Tail)");

		// Add at the first
		deque.addFirst("Element 2 (Head)");

		// Add at the last
		deque.addLast("Element 3 (Tail)");

		// Add at the first
		deque.push("Element 4 (Head)");

		// Add at the last
		deque.offer("Element 5 (Tail)");

		// Add at the first
		deque.offerFirst("Element 6 (Head)");

		System.out.println(deque + "\n");

		/*
		 * We can remove the first element or the last element mentioned only 2,
		 * 
		 * poll(): This method is used to retrieve and remove the element at the head of
		 * the deque. This method returns null if the deque is empty.
		 * Also provide: pollFirst(), pollLast()
		 * 
		 * pop() is used to remove and return the head of the deque.
		 * 
		 * However, poll() is used because this offers the same functionality as pop()
		 * and doesnt return an exception when the deque is empty.
		 */
		deque.removeFirst();
		deque.removeLast();
		System.out.println("Deque after removing " + "first and last:\n" + deque);

		System.out.println("\nAscending Iterator: ");
		for (Iterator<String> itr = deque.iterator(); itr.hasNext();) {
			System.out.print(itr.next() + " ");
		}

		System.out.println("\n\nDescending Iterator: ");
		for (Iterator<String> itr = deque.descendingIterator(); itr.hasNext();) {
			System.out.print(itr.next() + " ");
		}
	}
}