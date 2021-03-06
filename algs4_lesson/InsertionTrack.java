import java.awt.Color;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class InsertionTrack {

	 public static void sort(Double[] a){
	    	int N=a.length;
	    	int temp =0;
	        for(int i=1;i<N;i++){
	        	temp=i;
	        	for(int j =i;j>0&&less(a[j],a[j-1]);j--)
	        		{
	        		exch(a, j, j-1);
                    temp=j;
	        		}
        		animation(a,temp-1,i);
        		StdDraw.show(1000);
	        }
	    }
	    
	    public static Double[] randomArr(int N){
	    	Double[] a=new Double[N];
	    	for(int i=0;i<N;i++){
	    		a[i]= StdRandom.uniform(0, 10*N*1.0);
	    	}
	    	return a;
	    		
	    }
	    private static void animation(Double[] a,int begin,int end){
	    	StdDraw.clear();
	    	StdDraw.setPenRadius();
	    	int N=a.length;
	    	StdDraw.setXscale(0, 1);
	    	StdDraw.setYscale(0, N*N);
	    	for(int i=0;i<a.length;i++){
	    		if(i>=begin && i<=end) StdDraw.setPenColor(Color.black);
	    		else StdDraw.setPenColor(Color.gray);
	    		double x =(1.0*i)/N;
	    		double y=a[i]/2.0;
	    		double rw =(0.5)/N;
	    		double rh=a[i]/2.0;
	    		StdDraw.filledRectangle(x, y, rw, rh);
	    	}
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
        int N =20;
        Double[] a =randomArr(N);
        sort(a);
		}

}
