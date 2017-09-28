package binarySearchTree;

import java.util.Iterator;

public interface BinaryTreeADT {

	/**
	 * @return root element
	 */
	BinaryTreeNode<Integer> getRoot();

	/**
	 * @return true if empty
	 */
	boolean isEmpty();

	/**
	 * @return number of elements
	 */
	int size();

	/**
	 * @param element
	 *            to look for
	 * @return true if found element
	 */
	boolean contains(int element);

	/**
	 * @param node
	 *            to find height for
	 * @return height of node
	 */
	int height(BinaryTreeNode<Integer> node);

	/**
	 * @return an in order iterator
	 */
	Iterator<Integer> iteratorInOrder();

	/**
	 * @return a post order iterator
	 */
	Iterator<Integer> iteratorPostOrder();

	/**
	 * @return a pre order iterator
	 */
	Iterator<Integer> iteratorPreOrder();

	/**
	 * @return a level order iterator
	 */
	Iterator<Integer> iteratorLevelOrder();

}
