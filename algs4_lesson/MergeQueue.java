import java.util.Iterator;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class MergeQueue {
	public static Queue<Integer> sortedQueue;
    public static Queue<Integer> merge(Queue<Integer> a,Queue<Integer> b){
    	Queue<Integer> sortQueue =new Queue();
    	while((!a.isEmpty())&&(!b.isEmpty())){
    		if(a.peek()<b.peek())
    			sortQueue.enqueue(a.dequeue());
    		else 
    			sortQueue.enqueue(b.dequeue());
    	}
    	while(!a.isEmpty()){
    		sortQueue.enqueue(a.dequeue());
    	}
    	while(!b.isEmpty()){
    		sortQueue.enqueue(b.dequeue());
    	}
    	return sortQueue;
    }
    public static void mergeBU(int N){
       Queue<Queue<Integer>> queueList =new Queue<Queue<Integer>>();
       for(int i=0;i<N;i++){
    	 Queue<Integer> temp =new Queue<Integer>();
    	 temp.enqueue(StdRandom.uniform(0, N*N));
    	 queueList.enqueue(temp);
       }
       while(queueList.size()!=1){
    	   int times =queueList.size()/2;
    	   for(int i=0;i<times;i++){
    		   Queue<Integer> A =queueList.dequeue();
    		   Queue<Integer> B=queueList.dequeue();
    		   queueList.enqueue(merge(A, B));
    	   }
    	   
       }
       Queue<Integer> c =queueList.dequeue();
       StdOut.println("Print Begin");
       while(!c.isEmpty()){
    	   StdOut.print(" "+c.dequeue());
       }
       StdOut.println("Print End");
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N=24;
		mergeBU(N);

	}

}
