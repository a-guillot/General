package List;

import java.util.Iterator;

import util.ElementNotFoundException;

public class ArrayList<T> implements ListADT<T>, Iterable<T> {

	protected final int DEFAULT_CAPACITY = 100;
	private final int NOT_FOUND = -1;
	protected int rear;
	protected T[] list;
	
	
	public ArrayList() {
		rear = 0;
		list = (T[]) new Object[DEFAULT_CAPACITY];
	}
	
	public ArrayList(int initialCapacity) {
		rear = 0;
		list = (T[]) new Object[initialCapacity];
	}
	
	@Override
	public T removeFirst() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T removeLast() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T remove(T element) throws ElementNotFoundException {
		T result;
		int index = find(element);
		
		if (index == NOT_FOUND)
			throw new ElementNotFoundException("List");
		
		result = list[index];
		rear--;
		
		// shift
		for (int scan = index; scan < rear; scan++) {
			list[scan] = list[scan+1];
		}
		
		list[rear] = null;
		
		return result;
	}

	private int find(T element) {
		int scan = 0;
		int result = NOT_FOUND;
		boolean found = false;
		
		while (!isEmpty()) {
			while (!found && scan < rear) {
				if (element.equals(list[scan]))
					found = true;
				else scan++;
			}
		}
		if (found)
			result = scan;
		
		return result;
	}

	@Override
	public T first() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T last() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean contains(T target) {
		return (find(target) != NOT_FOUND);
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Iterator<T> iterator() {
		return new ArrayIterator<T>(list, rear);
	}

}
