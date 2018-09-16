import java.awt.Color;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class QuickUnionUF {
    private int[] id;
    private int count;
    public QuickUnionUF(int N) {
    	count =N;
    	id =new int[N];
    	for(int i =0;i<N;i++)
    		id[i]=i;
    }
    public int count() {
    	return count;
    }
    public int[] getid() {
    	return id;
    }
    public boolean connected(int p,int q) {
    	return find(p)==find(q);
    }
    public int[] find(int p) {
    	int [] ResultCost =new int[2];
    	while(p!=id[p]) {
    		ResultCost[0]++;
    		p=id[p];
    	}
    	ResultCost[1]=p;
    	return ResultCost;
    }
    public int union(int p,int q) {
    	int [] pFind =find(p);
    	int [] qFind =find(q);
    	int cost=0;
    	if(pFind[1]==qFind[1]) { 
    		cost =pFind[0]+qFind[0];
    		return cost;}
    	cost=cost =pFind[0]+qFind[0]+1;
    	id[pFind[1]]=qFind[1];
    	count--;
    	return cost;
    }
    
    public void CostSharing()  {
        StdDraw.setXscale(0,count);
        StdDraw.setYscale(0,4*count);
        StdDraw.setPenRadius(.01);
        int p;
        int q;
        int  cost =0;
        int total =0;
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
	     QuickUnionUF uf =new QuickUnionUF(1000);
	     uf.CostSharing();
	}

}
