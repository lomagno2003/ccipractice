package Question4_7;

import java.util.HashSet;
import java.util.Set;

public class Solution {
	public static Node firstAncestor(Node a, Node b){
	 	/* We can check if a||b are null, just for better performance */
	 	if(a==null||b==null){
	 		return null;
	 	}
	 	Set<Node> visitedNodes = new HashSet<Node>();
	 	
	 	Node ptr = a;
	 	
	 	while(ptr!=null){
	 		visitedNodes.add(ptr);
	 		
	 		ptr = ptr.parent;
	 	}
	 	
	 	ptr = b;
	 	
	 	while(ptr!=null){
	 		if(visitedNodes.contains(ptr)){
	 			return ptr;
	 		}
	 		
	 		ptr = ptr.parent;
	 	}
	 	
	 	/* The 2 nodes don't belong to the same tree */
	 	return null;
	 }
	
	public static class Wrapper {
	  	public Boolean aFound = false;
	  	public Boolean bFound = false;
	  	public Node result = null;
	  }
	  
	  private static void dfs(Node node, Node a, Node b, Wrapper wrapper){
	  	if(node!=null){
	  		if(wrapper.result==null)
	  			dfs(node.left, a, b, wrapper);
	  			
	  		if(wrapper.result==null)
	  			dfs(node.right, a, b, wrapper);
	  		
	  		if(wrapper.result==null)
		  		if(wrapper.aFound&&wrapper.bFound){
	  				wrapper.result = node;
	  			}
	  		
	  		if(wrapper.result==null){
	  			if(node.equals(a)){
	  				wrapper.aFound = true;
	  			}
	  			
	  			if(node.equals(b)){
	  				wrapper.bFound = true;
	  			}
	  		}
	  	}
	  }
	  
	  public static Node firstAncestor2(Node root, Node a, Node b){
	  	Wrapper wrapper = new Wrapper();
	  	
	  	dfs(root, a, b, wrapper);
	  	
	  	return wrapper.result;
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
		 
		 Node result = firstAncestor2(root, root.left.right, root.left.left);
		 
		 System.out.println(result.value);
	 }
	 
}
