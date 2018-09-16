import java.util.Arrays;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class StaticSETofInts {
    private int[] a;
    public StaticSETofInts(int[] keys) {
    	a =new int[keys.length];
    	for(int i=0;i<keys.length;i++)
    		a[i]=keys[i];
    	Arrays.sort(a);
    }
    public boolean contains(int key) {
    	return rank(key)!=-1;
    }
    private int rank(int key) {
    	int lo=0;
    	int hi=a.length-1;
    	while(lo<=hi) {
    		int mid =lo+(hi -lo)/2;
    		if(key<a[mid]) hi=mid-1;
    		else if(key>a[mid]) lo=mid+1;
    		else return mid;
    	}
    	return -1;
    }
    public int howMany(int key,int pos) {
    	return rank(0,a.length-1,a,key,pos);
    }
    
    public static int rankLowIndex(int lo,int hi,int[] a,int key,int pos) {
    	if(lo>hi) return pos;
    	int mid=lo+(hi -lo)/2;
    	if(key<a[mid]) return rankLowIndex(lo,mid-1,a,key,pos);
    	if(key>a[mid]) return rankLowIndex(mid+1,hi,a,key,pos);
    	else {
    		pos =mid;
    		return rankLowIndex(lo,mid-1,a,key,pos);
    	}
    }
    
    public static int rankHighIndex(int lo,int hi,int[] a,int key,int pos) {
    	if(lo>hi) return pos;
    	int mid=lo+(hi -lo)/2;
    	if(key<a[mid]) return rankHighIndex(lo,mid-1,a,key,pos);
    	if(key>a[mid]) return rankHighIndex(mid+1,hi,a,key,pos);
    	else {
    		pos =mid;
    		return rankHighIndex(mid+1,hi,a,key,pos);
    	}
    }
    public static int rank(int lo,int hi,int[] a,int key,int pos) {
    	if(lo>hi) return -1;
    	int mid=lo+(hi -lo)/2;
    	if(key<a[mid]) return rank(lo,mid-1,a,key,pos);
    	if(key>a[mid]) return rank(mid+1,hi,a,key,pos);
    	else {
    		pos=mid;
    		return rankHighIndex(mid+1, hi, a, key, pos) -rankLowIndex(lo, mid-1, a, key, pos)+1;
    	}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       int[] w =In.readInts(args[0]);
       StaticSETofInts set =new StaticSETofInts(w);
       while(!StdIn.isEmpty()) {
    	   int key =StdIn.readInt();
    	   int pos =-1;
    	   if(set.contains(key))
    		   {
    		   StdOut.println(" Key: "+ key +" Counts"+set.howMany(key, pos));
    	       StdOut.println();
    	       }
    	   else
    		   {
    		   StdOut.println(" Key:"+key+" is not in the set");
    		   StdOut.println();
    		   }
       }
	}

}
