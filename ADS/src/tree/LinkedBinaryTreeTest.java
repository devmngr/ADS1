package tree;

import static org.junit.Assert.*;

import org.hamcrest.core.IsEqual;
import org.junit.Before;
import org.junit.Test;

public class LinkedBinaryTreeTest {

	private LinkedBinaryTreeADT tree;
	
	 @Before
	   public void setUp() throws Exception
	   {
	     tree = new LinkedBinaryTree();
	   }
	@Test
	public void testGetRoot() {
		
		assertEquals(null, tree.getRoot());
		BinaryTreeNode a = new BinaryTreeNode(10);
		BinaryTreeNode b = new BinaryTreeNode(5);
		BinaryTreeNode c = new BinaryTreeNode(15);
		BinaryTreeNode d = new BinaryTreeNode(3);
		BinaryTreeNode e = new BinaryTreeNode(7);
		a.addLeftChild(b);
		a.addRightChild(c);
		b.addLeftChild(d);
		b.addRightChild(e);
		tree = new LinkedBinaryTree(a);
		
	}
	@Test
	public void testIsEmpty(){
		
		assertEquals(true, tree.isEmpty());
		assertTrue(tree.isEmpty());
		
	}
	@Test
	public void testContains(){
		
		assertFalse(tree.contains(1));
	
		
	}
	@Test
	public void testSize(){
		
		assertEquals(0,tree.size());
		
	}
	@Test
	public void testFind(){
		
		
	}
	@Test
	public void testIteratorInOrder(){
		
		
	}
	@Test
	public void testIteratorPreOrder(){
		
		
	}
	@Test
	public void testIteratorPostOrder(){
		
		
	}
	@Test
	public void testIteratorLevelOrder(){
		
		
	}

}
