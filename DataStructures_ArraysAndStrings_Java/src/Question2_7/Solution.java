package Question2_7;

import Question2_3.Node;

public class Solution {
	/*
	 * If the list is double linked list, the solution is trivial.
	 * If not, we can use the recursion to go to the end of the list, 
	 * and then return back. This solution will have O(n) in processing, and
	 * O(n) in space.
	 *
	 * Another more complicated solution is to, first find the middle of the list
	 * (taking in count if the list size is a pair size, or not). Then invert the 
	 * links before the middle. And finally, iterate the list from the start and the end
	 * making the comparision.
	 */
	 
	 private static Node invertLinks(Node root){
	 	if(root!=null){
		 	Node lastPointer = root;
		 	Node actualPointer = root.getNext();
		 	Node nextPointer;
		 	
		 	while(actualPointer!=null){
		 		nextPointer = actualPointer.getNext();
		 		actualPointer.setNext(lastPointer);
		 		
		 		lastPointer = actualPointer;
		 		actualPointer = nextPointer;
		 	}
		 	
		 	/* The first node is gonna be the last of the list */
	 		root.setNext(null);
	 		
	 		return lastPointer;
		 } else {
		 	return null;
		 }
	 }
	 
	 private static Boolean checkPrefix(Node rootA, Node rootB){
	 	Node ptrA = rootA;
	 	Node ptrB = rootB;
	 	
	 	while(ptrA!=null&&ptrB!=null){
	 		if(!ptrA.getValue().equals(ptrB.getValue())){
	 			return false;
	 		}
	 		ptrA = ptrA.getNext();
	 		ptrB = ptrB.getNext();
	 	}
	 	
	 	return true;
	 }
	 
	 public static Boolean isPalindrome(Node rootList){
	 	if(rootList!=null){
		 	Node ptr1=rootList;
		 	Node ptr2=rootList;
		 	
		 	/* Find the middle*/
		 	while(ptr2!=null&&ptr2.getNext()!=null){
		 		ptr1 = ptr1.getNext();
		 		ptr2 = ptr2.getNext().getNext();
		 	}
		 	
		 	if(ptr2==null){
		 		/* The size is pair and ptr1 is in the begining of the second part */
		 	} else {
			 	if(ptr2.getNext()==null){
			 		/* The size is not pair and ptr1 is in the middle element.
			 		 * So, we advance the ptr1 one time to put it in the begining
			 		 * of the second part 
			 		 */
			 		 ptr1 = ptr1.getNext();
			 	}
		 	}
		 	
		 	/* Invert the second part */
		 	Node invertedSecondPart = invertLinks(ptr1);

		 	/* Check if the invertedSecondPart is the same as the first part */
		 	Boolean result = checkPrefix(rootList,invertedSecondPart);
		 	
		 	/* Restore the list */
		 	invertLinks(invertedSecondPart);
		 	
		 	return result;
	 	} else {
	 		/*The list is empty, so we can consider that it is a palindrome*/
	 		return true;
	 	}
	 }
	 
	 public static void main(String[] args) {
			Node root = new Node(1,null);
			root = new Node(2,root);
			root = new Node(3,root);
			root = new Node(2,root);
			root = new Node(1,root);
			
			for(Node it = root;it!=null;it=it.getNext()){
				System.out.println(it.getValue());
			}
			
			if(isPalindrome(root)){
				System.out.println("Is palindrome");
			} else {
				System.out.println("Is not palindrome");
			}
			
			for(Node it = root;it!=null;it=it.getNext()){
				System.out.println(it.getValue());
			}
		}
}
