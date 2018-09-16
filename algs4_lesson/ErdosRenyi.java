import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class ErdosRenyi {
    QuickUnionUF uf;
    int Num;
    public ErdosRenyi(int N) {
    	Num =N;
    	uf =new QuickUnionUF(N);
    }
    
    public boolean AllConnected() {
    	boolean result =false;
    	int [] arr =uf.getid();
    	for(int i=0;i<Num;i++) {
    		if(arr[i]!=arr[i+1]) {
    			return result;
    		}
    	}
    	result =true;
    	return result;
    }
    public int ErdosRenyiDemo() {
    	int[] a =uf.getid();
    	int sums=0;
    	while(!AllConnected()) {
    		int p =StdRandom.uniform(0,Num);
    		int q =StdRandom.uniform(0,Num);
    		int connected =uf.union(p, q);
    		sums=sums+connected;
    	}
    	return sums;
    	
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      ErdosRenyi er =new ErdosRenyi(1000);
      int result =er.ErdosRenyiDemo();
      StdOut.println();
      StdOut.println("Connections : "+result);
	}

}
