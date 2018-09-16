import java.util.Comparator;
import java.util.Iterator;

import javax.swing.event.InternalFrameListener;

import org.omg.CORBA.Context;
import org.omg.CORBA.ContextList;
import org.omg.CORBA.DomainManager;
import org.omg.CORBA.ExceptionList;
import org.omg.CORBA.NVList;
import org.omg.CORBA.NamedValue;
import org.omg.CORBA.Object;
import org.omg.CORBA.Policy;
import org.omg.CORBA.Request;
import org.omg.CORBA.SetOverrideType;
import org.omg.PortableInterceptor.Interceptor;

import edu.princeton.cs.algs4.StdOut;

public class StringTimes  implements Comparable<StringTimes>{
    private String s;
    private Integer t;
    public StringTimes(String s,Integer t){
    	this.s =s;
    	this.t=t;
    }
    public Integer getTimes(){
    	return t;
    }
    public String getString(){
    	return s;
    }
    public void add(){
    	t++;
    }
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	@Override
	public int compareTo(StringTimes o) {
		// TODO Auto-generated method stub
		return this.getTimes().compareTo(o.getTimes());
	}
	
	public boolean equals(Object o){
		StringTimes temp =(StringTimes)o;
		StdOut.println(" equals   "+this.getString()+" : "+temp.getString());
		return this.getString().equals(temp.getString());
	}

	
	
    

}
