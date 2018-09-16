import java.awt.Color;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

public class BST<Key extends Comparable<Key>,Value> {
    private Node root;
    public class Node{
    	private Key key;
    	private Value val;
    	private Node left ,rigtht;
    	private int N;
    	public Node(Key key,Value val,int N){
    		this.key=key;
    		this.val =val;
    		this.N=N;
    	}
    	public Node getLeft(){
    		return this.left;
    	}
    	public Node getRight(){
    		return this.rigtht;
    	}
    	
    	}
    public int size(){
		return size(root);
	}
    public Node getRoot(){
    	return root;
    }
	private int size(Node x){
		if(x==null) return 0;
		else return x.N;
	}
	Value get(Key key){
		return get(root,key);
	}
	private Value get(Node x,Key key){
		if(x==null) return null;
		int cmp =key.compareTo(x.key);
		if(cmp <0) return get(x.left,key);
		else if(cmp >0) return get(x.rigtht,key);
		else return x.val;
	}
	
	public void put(Key key,Value val){
	  root = put(root,key,val);
	}
	private Node put(Node x,Key key,Value val){
		if(x==null) return new Node(key,val,1);
		int cmp =key.compareTo(x.key);
		if(cmp <0) x.left =put(x.left,key,val);
		else if(cmp >0 ) x.rigtht =put(x.rigtht,key,val);
		else x.val =val;
		x.N =size(x.left)+size(x.rigtht)+1;
		return x;
				
	}
	
	public Key min(){
		return min(root).key;
	}
	public Node min(Node x){
		if(x.left ==null) return x;
		return min(x.left);
	}
	public Key max(){
		return max(root).key;
	}
	public Node max(Node x){
		if(x.rigtht ==null) return x;
		return max(x.rigtht);
	}
	public Key floor(Key key){
		Node x =floor(root,key);
		if(x==null) return null;
		return x.key;
	}
	private Node floor(Node x,Key key){
		if(x==null) return null;
		int cmp =key.compareTo(x.key);
		if(cmp ==0) return x;
		if(cmp < 0) return floor(x.left,key);
		Node t =floor(x.rigtht,key);
		if(t!=null) return t;
		else return x;
	}
    
	public Key select(int k){
		return select(root,k).key;
		
	}
	private Node select(Node x,int k){
		if(x==null) return null;
		int t =size(x.left);
		if( t>k) return select(x.left,k);
		else if(t < k) return select(x.rigtht,k-t-1);
		else return x;
	}
	public int rank(Key key){
		return rank(key,root);
	}
	private int rank(Key key,Node x){
		if(x==null) return 0;
		int cmp =key.compareTo(x.key);
		if(cmp < 0) return rank(key,x.left);
		else if(cmp >0) return 1+size(x.left)+rank(key,x.left);
		else return size(x.left);
	}
    public void deleteMin(){
    	root =deleteMin(root);
    }   
    private Node deleteMin(Node x){
    	if(x.left ==null) return x.rigtht;
    	x.left =deleteMin(x.left);
    	x.N =size(x.left)+size(x.rigtht)+1;
    	return x;
    }
    public void delete(Key key){
    	root =delete(root,key);
    }
    private Node delete(Node x,Key key){
    	if(x==null) return null;
    	int cmp =key.compareTo(x.key);
    	if(cmp <0) x.left =delete(x.left, key);
    	else if(cmp>0) x.rigtht =delete(x.rigtht, key);
    	else{
    		if(x.rigtht ==null) return x.left;
    		if(x.left ==null) return x.rigtht;
    		Node t =x;
    		x =min(t.rigtht);
    		x.rigtht =deleteMin(t.rigtht);
    		x.left =t.left;
    	}
    	x.N =size(x.left)+size (x.rigtht)+1;
    	return x;
    }
	public Iterable<Key> keys(){
		return keys(min(),max());
	}
	public Iterable<Key> keys(Key lo,Key hi){
		Queue<Key> queue =new Queue<Key>();
		keys(root,queue,lo,hi);
		return queue;
	}
	 
