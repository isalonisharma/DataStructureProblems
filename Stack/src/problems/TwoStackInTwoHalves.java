package problems;

public class TwoStackInTwoHalves
{
	public static void main(String[] args) {
		twoStack obj = new twoStack(10);
		obj.push1(10);
		obj.push1(20);
		obj.push1(30);
		
		obj.push2(100);
		obj.push2(90);
		obj.push2(80);
		obj.push2(70);
		obj.push2(60);
		
		obj.print();
		System.out.println("\n" + obj.pop1());
		System.out.println(obj.pop1());
		System.out.println(obj.pop2());
		System.out.println(obj.pop2());
		obj.print();
	}
}
class twoStack{
    int n;
    int top1, top2;
    int[] arr;
    
    void print(){
    	System.out.println("");
        for(int i: arr){
            System.out.print(i + " ");
        }
    }
    
    twoStack(int n){
        this.n = n;
        arr = new int[n];
        top1 = -1;
        top2 = n/2 - 1;
    }
    
    void push1(int data){
        if(top1>=(n/2)){
            System.out.println("overflow");
        } else{
            top1++;
            arr[top1] = data;
        }
    }
    
    void push2(int data){
        if(top2>=(n-1)){
            System.out.println("overflow");
        } else{
            top2++;
            arr[top2] = data;
        }
    }
    
    int pop1(){
        int data = 0;
        if(top1<0){
            System.out.println("underflow");
        } else{
            data = arr[top1];
            top1--;
        }
        return data;
    }
    
    int pop2(){
        int data = 0;
        if(top2<=n/2){
            System.out.println("underflow");
        } else {
            data = arr[top2];
            top2--; 
        }
        return data;
    }
}