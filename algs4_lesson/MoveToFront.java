import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class MoveToFront {
	public Node first;
	public void insertFirst(char a) {
		if(first ==null) {
			first =new Node(a);
			first.next=null;
		return;
		}else {
			Node oldfirst =first;
			first =new Node(a);
			first.next =oldfirst;
			return;
		}
	}

	public void repeatJudge( char a) {
		if(first ==null) {
			insertFirst(a);
			return;
		}
		else if(first.item ==a) {
			return;
		}
		
		else {
			Node x;
			for(x=first;x.next!=null;x=x.next){
				if(x.next.item == a) break;
			}
			if(x.next ==null) {
				x.next =new Node(a);
				x.next.next=null;
				return;
			}
			x.next=x.next.next;
			insertFirst(a);
		}
		
	}
	public void readChar() {
		while(!StdIn.isEmpty()) {
			char a =StdIn.readChar();
			repeatJudge(a);
		}
		return;
	}
	public void ergodic() {
		Node x;
		StdOut.println("Ergodic");
		for(x=first;x!=null;x=x.next) {
			StdOut.print("  "+x.item);
		}
	}
	private class Node{
		public Node next;
		public char item;
		public Node(char item) {
			this.item =item;
			this.next=null;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       MoveToFront m =new MoveToFront();
       m.readChar();
       m.ergodic();
	}

}
