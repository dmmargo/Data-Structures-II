public class Heap {
   private final int heap[];
   private int lastIndex;
   private int swaps;

   //size provided by user
   public Heap(int size) {
       heap = new int[size];						//set heap size depending on user's input
       lastIndex = 0; 								//last element + 1
       swaps = 0;									//intizlize swap to be 0
   }

   
   //adds another item to the next slot and checks to make sure there are no duplicates
   //good for checking optimal
   public boolean addCheck(int num) {
       if (same(num) || lastIndex > heap.length - 1)
           return false;							//user cannot add
       else {
           heap[lastIndex] = num;					//new number is placed into heap at next index
           lastIndex++;								//increment index
           return true;								//successfully able to add 
       }
   }
   //add and swap (upheap)
   public boolean add(int num) {
       if (same(num) || lastIndex > heap.length - 1)
           return false;							//was not able to add
       else {
    	   int i = lastIndex;
    	   heap[i] = num;
    	   int parent = (i - 1) / 2;
    	   while (i != 0 && num > heap[parent]) {
    		   heap[i] = heap[parent]; 				//swap
    		   heap[parent] = num;
    		   swaps++;
    		   i = parent;
    		   parent = (i - 1) / 2;
    	   }
    	   lastIndex++;
    	   return true;
       }
   }

   //sees if there are any numbers the same 
   public boolean same(int num) {
       for (int i = 0; i < lastIndex; i++) {
           if (num > heap[i])
               return false;
           else if (num == heap[i])
               return true;
       }
       return false;
   }
   
   //remove the root node and shift the new one down
   public void remove() {
       heap[0] = heap[lastIndex - 1];
       int i = 0;
       move(0);
       lastIndex--;
   }
   
   //reheap the tree after user inputs new numbers
   public void reheap() {
       //find the bottom rung
       int j = lastIndex - 1;
       int height;									//height change
       height = (int) Math.ceil(Math.log((double) (j + 1)) / Math.log(2.0)); //the the ceiling height of j 
       int i = j - 1;
       int newLevel;
       newLevel = (int) Math.ceil(Math.log((double) (i + 1)) / Math.log(2.0)); // the ceiling height of the previous node
       while (newLevel == height) { 				//find left most node on this level
               i--;
               newLevel = (int) Math.ceil(Math.log((double) (i + 1)) / Math.log(2.0));
       } //now i to j is the last level, i - 1 is the lastIndex of the next height up
       while (i != 0) {
           for (int k = i; k <= j; k += 2) {
               if (k + 1 > j) { 					//only one child
                       if (heap[k] > heap[(k - 1) / 2]) {
                               //swap			
                               int temp = heap[k];
                               heap[k] = heap[(k - 1) / 2];
                               heap[(k - 1) / 2] = temp;
                               swaps++;
                               move(k);
                       }
               }
               else { 								//two children
                   if (heap[k] > heap[k + 1] && heap[k] > heap[(k - 1) / 2]) {
                       //swap
                       int temp = heap[k];
                       heap[k] = heap[(k - 1) / 2];
                       heap[(k - 1) / 2] = temp;
                       swaps++;
                       move(k);
                   }
                   else if (heap[k + 1] > heap[k] && heap[k + 1] > heap[(k - 1) / 2]) {
                       //swap
                       int temp = heap[k + 1];
                       heap[k + 1] = heap[(k - 1) / 2];
                       heap[(k - 1) / 2] = temp;
                       swaps++;
                       move(k + 1);
                   }
               }
           }
           //move to the next height
           j = i - 1;
           i = (i - 1) / 2;
       }
   }
  
   //helper function for optomize to move down swapped nodes
   private void move(int m) {
           //have to do bounds checking before accessing the heap
           while (m != lastIndex - 1 && ( (2 * m + 1 < lastIndex && heap[m] < heap[2 * m + 1]) || (2 * m + 2 < lastIndex && heap[m] < heap[2 * m + 2]) ) ) {
               if (2 * m + 2 >= lastIndex || heap[2 * m + 1] > heap[2 * m + 2]) {
                   									//swap
                   int temp = heap[2 * m + 1];
                   heap[2 * m + 1] = heap[m];
                   heap[m] = temp;
                   swaps++;
                   m = 2 * m + 1;
               }
               else {								//swap			
                   int temp = heap[2 * m + 2];
                   heap[2 * m + 2] = heap[m];
                   heap[m] = temp;
                   swaps++;
                   m = 2 * m + 2;
               }
           }
   }

   //returns the number of swaps made by this heap
   public int getSwaps() {
       return swaps;
   }

   //prints the first n values of the heap
   public void print(int n) {
       int i;
       for (i = 0; i < n && i < lastIndex; i++) {
           System.out.print(heap[i]);
           if (i != lastIndex- 1)
               System.out.print(',');
       }
       if (i != lastIndex)
               System.out.print("...");
   }

}