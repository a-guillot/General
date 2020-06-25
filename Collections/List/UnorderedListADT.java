package List;

public interface UnorderedListADT<T> extends ListADT<T> {

	/**
	 * Adds the specified element to the front of this list 
	 * @param element element to add
	 */
	public void addToFront(T element);
	
	/**
	 * Adds the specified element to the rear of the list
	 * @param element element to add
	 */
	public void addToRear(T element);
	
	/**
	 * Adds the element after the specified target
	 * @param element element to be added after the target
	 * @param target the target is the item that the element will be added after
	 */
	public void addAfter(T element, T target);
}
