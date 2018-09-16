import edu.princeton.cs.algs4.StdOut;

public class MyDoubleNode {
   public DoubleNode first;
   public DoubleNode last;
   public MyDoubleNode(String s) {
	   first = new DoubleNode(s);
	   last =first;
	   first.backward=null;
	   last.forward=null;
   } 
   public void FirstNodeInsert(String s) {
	   if(first ==null) {
          first =new DoubleNode(s);
          last =first;
          first.backward=null;
          last.forward=null;
	   }
	   else {
		   DoubleNode oldfirst =first;
		   first =new DoubleNode(s);
		   first.backward =oldfirst;
		   first.forward=oldfirst.forward;
		   oldfirst.forward =first;
	   }
   }
   public void LastNodeInsert(String s) {
	   if(last ==null) {
		   last =new DoubleNode(s);
		   first =last;
		   first.backward=null;
		   last.forward=null;
	   }
	   else {
		   DoubleNode oldlast =last;
		   last =new DoubleNode(s);
		   last.forward =oldlast;
		   last.backward =oldlast.backward;
		   oldlast.backward=last;

	   }
   }
   public void BackwardErgodic() {
	   StdOut.println(" Backward Ergodic");
	   DoubleNode x;
	   if(first ==null) return;
	   else {
		   for(x=first;x!=null;x=x.backward)
			   StdOut.println(x +x.item +""+ "---->"+x.backward);
	   }
	   
   }
   public void ForwardErgodic() {
	   StdOut.println(" Forward Ergodic");
	   DoubleNode x;
	   if(last ==null) return;
	   else {
		   for(x=last;x!=null;x=x.forward)
			   StdOut.println(x.forward +" <------"+" "+x.item+x);
	   }
   }
   public void FirstDeleteNode() {
	   if(first ==last) {
		   first =null;
		   last =null;
		   return;
	   }
	   first =first.backward;
	   first.forward =null;
   }
   public void LastDeleteNode() {
	   if(first ==last) {
		   first =null;
		   last =null;
	   }
	   last =last.forward;
	   last.backward=null;
   }
   public void InsertBeforeNode(String s1,String  s2 ) {
	   DoubleNode x;
	   DoubleNode y=new DoubleNode(s2);
	   if(first.item ==s1) {
		   this.FirstNodeInsert(s2);
		   return;
		   
	   }
	   for(x=first;x!=null;x=x.backward) {
		   if(x.item == s1) {
			   StdOut.println("Find");
			   y.backward =x;
			   y.forward=x.forward;
			   x.forward.backward=y;
			   x.forward=y;
			   
		   }
	   }
	   this.BackwardErgodic();
	   StdOut.println("Inside Ergodic");
   }
   public void InsertAfterNode(String s1,String s2) {
	   DoubleNode x;
	   DoubleNode y=new DoubleNode(s2);
	   if(last.item ==s1) {
		   this.LastNodeInsert(s2);
		   return;
	   }
	   for(x=last;x!=null;x=x.forward) {
		   if(x.item ==s1) {
			   StdOut.println("Find");
			   y.forward =x;
			   y.backward=x.backward;
			   x.backward.forward=y;
			   x.backward=y;
		   }
	   }
   }
   public void DeleteNode(String s1) {
	   if(first ==null) {
		   StdOut.println("Empty Node");
		   return;
	   }
	   if(last ==null) {
		   StdOut.println("Empty Node");
		   return;
	   }
	   if(first.item ==s1) {
		   first =first.backward;
		   first.forward=null;
		   return;
	   }
	   if(last.item==s1) {
		   last=last.forward;
		   last.backward=null;
		   return;
	   }
	   else {
		   DoubleNode x;
		   for(x=first;x!=null;x=x.backward) {
			   if(x.item ==s1)
				   break;
		   }
		   x.forward.backward=x.backward;
		   x.backward.forward=x.forward;
	   }
   }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      MyDoubleNode mynode =new MyDoubleNode("1");
      mynode.LastNodeInsert("2");
      mynode.LastNodeInsert("3");
      mynode.LastNodeInsert("4");
      mynode.LastNodeInsert("5");
      mynode.BackwardErgodic();
      mynode.LastNodeInsert("6");
      mynode.LastNodeInsert("7");
      mynode.ForwardErgodic();
      StdOut.println("Delete First Node");
      mynode.BackwardErgodic();
      mynode.FirstDeleteNode();
      mynode.BackwardErgodic();
      StdOut.println("Delete Last Node");
      mynode.ForwardErgodic();
      mynode.LastDeleteNode();
      mynode.BackwardErgodic();
      mynode.InsertBeforeNode("5", "55");
      mynode.BackwardErgodic();
      StdOut.println("*****************************");
      mynode.ForwardErgodic();
      mynode.InsertAfterNode("6", "77");
      StdOut.println("Insert After");
      mynode.ForwardErgodic();
      StdOut.println("Delete Node ");
      mynode.DeleteNode("3");
      mynode.ForwardErgodic();
	}

}
