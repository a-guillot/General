package Set;

import util.LinearNode;


public class DoubleNode<T> {
private T element;
	
	private LinearNode<T> previous;
	private LinearNode<T> next;
	
	public DoubleNode() {
		element = null;
		previous = null;
		next = null;
	}
	
	public DoubleNode(T value) {
		element = value;
	}
	
	public DoubleNode(T value, LinearNode<T> previous, LinearNode<T> next) {
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

	public LinearNode<T> getPrevious() {
		return previous;
	}

	public void setPrevious(LinearNode<T> previous) {
		this.previous = previous;
	}

	public LinearNode<T> getNext() {
		return next;
	}

	public void setNext(LinearNode<T> next) {
		this.next = next;
	}
}
