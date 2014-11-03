package Question4_5;

public class Solution {
	 private Integer lastValue;
	 
	 public Boolean isBinarySearchTree(Node root){
	 	lastValue = null;
	 	
	 	return dfs(root);
	 }
	 
	 /* O(N) time, and O(N) space */
	 private Boolean dfs(Node root){
	 	if(root!=null){
	 		if(dfs(root.left)){
	 			if(lastValue==null){
	 				/* The first element */
	 				lastValue = root.value;
	 				
	 				return true;
	 			} else {
		 			if(root.value>lastValue){
		 				lastValue = root.value;
		 				
		 				return dfs(root.right);
		 			} else {
		 				/* The tree is not ordered */
		 				return false;
		 			}
		 		}
	 		} else {
	 			return false;
	 		}
	 	} else {
	 		/* A empty tree could be a empty search tree */
	 		return true;
	 	}
	 }
	 
	 public static void main(String [] args){
		 Node root = new Node(4);
		 root.left = new Node(2);
		 root.left.left = new Node(1);
		 root.left.right = new Node(3);
		 root.right = new Node(6);
		 root.right.left = new Node(5);
		 root.right.right = new Node(7);
		 
		 Boolean result = new Solution().isBinarySearchTree(root);
		 
		 if(result) {
			 System.out.println("Is binary search tree");
		 } else {
			 System.out.println("Isn't binary search tree");
		 }
	 }
	 
}
