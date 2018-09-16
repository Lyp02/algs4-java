import java.util.Comparator;

import edu.princeton.cs.algs4.Date;

public class Transaction implements Comparable<Transaction> {
	private String who;
	private Date when;
	private double amount;
public Transaction(String who,Date when,double amount) {
	this.who =who;
	this.when=when;
	this.amount =amount;
}
public String who() {
	return this.who;
}
public Date when() {
	return this.when;
}
public double amount() {
	return this.amount;
}
public String toString() {
	return this.when+" "+this.who+" amount: "+this.amount;
}
public boolean equals(Transaction t) {
	if(this.who.equals(t.who)&&this.when.equals(t.when)&&(this.amount==t.amount))
		return true;
	else return false;
}
public int compareTo(Transaction t) {
	if (this.amount >t.amount)
		return 1;
	else if(this.amount ==t.amount)
		return 0;
	else return -1;
}
public static class WhoOrder implements Comparator<Transaction>{
	public int compare(Transaction v,Transaction w){
		return v.who.compareTo(w.who);
	}
}

public static class WhenOrder implements Comparator<Transaction>{
	public int compare(Transaction v,Transaction w){
		return v.when.compareTo(w.when);
	}
}

public static class HowMuchOrder implements Comparator<Transaction>{
	public int compare(Transaction v,Transaction w){
		if(v.amount<w.amount) return -1;
		if(v.amount>w.amount) return 1;
		return 0;
	}
}

public static void sort(Object[] a,Comparator c){
	int N =a.length;
	for(int i=1;i<N;i++)
		for(int j=i;j>0&&less(c,a[j],a[j-1]);j--)
			exch(a,j,j-1);
}

private static boolean less(Comparator c,Object v,Object w){
	return c.compare(v, w)<0;
}
private static void exch(Object[] a,int i,int j){
 Object t =a[i];
 a[i] =a[j];
 a[j] =t; 
}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     
	}

}
