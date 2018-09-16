import java.awt.Color;
import java.util.Arrays;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.WhiteFilter;
import edu.princeton.cs.algs4.Whitelist;

public class practice_1_1 {
	
	public static boolean threeSame(int a1,int a2,int a3) {
		return (a1==a2)&&(a2==a3);
	}
	public static boolean double0to1(double a1,double a2) {
		return (a1>0)&&(a1<1)&&(a2>0)&&(a2<1);
	}
	public static String binaryToString(int a) {
		String s="";
		for(int n= a;a>0;a/=2)
			s=(n%2)+s;
		return s;
	}
	public static void printArray(int[][] arr,int rank,int column) {
		for(int i=0;i<rank;i++) {
			for(int j=0;j<column;j++) 
                StdOut.printf(" [%d][%d]:%d",i,j,arr[i][j]);
		StdOut.println();
		}	
	}
	public static int[][] reverseArray(int[][] arr,int rank,int column) {
		int[][] b=new int[column][rank];
		for(int i=0;i<rank;i++)
			for(int j=0;j<column;j++) {
              b[j][i]=arr[i][j];
				
			}
		return b;
	}
	public static void  printBooleanArrays(boolean[][] arr,int rank,int column) {
		for(int i=0;i<rank;i++) {
			for(int j=0;j<column;j++) {
				if(arr[i][j])
					StdOut.printf(" [%d][%d]:*",i,j);
				else
					StdOut.printf(" [%d][%d]: ",i,j);
			}
		StdOut.println();
		}
	}
	public static int lg(int N) {
		int temp =1;
		int count=0;
		if(N==1) return 0;
		else {
			while(temp<=N)
			{ 
				temp=temp*2;
				count++;
			}
			return count-1;
		}
		
	}
	public static int arrayCounts(int[] a,int v) {
		int temp=0;
		for(int i=0;i<a.length;i++) {
			if(a[i]==v) temp++;
		}
		return temp;
	}
	public static int[] histogram(int[] a,int M) {
		int[] b =new int[M];
		for(int i=0;i<M;i++)
			b[i]=arrayCounts(a, i);
		return b;
	}
	public static String exR1(int n) {
		if(n<=0) return "";
		return exR1(n-3)+n+exR1(n-2)+n;
	}
	public static int mystery(int a,int b) {
		if(b==0) return 1;
		if(b%2==0) return mystery(a*a,b/2);
		return mystery(a*a,b/2)*a;
	}
	public static long F1(int N) {
		if(N==0) return 0;
		if(N==1) return 1;
		return F1(N-1)+F1(N-2);
	}
	public static long F2(int N,long[]f2) {
		if(N==0) return 0;
		if(N==1) return 1;
		return f2[N-1]+f2[N-2];
	}
	public static double lnN(int n) {
		if((n==1)||(n==0)) return 0;
		return lnN(n-1) + Math.log(n);
		}
	public static void readData() {
		String[] name =new String[100];
		int i=0;
		double[] score1 =new double[100];
		double[] score2 =new double[100];
		double[] result=new double[100];
		while((StdIn.hasNextLine())) {
			String[] str =StdIn.readLine().split(" ");
			name[i]=str[0];
			score1[i]=Double.parseDouble(str[1]);
			score2[i]=Double.parseDouble(str[2]);
			result[i] =score1[i]/score2[i];
			i=i+1;
			
		}
		for(int j=0;j<i;j++) {
			StdOut.printf(" NAME:%s Score1:%f Score2:%f Result:%.2f \n ", 
					name[j],score1[j],score2[j],result[j]);
		}
	}
	public static int rank(int key,int[]a,int count) {
		return rank(key,a,0,a.length-1,count);
	}
	public static int rank(int key,int[]a,int lo,int hi,int count) {
		for(int i=0;i<=count;i++) {
			StdOut.print(" ");
		}
		StdOut.printf("hi=%d lo=%d depth=%d \n", hi,lo,count);
		if(lo>hi) return -1;
		int mid=lo+(hi-lo)/2;
		if(key<a[mid]) return rank(key,a,lo,mid-1,++count);
		else if(key>a[mid]) return rank(key,a,mid+1,hi,++count);
		else return mid;
	}
	
