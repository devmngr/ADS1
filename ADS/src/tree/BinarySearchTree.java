package tree;

import java.util.ArrayList;
import java.util.Iterator;
////xyu
public class BinarySearchTree implements BinarySearchTreeADT {
	private BinaryTreeNode<Integer> root;
	private int count;
///ghghghghggs
	public BinarySearchTree() {
		root = null;
		count = 0;
	}

	public BinarySearchTree(BinaryTreeNode<Integer> root) {
		this.root = root;
		count = 1;
	}

	@Override
	public BinaryTreeNode getRoot() {
		return root;
	}

	@Override
	public boolean isEmpty() {
		return root == null;
	}

	@Override
	public int size() {
		return count;
	}

	@Override
	public boolean contains(int element) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int find(int element) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Iterator<Integer> iteratorInOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<Integer> iteratorPreOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<Integer> iteratorPostOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<Integer> iteratorLevelOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void printTree(BinaryTreeNode[] list) {

	}

	@Override
	public void addElement(int element) {
		if (root == null) {
			root = new BinaryTreeNode<Integer>(element);
		} else
			newNode(root, element);
	}

	@Override
	public int removeElement(int element) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void removeAllOccurances(int element) {
		// TODO Auto-generated method stub

	}

	@Override
	public int removeMin() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int removeMax() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int findMin() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int findMax() {
		// TODO Auto-generated method stub
		return 0;
	}

	private void newNode(BinaryTreeNode<Integer> node, int elementToAdd) {
	
		int currentElement = node.getElement();
	
		if (elementToAdd < currentElement) {
			if (node.getLeftNode() == null)
				node.addLeftChild(new BinaryTreeNode<Integer>(elementToAdd));
			else
				newNode(node.getLeftNode(), elementToAdd);
		}
	
		else if (elementToAdd >= currentElement) {
	
			if (node.getRightNode() == null)
				node.addRightChild(new BinaryTreeNode<Integer>(elementToAdd));
			else
	
				newNode(node.getRightNode(), elementToAdd);
		}
	}

	public void printTree2(BinaryTreeNode[] list) {
		int count = 0;
		int idx = 0;
		int size = list.length * 2;
		BinaryTreeNode<Integer>[] temp = new BinaryTreeNode[size];

		System.out.print("-");

		for (int i = 0; i < list.length; i++) {
			System.out.print("\t" + list[i].getElement() + "\t");

			if (list[i].getLeftNode() != null)
				temp[idx] = (list[i].getLeftNode());
			else {
				temp[idx] = new BinaryTreeNode<Integer>();
				count++;
			}
			idx++;
			if (list[i].getRightNode() != null)
				temp[idx] = (list[i].getRightNode());
			else {
				temp[idx] = new BinaryTreeNode<>();
				count++;
			}
			idx++;
		}
		if (count == size) {
			System.out.println("\nDone");
			return;
		}
		System.out.println();
		printTree(temp);

	}
	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		tree.addElement(10);
		tree.addElement(5);
		tree.addElement(30);
		tree.addElement(3);
		tree.addElement(4);
		
		BinaryTreeNode<Integer> a = tree.getRoot();
		BinaryTreeNode[] lsit = { a };
		
		System.out.println("\t" + a.getElement());
		System.out.println("\t" +a.getLeftNode().getElement() + " ---- " + a.getRightNode().getElement());
		System.out.print(a.getLeftNode().getLeftNode().getElement()+"--");
		System.out.println(a.getLeftNode().getRightNode().getElement());

		
		

	}

}
