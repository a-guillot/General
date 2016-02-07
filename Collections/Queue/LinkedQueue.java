package Queue;

import util.EmptyCollectionException;
import util.LinearNode;

/**
 * Queue implementation using links
 * @author Andréas
 *
 * @param <T>
 */
public class LinkedQueue<T> implements QueueADT<T> {

	/**
	 * number of values in the queue
	 */
	private int count;
	
	/**
	 * first and last items of the queue
	 */
	private LinearNode<T> front, rear;
	
	/**
	 * Creates an empty queue
	 */
	public LinkedQueue() {
		count = 0;
		front = rear = null;
	}
	
	@Override
	/**
	 * Adds the specified element to the rear of the queue
	 * @param element that will be added to the queue
	 */
	public void enqueue(T element) {
		LinearNode<T> node = new LinearNode<T>(element);
		
		if (isEmpty())			// if empty, the new element becomes the front one
			front = node;
		else					// else, the last's next becomes the new element
			rear.setNext(node);
		
		rear = node;			// and the element becomes the last one
		count++;
	}

	@Override
	/**
	 * Removes the element at the front of this queue and returns a
	 * reference to it. Throws an EmptyCollectionException if the
	 * queue is empty.
	 * 
	 * @return element at the front of the queue
	 * @throws EmptyCollectionException if queue is empty
	 */
	public T dequeue() throws EmptyCollectionException {
		if (isEmpty())
			throw new EmptyCollectionException("Queue");
		
		T result = front.getElement();
		front = front.getNext();
		count--;
		
		if (isEmpty())
			rear = null;
		
		return result;
	}

	@Override
	public T first() throws EmptyCollectionException {
		return front.getElement();
	}

	@Override
	public boolean isEmpty() {
		return (size() == 0);
	}

	@Override
	public int size() {
		return count;
	}

	@Override
	public int indexOf(T element) {
		// TODO Auto-generated method stub
		return 0;
	}

}
