import java.util.Iterator;

public class Steque<Item> implements Iterable<Item> {
    private Node first;
    private int N;
    private class Node{
    	Item item;
    	Node next;
    }
    public boolean isEmpty() {
    	return first==null;
    }
    public int size() {
    	return N;
    }
    public void push(Item item) {
    	Node oldfirst =first;
    	first =new Node();
    	first.item=item;
    	first.next=oldfirst;
    	N++;
    }
    public Item pop()
    {
    	Item item =first.item;
    	first=first.next;
    	N--;
    	return item;
    }
    public void enqueue(Item item) {
    	Node node =new Node();
    	node.item=item;
    	if(first ==null) {
    		first = node;
    		first.next=null;
    	}
    	else {
    		Node x;
    		for(x=first;x.next!=null;x=x.next);
    		x.next=node;
    		node.next=null;
    			
    	}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
