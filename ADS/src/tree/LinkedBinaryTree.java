package tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Queue;

import collection.ArrayQueue;
import collection.QueueADT;

public class LinkedBinaryTree implements LinkedBinaryTreeADT {

	private BinaryTreeNode<Integer> root;

	public LinkedBinaryTree() {

		root = null;
	}

	public LinkedBinaryTree(int element) {

		root = new BinaryTreeNode<Integer>(element);
	}

	public LinkedBinaryTree(BinaryTreeNode<Integer> element) {

		root = element;
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
		return size(root);
	}

	private int size(BinaryTreeNode<Integer> node) {
		if (node == null)
			return 0;
		else
			return (size(node.getLeftNode()) + 1 + size(node.getRightNode()));
	}

	@Override
	public boolean contains(int element) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		inOrderTraverse(arr, root);

		return arr.contains(element);
	}

	@Override
	public int find(int element) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		inOrderTraverse(arr, root);
		return arr.indexOf(element);
	}

	@Override
	public Iterator iteratorInOrder() {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		inOrderTraverse(arr, root);
		return arr.iterator();
	}

	private void inOrderTraverse(ArrayList<Integer> arr,
			BinaryTreeNode<Integer> node) {

		if (node != null) {
			inOrderTraverse(arr, node.getLeftNode());
			arr.add(node.getElement());
			inOrderTraverse(arr, node.getRightNode());
		}
	}

	@Override
	public Iterator iteratorPreOrder() {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		preOrderTraverse(arr, root);
		return arr.iterator();
	}

	private void preOrderTraverse(ArrayList<Integer> arr,
			BinaryTreeNode<Integer> node) {
		if (node != null) {
			arr.add(node.getElement());

			preOrderTraverse(arr, node.getLeftNode());
			preOrderTraverse(arr, node.getRightNode());
		}
	}

	@Override
	public Iterator iteratorPostOrder() {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		postOrderTraverse(arr, root);
		return arr.iterator();
	}

	private void postOrderTraverse(ArrayList<Integer> arr,
			BinaryTreeNode<Integer> node) {

		if (node != null) {
			postOrderTraverse(arr, node.getLeftNode());
			postOrderTraverse(arr, node.getRightNode());
			arr.add(node.getElement());
		}
	}

	@Override
	public Iterator iteratorLevelOrder() {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		levelOrderTraverse(arr, root);
		return arr.iterator();
	}

	private void levelOrderTraverse(ArrayList<Integer> arr,
			BinaryTreeNode<Integer> node) {

		QueueADT<BinaryTreeNode<Integer>> queue = new ArrayQueue<BinaryTreeNode<Integer>>(
				true);
		queue.enqueue(node);
		while (!queue.isEmpty()) {
			BinaryTreeNode<Integer> temp = queue.dequeue();
			if (temp != null) {
				arr.add(temp.getElement());
				queue.enqueue(temp.getLeftNode());
				queue.enqueue(temp.getRightNode());
			} else
				arr.add(null);
		}
	}

	@Override
	public void printTree(BinaryTreeNode[] list) {
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
				temp[idx] = new BinaryTreeNode<>();
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



	public int height() {
		return treeHeight(root);
	}

	public static void main(String[] args) {

		BinaryTreeNode a = new BinaryTreeNode(10);
		BinaryTreeNode b = new BinaryTreeNode(5);
		BinaryTreeNode c = new BinaryTreeNode(15);
		BinaryTreeNode d = new BinaryTreeNode(3);
		BinaryTreeNode e = new BinaryTreeNode(7);
		a.addLeftChild(b);
		a.addRightChild(c);
		b.addLeftChild(d);
		b.addRightChild(e);
		//BinaryTreeNode z = new BinaryTreeNode(1);
		//d.addLeftChild(z);
		LinkedBinaryTreeADT bt = new LinkedBinaryTree(a);
		BinaryTreeNode[] lsit = { a };
		// lsit.add(a);
		System.out.println("TREE: ");
		bt.printTree(lsit);
		System.out.println();
		System.out.println("Root : " + bt.getRoot().getElement());
		System.out.println("Is Empty? : " + bt.isEmpty());
		System.out.println("Size? : " + bt.size());
		System.out.println("Contains nr.15? : " + bt.contains(15));
		System.out.println("Find nr.15! : " + bt.find(15));

		System.out.println("In Order : " + bt.iteratorInOrder());
		System.out.println("Pre Order : " + bt.iteratorPreOrder());
		System.out.println("Post Order : " + bt.iteratorPostOrder());
		System.out.println("Level Order : " + bt.iteratorLevelOrder());
		
		
		
		
		//System.out.println("Height: " + bt.treeHeight(a));
	}

}
