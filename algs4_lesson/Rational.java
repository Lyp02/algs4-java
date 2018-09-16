import edu.princeton.cs.algs4.StdOut;

public class Rational {
    private int num;
    private int den;
    public Rational(int num,int den) {
    	assert num!=0 :"num cannont be zero!";
    	assert (Math.abs(num)<=Integer.MAX_VALUE)&&(Math.abs(den)<=Integer.MAX_VALUE):"num or den over the max value of Integer";
    	this.num=num;
    	this.den=den;
    }
    public Rational minus(Rational b) {
    	int x =this.num*b.den - this.den*b.num;
    	int y =this.den*b.den;
    	int  z =Euclid(x, y);
    	return new Rational((x/z),(y/z));
    	
    }
    public Rational plus(Rational b) {
    	int x =this.num*b.den + this.den*b.num;
    	int y =this.den*b.den;
    	int z =Euclid(x, y);
    	return new Rational((x/z),(y/z));
    	
    }
    public Rational times(Rational b) {
    	int x =this.num*b.num;
    	int y =this.den*b.den;
    	int z =Euclid(x, y);
    	return new Rational((x/z),(y/z));
    	
    }
    public Rational divdes(Rational b) {
    	int x =this.num*b.den;
    	int y =this.den*b.num;
    	int z =Euclid(x, y);
    	return new Rational((x/z),(y/z));
    	
    }
    public boolean equals(Rational b) {
         boolean temp =(this.num * b.den ) ==(this.den *b.num);
         return temp;
    }
    
    public String toString() {
    	return this.num+"/"+this.den;
    }
	public static int Euclid(int p,int q) {
		if((p%q)==0) return q;
		else return Euclid(q,p%q);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       Rational r1 =new Rational(9, 15);
       Rational r2 =new Rational(11, 89);
       Rational r3=new Rational(3, 5);
       StdOut.println(r1.plus(r2).toString());
       StdOut.println(r1.minus(r2).toString());
       StdOut.println(r1.times(r2).toString());
       StdOut.println(r1.divdes(r2).toString());
       StdOut.println(r1.equals(r3));
       StdOut.println(r3.toString());
	}

}
