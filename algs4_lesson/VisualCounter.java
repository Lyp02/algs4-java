import java.awt.Color;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

public class VisualCounter {
	private int  N;
	private int max;
	private int current;
	private int times;
	public int getcurrent() {
		return current;
	}
	public int gettimes() {
		return times;
	}
	public VisualCounter(int N,int max) {
		this.N=N;
		this.max=max;
		this.current=0;
		this.times=0;
		StdDraw.setXscale(0,N*2);
		StdDraw.setYscale(-max,max);
		StdDraw.setPenRadius(0.005);
	}
	public void increment() {
		if((Math.abs(current)>max)&&(times>=N))
			{
			current=current;
			return;
			}
			
		else current++;
		StdDraw.setPenColor(Color.gray);
		times++;
		StdDraw.point(times ,current);
		StdDraw.setPenColor(Color.red);
		StdDraw.point(times ,current/times);
	}
	public void decrease() {
		if((Math.abs(current)>max)&&(times>=N))
			{
			current =current;
			return;
			}
		else current--;
		StdDraw.setPenColor(Color.gray);
		times++;
		StdDraw.point(times ,current);
		StdDraw.setPenColor(Color.red);
		StdDraw.point(times ,current/times);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N=2000;
		int max =2000;
		boolean dir;
		VisualCounter counter =new VisualCounter(N, max);
		for(int  i=0;i<N;i++) {
			dir =StdRandom.bernoulli(0.1);
			if(dir) counter.increment();
			else counter.decrease();
		}
		StdDraw.setFont();
		StdDraw.text(N/2, max/2, " current :"+counter.getcurrent()+" times :"+counter.gettimes());

	}

}
