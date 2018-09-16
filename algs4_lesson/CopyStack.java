import java.util.Iterator;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

public class CopyStack<Item> {
    Stack<Item> s;
    public CopyStack(Stack<Item> r){
      Stack<Item> temp =new Stack();
      s =new Stack();
      int count =r.size();
      while(count>0) {
    	  temp.push(r.pop());
    	  count--;
      }
      while(temp.size()>0) {
    	  Item a = temp.pop();
    	  s.push(a);
    	  r.push(a);
      }
      
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<String> r =new Stack();
		r.push("Hello");
		r.push("World");
		CopyStack<String> cp =new CopyStack<>(r);
        Iterator<String> i=cp.s.iterator();
        StdOut.println("s:");
        while(i.hasNext()) {
        	StdOut.print("  "+i.next());
        }
        StdOut.println();
        i=r.iterator();
        StdOut.println("r");
        while(i.hasNext()) {
        	StdOut.print(" "+i.next());
        }
        
     
	}

}
