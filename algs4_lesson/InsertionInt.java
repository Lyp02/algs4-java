import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class InsertionInt {

	 public static void sort(int[] a){
	    	int N=a.length;
	        for(int i=1;i<N;i++){
	        	for(int j =i;j>0&&less(a[j],a[j-1]);j--)
	        		exch(a, j, j-1);
	        }
	    }
	    private static boolean less(int v,int w){
	    	return v<w;
	    }
	    private static void exch(int[] a,int i,int j){
	    	int t =a[i];
	    	a[i]=a[j];
	    	a[j]=t;
	    }
	    private static void show(int[] a){
	    	for(int i=0;i<a.length;i++)
	    		StdOut.print(a[i]+" ");
	    	StdOut.println();
	    }
	    public static boolean isSorted(int[] a){
	    	for(int i=1;i<a.length;i++)
	    		if(less(a[i],a[i-1])) return false;
	    	return true;
	    }
	    public static int[] RandomIntArr(int N){
	    	int[] a =new int[N];

	    		for(int i=0;i<N;i++)
	    			a[i]=StdRandom.uniform(0,N*N);

	                  
	    	
	    	return a;
	    }
		public static void main(String[] args) {
			// TODO Auto-generated method stub
	        StdOut.println("Begin!");
			int N =115200;
			int[] a =RandomIntArr( N);
			Integer[] b =new Integer[a.length];
			for(int i=0;i<a.length;i++)
				b[i]=a[i];
			Stopwatch timer1 =new Stopwatch();
			sort(a);
			double timer1Length = timer1.elapsedTime();
			Stopwatch timer2 =new Stopwatch();
			Insertion.sort(b);
			double timer2Length =timer2.elapsedTime();
			StdOut.println(" Insertion int is "+(1.0*timer2Length/timer1Length)+" faster than Insertion Integer");
	     
		}

}
