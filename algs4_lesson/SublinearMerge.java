import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class SublinearMerge {
    private int[] a ;
    private int N;
    private int M;
    private int[] block;
    private int[] blockIndex;
    
    public SublinearMerge(int N,int M){
    	this.N=N;
    	this.M=M;
    	a =new int[N];
    	block =new int[M];
    	blockIndex =new int[N/M];
    	for(int i=0;i<blockIndex.length;i++)
    		blockIndex[i]=i;
    	for(int i=0;i<N;i++)
    		a[i]=StdRandom.uniform(0, N*N);
    	//Insertion sort each block
    	for(int i=1;i<=(N/M);i++){
    		sort(a,(i-1)*M,i*M-1);
    		
    	}
    	StdOut.println("Print Arrays");
    	for(int i=0;i<(N);i++){
    		if((i%(M))==0) {
    			StdOut.println();
    			StdOut.println((i/M)+" : " +i);}
    		StdOut.print(a[i]+" ");
    	}
    	StdOut.println();
    	StdOut.println("Print End");
    	//each blockIndex Insertion sort
   	for(int i=1;i<(N/M);i++){
   		    
    		for(int j=i;j>0&&(a[blockIndex[j]*M]<=a[blockIndex[j-1]*M]);j--){
    			int Indextemp =blockIndex[j-1];
    			blockIndex[j-1]=blockIndex[j];
    			blockIndex[j]=Indextemp;
    		}
    	   	StdOut.println("Index Block");
    	   	for(int x=0;x<blockIndex.length;x++)
    	   		StdOut.print("  <"+blockIndex[x] +" : "+a[blockIndex[x]*M]+" >");
    	   	StdOut.println();
    	   	StdOut.println("Index Block End");
   	}
   	StdOut.println("Index Block");
   	for(int i=0;i<blockIndex.length;i++)
   		StdOut.print("  <"+blockIndex[i] +" : "+a[blockIndex[i]*M]+" >");
   	StdOut.println();
   	StdOut.println("Index Block End");
   	StdOut.println("After Inser Index :");
   	for(int i=0;i<(N/M);i++){
   		StdOut.println("("+i+")");
   		for(int j=0;j<M;j++)
   			StdOut.print(" "+a[blockIndex[i]*M+j]);
   		StdOut.println();
   	}
   	StdOut.println();
   	StdOut.println("End");

	StdOut.println("Print Arrays---Exchanged");
	for(int i=0;i<(N);i++){
		if((i%(M))==0) {
			StdOut.println();
			StdOut.println((i/M)+" : " +i);}
		StdOut.print(a[i]+" ");
	}
	StdOut.println();
	StdOut.println("Print End");
    	int count =0;
    	while(count<(N/M)){
        	for(int i=0;i<(N/M)-1;i++){
        	    StdOut.println("N/M : "+(N/M)+" i: "+i);
        		blockMerge(i, i+1);	
        	}
        	count++;
    	}
    	boolean result =isSorted(a);
    	StdOut.println("Is Sorted ? "+result);
    	
    	//change to the array normal order
    	for(int m=0;m<(N/M);m++){
    		blockExchange(blockIndex[m], m);
    	}
    	result =isSorted(a);
    	StdOut.println("Now Is Sorted ? "+result);
    	StdOut.println("Print Arrays");
    	for(int i=0;i<(N);i++){
    		if((i%(M))==0) {
    			StdOut.println();
    			StdOut.println((i/M)+" : " +i);}
    		StdOut.print(a[i]+" ");
    	}
    	StdOut.println();
    	StdOut.println("Print End");

    	
    		
    }
    //block exchange
    private void blockExchange(int src,int dst){
    	 int temp;
    	for(int i=0;i<M;i++)
    		{
    		temp=a[dst*M+i];
    		a[dst*M+i]=a[src*M+i];
    		a[src*M+i]=temp;
    		}
    }
    
    //block merge
    private  void blockMerge(int lo,int hi){
    	for(int i=0;i<M;i++){
    		block[i]=a[blockIndex[lo]*M+i];
    	}
    	int start =blockIndex[lo];
    	int end=blockIndex[hi];
    	int i=0;
    	int j=0;
    	for(int k=0;k<2*M;k++){
            if(k<M){
        		if(i>=M) {
        			a[k+start]=a[j+end];
        			j++;
        		}
        		else if(j>=M) a[k+start]=block[i++];
        		else if(block[i]<=a[j+end]) a[k+start]=block[i++];
        		else if(block[i]>a[j+end]) {
        			a[k+start]=a[j+end];
        			j++;
        		}
            } 
            else{
        		if(i>=M) {
        			a[k+end-M]=a[j+end];
        			j++;
        		}
        		else if(j>=M) a[k+end-M]=block[i++];
        		else if(block[i]<=a[j+end]) a[k+end-M]=block[i++];
        		else if(block[i]>a[j+end]) {
        			a[k+end-M]=a[j+end];
        			j++;
        		}
            }


    	}
    }
    
    //Insertion sort
    private static void sort(int[] a,int lo,int hi){
    	for(int i=lo+1;i<=hi;i++)
    		for(int j=i;j>lo&&(a[j]<=a[j-1]);j--){
    			int temp =a[j-1];
    			a[j-1]=a[j];
    			a[j]=temp;
    		}
    }
    
    public static boolean isSorted(int[] a){
    	for(int i=1;i<a.length;i++)
    		if(a[i]<a[i-1]) return false;
    	return true; 
    }
	public static void main(String[] args){
		int N =48;
		int M =8;
		SublinearMerge merge =new SublinearMerge(N, M);
	}
}
