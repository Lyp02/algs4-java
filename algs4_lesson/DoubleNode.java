
public class DoubleNode {
   String item;
   DoubleNode forward;
   DoubleNode backward;
   public DoubleNode(DoubleNode node) {
	   this.item =node.item;
	   this.forward=null;
	   this.backward=null;
   }
   public DoubleNode(String s) {
	   this.item =s;
	   this.forward=null;
	   this.backward=null;
   }
   
   public String printString() {
	   String s= this+": "+this.forward+"<----" +" item:"+this.item+" DoubleNode: "+this.hashCode()+" ---->"+this.backward;
	   return s;
   }
   
}
