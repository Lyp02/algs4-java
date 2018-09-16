import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class ShellPrint {
	 public static void sort(Double[] a){
	    	int N=a.length;
	    	int total =0;
	        int h=1;
	        while(h<N/3) h=3*h+1;//must end with 1
	        while(h>=1){
	        	for(int i=h;i<N;i++){
	        		total =total +1;
	        		for(int j=i;j>=h && less(a[j],a[j-h]);j-=h)
	        			{
	        			total++;
	        			exch(a,j,j-h);
	        			}
	        	}
	        	h=h/3;
	        }
	        StdOut.println(" size: "+a.length +" compare times:"+total+" compare times / size :"+(total/N));
	        }
	    
	    private static Double[] randomArray(int N){
	    	Double[] a =new Double[N];
	    	for(int i=0;i<N;i++)
	    		a[i]=StdRandom.uniform();
	    	return a;
	    }
	    private static void test(){
	    	int start =100;
	    	Double[] t;
	    	while(true){
	    		t = randomArray(start);
	    		sort(t);
	    		start =start*10;
	    	}
	    	
	    }
	    
	    private static boolean less(Double v,Double w){
	    	return v.compareTo(w)<0;
	    }
	    private static void exch(Double[] a,int i,int j){
	    	Double t =a[i];
	    	a[i]=a[j];
	    	a[j]=t;
	    }
	    private static void show(Double[] a){
	    	for(int i=0;i<a.length;i++)
	    		StdOut.print(a[i]+" ");
	    	StdOut.println();
	    }
	    public static boolean isSorted(Double[] a){
	    	for(int i=1;i<a.length;i++)
	    		if(less(a[i],a[i-1])) return false;
	    	return true;
	    }
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			StdOut.println("begin");
			test();
	
		}

}
