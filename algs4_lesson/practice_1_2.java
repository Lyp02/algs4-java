import java.awt.Color;

import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.Interval2D;
import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class practice_1_2 {
  public static double distance(double x1,double y1,double x2,double y2) {
	  return Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2)); 
  }
  public static void Point2D(int N) {
	  double x[] = new double[N];
	  double y[]=  new double[N];
	  double distance =10;
	  double temp=120;
	  for(int i=0;i<N;i++) {
		  x[i]=StdRandom.uniform(0.0,1.0);
		  y[i]=StdRandom.uniform(0.0,1.0);
	  }
	  StdDraw.setXscale(-1,1);
	  StdDraw.setYscale(-1, 1);
	  StdDraw.setPenColor(Color.red);
	  StdDraw.setPenRadius(0.05);
	  StdDraw.square(0, 0, 0.5);
	  StdDraw.setPenColor(Color.blue);
	  StdDraw.setPenRadius(0.01);
	  for(int i=0;i<N;i++) {
		  StdOut.printf(" %f %f \n",x[i],y[i]);
		  StdDraw.point(x[i]-0.5, y[i]-0.5);
	  }
	  for(int i=0;i<N-1;i++) {
        for(int j=i+1;j<N;j++) {
        	temp =distance(x[i], y[i], x[j], y[j]);
        	if(distance >= temp) distance =temp;
        }
	  }
	  StdDraw.setFont();
	  StdDraw.text(0, 0.8, "Minum distance is "+temp);
  }
  
  public static void Interval1D_intersect(int N) {
	  double x[] = new double[N];
	  double y[]=  new double[N];
	  Interval1D[] Interval1Ds =new Interval1D[N];
	  for(int i=0;i<N;i++) {
		  x[i]=StdRandom.uniform(0.0,1.0);
		  y[i]=StdRandom.uniform(0.0,1.0);
		  if(x[i] <=y[i])
			  Interval1Ds[i] =new Interval1D(x[i],y[i]);
		  else 
			  Interval1Ds[i] =new Interval1D(y[i],x[i]);
	  }
	  
	  for(int i=0;i<N-1;i++) {
		  for(int j=i+1;j<N;j++) {
			  if(Interval1Ds[i].intersects(Interval1Ds[j]))
					  StdOut.printf("intersect <%f,%f>--<%f,%f>\n", Interval1Ds[i].left()
							  ,Interval1Ds[i].right(),Interval1Ds[j].left(),Interval1Ds[j].right());
			  
		  }
		  
	  }
  }
  public static void Interval2D_intersect(int N,double min,double max) {
	  double x[] = new double[N];
	  double y[]=  new double[N];
	  int intersect_counts=0;
	  int contain_counts=0;
	  Interval1D[] Interval1DXs =new Interval1D[N];
	  Interval1D[] Interval1DYs =new Interval1D[N];
	  Interval2D[] Interval2Ds =new Interval2D[N];
	  StdDraw.setXscale(0,max);
	  StdDraw.setYscale(0, max*10);
	  StdDraw.setPenColor(Color.red);
	  StdDraw.setPenRadius(0.001);
	  for(int i=0;i<N;i++) {
		  x[i]=StdRandom.uniform(min,max);
		  y[i]=StdRandom.uniform(min,max);
		  if(x[i] <=y[i])
			  Interval1DXs[i] =new Interval1D(x[i],y[i]);
		  else 
			  Interval1DXs[i] =new Interval1D(y[i],x[i]);
	  }
	  for(int i=0;i<N;i++) {
		  x[i]=StdRandom.uniform(min,max);
		  y[i]=StdRandom.uniform(min,max);
		  if(x[i] <=y[i])
			  Interval1DYs[i] =new Interval1D(x[i],y[i]);
		  else 
			  Interval1DYs[i] =new Interval1D(y[i],x[i]);
	  }
	  for(int i=0;i<N;i++) {
		  Interval2Ds[i] =new Interval2D(Interval1DXs[i], Interval1DYs[i]);
		  Interval2Ds[i].draw();
	  }
	  for(int i=0;i<N-1;i++) {
		  for(int j=i+1;j<N;j++) {

			  if(Interval2Ds[i].intersects(Interval2Ds[j]))
				  intersect_counts++;
			  if(Interval2Ds[i].area() >=Interval2Ds[j].area()) {
				  boolean containBit =Interval2Ds[i].contains(new Point2D(Interval1DXs[j].left(),Interval1DYs[j].left()))&&
						  Interval2Ds[i].contains(new Point2D(Interval1DXs[j].left(),Interval1DYs[j].right()))&&
						  Interval2Ds[i].contains(new Point2D(Interval1DXs[j].right(),Interval1DYs[j].left()))&&
						  Interval2Ds[i].contains(new Point2D(Interval1DXs[j].right(),Interval1DYs[j].right()));
				  if(containBit) contain_counts++;
			  }
			  else if(Interval2Ds[i].area() <Interval2Ds[j].area()) {
				  boolean containBit =Interval2Ds[j].contains(new Point2D(Interval1DXs[i].left(),Interval1DYs[i].left()))&&
						  Interval2Ds[j].contains(new Point2D(Interval1DXs[i].left(),Interval1DYs[i].right()))&&
						  Interval2Ds[j].contains(new Point2D(Interval1DXs[i].right(),Interval1DYs[i].left()))&&
						  Interval2Ds[j].contains(new Point2D(Interval1DXs[i].right(),Interval1DYs[i].right()));
				  if(containBit) contain_counts++;
				  
			  }
		  }
	  }
	  StdDraw.setFont();
	  StdDraw.setPenColor(Color.blue);
	  StdDraw.setPenRadius(0.01);
	  StdDraw.text(min/2, min/2, "Intersect counts: "+intersect_counts+"Contains counts: "+contain_counts);
	  
	  
	  
	  
  }
  public static String mystery(String s) {
	  int N=s.length();
	  if(N<=1) return s;
	  String a =s.substring(0, N/2);
	  String b=s.substring(N/2,N);
	  return mystery(b)+mystery(a);
	  
  }
	public static long Euclid(long p,long q) {
		if((p%q)==0) return q;
		else return Euclid(q,p%q);
		
	}
  public static void main(String[] args) {
//	  Point2D(100000);
//    Interval1D_intersect(1000);
//	  Interval2D_intersect(200,30.0,80.0);
//	  String string1 ="hello";
//	  String string2 =string1;
//	  string1="world";
//	  StdOut.println(string1);
//	  StdOut.println(string2);
//	  String s1 ="ACTGACG";
//	  String s2="TGACGAC";
//	  String s3 =(s1.substring(s1.indexOf(s2.charAt(0)),s1.length())).concat(s1.substring(0, s1.indexOf(s2.charAt(0))));
//	  StdOut.printf("s1:%s  s2:%s  s3:%s", s1,s2,s3);
//	  StdOut.println(s3.equals(s2));
//	  String s4="Hello World";
//	  String s5 =mystery(s4);
//	  StdOut.println(s4+ " "+s5);
//	  
  }
}
