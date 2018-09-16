import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class LinklistMerge {
    public Node start;
    public void  MergeTest(int N){
    	start =new Node(6);
    	StdOut.println(" start :" +start.item);
    	Node current =start;
    	for(int i =0;i<N;i++){
    		Node temp =new Node(StdRandom.uniform(0, N*N));
    		current.next =temp;
    		current =current.next;
    		StdOut.println(" i+1 : "+current.item);
    	}
    	StdOut.println();
    	StdOut.println("Before ");
    	Node node1 =start;
    	while(node1!=null){
    		StdOut.print("  "+node1.item);
    		node1 =node1.next;
    	}
    	StdOut.println();
    	StdOut.println("End");
    	
    	start=sort(start);
    	Node node  =start;
    	StdOut.println("Print ");
    	while(node!=null){
    		StdOut.print("  "+node.item);
    		node =node.next;
    	}
    	StdOut.println();
    	StdOut.println("End ");
    }
	public class Node{
    	public int item;
    	public Node next;
    	
    	public Node(int a){
    		this.item=a;
    		this.next=null;
    	}
    }
    
    public Node merge (Node lo,Node l1){
    	Node first;
    	Node current;
    	if(lo==null) {
    		first =lo;
    		return first;
    	}
    	if(l1==null) {
    		first =l1;
    		return first;
    	}
   //决定表头
    	if(lo.item < l1.item){
    		first =lo;
    		current =first;
    		lo=lo.next;
    	}else{
    		first =l1;
    		current =first;
    		l1=l1.next;
    	}
    //归并开始
    	while(lo!=null&&l1!=null){
    		if(lo.item <l1.item){
    			current.next =lo;
    			current =current.next;
    			lo =lo.next;
    		}
    		else{
    			current.next =l1;
    			current =current.next;
    			l1=l1.next;
    		}
    	}
    	if(lo ==null) current.next=l1;
    	if(l1 ==null) current.next=lo;
    	StdOut.println();
    	return first;
    	
    	
    }
    public Node findBlock(Node l){
    	Node head =l;
    	while(head.next!=null){
    		if(head.item > head.next.item){
    			return head;
    		}
    		head =head.next;
    		}
    	return head;
    	}
    
    public Node sort(Node start){
        Node l0 =start;
        Node h0 =findBlock(l0);
        Node l1;
        Node h1;
        Node after =h0.next;
        h0.next=null;
        while(after!=null){
        	l1=after;
        	h1 =findBlock(l1);
        	after =h1.next;
        	h1.next =null;
        	StdOut.println();
        	StdOut.println(" l0");
        	printNodes(l0);
        	StdOut.println(" l1");
        	printNodes(l1);
        	StdOut.println(" merge ( l0,l1 ) ");
        	l0=merge(l0, l1);
        	printNodes(l0);
        }
        return l0;
    	
    }
    
    private void printNodes(Node n){
    	StdOut.println();
    	while(n!=null){
    		StdOut.print( " "+n.item);
    		n= n.next;
    	}
    	StdOut.println();
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      LinklistMerge l =new LinklistMerge();
      int N=6;
      l.MergeTest(N);
	}

}
