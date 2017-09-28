package binarySearchTree;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

public class binarySearchTreeTest {

	private binarySearchTree tree;
	int value;

	@Before
	public void setUp() throws Exception {
		tree = new binarySearchTree();
		value = 0;
	}

	@Test
	public void testGetRoot() {
		assertTrue(tree.getRoot() == null);
		assertEquals(0, tree.size());

		tree.addElement(1);
		assertTrue(tree.getRoot() != null);
		assertTrue(tree.getRoot().getElement() == 1);
		assertEquals(1, tree.size());

		tree.addElement(2);
		assertEquals(2, tree.size());
		assertTrue(tree.getRoot().getElement() == 1);

		tree.addElement(3);
		tree.addElement(4);
		assertEquals(4, tree.size());
		assertTrue(tree.getRoot().getElement() == 1);

		tree.removeElement(1);
		assertTrue(tree.getRoot().getElement() == 2);

		tree.removeElement(2);
		assertTrue(tree.getRoot().getElement() == 3);

		tree.removeElement(3);
		assertTrue(tree.getRoot().getElement() == 4);

		tree.removeElement(4);
		assertTrue(tree.getRoot() == null);
		assertEquals(0, tree.size());
	}

	@Test
	public void testGetRootEmptyTree() {
		assertTrue(tree.getRoot() == null);
		assertTrue(tree.size() == 0);

		tree.addElement(1);
		assertTrue(tree.getRoot() != null);
		assertTrue(tree.getRoot().getElement() == 1);
		assertEquals(1, tree.size());

		tree.removeElement(1);
		assertTrue(tree.getRoot() == null);
		assertEquals(0, tree.size());
	}

	@Test
	public void testIsEmpty() {

		assertTrue(tree.isEmpty());
		tree.addElement(1);
		assertFalse(tree.isEmpty());
		tree.removeElement(2);
		assertFalse(tree.isEmpty());
		tree.removeElement(1);
		assertTrue(tree.isEmpty());

	}

	@Test
	public void testSize() {
		assertEquals(0, tree.size());
		tree.addElement(1);
		assertEquals(1, tree.size());

		tree.addElement(2);
		assertEquals(2, tree.size());

		tree.addElement(3);
		tree.addElement(-4);
		assertEquals(4, tree.size());

		tree.removeElement(1);
		tree.removeElement(2);
		assertEquals(2, tree.size());

		tree.removeElement(3);
		tree.removeElement(-4);
		assertEquals(0, tree.size());
	}

	@Test
	public void testContains() {
		assertTrue(tree.isEmpty());
		assertEquals(0, tree.size());
		assertFalse(tree.contains(1));
		assertFalse(tree.contains(2));
		assertFalse(tree.contains(3));

		tree.addElement(1);
		assertTrue(tree.contains(1));
		assertFalse(tree.isEmpty());

		tree.addElement(2);
		assertTrue(tree.contains(1));
		assertTrue(tree.contains(2));

		tree.addElement(3);
		assertTrue(tree.contains(3));

		tree.removeElement(1);
		assertTrue(tree.contains(2));
		assertTrue(tree.contains(3));
		assertFalse(tree.contains(1));

		tree.removeElement(2);
		tree.removeElement(3);
		assertFalse(tree.contains(2));
		assertFalse(tree.contains(3));
		assertFalse(tree.contains(1));
		assertTrue(tree.isEmpty());

	}

