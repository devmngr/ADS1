package collection;

public class LinkedStack<T> implements StackADT<T> {

	private int count;
	private LinearNode<T> top;
	private boolean allowNullElement = false;

	public LinkedStack(boolean allowNullElement) {
		count = 0;

		top = new LinearNode<T>();
		this.allowNullElement = allowNullElement;

	}

	public String toString() {
		String str = "";
		LinearNode<T> current = new LinearNode<T>();
		current = top;

		for (int i = 0; i < count; i++) {
			str += current.getElement();
			current = current.getNext();
			if (i < count - 1) {
				str += ", ";
			}
		}

		return str;
	}

	@Override
	public void push(T element) {
		if (element == null && !allowNullElement) {
			throw new IllegalArgumentException(
					"Cannot push null onto the stack");
		}

		LinearNode<T> temp = new LinearNode<T>();
		temp.setElement(element);
		temp.setNext(top);
		top = temp;
		count++;
	}

	@Override
	public T pop() {

		if (count == 0) {
			throw new IllegalStateException("Stack was empty");
		}
		T temp = top.getElement();
		top = top.getNext();
		count--;
		return temp;
	}

	@Override
	public T peek() {
		if (count == 0) {
			throw new IllegalStateException("Stack was empty");
		}

		return top.getElement();
	}

	@Override
	public int indexOf(T element) {
		if (count == 0) {
			throw new IllegalStateException("Stack was empty");
		}
		if (element == null && !allowNullElement) {
			throw new IllegalArgumentException("Null elements not allowed");
		}
		LinearNode<T> current = new LinearNode<T>();
		current = top;

		for (int i = 0; i < count; i++) {
			if (element == current.getElement()) {
				return i;
			}
			current = current.getNext();
		}

		return -1;

	}

	@Override
	public boolean isEmpty() {

		return count == 0;
	}

	@Override
	public int size() {
		return count;
	}

}
