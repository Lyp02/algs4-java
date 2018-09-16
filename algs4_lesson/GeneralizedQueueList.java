import edu.princeton.cs.algs4.StdOut;

public class GeneralizedQueueList<Item> {
	public Node<Item> first;
	public Node<Item> last;
	public int N;
	private class Node<Item>{
		public Node next;
		public Item item;
	public Node(Item item) {
		this.item=item;
		this.next=null;
	}	
	}
	
	public GeneralizedQueueList() {
		first=null;
		last=null;
		N=0;
	}
	
	public boolean isEmpty() {
		return N==0;
	}
	public void insert(Item x) {
		if(first ==last) {
			if(first==null) {
				first =new Node(x);
				last=first;
				N++;
			}
			else {
				last.next=new Node(x);
				last =last.next;
				N++;
			}
		}
		else {
			last.next =new Node(x);
			last =last.next;
			N++;
		}
	}
	
	public Item delete(int k) {
		if((k>N)||(k<=0)||(N==0))
			return null;
		if(k==1) {
			Node temp =first;
			first =first.next;
			last =first;
			N--;
			return (Item) temp.item;
		}
		else {
			 Node x;
			 int counts=1;
			 for(x=first;x!=null;x=x.next) {
				 if(counts ==k-1) break;
				 counts++;
			 }
			 Node temp=x.next;
			 x.next=x.next.next;
			 N--;
			 return (Item) temp.item;
		}
			
		}
	public void ergodic() {
		if(first ==null) return;
		Node x;
		StdOut.println();
		for(x=first;x!=null;x=x.next)
			StdOut.print(" "+x.item );
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GeneralizedQueueList<String> a =new GeneralizedQueueList<String>();
		a.insert(""+0);
		a.insert(""+1);
		a.insert(""+2);
		a.insert(""+3);
		a.insert(""+4);
		a.insert(""+5);
		a.insert(""+6);
		a.insert(""+7);
		a.delete(1);
		a.delete(5);
		a.ergodic();

	}

}
