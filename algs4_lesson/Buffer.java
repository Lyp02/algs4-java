import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

public class Buffer<Character> {
    Stack<Character> stackA;
    Stack<Character> stackB;
    int N;
    public int size() {
    	return N;
    }
    public Buffer() {
    	stackA =new Stack();
    	stackB =new Stack();
    	N=0;
    }
    public void insert(Character c) {
    	stackA.push(c);
    	N++;
    }
    public Character delete() {
    	N--;
    	return stackA.pop();
    	
    }
    public void left(int k) {
    	if(stackA.size()<k) {
    		StdOut.println("Error");
    		return;
    	}
    	else {
    		for(int i=0;i<k;i++)
    		{
    		
    			stackB.push(stackA.pop());
    		}
    	}
    }
    public void right(int k) {
    	if(stackB.size()<k) {
    		StdOut.println("Error");
    		return;
    	}
    	else {
    		for(int i=0;i<k;i++)
    		{
    		stackA.push(stackB.pop());
    		}
    	}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
