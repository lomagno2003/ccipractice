package Question4_3;

public class Solution {
	public class Node {
		public Node left = null;
		public Node right = null;
		public Integer value = null;

		public Node(Integer value) {
			this.value = value;
		}
	}

	public Node generateNode(Integer array[], Integer offset, Integer lenght) {
		System.out.println("Generating (" + offset + ", " + lenght + ")");
		if (lenght > 0) {
			if (lenght == 1) {
				return new Node(array[offset]);
			} else {
				Integer middle = lenght / 2;

				Node result = new Node(array[offset + middle]);

				result.left = generateNode(array, offset, middle);
				result.right = generateNode(array, offset + middle + 1, lenght - (middle + 1));

				return result;
			}
		} else {
			return null;
		}
	}
	
	public void printTree(Node tree){
		if(tree.left!=null){
			printTree(tree.left);
		}

		System.out.print(tree.value);
		
		if(tree.right!=null){
			printTree(tree.right);
		}
	}
	
	public static void main(String args[]){
		Integer array[]={1,2,3,4,5,6,7,8,9,10};
		
		Solution solution = new Solution();
		solution.printTree(solution.generateNode(array, 0, array.length));
	}
}
