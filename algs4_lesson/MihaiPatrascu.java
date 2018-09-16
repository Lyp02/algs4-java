import java.util.Arrays;

import edu.princeton.cs.algs4.BinarySearch;
import edu.princeton.cs.algs4.FileIndex;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/* 用加减法实现二分查找   Fk_1 =1 要停止*/
public class MihaiPatrascu {
    public static int find(int[] a,int key,int start,int Fk,int Fk_1) {
    	int Fk_2 =Fk -Fk_1;//Fk_1时刻 Fk_2变成递增
    	int Fk_3 =Fk_1-Fk_2;
    	//split two parts [start,start+Fk_2],[start+Fk_2,start+Fk_2+Fk_1]
    	if(Fk<0) return -1;
    	if(Fk_1==1) {
    		if(a[start]==key) return start;
    		else if(a[start+Fk]==key) return(start+Fk);
    		else return -1;
    		
    	}
    	if((start +Fk_2)<0) return -1;
    	if((start+Fk_2)>a.length-1) {
    		StdOut.println("Start : "+start +" Fk_2 "+Fk_2);
    	}
    	if(a[start+Fk_2]> key) return find(a,key,start,Fk_2,Fk_3);
    	if(a[start+Fk_2]<key)  return find(a,key,start+Fk_2,Fk_1,Fk_2);
    	else {
    		StdOut.println();
    		StdOut.println("Find: Index : "+(start+Fk_2)+" Value: "+a[start+Fk_2]);
    		return (start+Fk_2);
    	}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
     int N =12000000;
     int[] a =new int[N];
     for(int i=0;i<N;i++) {
    	 a[i] =StdRandom.uniform(-360000000,360000000);
     }

     //找到第一个大于等于数组长度的的裴波那契数
     //产生裴波那契数组Index:0~lens
     int[] fb =new int[N];
     fb[0]=1;
     fb[1]=1;
     int lens =0;
     for(int i=2;i<N;i++) {
    	 fb[i]=fb[i-1]+fb[i-2];
    	 if(fb[i]>=N-1) { 
    		 lens =i;
    		 break;
    		 }
     }
     StdOut.println();
     StdOut.println(" Fb["+lens+"] :"+fb[lens]+"  Fb["+(lens -1)+"]"+fb[lens-1]+"  N-1: "+(N-1));
     Arrays.sort(a);
     int [] b =new int[fb[lens]+1];
     for(int i =0;i<=fb[lens];i++) {
    	 if(i<=N-1) b[i]=a[i];
    	 else b[i]=a[N-1];
     }
     Stopwatch timer =new Stopwatch();
     int Index1=find(b, a[78], 0, fb[lens], fb[lens-1]);
     StdOut.println();
     StdOut.println("Time:"+timer.elapsedTime() +" Index "+Index1);
     Stopwatch timer2 =new Stopwatch();
     int Index =BinarySearch.rank(a[78], b);
     StdOut.println();
     StdOut.println("Time:"+timer2.elapsedTime() +" Index "+Index);
     

	}

}
