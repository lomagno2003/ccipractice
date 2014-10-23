package Question2_3;

public class Solution { 
	 public static void removeElement(Node element){
	 	if(element!=null){
	 		if(element.getNext()!=null){
			 	/* Overwrite the value */
			 	element.setValue(element.getNext().getValue());
			 } else {
			 	/* The next element is the last of the list, so here 
			 	 * i have to throw an exception or something, because
			 	 * is imposible to update the previous element */
			 	 //TODO Throw exception
			 }
		 	
		 	/* Delete the duplicated element */
		 	element.setNext(element.getNext().getNext());
		 } else {
		 	//TODO Throw exception?
		 }
	 }
	 
	public static void main(String[] args) {
		Node root = new Node(5,null);
		root = new Node(4,root);
		root = new Node(3,root);
		root = new Node(2,root);
		Node element = root;
		root = new Node(1,root);
		root = new Node(0,root);
		
		for(Node it = root;it!=null;it=it.getNext()){
			System.out.println(it.getValue());
		}
		removeElement(element);
		
		System.out.println("After delete:");
		
		for(Node it = root;it!=null;it=it.getNext()){
			System.out.println(it.getValue());
		}
	}

}
