import java.util.Iterator;
import java.util.NoSuchElementException;

public class IndexMinPQ<Key extends Comparable<Key>> implements Iterable<Integer> {
    private int maxN;
    private int n;
    private int[] pq;
    private int[] qp;
    private Key[] Keys;
    public IndexMinPQ(int maxN){
    	this.maxN =maxN;
    	n=0;
    	Keys =(Key[]) new Comparable[maxN+1];
    	pq =new int[maxN+1];
    	qp =new int[maxN+1];
    	for(int i=0;i<maxN;i++)
    		qp[i]=-1;
    	
    }
    public boolean isEmpty(){
    	return n==0;
    }
    
    public boolean contains(int i){
    	if(i<0||i>=maxN) throw new IllegalArgumentException();
    	return qp[i]!=-1;
    }
    public int size(){
    	return n;
    }
    public void insert(int i,Key key){
    	if(i<0||i>=maxN) throw new IllegalArgumentException();
    	if(contains(i)) throw new IllegalArgumentException();
    	n++;
    	qp[i]=n;
    	pq[n]=i;
    	Keys[i]=key;
    	swim(n);
    }
    public int minIndex(){
    	if(n==0) throw new NoSuchElementException();
    	return pq[1];
    }
    public Key minKey(){
    	if(n==0) throw new NoSuchElementException();
    	return Keys[pq[1]];
    }
    public int delMin(){
    	if(n==0) throw new NoSuchElementException();
    	int min =pq[1];
    	exch(1,n--);
    	sink(1);
    	assert min ==pq[n+1];
    	qp[min]=-1;
    	Keys[min]=null;
    	pq[n+1]=-1;
    	return min;
    	
    }
    public Key keyOf(int i){
    	if(i<0||i>=maxN) throw new IllegalArgumentException();
    	if(!contains(i)) throw new NoSuchElementException();
    	else return Keys[i];
    }
    public void changeKey(int i,Key key){
    	if(i<0||i>=maxN) throw new IllegalArgumentException();
    	if(!contains(i)) throw new NoSuchElementException();
    	Keys[i] =key;
    	swim(qp[i]);
    	sink(qp[i]);
    }
    public void change(int i,Key key){
    	changeKey(i, key);
    }
    public void decreaseKey(int i,Key key){
    	if(i<0||i>=maxN) throw new IllegalArgumentException();
    	if(!contains(i)) throw new NoSuchElementException();
    	if(Keys[i].compareTo(key)<=0) throw new IllegalArgumentException();
    	Keys[i] =key;
    	swim(qp[i]);
    }
    public void increaseKey(int i,Key key){
    	if(i<0||i>=maxN) throw new IllegalArgumentException();
    	if(!contains(i)) throw new NoSuchElementException();
    	if(Keys[i].compareTo(key)>=0) throw new IllegalArgumentException();
    	Keys[i] =key;
    	sink(qp[i]);
    }
    public void delete(int i) throws IllegalAccessException{
    	if(i<0||i>=maxN) throw new IllegalAccessException();
    	if(!contains(i)) throw new NoSuchElementException();
    	int index =qp[i];
    	exch(index,n--);
    	swim(index);
    	sink(index);
    	Keys[i]=null;
    	qp[i]=-1;
    }
    private boolean greater(int i,int j){
    	return Keys[pq[i]].compareTo(Keys[pq[j]])>0;
    }
    private void exch(int i,int j){
    	int swap =pq[i];
    	pq[i]=pq[j];
    	pq[j]=swap;
    	qp[pq[i]] =i;
    	qp[pq[j]] =j;
    }
    
    private void swim(int k){
    	while(k>1 && greater(k/2,k)){
    		exch(k,k/2);
    		k=k/2;
    	}
    }
    private void sink(int k){
    	while(2*k<=n){
    		int j =2*k;
    		if(j<n && greater(j,j+1)) j=j+1;
    		if(!greater(k, j)) break;
    		exch(k,j);
    		k=j;
    	}
    }
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	@Override
	public Iterator<Integer> iterator() { return new HeapIterator(); }
	
	private class HeapIterator implements Iterator<Integer> {
        // create a new pq
        private IndexMinPQ<Key> copy;

        // add all elements to copy of heap
        // takes linear time since already in heap order so no keys move
        public HeapIterator() {
            copy = new IndexMinPQ<Key>(pq.length - 1);
            for (int i = 1; i <= n; i++)
                copy.insert(pq[i], Keys[pq[i]]);
        }

        public boolean hasNext()  { return !copy.isEmpty();                     }
        public void remove()      { throw new UnsupportedOperationException();  }

        public Integer next() {
            if (!hasNext()) throw new NoSuchElementException();
            return copy.delMin();
        }
    }


}
