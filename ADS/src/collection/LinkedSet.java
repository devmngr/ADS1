package collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedSet<T> implements SetADT<T> {

	private int size;
	private LinearNode<T> front;
	private boolean allowNullElement;

	// /////////////////////////////////////////////////////
	private class LinkedSetIterator implements Iterator<T> {

		private LinearNode<T> currentNode;

		public LinkedSetIterator() {
			currentNode = front;
		}

		@Override
		public boolean hasNext() {
			return currentNode != null;
		}

		@Override
		public T next() {
			if (!hasNext())
				throw new NoSuchElementException();
			
			T temp = currentNode.getElement();
			currentNode = currentNode.getNext();
			return temp;
		}
	}
	///////////////////////////////////////////////////
	@Override
	public Iterator<T> iterator() {
		return new LinkedSetIterator();

	}
	public LinkedSet(boolean allowNullElement) {
		size = 0;
		front = null;
		this.allowNullElement = allowNullElement;
	}

	@Override
	public void add(T element) {
		if (element == null && !allowNullElement) {
			throw new IllegalArgumentException(
					"Null element is not allowed to add");
		}
		else if(!(contains(element)))
		{
		front = new LinearNode<T>(element, front);
		size++;
		}
	}

	@Override
	public T remove(T element) {

		if (!(contains(element))) {
			throw new IllegalStateException();
		}
		T temp = null;
		for (int i = 0; i < size; i++) {

			temp = getNode(i).getElement();
			if (temp.equals(element) || temp == element) {
				if (i == 0) {
					front = front.getNext();
					break;

				} else {
					getNode(i).setElement(front.getElement());
					front = front.getNext();
					break;
				}
			}
		}
		size--;
		return temp;
	}

	@Override
	public boolean contains(T element) {
		for (int i = 0; i < size; i++) {
			if (getNode(i).getElement() != null
					&& getNode(i).getElement().equals(element)) {
				return true;
			}
			if (getNode(i).getElement() == null
					&& getNode(i).getElement() == element) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean isEmpty() {

		return size == 0;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isSubset(SetADT<T> set) {
		if (set == null) {
			throw new IllegalArgumentException();
		}
		
		for (int i = 0; i < size; i++) {
			T temp = getNode(i).getElement();
			if (!(set.contains(temp))) {
				return false;
			}
		}
		return true;
	}

	@Override
	public SetADT<T> intersection(SetADT<T> set) {
		if (set == null) {
			throw new IllegalArgumentException();
		}
		SetADT<T> temp = new LinkedSet<T>(allowNullElement);

		for (int i = 0; i < size; i++) {

			if (set.contains(getNode(i).getElement())) {
				temp.add(getNode(i).getElement());
			}
		}
		return temp;
	}

	public SetADT<T> union(SetADT<T> set) {

		if (set == null) {
			throw new IllegalArgumentException();
		}

		LinkedSet<T> temp = new LinkedSet<T>(allowNullElement);
		LinearNode<T> node = front;

		for (int i = 0; i < size; i++) {
			T el = node.getElement();
			temp.add(el);
			node = node.getNext();
		}

		Iterator<T> iterator = set.iterator();
		while (iterator.hasNext()) {
			temp.add(iterator.next());

		}
		return temp;
	}
	public String toString() {
	
		String str = "{";
		for (int i = 0; i < size; i++) {
			str += getNode(i).getElement();
			if (i < size - 1) {
				str += (", ");
			}
		}
		return str + "}";
	
	}
	private LinearNode<T> getNode(int index) {
		LinearNode<T> current = front;
		for (int i = 0; i < index; i++) {
			current = current.getNext();
		}
		return current;
	}

}
