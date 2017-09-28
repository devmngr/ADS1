package tree;

public class BinaryTreeNode <T>
{
	private T element;
	private BinaryTreeNode<T> left;
	private BinaryTreeNode<T> right;
	
	public BinaryTreeNode(){
		element = null;
		left = null;
		right = null;
	}
	public BinaryTreeNode(T element)
	{
		this.element=element;
		left = null;
		right = null;
	}
	public BinaryTreeNode(T element, BinaryTreeNode<T> left)
	{
		this.element = element;
		this.left = left;
		this.right = null;
	}
	public BinaryTreeNode(T element, BinaryTreeNode<T> left, BinaryTreeNode<T> right)
	{
		this.element = element;
		this.left = left;
		this.right = right;
	}
	public BinaryTreeNode<T> getLeftNode()
	{
		return left;
	}
	public BinaryTreeNode<T> getRightNode()
	{
		return right;
	}
	public void addLeftChild(BinaryTreeNode<T> node)
	{
		left = node;
	}
	public void addRightChild(BinaryTreeNode<T> node)
	{
		right = node;
	}
	public T getElement()
	{
		return element;
	}
	public void setElement(T element)
	{
		this.element=element;
	}
	public boolean hasLeft(){
		return getLeftNode() != null;
	}
	public boolean hasRight(){
		return getRightNode()!=null;
	}
	
}