	@Test
	public void testHeight() {

		assertEquals(0, tree.height(tree.getRoot()));

		tree.addElement(10);
		assertEquals(1, tree.height(tree.getRoot()));

		tree.addElement(20);
		assertEquals(2, tree.height(tree.getRoot()));

		tree.addElement(8);
		assertEquals(2, tree.height(tree.getRoot()));

		tree.addElement(7);
		assertEquals(3, tree.height(tree.getRoot()));

		tree.addElement(9);
		assertEquals(3, tree.height(tree.getRoot()));

		tree.addElement(15);
		assertEquals(3, tree.height(tree.getRoot()));

		tree.addElement(40);
		assertEquals(3, tree.height(tree.getRoot()));

		tree.addElement(50);
		assertEquals(4, tree.height(tree.getRoot()));

		tree.addElement(60);
		assertEquals(5, tree.height(tree.getRoot()));

		tree.removeElement(8);
		tree.removeElement(7);
		assertEquals(5, tree.height(tree.getRoot()));

		tree.removeElement(60);
		assertEquals(4, tree.height(tree.getRoot()));

		tree.removeElement(50);
		assertEquals(3, tree.height(tree.getRoot()));

		tree.removeElement(40);
		tree.removeElement(15);
		tree.removeElement(20);
		assertEquals(2, tree.height(tree.getRoot()));

		tree.removeElement(9);
		assertEquals(1, tree.height(tree.getRoot()));

		tree.removeElement(10);
		assertEquals(0, tree.height(tree.getRoot()));

	}

	@Test
	public void testHeightNull() {

		assertEquals(0, tree.height(null));

		assertEquals(0, tree.height(tree.getRoot()));
		tree.addElement(1);
		assertEquals(1, tree.height(tree.getRoot()));

		tree.addElement(2);
		assertEquals(2, tree.height(tree.getRoot()));
		tree.addElement(-2);
		assertEquals(2, tree.height(tree.getRoot()));

		tree.removeElement(1);
		assertEquals(2, tree.height(tree.getRoot()));

		tree.removeElement(-2);
		assertEquals(1, tree.height(tree.getRoot()));

		tree.removeElement(2);
		assertEquals(0, tree.height(tree.getRoot()));

		assertEquals(0, tree.height(null));

	}

	@Test
	public void testInOrderTraversal() {
		assertEquals(0, tree.size());
		tree.addElement(40);
		tree.addElement(20);
		tree.addElement(10);
		assertEquals(3, tree.size());
		tree.addElement(30);
		tree.addElement(70);
		assertEquals(5, tree.size());
		ArrayList<Integer> arr = new ArrayList<Integer>();
		java.util.Iterator<Integer> iterator = tree.iteratorInOrder();
		while (iterator.hasNext()) {
			arr.add(iterator.next());
		}
		// 10-20-30-40-70
		int value = arr.get(0);
		assertEquals(10, value);

		value = arr.get(1);
		assertEquals(20, value);

		value = arr.get(2);
		assertEquals(30, value);

		value = arr.get(3);
		assertEquals(40, value);

		value = arr.get(4);
		assertEquals(70, value);

		tree.removeElement(10);
		tree.removeElement(20);
		assertEquals(3, tree.size());
		tree.removeElement(30);
		tree.removeElement(40);
		tree.removeElement(70);
		assertEquals(0, tree.size());

	}

	@Test
	public void testPreOrderTraversal() {
		assertEquals(0, tree.size());
		tree.addElement(40);
		tree.addElement(20);
		tree.addElement(10);
		assertEquals(3, tree.size());
		tree.addElement(30);
		tree.addElement(70);
		assertEquals(5, tree.size());
		ArrayList<Integer> arr = new ArrayList<Integer>();
		java.util.Iterator<Integer> iterator = tree.iteratorPreOrder();
		while (iterator.hasNext()) {
			arr.add(iterator.next());
		}
		// 40-20-10-30-70
		int value = arr.get(0);
		assertEquals(40, value);

		value = arr.get(1);
		assertEquals(20, value);

		value = arr.get(2);
		assertEquals(10, value);

		value = arr.get(3);
		assertEquals(30, value);

		value = arr.get(4);
		assertEquals(70, value);

		tree.removeElement(10);
		tree.removeElement(20);
		assertEquals(3, tree.size());
		tree.removeElement(30);
		tree.removeElement(40);
		tree.removeElement(70);
		assertEquals(0, tree.size());

	}

