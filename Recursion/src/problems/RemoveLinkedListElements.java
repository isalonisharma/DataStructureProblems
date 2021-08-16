package problems;

public class RemoveLinkedListElements {
	static Node removeLinkedListElementsHead;

	static class Node {
		int val;
		Node next;

		Node(int val) {
			this.val = val;
			this.next = null;
		}
	}

	public static Node removeElements(Node head, int val) {
        if(head == null){
            return head;
        } 
        else if(head.next == null){
            if(head.val == val){
                return null;
            } else{
                return head;
            }
        }
        else {
            // base condition
            while(head.val == val){
                head = head.next;
                if(head == null) {
                	return null;
                }
            } 
            
            // hypothesis
            Node res = removeElements(head.next, val);

            // induction
            if(head != null){
               head.next = res; 
            }

            return head; 
        }
	}

	static void print() {
		Node movingNode = removeLinkedListElementsHead;
		while (movingNode != null) {
			System.out.print(movingNode.val + " ");
			movingNode = movingNode.next;
		}
	}

	static void addLast(int data) {
		Node newNode = new Node(data);
		if (removeLinkedListElementsHead == null) {
			removeLinkedListElementsHead = newNode;
		} else {
			Node lastNode = removeLinkedListElementsHead;
			while (lastNode.next != null) {
				lastNode = lastNode.next;
			}
			lastNode.next = newNode;
		}
	}

	public static void main(String[] args) {
		addLast(1);
		addLast(1);
		addLast(1);
		addLast(1);
		System.out.print("Original Linked List: ");
		print();
		removeElements(removeLinkedListElementsHead, 1);
		System.out.print("\nReversed Linked List: ");
		print();
	}
}