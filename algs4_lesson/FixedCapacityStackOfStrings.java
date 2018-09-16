import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class FixedCapacityStackOfStrings {
	private String[] a;
	private int N;
	public FixedCapacityStackOfStrings(int cap) {
		a = new String[cap];
	}
	public boolean isEmpty() {
		return N==0;
	}
	public int size() {
		return N;
	}
	public void push(String item) {
		a[N++]=item;
	}
	public String pop() {
		return a[--N];
	}
    public boolean isFull() {
    	return N==a.length-1;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FixedCapacityStackOfStrings s;
		s =new FixedCapacityStackOfStrings(100);
		while(!StdIn.isEmpty()) {
			String item =StdIn.readString();
			if(!item.equals("-"))
				s.push(item);
			else if(!s.isEmpty()) StdOut.print(s.pop()+"");
		}
		StdOut.println("("+s.size()+" left on stack )");

	}

}