	@Test
	public void testPostOrderTraversal() {
		assertEquals(0, tree.size());
		tree.addElement(40);
		tree.addElement(20);
		tree.addElement(10);
		assertEquals(3, tree.size());
		tree.addElement(30);
		tree.addElement(70);
		assertEquals(5, tree.size());
		ArrayList<Integer> arr = new ArrayList<Integer>();
		java.util.Iterator<Integer> iterator = tree.iteratorPostOrder();
		while (iterator.hasNext()) {
			arr.add(iterator.next());
		}
		// 10-30-20-70-40
		int value = arr.get(0);
		assertEquals(10, value);

		value = arr.get(1);
		assertEquals(30, value);

		value = arr.get(2);
		assertEquals(20, value);

		value = arr.get(3);
		assertEquals(70, value);

		value = arr.get(4);
		assertEquals(40, value);

		tree.removeElement(10);
		tree.removeElement(20);
		assertEquals(3, tree.size());
		tree.removeElement(30);
		tree.removeElement(40);
		tree.removeElement(70);
		assertEquals(0, tree.size());
	}

	@Test
	public void testLevelOderTraversal() {

		assertEquals(0, tree.size());
		tree.addElement(40);
		tree.addElement(20);
		tree.addElement(10);
		assertEquals(3, tree.size());
		tree.addElement(30);
		tree.addElement(70);
		assertEquals(5, tree.size());
		ArrayList<Integer> arr = new ArrayList<Integer>();
		java.util.Iterator<Integer> iterator = tree.iteratorLevelOrder();
		while (iterator.hasNext()) {
			arr.add(iterator.next());
		}
		// 40-20-70-10-30
		int value = arr.get(0);
		assertEquals(40, value);

		value = arr.get(1);
		assertEquals(20, value);

		value = arr.get(2);
		assertEquals(70, value);

		value = arr.get(3);
		assertEquals(10, value);

		value = arr.get(4);
		assertEquals(30, value);

		tree.removeElement(10);
		tree.removeElement(20);
		assertEquals(3, tree.size());
		tree.removeElement(30);
		tree.removeElement(40);
		tree.removeElement(70);
		assertEquals(0, tree.size());
	}

	@Test
	public void testAdd() {
		assertEquals(null, tree.getRoot());
		assertEquals(0, tree.size());
		tree.addElement(20);
		value = tree.getRoot().getElement();
		assertEquals(20, value);

		tree.addElement(10);
		value = tree.getRoot().getLeftNode().getElement();
		assertEquals(10, value);

		tree.addElement(40);
		value = tree.getRoot().getRightNode().getElement();
		assertEquals(40, value);
		assertEquals(3, tree.size());

		tree.addElement(15);
		value = tree.getRoot().getLeftNode().getRightNode().getElement();
		assertEquals(15, value);
		assertEquals(4, tree.size());

		tree.addElement(3);
		value = tree.getRoot().getLeftNode().getLeftNode().getElement();
		assertEquals(3, value);
		assertEquals(5, tree.size());

		tree.addElement(2);
		value = tree.getRoot().getLeftNode().getLeftNode().getLeftNode()
				.getElement();
		assertEquals(2, value);
		assertEquals(6, tree.size());

		tree.addElement(4);
		value = tree.getRoot().getLeftNode().getLeftNode().getRightNode()
				.getElement();
		assertEquals(4, value);
		assertEquals(7, tree.size());

		tree.addElement(8);
		value = tree.getRoot().getLeftNode().getLeftNode().getRightNode()
				.getRightNode().getElement();
		assertEquals(8, value);
		assertEquals(8, tree.size());

		tree.addElement(7);
		value = tree.getRoot().getLeftNode().getLeftNode().getRightNode()
				.getRightNode().getLeftNode().getElement();
		assertEquals(7, value);
		assertEquals(9, tree.size());

		tree.addElement(6);
		value = tree.getRoot().getLeftNode().getLeftNode().getRightNode()
				.getRightNode().getLeftNode().getLeftNode().getElement();
		assertEquals(6, value);
		assertEquals(10, tree.size());

		tree.removeElement(6);
		tree.removeElement(7);
		tree.removeElement(8);
		tree.removeElement(4);
		tree.removeElement(3);
		assertEquals(5, tree.size());
		tree.removeElement(2);
		tree.removeElement(10);
		tree.removeElement(15);
		tree.removeElement(20);
		tree.removeElement(40);
		assertEquals(0, tree.size());
	}

