import java.awt.Color;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class WeightedQuickUnionUF {
    private int[] id;
    private int[] sz;
    private int[] hi;
    private int count;
    public WeightedQuickUnionUF(int N) {
    	count =N;
    	id =new int[N];
    	for(int i=0;i<N;i++) id[i]=i;
    	sz =new int[N];
    	for(int i=0;i<N;i++) sz[i]=1;
    	hi=new int[N];
    }
    public int[] getid() {
    	return id;
    }
    public int[] getsz() {
    	return sz;
    }
    public int[] gethi() {
    	return hi;
    }
    public int count() {
    	return count;
    }
    public boolean connected(int p,int q) {
    	return find(p)==find(q);
    }
    public int[] find(int p) {
    	int CostResult[] =new int[2];
    	int times =0;
    	int temp =p;
    	while(p!=id[p]) { 
    		p=id[p];
    		times++;
    		}
    	/*路径压缩*/
/*    	int root =p;
    	while(temp!=id[temp]) {
    		temp=id[temp];
    		id[temp]=root;
    	}*/
    	StdOut.println(p+" times: "+times);
    	CostResult[0]=times;
    	CostResult[1]=p;
    	return CostResult;
    }
    
    public int union(int p,int q) {
    	int[] pFind;
    	int[] qFind;
    	int cost =0; 
    	pFind=find(p);
    	qFind=find(q);
    	int i =pFind[1];
    	int j =qFind[1];
    	cost =pFind[0]+qFind[0];
    	if(pFind[1]==qFind[1]) return cost;
 
 /* 数量加权*/
/*    	if(sz[i]<sz[j]) {
    		id[i]=j;
    		sz[j]+=sz[i];
    	}
    	else {
    		id[j]=i;
    		sz[i]+=sz[j];
    	}*/
/* 高度加权*/
    	if(hi[i]<hi[j]) {
    		id[i]=j;
    		
    	}
    	else {//两组相等高度时候原来高度加1
    		id[j]=i;
    		if(hi[i]==hi[j])
    			//小树 的高度都加1
    			hi[i]=hi[i]+1;
    	count--;
    }
     return (cost+1);
    }
    
    public void CostSharing()  {
        StdDraw.setXscale(0,count);
        StdDraw.setYscale(-4*count,4*count);
        StdDraw.setPenRadius(.01);
        int p;
        int q;
        int cost=0;
        int total=0;
    	for(int i =1;i<count*2;i++) {
    	   p =StdRandom.uniform(0, count);
    	   q =StdRandom.uniform(0, count);
    	   cost =union(p, q);
    	   StdDraw.setPenColor(Color.gray);
    	   StdDraw.point(i, cost);
    	   StdDraw.setPenColor(Color.RED);
    	   total =total +cost;
    	   StdDraw.point(i, total/i);
    	   StdOut.println(cost+"  "+(total/i));
       }
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	     WeightedQuickUnionUF uf =new WeightedQuickUnionUF(1000);
	     uf.CostSharing();
	}

}
