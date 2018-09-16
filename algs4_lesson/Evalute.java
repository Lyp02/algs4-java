import java.util.Scanner;
import java.util.Stack;

public class Evalute{
	public static void main(String[] args) {
		Stack<String> ops =new Stack<String>();
		Stack<Double> vals=new Stack<Double>();
		String content;
		Scanner in =new Scanner(System.in);
		content =in.nextLine();
		while(!content.isEmpty()) {
			if(content.equals("("));
			else if(content.equals("+")) ops.push(content);
			else if(content.equals("-")) ops.push(content);
			else if(content.equals("*")) ops.push(content);
			else if(content.equals("/")) ops.push(content);
			else if(content.equals("sqrt")) ops.push(content);
			else if(content.equals(")")) {
				String op =ops.pop();
				double v=vals.pop();
				if(op.equals("+")) v=vals.pop()+v;
				else if(op.equals("-")) v=vals.pop() -v;
				else if(op.equals("*")) v=vals.pop()*v;
				else if(op.equals("/")) v=vals.pop()/v;
				else if(op.equals("sqrt")) v=Math.sqrt(v);
				vals.push(v);
			}
			else vals.push(Double.parseDouble(content));
			content =in.nextLine();
			
		}
		System.out.println(vals.pop());
		
		
	} 
}