	@Test
	public void testRemoveRoot() {
		assertEquals(null, tree.getRoot());

		tree.addElement(20);
		tree.addElement(10);
		tree.addElement(30);
		tree.addElement(8);
		assertEquals(4, tree.size());
		int value = tree.getRoot().getElement();
		assertEquals(20, value);

		tree.removeElement(20);
		assertEquals(3, tree.size());
		value = tree.getRoot().getElement();
		assertEquals(10, value);

		tree.removeElement(10);
		assertEquals(2, tree.size());
		value = tree.getRoot().getElement();
		assertEquals(8, value);

		tree.removeElement(8);
		assertEquals(1, tree.size());
		value = tree.getRoot().getElement();
		assertEquals(30, value);

		tree.removeElement(30);
		assertEquals(0, tree.size());
	}

	@Test
	public void testRemoveElementRootNull() {
		assertEquals(0, tree.size());
		assertEquals(null, tree.getRoot());
		try {
			tree.removeElement(1);
		} catch (NullPointerException e) {
		}
	}

	@Test
	public void testRemoveElementRootLeftNullRightLeaf() {
		assertEquals(0, tree.size());
		assertEquals(null, tree.getRoot());

		tree.addElement(20);
		tree.addElement(30);
		assertEquals(2, tree.size());
		assertEquals(null, tree.getRoot().getLeftNode());
		int value = tree.getRoot().getRightNode().getElement();
		assertEquals(30, value);
		assertTrue(tree.getRoot().getRightNode().isLeaf());

		tree.removeElement(20);
		assertEquals(1, tree.size());
		assertEquals(null, tree.getRoot().getLeftNode());
		assertEquals(null, tree.getRoot().getRightNode());
		value = tree.getRoot().getElement();
		assertEquals(30, value);
		assertTrue(tree.getRoot().isLeaf());

		tree.removeElement(30);
		assertEquals(0, tree.size());
		assertEquals(null, tree.getRoot());

	}

	@Test
	public void testRemoveElementRootRightNullLeftLeaf() {
		assertEquals(0, tree.size());
		assertEquals(null, tree.getRoot());

		tree.addElement(20);
		tree.addElement(10);
		assertEquals(2, tree.size());
		assertEquals(null, tree.getRoot().getRightNode());
		int value = tree.getRoot().getLeftNode().getElement();
		assertEquals(10, value);
		assertTrue(tree.getRoot().getLeftNode().isLeaf());

		tree.removeElement(20);
		assertEquals(1, tree.size());
		assertEquals(null, tree.getRoot().getLeftNode());
		assertEquals(null, tree.getRoot().getRightNode());
		value = tree.getRoot().getElement();
		assertEquals(10, value);
		assertTrue(tree.getRoot().isLeaf());

		tree.removeElement(10);
		assertEquals(0, tree.size());
		assertEquals(null, tree.getRoot());

	}

