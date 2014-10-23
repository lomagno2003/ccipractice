package Question2_4;

import Question2_3.Node;

public class Solution {
	public static Node solution(Node root, Integer value) {
		if (root != null) {
			Node rootHigherValues = null;
			Node rootLowerValues = null;
			Node lastLowerNode = null;

			Node it = root;

			while (it != null) {
				Node nextIt = it.getNext();

				if (((Integer) it.getValue()) >= value) {
					/* Add it to the higherValuesList */
					it.setNext(rootHigherValues);
					rootHigherValues = it;
				} else {
					/*
					 * I save a reference to the first node that i add to the
					 * lowerValuesList
					 */
					if (lastLowerNode == null) {
						lastLowerNode = it;
					}

					it.setNext(rootLowerValues);
					rootLowerValues = it;
				}

				it = nextIt;
			}

			lastLowerNode.setNext(rootHigherValues);

			return rootLowerValues;
		}

		return null;
	}

	public static void main(String[] args) {
		Node root = new Node(17,null);
		root = new Node(50,root);
		root = new Node(12,root);
		root = new Node(98,root);
		root = new Node(15,root);
		root = new Node(32,root);
		
		for(Node it = root;it!=null;it=it.getNext()){
			System.out.println(it.getValue());
		}
		
		root = solution(root,20);
		
		System.out.println("After reorder:");
		
		for(Node it = root;it!=null;it=it.getNext()){
			System.out.println(it.getValue());
		}
	}

}
