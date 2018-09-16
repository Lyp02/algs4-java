//2018 5.24 9:33
public class mySort {
     private long[] arrays;
     private int length;
     private int index;
     public mySort(int lens) {
    	 arrays =new long[lens];
    	 length=lens;
    	 index=-1;
    	 
     }
     public int getLength() {
    	 return (index+1);
     }
     public int insert(long newNum) {
    	 if(index >= this.length-1) {
    		 System.out.println("no space for the new value");
    		 return -1;
    	 }
    	 else {
    		 index=index+1;
    		 arrays[index] =newNum;
    		 return 0;
    	 }
     }
     public int delete() {
    	 if(index <=-1) {
    		 System.out.println("no value in the Array");
    		 return -1;
    	 }else {
    		 this.arrays[index] =0;
    		 index=index-1;
    		 return 0;
    	 }
     }
     public void display() {
    	 if(index ==-1) {
    		 System.out.println("no value in the Array");
    		 return;
    	 }
    	 else {
    	 for(int i=0;i<=index;i++) {
    		 System.out.print(arrays[i]);
    		 System.out.print(" ");
    	 }
    	 System.out.println("");
    	 }
    	 return;
     }
     private void swap(int i,int j) {
    	 long temp =this.arrays[i];
    	 this.arrays[i]=this.arrays[j];
    	 this.arrays[j]=temp;
    	 
     }
     public void bubbleSort() {
    	for (int i=index;i>0;i--) {
    		for(int j=0;j<i;j++) {
    			if(this.arrays[j]>this.arrays[j+1])
    				swap(j,j+1);
    		}
    		
    	}
    	return;
 
     }
     public void selectSort() {
    	 int min=0;
    	 for(int i=0;i<index;i++) {
    		 min=i;
    		 for(int j=i+1;j<=index;j++) {
    			 if(this.arrays[min]>this.arrays[j]) {
    				 min=j;
    		 }
    		 
    		 
    	 }
    		 swap(i,min);
    	 
     }
    	 return;
     }
     public void insertSort() {
    	 int i=0;
    	 int j=0;
    	 long temp;
    	 for(i=0;i<index;i++) {
    		 temp=this.arrays[i+1];
    		 j=i;
    		 while((j>=0)&&(temp<this.arrays[j])) {
    			 this.arrays[j+1]=this.arrays[j];
    			 j--;
    		 }
    		 this.arrays[j+1]=temp;
    	 }
     }
     
//     public void shellSort() {
//      int h=1;
//      int j;
//      int i;
//      long temp;
//      while(h<((index +1)/3)) h=3*h+1;
//      while(h>=1) {
//    	  for( i=h;i<=index;i++) {
//    		 temp=this.arrays[i+h];
//    		  for(j=i;j>=h &&(temp<this.arrays[j]);j-=h) {
//    			  this.arrays[j+h]=this.arrays[j];
//    		  }
//    		  this.arrays[j+h] =temp;
//    	  }
//    	  h=h/3;
//      }
//      
//     }
     public void shellSort() {
    	 int N=index+1;
    	 int h=1;
    	long temp;
    	 while(h<N/3) h=3*h+1;
    	 while(h>=1) {
    		 for(int i=h;i<N;i++) {
    			 for(int j=i;j>=h&&(this.arrays[j]<this.arrays[j-h]);j-=h)
    				 {temp=this.arrays[j];
    				 this.arrays[j] =this.arrays[j-h];
    				 this.arrays[j-h]=temp;
    				 }
    			 
    		 }
    		 h=h/3;
    	 }
     }
     
     public static void main(String[] args) {
    	 mySort sortInstance = new mySort(120);
    	 sortInstance.insert(23);
    	 sortInstance.insert(21);
    	 sortInstance.insert(145);
    	 sortInstance.insert(2);
    	 sortInstance.insert(8);
    	 sortInstance.insert(78);
    	 sortInstance.insert(4);
    	 sortInstance.insert(76);
    	 sortInstance.insert(46);
    	 sortInstance.display();
    	 sortInstance.bubbleSort();
    	 System.out.println("after bubble Sort-----");
    	 sortInstance.display();
    	 sortInstance.insert(66);
    	 sortInstance.insert(21);
    	 sortInstance.insert(67);
    	 sortInstance.insert(89);
    	 sortInstance.display();
    	 sortInstance.selectSort();
    	 System.out.println("after select Sort----");
    	 sortInstance.display();
    	 sortInstance.insert(5);
    	 sortInstance.insert(13);
    	 sortInstance.display();
    	 sortInstance.insertSort();
    	 System.out.println("after insert Sort---");
    	 sortInstance.display();
    	 sortInstance.insert(23);
    	 sortInstance.insert(21);
    	 sortInstance.insert(145);
    	 sortInstance.insert(2);
    	 sortInstance.insert(8);
    	 sortInstance.insert(78);
    	 sortInstance.insert(4);
    	 sortInstance.insert(76);
    	 sortInstance.insert(46);
    	 sortInstance.shellSort();
    	 System.out.println("after shell Sort---");
    	 sortInstance.display();
    	 
     }
     
     
     
}
