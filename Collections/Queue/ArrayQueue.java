package Queue;

import util.EmptyCollectionException;

public class ArrayQueue<T> implements QueueADT<T> {

	private final int DEFAULT_CAPACITY = 100;
	private int front;
	private int rear;
	private int count;
	private T[] queue;
	
	public ArrayQueue() {
		front = 0;
		rear = 0;
		count = 0;
		queue = (T[]) new Object[DEFAULT_CAPACITY];
	}
	
	public ArrayQueue(int initialCapacity) {
		front = rear = count = 0;
		queue = (T[]) new Object[initialCapacity];
	}
	
	@Override
	public void enqueue(T element) {

		if (size() == queue.length)
			expandCapacity();
		
		queue[rear] = element;
		rear = (rear + 1)% queue.length;
		count++;

	}

	private void expandCapacity() {
		T[] larger = (T[]) new Object[queue.length * 2];

		for (int index = 0; index < queue.length; index++) {
			larger[index] = queue[index];
		}

		queue = larger;

	}

	@Override
	public T dequeue() throws IllegalStateException {
		if (isEmpty())
			throw new IllegalStateException("array queue");
		
		T result = queue[front];
		queue[front] = null;
		front = (front + 1)% queue.length;
		count--;
		
		return result;
	}

	@Override
	public T first() throws IllegalStateException {
		if (isEmpty())
			throw new IllegalStateException("array queue");
		
		return queue[front];
	}

	@Override
	public int indexOf(T element) {
		for (int i = size(); i > 0; i--) {
			if (element.equals(queue[i]))
				return i;
		}
		return -1;
	}

	@Override
	public boolean isEmpty() {
		return (count == 0);
	}

	@Override
	public int size() {
		return count;
	}

}
