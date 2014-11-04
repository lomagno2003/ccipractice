package Question4_8;

import Question4_7.Node;

public class Solution {
	public static Long getHashValue(Node tree, Long hashValue) {
		if (tree != null) {
			Long result = getHashValue(tree.left, hashValue);
			result += tree.value.hashCode();
			result += getHashValue(tree.right, hashValue);

			if (hashValue != null && hashValue.equals(result)) {
				found = true;
			}

			return result;
		} else {
			return 0L;
		}
	}

	private static Boolean found;

	public static Boolean isSubtree(Node treeA, Node treeB) {
		Long hashValue = getHashValue(treeA, null);

		found = false;

		/* Look for subtree */
		getHashValue(treeB, hashValue);

		return found;
	}

	public static void main(String[] args) {
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
		
		Node root2 = new Node(6);
		root2.left = new Node(5);
		root2.right = new Node(8);
		
		if(isSubtree(root2, root)){
			System.out.println("Is subtree");
		} else {
			System.out.println("Is not subtree");
		}
	}

}
