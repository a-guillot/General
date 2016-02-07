package Iterators;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayIterator<T> implements Iterator<T> {

	private int count;
	private int current;
	private T[] items;
	
	/**
	 * Sets up the iterator using the specified items
	 * @param collection the collection to create the iterator for
	 * @param size the size of the collection
	 */
	public ArrayIterator(T[] collection, int size) {
		items = collection;
		count = size;
		current = 0;
	}
	
	/**
	 * Returns true if this iterator has at least one more element
	 * to deliver in the iteration
	 */
	@Override
	public boolean hasNext() {
		return (current < count);
	}

	/**
	 * Returns the next element in the iteration. If there are no
	 * more elements, a NoSuchElementException is thrown.
	 * @return the next element in the iteration
	 */
	@Override
	public T next() {
		if (!hasNext())
			throw new NoSuchElementException();
		
		current++;
		
		return items[current - 1];
	}
}
