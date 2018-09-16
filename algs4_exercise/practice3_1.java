import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class practice3_1 {
    public static void Question1(){
    	int capacity =20;
    	BinarySearchST<String, Double> bs =new BinarySearchST(capacity);
    	bs.put("F",0.00 );
    	bs.put("D", 1.00);
    	bs.put("C-", 1.67);
    	bs.put("C", 2.00);
    	bs.put("C+", 2.33);
    	bs.put("B-", 2.67);
    	bs.put("B", 3.00);
    	bs.put("B+", 3.33);
    	bs.put("A-", 3.67);
    	bs.put("A", 4.00);
    	bs.put("A+", 4.33);
    	StdOut.println(" input the Character");
    	while(!StdIn.isEmpty()){
    		String s = StdIn.readString();
    		Double result =bs.get(s);
    		if(result ==null){
    			StdOut.println("illegal input");
    		}
    		else{
    			StdOut.println(" Grades : "+result);
    		}
    		StdOut.println(" input the Character");
    	}
    	StdOut.println(" End");
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       Question1();
	}

}
