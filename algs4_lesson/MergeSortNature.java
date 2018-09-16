import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class MergeSortNature {
    public static void Sort(Integer[] a){
    	Integer[] aux =new Integer[a.length];
    	while(true){
    		int lo=0;
    		int mid =FindBlock(lo,a)-1;
    		if(mid ==a.length-1)
    			break;
    		while(mid<a.length-1){
    			int hi =FindBlock(mid+1,a)+mid;
    			Merge(lo,mid,hi,a,aux);
    			lo=hi+1;
    			mid =FindBlock(lo,a)+lo-1;
    		}
    	}
    }
    
    private static void Merge(int lo,int mid,int hi,Integer[] a,Integer[] aux){
    	for(int k =lo;k<=hi;k++){
    		aux[k]=a[k];
    	}
    	int i =lo,j=mid+1;
    	for(int k=lo;k<=hi;k++){
    		if(i>mid){
    			a[k]=aux[j++];
    		}
    		else if(j>hi){
    			a[k]=aux[i++];
    		}
    		else if(aux[j]<aux[i]){
    			a[k]=aux[j++];
    		}else{
    			a[k]=aux[i++];
    		}
    	}
    	
    }
    private static int FindBlock(int lo,Integer[] a){
    	int size =1;
    	for(int i=lo;i<a.length-1;i++){
    		if(a[i]<=a[i+1])
    			size++;
    		else break;
    	}
    	return size;
    }
    
    public static void main(String[] args){
    	int N=24;
    	Integer[] a =new Integer[N];
    	for(int i=0;i<a.length;i++){
    		a[i]=StdRandom.uniform(0, N*N);
    	}
    	Sort(a);
    	StdOut.println("Print Arrays");
    	for(int i=0;i<N;i++)
    		StdOut.print(" "+a[i]);
    	StdOut.println();
    	StdOut.println("Print End");
    }
}
