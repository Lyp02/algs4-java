import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class QuickSortNoRecursion {

	public static void sort(Comparable[] a){
    	StdRandom.shuffle(a);
    	sort(a,0,a.length-1);
    }
    
    private static void sort(Comparable[] a,int lo,int hi){
    	if(hi<=lo) return;
    	Stack<Integer> st = new Stack<Integer>();
    	int i,j;
    	st.push(hi);
    	st.push(lo);
    	while(!st.isEmpty()){
    		i=st.peek();
    		st.pop();
    		j=st.peek();
    		st.pop();
    		StdOut.println();
    		StdOut.println(" i: "+i+" j: "+j);
    		if(i<j){
    			int k =partition(a, i, j);
    			StdOut.println();
    			StdOut.println(" i: "+i+" j: "+j+" k: "+k);
    			if(k-i>j-k){
    				st.push(k-1);
    				st.push(i);
    				if(j-k>0){
    					st.push(j);
    					st.push(k+1);
    				}
    			}
    			else{
    				st.push(j);
    				st.push(k+1);
    				if(k-i>0){
    					st.push(k-1);
    					st.push(i);
    				}
    			}

    		}
    				
    	}
    }
    private static int partition(Comparable[] a,int lo,int hi){
    	int i=lo,j=hi+1;
    	Comparable v =a[lo];
    	while(true){
    		while(less(a[++i],v)) if(i==hi) break;
    		while(less(v,a[--j])) if(j==lo) break;
    		if(i>=j) break;
    		exch(a, i, j);
    	}
    	exch(a,lo,j);
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
	     Integer[] test ={22,4,2,1,6,8,0,-1,4,12,-9,7,3,-99,23,76,1,90,-2,7,-8,13,27,89,12,17};
	     sort(test);
	     show(test);
      
	}
}
