import edu.princeton.cs.algs4.StdOut;

public class ResizingArrayDeque {
    public String[] a;
    public int first;
    public int last;
    public int N;
    public ResizingArrayDeque(int cap) {
    	a =new String[cap];
    	first=cap/2;
    	last=cap/2;
    	N=0;
    	
    }
    public boolean isEmpty() {
    	if((first == last)&&(a[first]==null)) return true;
    	else return false;
    	
    }
    public int size() {
    	if((first ==last)&&(a[first]==null)) return 0;
    	else return last -first+1;
    	
    }
    public void resize(int length) {
      int currenLength =last-first+1;
      int start =(length -currenLength)/2;
      String[] b=new String[length];
      for(int i=0;i<currenLength;i++) {
    	  b[(start)+i]=a[first+i];
      }
      first =start;
      last =first+currenLength-1;
      a=b;
    	
    }
    public void judegeResize() {
    	if(first == last) return;
    	if((first==0 || last==a.length-1)) {
    		if((last -first +1)<(a.length)/4) {
    			resize(a.length/2);
    			return;
    		}
    		else if((last -first+1)>(a.length/2)) {
    			resize(a.length*2);
    			return;
    		}
    		else {
    			resize(a.length);
    			return;
    		}
    	}
    	else if((last-first+1)==a.length/4) {
    		resize(a.length/2);
    		return;
    	}
    	else if((last-first+1)==a.length) {
    		resize(a.length*2);
    		return;
    	}
    }
    public void pushLeft(String s) {
    	this.judegeResize();
    	if(a[first] ==null) {
    		a[first]=s;
    		first=first-1;
    		return;
    	}

    	a[first] =s;
    	first=first-1;
    	N++;
    	
    }
    public void pushRigth(String s) {
    	this.judegeResize();
    	if(a[last] ==null) {
    		a[last]=s;
    		last=last+1;
    		return;
    	}
        last =last+1;
    	a[last]=s;
    	N++;
    }
    
    public String popLeft() {

    	String temp=a[first+1];
    	a[first]=null;
    	first=first+1;
    	this.judegeResize();
    	N--;
    	return temp;
    	
    }
    public String popRight() {
    	String temp=a[last];
    	a[last]=null;
    	last=last-1;
    	this.judegeResize();
    	N--;
    	return temp;
    	
    }
    public void ergodic() {
    	int count =1;
    	for(int i=first+1;i<=last;i++) {
    		StdOut.println("Element "+count +" "+a[i]);
    		count=count+1;
    	}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       ResizingArrayDeque q =new ResizingArrayDeque(4);
       q.pushLeft("1");
       q.pushLeft("2");
       q.pushLeft("3");
       q.pushLeft("4");
       q.pushRigth("11");
       q.pushRigth("12");
       q.ergodic();
       StdOut.println(q.popLeft() +" Left");
       StdOut.println(q.popRight()+ " Right");
       StdOut.println(q.popLeft() +" Left");
       StdOut.println(q.popRight()+ " Right");
       q.ergodic();
	}

}
