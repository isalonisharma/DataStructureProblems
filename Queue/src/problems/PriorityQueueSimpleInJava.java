package problems;

import java.util.*;

public class PriorityQueueSimpleInJava {

	public static void main(String args[]) {
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
		priorityQueue.add(10);
		priorityQueue.add(20);
		priorityQueue.add(15);

		System.out.println("priority queue: " + priorityQueue);
		System.out.println("peek value: " + priorityQueue.peek());
		System.out.println("poll value: " + priorityQueue.poll());

		System.out.println("priority queue: " + priorityQueue);
		System.out.println("peek value: " + priorityQueue.peek());
	}
}