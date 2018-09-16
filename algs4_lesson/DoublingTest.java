import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class DoublingTest {

	public static double timeTrial(int N) {
		int MAX=1000000;
		int[] a =new int[N];
		for(int i=0;i<N;i++) {
			a[i]=StdRandom.uniform(-MAX,MAX);
		
		}
		Stopwatch timer =new Stopwatch();
		int cnt =ThreeSumFast.count(a);
		return timer.elapsedTime();
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        double Xmax =1000;
        double Ymax =0.01;
        int width =50;
        int highth =250;
        double pendRadius =0.01;
        StdDraw.setCanvasSize(2*width,2*highth);        
        StdDraw.setPenRadius(0.01);
        StdDraw.setXscale(-width,width);
        StdDraw.setYscale(-highth,highth);
        for(int N=250;true;N+=N) {
        	double time =timeTrial(N);
        	if(N>Xmax)
        		Xmax =10*Xmax;
        	if(time>Ymax)
        		Ymax=100*Ymax;
        	StdDraw.point((((N)/Xmax)*width), ((N*N*N/Ymax)*highth));
        	StdDraw.show(6);
        	
        }
        
        
        


        
	}

}
