
public class OrderedSequentialSearchST<Key extends Comparable<Key>,Value> {
	private Node first;
	private class Node{
		Key key;
		Value val;
		Node next;
		public Node(Key key,Value val,Node next){
			this.key =key;
			this.val =val;
			this.next =next;
			
		}
		public void changeNext(Node next){
			this.next =next;
		}
	}
	
	public int size(){
		if(first ==null) return 0;
		else{
			int counts =0;
			for(Node x =first;x!=null;x=x.next)
				counts++;
			return counts;
		}
	}
	public boolean isEmpty(){
		return size()==0;
	}
	public Node rank(Key key){
		Node x;
		Node y =first;
		for( x =first;(x!=null)&&(x.key.compareTo(key)<0);x=x.next){
		}
		return x;//前面结点>=目标结点
			
		
	}
	public boolean contains(Key key){
		Node x =rank(key);
		if(x==null) return false;
		else{
			if(x.key.compareTo(key)==0)
				return true;
		}
		return false;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public Value get(Key key){
    	Node x =rank(key);
    	if(x.key.compareTo(key) ==0)
    		return x.val;
    	else return null;
    }
    public void put(Key key,Value val){
    	Node x =rank(key);
    	Node y =first;
    	if(x.key.compareTo(key)==0) {
    		x.val =val;
    		return;
    	}
    	if(first.key.compareTo(key)>0){
    		first =new Node(key,val,first);
    		return;
    	}
    	for( y=first;(y.next!=null)&&(y.next.key.compareTo(key)<0);y=y.next);
    	//找到x前级结点
    	Node temp =y.next;
    	Node n =new Node(key,val,temp);
    	x.changeNext(n);
    	return;
    	
    	 
    	
    }
}
