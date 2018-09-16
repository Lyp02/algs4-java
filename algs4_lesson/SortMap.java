
public class SortMap implements Comparable<SortMap> {
    private String Key;
    private int index;
    public SortMap(String item,int i){
    	this.Key = item;
    	this.index =i;
    }
    public int getIndex(){
    	return index;
    }
    
    public String getKey(){
    	return Key;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public int compareTo(SortMap o) {
		// TODO Auto-generated method stub
		return this.Key.compareTo(o.Key);
	}




}
