import java.util.Iterator;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class RandomBag<Item> implements Iterable<Item> {
	public Item [] a;
	public int N;
	public RandomBag(int cap) {
		a =(Item[])new Object[cap];
		N=0;
	}
	public boolean isEmpty() {
		return N>0;
	}
	public int  size() {
		return N;
	}
	
	public void add(Item item) {
		a[N++] =item;
	}
	public Iterator<Item> iterator(){
		return new RandomBagIterator();
	}
	private class RandomBagIterator implements Iterator<Item>{
		private int i=N;

		public RandomBagIterator() {
			for(int i=0;i<N;i++) {
				Item temp = a[i];
				int k =StdRandom.uniform(i+1);
				a[i]=a[k];
				a[k]=temp;
			}
		}
		public boolean hasNext() {
			return i>0;
		}
		public Item next() {
			return a[--i];
			
		}
		public void remove() {}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        RandomBag<String> bag =new RandomBag<String>(200);
        bag.add("Hello");
        bag.add("World");
        bag.add("Java");
        Iterator<String> i =bag.iterator();
        while(i.hasNext()) {
        	String s =i.next();
        	StdOut.println(s);
        }
	}

}
