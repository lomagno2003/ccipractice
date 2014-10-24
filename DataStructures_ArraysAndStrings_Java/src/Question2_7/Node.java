package Question2_7;

public class Node{
 	private Object value;
 	private Node next;
 	
 	public Node(Object value, Node next){
 		this.setValue(value);
 		this.setNext(next);
 	}
 	
 	public Object getValue(){
 		return this.value;
 	}
 	
 	public void setValue(Object value){
 		this.value = value;
 	}
 	
 	public Node getNext(){
 		return this.next;
 	}
 	
 	public void setNext(Node next){
 		this.next = next; 
 	}
 }