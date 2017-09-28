package collection;

////Tested-Status OK!
public class LinkedList3<T> implements ListADT<T>{

	private LinearNode<T> rear;
	private int count;
	
	@Override
	public void add(int index, T element) {
		if(index > count || index < 0 ) {
			throw new IndexOutOfBoundsException("Idx too high or low");
		}
		if(index == count) { // insert at the end
			add(element);
		} else if(count == 0) {
			add(element);
		} else {
			LinearNode<T> before = rear;
			for(int i = -1; i < index -1; i++) {
				before = before.getNext();
			}
			LinearNode<T> newNode = new LinearNode<>(element);
			newNode.setNext(before.getNext());
			before.setNext(newNode);
			count++;
		}
		
	}

	@Override
	public void add(T element) {
		if(count == 0) {
			LinearNode<T> node = new LinearNode<T>(element);
			node.setNext(node);
			rear = node;
		} else {
			LinearNode<T> node = new LinearNode<T>(element);
			node.setNext(rear.getNext());
			rear.setNext(node);
			rear = node;
		}
		count++;		
	}

	@Override
	public boolean contains(T element) {
		if(count == 0) return false;
		LinearNode<T> current = rear.getNext();
		for(int i = 0; i < count; i++) {
			if(current.getElement() == null) {
				if(element == null)
					return true;
			} else if(current.getElement().equals(element)) {
				return true;
			}
			current = current.getNext();
		}
		return false;
	}

	@Override
	public T get(int index) {
		if(index >= count || index < 0 ) {
			throw new IndexOutOfBoundsException("idx too high or low");
		}
		LinearNode<T> current = rear.getNext();
		for(int i = 0; i < index; i++) {
			
			current = current.getNext();
		}
		return current.getElement();
	}

	@Override
	public int indexOf(T element) {
		if(count == 0) return -1;
		LinearNode<T> current = rear.getNext();
		for(int i = 0; i < count; i++) {
			if(current.getElement() == null) {
				if(element == null)
					return i;
			} else if(current.getElement().equals(element)) {
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
	public T remove(T element) {
		if(!contains(element)) {
			throw new IllegalStateException("Element not found");
		}
		LinearNode<T> current = rear.getNext();
		LinearNode<T> previous = rear;
		
		int i = 0; 
		for(int x; i < count; i++) {
			if(current.getElement() == null) {
				if(element == null)
					break;
			} else if(current.getElement().equals(element)) {
				break;
			}
			previous = current;
			current = current.getNext();
		}
		previous.setNext(current.getNext());
		if(current == rear) {
			rear = previous;
		}
		count--;
		return current.getElement();
	}

	@Override
	public T remove(int index) {
		if(index >= count || index < 0)
			throw new IndexOutOfBoundsException("Idx too high or low");
		LinearNode<T> current = rear.getNext();
		LinearNode<T> previous = rear;
		
		for(int i = 0; i < index; i++) {
			previous = current;
			current = current.getNext();
		}
		previous.setNext(current.getNext());
		if(index == count-1) {
			rear = previous;
		}
			
		count--;
		return current.getElement();
	}

	@Override
	public int size() {
		return count;
	}

	@Override
	public void set(int index, T element) {
		if(index >= count || index < 0 ) {
			throw new IndexOutOfBoundsException();
		}
		
		LinearNode<T> current = rear.getNext();
		for(int i = 0; i < index; i++) {
			
			current = current.getNext();
		}
		current.setElement(element);
	}
	
	@Override
	public String toString() {
		LinearNode<T> node = rear.getNext();
		StringBuilder sb = new StringBuilder("{");
		for(int i = 0; i < count; i++) {
			sb.append(node.getElement());
			node = node.getNext();
			if(i < count -1) {
				sb.append(", ");
			}
		}
		return sb.append("}").toString();
	}
}
