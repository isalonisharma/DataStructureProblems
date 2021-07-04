package problems;

public class TwoStackTwoEndsSpaceEfficient {
	public static void main(String[] args) {
		TwoStackEfficient obj = new TwoStackEfficient(10);
		obj.push1(10);
		obj.push1(20);
		obj.push1(30);
		
		obj.push2(100);
		obj.push2(90);
		obj.push2(80);
		obj.push2(70);
		obj.push2(60);
		obj.push2(50);
		
		obj.print();
		System.out.println("\n" + obj.pop1());
		System.out.println(obj.pop1());
		System.out.println(obj.pop2());
		System.out.println(obj.pop2());
		obj.print();
	}
}

class TwoStackEfficient {
	int size;
	int top1, top2;
	int[] arr;

	void print() {
		System.out.println("Stack: ");
		for (int i : arr) {
			System.out.print(i + " ");
		}
	}

	TwoStackEfficient(int size) {
		arr = new int[size];
		this.size = size;
		top1 = -1;
		top2 = size;
	}

	void push1(int data) {
		if (top1 + 1 > top2) {
			System.out.println("Overflow");
		} else {
			top1++;
			arr[top1] = data;
		}
	}

	void push2(int data) {
		if (top2 - 1 < top1) {
			System.out.println("overflow");
		} else {
			top2--;
			arr[top2] = data;
		}
	}

	int pop1() {
		int data = 0;
		if (top1 < 0) {
			System.out.println("underflow");
		} else {
			data = arr[top1];
			top1--;
		}
		return data;
	}

	int pop2() {
		int data = 0;
		if(top2>size-1) {
			System.out.println("underflow");
		} else {
			data = arr[top2];
			top2++;
		}
		return data;
	}
}
