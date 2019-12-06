
public class CS6088Aashikari {

	static int numberOfNodes(Lab8BTNode root) {
		
		if (root == null) {
			return 0;
		} else {
			return (numberOfNodes(root.right) + numberOfNodes(root.left)+ 1);
		}
		
	}
	
    // Returns the max value in a binary tree
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
		
		
	}
}