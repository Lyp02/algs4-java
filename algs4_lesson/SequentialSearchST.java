import java.util.Iterator;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class SequentialSearchST<Key,Value> {
    private Node first;
    public static int times;
    public static int totals;
    public SequentialSearchST(){
    	this.times =0;
    	this.totals=0;
    }
    private class Node{
    	Key key;
    	Value val;
    	Node next;
    	public Node(Key key,Value val,Node next){
    		this.key =key;
    		this.val =val;
    		this.next =next;
    	}
    	
    }
    public Value get(Key key){
    	for(Node x=first;x!=null;x=x.next)
    		if(key.equals(x.key))
    			return x.val;
    	return null;
    }
    public void put(Key key,Value val){
        this.times =0;
    	for(Node x =first;x!=null;x=x.next){
    		times++;
    		if(key.equals(x.key)){
    			x.val =val;
    			return;
    		}
    	}
    	this.totals+=this.times;
    	first =new Node(key,val,first);
    }
    public int size(){
    	if(first ==null) return 0;
    	int counts =0;
    	for(Node x =first;x!=null;x=x.next){
    		counts++;
    	}
    	return counts;
    }
    public boolean delete(Key key){
    	
    	if(first==null) return false;
    	if(first.key.equals(key)){
    		first =first.next;
    		return true;
    	}
    	else{
    		for(Node x =first;x.next!=null;x=x.next){
    			if(key.equals(x.next.key)){
                    x=x.next.next;
                    return true;
    			}
    		}
    	}
    	return false;
    }
    public Iterator<Key> keys(){
    	return new SequentialSearchSTIterator();
    }
    public boolean contains(Key key){
    	for(Node x=first;x!=null;x=x.next){
    		if(key.equals(first.key))
    			return true;
    	}
    	return false;
    }
    private class SequentialSearchSTIterator implements Iterator<Key>{
    	private Node current =first;
    	public boolean hasNext(){
    		return current!=null;
    	}
    	public void remove(){
    		
    	}
    	public Key next(){
    		Key key =current.key;
    		current =current.next;
    		return key;
    	}
    	
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       int minlen =Integer.parseInt(args[0]);
       VisualAccumulator vc =new VisualAccumulator(16000, 7000);
       SequentialSearchST<String, Integer> st =new SequentialSearchST<String,Integer>();
       while(!StdIn.isEmpty()){
    	   String word =StdIn.readString();
    	   if(word.length()<minlen) continue;
    	   if(!st.contains(word)) st.put(word, 1);
    	   else st.put(word, st.get(word)+1);
    	   vc.addDataValue(st.times);
    	   
       }
       String max="";
       st.put(max, 0);
       Iterator<String> i =st.keys();
       while(i.hasNext()){
    	   String temp =i.next();
    	   if(st.get(temp)>st.get(max))
    		   max =temp;
       }
       StdOut.println(max+" "+st.get(max));
    	   
	}

}
