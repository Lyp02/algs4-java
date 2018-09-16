import java.util.Arrays;

import edu.princeton.cs.algs4.BinarySearch;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class TwoEqualSums {
  public int[] a;
  public TwoEqualSums(int cap,int MAX) {
	  a =new int[cap];
	  for(int i=0;i<cap;i++) {
		  a[i] =StdRandom.uniform(-MAX,MAX);
	  }
  }
  
  public int sums() {
	  int count =0;
	  for(int i=0;i<a.length;i++) {
		  for(int j=i+1;j<a.length;j++)
			  if(a[i]==a[j]) count++;
		      
	  }
	  return count;
  }
  public int toSum(int a) {
	 int sum=0;
	  for(int i=1;i<a;i++)
		  sum=sum+i;
	  return sum;
  }
  
  public int sumsFast() {
     int[] b =new int[a.length];
     int sum;
     int j=0;
     int count=0;
     for(int i=0;i<a.length;i++)
    	 b[i]=a[i];
     Arrays.sort(b);
     for(int i=0;i<a.length-1;) {
    	 j=i+1;
    	 sum =1;
    	 while((b[j]==b[i])) {
    		 j++;
    		 sum++;
    	 }
    	 i=i+sum;
    	 count =count +toSum(sum);
     }
     return count;
  }
  
  public static int TwoSumFaster(int[] a) {
  	int[] b =new int[a.length];
  	for(int k=0;k<a.length;k++)
  		b[k]=a[k];
  	Arrays.sort(b);
  	int i=0;
  	int j=a.length-1;
  	int count =0;
  	while((i<a.length)&&(j>=0)&&(j>i)) {
  		int temp =a[i]+a[j];
  		if(temp<0) i++;
  		if(temp==0) {
  			count++;
  			i++;
  		}
  		if(temp>0) j--;
  	}
  	
  return count;
  }
  public static void main(String[] args) {
	  TwoEqualSums a =new TwoEqualSums(20000000, 100000);
	  Stopwatch watch1 =new Stopwatch();
	  int result1=a.sums();
	  StdOut.println("counts: "+result1 +" time: "+watch1.elapsedTime());
	  Stopwatch watch2 =new Stopwatch();
	  int result2=a.sumsFast();
	  StdOut.println("counts: "+result2 +" time: "+watch2.elapsedTime());
	  
  }

}
