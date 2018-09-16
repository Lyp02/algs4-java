import java.util.Iterator;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class RandomQueue<Item> implements Iterable<Item> {
	public Item[] a;
	public int first;
	public int last;
	public int N;
	public RandomQueue(int cap) {
		a =(Item[])(new Object[cap]);
		first=0;
		last=0;
		N=0;
	}
	
	public boolean isEmpty() {
		return !(N>0);
	}
	
	public void resize(int cap) {
		Item[] b =(Item[])(new Object[cap]);
		for(int i=0;i<N;i++) {
			b[i]=a[first+i];
		}
		a=b;
		
	}
	public void enqueue(Item  item) {
		if((first == last)&&(a[first]==null) ) {
			a[first] =item;
			N++;
			return;
		}else {
			if(N==a.length) 
				resize(2*a.length);
			a[++last]=item;
			N++;
			return;
		}
	}
	public Item dequeue() {
		if(N==0) {
			StdOut.println("Empty Queue");
		}
		int index =StdRandom.uniform(N);
		Item temp =a[index];
		a[index]=a[N-1];
		a[N-1]=temp;
		a[--N]=null;
		if(N==a.length/4)
			resize(a.length/2);
		return temp;
		
	}
	public Item sample() {
		int index =StdRandom.uniform(N);
		return a[index];
	}
	public void ergodic() {
		for(int i=first;i<N;i++) {
			StdOut.print(" "+a[i]);
		}
		StdOut.println();
		
	}
	
	public Iterator<Item> iterator(){
		return new RandomQueueIterator();
	}
	
	public class RandomQueueIterator implements Iterator<Item>{
		public int i=N;
		public Item[] b;
        public RandomQueueIterator() {
        	i =N;
        	 b =(Item[])(new Object[N]);
    		for(int j=0;j<N;j++) {
    			b[j]=a[first+j];
    		}
        }
		public boolean hasNext() {
			return i>0;
		}
		public Item next() {

			int index =StdRandom.uniform(i);
			Item temp =b[index];
			b[index]=b[i-1];
			b[i-1]=temp;
			b[--i]=null;
			return temp;
		  
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RandomQueue<String> q =new RandomQueue<>(52);
		Object[] b =(Object[]) q.a;
		StdOut.println(b.length);
		String[] category = {"hearts","spades","diamonds","clubs"};
		String[] nums = {"A","1","2","3","4","5","6","7","8","9","10","J","Q","K"};
		for(int i=1;i<=b.length;i++) {
				q.enqueue(""+category[(i-1)/13]+" "+ nums[(i-1)%13]);
		}
		RandomQueue<String> card0 = new RandomQueue<>(13);
		RandomQueue<String> card1 = new RandomQueue<>(13);
		RandomQueue<String> card2 = new RandomQueue<>(13);
		RandomQueue<String> card3 = new RandomQueue<>(13);
		
		
		for(int i=0;i<13;i++) {
		  card0.enqueue(q.dequeue());
		  card1.enqueue(q.dequeue());
		  card2.enqueue(q.dequeue());
		  card3.enqueue(q.dequeue());
	
		}
		card0.ergodic();
		card1.ergodic();
		card2.ergodic();
		card3.ergodic();

	    Iterator<String> i = card0.iterator();
	    int counts =0;
	    while(i.hasNext()) {
	    	StdOut.print( i.next());
	    	counts ++;
	    	if(counts %13 ==0)
	    		StdOut.println();
	    	
	    }
	
	}
	
	

}
