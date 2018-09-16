import java.util.Iterator;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

public class CopyQueue<Item>  {
    Queue<Item> q ;
    public void ergodic() {
    	while(q.size()>0) {
    		StdOut.print(" "+q.dequeue());
    	}
    }
    public CopyQueue(Queue<Item> r) {
    	q =new Queue<Item>();
    	int count =r.size();
    	while(count>0) {
    		Item temp =r.dequeue();
    		count--;
    		q.enqueue(temp);
    		r.enqueue(temp);
    	}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
    Queue<String> r =new Queue<String>();
    r.enqueue("Hello");
    r.enqueue("World");
    CopyQueue<String> cp =new CopyQueue<String>(r);
    cp.ergodic();
    Iterator<String> i = r.iterator();
    StdOut.println();
    while(i.hasNext()) {
    	StdOut.println(i.next());
    }
	}

}
