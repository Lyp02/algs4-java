import java.util.Iterator;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Transaction;

public class MaxPQ<Key extends Comparable<Key>> implements Iterator<Key>{
    private Key[] pq;
    private int N=0;
    public MaxPQ(int maxN){
    	pq =(Key[]) new Comparable[maxN+1];
    }
    public boolean isEmpty(){
    	return N==0;
    }
    public int size(){
    	return N;
    }
    public void insert(Key v){
    	pq[++N]=v;
    	swim(N);
    }
    public Key delMax(){
    	Key max =pq[1];
    	exch(1,N--);
    	pq[N+1]=null;
    	sink(1);
    	return max;
    }
    private boolean less(int i,int j){
    	return pq[i].compareTo(pq[j])<0;
    }
    private void exch(int i,int j){
    	Key t =pq[i];
    	pq[i]=pq[j];
    	pq[j]=t;
    }
    public void swim(int k){
    	while(k>1&&less(k/2,k)){
    		exch(k/2,k);
    		k=k/2;
    	}
    }
    private void sink(int k){
    	while(2*k<=N){
    		int j=2*k;
    		if(j<N&&less(j,j+1)) j++;//find the max children node
    		if(!less(k,j)) break;    //father node compare with children node
    		exch(k,j);
    		k=j;
    	}
    }
    public Iterator<Key> iterator(){
    	return new MaxPQIterator();
    }
    private class MaxPQIterator implements Iterator<Key>{
    	private int index=1;
    	public boolean hasNext(){
    		return index<=N;
    	}
    	public Key next(){
    		return pq[index++];
    	}
    	public void remove(){}
    }
    
    public MaxPQ<Key> copy(){
    	MaxPQ<Key> temp =new MaxPQ<Key>(pq.length-1);
    	temp.N=this.N;
    	for(int i=1;i<=this.N;i++){
    		temp.pq[i]=pq[i];
    	}
    	return temp;
    }
    
    public String toString(){
    	MaxPQ<Key> temp =this.copy();
    	String content="";
    	while(temp.size()>0){
    		content =content +temp.delMax()+"";
    	}
    	return content;
    	
    }
    
    public  int  contains(Key t){
    	boolean result;
    	if(this.N ==0) return -1;
    	for(int i=1;i<=this.N;i++){
    		result = this.pq[i].equals(t);
    		if(result){
    			StdOut.println(this.pq[i].toString()+" : "+t.toString());
    			return i;	
    		}
    			
    	}
    	return -1;
    }
    
    public Key[] getKey(){
    	return pq;
    }
    

    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      int M =5;
      MaxPQ<Transaction> pq =new MaxPQ<Transaction>(M+1);
      while(StdIn.hasNextLine()){
    	  pq.insert(new Transaction(StdIn.readLine()));
    	  if(pq.size()>M) pq.delMax();
      }
      Stack<Transaction> stack =new Stack<Transaction>();
      while(!pq.isEmpty()) stack.push(pq.delMax());
      for(Transaction t:stack) StdOut.println(t);
	}
	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public Key next() {
		// TODO Auto-generated method stub
		return null;
	}

}
