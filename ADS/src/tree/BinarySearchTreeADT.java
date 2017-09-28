package tree;

public interface BinarySearchTreeADT extends LinkedBinaryTreeADT{

	
	public void addElement(int element);
	public int removeElement(int element);
	public void removeAllOccurances(int element);
	public int removeMin();
	public int removeMax();
	public int findMin();
	public int findMax();
}
