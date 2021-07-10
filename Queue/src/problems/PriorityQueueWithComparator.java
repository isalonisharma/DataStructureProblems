package problems;

import java.util.*;

class Student {
	public String name;
	public double cgpa;

	public Student(String name, double cgpa) {

		this.name = name;
		this.cgpa = cgpa;
	}

	public String getName() {
		return name;
	}
}

class StudentComparator implements Comparator<Student> {
	public int compare(Student s1, Student s2) {
		if (s1.cgpa < s2.cgpa)
			return 1;
		else if (s1.cgpa > s2.cgpa)
			return -1;
		return 0;
	}
}

public class PriorityQueueWithComparator {
	public static void main(String[] args) {
		PriorityQueue<Student> pq = new PriorityQueue<Student>(5, new StudentComparator());
		Student student1 = new Student("Nandini", 3.2);
		pq.add(student1);
		Student student2 = new Student("Anmol", 3.6);
		pq.add(student2);
		Student student3 = new Student("Palak", 4.0);
		pq.add(student3);
		System.out.println("Students served in their priority order getting removed from queue: ");
		while (!pq.isEmpty()) {
			System.out.println(pq.poll().getName());
		}
	}
}