import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

public class MyNode {
    public Node first;
    public MyNode(String s) {
    	first =new Node();
    	first.next=null;
    	first.item=s;
    }
    public MyNode(Node node) {
    	first =node;

    }
    public   void FirstNodeInsert(String s) {
    	Node oldfirst = this.first;
    	Node node =new Node();
    	node.next=oldfirst;
    	node.item=s;
    	this.first=node; ;
    }
    public   void FirstNodeInsert(Node node) {
    	Node oldfirst = this.first;
    	node.next=oldfirst;
    	this.first=node; 
    	int i=0;
    	i=i+1;
    }
    
    public static  void FirstNodeDelete(Node first) {
        if(first ==null) {
        	StdOut.println("Empty Node");
        	return;
        }
    	first =first.next;
    }
    public  void TailNodeInsert(Node first,String s) {
    	if(first ==null) FirstNodeInsert(s);
    	else {
    		Node x =first;
    		for(x=first;x!=null;x=x.next) {
    		}
			Node  tail =new Node();
			tail.next=null;
			x.next=tail;
    	}
    }
    public  void TailNodeInsert(Node node) {
    	if(first ==null) {
    		FirstNodeInsert(node);
    		return;
    		}
    	else {
    		Node x =first;
    		for(x=first;x.next!=null;x=x.next) {
    		}
			node.next=null;
			x.next=node;
    	}
    }
    public  void TailNodeDelete(){
     Node x;
     if(first == null) {
    	 StdOut.println("Empty Nodes");
     }
     else if(first.next ==null) {
    	 first =null;
     }
     else {
    	 for(x=first;x.next.next!=null;x=x.next);
    	 x.next=null;
     }
     
    }
    public  void ErgodicNode() {
    	Node x =first;
    	int count=1;
    	StdOut.println("Ergodic:"+first);
    	for(x =first;x!=null;) {
    		StdOut.printf(" Node <%d> %s   %s  address %s \n", count,x.item,x.next,x);
    		count=count+1;
    		x=x.next;
    	}
    	StdOut.println();
    }
    public void delete(int k) {
    	Node x=first;
    	if(k==0) return;
    	if(x.next==null) {
    		if(k==1) {
    		     first=null;
    		     return;
    		}
    		else if(k>1) {
    			StdOut.println("No more Nodes");
    			return;
    		}
    		
    	}
    	int size =0;
    	for(Node y=x;y!=null;y=y.next)
    		size++;
    	if(k>size) {
    		StdOut.println("No more Nodes");
    		return;
    	}
    	int count =1;
    	for(count=1;count<k-1;count++)
    		x=x.next;
    	x.next=x.next.next;
    	
    }
    public boolean find(String s) {
    	Node x;
    	if(first ==null) return false;
    	boolean temp =false;
    	for(x=first;x!=null;x=x.next)
    		if(x.item.equals(s)){
    			temp =true;
    			return temp;
    		}
    	return temp;
    	
    }
    public void removeAfter(Node node) {
    	Node x;
    	for(x =first;x!=null;x=x.next) {
    		if(x.equals(node)) {
    			x.next =null;
    			return;
    		}
    	}
    }
    public void deleteNode(Node node) {
    	Node x;
    	if(node.equals(first)) {
    		first=null;
    		return;
    	}
    	for(x=first;x!=null;x=x.next) {
    		if(x.next.equals(node)) {
    			x.next=node.next;
    		}
    	}
    }
    public void remove(String s) {
    	if(first ==null) return;
    	if(first.item ==s) {
    		first=null;
    		return;
    	}
    	Node x;
    	int count =1;
    	for(x=first;x!=null;x=x.next) {
    		if(x.next!=null) {
    		 StdOut.printf(" %d  %s \n",count++,x.item);
    		if(x.next.item ==s) {
    			x.next =x.next.next;
    		}
    		
    		}
    	}
    	return ;
    	
    }
    public void max() {
    	Node x;
    	String max;
    	if(first == null) return;
    	else max =first.item;
    	for(x=first;x!=null;x=x.next) {
    		if(x.item.compareTo(max) >0) max =x.item;
    	}
    	StdOut.printf("max item of the Nodes is %s \n",max);
    }
    public String  max(Node node,String max) {
    	if(node.next == null) return (max.compareTo(node.item)>=0)?max:node.item;
    	max=( (max.compareTo(node.item)>=0)?max:node.item);
    	return max(node.next,max);
    }
    public void insertAfer(Node node1 ,Node node2) {
    	if((node1 ==null)&&(node2==null)) return;
    	else if(node2==null) {
    		this.FirstNodeInsert(node1);
    		return;
    	}
    	else {
    		this.FirstNodeInsert(node2);
    		this.FirstNodeInsert(node1);
    	}
    	StdOut.println("In the function insertAfter ");
    	this.ErgodicNode();
    }
    public MyNode reverseNode() {
    	MyNode newNode;
    	Stack<Node> nodeStack =new Stack<Node>();
    	Node x ;
    	for(x=first;x!=null;x=x.next) {
    		nodeStack.push(x);
    	}
    	newNode = new MyNode(nodeStack.pop());
    	while(!nodeStack.isEmpty()) {
    		x =nodeStack.pop();
    		newNode.TailNodeInsert(x);
    	}
    	x.next=null;
    	return newNode;
   
    }
    public Node reverse(Node node) {
    	if(node ==null) return null;
    	if(node.next ==null) return node;
    	Node second =node.next;
    	Node rest =reverse(second);
    	second.next =node;
    	node.next=null;
    	return rest;
    	
    	
    	
    }
	public static void main(String[] args) {                               
		// TODO Auto-generated method stub
       MyNode mynode = new MyNode(""+1);
  //     Node first =mynode.first;//first 会变动 每次倒要动态
       mynode.FirstNodeInsert(""+2);
       mynode.FirstNodeInsert(""+3);
       mynode.FirstNodeInsert(""+4);
       Node node1 =mynode.first;
       mynode.FirstNodeInsert(""+5);
       mynode.FirstNodeInsert(""+6);
       mynode.FirstNodeInsert(""+7);
       mynode.FirstNodeInsert(""+8);
       mynode.FirstNodeInsert(""+9);
       mynode.ErgodicNode();
       StdOut.println("Afeter reversed");
//       MyNode revnode =mynode.reverseNode();
       Node renode =mynode.reverse(mynode.first);
       Node x;
       for(x=renode;x!=null;x=x.next)
    	   StdOut.printf(" Node   %s   %s  address %s \n",x.item,x.next,x);
 //      mynode.TailNodeDelete();
 //      mynode.ErgodicNode();
//       StdOut.println(mynode.find("10"));
//       StdOut.println(mynode.find("5"));
//       StdOut.println(node1.item +" "+node1);
//       mynode.removeAfter(node1);
//       Node node3 =new Node();
//       node3.item="99";
//       Node node2 =new Node();
//       node2.item="45";
//       mynode.insertAfer(node2, node3);
//       mynode.FirstNodeInsert(""+9);
//       mynode.FirstNodeInsert(""+55);
//       mynode.FirstNodeInsert(""+22);
//       mynode.ErgodicNode();
//       String s="9";
//       mynode.remove(s);
//       mynode.ErgodicNode();
//       mynode.max();
//       Node x =mynode.first;
//       String max =""+0;
//       StdOut.println("Max of the Nodes is "+mynode.max(x, max));
       
       
       
	}

}
