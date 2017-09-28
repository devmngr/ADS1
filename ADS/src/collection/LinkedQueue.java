package collection;

public class LinkedQueue<T> implements QueueADT<T>{

	
	private int count;
	private LinearNode<T> rear;
	private LinearNode<T> front;
	private boolean allowNullElement = false;

	
	public LinkedQueue(boolean allowNullElement)
	{
		count=0;
		rear = new LinearNode<T>();
		front = new LinearNode<T>();
		this.allowNullElement = allowNullElement;
	}
	public String toString()
	{
		String str = "";
		LinearNode<T> current = new LinearNode<T>();
		current = front;

		for (int i = 0; i < count; i++) {
			str += current.getElement();
			current = current.getNext();
			if (i < count - 1) {
				str += ", ";
			}
		}

		return str;
	}
	public LinearNode<T> getNode(int index)
	{LinearNode<T> temp = new LinearNode<T>();
	
	for (int i = 0; i < index; i++) {
		temp = temp.getNext();
	}
		return temp;
	}
	@Override
	public void enqueue(T element) {
		
		if(element == null && !allowNullElement)
		{
			throw new IllegalArgumentException("Null elements not allowed");
		}
		 if (count == 0)
		{
			front.setElement(element);
			front.setNext(rear);
			rear.setNext(front);
			rear=front;
			
		}
		 else{
			 LinearNode<T> temp = new LinearNode<T>();
				temp.setElement(element);
				
				rear.setNext(temp);
				temp.setNext(front);
				rear = temp;
		 }
		 count++;
			
		
	}
	@Override
	public T dequeue() {
		if (count == 0)
		{
			throw new IllegalStateException("Queue is empty");
		}		
		T temp = front.getElement();
		front = front.getNext();				
		count--;		
		return temp;		
	}
	@Override
	public T first() {
		if(count == 0)
		{
			throw new IllegalStateException("Queue is empty");
		}
		
		return front.getElement();
	}
	@Override
	public int indexOf(T element) {
		if (count == 0) {
			throw new IllegalStateException("Queue was empty");
		}
		if (element == null && !allowNullElement) {
			throw new IllegalArgumentException("Null elements not allowed");
		}
		
		LinearNode<T> temp = new LinearNode<>();
		temp = front;
		for (int i = 0; i < count; i++) {
			if(element == temp.getElement())
			{
				return i;
			}
			temp = temp.getNext();		
		}
		return -1;		
	}
	@Override
	public boolean isEmpty() {
		return count==0;
	}
	@Override
	public int size() {
		
		return count;
	}

	
	
	
	
}
