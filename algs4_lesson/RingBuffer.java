import edu.princeton.cs.algs4.StdOut;

public class RingBuffer<Item> {
	public Item[] a;
	public int first;
	public int last;
	public int N;
	public RingBuffer(int cap){
		this.N=0;
		a=(Item[])(new Object[cap]);
		first=0;
		last=0;
		
	}
	public  boolean isEmpty() {
		return N==0;
	}
	public boolean isFull() {
		return N==a.length;
	}
	public boolean produce(Item item) {
		if(isFull()) 
			{
			StdOut.println("Buffer is Full ,Consumer need");
			return false;
			}
		if(first == last) {
			if(N==0) {
				a[first]=item;
				N++;
				return true;
			}
			else {
				last =(last+1)%(a.length);
				a[last]=item;
				N++;
				return true;
			}
		}
		else {
			last =(last+1)%(a.length);
			a[last]=item;
		    N++;
		    return true;
		
		}
		}
   public boolean consume() {
	   if(isEmpty()) {
		   StdOut.println("Buffer is Empty,Producer need");
		   return false;
	   }
	   if(first ==last) {
		   StdOut.println(" "+a[first]);
		   a[first]=null;
		   N--;
		   return true;
	   }
	   else {
		   StdOut.println(" "+a[first]);
		   a[first]=null;
		   first=(first+1)%a.length;
		   N--;
		   return true;
	   }
   }
   
   public void ergodic() {
	   StdOut.println(" Ergodic");
	   for(int i=first;i<first+N-1;i++)
		   StdOut.print(a[first%a.length]);
   }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
