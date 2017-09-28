package collection;

public class SizeSafeArrayQueue<T> implements QueueADT<T> {

	private BoundedArrayQueue<T> queue;
	private int capacity;

	public SizeSafeArrayQueue() {
		capacity = 5;
		queue = new BoundedArrayQueue<T>(capacity);
	}

	public String toString() {
		return queue.toString();
	}

	@Override
	public void enqueue(T element) {

		if (capacity == queue.size()) {

			BoundedArrayQueue<T> newArray = new BoundedArrayQueue<T>(
					queue.size() * 2);
			for (int i = 0; i < queue.size(); i++) {
				newArray.enqueue(queue.dequeue());
			}

			queue = newArray;
		}
		queue.enqueue(element);

	}

	@Override
	public T dequeue() {
		return queue.dequeue();
	}

	@Override
	public T first() {
		return queue.first();
	}

	@Override
	public int indexOf(T element) {
		return queue.indexOf(element);
	}

	@Override
	public boolean isEmpty() {
		return queue.isEmpty();
	}

	@Override
	public int size() {
		return queue.size();
	}

}
