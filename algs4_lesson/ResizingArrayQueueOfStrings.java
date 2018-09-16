import edu.princeton.cs.algs4.StdOut;

public class ResizingArrayQueueOfStrings  {
	private int first;
	private int last;
	private String[] a;
	public ResizingArrayQueueOfStrings(int cap) {
		first =0;
		last =0;
		a =new String[cap];
	}
	public void enqueue(String s) {
		if((last-first) == a.length-1) resize(2*a.length);
			last =last+1;
			a[last]=s;
	}
	public String dequeue() {
		if(first == last) {
			StdOut.println("Queue is Empty!");
			return null;
		}
		else if((last -first)==a.length/4) resize(a.length/2);
		String temp=a[first+1];
		a[first+1]=null;
		first++;
		return  temp;
		
	}
	public void resize(int cap) {
		String[] temp =new String[cap];
		int j=1;
		for(int i=first+1;i<=last;i++) {
			temp[j++]=a[i];
		}
		first =0;
		last = j-1;
		a=temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      ResizingArrayQueueOfStrings a =new ResizingArrayQueueOfStrings(12);
      for(int i=0;i<16;i++) {
          StdOut.println(i);    	                      
    	  a.enqueue(i+"");
      }
      StdOut.println(a.last -a.first);                                                 
      for(int i=0;i<13;i++) {
    	  StdOut.println(a.dequeue());
      }  
      StdOut.println(a.last-a.first);
      
	}

}
