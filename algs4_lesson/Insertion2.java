import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Insertion2 {

	public static void sort(Comparable[] a){
    	int N=a.length;
    	Comparable temp =0;
    	int t=0;
        for(int i=1;i<N;i++){
        	temp = a[i];
        	for(int j =i;j>0&&less(temp,a[j-1]);j--)
        		{
        		a[j]=a[j-1];
        		t=j;
        		}
        	a[t]=temp;
        	
        	
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
      sort(a);
      assert isSorted(a);
      show(a);
	}


}
