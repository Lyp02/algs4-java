import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class practice_2_4 {
    public static void delMaxExp(){
    	int maxN =120;
    	Character c;
    	Character result;
    	MaxPQ<Character> pq =new MaxPQ<Character>(maxN);
    	StdOut.println("---Input the Char---");
    	while(!StdIn.isEmpty()){
    		 c =StdIn.readChar();
    		if(c.charValue()=='*'){
    		    if(pq.size()>0){
    			result =pq.delMax();
    		    }
    		    else{
    		    	StdOut.println("Empty MaxPQ cannot delMax!!");
    		    	return;
    		    }
    		    StdOut.println("delMax: "+result);
    		  
    		}
    		else pq.insert(c);
    	}
    }
    public static void Question5(){
    	String[] strs ={"E","A","S","Y","Q","E","S","T","I","O","N"};
    	int maxN =120;
    	String result;
    	MaxPQ<String> pq =new MaxPQ<String>(maxN);
    	for(int i=0;i<strs.length;i++){
    		pq.insert(strs[i]);
    	}
    	StdOut.println("After heap sort");
    	int k =0;
    	while(pq.size()>0){
    		result =pq.delMax();
    		StdOut.print(" "+k+" : "+result+">");
    		k++;
    	}
    	StdOut.println();
    	
    }
    public static void Question6(){
    	String[] strs ={"P","R","I","O","*","R","*","*","I","*","T","*","Y","*","*","*","Q","U","E","*","*","*","U","*","E"};
    	int maxN =120;
    	String result;
    	
    	MaxPQ<String> pq =new MaxPQ<String>(maxN);
    	for(int i=0;i<strs.length;i++){
    		if(strs[i].equals("*")){
    			pq.delMax();
    		}else{
    			pq.insert(strs[i]);
    		}
    		StdOut.println();
    		printMaxPQ(pq);
    	}
    	
    }
    
    public static void Permutation(String[] des,String[] content,int[] src,int deep,HashSet<String> hs){
    	if(deep==content.length){
    		String[] des1;
    		int[] src1;
    		des1=des.clone();
    		src1=src.clone();
    		des1[deep-1] =content[src1[0]];
    		src1[0]=Integer.MAX_VALUE;
    		Arrays.sort(src1);
    		//String st =des1.toString();
    		String st="";
    		for(int i=0;i<des1.length;i++)
    			st=st+des1[i];
    		hs.add(st);
    		StdOut.println((content.length-deep+1)+" :"+" "+0);
    		StdOut.println(" heap content : "+st );
    		return;
    	}
    //	@SuppressWarnings("unchecked")
		String[] des1 ;
    	int[] src1; 
    	for(int i=0;i<=content.length-deep;i++){
    		 des1 = des.clone();
    		src1 =src.clone();
    		des1[deep-1]=content[src1[i]];
    		src1[i]=Integer.MAX_VALUE;
    		Arrays.sort(src1);
    		StdOut.println((content.length-deep+1)+" :"+" "+i);
    		int deep1 =deep+1;
    		Permutation(des1, content, src1, deep1, hs);
    		
    	}
    }
    public static void Question9(){
    	String[] content1 ={"A","B","C","D","E"};
    	String[] content2 ={"A","A","A","B","B"};
    	int[] src1 ={0,1,2,3,4};
    	int[] src2 ={0,1,2,3,4};
    	int maxN =10;
    	HashSet<String> hs1 =new HashSet<String>();
    	HashSet<String> hs2 =new HashSet<String>();
    	String[] des1 =new String[content1.length];
    	String[] des2 =new String[content2.length];
    	int deep1 =1;
    	int deep2 =1;
    	Permutation(des1,content1,src1,deep1,hs1);
    	Permutation(des2,content2,src2,deep2,hs2);
    	StdOut.println();
    	StdOut.println("content: "+content1.toString()+" : heaps:");
    	Iterator<String> i =hs1.iterator();
    	int count =0;
    	StdOut.println(" hs1 size: "+hs1.size());
    	while(i.hasNext()){

    		StdOut.println(" "+i.next());
    		if((count%12)==0) StdOut.println();
    		count++;
    	}
    	
    	StdOut.println();
    	StdOut.println("content: "+content2.toString()+" : heaps:");
    	Iterator<String> i1 =hs2.iterator();
    	 count =0;
    	 StdOut.println(" hs2 size: "+hs2.size());
    	while(i1.hasNext()){
    		
    		StdOut.println(" "+i1.next());
    		if((count%12)==0) StdOut.println();
    		count++;
    	}
    	
    }
    public static void printMaxPQ(MaxPQ<String> pq){
    	Iterator<String> i = pq.iterator();
    	int index =1;
    	StdOut.println("contents: ");
    	while(i.hasNext()){
    		String s =i.next();
    		StdOut.print(" "+index+" : "+s);
    		index++;
    	}
    	StdOut.println();
    	
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//        delMaxExp();
//        Question5();
//		  Question6();
		  Question9();
        
	}

}
