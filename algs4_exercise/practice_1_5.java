import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class practice_1_5 {
    public UF uf;
    public WeightedQuickUnionUF wuf;
    public static void printArr(int[] a) {
        StdOut.println();
    	for(int i =0;i<a.length;i++)
    	  StdOut.print( " "+i+"<"+a[i]+"> ");
        StdOut.println();
    }
    public void quickfindArr() {
    	uf =new UF(10);
    	StdOut.println("******QuickFind*******");
    	StdOut.println("Input the nums-pair (0~9) eg.1-2");
    	String s;
    	while(!StdIn.isEmpty()) {
    		s =StdIn.readLine();
    		String[] str =s.split("-");
    		int p =Integer.parseInt(str[0]);
    		int q =Integer.parseInt(str[1]);
    		if(uf.QuickFind_connected(p, q)) {

    			StdOut.println(" times : 0");
    			printArr(uf.getid());
    			continue;
    		}
    		uf.QuickFind_union(p, q);
    		printArr(uf.getid());
    	}
    	StdOut.println("**********************");
    }
    
    public void quickunionArr() {
    	uf =new UF(10);
    	StdOut.println("******QuickUnion*******");
    	StdOut.println("Input the nums-pair (0~9) eg.1-2");
    	String s;
    	while(!StdIn.isEmpty()) {
    		s =StdIn.readLine();
    		String[] str =s.split("-");
    		int p =Integer.parseInt(str[0]);
    		int q =Integer.parseInt(str[1]);
    		if(uf.QuickUnion_connected(p, q)) {

    			printArr(uf.getid());
    			continue;
    		}
    		uf.QuickUnion_union(p, q);
    		printArr(uf.getid());
    	}
    	StdOut.println("**********************");
    }
    
    
    public void weightedquickunionArr() {
    	wuf =new WeightedQuickUnionUF(10);
    	StdOut.println("******WeightedQuickUnion*******");
    	StdOut.println("Input the nums-pair (0~9) eg.1-2");
    	String s;
    	while(!StdIn.isEmpty()) {
    		s =StdIn.readLine();
    		String[] str =s.split("-");
    		int p =Integer.parseInt(str[0]);
    		int q =Integer.parseInt(str[1]);
    		if(wuf.connected(p, q)) {

    			printArr(wuf.getid());
    			printArr(wuf.getsz());
    			continue;
    		}
    		wuf.union(p, q);
    		printArr(wuf.getid());
    		//printArr(wuf.getsz());
    		printArr(wuf.gethi());
    	}
    	StdOut.println("*************************");
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       practice_1_5 p =new practice_1_5();
 //      p.quickfindArr();
 //      p.quickunionArr();
       p.weightedquickunionArr();
	}

}
