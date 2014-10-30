package Question4_2;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution {
	public class Node{
		private Collection<Node> adjacents;
		
		public Node(){
			this.adjacents = new HashSet<Node>();
		}
		
		public Collection<Node> getAdjacents(){
			return adjacents;
		}
	}
	
	public static Boolean isRoute(Node origin, Node destiny){
	 	Queue<Node> pendingNodes = new LinkedList<Node>();
	 	Set<Node> visitedNodes = new HashSet<Node>();
	 	
	 	visitedNodes.add(origin);
	 	pendingNodes.add(origin);
	 	while(!pendingNodes.isEmpty()){
	 		Node actualNode = pendingNodes.poll();
	 		
	 		if(actualNode.equals(destiny)){
	 			return true;
	 		} else {
	 			for(Node adjacent:actualNode.getAdjacents()){
	 				if(!visitedNodes.contains(adjacent)){
	 					pendingNodes.add(adjacent);
	 					visitedNodes.add(adjacent);
	 				}
	 			}
	 		}
	 	}
	 	
	 	return false;
	 }

	public static void main(String args[]){
		Solution sol = new Solution();
		Node a = sol.new Node();
		Node b = sol.new Node();
		Node c = sol.new Node();
		Node d = sol.new Node();
		
		a.getAdjacents().add(b);
		b.getAdjacents().add(c);
		c.getAdjacents().add(d);
		d.getAdjacents().add(a);
		
		if(isRoute(a, c)){
			System.out.println("LALA");
		}
	}
}
