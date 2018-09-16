import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

public class Josephus{
	public Queue<Integer> q;
	public int N;
	public int M;
	public Josephus(int N,int M) {
		this.N =N;
		this.M=M;
		q =new Queue<Integer>();
		for(int i=0;i<N;i++) {
			q.enqueue(i);
			
		}
		while(q.size()>1) {
			for(int i=1;i<M;i++) {
				q.enqueue(q.dequeue());
			}
			StdOut.println(" "+q.dequeue());
		}
		
		if(q.size() ==1) {
			StdOut.println(q.dequeue() +"has survived");
		}
		
		
	}
	public static void main (String[] args) {
		Josephus a =new Josephus(7, 2);
	}
}