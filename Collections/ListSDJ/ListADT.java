package ListSDJ;

public interface ListADT<T> {

	public void add(int index, T element) throws IllegalStateException, IndexOutOfBoundsException, IllegalArgumentException;
	public void add(T element) throws IllegalStateException, IllegalArgumentException;
	public boolean contains(T element);
	public T get(int index) throws IndexOutOfBoundsException;
	public int indexOf(T element);
	public boolean isEmpty();
	public T remove(int index) throws IndexOutOfBoundsException;
	public T remove(T element);
	public void set(int index, T element) throws IndexOutOfBoundsException, IllegalArgumentException;
	public int size();
}
