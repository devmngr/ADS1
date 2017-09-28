package binarySearchTree;

import java.util.ArrayList;
import java.util.Iterator;

public class binarySearchTree implements BinarySearchTreeADT {

	BinaryTreeNode<Integer> root;

	public binarySearchTree() {
		root = null;
	}

	public binarySearchTree(BinaryTreeNode<Integer> root) {
		this.root = root;
	}

	@Override
	public BinaryTreeNode<Integer> getRoot() {
		return root;
	}

	@Override
	public boolean isEmpty() {
		return root == null;
	}

	@Override
	public int size() {
		return size(root);
	}

	@Override
	public boolean contains(int element) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		inOrderTraverse(arr, root);

		return arr.contains(element);
	}

	@Override
	public int height(BinaryTreeNode<Integer> node) {

		if (node == null)
			return 0;
		int leftHeight = height(node.getLeftNode());
		int rightHeight = height(node.getRightNode());

		if (leftHeight > rightHeight)
			return leftHeight + 1;
		else
			return rightHeight + 1;
	}

	@Override
	public Iterator<Integer> iteratorInOrder() {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		inOrderTraverse(arr, root);
		return arr.iterator();
	}

	@Override
	public Iterator<Integer> iteratorPreOrder() {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		preOrderTraverse(arr, root);
		return arr.iterator();
	}

	@Override
	public Iterator<Integer> iteratorPostOrder() {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		postOrderTraverse(arr, root);
		return arr.iterator();
	}

	@Override
	public Iterator<Integer> iteratorLevelOrder() {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		levelOrderTraverse(arr, root);
		return arr.iterator();
	}

	@Override
	public void addElement(int element) {
		if (root == null) {
			root = new BinaryTreeNode<Integer>(element);
		} else
			addElement(root, element);
	}

	@Override
	public void removeElement(int element) {
		if (root == null)
			throw new NullPointerException("Root is null");
		else if (root.getElement() == element && root.isLeaf())
			root = null;
		else if (root.getElement() == element && root.getLeftNode() == null
				&& root.getRightNode().isLeaf())
			root = root.getRightNode();
		else if (root.getElement() == element && root.getRightNode() == null
				&& root.getLeftNode().isLeaf())
			root = root.getLeftNode();
		else if (root.getElement() == element && root.getLeftNode() == null
				&& !root.getRightNode().isLeaf()) {
			BinaryTreeNode<Integer> temp = new BinaryTreeNode<Integer>(
					findMin(root.getRightNode()));
			removeElement(root, temp.getElement());
			temp.setLeftNode(root.getLeftNode());
			temp.setRightNode(root.getRightNode());
			root = temp;
		} else if (root.getElement() == element && !root.getLeftNode().isLeaf()
				&& root.getRightNode() == null) {
			BinaryTreeNode<Integer> temp = new BinaryTreeNode<Integer>(
					findMax(root.getLeftNode()));
			removeElement(root, temp.getElement());
			temp.setLeftNode(root.getLeftNode());
			temp.setRightNode(root.getRightNode());
			root = temp;

		} else if (root.getElement() == element && root.getLeftNode().isLeaf()
				&& root.getRightNode().isLeaf()) {
			BinaryTreeNode<Integer> temp = root.getRightNode();
			root = root.getLeftNode();
			root.setRightNode(temp);
		}

		else
			removeElement(root, element);

	}

	@Override
	public void removeAllOccurrences(int element) {
		removeElement(element);
		while (contains(element))
			removeElement(element);
	}

	@Override
	public void removeMin() {
		removeElement(findMin(root));
	}

	@Override
	public void removeMax() {
		removeElement(findMax(root));

	}

	private int size(BinaryTreeNode<Integer> node) {
		if (node == null)
			return 0;
		else
			return (size(node.getLeftNode()) + 1 + size(node.getRightNode()));
	}

	private void addElement(BinaryTreeNode<Integer> node, int elementToAdd) {
		// ///IT IS NOT ADDING ON THE RIGHT SIDE
		int currentElement = node.getElement();

		if (elementToAdd < currentElement) {
			if (node.getLeftNode() == null)
				node.setLeftNode(new BinaryTreeNode<Integer>(elementToAdd));
			else
				addElement(node.getLeftNode(), elementToAdd);
		}

		else if (elementToAdd >= currentElement) {

			if (node.getRightNode() == null)
				node.setRightNode(new BinaryTreeNode<Integer>(elementToAdd));
			else

				addElement(node.getRightNode(), elementToAdd);
		}
	}

	private BinaryTreeNode<Integer> removeElement(BinaryTreeNode<Integer> node,
			int element) {
		// Base Case: If the tree is empty //
		if (node == null)
			return node;
		// Otherwise, recur down the tree //

		else if (element < node.getElement())
			node.setLeftNode(removeElement(node.getLeftNode(), element));
		else if (element > node.getElement())
			node.setRightNode(removeElement(node.getRightNode(), element));

		// if key is same as root's key, then This is the node
		// to be deleted
		else {
			// node with only one child or no child
			if (node.getLeftNode() == null)
				return node.getRightNode();
			if (node.getRightNode() == null)
				return node.getLeftNode();

			else {
				// node with two children: the biggest element in the left
				// subtree
				node.setElement(findMax(node.getLeftNode()));
				node.setLeftNode(removeElement(node.getLeftNode(),
						node.getElement()));

				// node with two children: the smallest element in the right
				// subtree
				// node.setElement(findMin(node.getRightNode()));
				// node.setRightNode(removeElement(node.getRightNode(),node.getElement()));
			}
		}
		return node;
	}

	private int findMin(BinaryTreeNode<Integer> node) {
		int min = node.getElement();
		while (node.getLeftNode() != null) {
			min = node.getLeftNode().getElement();
			node = node.getLeftNode();
		}
		return min;
	}

	private int findMax(BinaryTreeNode<Integer> node) {
		int max = node.getElement();
		while (node.getRightNode() != null) {
			max = node.getRightNode().getElement();
			node = node.getRightNode();
		}
		return max;
	}

	private void inOrderTraverse(ArrayList<Integer> arr,
			BinaryTreeNode<Integer> node) {

		if (node != null) {
			inOrderTraverse(arr, node.getLeftNode());
			arr.add(node.getElement());
			inOrderTraverse(arr, node.getRightNode());
		}
	}

	private void preOrderTraverse(ArrayList<Integer> arr,
			BinaryTreeNode<Integer> node) {
		if (node != null) {
			arr.add(node.getElement());

			preOrderTraverse(arr, node.getLeftNode());
			preOrderTraverse(arr, node.getRightNode());
		}
	}

	private void postOrderTraverse(ArrayList<Integer> arr,
			BinaryTreeNode<Integer> node) {

		if (node != null) {
			postOrderTraverse(arr, node.getLeftNode());
			postOrderTraverse(arr, node.getRightNode());
			arr.add(node.getElement());
		}
	}

	private void levelOrderTraverse(ArrayList<Integer> arr,
			BinaryTreeNode<Integer> node) {

		QueueADT<BinaryTreeNode<Integer>> queue = new ArrayQueue<BinaryTreeNode<Integer>>(
				true);
		queue.enqueue(node);

		while (!queue.isEmpty()) {
			BinaryTreeNode<Integer> temp = queue.dequeue();
			arr.add(temp.getElement());
			if (temp.getLeftNode() != null)
				queue.enqueue(temp.getLeftNode());
			if (temp.getRightNode() != null)
				queue.enqueue(temp.getRightNode());
		}
	}

	public void printTree() {
		ArrayList<BinaryTreeNode<Integer>> parent = new ArrayList<BinaryTreeNode<Integer>>();
		parent.add(root);
		printT(parent, 64);
	}

	private void printT(ArrayList<BinaryTreeNode<Integer>> parent, int left) {
		ArrayList<BinaryTreeNode<Integer>> children = new ArrayList<BinaryTreeNode<Integer>>();
		BinaryTreeNode<Integer> current;
		boolean moreNodes = false;
		boolean firstNode = true;
		BinaryTreeNode<Integer> dummy = new BinaryTreeNode<Integer>(0);

		int dist = 0;
		System.out.println();
		System.out.println();

		while (!parent.isEmpty()) {
			current = parent.remove(0);
			if (current == null) {
				System.out.println("The Tree is empty !!!");
				return;
			}
			if (firstNode) {
				printSpace(left);
				if (current.getElement() != 0)
					System.out.print(current.getElement());
				dist = 2 * left;
				firstNode = false;

				if (current.getElement() != 0) {
					if (current.getLeftNode() != null) {
						children.add(current.getLeftNode());
						moreNodes = true;
					} else
						children.add(dummy);
					if (current.getRightNode() != null) {
						children.add(current.getRightNode());
						moreNodes = true;
					} else
						children.add(dummy);
				} else {
					children.add(dummy);
					children.add(dummy);
				}
			} else {
				if (current.getElement() != 0) {
					printSpace(dist - 1);
					System.out.print(current.getElement());
					if (current.getLeftNode() != null) {
						children.add(current.getLeftNode());
						moreNodes = true;
					} else
						children.add(dummy);
					if (current.getRightNode() != null) {
						children.add(current.getRightNode());
						moreNodes = true;
					} else
						children.add(dummy);
				} else {
					printSpace(dist - 1);
					System.out.print(" ");
					children.add(dummy);
					children.add(dummy);
				}
			}
		}

		if (moreNodes)
			printT(children, left / 2);

	}

	private void printSpace(int pos) {
		for (int i = 0; i < pos; i++)
			System.out.print(" ");

	}

	public static void main(String[] args) {

		binarySearchTree tree = new binarySearchTree();

		tree.addElement(20);
		tree.addElement(40);
		tree.addElement(10);
		tree.addElement(15);
		tree.addElement(3);
		tree.addElement(2);
		tree.addElement(4);
		tree.addElement(8);
		tree.addElement(7);
		tree.addElement(6);

		
		 tree.removeElement(10); 
		 tree.removeElement(15);
		 tree.removeElement(3); 
		 tree.removeElement(4); 
		 tree.removeElement(20);
		// tree.removeElement(8); 
		 //tree.removeElement(7); 
		// tree.removeElement(6);
		// tree.removeElement(40); 
	//	 tree.removeElement(2);
		
tree.removeMin();
tree.removeMax();
/*
		 * tree.removeElement(10); tree.removeElement(15);
		 * tree.removeElement(3); tree.removeElement(4); tree.removeElement(20);
		 * tree.removeElement(8); tree.removeElement(7); tree.removeElement(6);
		 * tree.removeElement(40); tree.removeElement(2);
		 * tree.removeElement(20);
		 */

		/*
		 * tree.addElement(1); tree.addElement(2); tree.addElement(3);
		 * tree.addElement(4); // tree.addElement(5); tree.removeElement(1); //
		 * tree.removeElement(-2); // tree.removeElement(-3); //
		 * tree.removeElement(-4);
		 */
		tree.printTree();
	}
}
