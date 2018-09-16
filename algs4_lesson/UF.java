import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class UF {
    private int[] id;
    private int count;
    public UF(int N) {
    	count =N;
    	id= new int[N];
    	for(int i=0;i<N;i++)
    		id[i]=i;
    }
    public int[] getid() {
    	return id;
    }
    public int count() {
    	return count;
    }
    public boolean QuickFind_connected(int p,int q) {
    	return QuickFind_find(p)==QuickFind_find(q);
    }
 /* quick-find*/
    public int 	QuickFind_find(int p) {return id[p];}
    public void QuickFind_union(int p,int q) {
    	int times =0;
    	int pID =QuickFind_find(p);
    	int qID=QuickFind_find(q);
    	if(pID==qID) return ;
    	for(int i=0;i<id.length;i++)
    		if(id[i]==pID) {
    			times++;
    			id[i]=qID;}
    	count--;
    	StdOut.println(" times : "+times);
    }
    
   
    
    public boolean QuickUnion_connected(int p,int q) {
    	return QuickUnion_find(p)==QuickUnion_find(q);
    }
    /*quick-union*/
   private int QuickUnion_find(int p) {
    	//find the name of component
    	int times =0;
    	int temp =p;
	   while(p!=id[p]) { 
		   times++;
		   p=id[p];
		   }
	   int root =p;
	   while(temp!=id[temp]) {
		   temp=id[temp];
		   id[temp]=root;
	   }
	   StdOut.println(temp+" times : "+times);
    	return p;
    }
    public void QuickUnion_union(int p,int q) {
    	int pRoot =QuickUnion_find(p);
    	int qRoot =QuickUnion_find(q);
    	if(pRoot == qRoot) return;
    	id[pRoot]=qRoot;
    	count--;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
