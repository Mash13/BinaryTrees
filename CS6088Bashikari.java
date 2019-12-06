import java.util.*;

public class CS6088Bashikari {

	static int numberOfNodes(Lab8BTNode root) {
		
		if (root == null) {
			return 0;
		} else {
			return (numberOfNodes(root.right) + numberOfNodes(root.left)+ 1);
		}
		
	}
	
	static int largest(Lab8BTNode node)
    {
        if (node == null)
            return Integer.MIN_VALUE;
  
        int max = node.element;
        int left = largest(node.left);
        int right = largest(node.right);
  
        if (left > max)
            max = left;
        if (right > max)
            max = right;
        return max;
    }
	
	static int sumOfElements(Lab8BTNode node) {

		if (node == null)
			return 0;
		
		return (node.element + sumOfElements(node.left) + sumOfElements(node.right));
		
		
	}
	
	static boolean searchFor(Lab8BTNode node, int val) 
    {
        boolean found = false;
        while ((node != null) && !found) 
        {
            int rval = node.element;
            if (val < rval)
                node = node.left;
            else if (val > rval)
                node = node.right;
            else 
            {
                found = true;
                break;
            }
            found = searchFor(node, val);
        }
        return found;
    }
	
	static void levelWithLargestNumberOfNodes(Lab8BTNode root, int height)
	{
	    int[] levelCounters = new int[height];
	    updateCounters(root, 0, levelCounters, height);
	    int levelWithMaxNodes = findMaxIndex(levelCounters);
	    System.out.println("The level with the largest number of nodes is: " + levelWithMaxNodes);
	}

	private static void updateCounters(Lab8BTNode root, int currentLevel, int[] levelCounters, int height){
	    if(root!=null && currentLevel < height){
	        levelCounters[currentLevel]++;
	        updateCounters(root.left, currentLevel+1, levelCounters, height);
	        updateCounters(root.right, currentLevel+1, levelCounters, height);
	    }
	}

	private static int findMaxIndex(int[] levelCounters) {
	    int maxIndex = -1;
	    int maxNodes = -1;
	    for(int i = 0; i<levelCounters.length; ++i){
	        if(levelCounters[i]>maxNodes){
	            maxNodes = levelCounters[i];
	            maxIndex = i;
	        }
	    }
	    return maxIndex;
	}
	
	public static void main(String[] args) throws Exception {
	
		//create an instance of Lab5BTMethods... did he mean BTMethods??
		Lab8BTMethods instance = new Lab8BTMethods();
		
		//Generate a binary tree (use the method createBinaryTree())
		instance.createBinaryTree();
		
		//traverse the in preorder
		System.out.println("Binary tree traversed in preorder: ");
		instance.preOrder(instance.root);
		
		//print the height of the tree
		System.out.println("\nHeight of the tree = " + instance.height(instance.root));
		//print the level order of the tree
		System.out.println("Binary tree displayed in level order: ");
		instance.displayTree(instance.root);
		
		//print the number of nodes in the tree
		System.out.println("\nThe number of nodes in the binary tree = " 
				+ numberOfNodes(instance.root));
		
		//print the largest element in the tree
		
		int max = largest(instance.root);
		System.out.println("The largest number in the tree is " + max);
		
		//print the sum of all of the elements in the tree
		
		int sum = 0;
		sum = sumOfElements(instance.root);
		System.out.println("The sum of all elements in the tree is: " + sum);
		
		//print the results of searchFor(). This method searches for the number n
		System.out.println("What number would you like to search the binary tree for?");
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		
		if (searchFor(instance.root, n) == true) {
			
			System.out.println("The node with value " + n + " exists!");
			
		} else {
			
			System.out.println("The node with value " + n + " does not exist!");
			
		}
		
		//print the level with the largest number of nodes
	
		levelWithLargestNumberOfNodes(instance.root, instance.height(instance.root));
		
		scan.close();
	}
}
