import java.awt.Color;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class MergePaint {

	 private static Double[] aux;
	 private static Integer times =0;
	    
	 public static void paint(){
		 int N=1;
		 StdDraw.setXscale(0,512);
		 StdDraw.setYscale(0,512*5);
		 StdDraw.setPenRadius(0.01);
		 StdDraw.setPenColor(Color.red);
		 for(int  i=1;i<=512;i++){
			 StdDraw.point(i, 6*i*(Math.log(i)));
		 }
		 StdDraw.setPenColor(Color.black);
		 while(N<=512){
			 sort(N);
			 N++;
		 }
	 }
	 public static void sort(int N){
	    	times =0;
	    	aux =randmomArr(N);
	    	sort(aux,0,N-1);
	    	StdOut.println();
	    	StdOut.println("times : "+times);
	    	StdDraw.point(N, times);
	    }
	    
	    public static Double[] randmomArr(int N){
	    	Double[] a =new Double[N];
	    	for(int i=0;i<a.length;i++)
	    		a[i]=StdRandom.uniform(0, 1.0*N*N);
	    	return a;
	    }
	    private static void  sort(Double[] a,int lo,int hi){
	    	if(hi<=lo) return ;
	    	int mid =lo+(hi-lo)/2;
	    	sort(a,lo,mid);
	    	sort(a,mid+1,hi);
	    	merge(a,lo,mid,hi);
	    	return ;
	    }
	    public static int  merge(Double[] a,int lo,int mid,int hi){
	    	
	    	int i=lo;
	    	int j=mid+1;
	    	for(int k=lo;k<=hi;k++)
	    		aux[k]=a[k];
	    	for(int k=lo;k<=hi;k++){
	    		if(i>mid) a[k]=aux[j++];
	    		else if(j>hi) a[k]=aux[i++];
	    		else if(less(aux[j],aux[i])) 
	    			{
	    			a[k]=a[j++];
	    			times++;
	    			}
	    		else {
	    			a[k]=a[i++];
	    			times++;
	    		}
	    	}
	    	return times;
	    	
	    }
	    private static boolean less(Double v,Double w){
	    	return v.compareTo(w)<0;
	    }
	    private static void exch(Double[] a,int i,int j){
	    	Double t=a[i];
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
         paint();
		}


}
