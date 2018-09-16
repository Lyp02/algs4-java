
public class Domain implements Comparable<Domain> {
    private String[] name;
    public String[] getName(){
    	return name;
    }
    public Domain(String content){
    	String[] temp =content.split("\\.");
    	int length =temp.length;
    	int j=length-1;
    	name =new String[length];
    	for(int i=0;i<length;i++){
    		name[i]=temp[j--];
    	}
    }
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	@Override
	public int compareTo(Domain o) {
		// TODO Auto-generated method stub
		String[] a =this.name;
		String[] b =o.getName();
		int i=0;
		int j=0;
		while(i!=a.length&&j!=b.length){
			if(a[i].compareTo(b[j])<0) return -1;
			if(a[i].compareTo(a[j])>0) return +1;
			i++;
			j++;
		}
        if(i==a.length&&j==b.length) return 0;
        else if(a.length>b.length) return -1;
        else return +1;
		
	}

}
