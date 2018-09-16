
public class Task  implements Comparable<Task>{
    private String taskname;
    private Double time;
    public Task(String taskname,Double time ){
    	this.taskname =taskname;
    	this.time =time;
    }
    public String getString(){
    	return this.taskname;
    }
    public Double getTime(){
    	return this.time;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	@Override
	public int compareTo(Task o) {
		// TODO Auto-generated method stub
		return this.getTime().compareTo(o.getTime());
	}

}
