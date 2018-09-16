import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.BinarySearch;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class practice_2_5 {
    public static void Qusetion2(){
    	Bag<String> bg =new Bag<String>();
    	HashSet<String> hs =new HashSet<String>();
    	StdOut.println("Input String:");
    	while(!StdIn.isEmpty()){
    		
    		String s = StdIn.readString();
    		bg.add(s);
    		StdOut.println("Input String:");
    		
    	}
    	StdOut.println("Input End :");
    	 StdOut.println(bg.size());
    	String[] strs =new String[bg.size()];
    	
    	//Arrays.sort(strs);
    	int k=0;
    	Iterator<String> i =bg.iterator();
    	while(i.hasNext()){
    		strs[k++] =i.next();
    	}
    	
    	String content;
    	for(int j=0;j<strs.length;j++){
    		content =strs[j];
    		for(int m=0;m<strs.length;m++){
    			if(m!=j){
    				String result =content +strs[m];
    				hs.add(result);
    				
    			}
    			
    		}
    		content =null;
    		
    	}
    	String[] des =new String[hs.size()];
    	Iterator<String> i1 =hs.iterator();
    	k=0;
    	while(i1.hasNext()){
    		des[k++]=i1.next();
    	}
    	StdOut.println("strs length : "+strs.length +" des length: "+des.length);
    	StdOut.println("Combination :");
    	 find(strs,des);
    	 StdOut.println();
    	
    
    }
    
    private static void find(Object[] a,Object[] b){
        Object aitem;
        Object bitem;
        
        for(int i=0;i<a.length;i++){
          aitem =a[i];
           for(int j=0;j<b.length;j++)
           {   
        	   bitem =b[j];
        	   //StdOut.println( "aitem: "+aitem+" bitem: "+bitem);
        	   if(bitem.equals(aitem))
        		   StdOut.println(aitem.toString());
           }
        }
        
    }
    
    public static void Question4(){
    	String[] test ={"Hello","World","Hello","Java","AI","java","Algoritimitic","3","End","ai","ai"};
    	String[] des =dedup(test);
    	StdOut.println("Print: ");
    	for(int i=0;i<des.length;i++){
    		StdOut.print( " "+des[i]);
    	}
    	StdOut.println();
    	StdOut.println("End:");
    }
    public static String[] dedup(String[] a){
    	String[] des;
    	Stack<String> st =new Stack<String>();
    	int max;
    	for(int i=a.length-1;i>=0;i--){
    		max=0;
    		for(int j=0;j<=i;j++){
    			if(a[max].compareTo(a[j])<0) max =j;    
    		}
			exch(a,max,i);
			if(i==a.length-1){
				st.push(a[i]);
			}else{
				if(a[i].compareTo(a[i+1])!=0)
					st.push(a[i]);
			}
      }
    	des =new String[st.size()];
    	int index =0;
    	while(st.size()>0){
    		des[index++]=st.pop();
    	}
    	return des;
    }
    
    public static void exch(Object[] a,int i,int j){
    	Object t =a[i];
    	a[i]=a[j];
    	a[j]=t;
    }
    
    public static void Question6(){
    	String[] test={"Hello","World","Hello","Java","AI","java","Algoritimitic","3","End","ai","ai"};
    	printArrs(test);
    	select(test, 0,test.length-1 );
    	printArrs(test);
    	
    }
    
    public static void printArrs(Object[] a){
    	StdOut.println("Print");
    	for(int i=0;i<a.length;i++)
    		StdOut.print(" "+a[i]);
    	StdOut.println();
    	StdOut.println("End");
    }
    public static void select(Comparable[] a,int lo,int hi){
    	if(hi<=lo) return;
    	int maxIndex =max(a,lo,hi);
    	StdOut.println(" "+maxIndex);
    	exch(a,maxIndex,hi);
    	select(a, lo, --hi);
    	
    }
    
    public static int  max(Comparable[] a,int lo,int hi){
    	int max =lo;
    	for(int i=lo;i<=hi;i++){
    		if(a[max].compareTo(a[i])<0) max =i;
    	}
    	return max;
    }
    
    public static void Question8(){
    	//泛型的equals函数不是调用期望的类的函数，而是调用Object 的equals函数
    	//耽误这么长时间没有做出来2018年7.13
    	//题目意思理解错了。
    	MaxPQ<StringTimes> pq =new MaxPQ<StringTimes>(100);
    	StdOut.println("Input String :");
    	int counts  =0;
    	String str;
    	StringTimes st;
    	
    	while(!StdIn.isEmpty()){
    		str =StdIn.readString();
    		st =new StringTimes(str,1);
    		int find =pq.contains(st);
    		if(find==-1){
    			pq.insert(st);
    		}else{
    			StdOut.println("AddA"
    					+ "");
    			pq.getKey()[find].add();
    			pq.swim(find);
    		}
    		StdOut.println("Input String :");
    	}
    	StdOut.println("Input End ");
    	StringTimes temp;
    	StdOut.println("Contents :");
    	while(pq.size()>0){
    		temp =pq.delMax();
    		StdOut.println(" String: "+temp.getString()+"  Times: "+temp.getTimes());
    	}
    	StdOut.println();
    	
    	
    }
    
    public static void Question8_1(){
    	String[] test ={"Hello","World","Hello","Java","AI","java","Algoritimitic","3","End","ai","ai","ai"};
    	MaxPQ<StringTimes> st =new MaxPQ<StringTimes>(100);
        int old =0;
        int cur =0;
        int count =0;
        int max =0;
        int N =test.length;
        for(int i=N-1;i>=0;i--){
        	max =0;
        	for(int j=0;j<=i;j++){
        		if(test[max].compareTo(test[j])<0) max =j;
        	}
        	exch(test,max,i);
        	if(i==N-1){  old =i;}
        	else if(!test[i].equals(test[i+1])){
        		
        		count =old -i;
        		st.insert(new StringTimes(test[old], count));
        		old =i;
        		StdOut.println(" i: "+i);
        	} 
        }
          //开头为单独元素时候需要额外记录。
        if(old ==0) st.insert(new StringTimes(test[old], 1));
        printArrs(test);
        StdOut.println(" Print StringTimes :");
        StringTimes temp;
        while(st.size()>0){
        	temp =st.delMax();
        	StdOut.println("String : "+temp.getString()+"  :  "+"Times: "+temp.getTimes());
        }
    	
    }
    public static void Question12(){
    	MinPQ<Task> tasks =new MinPQ<Task>();
    	for(int i=0;i<10;i++){
    		Task temp =new Task(""+i,StdRandom.uniform(0, i*1000.0+1));
    		tasks.insert(temp);
    	}
    	int counts =0;
    	StdOut.println();
    	while(tasks.size()>0){
    		Task result =tasks.delMin();
    		StdOut.println("Sequence : "+(counts++)+" Task Name : "+result.getString()+" timeused :"+result.getTime());
    	}
    }
   
   public static void Question13(){
	  int N =10;
	  int M =3;
	  Task  temp =null;
	  Task[] tasks =new Task[N];
	  IndexMinPQ<Task> pq =new IndexMinPQ<Task>(M+1);
	  for(int i=0;i<N;i++){
		  tasks[i]= new Task(" "+i, StdRandom.uniform(0,1.0+i*1000));
	  }
	  Arrays.sort(tasks);
	  int nextIndex =N-1;
	  for(int i=1;i<=M;i++){
		  pq.insert(i, tasks[nextIndex--]);
	  }
	  int minIndex =0;
	  Double timeTatal =0.0;
	  Double timeused =0.0;
	  
	  while(nextIndex>=1){
		  minIndex =pq.minIndex();
		  StdOut.println();
		  StdOut.println(" End Task : "+ " Name: "+pq.keyOf(minIndex).getString()+" Time: "+pq.keyOf(minIndex).getTime());
		  timeused =tasks[pq.delMin()].getTime();
		  timeTatal +=timeused;
		 
		  for(int i=1;i<=M;i++){
			  if(i!=minIndex){
				  temp =pq.keyOf(i);
				  pq.change(i,new Task(temp.getString(),temp.getTime()-timeused));
			  }
		  }
		  pq.insert(minIndex, tasks[nextIndex--]);
	  }
	  while(pq.size()>0){
		  minIndex =pq.minIndex();
		  temp =pq.keyOf(minIndex);
		  StdOut.println(" End Task : "+ " Name: "+pq.keyOf(minIndex).getString()+" Time: "+pq.keyOf(minIndex).getTime());
		  pq.delMin();
	  }
	  timeTatal +=temp.getTime();
	  StdOut.println("Total Time : "+timeTatal);
	  
   } 
   public static void Question14(){
	   String[] test ={"cs.princeton.edu","ai.princeton.edu","math.princeton.edu","princeton.edu",".java.mit.edu","mit.edu"};
	   Domain[] domain =new Domain[test.length];
	   for(int i=0;i<test.length;i++){
		   domain[i]=new Domain(test[i]);
	   }
	   Arrays.sort(domain);
	   StdOut.println();
	   for(int i=0;i<domain.length;i++){
		   StdOut.println("Sequence Index :"+i+" Name : ");
		   for(int k=0;k<domain[i].getName().length;k++){
			   StdOut.print(" "+domain[i].getName()[k]);
			   
		   }
		   StdOut.println();
	   }
   }
   
   public static void Question15(){
	   String[] test ={"Li","Ma","Deng","Sun","Po","Ret"};
	   FairStringComparator cp =new FairStringComparator();
	   Arrays.sort(test, cp);
	   StdOut.println();
	   for(int i=0;i<test.length;i++){
		   StdOut.println(" Sequence Index : "+i+" String : "+test[i]);
	   }
   }
   public static void Question16(){
	   String[] test ={"Li","Ma","Deng","Sun","Po","Ret","Li","Zhou","Li"};
	   SortMap[] sp = new SortMap[test.length];//类型转换创造数组
	   for(int i=0;i<test.length;i++)
		   sp[i] =new SortMap(test[i],i);
	   StdOut.println("");
	   StdOut.println(" Sort Before");
	   for(int i=0;i<test.length;i++)
		   StdOut.println(" Sequence : "+i+" Key: "+sp[i].getKey()+" Index: "+sp[i].getIndex());
	   StdOut.println(" End");
	   Arrays.sort(sp);
	  // Merge.sort(sp);
	   StdOut.println(" Sort After");
	   for(int i=0;i<test.length;i++)
		   StdOut.println(" Sequence : "+i+" Key: "+sp[i].getKey()+" Index: "+sp[i].getIndex());
	   StdOut.println(" End");
	   boolean result =check(sp);
	   if(result) StdOut.println("Stable");
	   else StdOut.println("UnStable");
	   
	   
   }
   public static void Question18(){
	   String[] test ={"Li","Ma","Deng","Sun","Po","Ret","Li","Zhou","Li"};
	   StableSort[] ss =new StableSort[test.length];
	   int counts =-1;
	   String[] result =new String[test.length];
	   result =stableSort(test,ss,counts);
	   StdOut.println("After Sort");
	   for(int i=0;i<result.length;i++)
		   StdOut.println(result[i]);
	   
   }
   public static String[] stableSort(String[] t,StableSort[] ss,int counts){
	   for(int i=0;i<t.length;i++){
		   int k =contains(ss,t[i],counts);
		   if(k==-1){
			   counts++;
			   ss[counts]=new StableSort(t[i], i);
		   }else{
			   ss[k].getQueue().enqueue(i);
		   }
	   }
	   int j=0;
	   String[] result =new String[t.length];
	   for(int i=0;i<=counts;i++){
		  while(ss[i].getQueue().size()>0){
			  result[j++] =t[ss[i].getQueue().dequeue()];
		  } 
	   }
	   
	   return result;

	   
   }
   
   public static int contains(StableSort[] a,String t,Integer counts){
	   if(counts ==-1) return -1;
	   else{
		   for(int i=0;i<=counts;i++){
			   if(a[i].getKey().compareTo(t)==0)
				   return i;
		   }
			   
	   }
	   
	   return -1;
   }
   public static boolean check(SortMap[] sp){
	   SortMap a;
	   SortMap b;
	   for(int i=0;i<sp.length-1;i++){
		   a=sp[i];
		   b=sp[i+1];
		   if(a.getKey().compareTo(b.getKey())==0){
			   if(a.getIndex()>b.getIndex())
				   return false;
		   }
		   
	   }
	   return true;
   }
   
   public static int[] indirestSort(Comparable[] c){
	   int[] index =new int[c.length];
	   for(int i=0;i<index.length;i++)
		   index[i]=i;
	   if(c.length==1) return index;
	   for(int i=1;i<=c.length-1;i++){
		   for(int j=i;j>0&&(c[index[j]].compareTo(c[index[j-1]])<0);j--){
			   int temp =index[j];
			   index[j] =index[j-1];
			   index[j-1]=temp;
		   }
	   }
	   return index;
   } 
   public static void Question27(){
	   Integer[] test =new Integer[12];
	   for(int i=0;i<test.length;i++){
		   test[i]=StdRandom.uniform(i*1000+1);
	   }
	   int[] result =indirestSort(test);
	   StdOut.println();
	   for(int i=0;i<test.length;i++)
		   StdOut.print("  "+test[result[i]]); 
   }
	public static void main(String[] args) { 
		// TODO Auto-generated method stub
 //      Question8_1();
//		Question12();
//		Question13();
//		Question14();
//		Question18();
		Question27();
	}

}
