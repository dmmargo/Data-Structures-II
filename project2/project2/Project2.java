import java.util.*;

public class Project2 {
   public static void main(String[] args) {
       Scanner kb = new Scanner(System.in);
       Random rd = new Random();
       
																		//prompt
       System.out.println("Please select how to test the program: ");
       System.out.println("(1) 20 sets of 100 randomly generated integers");
       System.out.println("(2) Fixed integer values 1-100");
       System.out.print("Enter choice: ");
       
       
       int choice = kb.nextInt(); 										//get choice from user (1) (2) or invalid
       
       /*test your program with 100 randomly generated integers 
       (no duplicates, positive numbers with proper range);*/
       if(choice == 1) {												//if user chooses 1
    	   Heap heaps[] = new Heap[20];									//create new heap with 20 spaces
    	   int optimalSwap = 0;

           //series of insertions
           for (int i = 0; i < 20; i ++) {
               heaps[i] = new Heap(100);
               for (int j = 0; j < 100;) {
                   if (heaps[i].add(rd.nextInt(2147483647) + 1)) 		//if successfully added with no duplicate, increase num
                       j++;									 	 		//increment j
               }
               optimalSwap += heaps[i].getSwaps();						//swap- calls function to switch
           }
           double avgSwaps = optimalSwap / 20.0;						//avg swaps = optimal swap /20
           System.out.print("\nAverage swaps for series of insertions: ");	//prints avg swap
           System.out.println(avgSwaps);

           //optimal method
           optimalSwap = 0;												//set optimal swap back to 0
           for (int i = 0; i < 20; i ++) {
               heaps[i] = new Heap(100);
               for (int j = 0; j < 100;) {
                   if (heaps[i].addCheck(rd.nextInt(2147483647) + 1)) 	//checks to see if there are any duplicates
                       j++; 											//if dupocates, increment j
               }
               heaps[i].reheap();										//reheap
               optimalSwap += heaps[i].getSwaps();						//get swap method again
           }
           avgSwaps = optimalSwap / 20.0;
           System.out.print("Average swaps for optimal method: ");		//prints avg swap again
           System.out.println(avgSwaps);
       }
       /*test your program with the following 100 fixed values from 1, 2, 3, ..., and 100*/
       else if(choice==2) {												//if user picked 2
    	 //series of insertions
           Heap heap = new Heap(100);									//set size to 100
           for (int i = 1; i <= 100; i++) {								//for loop for adding
               heap.add(i);												//adds i to the heap
           }
           System.out.print("\nHeap built using series of insertions: ");
           heap.print(10);												//prints first 10 values
           System.out.println();
           System.out.print("Number of swaps: ");
           System.out.println(heap.getSwaps());							//prints number of times swapped
           for (int i = 0; i < 10; i++) {
               heap.remove();											//remove from heap
           }
           System.out.print("Heap after 10 removals: ");
           heap.print(10);												//prints the first 10 numbers removed from heap
           
           System.out.println();

           //optimal method
           heap = new Heap(100);
           for (int i = 1; i <= 100; i++) {
               heap.addCheck(i);										//checks to make sure no duplicates for optimal
           }
           heap.reheap();												//reheap
           System.out.print("\nHeap built using optimal method: ");		
           heap.print(10);												//prints first 10 numbers of optimal method
           
           System.out.println();
           
           System.out.print("Number of swaps: ");						
           System.out.println(heap.getSwaps());							//prints number of swaps
           
           for (int i = 0; i < 10; i++) {								//remove 10 from heap
               heap.remove();
           }
           System.out.print("Heap after 10 removals: ");				
           heap.print(10);												//prints first 10 removals
           
           System.out.println();
       }
       
       else {															//if not 1 or 2, print invalid input
    	   System.out.println("not a valid selection");
       }
   }
}