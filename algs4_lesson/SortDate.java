import java.util.Comparator;

public class SortDate  implements Comparable<SortDate>{
    private int hours;
    private int minutes;
    private int seconds;
    public SortDate(int h,int m,int s){
    	this.hours =(h%24);
    	this.minutes =(m%60);
    	this.seconds =(s%60);
    }
    
    @Override
    public int compareTo( SortDate o2) {
    	// TODO Auto-generated method stub
    	if(this.hours<o2.hours) return -1;
    	else if(this.hours>o2.hours) return +1;
    	else{
    		if(this.minutes<o2.minutes) return -1;
    		else if(this.minutes>o2.minutes) return +1;
    		else{
    			if(this.seconds<o2.seconds) return -1;
    			else if(this.seconds>o2.seconds) return +1;
    			else return 0;
    		}
    	}
    }
    
    public String toString(){
    	return this.hours+":"+this.minutes+":"+this.seconds;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub


	}

}
