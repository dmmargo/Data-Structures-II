public class BST {
    class TreeNode {
        int newEntry;
        TreeNode leftChild, rightChild;
        
        public TreeNode(int n) {
            newEntry = n;
            leftChild  =  null;
            rightChild  =  null;
        }
    }
    
    TreeNode node;
    public BST() {
        node = null;
    }
    
    
    //transverse _______________________________________
    public void inOrder() {
        inOrderTraverse(node);
    }
    private void inOrderTraverse(TreeNode node) {
        if (node !=  null) {
            inOrderTraverse(node.leftChild);
            System.out.print(node.newEntry + " ");
            inOrderTraverse(node.rightChild);
        }
    }
    
    
    public void preOrder() {
        preOrderTraverse(node);
    }
    private void preOrderTraverse(TreeNode node) {
        if (node !=  null) {
            System.out.print(node.newEntry + " ");
            preOrderTraverse(node.leftChild);
            preOrderTraverse(node.rightChild);
        }
    }
    
    
    public void postOrder() {
        postOrderTraverse(node);
    }
    private void postOrderTraverse(TreeNode node) {
        if (node !=  null) {
            postOrderTraverse(node.leftChild);
            postOrderTraverse(node.rightChild);
            System.out.print(node.newEntry + " ");
        }
    }
    
    //insert and delete_________________________________
    public TreeNode Search(int newEntry) {
        TreeNode searchNode  =  node;                         
        while (searchNode !=  null && searchNode.newEntry!= newEntry) {
            if (newEntry < searchNode.newEntry) {                   
            	searchNode  =  searchNode.leftChild;
            } else if (newEntry > searchNode.newEntry) {           
                searchNode  =  searchNode.rightChild;
            }
        }
        return searchNode;
    }
    
    void addEntry(int newEntry) {
        if(Search(newEntry)!= null) {
            System.out.println(newEntry + " already exists, ignore");
            return;
        }
        node = addingTreeNode(node,newEntry);
    }
    
    TreeNode addingTreeNode(TreeNode node,int newEntry) {
        if (node  ==  null) {
           node  =  new TreeNode(newEntry);
            return node;
        }
        if (newEntry < node.newEntry)
            node.leftChild  =  addingTreeNode(node.leftChild, newEntry);
        else if (newEntry > node.newEntry)
            node.rightChild  =  addingTreeNode(node.rightChild, newEntry);
        return node;
    }
    void removeEntry(int newEntry) {
        if(Search(newEntry) == null) {
            System.out.println(newEntry + " doesn't exist!");
            return;
        }
        node = deletingTreeNode(node,newEntry);
    }
    TreeNode deletingTreeNode(TreeNode node,int newEntry) {
        if (node  ==  null)
            return node;
        if (newEntry < node.newEntry)
            node.leftChild  =  deletingTreeNode(node.leftChild, newEntry);
        else if (newEntry > node.newEntry)
            node.rightChild  =  deletingTreeNode(node.rightChild, newEntry);
        else {
            if (node.leftChild  ==  null)
                return node.rightChild;
            else if (node.rightChild  ==  null)
                return node.leftChild;
            node.newEntry  =  findSuccessor(node);
            node.rightChild  =  deletingTreeNode(node.rightChild, node.newEntry);
        }

        return node;
    }
    
    //Successor and Predecessor________________________
    
    public int findingSuccessor(int newEntry) {
        TreeNode no = Search(newEntry);
        return findSuccessor(no);
    }
    private int findSuccessor(TreeNode node) {
    	if(node==null) {
    		System.out.print("node doesn't contain content");
    		return 0;
    	}
    	
    	int succ;
    	node = node.rightChild; //go to the right child of parent
        succ  =  node.newEntry;
        
        while (node.leftChild !=  null) {
            succ = node.leftChild.newEntry;
            node = node.leftChild;
        }
        System.out.println(succ);
        return succ;
        }
    
    public int findPredecessor(int newEntry) {
        TreeNode no = Search(newEntry);
        return findPredecessor(no);
    }
    private int findPredecessor(TreeNode node) {
    	if(node==null) {
    		System.out.print("node doesn't containt content");
    		return 0;
    	}
    	
        node = node.leftChild;
        int pred = node.newEntry;
        while (node.rightChild !=  null) {
            pred = node.rightChild.newEntry;
            node = node.rightChild;
        }
        System.out.println(pred);
        return pred;
    }
  
}