	public static int rank(int key,int[]a) {
		return rank(key,a,0,a.length-1);
	}
	public static int rank(int key,int[]a,int lo,int hi) {

		if(lo>hi) return -1;
		int mid=lo+(hi-lo)/2;
		if(key<a[mid]) return rank(key,a,lo,mid-1);
		else if(key>a[mid]) return rank(key,a,mid+1,hi);
		else return mid;
	}
	
public static int rankLess(int key,int[] a) {
	int pos =rank(key,a);
	int i=0;
	if(pos==-1) {
		if(a[0]>=key) return 0;
		if(a[a.length-1]<key) return a.length;
		while(a[i]<key) i++;
		return i;
	}
	else {
		for(i=pos;(i>=0)&&(a[i]>=a[pos]);i--);
	}
	return i+1;
}

public static int rankEqual(int key,int[]a) {
	int pos =rank(key,a);
	int i=0;
	int j=0;
	if(pos==-1) return 0;
	else {
		for(i=pos;(i>=0)&&(a[i]>=a[pos]);i--);
		for(j=pos;(j<a.length)&&(a[j]<=a[pos]);j++);
	}
	return j-i-1;
}
	
	public static long Euclid(long p,long q) {
		StdOut.printf("%d %d \n", p,q);
		if((p%q)==0) return q;
		else return Euclid(q,p%q);
		
	}
	public static void gcdArray(boolean[][] a,int rank,int col){
		for(int i=1;i<rank;i++)
			for(int j=1;j<col;j++) {
				if(Euclid(i, j)==1) {
					a[i][j]=true;
				    a[j][i]=true;
				    }
			}
	}
	public static double binomial(int N,int k,double p) {
		if(N==0&&k==0) return 1.0;
		if(N<0 || k<0) return 0.0;
		return (1.0-p)*binomial(N-1,k,p)+p*binomial(N-1,k-1,p);
		
	}
	
