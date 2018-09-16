import java.util.Arrays;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class practice3_2 {
    public void Question25(){
    	int N =12;
    	Integer[] a =new Integer[N];
    	for(int i=0;i<N;i++){
    		a[i]=StdRandom.uniform(0, i*i+1);
    	}
    	Arrays.sort(a);
    	BST<Integer, Integer> bst =new BST<>();
    	int lo =0;
    	int hi =a.length-1;
    	perfectBalance(bst,a,lo,hi);
    }
    public void perfectBalance(BST<Integer, Integer> bst,Integer[] a,int lo,int hi){
    	if(lo> hi) return;
    	int mid =lo +(hi-lo)/2;
    	bst.put(a[mid], mid);
    	perfectBalance(bst, a, lo, mid-1);
    	perfectBalance(bst, a, mid+1, hi);
    }
    public static void Question36(){
    	BST<Integer,Integer> st =new BST<Integer,Integer>();
    	int N =12;
    	for(int i=0;i<N;i++){
    		st.put(i,i*i+1 );
    	}
    	
    	StdOut.println();
    	for(Integer i:st.mykeys(4,9))
    		StdOut.println( i+"  "+st.get(i));
    	//Iterable<Integer> i =st.mykeys();
    }
    
    public static void Question37(){
       	BST<Integer,Integer> st =new BST<Integer,Integer>();
    	int N =12;
    	for(int i=0;i<N;i++){
    		st.put(i,i*i+1 );
    	}
    	Queue<Node> q1 =new Queue<>();
    	Node x;
        printLevel(q1);
    }
    public static void printLevel(Queue<Node> q){
    	if(q.isEmpty()) return;
    	Queue<Node> q2 =new Queue<>();
    	while(!q.isEmpty()){
    		Node temp =q.dequeue();
    		StdOut.print(temp);
    		if(temp.left!=null) q2.enqueue(temp.left);
    		if(temp.right!=null) q2.enqueue(temp.right);
    	}
    	StdOut.println();ie
    	printLevel(q2);
    	
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       Question36();
	}

}
