package collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArraySet<T> implements SetADT<T> {

	private static final int DEFAULT_CAPACITY = 100;
	private int size;
	private T[] set;
	private boolean allowNullElement;

	// /////////////////////////////////////////////////////////////////////////////////////////////////
	private class ArraySetIterator implements Iterator<T> {

		private int current;
		

		public ArraySetIterator(){
			current = 0;
		}
		
		@Override
		public boolean hasNext() {
			return current < size();
		}

		@Override
		public T next() {
			if (!hasNext())
				throw new NoSuchElementException();
			T temp = set[current];
			set[current] = set[current++];
			return temp;		
		}

	}

	// //////////////////////////////////////////////////////////////////////////////////////////////////
	public ArraySet(boolean allowNullElement) {
		set = (T[]) new Object[DEFAULT_CAPACITY];
		this.allowNullElement = allowNullElement;
		size = 0;
	}

	public ArraySet(int initialCapacity, boolean allowNullElement) {
		this.size = 0;
		this.allowNullElement = allowNullElement;
		set = (T[]) new Object[initialCapacity];
	}

	@Override
	public void add(T element) {
		if (size == set.length) {
			throw new IllegalStateException();
		}
		if (element == null && !allowNullElement) {
			throw new IllegalArgumentException();
		}
		else if(!(contains(element)))
		{
		set[size] = element;
		size++;
		}
	}

	@Override
	public T remove(T element) {
		T temp = null;
		for (int i = 0; i < size; i++) {
			if (set[i] == element || set[i].equals(element)) {
				temp = set[i];
				set[i] = set[size - 1];
				set[size - 1] = null;
				size--;
			}
		}
		if (temp == null)
			throw new IllegalStateException();
		else
			return temp;
	}

	@Override
	public boolean contains(T element) {

		for (int i = 0; i < size; i++)
			if (set[i] == element || set[i].equals(element))
				return true;

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
		
		for (int i=0;i<size;i++)
		if(!(set.contains(this.set[i])))
			return false;
		
		return true;
	}

	@Override
	public SetADT<T> intersection(SetADT<T> set) {
		if (set == null) {
			throw new IllegalArgumentException();
		}
		ArraySet<T> temp = new ArraySet<T>(allowNullElement);
		
		for(int i= 0; i<size; i++)
			if(set.contains(this.set[i]))
				temp.add(this.set[i]);
		
		return temp;
		
		
	}

	@Override
	public SetADT<T> union(SetADT<T> set) {
		if (set == null) {
			throw new IllegalArgumentException();
		}
		
ArraySet<T> temp = new ArraySet<T>((this.set.length+set.size()),allowNullElement);
		
		for(int i= 0; i<size; i++)
				temp.add(this.set[i]);
		
		///TheIterator 
		Iterator<T> iterator = set.iterator();
		while(iterator.hasNext())
			temp.add(iterator.next());
		
		return temp;
	}

	@Override
	public Iterator<T> iterator() {

		return new ArraySetIterator();
		
	}

	public String toString() {
		String str = "";
		for (int i = 0; i < size; i++) {
			str += set[i];
			if (i < size - 1) {
				str += ", ";
			}
		}
		return str;
	}

}
