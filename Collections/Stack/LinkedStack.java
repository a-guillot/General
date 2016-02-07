package Stack;

import util.EmptyCollectionException;
import util.LinearNode;

public class LinkedStack<T> implements StackADT<T> {

	/**
	 * Indicates number of elements stored
	 */
	private int count;
	
	/**
	 * Pointer to top of stack
	 */
	private LinearNode<T> top;
	
	/**
	 * Creates an empty LinkedStack
	 */
	public LinkedStack() {
		count = 0;
		top = null;
	}
	
	@Override
	/**
	 * Adds the specified element to the top of this stack
	 * @param element element to be pushed on stack
	 */
	public void push(T element) {
		LinearNode<T> temp = new LinearNode<T>(element);
		
		temp.setNext(top); // we link it to the rest of the stack
		top = temp;		   // this becomes the top of the stack
		count++;
	}

	@Override
	/**
	 * Removes the element at the top of the stack and returns a
	 * reference to it. Throws an EmptyCollectionException if the
	 * stack is empty.
	 * 
	 * @return T element from the top of the stack
	 * @throws EmptyStackException on pop from empty stack
	 */
	public T pop() throws EmptyCollectionException {
		if (isEmpty())
			throw new EmptyCollectionException("Stack");
		
		T result = top.getElement();
		top = top.getNext();
		count--;
		
		return result;
	}

	@Override
	/**
	 * Returns the element at the top of the stack without
	 * removing it
	 */
	public T peek() throws EmptyCollectionException {
		return top.getElement();
	}

	@Override
	public boolean isEmpty() {
		return (size() == 0);
	}

	@Override
	public int size() {
		return count;
	}


}
