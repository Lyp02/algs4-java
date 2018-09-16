import java.util.Comparator;

import edu.princeton.cs.algs4.Queue;

public class StableSort implements Comparable<StableSort>{
	private Comparable Key;
	private Queue<Integer> q;
    public StableSort( Comparable c,Integer i) {
    	Key =c;
    	q =new Queue<Integer>();
    	q.enqueue(i);
    	
    	
		// TODO Auto-generated constructor stub
	}
    public Comparable getKey(){
    	return Key;
    }
    public Queue<Integer> getQueue(){
    	return q;
    }

	@Override
	public int compareTo(StableSort o) {
		// TODO Auto-generated method stub
		return this.Key.compareTo(o.getKey());
	}
}