	private void keys(Node x,Queue<Key> queue,Key lo,Key hi){
		if(x==null) return ;
		int cmplo =lo.compareTo(x.key);
		int cmphi =hi.compareTo(x.key);
		if(cmplo <0) keys(x.left,queue,lo,hi);
		if(cmplo<=0&cmphi>=0) queue.enqueue(x.key);
		if(cmphi>0) keys(x.rigtht,queue,lo,hi);
	}
	
	public Iterable<Key> mykeys(){
		return keys(min(),max());
	}
	public Iterable<Key> mykeys(Key lo,Key hi){
		Queue<Key> queue =new Queue<Key>();
		keys(root,queue,lo,hi);
		return queue;
	}
	
	public Iterable<Key> mykeys(Node x,Queue<Key> queue,Key lo,Key hi){
		Stack<Node> s =new Stack<>();
		s.push(x);
		while(!s.isEmpty()){
			x = s.peek();
			while(x!=null){
				int cmplo =lo.compareTo(x.key);
				int cmphi =hi.compareTo(x.key);
				if(cmplo<=0&&cmphi>=0) queue.enqueue(x.key);
				if(cmplo<0) {
					x=x.left;
					s.push(x.rigtht);
				}
			}
			s.pop();
			if(!s.isEmpty()){
				x =s.pop();
				s.push(x.rigtht);
			}
		}
		return queue;
	}
	
	public int avgCompares(){
		if(root ==null) return 0;
		int count =0;
		int deep =0;
		return 1+((avgCompares(root,count,deep))/size(root));
	}
	private int avgCompares(Node x,int count,int deep){
		if(x==null) return 0;
		count=count +deep;
		if(x.left!=null)
			avgCompares(x.left,count,deep+1);
		if(x.rigtht!=null)
			avgCompares(x.rigtht,count,deep+1);
		return count;
	}
	public int pow2(int i){
		int sum =1;
		while(i>0){
			sum=2*sum;
			i--;
		}
		return sum;
	}
	public int optCompares(int N){
		if(N==0) return 0;
		//the height of the N bst
		int h =0;
		int sum =0;
		while(pow2(h+1)-1 <N)
			h++;
		if(pow2(h+1)-1==N){
			return 1+((h-1)*pow2(h+1)+2)/N;
		}
		else{
		   return 1+((h-2)*pow2(h)+2+(N-(pow2(h)-1)*h))/N;
		}
		}
	public void draw(){
		double H = 600;  // diatance betwen two levels is 30;
		double W = 1800;
		int level =1;
		StdDraw.setXscale(0,1800);
		StdDraw.setYscale(0, 800);
		StdDraw.setPenColor(Color.black);
		StdDraw.setPenRadius(0.05);
		if(root ==null) return;
		else{
			drawNode(root,level,W/2,H,W,H);
		}
	}	
	public void drawNode(Node p,int level,double x,double y,double width,double height){
		int nums =pow2(level+1);
		double xdistance =width/nums;
		if(p ==null) return;
		else{
			StdDraw.setPenRadius(0.01);
			StdDraw.point(x, y);
			StdDraw.setPenRadius(0.005);
			if(p.left!=null){
				StdDraw.line(x, y, x-xdistance, y-60);
				drawNode(p.left,level+1,x-xdistance,y-60,width,height);
			}
			if(p.rigtht!=null){
				StdDraw.line(x, y, x+xdistance, y-60);
				drawNode(p.rigtht,level+1,x+xdistance,y-60,width,height);
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       	BST<Integer,Integer> st =new BST<Integer,Integer>();
    	int N =50;
    	for(int i=0;i<N;i++){
    		st.put(StdRandom.uniform(50000),i*i+1 );
    	}
    	st.draw();
	}
	 

}
