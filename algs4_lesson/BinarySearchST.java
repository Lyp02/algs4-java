import java.util.Iterator;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class BinarySearchST<Key extends Comparable<Key>,Value> {
    private Key[] keys;
    private Value[] vals;
    private int N;
    public static int times;
    public BinarySearchST(int capacity){
    	keys =(Key[]) new Comparable[capacity];
        vals =(Value[]) new Object[capacity];
        this.times =0;
    }
    public int size(){
    	return N;
    }
    public Value get(Key key){
    	if(isEmpty()) return null;
    	int i =rank(key);
    	if(i<N&&keys[i].compareTo(key)==0) return vals[i];
    	else return null;
    }
    public int rank(Key key){
    	int lo =0,hi=N-1;
    	while(lo<=hi){
    		this.times++;
    		int mid =lo+(hi -lo)/2;
    		int cmp =key.compareTo(keys[mid]);
    		if(cmp<0) hi =mid-1;
    		else if(cmp>0) lo=mid+1;
    		else return mid;
    	}
    	return lo;
    }
    public void delete(Key key){
    	int i=rank(key);
    	if(i<N&&keys[i].compareTo(key)==0){
    		for(int j=i+1;i<N;j++){
    			keys[j-1]=keys[j];
    			vals[j-1]=vals[j];
    		}
    		N--;
    		return;
    	}
    	StdOut.println();
    	StdOut.println("No Such Key !");
    	return;
    }
    public Key min(){
    	return keys[0];
    }
    public Key max(){
    	return keys[N-1];
    }
    public Key select(int k){
    	return keys[k];
    }
    public Key ceiling(Key key){
    	int i =rank(key);
    	return keys[i];
    }
    public Key floor(Key key){
    	int i =rank(key);
    	if(i==0) return null;
    	else if(keys[i].compareTo(key) ==0) return keys[i];
    	else  return keys[i-1];
    }
    public Iterable<Key> keys(Key lo,Key hi){
    	Queue<Key> q =new Queue<Key>();
    	for(int i=rank(lo);i<rank(hi);i++){
    		q.enqueue(keys[i]);
    	}
    	if(contains(hi))
    		q.enqueue(keys[rank(hi)]);
    	return q;
    }
    public boolean contains(Key key){
    	int i =rank(key);
    	if(i<N&&keys[i].compareTo(key)==0){
    		return true;
    	}
    	return false;
    	
    }
    public boolean isEmpty(){
    	return N==0;
    }
    public void put(Key key,Value val){
    	this.times =0;
    	int i =rank(key);
    	if(i<N&&keys[i].compareTo(key)==0){
    		vals[i] =val;
    		return ;
    	}
    	for(int j=N;j>i;j--){
    		keys[j]=keys[j-1];
    		vals[j] =vals[j-1];
    		this.times++;
    	}
    	keys[i] =key;
    	vals[i] =val;
    	N++;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int minlen =Integer.parseInt(args[0]);
	       VisualAccumulator vc =new VisualAccumulator(16000, 7000);
	       BinarySearchST<String, Integer> st =new BinarySearchST<String,Integer>(10000);
	       while(!StdIn.isEmpty()){
	    	   String word =StdIn.readString();
	    	   if(word.length()<minlen) continue;
	    	   if(!st.contains(word)) st.put(word, 1);
	    	   else st.put(word, st.get(word)+1);
	    	   vc.addDataValue(st.times);
	    	   
	       }

	    	   
		}

	

}
