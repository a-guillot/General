package Set;

import java.util.Iterator;
import java.util.NoSuchElementException;

import Iterators.ArrayIterator;

public class ArraySet<T> implements SetADT<T> {

	private static final int DEFAULT_CAPACITY = 100;
	private static final int NOT_FOUND = -1;
	private int count;
	private T[] contents;
	
	public ArraySet() {
		count = 0;
		contents = (T[]) new Object[DEFAULT_CAPACITY];
	}
	
	public ArraySet(int initialCapacity) {
		if (initialCapacity < 0)
			throw new IllegalArgumentException();
		
		count = 0;
		contents = (T[]) new Object[initialCapacity];
	}
	@Override
	public void add(T element) {
		if (!contains(element)) {
			if (size() == contents.length)
				expandCapacity();
			
			contents[count] = element;
			count++;
		}
	}

	@Override
	public void addAll(SetADT<T> set) {
		Iterator<T> scan = set.iterator();
		
		while (scan.hasNext())
			add(scan.next());
	}
	
	private void expandCapacity() {
		T[] larger = (T[]) new Object[contents.length * 2];
		
		for (int i = 0; i < contents.length; i++) {
			larger[i] = contents[i];
		}
		
		contents = larger;
	}

	@Override
	public T remove(T element) {
		int search = NOT_FOUND;
		
		if (isEmpty())
			throw new IllegalStateException();
		
		for (int index = 0; index < count && search == NOT_FOUND; index++) {
			if (contents[index].equals(element))
				search = index;
		}
		
		if (search == NOT_FOUND)
			throw new NoSuchElementException();
		
		T result = contents[search];
		
		contents[search] = contents[count - 1];
		contents[count - 1] = null;
		count--;
		
		return result;
	}

	@Override
	public SetADT<T> union(SetADT<T> set) {
		ArraySet<T> both = new ArraySet<>();
		
		for (int index = 0; index < size(); index++) {
			both.add(contents[index]);
		}
		
		Iterator<T> scan = set.iterator();
		
		while (scan.hasNext())
			both.add(scan.next());
		
		return both;
	}

	@Override
	public boolean contains(T element) {
		int search = NOT_FOUND;
		
		for (int index = 0; index < count && search == NOT_FOUND; index++) {
			if (contents[index].equals(element))
				search = index;
		}
		
		return (search != NOT_FOUND);
	}

	@Override
	public boolean equals(SetADT<T> set) {
		boolean result = false;
		
		ArraySet<T> temp1 = new ArraySet<>();
		ArraySet<T> temp2 = new ArraySet<>();
		T obj;
		
		if (size() == set.size()) {
			temp1.addAll(this);
			temp2.addAll(set);
			
			Iterator<T> scan = set.iterator();
			
			while (scan.hasNext()) {
				obj = scan.next();
				
				if (temp1.contains(obj)) {
					temp1.remove(obj);
					temp2.remove(obj);
				}
			}
			result = (temp1.isEmpty() && temp2.isEmpty());
		}
		
		return result;
	}

	@Override
	public boolean isSubset(SetADT<T> set) {
		SetADT<T> temp = new ArraySet<>();
		temp.addAll(this);
		
		Iterator<T> scan = temp.iterator();
		T obj;
		
		while (scan.hasNext()) {
			obj = scan.next();
			
			if (set.contains(obj))
				temp.remove(obj);
		}
		return temp.isEmpty();
	}

	@Override
	public SetADT<T> intersection(SetADT<T> set) {
		SetADT<T> intersection = new ArraySet<>();
		
		Iterator<T> scan = set.iterator();
		T obj;
		
		while (scan.hasNext()) {
			obj = scan.next();
			
			if (contains(obj))
				intersection.add(obj);
		}
		
		return intersection;
	}

	@Override
	public boolean isEmpty() {
		return (size() == 0);
	}

	@Override
	public int size() {
		return count;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Iterator<T> iterator() {
		return (Iterator<T>) new ArrayIterator<T>(contents, count);
	}
}
