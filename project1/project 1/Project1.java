import java.util.Scanner;

public class Project1 {
    public static void main(String[] args) {
    	Scanner kb = new Scanner(System.in);
    	BST tree  =  new BST();
    	String lin;
    	System.out.println("Please enter the initial sequence of values:");
    	lin = kb.nextLine();
    	String[] sarr  =  lin.split(" ");
    	int[] arr  =  new int[sarr.length];
       
    	int di = 0;
    	for(di  =  0; di < sarr.length; di++) {
    		arr[di]  =  Integer.parseInt(sarr[di]);
    	}
    	for(int k = 0;k<di;k++) {
    		tree.addEntry(arr[k]);
    	}
    	
    	//getting transverse
    	System.out.print("Pre-Order: ");
    	tree.preOrder();
    	System.out.println();
       
    	System.out.print("In-Order: ");
    	tree.inOrder();
    	System.out.println();
       
    	System.out.print("Post-Order: ");
    	tree.postOrder();
    	System.out.println();
       
    	String kbCo;
    	System.out.print("Command? ");
    	kbCo = kb.nextLine();
    	
    	String[] array= new String[10];
       
    	int newEntry;
    	
    	
    	while(kbCo!= "E") {
    		char user  =  kbCo.charAt(0);
           
    		if (user == 'H') {
    			System.out.println("I Insert a value");
    			System.out.println("D Delete a value");
    			System.out.println("P Find predecessor");
    			System.out.println("S Find successor");
    			System.out.println("E Exit the program");
    			System.out.println("H Display the message");
    		}
    		else if (user == 'I') {
    			array= kbCo.split(" ");
    			newEntry = Integer.parseInt(array[1]);
    			tree.addEntry(newEntry);
    			System.out.print("In-Order: ");
    			tree.inOrder();
    			System.out.println();
    		}
    		else if (user  == 'D') {
    			array= kbCo.split(" ");
    			newEntry = Integer.parseInt(array[1]);
    			tree.removeEntry(newEntry);
    			System.out.print("In-Order: ");
    			tree.inOrder();
    			System.out.println();
    		}
    		else if (user  == 'P') {
    			array= kbCo.split(" ");
    			newEntry = Integer.parseInt(array[1]);
    			tree.findPredecessor(newEntry);
    			//System.out.println(tree);
    		}
    		else if (user  == 'S') {
    			array= kbCo.split(" ");
    			newEntry = Integer.parseInt(array[1]);
    			tree.findingSuccessor(newEntry);
    			//System.out.println(tree);
    		}
    		else if (user  == 'E') {
    			System.out.println("Thank you for using my program!");
    			System.exit(0);
    		}
    		else {
    			System.out.println("Input is wrong. Try again!");
    		}
           
    		System.out.print("Command? ");
    		kbCo = kb.nextLine();
       }
    }
}

