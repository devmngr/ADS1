package collection;


////Tested-Status OK!
public class StackListBased<T> implements StackADT<T>{

	private LinkedList1<T> list;

	public StackListBased(boolean allowNullElement)
	{
		list = new LinkedList1<T>(allowNullElement);
	}
	
	public String toString()
	{
		return list.toString();
	}

	
	@Override
	public void push(T element) {
		
		list.add(0,element);
		
	}

	@Override
	public T pop() {
		T temp = list.get(0);
	      list.remove(0);
	      return temp;
		
	}

	@Override
	public T peek() {
		
		return list.get(0);
		
	}

	@Override
	public int indexOf(T element) {
		
		return list.indexOf(element);
		
	}

	@Override
	public boolean isEmpty() {
		
		return list.isEmpty();
		
	}

	@Override
	public int size() {
		return list.size();
	}

	
	
	
}
