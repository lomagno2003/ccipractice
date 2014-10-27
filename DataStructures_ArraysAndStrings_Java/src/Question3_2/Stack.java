package Question3_2;

public class Stack {
 	private class StackElement{
 		private Integer actualMin;
 		private Integer value;
 		private StackElement nextElement;
 		
 		public StackElement(Integer value, Integer actualMin, StackElement nextElement){
 			this.actualMin = actualMin;
 			this.value = value;
 			this.nextElement = nextElement;
 		}
 		
 		public Integer getActualMin(){
 			return this.actualMin;
 		}
 		
 		public Integer getValue(){
 			return this.value;
 		}
 		
 		public StackElement getNextElement(){
 			return this.nextElement;
 		}
 	}
 	
 	private StackElement headElement;
 	
 	public Stack(){
 		this.headElement = null;
 	}
 	
 	public Integer pop(){
 		if(this.headElement!=null){
	 		Integer result = this.headElement.getValue();
	 		this.headElement = headElement.getNextElement();
	 		return result;
	 	} else {
	 		return null;
	 	}
 	}
 	
 	public void push(Integer element){
 		Integer actualMin=this.getMin();
 		if(actualMin==null || element < actualMin){
 			actualMin = element;
 		}
 		
 		this.headElement = new StackElement(element,actualMin,this.headElement);
 	}
 	
 	public Integer getMin(){
 		if(this.headElement!=null){
 			return this.headElement.getActualMin();
 		} else {
 			return null;
 		}
 	}
 	
	public static void main(String[] args) {
		Stack stack = new Stack();
		
		stack.push(5);
		stack.push(10);
		stack.push(20);
		stack.push(4);
		stack.push(13);
		
		System.out.println("Min: " + stack.getMin());
		System.out.println("Pop: " + stack.pop());
		
		System.out.println("Min: " + stack.getMin());
		System.out.println("Pop: " + stack.pop());
		
		System.out.println("Min: " + stack.getMin());
		System.out.println("Pop: " + stack.pop());
		
		System.out.println("Min: " + stack.getMin());
		System.out.println("Pop: " + stack.pop());
		
		System.out.println("Min: " + stack.getMin());
		System.out.println("Pop: " + stack.pop());
		

	}

}
