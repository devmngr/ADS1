package binarySearchTree;

public interface BinarySearchTreeADT extends BinaryTreeADT{

	
	/**
	* @param element to add
	*/
	public void addElement(int element);
	/**
	* @param element to remove
	*/
	public void removeElement(int element);
	/**
	* @param elements to remove
	*/
	public void removeAllOccurrences(int element);
	/**
	* @param remove min element
	*/
	public void removeMin();
	/**
	* @param remove max element
	*/
	public void removeMax();


}
