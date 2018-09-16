import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class MergeImprove {

	 private static Comparable[] aux;
	    public static void sort(Comparable[] a){
	    	aux =new Comparable[a.length];
	    	aux=a.clone();
	    	sort(a,0,a.length-1,aux);
	    }
	    private static void sort(Comparable[] src,int lo,int hi,Comparable[] dst){
            if(hi<=lo) return;

	    	int mid =lo+(hi-lo)/2;
	    	if(((mid-lo+1)<=15)&&((hi-mid)<=15)){
	    		Insertion.sort(src, lo, mid);
	    		Insertion.sort(src,mid+1,hi);
	    		StdOut.println("Insertion : lo "+lo+" mid "+mid+" hi "+hi+" < "+(mid-lo+1)+" >");
	    	}
	    	else{
		    	sort(src,lo,mid);
		    	sort(src,mid+1,hi);
		    	StdOut.println("Merge : lo "+lo+" mid "+mid+" hi "+hi+" < "+(mid-lo+1)+" >");
		    	
	    	}

	    	if(less(src[mid],src[mid+1])) {
	    		dst=src;
	    		return;
	    	}
	    	merge(dst,lo,mid,hi,src);
	    }
	    public static void merge(Comparable[] a,int lo,int mid,int hi,Comparable[] b){
	    	int i=lo;
	    	int j=mid+1;
	    	for(int k=lo;k<=hi;k++){
	    		if(i>mid) a[k]=b[j++];
	    		else if(j>hi) a[k]=b[i++];
	    		else if(less(b[j],b[i])) a[k]=b[j++];
	    		else a[k]=b[i++];
	    	}
	    	
	    }
	    
	    private static void Fastmerge(Comparable[] a,int lo,int mid,int hi){
	    	for(int i =lo;i<=mid;i++)
	    		aux[i]=a[i];
	    	for(int j=mid+1;j<=hi;j++)
	    		aux[j]=a[hi-j+mid+1];
	    	int i=lo,j=hi;
	    	for(int k  =lo;k<=hi;k++)
	    		if(less(aux[j],aux[i])) a[k]=aux[j--];
	    		else a[k]=aux[i++];
	    }
	    private static boolean less(Comparable v,Comparable w){
	    	//StdOut.println("MergeImprove  : v "+v+" w: "+w);
	    	return v.compareTo(w)<0;
	    }
	    private static void exch(Comparable[] a,int i,int j){
	    	Comparable t=a[i];
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
            int N=1000;
			Double[] test = new Double[N];
			for(int i=0;i<N;i++){
			   test[i]=StdRandom.uniform(0, 1.0*N*N);
			}
			sort(test);
			boolean result =isSorted(test);
			StdOut.println();
			StdOut.println("Is Sorted? "+result);
			
		}

}
