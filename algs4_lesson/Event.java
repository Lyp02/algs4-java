
public class Event implements Comparable<Event> {
	private SortDate date;
	private String city;
	public Event(SortDate date ,String city){
		this.date =date;
		this.city =city;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public int compareTo(Event o) {
		// TODO Auto-generated method stub
		return this.date.compareTo(o.date);
	}

}
