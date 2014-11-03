package Question4_6;

public class Solution {
	public static Node nextElement(Node node){
	 	if(node!=null){
		 	Integer actualValue = node.value;
		 	
		 	
		 	/* The next is the lowest element of the right tree */
		 	if(node.right!=null){
		 		Node ptr = node.right;
		 		
		 		while(ptr.left!=null){
		 			ptr = ptr.left;
		 		}
		 		
		 		return ptr;
		 	} else {
			 	Node ptr = node.parent;
			 	
		 		/* The next is the first parent which is higher than the node */
			 	while(ptr!=null && ptr.value<actualValue){
			 		ptr = ptr.parent;
			 	}
			 	
			 	if(ptr == null) {
			 		/* node is the highest element of the tree */
			 		return null;
			 	} else {
			 		return ptr;
			 	}
		 	}
		 } else {
		 	return null;
		 }
	 }
	 
	 public static void main(String [] args){
		 Node root = new Node(4);
		 root.left = new Node(2);
		 root.left.parent = root;
		 
		 root.left.left = new Node(1);
		 root.left.left.parent = root.left;
		 root.left.right = new Node(3);
		 root.left.right.parent = root.left;
		 
		 root.right = new Node(6);
		 root.right.parent = root;
		 root.right.left = new Node(5);
		 root.right.left.parent = root.right;
		 root.right.right = new Node(7);
		 root.right.right.parent = root.right;
		 
		 Node result = nextElement(root.left.right);
		 
		 System.out.println(result.value);
	 }
	 
}