	@Test
	public void testRemoveElementInexistentElement() {
		tree.addElement(20);
		tree.addElement(30);
		tree.addElement(40);
		tree.addElement(10);

		assertEquals(4, tree.size());
		assertTrue(tree.getRoot().getElement() == 20);

		tree.removeElement(100);
		assertEquals(4, tree.size());
		assertTrue(tree.getRoot().getElement() == 20);

		tree.removeElement(10);
		tree.removeElement(40);
		assertEquals(2, tree.size());
		assertTrue(tree.getRoot().getElement() == 20);

		tree.removeElement(100);

		tree.removeElement(30);
		assertEquals(1, tree.size());
		assertTrue(tree.getRoot().getElement() == 20);

		tree.removeElement(20);
		assertEquals(0, tree.size());
		assertTrue(tree.getRoot() == null);

		try {
			tree.removeElement(100);
		} catch (NullPointerException e) {

		}
	}

	@Test
	public void testRemoveElement() {
		assertEquals(null, tree.getRoot());

		tree.addElement(20);
		tree.addElement(10);
		tree.addElement(30);

		assertEquals(3, tree.size());
		int value = tree.getRoot().getElement();
		assertEquals(20, value);

		tree.removeElement(10);
		assertEquals(2, tree.size());
		assertEquals(null, tree.getRoot().getLeftNode());

		tree.removeElement(30);
		assertEquals(1, tree.size());
		assertEquals(null, tree.getRoot().getRightNode());
		assertEquals(20, value);

		tree.removeElement(20);
		// value =tree.getRoot().getElement();
		assertEquals(null, tree.getRoot());
		assertEquals(0, tree.size());
	}

	@Test
	public void testRemoveAllOcurencesEmptyTree() {
		assertEquals(null, tree.getRoot());
		assertEquals(0, tree.size());

		try {
			tree.removeAllOccurrences(10);
		} catch (NullPointerException e) {
		}
	}

	@Test
	public void testRemoveAllOccurencesOneOccur() {
		assertEquals(null, tree.getRoot());
		assertEquals(0, tree.size());

		tree.addElement(10);
		tree.addElement(20);
		int value = tree.getRoot().getElement();
		assertEquals(10, value);
		assertEquals(2, tree.size());

		tree.removeAllOccurrences(10);
		value = tree.getRoot().getElement();
		assertEquals(20, value);
		assertEquals(1, tree.size());

		tree.removeAllOccurrences(20);
		assertEquals(null, tree.getRoot());
		assertEquals(0, tree.size());

	}

	@Test
	public void testRemoveAllOccurences() {
		assertEquals(null, tree.getRoot());
		assertEquals(0, tree.size());

		tree.addElement(10);
		tree.addElement(10);
		tree.addElement(20);
		tree.addElement(10);
		tree.addElement(8);
		tree.addElement(10);

		int value = tree.getRoot().getElement();
		assertEquals(10, value);
		assertEquals(6, tree.size());

		tree.removeAllOccurrences(10);
		value = tree.getRoot().getElement();
		assertEquals(8, value);
		assertEquals(2, tree.size());

		tree.removeAllOccurrences(20);
		value = tree.getRoot().getElement();
		assertEquals(8, value);
		assertEquals(1, tree.size());

		tree.removeAllOccurrences(8);
		assertEquals(null, tree.getRoot());
		assertEquals(0, tree.size());
	}

	@Test
	public void testRemoveAllOccurencesInexistentElement() {

		assertEquals(null, tree.getRoot());
		assertEquals(0, tree.size());

		tree.addElement(10);
		tree.addElement(10);
		tree.addElement(20);

		int value = tree.getRoot().getElement();
		assertEquals(10, value);
		assertEquals(3, tree.size());

		try {
			tree.removeAllOccurrences(100);

		} catch (NullPointerException e) {
			assertEquals(3, tree.size());

			tree.removeAllOccurrences(10);
			assertEquals(1, tree.size());

			tree.removeAllOccurrences(20);
			assertEquals(0, tree.size());
		}

	}

	@Test
	public void testRemoveMinEmptyTree() {
		assertEquals(null, tree.getRoot());
		assertEquals(0, tree.size());

		try {
			tree.removeMin();
		} catch (NullPointerException e) {

		}
	}

