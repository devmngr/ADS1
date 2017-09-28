package tree;

import java.util.ArrayList;
import java.util.Iterator;

public interface LinkedBinaryTreeADT {

	public BinaryTreeNode getRoot(); // returns a reference to the root of the
									// binary tree

	public boolean isEmpty(); // determines whether the tree is empty

	public int size(); // returns the number of elements in the tree

	public boolean contains(int element); // determines whether the specified target is in
								// the tree

	public int find(int element); // returns a reference to the specified target
								// element if it is found;

	public Iterator<Integer> iteratorInOrder(); // returns an iterator for an inorder
										// traversal of the tree

	public Iterator<Integer> iteratorPreOrder(); // returns an iterator for a preorder
										// traversal of the tree

	public Iterator<Integer> iteratorPostOrder();// returns an iterator for a postorder
										// traversal of the tree

	public Iterator<Integer> iteratorLevelOrder();// returns an iterator for a
											// level-order traversal of the tree

	public void printTree(BinaryTreeNode[] list); // returns a String representation of the tree
	public int treeHeight(BinaryTreeNode<Integer> node);
}