	public static double binomial(int N,int k,double p,double[][]a) {
		if(N==0&&k==0) return 1.0;
		if(N<0 || k<0 || k>N) return 0.0;
		if(N>=1 && k<1) return (1.0-p)*a[N-1][k];
		else return (1.0-p)*a[N-1][k]+p*a[N-1][k-1];
		
	}
   public static void delRepeat(int[] a,int[] b) {
	   int i=1;
	   int j=1;
	   b[0]=a[0];
	   while(i<a.length) {

		   while(a[i]==a[i-1])
			   i++;
		   b[j]=a[i];
		   i=i+1;
		   j=j+1;
	   }

	   return;
   }
   public static void initialArr(int[] a) {
	   for(int i=0;i<a.length;i++) {
		   a[i]=i;
	   }
   }
   public static void shuffle(int[] a) {
	   int N=a.length;
	   for(int i=0;i<N;i++) {
		   int r=StdRandom.uniform(N);
		   int temp=a[i];
		   a[i]=a[r];
		   a[r]=temp;
	   }
	   
   }
   public static int[][] shuffleTest(int M,int N){
	   int[][] c=new int[M][M];
	   int a[] =new int[M];
	   for(int i=0;i<N;i++) {
		   initialArr(a);
		   shuffle(a);
		   for(int j=0;j<M;j++) {
			   
				   c[a[j]][j]++;
			  
		   }
	   }
	   return c;
   }
   public static void drawCircle(int N,double p) {
	   double[] x_data=new double[N];
	   double[] y_data=new double[N];
	   StdDraw.setXscale(0,2);
	   StdDraw.setYscale(0,2);
	   StdDraw.setPenColor(Color.red);
	   StdDraw.setPenRadius(0.05);
	   StdDraw.circle(1.0, 1.0, 0.8);
	   StdDraw.setPenColor(Color.gray);
	   StdDraw.setPenRadius(0.05);
	   for(int i=0;i<N;i++) {
		   x_data[i]=1+0.8*Math.sin(((2*3.1415926)/N)*i);
		   y_data[i]=1+0.8*Math.cos(((2*3.1415926)/N)*i);
	   }
	   for(int i=0;i<N-1;i++) {
		   for(int j=i+1;j<N;j++) {
			   if(StdRandom.bernoulli(p)) {
				   StdDraw.line(x_data[i],y_data[i], x_data[j], y_data[j]);
				   StdDraw.show(100);
			   }
		   }
	   }
   }
	public static void generateRandomArrays(double[]a,double lo,double hi) {
		for(int i=0;i<a.length;i++) {
			a[i]=StdRandom.uniform(lo,hi);
		}
	}
	public static void drawHistogram(double[] a,double lo,double hi,int N) {
		int[] counts =new int[N];
		double[] bounds =new double[N+1];
		for(int i=0;i<bounds.length;i++) {
			bounds[i]=lo+((hi-lo)/N)*i;
		}
		for(int i=0;i<a.length;i++) {
              int j=0;
              while(j<bounds.length-1) {
        	  while(!(bounds[j]<=a[i]&&bounds[j+1]>a[i])) j++;
        	  counts[j]++;
        	  break;
              }
          
			
		}
		
		   StdDraw.setXscale(0,1);
		   StdDraw.setYscale(0,2*a.length/N);
		   StdDraw.setPenColor(Color.red);
		   StdDraw.setPenRadius(0.05);
		
		for(int i=0;i<N;i++) {
			double x = 1.0*i/N;
			double y=counts[i]/2.0;
			double rw=0.5/N;
			double rh=counts[i]/2.0;
			StdDraw.filledRectangle(x, y, rw, rh);
			
		}
	} 
	public static double dot(double[] x,double[] y) {
		double sum=0;
		for(int i=0;i<x.length;i++) {
			sum+=x[i]*y[i];
		}
		return sum;
	}
	public static double[][] mult(double[][]a, double[][]b){
		double[][] c =new double[a.length][b[0].length];
		double sum=0;
		for(int i=0;i<a.length;i++) {
			sum=0;
			for(int j=0;j<b[0].length;j++) {
				for(int k=0;k<a[0].length;k++) {
					sum+=a[i][k]*b[k][j];
				}
				c[i][j]=sum;
				
			}
		}
		return c;
	}
	public static double[][] transpose(double[][] a){
		double[][] b=new double[a[0].length][a.length];
		for(int i=0;i<a.length;i++) {
			for(int  j=0;j<a[0].length;j++) {
				b[j][i]=a[i][j];
			}
		}
		return b;
	}
	public static double[] mult(double[][] a,double[]x) {
		double[] c =new double[x.length];
		for(int i=0;i<a.length;i++) {
			int sum=0;
			for(int j=0;j<a[0].length;j++) {
				sum+=a[i][j]*x[j];
			}
			c[i]=sum;
			
		}
		return c;
	}
	public static double[] mult(double[] y,double[][] a) {
		double[] c =new double[y.length];
		for(int i=0;i<a[0].length;i++) {
			int sum=0;
			for(int j=0;j<y.length;j++) {
				sum+=y[j]*a[j][i];
			}
			c[i]=sum;
		}
		return c;
		
	}
	public static void printArrays(double[][] a) {
		for(int i=0;i<a.length;i++) {
			StdOut.println("");
			for(int j=0;j<a[0].length;j++) {
				StdOut.printf(" %4.4f",a[i][j] );
			}
		}
	}
	public static void printArrays(double[] a) {
		for(int i=0;i<a.length;i++) {
			StdOut.printf("%4.4f", a[i]);
		}
		StdOut.println();
	}
	public static long diceN( double[] a) {
		int N=1200000;
		double[] dist1=new double[13];
		
		while(!((Math.abs((dist1[7]-a[7]))<=0.001))) {
		for(int i=0;i<N;i++) {
			dist1[StdRandom.uniform(1, 7)+StdRandom.uniform(1, 7)]+=1.0;
		}
		for(int k=2;k<=12;k++) {
			dist1[k]/=36.0;
		}
		N=N*10;
		}
		return N;
		
	}
	public static int randomArrsMatch(int N) {
		int[] a =new int[N];
		int[] b=new int[N];
		int j=0;
		int counts=0;
		for(int i=0;i<N;i++) {
			a[i]=StdRandom.uniform(100000, 999999);
			b[i]=StdRandom.uniform(100000, 999999);
		}
		Arrays.sort(a);
		Arrays.sort(b);
		for(int i=0;i<N;i++) {
			while((j<N)&&(i<N)) {
				if(a[i]<b[j])  break;
				if(a[i]==b[j]) {
					i++;
					counts++;
				}

				j++;
			}
			if(j>=N) break;
		}
		return counts;
	}
	
	public static int ArrsMatch() {
		int[] a =new int[20];
		int[] b=new int[20];
		int j=0;
		int counts=0;
		for(int i=0;i<20;i++) {
			a[i]=2*i;
			b[i]=6*i;
		}
		Arrays.sort(a);
		Arrays.sort(b);
		for(int i=0;i<20;i++) {
			while((j<20)&&(i<20)) {
				if(a[i]<b[j])  break;
				if(a[i]==b[j]) {
					i++;
					counts++;
				}

				j++;
			}
			if(j>=20) break;
		}
		return counts ;
	}
	
