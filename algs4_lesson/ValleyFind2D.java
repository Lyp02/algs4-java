import java.util.Arrays;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class ValleyFind2D {
	
	public static Point FindCrossMin(Point[][] a,int Rowbegin,int Rowend,int Colbegin,int Colend,Point Start) {
		Point Min=Start;
		int MidRow =(Rowbegin+Rowend)/2;
		int MidCol=(Colbegin+Colend)/2;
		if(((Rowend -Rowbegin)<2)||((Colend -Colbegin)<2))
			return null;
		else {
			for(int i=Rowbegin+1;i<Rowend;i++) {
				if(Min.value > a[i][MidCol].value)
					Min =a[i][MidCol];
			}
			for(int i=Colbegin+1;i<Colend;i++) {
				if(Min.value >a[MidRow][i].value)
					Min=a[MidRow][i];
			}
			return Min;
		}
	}
	
	//太复杂了，有更简单的方法吗。
   public static Point FindValley2D(Point[][] a,int Rowbegin,int Rowend,int Colbegin,int Colend,Point Start) {
		if(((Rowend -Rowbegin)<2)||((Colend -Colbegin)<2))
			return null;
		int MidRow =(Rowbegin+Rowend)/2;
		int MidCol=(Colbegin+Colend)/2;
		Point findCur =FindCrossMin(a, Rowbegin, Rowend, Colbegin, Colend, Start);
		if((findCur.x==MidRow)&&(findCur.y==MidCol)) {
			StdOut.println();
			StdOut.println("Find! <"+" "+(findCur.x-1) +" , "+(findCur.y -1)+">"+" Value :"+findCur.value);
			return findCur;
		}
		if(findCur.y ==Rowbegin) {
			if(findCur.value<=a[findCur.x][findCur.y+1].value) {

				StdOut.println("Rowbegin");
				return findCur;
						
				}
			else if((findCur.value>a[findCur.x][findCur.y+1].value)&&(findCur.x<MidCol))
				return FindValley2D(a, Rowbegin, MidRow, Colbegin, MidCol, findCur);
			else if((findCur.value>a[findCur.x][findCur.y+1].value)&&(findCur.x>=MidCol))
			 return FindValley2D(a, Rowbegin, MidRow, MidCol, Colend, findCur);
		}
		if(findCur.y ==MidRow) {
			int[] temp =new int[2];
			temp[0]=a[findCur.x][findCur.y+1].value;
			temp[1]=a[findCur.x][findCur.y-1].value;
			Arrays.sort(temp);
			int Mintemp =temp[0];
			if(findCur.value<=temp[0])return findCur;
			else if((findCur.value>temp[0])) {
				if(temp[0] ==a[findCur.x][findCur.y+1].value) {
					//上面
					if(findCur.x <MidCol)
					   return FindValley2D(a, Rowbegin, MidRow, Colbegin, MidCol, findCur);
					else return  FindValley2D(a, Rowbegin, MidRow, MidCol, Colend, findCur);
				}
				else {
					//下面
					if(findCur.x <MidCol)
					     return FindValley2D(a, MidRow, Rowend, Colbegin, MidCol, findCur);
					else return FindValley2D(a, MidRow, Rowend,  MidCol,Colend, findCur);
			  }
			}
		
		}
		if(findCur.y==Rowend) {
			if(findCur.value<=a[findCur.x][findCur.y-1].value) {
				StdOut.println("Rowend");
				return findCur;}
			else if((findCur.value>a[findCur.x][findCur.y-1].value)&&(findCur.x<MidCol))
				return FindValley2D(a, MidRow, Rowend, Colbegin, MidCol, findCur);
			else if((findCur.value>a[findCur.x][findCur.y-1].value)&&(findCur.x>=MidCol))
			 return FindValley2D(a, MidRow, Rowend, MidCol, Colend, findCur);
		}
		//列的讨论
		
		if(findCur.x ==Colbegin) {
			if(findCur.value<=a[findCur.x+1][findCur.y].value) {
				StdOut.println("Colbegin");
				return findCur;}
			else if((findCur.value>a[findCur.x+1][findCur.y].value)&&(findCur.y<MidRow))
				return FindValley2D(a, Rowbegin, MidRow, Colbegin, MidCol, findCur);
			else if((findCur.value>a[findCur.x+1][findCur.y].value)&&(findCur.y>=MidRow))
			 return FindValley2D(a, MidRow,Rowend, Colbegin, MidCol, findCur);
		}
		if(findCur.x ==MidCol) {
			int[] temp =new int[2];
			temp[0]=a[findCur.x+1][findCur.y].value;//右边
			temp[1]=a[findCur.x-1][findCur.y].value;//左边
			Arrays.sort(temp);
			int Mintemp =temp[0];
			if(findCur.value<=temp[0])return findCur;
			else if((findCur.value>temp[0])) {
				if(temp[0] ==a[findCur.x+1][findCur.y].value) {
					//右边
					if(findCur.y <MidRow)//上面
					   return FindValley2D(a, Rowbegin, MidRow, MidCol, Colend, findCur);
					else return  FindValley2D(a, MidRow, Rowend,MidCol, Colend, findCur);
				}
				else {
					//左面
					if(findCur.y <MidRow)
					     return FindValley2D(a, Rowbegin, MidRow, Colbegin, MidCol, findCur);
					else return FindValley2D(a, MidRow, Rowend,  Colbegin,MidCol, findCur);
			  }
			}
		
		}
		if(findCur.x==Colend) {
			if(findCur.value<=a[findCur.x-1][findCur.y].value) {
				StdOut.println("Colend");
				return findCur;}
			else if((findCur.value>a[findCur.x-1][findCur.y].value)&&(findCur.y<MidRow))
				return FindValley2D(a, Rowbegin, MidRow, MidCol, Colend, findCur);
			else if((findCur.value>a[findCur.x-1][findCur.y].value)&&(findCur.y>=MidRow))
			 return FindValley2D(a, MidRow, Rowend, MidCol, Colend, findCur);
		}
		return findCur;
   }
   
   
   
   
   //**
   public static void FindCloseMax(double[] a) {
   	double a1[] =new double[a.length];
   	double b[] =new double[a.length-1];
   	for(int i=0;i<a1.length;i++) {
   		a1[i]=a[i];
   	}
   	Arrays.sort(a1);
       StdOut.println("Maxmum :"+a1[a1.length-1]+" "+a1[0]);
   	 
   	
   		
   }
   
   public static int FindArrayMin(int lo,int hi,int[] b) {
   	int a[] =new int[b.length];
   	for(int i=0;i<a.length;i++) {
   		a[i]=b[i];
   	}
   	if((hi-lo)<2) return -1;
   	else {
   		int mid =lo+(hi-lo)/2;
   		if((a[mid]<=a[mid-1])&&(a[mid]<=a[mid+1])) {
   			StdOut.println("Index: "+mid+" "+a[mid-1] +" "+a[mid]+" "+a[mid+1]);
   			return mid;
   		}
   		else if((a[mid]>a[mid-1])&&(a[mid]<=a[mid+1])) return FindArrayMin(lo, mid-1, b);
   		else if((a[mid]>a[mid-1])&&(a[mid]>a[mid+1])) {
   			if(a[mid-1]<a[mid+1]) return FindArrayMin(lo, mid-1, b);
   			else return FindArrayMin(mid+1, hi, b);
   		}
   		else if((a[mid]<=a[mid-1])&&(a[mid]>a[mid+1])) return FindArrayMin(lo, mid+1, b);
   		}
   	return -1;
   	}
   
   public static int FindArrayMin1(int lo,int hi,int[] b) {
   	int a[] =new int[b.length];
   	for(int i=0;i<a.length;i++) {
   		a[i]=b[i];
   	}
   	if((hi-lo)<2) return -1;
   	else {
   		int mid =lo+(hi-lo)/2;
   		if(a[mid]>a[mid-1]) return FindArrayMin1(lo, mid-1, a);
   		if(a[mid]>a[mid+1]) return FindArrayMin1(mid+1, hi, a);
   		else {
   			StdOut.println("Index: "+mid+" "+a[mid-1] +" "+a[mid]+" "+a[mid+1]);
   			return mid;
   		}
   	}
   	}
   public static int findColMin(int col,int N,int[][] a) {
   	int min =a[0][col];
   	int row =0;
   	for(int i=0;i<N;i++) {
   		if(a[i][col]<min) {
   			min =a[i][col];
   			row =i;
   		}
   		
   	}
   	return row;
   }
   
   public static int FindArrMin(int col,int N,int[][] a) {// O(nlogn)
   	int row =findColMin(col, N, a);
   	if((col==0)||(col==N-1)) {
   		return row;
   	}
   	else if((a[col-1][row]<a[col][row]))
   			return FindArrMin((col-1)/2, N, a);
   	else if((a[col+1][row]<a[col][row]))
   		return FindArrMin((col+N)/2, N, a);
   	else {
   		StdOut.println("Find! <"+row+" , "+col+">"+"  "+a[row][col]);
   		return row;
   	}
   	
   	
   }
   
   public static int  findRowOrColMin(int[][]a,int option, int cur, int begin,int end) {
   	if(option%2==0) {
   		//RowFind
   		int minIndex =0;
   		int min =a[cur][0];
   		for(int i=begin;i<=end;i++) {
   			if(a[cur][i]<min) {
   				min =a[cur][i];
   				minIndex =i;
   			}
   		}
   		return minIndex;
   	}
   	
   	else{
   		//ColFind
   		int minIndex =0;
   		int min =a[0][cur];
   		for(int i=begin;i<=end;i++) {
   			if(a[i][cur]<min) {
   				min =a[i][cur];
   				minIndex =i;
   			}
   		}
   		return minIndex;
   	}
   }
   
   public static int FindArrMin2(int[][]a,int option,int cur,int begin,int end) {
   	int RowOrCol =findRowOrColMin(a, option, cur, begin, end);
   	if((RowOrCol ==begin)||(RowOrCol ==end)) {
   		if((option%2)==0) {
   			//Row
   			StdOut.println(" < "+cur+" , "+RowOrCol+" >" +a[cur][RowOrCol]);
   			
   		}
   		else {
   			//Col
   			StdOut.println(" < "+RowOrCol+" , "+cur+" >"+a[RowOrCol][cur]);
   			
   		}
   		return RowOrCol;
   	}
   	
   	else {
   		if(option%2==0) {
   			//Row
   			if(a[cur-1][RowOrCol]<a[cur][RowOrCol])
   				return FindArrMin2(a, ++option, RowOrCol, begin, cur-1);
   			if(a[cur+1][RowOrCol]<a[cur][RowOrCol])
   				return FindArrMin2(a, ++option, RowOrCol, cur+1, end);
   			else {
   				StdOut.println("Find!");
   				StdOut.println(" < "+cur+" , "+RowOrCol+" >"+" "+a[cur][RowOrCol]);
   				return RowOrCol;
   					
   				
   			}
   		}
   		
   		else {
   			//Col
   			if(a[RowOrCol][cur-1]<a[RowOrCol][cur])
   				return FindArrMin2(a, ++option, RowOrCol, begin, cur-1);
   			if(a[RowOrCol][cur+1]<a[RowOrCol][cur])
   				return FindArrMin2(a, ++option, RowOrCol, cur+1, end);
   			else {
   				StdOut.println("Find!");
   				StdOut.println(" <  "+RowOrCol+" , "+cur+"  >"+" "+a[RowOrCol][cur]);
   				return RowOrCol;
   					
   				
   			}
   		}
   	}
   }
   
   
   
   
   
   
   
   
	public static void main(String[] args) {
		// TODO Auto-generated method stub
     //产生 13*13随机数组
		int N=9999;
		ValleyFind2D v =new ValleyFind2D();
		int[][] a =new int[N][N];
		Point[][] pointArr =new Point[N+2][N+2];
		for(int i=0;i<N+2;i++)
			for(int j=0;j<N+2;j++) {
				pointArr[i][j]=new Point(i, j, 9999);
			}
		StdOut.println("******** 2D Arrays ********");
		for(int i=1;i<N+1;i++) {
			for(int j=1;j<N+1;j++) {
				a[i-1][j-1] =StdRandom.uniform(-2500000, 250000);
				pointArr[i][j] =new Point(i, j, a[i-1][j-1]);
				//StdOut.print(" "+a[i-1][j-1]);
			}
			//StdOut.println();
		}
		StdOut.println("****************************");
		Point startPoint =pointArr[0][0];
		int Rowbegin =0;
		int Rowend =N+1;
		int Colbegin =0;
		int Colend=N+1;
		Stopwatch timer1 =new Stopwatch();
		Point find =FindValley2D(pointArr, Rowbegin, Rowend, Colbegin, Colend, startPoint);
		StdOut.println(" time : "+timer1.elapsedTime()*1000000000);
		StdOut.println();
		StdOut.println(" < "+(find.x-1)+" , "+(find.y-1)+" >"+" Value "+find.value);
        StdOut.println("Result");
        Stopwatch timer2 =new Stopwatch();
        FindArrMin((N-1)/2, N, a);
        StdOut.println(" time: "+ timer2.elapsedTime()*1000000000);
        StdOut.println();
        StdOut.println("Result1:");
        int option =0;
        Stopwatch timer3 =new Stopwatch();
        FindArrMin2(a, option, (a.length-1)/2, 0, a.length-1);
        StdOut.println(" time: "+timer3.elapsedTime()*1000000000);
        //JVM内存溢出 找时间处理下这边先放下，去完成后面题目2018/6/23 
	}

}
