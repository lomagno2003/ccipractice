package Question4_9;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import Question4_7.Node;

public class Solution {
	public static class Path {
		private List<Integer> nodes;

		private Integer sum;

		public Path() {
			nodes = new LinkedList<Integer>();
			sum = 0;
		}

		public Path(Integer value) {
			nodes = new LinkedList<Integer>();
			nodes.add(value);
			sum = value;
		}

		public void addNode(Integer value) {
			sum += value;
			nodes.add(value);
		}

		public void removeLastNode() {
			sum -= getNodes().get(getNodes().size() - 1);
			nodes.remove(getNodes().size() - 1);
		}

		/* Getters and setters */

		public Path clone() {
			Path result = new Path();

			for (Integer node : this.getNodes()) {
				result.addNode(node);
			}

			return result;
		}

		public List<Integer> getNodes() {
			return nodes;
		}

		public void setNodes(List<Integer> nodes) {
			this.nodes = nodes;
		}

		public Integer getSum() {
			return sum;
		}

		public void setSum(Integer sum) {
			this.sum = sum;
		}
	}

	public static void printPath(Path path) {
		for (Integer node : path.getNodes()) {
			System.out.print(node + ", ");
		}

		System.out.println();
	}

	public static void printPaths2(Node tree, Collection<Path> paths, Integer sum) {
		if (tree != null) {
			/* Generate paths */
			Collection<Path> newPaths = new HashSet<Path>();

			if (paths != null) {
				for (Path path : paths) {
					Path newPath = path.clone();
					newPath.addNode(tree.value);
					newPaths.add(newPath);
				}
			}

			newPaths.add(new Path(tree.value));

			/* Test */
			for (Path path : newPaths) {
				if (path.getSum().equals(sum)) {
					printPath(path);
				}
			}

			/* Recurse */
			printPaths2(tree.left, newPaths, sum);
			printPaths2(tree.right, newPaths, sum);
		}
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

		printPaths2(root, null, 6);
	}
}