	public static void randomMatch(int T) {
		int[] Ns =new int[4];
		Ns[0]=1000;
		Ns[1]=10000;
		Ns[2]=100000;
		Ns[3]=1000000;
		int[] Ts =new int[4];
		for(int i=0;i<T;i++) {
			for(int j=0;j<Ns.length;j++) {
				Ts[j]+=randomArrsMatch(Ns[j]);
			}
		}
		StdOut.println("");
		for(int i=0;i<4;i++) {
			StdOut.printf("%d times %d nums experiment is %d\n", T,Ns[i],Ts[i]);
		}
		
	}
	public static void main(String[] args) {
//		 int a=(0 + 15)/2;
//		 double b=(2.0e-6*100000000.1);
//		 boolean c =true && false || true && true;
//		 StdOut.println(" "+a);
//		 StdOut.println(" "+b);
//		 StdOut.println(" "+c);	
////		 boolean sameBit = threeSame(Integer.parseInt(args[0]),Integer.parseInt(args[1]),
////				 Integer.parseInt(args[2]));
////		 StdOut.println(sameBit);
//		 boolean double0to1Bit = double0to1(0.2, 0.7);
//		 StdOut.println(double0to1Bit);
//		 int f=0;
//		 int g=1;
//		 for(int i=0;i<=15;i++) {
//			 StdOut.println(f);
//			 f=f+g;
//			 g=f-g;
//		 }
//		   //Newton iterative method 
//			double t=9.0;
//			while(Math.abs(t -9.0/t)>.001)
//				t =(9.0/t + t)/2.0;
//			StdOut.printf("%.5f\n", t);
//           System.out.println('b');
//           System.out.println('b'+'c');
//           System.out.println((char)('a' +4));
//           String num2string = binaryToString(255);
//           StdOut.println(num2string);
//           boolean [][] arrs= new boolean[4][5];
//           printBooleanArrays(arrs, 4, 5);
//           int[] a1=new int[10];
//           for(int i=0;i<10;i++)
//        	   a1[i]=9-i;
//           for(int i=0;i<10;i++)
//        	   a1[i]=a1[a1[i]];
//           for(int i=0;i<10;i++)
//        	   System.out.println(i);
//           int [][] intArray =new int[3][7];
//           for(int i=0;i<3;i++)
//			for(int j=0;j<7;j++)
//				intArray[i][j] =(7*i)+j;
//           printArray(intArray, 3, 7);
//           StdOut.println("*********************");
//           int[][] reverseArr = reverseArray(intArray, 3, 7);
//           printArray(reverseArr, 7, 3);
//           int d1 =lg(6);
//           int d2 =lg(16);
//           int d3=lg(4);
//           StdOut.printf(" %d %d %d ", d1,d2,d3);
//           int[] arr2=new int[13];
//           for(int i=0;i<13;i++) {
//        	   arr2[i]=i;
//           }
//           int[] arr3;
//           arr3 =histogram(arr2, 7);
//           int sum1=0;
//           for(int i=0;i<7;i++) {
//        	   sum1=sum1+arr3[i];
//           }
//           StdOut.println((sum1==13));
//           String str =exR1(6);
//           StdOut.println(str);
//           StdOut.println(mystery(2,25));
//           StdOut.println(mystery(3,11));
//           StdOut.println(lnN(12));
           // readData();
//           int[] nums =new int[200];
//           for(int i=0;i<nums.length;i++) {
//        	   nums[i]=2*i+1;
//           }
//           int count=0;
//           int key=97;
//           int mid=rank(key, nums,count);
//           StdOut.printf(" %d is the sequence of %d in Array \n",key,mid);
//           int[] whitelist =In.readInts(args[0]) ;
//           String cmd =args[1];
//           Arrays.sort(whitelist);
//           while(!StdIn.isEmpty()) {
//        	   int key1 =StdIn.readInt();
//        	   if(cmd.equals("+")) {
//        		   if(rank(key1,whitelist)<0)
//        			   StdOut.println(key1);
//        	   }
//        	   else if(cmd.equals("-")) {
//        		   if(rank(key1,whitelist)>=0)
//        			   StdOut.println(key1);
//        	   }
//        	   else StdOut.println("Wrong comand");
//        	   
//           }
//           
//			long a4=Euclid(105, 24);
//			StdOut.println(a4);
//			long a5=Euclid(1111111, 1234567);
//			StdOut.println(a5);
//			double a6= binomial(2,1,0.25);
//			StdOut.println(a6);
//			int N=100;
//			int k=50;
//			double p=0.25;
//			double[][] binomialArr =new double[N+1][N+1];
//			for(int i=0;i<=N;i++) {
//				for(int j=0;j<=i;j++)
//					binomialArr[i][j]=binomial(i, j, p, binomialArr);
//			}
//			StdOut.println(binomialArr[N][k]);
//			for(int i=0;i<N+1;i++) {
//				StdOut.println("");
//				for(int j=0;j<N+1;j++) {
//					StdOut.printf("% .2f", binomialArr[i][j]);
//				}
//			}
//			
			int [] whitelist =In.readInts(args[0]);
			Arrays.sort(whitelist);
//			int[] b =new int[whitelist.length];
//			
//			for(int i=0;i<whitelist.length;i++) {
//				StdOut.printf("% d", whitelist[i]);
//				if(i%5==0) StdOut.println("");
//			}
//			delRepeat(whitelist, b);
//			StdOut.println("************************************");
//			for(int i=0;i<b.length;i++) {
//				StdOut.printf("% d", b[i]);
//				if(i%5==0) StdOut.println("");
//			}
//			int rank_less =rankLess(77, whitelist);
//			int rank_euqal=rankEqual(77, whitelist);
//			StdOut.printf(" less than numbs %d \n", rank_less);
//			StdOut.printf(" equal numbs is %d \n", rank_euqal);
//			int N=20;
//			int M=20;
//			boolean[][] gcdArr =new boolean[M][N];
//			gcdArray(gcdArr, M, N);
//			for(int i=0;i<M;i++) {
//				StdOut.println("");
//				for(int j=0;j<N;j++) {
//					StdOut.print(""+gcdArr[i][j]);
//				}
//					
//			}
			
			//drawCircle(100, 0.003);
//			double[] data =new double[50];
//			generateRandomArrays(data, 0, 100);
//			drawHistogram(data, 0, 100, 13);
//			 double[][] A= new double[4][4];
//			 double[][] B=new double[4][4];
//			 double[] C =new double[4];
//			 double[] D=new double[4];
//			 for(int i=0;i<A.length;i++) {
//				 for(int j=0;j<A[0].length;j++) {
//					 A[i][j]=i*j;
//				 }
//			 }
//			 for(int i=0;i<B.length;i++) {
//				 for(int j=0;j<B[0].length;j++) {
//					 B[i][j]=i*j;
//				 }
//			 }
//			 for(int i=0;i<C.length;i++) {
//			   C[i] =i;
//			 }
//			 for(int i=0;i<D.length;i++) {
//				   D[i] =i;
//				 }
//			 printArrays(A);
//			 StdOut.println("");
//			 StdOut.println(">>>>>>>>>>>>>>>>>><<<<<<<<<<<<<");
//			 printArrays(B);
//			 StdOut.println("");
//			 StdOut.println(">>>>>>>>>>>>>>>>>><<<<<<<<<<<<<");
//			 printArrays(mult(A,B));
//			 StdOut.println("");
//			 StdOut.println(">>>>>>>>>>>>><<<<<<<<<<<<<<<<<¡¶");
//			 printArrays(mult(A,C));
//			 StdOut.println("");
//			 StdOut.println(">>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<");
//			 printArrays(mult(D,B));
//			 StdOut.println("");
//			 StdOut.println(">>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<");
//			 printArrays(transpose(A));
//			 StdOut.println("");
//			 StdOut.println(">>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<");
//			 StdOut.println(dot(C,D));
//			 StdOut.println("");
//			 StdOut.println(">>>>>>>>>>>>>>>>>><<<<<<<<<<<<<");
//			int SIDES=6;
//			double[] dist=new double[2*SIDES+1];
//			for(int i=1;i<=SIDES;i++) {
//				for(int j=1;j<=SIDES;j++)
//					dist[i+j]+=1.0;
//			}
//			for(int k=2;k<=2*SIDES;k++)
//				dist[k]/=36.0;
//			
//			long N =diceN(dist);
//			StdOut.println(N);
//			 
//		
// 	        int M=16;
//	        int N=1500;
//	        int[][] data =new int[M][M];
//	        data = shuffleTest(M,N);
//	        for(int i=0;i<data.length;i++) {
//	        	StdOut.println("");
//	        	for(int j=0;j<data.length;j++)
//	        		StdOut.printf(" [%d][%d]:%d",i,j, data[i][j]);
//	        }
			int T=100;
			randomMatch(T);
			int num=ArrsMatch();
			StdOut.println(num);
	        
	        
	
	
	}

	

 
}
