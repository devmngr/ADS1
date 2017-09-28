
package collection;

public class BoundedArrayQueue<T> implements QueueADT<T>

{
	private int front;
	private int count;
	private T[] queue;
	
	public BoundedArrayQueue()
	{
		queue = (T[]) new Object[0];
		front =0;
		count = 0;
	}
	
	public BoundedArrayQueue(int capacity)
	{
		queue = (T[]) new Object[capacity];
		count = 0;
		front =0;
	}	
	public String toString()
	{
		String str = "{";
			for(int i = 0; i < count; i++) { 
				int index = (front+i) % queue.length;
				str += queue[index];
				if(i < count -1) {
					str += (", ");
				}
			}
			return str + "}";		
	}

	@Override
	public void enqueue(T element) throws IllegalStateException {
		if(element==null)
		{
			throw new IllegalArgumentException("Null not allowed");
		}
		else if(count==queue.length)
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
		if(element == null)
		{
			return -1;
		}
			for (int i=0; i<count; i++)
			{
				int index = (front + i) % queue.length;	
				if(element.equals(queue[index]))
				{
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
