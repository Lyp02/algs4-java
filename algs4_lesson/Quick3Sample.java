import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Quick3Sample {
	 public static void sort(Comparable[] a){
		 StdRandom.shuffle(a);
		 sort(a,0,a.length-1);
	 }
	 
	 private static void sort(Comparable[] a ,int lo,int hi){
		 if(hi<=lo+2){
			 Insertion.sort(a, lo, hi);
			 return;
		 }
		 else{
			 int j= partition(a,lo,hi);
			 sort(a,lo,j-1);
			 sort(a,j+1,hi);
		 }
	 }
	 
	 private static int partition(Comparable[] a,int lo,int hi){
		 Insertion.sort(a, lo, lo+2);
		 exch(a,lo+2,hi);
		 int i=lo+1,j=hi+1;
		 Comparable v =a[lo+1];
		 while(true){
			 while(less(a[++i],v));
			 while(less(v,a[--j]));
			 if(i>j) break;
			 exch(a,i,j);
		 }
		 exch(a,lo+1,j);
		 return j;
	 }

	 private static boolean less(Comparable v,Comparable w){
	    	return v.compareTo(w)<0;
	    }
	    private static void exch(Comparable[] a,int i,int j){
	    	Comparable t =a[i];
	    	a[i]=a[j];
	    	a[j]=t;
	    }
	    private static void show(Comparable[] a){
	    	for(int i=0;i<a.length;i++)
	    		StdOut.print(a[i]+" ");
	    	StdOut.println();
	    }
	    public static boolean isSorted(Comparable[] a){
	    	for(int i=1;i<a.length;i++)
	    		if(less(a[i],a[i-1])) return false;
	    	return true;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
     Integer[] test ={22,4,2,1,6,8,0,-1,4,12,-9,7,3};
     sort(test);
     show(test);
	}

}
