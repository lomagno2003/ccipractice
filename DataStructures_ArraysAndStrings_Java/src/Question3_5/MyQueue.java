package Question3_5;

import java.util.Stack;

public class MyQueue {
	private Stack<Integer> firstStack;
	
	private Stack<Integer> secondStack;
	
	public MyQueue(){
		this.firstStack = new Stack<Integer>();
		this.secondStack = new Stack<Integer>();
	}
	
	public void push(Integer element){
		this.firstStack.push(element);
	}
	
	public Integer pop(){
		if(this.secondStack.isEmpty()){
			if(this.firstStack.isEmpty()){
				/* The queue is empty */
				return null;
			} else {
				/* We pop all the elements from the first stack, and push them 
				 * to the second stack */
				 while(!this.firstStack.isEmpty()){
				 	this.secondStack.push(this.firstStack.pop());
				 }
			}
		}
		
		return this.secondStack.pop();
	}
	
	public static void main(String[] args){
		MyQueue queue = new MyQueue();
		
		queue.push(1);
		queue.push(2);
		queue.push(3);
		System.out.println(queue.pop());
		System.out.println(queue.pop());
		System.out.println(queue.pop());
		System.out.println(queue.pop());
		queue.push(4);
		queue.push(5);
		queue.push(6);
		System.out.println(queue.pop());
		System.out.println(queue.pop());
		
	}
}
