package collection;

public class ArrayQueue<T> implements QueueADT<T> {

	private static final int DEFAULT_CAPACITY = 100;
	private int front;
	private int count;
	private T[] queue;
	////
	private boolean allowNullElement;

	public ArrayQueue(boolean allowNullElement) {
		front = 0;
		count = 0;
		queue = (T[]) new Object[DEFAULT_CAPACITY];
		this.allowNullElement = allowNullElement;
	}

	public ArrayQueue(int initialCapacity, boolean allowNullElement) {
		front = 0;
		count = 0;
		queue = (T[]) new Object[initialCapacity];
		this.allowNullElement = allowNullElement;
	}

	public String toString() {
		String str = "{";
		for (int i = 0; i < count; i++) {
			int index = (count-1)%queue.length;
			str += queue[index];
			if (i < count - 1) {
				str += (", ");
			}
		}
		return str + "}";
	}


	private void expandCapacity() {

		T[] newQueue = (T[]) new Object[queue.length * 2];
		for (int i = 0; i < queue.length; i++) {
			newQueue[i] = queue[i];

		}
		queue = newQueue;
	}

	@Override
	public void enqueue(T element) throws IllegalStateException {
		if(element ==null && !allowNullElement)
		{
			throw new IllegalArgumentException("Null is not allowed");
		}
		else if(count ==queue.length)
		{
			throw new IllegalStateException("Queue is full");
		}
		
		queue[(front+count)%queue.length] = element;
		count++;
		
	}

	@Override
	public T dequeue() {
		if (count == 0)
		{
			throw new IllegalStateException("Queue is empty");
		}
		T result = queue[front];
		queue[front] = null;
		front = (++front)% queue.length;
		count--;
		
		return result;
	}

	@Override
	public T first() {
		if(count==0)
		{
			throw new IllegalStateException("Queue is empty");
		}
		return queue[front];
	}

	@Override
	public int indexOf(T element) {
		if (element == null) {
			return -1;
		}
		for (int i = 0; i < count; i++) {
			int index = (front + i) % queue.length;
			if (element.equals(queue[index])) {
				return i;
			}
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
