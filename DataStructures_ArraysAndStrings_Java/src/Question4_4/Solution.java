package Question4_4;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Solution {
	
	
	public static void addToList(Node node, Map<Integer, LinkedList<Node>> lists, Integer level){
	 	if(node != null){
	 		addToList(node.left, lists, level + 1);
	 		addToList(node.right, lists, level + 1);
	 		
	 		if(!lists.containsKey(level)){
	 			lists.put(level, new LinkedList<Node>());
	 		}
	 		
	 		lists.get(level).add(node);
	 	}
	 }
	 
	 public static Map<Integer, LinkedList<Node>> generateLists(Node root){
	 	Map<Integer, LinkedList<Node>> result = new HashMap<Integer, LinkedList<Node>>();
	 	
	 	addToList(root, result, 0);
	 	
	 	return result;
	 }
	 
	 public static void main(String [] args){
		 Node root = new Node(0);
		 root.left = new Node(2);
		 root.left.left = new Node(1);
		 root.left.right = new Node(3);
		 root.right = new Node(5);
		 root.right.left = new Node(4);
		 root.right.right = new Node(6);
		 
		 Map<Integer, LinkedList<Node>> result = generateLists(root);
		 
		 for(Integer key : result.keySet()){
			 System.out.println("Level: " + key);
			 for(Node node : result.get(key)){
				 System.out.println(node.value);
			 }
		 }
	 }
	 
}
