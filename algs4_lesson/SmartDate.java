import edu.princeton.cs.algs4.StdOut;

public class SmartDate  {
	private int month;
	private static  int day;
	private int year;
	private static String[] weekDays= {"Saturday","Sunday","Monday","Tuesday","Wendesday","Thursday","Friday"};
	private static final int[] DAYS = { 0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };	
	
	
	
	
	public SmartDate(int month, int day, int year) {
		if (!isValid(month, day, year)) throw new IllegalArgumentException("Invalid date");
		this.month =month;
		this.day=day;
		this.year=year;
		
	}
    private static boolean isValid(int m, int d, int y) {
        if (m < 1 || m > 12)      return false;
        if (d < 1 || d > DAYS[m]) return false;
        if (m == 2 && d == 29 && !isLeapYear(y)) return false;
        return true;
    }
    private static boolean isLeapYear(int y) {
        if (y % 400 == 0) return true;
        if (y % 100 == 0) return false;
        return y % 4 == 0;
    }
	public  int day() {
		return this.day;
	}
	public int month() {
		return this.month;
	}
	public int year() {
		return this.year;
	}
	public static String dayOfTheWeek(SmartDate date) {
		int currentDay =date.day();
		int currentMonth =date.month();
		int currentYear=date.year();
		int leapYearCounts =(currentYear/4)-(2000/4) +1;
		int dayCounts =(currentYear-2000)*365+(leapYearCounts);
		if(currentYear ==2000) dayCounts=0;
		for(int i=1;i<currentMonth;i++) {
			dayCounts=dayCounts+DAYS[i];
		}
		if(currentMonth <= 2) return weekDays[(dayCounts+currentDay-1)%7];
		else if((currentYear%4)!=0) return weekDays[( currentDay+dayCounts-1-1)%7];
		else return weekDays[(currentDay+dayCounts-1)%7];
		
	}
    


	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      int day =1;
      int month =1;
      int year =2000;
      SmartDate date =new SmartDate(month, day, year);
      StdOut.println(date.dayOfTheWeek(date));
	}

}
