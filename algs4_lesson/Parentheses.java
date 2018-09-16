import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Parentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    Stack<String> left =new Stack<String>();
    boolean matchBit =true;
    Stack<Integer> stack =new Stack<Integer>();
    int N=50;
    while(N>0) {
    	stack.push(N%2);
    	N=N/2;
    }
    for(int d: stack) StdOut.print(d);
    StdOut.println();
    while(!StdIn.isEmpty()) {
    	String s =StdIn.readString();
    	if(s.equals("(")) left.push(s);
    	else if(s.equals("[")) left.push(s);
    	else if(s.equals("{")) left.push(s);
    	else if(s.equals(")")) matchBit=left.pop().equals("(");
    	else if(s.equals("]")) matchBit=left.pop().equals("[");
    	else if(s.equals("}")) {matchBit=left.pop().equals("{");}
    	else matchBit =false;
    	if(!matchBit) {
    		StdOut.println("unmatched");
    		return;
    	}
    		
    }
    StdOut.println("matched");
    
    
	}

}
