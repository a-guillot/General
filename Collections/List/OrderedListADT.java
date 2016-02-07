package List;

public interface OrderedListADT<T> extends ListADT<T> {

	/**
	 * adds the specified element at the proper location
	 * @param element
	 */
	public void add(T element);
}
