import java.util.Arrays;

import edu.princeton.cs.algs4.BinarySearch;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class practise1_4 {
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
    // the number of an element in the array
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
    
    public static int rank(int lo,int hi,int[] a,int key) {
    	if(lo>hi) return -1;
    	int mid=lo+(hi -lo)/2;
    	if(key<a[mid]) return rank(lo,mid-1,a,key);
    	if(key>a[mid]) return rank(mid+1,hi,a,key);
    	else {
    		return mid;
    	}
    }
    
    
    public static int rank(int lo,int hi,double[] a,double key) {
    	if(lo>hi) return -1;
    	int mid=lo+(hi -lo)/2;
    	if(key<a[mid]) return rank(lo,mid-1,a,key);
    	if(key>a[mid]) return rank(mid+1,hi,a,key);
    	else {
    		return mid;
    	}
    }
    public static void  printCommon(int[] a,int[] b) {
    	int[] a1 =new int[a.length];
    	int[] b1 =new int[b.length];
    	StdOut.println("Array 1:");
    	for(int i=0;i<a.length;i++) {
    		a1[i]=a[i];
    		StdOut.print(" "+a[i]);
    		if(i%9 ==0)
    			StdOut.println();
    	}
    	StdOut.println();
    	StdOut.println("Array 2:");
    	for(int i=0;i<b.length;i++) {
    		b1[i]=b[i];
    		StdOut.print(" "+b[i]);
    		if(i%9==0)
    			StdOut.println();
    	}
    	StdOut.println();
    	Arrays.sort(a1);
    	Arrays.sort(b1);
    	Queue<Integer> q =new Queue();
    	for(int i=0,j=0;(i<a1.length)&&(j<b1.length);) {
    		if(a1[i] == b1[j]) {
    			q.enqueue(a1[i]);
    			i++;
    			j++;
    		}
    		else if(a1[i]>b1[j]) {
    			j++;
    		}
    		else if(a1[i]<b1[j]) {
    			i++;
    		}
    	}
    	StdOut.println("Common :");
    	int count =0;
    	while(q.size()>0) {
    		StdOut.print(" "+q.dequeue());
    		count++;
    		if(count %9 ==0)
    			StdOut.println();
    	}
    	
    	
	   }
    public static int FoursumFast(int[] a) {
    	if(a.length<4) {
    		StdOut.println("Not enough nums");
    		return -1;
    	}
    	int[] b =new int[a.length];
    	int count =0;
    	for(int i=0;i<b.length;i++) {
    		b[i]=a[i];
    	}
    	Arrays.sort(b);
    
    		for(int i=0;i<b.length;i++)
    			for(int j=i+1;j<b.length;j++)
    				for(int k=j+1;k<b.length-1;)
    					
    				{   
    					int pos =-1;
    					int num=0;
    					int temp =rank(k+1,b.length-1,b,(-b[i]-b[j]-b[k]),pos);
    					if(temp>0)
    					{
    				
    				    count=count+temp;
    				    k++;
    					}
    					else k++;
    					

    				}

    return count;
    
    }
    public static int FoursumFast1(int[] a) {
    	if(a.length<4) {
    		StdOut.println("Not enough nums");
    		return -1;
    	}
    	int[] b =new int[a.length];
    	int count =0;
    	int tempsum =0;
    	int temp=0;
    	for(int i=0;i<b.length;i++) {
    		b[i]=a[i];
    	}
    	Arrays.sort(b);
    
    		for(int i=0;i<b.length;i++)
    			for(int j=i+1;j<b.length;j++)
    				for(int k=j+1;k<b.length-1;)
    					
    				{   if((tempsum==b[i]+b[j]+b[k])&&(k>2)&&(temp>0)) {
    					count=count +temp;
    					k++;
    					continue;
    				}
    					
    					tempsum=b[i]+b[j]+b[k];
    					int pos =-1;
    					int num=0;
    					temp =rank(k+1,b.length-1,b,-tempsum,pos);
    					if(temp>0)
    					{
    				
    				    count=count+temp;
    				    k++;
    					}
    					else k++;
    					

    				}

    return count;
    
    }
    public static int Foursum(int[] a) {
    	if(a.length<4)
    	{
    		StdOut.println("Not  enough nums");
    		return -1;
    	}
    	int count=0;
    	for(int i=0;i<a.length;i++)
    		for(int j=i+1;j<a.length;j++)
    			for(int k=j+1;k<a.length;k++)
    				for(int m =k+1;m<a.length;m++)
    					if((a[i]+a[j]+a[k]+a[m])==0) 
    						count++;
    	return count;
    }
    public static int ThreeSum(int[] a) {
    	int[] b =new int[a.length];
    	for(int i=0;i<b.length;i++)
    		b[i]=a[i];
    	int count=0;;
    	Arrays.sort(b);
    	for(int i=0;i<b.length;i++)
    		for(int j=i+1;j<b.length;j++)
    			for(int k=j+1;k<b.length;k++)
    				if((b[i]+b[j]+b[k])==0) count++;
    	return count;
    	
   
    }
    public static int ThreeSumFaster(int[] a) {
    	int[] b =new int[a.length];
    	for(int i=0;i<b.length;i++)
    		b[i]=a[i];
    	int count =0;
    	int temp;
    	int tempsum;
    	int m;
    	for(int i=0;i<a.length;i++) {
    		int k =a.length-1;
    		for(int j=i+1;(j<a.length)&&(k>j);) {
    			tempsum =a[i]+a[j]+a[k];
    			if(tempsum <0) j++;
    			if(tempsum >0) k--;
    			if(tempsum==0) {
    			  count++;
    			  j++;
    			}
    			
    			
    		}
    	}
    	
    	return count;
    			
    }
    public static int TwoSumFast(int[] a) {
    	int[] b =new int[a.length];
    	for(int i=0;i<b.length;i++)
    		b[i]=a[i];
    	Arrays.sort(b);
    	int count=0;
    	for(int i=0;i<b.length;i++)
    		if(BinarySearch.rank(-b[i], b)>i)
    			count++;
    	return count;
    }
    public static int TwoSumFast1(int[] a) {
    	int[] b =new int[a.length];
    	for(int i=0;i<b.length;i++)
    		b[i]=a[i];
    	Arrays.sort(b);
    	int count=0;
    	int temp;
    	int lens;
    	int pos;
    	for(int i=0;i<b.length-1;i++)
    	{
    		pos =-1;
    		lens=rank(i+1,b.length-1,b,-b[i],pos);
    		if(lens >0) count=count+lens;
    		
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
    	while((i<b.length)&&(j>=0)&&(j>i)) {
    		int temp =b[i]+b[j];
    		if(temp<0) i++;
    		if(temp==0) {
    			int k=j-1;
    			count++;
    			while(((b[k]+b[i])==0)&&(k>i)) {
    				k--;
    				count++;
    			}
    			i++;
    		}
    		if(temp>0) j--;
    	}
    	
    return count;
    }
    
    public static int TwoSumFaster1(int[] a) {
    	int[] b =new int[a.length];
    	for(int k=0;k<a.length;k++)
    		b[k]=a[k];
    	Arrays.sort(b);
    	int i=0;
    	int j=a.length-1;
    	int count =0;
    	while((i<b.length)&&(j>=0)&&(j>i)) {
    		int temp =b[i]+b[j];
    		if(temp<0) i++;
    		if(temp==0) {
    			count++;
    			i++;
    		}
    		if(temp>0) j--;
    	}
    	
    return count;
    }
    
    public static int TwoSum(int[] a) {
    	int count =0;
    	int[] b =new int[a.length];
    	for(int i=0;i<a.length;i++)
    		for(int j=i+1;j<a.length;j++)
    			if((a[i]+a[j])==0) count++;
    	return count;
    }
    public static void FindCloseMinmun(double[] a) {
    	double a1[] =new double[a.length];
    	double b[] =new double[a.length-1];
    	for(int i=0;i<a1.length;i++) {
    		a1[i]=a[i];
    	}
    	Arrays.sort(a1);
    	for(int i=0;i<b.length;i++) {
    		b[i]=a1[i+1]-a1[i];
    	}
        int minIndex =0;
        int temp;
        for(int i=0;i<b.length;i++) {
        	if(b[minIndex]>b[i]) minIndex =i;
        }
        StdOut.println("Minmum :"+a1[minIndex+1]+" "+a1[minIndex]);
    	 
    	
    		
    }
    
    public static double FindCloseMin1(int lo,int hi,double[] a) {
    	int mid =lo+(hi -lo)/2;
    	if(hi==lo)  return 9999.0;//一个数时候认为距离为9999
    	if(hi==lo+1) return a[hi]-a[lo];
    	double d =a[mid]-a[mid-1];
    	double b =FindCloseMin1(lo, mid-1, a);
    	double c=FindCloseMin1(mid, hi, a);
    	if(b<d) d=b;
    	if(c<d) d=c;
    	return d;
   }
    
    public static void FindCloseMax(double[] a) {
    	double a1[] =new double[a.length];
    	double b[] =new double[a.length-1];
    	for(int i=0;i<a1.length;i++) {
    		a1[i]=a[i];
    	}
    	Arrays.sort(a1);
        StdOut.println("Maxmum :"+a1[a1.length-1]+" "+a1[0]);
    	 
    	
    		
    }
    
    public static int FindArrayMin(int lo,int hi,int[] b) {
    	int a[] =new int[b.length];
    	for(int i=0;i<a.length;i++) {
    		a[i]=b[i];
    	}
    	if((hi-lo)<2) return -1;
    	else {
    		int mid =lo+(hi-lo)/2;
    		if((a[mid]<=a[mid-1])&&(a[mid]<=a[mid+1])) {
    			StdOut.println("Index: "+mid+" "+a[mid-1] +" "+a[mid]+" "+a[mid+1]);
    			return mid;
    		}
    		else if((a[mid]>a[mid-1])&&(a[mid]<=a[mid+1])) return FindArrayMin(lo, mid-1, b);
    		else if((a[mid]>a[mid-1])&&(a[mid]>a[mid+1])) {
    			if(a[mid-1]<a[mid+1]) return FindArrayMin(lo, mid-1, b);
    			else return FindArrayMin(mid+1, hi, b);
    		}
    		else if((a[mid]<=a[mid-1])&&(a[mid]>a[mid+1])) return FindArrayMin(lo, mid+1, b);
    		}
    	return -1;
    	}
    
    public static int FindArrayMin1(int lo,int hi,int[] b) {
    	int a[] =new int[b.length];
    	for(int i=0;i<a.length;i++) {
    		a[i]=b[i];
    	}
    	if((hi-lo)<2) return -1;
    	else {
    		int mid =lo+(hi-lo)/2;
    		if(a[mid]>a[mid-1]) return FindArrayMin1(lo, mid-1, a);
    		if(a[mid]>a[mid+1]) return FindArrayMin1(mid+1, hi, a);
    		else {
    			StdOut.println("Index: "+mid+" "+a[mid-1] +" "+a[mid]+" "+a[mid+1]);
    			return mid;
    		}
    	}
    	}
    public static int findColMin(int col,int N,int[][] a) {
    	int min =a[0][col];
    	int row =0;
    	for(int i=0;i<N;i++) {
    		if(a[i][col]<min) {
    			min =a[i][col];
    			row =i;
    		}
    		
    	}
    	return row;
    }
    
    public static int FindArrMin(int col,int N,int[][] a) {// O(nlogn)
    	int row =findColMin(col, N, a);
    	if((col==0)||(col==N-1)) {
    		return row;
    	}
    	else if((a[col-1][row]<a[col][row]))
    			return FindArrMin((col-1)/2, N, a);
    	else if((a[col+1][row]<a[col][row]))
    		return FindArrMin((col+N)/2, N, a);
    	else {
    		StdOut.println("Find! <"+row+" , "+col+">"+"  "+a[row][col]);
    		return row;
    	}
    	
    	
    }
    
    public static int  findRowOrColMin(int[][]a,int option, int cur, int begin,int end) {
    	if(option%2==0) {
    		//RowFind
    		int minIndex =0;
    		int min =a[cur][0];
    		for(int i=begin;i<=end;i++) {
    			if(a[cur][i]<min) {
    				min =a[cur][i];
    				minIndex =i;
    			}
    		}
    		return minIndex;
    	}
    	
    	else{
    		//ColFind
    		int minIndex =0;
    		int min =a[0][cur];
    		for(int i=begin;i<=end;i++) {
    			if(a[i][cur]<min) {
    				min =a[i][cur];
    				minIndex =i;
    			}
    		}
    		return minIndex;
    	}
    }
    
    public static int FindArrMin2(int[][]a,int option,int cur,int begin,int end) {
    	int RowOrCol =findRowOrColMin(a, option, cur, begin, end);
    	if((RowOrCol ==begin)||(RowOrCol ==end)) {
    		if((option%2)==0) {
    			//Row
    			StdOut.println(" < "+cur+" , "+RowOrCol+" >" +a[cur][RowOrCol]);
    			
    		}
    		else {
    			//Col
    			StdOut.println(" < "+RowOrCol+" , "+cur+" >"+a[RowOrCol][cur]);
    			
    		}
    		return RowOrCol;
    	}
    	
    	else {
    		if(option%2==0) {
    			//Row
    			if(a[cur-1][RowOrCol]<a[cur][RowOrCol])
    				return FindArrMin2(a, ++option, RowOrCol, begin, cur-1);
    			if(a[cur+1][RowOrCol]<a[cur][RowOrCol])
    				return FindArrMin2(a, ++option, RowOrCol, cur+1, end);
    			else {
    				StdOut.println("Find!");
    				StdOut.println(" < "+cur+" , "+RowOrCol+" >"+" "+a[cur][RowOrCol]);
    				return RowOrCol;
    					
    				
    			}
    		}
    		
    		else {
    			//Col
    			if(a[RowOrCol][cur-1]<a[RowOrCol][cur])
    				return FindArrMin2(a, ++option, RowOrCol, begin, cur-1);
    			if(a[RowOrCol][cur+1]<a[RowOrCol][cur])
    				return FindArrMin2(a, ++option, RowOrCol, cur+1, end);
    			else {
    				StdOut.println("Find!");
    				StdOut.println(" <  "+RowOrCol+" , "+cur+"  >"+" "+a[RowOrCol][cur]);
    				return RowOrCol;
    					
    				
    			}
    		}
    	}
    }
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int N=20;
        int[][] a1 =new int[N][N];
        StdOut.println("*****a1[][]******");
        for(int i=0;i<N;i++)
        	for(int j=0;j<N;j++) {
        		if(j==0) StdOut.println();
        		a1[i][j]=StdRandom.uniform(-9, 9);
        		StdOut.print(" "+a1[i][j]+"  ");
        	}
        StdOut.println();
        StdOut.println("Result");
        FindArrMin((N-1)/2, N, a1);
        StdOut.println();
        StdOut.println("Result1:");
        int option =0;
        FindArrMin2(a1, option, (a1.length-1)/2, 0, a1.length-1);
//		double[] arr =new double[10000000];
//		int[] arr1 =new int[arr.length];
//		for(int i=0;i<arr.length;i++) {
//			arr[i]=StdRandom.uniform(-1000000000, 1000020000);
//			arr1[i]=StdRandom.uniform(-999999999, 999999999);
//		}
//		Arrays.sort(arr);
//		StdOut.println();
//		Stopwatch timer1 =new Stopwatch();
//		double temp =FindCloseMin1(0, arr.length-1, arr);
//       StdOut.println(" NlogN : "+temp+" "+timer1.elapsedTime());
//        Stopwatch timer2 =new Stopwatch();
//		FindCloseMinmun(arr);
//		StdOut.println(" "+timer2.elapsedTime());
//		Stopwatch timer3 =new Stopwatch();
//		FindArrayMin(0, arr1.length-1, arr1);
//		StdOut.println("  "+timer3.elapsedTime());
//		Stopwatch timer4 =new Stopwatch();
//		FindArrayMin1(0, arr1.length-1, arr1);
//		StdOut.println("  "+timer4.elapsedTime());
		

		
//		double[] d =new double[100];
//		StdOut.println("*********************");
//		for(int i=0;i<d.length;i++) {
//			if(i%9==0) StdOut.println();
//			d[i]=StdRandom.uniform(-100000, 100000);//这边变化怎么会导致程序出错？
//			StdOut.print(" "+d[i]);
//		}
//		FindCloseMinmun(d);
//		FindCloseMax(d);
		
		
		
//		int[] a =new int[1000];
//		int[] b =new int[100];
//		for(int i=0;i<a.length;i++)
//			{
//			a[i]=StdRandom.uniform(-10, 10);
//			}
//		Stopwatch timer7 =new Stopwatch();
//		StdOut.println(" FourSum :" + Foursum(a));
//		StdOut.println(" time : "+timer7.elapsedTime());
//		Stopwatch timer8 =new Stopwatch();
//		StdOut.println(" FourSumFast: "+FoursumFast(a));
//		StdOut.println(" time : "+timer8.elapsedTime());
//		Stopwatch timer9 =new Stopwatch();
//		StdOut.println(" FourSumFast1: "+FoursumFast1(a));
//		StdOut.println(" time : "+timer9.elapsedTime());
//		Stopwatch timer1 =new Stopwatch();
//		StdOut.println(" TwoSum :" + TwoSum(a));
//		StdOut.println("time :" +timer1.elapsedTime());
//		Stopwatch timer2 =new Stopwatch();
//		StdOut.println("TwoSumFast :"+TwoSumFast(a));
//		StdOut.println("time :" +timer2.elapsedTime());
//		Stopwatch timer3 =new Stopwatch();
//		StdOut.println(" TwoSumFaster: "+TwoSumFaster(a));
//		StdOut.println("time :" +timer3.elapsedTime());
//		Stopwatch timer4 =new Stopwatch();
//		StdOut.println(" TwoSumFaster1: "+TwoSumFaster1(a));
//		StdOut.println("time :" +timer4.elapsedTime());
//		Stopwatch timer5 =new Stopwatch();
//		StdOut.println("TwoSumFast1 :"+TwoSumFast1(a));
//		StdOut.println("time :" +timer5.elapsedTime());
//		for(int i=0;i<b.length;i++)
//		{
//		b[i]=StdRandom.uniform(-5, 6);
//		}
//		Arrays.sort(b);
//		StdOut.println("********Arrays Print***********");
//		for(int i=0;i<b.length;i++) {
//			if((i%9)==0)
//				StdOut.println();
//			StdOut.print(" "+b[i]);
//		}
//		StdOut.println("********************************");
//		for(int i=-5;i<6;i++) {
//			int pos =-1;
//          StdOut.println( i+" :"+rank(0, b.length-1, b, i, pos));
//		}
//		int pos =-1;
//		Arrays.sort(a);
//		for(int i=0;i<a.length;i++)
//		{
//		if(i%5==0) StdOut.println();
//		StdOut.print(" "+a[i]);
//		}
//		int find =rank(0,a.length-1,a,9,pos);
//		StdOut.println();
//		StdOut.println(" find minum index : "+find);
//		printCommon(a, b);

	}

}
