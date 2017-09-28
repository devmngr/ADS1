package collection;


public class ArrayList<T> implements ListADT<T> {

	private static final int DEFAULT_CAPACITY = 100;
	private int size;
	private T[] list;
	private boolean allowNullElement;

	public ArrayList(int initialCapacity, boolean allowNullElement) {
		size = 0;
		list = (T[]) new Object[initialCapacity];
		this.allowNullElement = allowNullElement;	
	}

	public ArrayList(boolean allowNullElement) {
		size = 0;
		list = (T[]) new Object[DEFAULT_CAPACITY];
		this.allowNullElement = allowNullElement;
	}

	@Override
	public void add(int index, T element) {
		if (element == null && !allowNullElement) {
			throw new IllegalArgumentException("Null is not allowed");
		} else if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException();
		} else if (size == list.length) {
			expandCapacity();
		}
		T temp=null;
		size++;
		for (int i = index; i < size; i++) {
			temp = list[i];
			list[i] = element;
			element = temp;
		}
	}

	@Override
	public void add(T element) {
		if (element == null && !allowNullElement) {
			throw new IllegalArgumentException("Null is not allowed to add");
		}
		if (size == list.length) {
			expandCapacity();
		}

		list[size] = element;
		size++;
	}

	@Override
	public void set(int index, T element) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException();
		}
		if (element == null && !allowNullElement) {
			throw new IllegalArgumentException("Null is not allowed to add");
		}

		list[index] = element;
	}

	@Override
	public T get(int index) {
		if (index < 0 || index > size-1) {
			throw new IndexOutOfBoundsException();
		}

		return list[index];
	}

	@Override
	public T remove(int index) {
		if (index < 0 || index > size-1) {
			throw new IndexOutOfBoundsException();
		}

		T element = list[index];
		list[index] = null;
		return element;
	}

	@Override
	public T remove(T element) {
		if (element == null && !allowNullElement) {
			throw new IllegalStateException("null elements not allowed");
		}
		T temp = null;

		for (int i = 0; i < size; i++) {
			if (list[i] == element || list[i].equals(element)) {
				temp = list[i];
				list[i]=null;
			}
		}

		return temp;

	}

	@Override
	public int indexOf(T element) {
		
		for (int i = 0; i < size; i++) {
			if(list[i] == element || list[i].equals(element))
			{
				return i;
			}
		}
		return -1;	
	}

	@Override
	public boolean contains(T element) {

		for (int i = 0; i < list.length; i++) {
			if(list[i] == element || list[i].equals(element))
			{
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
	public boolean isBounded()
	{
		return list.length == DEFAULT_CAPACITY;
	}
	public String toString() {
		String str = "";
		for (int i = 0; i < size; i++) {
			str += list[i];
			if (i < size - 1) {
				str += ", ";
			}
		}
		return str;
	}

	private void expandCapacity() {
		T[] newList = (T[]) new Object[list.length * 2];
		for (int i = 0; i < list.length; i++) {
			newList[i] = list[i];
		}
		list = newList;
	}
}