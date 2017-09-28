package collection;

public class LinkedList<T> implements ListADT<T> {

	private LinearNode<T> front;
	private int count;
	private boolean allowNullElement;

	public LinkedList(boolean allowNullElement) {
		count = 0;
		front = null;
		this.allowNullElement = allowNullElement;
	}

	public String toString() {

		String str = "{";
		for (int i = 0; i < count; i++) {
			str += getNode(i).getElement();
			if (i < count - 1) {
				str += (", ");
			}
		}
		return str + "}";
	}

	public LinearNode<T> getNode(int index) {
		LinearNode<T> current = front;
		for (int i = 0; i < index; i++) {
			current = current.getNext();
		}
		return current;
	}

	@Override
	public void add(int index, T element) {
		if(element == null && !allowNullElement)
		{
			throw new IllegalArgumentException("Null element is not allowed to add");
		}
		if (index < 0 || index > count) {
			throw new IndexOutOfBoundsException();
		}
	
		if (index == 0) {
			front = new LinearNode<T>(element, front);
		}
		else {
			LinearNode<T> previous = getNode(index - 1);
			LinearNode<T> newNode = new LinearNode<T>(element,
					previous.getNext());
			previous.setNext(newNode);
		}
		count++;
	}

	@Override
	public void add(T element) {
		if(element == null && !allowNullElement)
		{
			throw new IllegalArgumentException("Null element is not allowed to add");
		}
		
		if (count == 0) {
			front = new LinearNode<T>(element, front);
		}
		LinearNode<T> previous = getNode(count - 1);
		LinearNode<T> newNode = new LinearNode<T>(element);
		previous.setNext(newNode);
		count++;
	}

	@Override
	public void set(int index, T element) {
		if (index < 0 || index > count - 1) {
			throw new IndexOutOfBoundsException();
		}

		getNode(index).setElement(element);
	}

	@Override
	public T get(int index) {
		if (index < 0 || index > count - 1) {
			throw new IndexOutOfBoundsException();
		}
		return getNode(index).getElement();
	}

	@Override
	public T remove(int index) {

		if (index < 0 || index > count - 1) {
			throw new IndexOutOfBoundsException();
		}
		T temp = getNode(index).getElement();
		if (index == 0) {

			front = getNode(index + 1);
			count--;
		}

		else {
			LinearNode<T> previous = getNode(index - 1);
			previous.setNext(getNode(index + 1));
			count--;
		}
		return temp;
	}

	@Override
	public T remove(T element) {

		if(!(contains(element)))
		{
			throw new IllegalStateException();
		}
		
		T  temp = null;

		for (int i = 0; i < count; i++) {

			if (get(i)==null || get(i).equals(element)) {
				if(i==0){
					temp=get(i);
					front = getNode(i+1);
					count--;
					break;
				}
				else if(i == count-1){
					temp = get(i);
					getNode(i-1).setNext(null);
					count--;
					break;
					
					
				}
				else
					temp = get(i);
				LinearNode<T> previous = getNode(i-1);
						previous.setNext(getNode(i+1));
						count--;
						break;
			}
		}
		return temp;
	}

	@Override
	public int indexOf(T element) {

		for (int i = 0; i < count - 1; i++) {
			if(get(i) != null && get(i).equals(element))
			{
				return i;
			}
			if (get(i) == null && get(i)==element) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public boolean contains(T element) {
		for (int i = 0; i < count; i++) {
			if(getNode(i).getElement()!=null)
			{
				if (getNode(i).getElement().equals(element))
					return true;
			}
			else if(getNode(i).getElement()==null)
			{
				if(getNode(i).getElement()==element)
					return true;
			}
		}
		return false;
	}
	@Override
	public boolean isEmpty() {

		return getNode(0) == null;
	}

	@Override
	public int size() {

		return count;
	}

}
