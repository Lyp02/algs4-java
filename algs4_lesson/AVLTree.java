

public class AVLTree<Key extends Comparable<Key>,Value>  {
	 private class Node{
	    	Key key;
	    	Value val;
	    	Node left,right;
	    	int height;
	    	
	    	Node(Key key,Value val,int height){
	    		this.key =key;
	    		this.val =val;
	    		this.height =height;

	    		
	    	}
	    }
	 private int height (Node x){
		 return x==null?-1:x.height;
	 }
	 private Node insert(Key key,Value val,Node t){
		 if(t==null) return new Node(key,val,0);
		 int cmp =key.compareTo(t.key);
		 if(cmp<0){
			 t.left =insert(key,val,t.left);
			 if(height(t.left)-height(t.right)==2){
				 if(key.compareTo(t.left.key)<0)
					 t =rotateWithLeftChild(t);
				 else 
					 t=doubleWithLeftChild(t);
			 }
		 }
		 else if(cmp>0){
			 t.right =insert(key,val,t.right);
			 if(height(t.right)-height(t.left)==2){
				 if(key.compareTo(t.right.key)>0)
					 t =rotateWithRightChild(t);
				 else 
					 t =doubleWithRightChild(t);
			 }
		 }
		 else t.val =val;
		 t.height =Math.max(height(t.left), height(t.right))+1;
		 return t;
	 }
	 private Node rotateWithLeftChild(Node k2){
		 Node k1 =k2.left;
		 k2.left =k1.right;
		 k1.right =k2;
		 k2.height =Math.max(height(k2.left), height(k2.right))+1;
		 k1.height =Math.max(height(k1.left), k2.height)+1;
		 return k1;
	 }
	 private Node rotateWithRightChild(Node k2){
		 Node k1 =k2.right;
		 k2.right =k1.left;
		 k1.left =k2;
		 k2.height =Math.max(height(k2.left), height(k2.right))+1;
		 k1.height =Math.max(height(k1.right), k2.height)+1;
		 return k1;
	 }
	 private Node doubleWithLeftChild(Node k3){
		 k3.left =rotateWithRightChild(k3.left);
		 return rotateWithLeftChild(k3);
	 }
	 private Node doubleWithRightChild(Node k3){
		 k3.right =rotateWithLeftChild(k3.right);
		 return rotateWithRightChild(k3);
	 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
