import java.util.Iterator;

import edu.princeton.cs.algs4.StdOut;

public class CopyStackStrings implements Iterable<String> {
	private String[] a;
	private int N;
	public CopyStackStrings() {
		
	}
	public CopyStackStrings(int cap) {
		a =new String[cap];
	}
	public boolean isEmpty() {
		return N==0;
	}
	public int size() {
		return N;
	}
	private void resize(int max) {
		String[] temp= new String[max];
		for(int i=0;i<N;i++) {
			temp[i] =a[i];
		}
		a =temp;
	}
	public void push(String s) {
		if(	N==a.length) resize(2*a.length);
		a[N++]=s;
	}
	
	public String pop() {
		String s =a[--N];
		a[N]=null;
		if(N>0 &&(N==a.length/4)) resize(a.length/2);
		return s;
	}
	public  Iterator<String> iterator(){
		return new ReverseArrayIterator();
	}
	private class ReverseArrayIterator implements Iterator<String>{
		private int i=0;
		public boolean hasNext() {return i<N;}
		public String next() { return a[i++];}
		public void remove() {}
	}
	public CopyStackStrings copy() {
		CopyStackStrings temp =new CopyStackStrings(this.a.length);
		Iterator<String> i =this.iterator();
		while(i.hasNext()) {
			String s =i.next();
			temp.push(s);
		}
		return temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      CopyStackStrings a =new CopyStackStrings(12);
      a.push("Hello");
      a.push("World");
      CopyStackStrings b =a.copy();
      Iterator<String> i =b.iterator();
      while(i.hasNext()) {
    	  String s =i.next();
    	  StdOut.println(s);
      }
	}



}