	@Test
	public void testRemoveMinMoreOccur() {
		assertEquals(null, tree.getRoot());
		assertEquals(0, tree.size());

		tree.addElement(20);
		tree.addElement(10);
		tree.addElement(10);

		int value = tree.getRoot().getElement();
		assertEquals(20, value);
		assertEquals(3, tree.size());

		value = tree.getRoot().getLeftNode().getElement();
		assertEquals(10, value);

		value = tree.getRoot().getLeftNode().getRightNode().getElement();
		assertEquals(10, value);

		tree.removeMin();
		value = tree.getRoot().getElement();
		assertEquals(20, value);
		value = tree.getRoot().getLeftNode().getElement();
		assertEquals(10, value);
		assertEquals(null, tree.getRoot().getLeftNode().getRightNode());
		assertEquals(2, tree.size());

		tree.removeMin();
		value = tree.getRoot().getElement();
		assertEquals(20, value);
		assertEquals(1, tree.size());

		tree.removeMin();
		assertEquals(null, tree.getRoot());
		assertEquals(0, tree.size());
	}

	@Test
	public void testRemoveMin() {
		assertEquals(null, tree.getRoot());
		assertEquals(0, tree.size());

		tree.addElement(10);
		tree.addElement(30);
		tree.addElement(20);
		int value = tree.getRoot().getElement();
		assertEquals(10, value);
		assertEquals(3, tree.size());

		tree.removeMin();
		assertEquals(2, tree.size());
		value = tree.getRoot().getElement();
		assertEquals(20, value);

		tree.removeMin();
		assertEquals(1, tree.size());
		value = tree.getRoot().getElement();
		assertEquals(30, value);

		tree.removeMin();
		assertEquals(0, tree.size());
		assertEquals(null, tree.getRoot());

	}

	@Test
	public void testRemoveMaxEmptyTree() {
		assertEquals(null, tree.getRoot());
		assertEquals(0, tree.size());

		try {
			tree.removeMax();
		} catch (NullPointerException e) {

		}
	}

	public void testRemoveMax() {
		assertEquals(null, tree.getRoot());
		assertEquals(0, tree.size());

		tree.addElement(10);
		tree.addElement(30);
		tree.addElement(40);
		int value = tree.getRoot().getElement();
		assertEquals(10, value);
		assertEquals(3, tree.size());

		tree.removeMax();
		assertEquals(2, tree.size());
		value = tree.getRoot().getElement();
		assertEquals(10, value);

		tree.removeMax();
		assertEquals(1, tree.size());
		value = tree.getRoot().getElement();
		assertEquals(10, value);

		tree.removeMax();
		assertEquals(0, tree.size());
		assertEquals(null, tree.getRoot());
	}

	@Test
	public void testRemoveMaxMoreOccur() {
		assertEquals(null, tree.getRoot());
		assertEquals(0, tree.size());

		tree.addElement(20);
		tree.addElement(40);
		tree.addElement(40);

		int value = tree.getRoot().getElement();
		assertEquals(20, value);
		assertEquals(3, tree.size());

		value = tree.getRoot().getRightNode().getElement();
		assertEquals(40, value);

		value = tree.getRoot().getRightNode().getRightNode().getElement();
		assertEquals(40, value);

		tree.removeMax();
		value = tree.getRoot().getElement();
		assertEquals(20, value);
		value = tree.getRoot().getRightNode().getElement();
		assertEquals(40, value);
		assertEquals(null, tree.getRoot().getRightNode().getRightNode());
		assertEquals(2, tree.size());

		tree.removeMax();
		value = tree.getRoot().getElement();
		assertEquals(20, value);
		assertEquals(1, tree.size());

		tree.removeMax();
		assertEquals(null, tree.getRoot());
		assertEquals(0, tree.size());
	}

}