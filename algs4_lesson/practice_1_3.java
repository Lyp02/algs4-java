import java.util.Iterator;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import edu.princeton.cs.algs4.Date;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class practice_1_3 {
   public static void parenthesesLeft() {
	   Stack<String> ops=new Stack<String>();
	   Stack<String> val=new Stack<String>();
	   String result;
	   while(!StdIn.isEmpty()) {
		   String s =StdIn.readString();
		   if(s.equals("+")) ops.push(s);
		   else if(s.equals("-")) ops.push(s);
		   else if(s.equals("*")) ops.push(s);
		   else if(s.equals("/")) ops.push(s);
		   else if(s.equals(")")){
			   String op =ops.pop();
			   String v2 =val.pop();
			   String v1=val.pop();
			   result = "("+v1+op+v2+s;
			   val.push(result);
		   }
		   else val.push(s);
	   }

	   StdOut.println(val.pop());
   }
   public static void PostfixToInfix() {
	   Stack<String> val =new Stack<String>();
	   String result;
	   while(!StdIn.isEmpty()) {
		   String s =StdIn.readString();
		   if(s.equals("+")||s.equals("-")||s.equals("*")||s.equals("/")) {
			   String v2 =val.pop();
			   String v1=val.pop();
			   result ="("+v1+s+v2+")";
			   val.push(result);
		   }
		   else val.push(s);
		   
	   }
	   StdOut.println(val.pop());
   }
   
   public static void InfixToPostfix() {
	  Stack<String> val =new Stack<String>();
	  Stack<String> ops=new Stack<String>();
	  String result;
	  while(!StdIn.isEmpty()) {
		  String s =StdIn.readString();
		  if(s .equals("(")) ops.push(s);
		  else if(s.equals("+")) ops.push(s);
		  else if(s.equals("-")) ops.push(s);
		  else if(s.equals("*")) ops.push(s);
		  else if(s.equals("/")) ops.push(s);
		  else if(s.equals(")")) {
			  String v2 =val.pop();
			  String v1=val.pop();
			  String ops2 =ops.pop();
			  String ops1 =ops.pop();
			  result =""+ops1+v1+ops2+v2+")";
			  val.push(result);
		  }
		  else val.push(s);
	  }
	  StdOut.println(val.pop());
   }
   public static void lastQueuePrint(int k) {
	   Queue<String> q =new Queue<String>();
	   int count =0;
	   while(!StdIn.isEmpty()) {
		   String s =StdIn.readString();
		   StdOut.println("<"+s+">");
		   q.enqueue(s);
	   }
	   if( k >q.size()) {
		   StdOut.println(" not k elements in Queue");
	   }
	   else {
		   StdOut.println("<"+"size"+q.size()+">");
		   Iterator<String> i =q.iterator();
		   while(i.hasNext()) {
			       String s =i.next();
			   if(count >=(q.size() -k)) {
				   StdOut.println(s);
			   }
			   count++;
		   }
	   }
   }
   public static Date[] readDates(String name) {
	   In in =new In(name);
	   Queue<Date> q =new Queue<Date>();
	   while(!in.isEmpty())
	   {
		   String[] fields =in.readString().split("/");
		   int month = Integer.parseInt(fields[0]);
		   int day =Integer.parseInt(fields[1]);
		   int year =Integer.parseInt(fields[2]);
		   Date date =new Date(month,day,year);
		   q.enqueue(date);
	   }
	   int N=q.size();
	   Date[] a =new Date[N];
	   for(int i=0;i<N;i++) {
		   a[i]=q.dequeue();
	   }
	   return a;
	   
   }
   public static void printFiles(String path,String filename,Queue q,String content) {
	   File f =new File(path+File.separator+filename);
	   content = content +"--";
	   if(!f.exists()) return;
	   else {
		   if(!f.isDirectory()) {
                q.enqueue(content+filename+"\r\n");
                return;
		   }
		   else {
			   q.enqueue(content+filename+"\r\n");
			   String[] files =f.list();
			   for(int i=0;i<files.length;i++) {
				   printFiles(path+File.separator+filename, files[i],q, content);
			   }
		   }
	   }
   }
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
	//	parenthesesLeft();
//		InfixToPostfix();
//		lastQueuePrint(4);
		Date[] date = readDates(".\\DateTest.txt");
//		for(int i=0;i<date.length;i++) {
//			StdOut.println(date[i].toString());
//		}
		String path ="D:";
		String filename ="Eclipse";
		String divider="";
		Queue q =new Queue();
		printFiles(path, filename, q,divider);
		File out =new File(path+File.separator+filename+File.separator+"catalog.txt");
		out.createNewFile();
		FileWriter writer =new FileWriter(out);
		while(q.size()>0) {
			writer.write((String)(q.dequeue()));
			
		}
		StdOut.println("Write OK");

	}

}
