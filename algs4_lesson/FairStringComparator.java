import java.util.Comparator;

public class FairStringComparator implements Comparator<String>{
    public static String standard ="RWQOJMVAHBSGZXNTCIEKUPDYFL";
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public int compare(String o1, String o2) {
		// TODO Auto-generated method stub
		int i =0;
		int j =0;
		while(i!=o1.length()&&j!=o2.length()){
			if(standard.indexOf(o1.charAt(i)) < standard.indexOf(o2.charAt(j))) return +1;
			if(standard.indexOf(o1.charAt(i)) > standard.indexOf(o2.charAt(j))) return -1;
		}
		if(i==o1.length()&&j==o2.length()) return 0;
		else if(o1.length() <o2.length()) return +1;
		else return -1;
		
	}

	




}
