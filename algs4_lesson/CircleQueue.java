import edu.princeton.cs.algs4.StdOut;

public class CircleQueue {
   public Node last;
   public int N;
   public CircleQueue() {
	   last = new Node("0");
	   last.next =last;
   }//在函数中last就是最后一个，不要用具有等价性此刻的node代替，这样程序才清晰
   public void enqueue(Node node) {
	   Node oldlast =last;
       last =node;
       last.next =oldlast.next;
       oldlast.next =last;
       
       N++;
   }
   public Node dequeue() {
	   Node node =last.next;
	   last.next = last.next.next;
	   N--;
	   return node;
   }
   
   public void ergodic() {
	   Node node =last.next;
	   while(!node.next.equals(last.next)) {
		   StdOut.println(" Node "+ node +" item "+node.item+" next "+node.next+"\n");
		   node =node.next;
	   }
	   StdOut.println(" Node "+ node +" item "+node.item+" next "+node.next+"\n");
   }
   
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       CircleQueue q =new CircleQueue();
       Node node1 =new Node("1");
       Node node2=new Node("2");
       Node node3 =new Node("3");
       Node node4 =new Node("4");
       Node node5=new Node("6");
       Node node6 =new Node("7");
       Node node7 =new Node("2");
       Node node8=new Node("11");
       Node node9 =new Node("15");
       q.enqueue(node1);
       q.enqueue(node2);
       q.enqueue(node3);
       q.enqueue(node4);
       q.enqueue(node5);;
       q.enqueue(node6);
       q.enqueue(node7);
       q.enqueue(node8);
       q.ergodic();
       q.dequeue();
       StdOut.println("After dequeue");
       q.ergodic();
       q.enqueue(node9);
       StdOut.println(q.N);
	}

}
