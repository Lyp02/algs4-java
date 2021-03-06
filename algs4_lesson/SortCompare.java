import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class SortCompare {
    public static double time(String alg,Double[] a){
    	Stopwatch timer =new Stopwatch();
    	if(alg.equals("Insertion")) Insertion.sort(a);
    	if(alg.equals("Selection")) Selection.sort(a);
    	if(alg.equals("Shell")) Shell.sort(a);
    	if(alg.equals("Shell_1")) Shell_1.sort(a);
    	if(alg.equals("Insertion1")) Insertion1.sort(a);
    	return timer.elapsedTime();
    }
    public static double timeRandomInput(String alg,int N,int T){
    	double total =0.0;
    	Double[] a =new Double[N];
    	for(int t=0;t<T;t++){
    		for(int i=0;i<N;i++)
    			a[i]=(double) StdRandom.uniform();
    		total +=time(alg,a);
                  
    	}
    	return total;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String alg1 =args[0];
        String alg2 =args[1];
        int N =Integer.parseInt(args[2]); 
        int T =Integer.parseInt(args[3]);
        while(true){
            StdOut.println();
            double t1 =timeRandomInput(alg1, N, T);
            double t2=timeRandomInput(alg2, N, T);
            StdOut.printf("For %d random Doubles\n  %s is", N,alg1);
            StdOut.printf(" %.1f times faster than %s \n", t2/t1,alg2);
            N=N*2;
        }

	}

}
