import edu.princeton.cs.algs4.StdOut;

public class Deque<Item> {
	DoubleNode first;
	DoubleNode last;
    private class DoubleNode<Item>{
    	DoubleNode forward;
    	DoubleNode backward;
    	Item item;
    }
    public Deque() {
    	first=null;
    	last=null;
    	
    }
    public boolean isEmpty() {
    	if(first ==null) return true;
    	if(last ==null)  return true;
    	else return false;
    	
    }
    public int size() {
    	int count=0;
    	if(first ==null) return 0;
    	if(last ==null) return 0;
    	else {
    		DoubleNode x;
    	    count =0;
    		for(x=first;x!=null;x=x.backward) {
    			count++;
    		}
    	}
    	return count;
    }
    public void pushLeft(Item item) {
    	DoubleNode node =new DoubleNode();
    	node.item=item;
    	if(first ==null ) {
    		first=node;
    		first.forward=null;
    		first.backward=null;
    		last=node;
    	}
    	
    	else{
    		DoubleNode oldfirst =first;
    		first =node;
    		first.backward=oldfirst;
    		oldfirst.forward=first;
    		first.forward=null;
    	}
    }
    public void pushRight(Item item) {
    	DoubleNode node =new DoubleNode();
    	node.item=item;
    	if(last==null) {
    		last=node;
    		last.forward=null;
    		last.backward=null;
    		first=node;
    	}
    	else {
    		 DoubleNode oldlast=last;
    		 last=node;
    		 last.forward=oldlast;
    		 oldlast.backward=last;
    		 last.backward=null;
    		 
    	}
    }
    
    public Item popLeft() {
    	if(first ==null) {
    		StdOut.println("Empty DoubelNode");
    		return null;
    	}
    	else if(first ==last) {
    		first =null;
    		last =null;
    		return (Item)first.item;
    		
    	}
    	else {
    		DoubleNode node =first;
    		first=first.backward;
    		first.forward=null;
    		return (Item)node.item;
    	}
    }
    
    public Item popRight() {
    	if(last ==null) {
    		StdOut.println("Empty DoubelNode");
    		return null;
    	}
    	else if(first ==last) {
    		first =null;
    		last =null;
    		return (Item)last.item;
    		
    	}
    	else {
    		DoubleNode node =last;
    		last=last.forward;
    		last.backward=null;
    		return (Item)node.item;
    	}
    }
    public void ergodic() {
    	DoubleNode x;
    	int counts=1;
    	for(x=first;x!=null;x=x.backward) {
    		StdOut.println("Element "+counts+" "+x+" Item "+x.item);
    		counts++;
    	}           
    }
 
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Deque<String> q =new Deque();
		q.pushLeft("1");
		q.pushLeft("2");
		q.pushRight("0");
		q.pushLeft("4");
		q.pushRight("5");
		q.pushLeft("7");
		q.ergodic();
		StdOut.println(q.popLeft()+"  popLeft");
		StdOut.println(q.popRight()+"  popRight");
		q.ergodic();
		
		

	}

}
