package ListSDJ;

public class ArrayList<T> implements ListADT<T> {

	private int count;
	private T[] list;
	private final static int DEFAULT_CAPACITY = 100;
	
	public ArrayList() {
		count = 0;
		list = (T[]) new Object[DEFAULT_CAPACITY];
	}
	
	public ArrayList(int initialCapacity) {
		count = 0;
		list = (T[]) new Object[initialCapacity];
	}
	
	@Override
	public void add(int index, T element) throws IllegalStateException,
			IndexOutOfBoundsException, IllegalArgumentException {
		if (element == null)
			throw new IllegalArgumentException("null is not accepted");
		if (count == list.length)
			throw new IllegalStateException("the list is full");
		if (index < 0 || index > count)
			throw new IndexOutOfBoundsException();
		
		count++;
		
		for (int i = (index); i < count; i++) {
			list[i+1] = list[i];
		}
		list[index] = element;
	}

	@Override
	public void add(T element) throws IllegalStateException,
			IllegalArgumentException {
		if (element == null)
			throw new IllegalArgumentException("null is not accepted");
		if (count == list.length)
			throw new IllegalStateException("the list is full");
		
		list[count++] = element;
		
	}

	@Override
	public boolean contains(T element) {
		boolean result = false;
		
		for (int i = 0; i < count; i++) {
			if (list[i].equals(element)) {
				result = true;
				break;
			}
		}
		return result;
	}

	@Override
	public T get(int index) throws IndexOutOfBoundsException {
		if (index < 0 || index > count)
			throw new IndexOutOfBoundsException();
		
		return list[index];
	}

	@Override
	public int indexOf(T element) {
		for (int i = 0; i < count; i++) {
			if (list[i].equals(element))
				return i;
		}
		return -1;
	}

	@Override
	public T remove(int index) throws IndexOutOfBoundsException {
		if (index < 0 || index > count)
			throw new IndexOutOfBoundsException();
		
		T result = list[index];
		count--;
		
		for (int i = index; i < count; i++) {
			list[i] = list[i+1];
		}
		
		return result;
	}

	@Override
	public T remove(T element) {
		for (int i = 0; i < count; i++) {
			if (list[i].equals(element)) {
				
				T result = list[i];
				count--;
				
				for (int j = i; i < count; i++) {
					list[i] = list[i+1];
				}
				
				return result;
				
			}
		}
		return null;
	}

	@Override
	public void set(int index, T element) throws IndexOutOfBoundsException,
			IllegalArgumentException {
		if (element == null)
			throw new IllegalArgumentException("null is not accepted");
		if (index < 0 || index > count)
			throw new IndexOutOfBoundsException();
		
		list[index] = element;
		
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
