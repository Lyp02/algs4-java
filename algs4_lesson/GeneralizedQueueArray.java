import edu.princeton.cs.algs4.StdOut;

public class GeneralizedQueueArray<Item>{
	public Item[] a;
	public int first;
	public int last;
	public int N;
	public GeneralizedQueueArray(int cap){
		a =(Item[])(new Object[cap]);
		first =0;
		last=0;
		N=0;
	}
	public void resize(int n) {
		Item[] b =(Item[])(new Object[n]);
		for(int i =0;i<N;i++) {
			b[i]=a[first+i];
		}
		a=b;
	}
	public  boolean isEmpty() {
		return N==0;
	}
	
	public void insert(Item x) {
		if(N==a.length) resize(2*a.length);
		if(last==a.length-1) resize(a.length);
		if(first == last) {
			if(a[first] ==null) {
				a[first]=x;
				N++;
				return;
			}
			else {
				a[++last]=x;
				N++;
				return;
			}
		}
		else {
			a[++last] =x;
			N++;
			return;
		}
	}
	
	public Item delete(int k) {
		if((k>N)||(k<=0)||(N==0)) return null;
		else {
			if(k==1) {
			if(N==1) {
				Item temp =a[first];
				a[first]=null;
				first++;
				last++;
				N--;
				if(N==a.length/4) resize(a.length/2);
				return temp;
				
			}
			  Item temp =a[first];
			  a[first]=null;
			  first =first+1;
			  N--;
			  if(N==a.length/4) resize(a.length/2);
			  return temp;
			  
			}
			else { 
				Item temp =a[first+k-1];
				for(int i=first+k-1;i<last;i++) {
					a[i]=a[i+1];
					}
				a[last]=null;
				last--;
				N--;
				
				if(N==a.length/4) resize(a.length/2);
				return temp;
			}
			}
		
		}
	public void ergodic() {
		if(N==0) {
			StdOut.println("Empty");
			return;
		}
		else {
			StdOut.println("Ergodic:");
			for(int i=first;i<=last;i++) {
				StdOut.print(" "+a[i] );
			}
			StdOut.println();
		}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       GeneralizedQueueArray<String> a =new GeneralizedQueueArray<String>(10);
       a.insert(""+0);
       a.insert(""+1);
       a.insert(""+2);
       a.insert(""+3);
       a.insert(""+4);
       a.insert(""+5);
       a.insert(""+6);
       a.insert(""+7);
       a.delete(1);
       a.delete(5);
       a.ergodic();
	}

}
