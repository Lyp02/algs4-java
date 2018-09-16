import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public abstract class STtest {

	public static void main(String[] args) {
		// TODO Auto-generated method stuTb
		ST<String,Integer> st;
		st =new ST<String,Integer>();
		for(int i=0;!StdIn.isEmpty();i++){
			String key =StdIn.readString();
			st.put(key, i);
		}
		for(String s:st.keys())
			StdOut.println(s +" "+st.get(s));
			

	}

}
