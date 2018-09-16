import javax.activation.CommandInfo;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Shell_1 {

	public static void sort(Comparable[] a){
    	int N=a.length;
        int h=1;
        while(h<N/3) h=3*h+1;//must end with 1
        while(h>=1){
           splitsort(a, h);
        	h=h/3;
        }
        }
	
	private static void splitsort(Comparable[] a,int h){
		Comparable Max =a[0] ;
		int N =a.length;
		StdOut.println(" < "+a.length+"  "+h+" >"+" "+(N-1)/h);
		Comparable[][] arrs =new Comparable[h][((N-1)/h)+1]; //²¹È«
		for(int i=0;i<N;i++)
			if(Max.compareTo(a[i])<0) Max =a[i];
		for(int i=0;i<arrs.length;i++)
			for(int j=0;j<arrs[0].length;j++)
				arrs[i][j]=Max;
		for(int i=0;i<N;i++){
			StdOut.println( i +" "+(i%h)+" "+(i/h));
			arrs[i%h][i/h] =a[i];
		}
		for(int i=0;i<h;i++){
			Insertion.sort(arrs[i]);
		}
		for(int i=0;i<N;i++){
			a[i]=arrs[i%h][i/h];
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
      String[] a =In.readStrings();
      StdOut.println("Shell Sort");
      sort(a);
      assert isSorted(a);
      show(a);
	}

}
