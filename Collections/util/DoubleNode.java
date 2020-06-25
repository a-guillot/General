package util;

public class DoubleNode<T> {

	private T element;
	
	private DoubleNode<T> previous;
	private DoubleNode<T> next;
	
	public DoubleNode() {
		element = null;
		previous = null;
		next = null;
	}
	
	public DoubleNode(T value) {
		element = value;
	}
	
	public DoubleNode(T value, DoubleNode<T> previous, DoubleNode<T> next) {
		element = value;
		this.previous = previous;
		this.next = next;
	}

	public T getElement() {
		return element;
	}

	public void setElement(T element) {
		this.element = element;
	}

	public DoubleNode<T> getPrevious() {
		return previous;
	}

	public void setPrevious(DoubleNode<T> previous) {
		this.previous = previous;
	}

	public DoubleNode<T> getNext() {
		return next;
	}

	public void setNext(DoubleNode<T> next) {
		this.next = next;
	}
}
