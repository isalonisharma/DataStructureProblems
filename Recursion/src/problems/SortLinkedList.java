package problems;

public class SortLinkedList {
	static Node head;

	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public static Node reverseList(Node list) {
        // base condition
        if(list == null || list.next == null){
            return list;
        }
        
        // hypothesis
        head = list;
        Node end = reverse(list);
        
        // induction
        end.next = null;
        
        return head;
    }

    public static Node reverse(Node list) {
        // base condition
        if(list.next == null){
            head = list;
            return list;
        }
        
        // hypothesis
        Node last = reverse(list.next);
        
        // induction
        last.next = list;
        
        return list;
    }

	static void print() {
		Node movingNode = head;
		while (movingNode != null) {
			System.out.print(movingNode.data + " ");
			movingNode = movingNode.next;
		}
	}

	static void addLast(int data) {
		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
		} else {
			Node lastNode = head;
			while (lastNode.next != null) {
				lastNode = lastNode.next;
			}
			lastNode.next = newNode;
		}
	}

	public static void main(String[] args) {
		addLast(1);
		addLast(2);
		addLast(3);
		addLast(4);
		addLast(5);
		addLast(6);
		addLast(7);
		addLast(8);
		System.out.print("Original Linked List: ");
		print();
		reverseList(head);
		System.out.print("\nReversed Linked List: ");
		print();
	}
}