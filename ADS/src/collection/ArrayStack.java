package collection;

public class ArrayStack<T> implements StackADT<T> {

	private static final int DEFAULT_CAPACITY = 100;
	private int top;
	private T[] stack;
	private boolean allowNullElement = false;

	public ArrayStack() {
		top = 0;
		stack = (T[]) new Object[DEFAULT_CAPACITY];
	}

	public ArrayStack(int capacity) {
		top = 0;
		stack = (T[]) new Object[capacity];
	}

	public String toString() {
		String returnStr = "{";
		for (int i = top - 1; i >= 0; i--) {
			returnStr += stack[i];
			if (i > 0) {
				returnStr += ",";
			}
		}
		return returnStr + "}";
	}
	public int capacity()
	{
		return stack.length;
	}

	private void expandCapacity() {
		T[] newStack = (T[]) new Object[stack.length *2];
		for (int i = 0; i < stack.length; i++) {
			newStack[i] = stack[i];
		}
		stack = newStack;
	}

	@Override
	public void push(T element) throws IllegalStateException {
		if (element == null && !allowNullElement) {
			throw new IllegalArgumentException(
					"Cannot push null onto the stack");
		}
		if (top >= stack.length) {
			expandCapacity();
		}

		stack[top] = element;
		top++;
	}

	@Override
	public T pop() throws IllegalStateException {

		if (top == 0) {
			throw new IllegalStateException("Stack was empty");
		}
		T element = stack[top - 1];
		stack[top - 1] = null;
		top--;

		return element;
	}

	@Override
	public T peek() throws IllegalStateException {
		if (top == 0) {
			throw new IllegalStateException("Stack was empty");
		}
		T element = stack[top - 1];
		return element;
	}

	@Override
	public int indexOf(T element) {
		int index = -1;

		for (int i = top - 1; i >= 0; i--) {
			if (element == null && element == stack[i]) {
				return top - 1 - i;

			} else if (element != null && element.equals(stack[i])) {

				return top - 1 - i;
			}
		}

		return -1;
	}

	@Override
	public boolean isEmpty() {
		return top == 0;
	}

	@Override
	public int size() {

		return top;
	}

}
