import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class QuickFindUF {
    private int[] id;
    private int count;
    public QuickFindUF(int N) {
    	count =N;
    	id =new int[N];
    	for(int i=0;i<N;i++)
    		id[i]=i;
    }
    public int count() {
    	return count;
    }
    public int find(int p) {
    	return id[p];
    }
    public int[] union(int p,int q,int total) {
    	int [] costAndtotal =new int[2];
    	costAndtotal[0]=0;
    	costAndtotal[1]=total;//总体成本
    	int pID=find(p);
    	int qID=find(q);
    	if(pID==qID) return costAndtotal;
    	for(int i=0;i<id.length;i++) {
    		if(id[i]==pID) {
    			id[i]=qID;
    			}
    		costAndtotal[0]++;
    	}
    	costAndtotal[1]=costAndtotal[1]+costAndtotal[0];	
    	count--;
    	return costAndtotal;
    }
    public boolean connected(int p,int q) {
    	return find(p)==find(q);
    }
    
    public void CostSharing()  {
        StdDraw.setXscale(0,count);
        StdDraw.setYscale(0,4*count);
        StdDraw.setPenRadius(.01);
        int p;
        int q;
        int[] CostTotal =new int[2];
        CostTotal[0]=0;
        CostTotal[1]=0;
    	for(int i =1;i<count*2;i++) {
    	   p =StdRandom.uniform(0, count);
    	   q =StdRandom.uniform(0, count);
    	   CostTotal =union(p, q, CostTotal[1]);
    	   StdDraw.setPenColor(Color.gray);
    	   StdDraw.point(i, CostTotal[0]);
    	   StdDraw.setPenColor(Color.RED);
    	   StdDraw.point(i, CostTotal[1]/i);
    	   StdOut.println(CostTotal[0]+"  "+(CostTotal[1]/i));
       }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
     QuickFindUF uf =new QuickFindUF(1000);
     uf.CostSharing();
	}

}
