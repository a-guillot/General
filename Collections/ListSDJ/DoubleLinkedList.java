package ListSDJ;

import util.DoubleNode;

public class DoubleLinkedList<T> implements ListADT<T> {

	private int count;
	
	private DoubleNode<T> front;
	
	public DoubleLinkedList() {
		count = 0;
		front = new DoubleNode<T>(null, front, front);
	}
	
	@Override
	public void add(int index, T element) throws IllegalStateException,
			IndexOutOfBoundsException, IllegalArgumentException {

		if (element == null)
			throw new IllegalArgumentException();

		if (index < 0 || index > count)
			throw new IndexOutOfBoundsException();

		DoubleNode<T> previousNode, nextNode;

		if (index == 0) { // we want it in the first place

			// the previous is the last
			if (!isEmpty())
				previousNode = getNode(count - 1);
			else
				previousNode = front;
			// the next is the front
			nextNode = getNode(0);

			// it becomes the front
			front = new DoubleNode<T>(element, previousNode, nextNode);

			count++;
		}
		else if (index == (count)) { // we want to place it at the last place
			// that's the job of add without index
			add(element);
		}
		else {
			// general case
			previousNode = getNode(index - 1);
			nextNode = getNode(index); // because it's currently there
			
			// insertion
			DoubleNode<T> node = new DoubleNode<T>(element, previousNode, nextNode);
			previousNode.setNext(node);
			nextNode.setPrevious(node);
			count++;
		}
	}
	

	@Override
	public void add(T element) throws IllegalStateException,
			IllegalArgumentException {
		
		if (element == null)
			throw new IllegalArgumentException();
		else {
			if (isEmpty()) {
				front.setElement(element);
			} else {
				DoubleNode<T> previous = getNode(count - 1);
				DoubleNode<T> node = new DoubleNode<T>(element, previous, front);
				previous.setNext(node);
				front.setPrevious(node);
			}
		}
		count++;
	}

	@Override
	public boolean contains(T element) {
		return (indexOf(element) != -1);
	}

	@Override
	public T get(int index) throws IndexOutOfBoundsException {
		if (index < 0 || index > count)
			throw new IndexOutOfBoundsException();
		
		return getNode(index).getElement();
	}

	@Override
	public int indexOf(T element) {
		int index = -1;
		
		DoubleNode<T> node = front;
		
		for (int i = 0; i < count; i++) {
			if (node.getElement() == element)
				index = i;
			node = node.getNext();
		}
		return index;
	}

	@Override
	public T remove(int index) throws IndexOutOfBoundsException {
		if (index < 0 || index > count)
			throw new IndexOutOfBoundsException();
		
		DoubleNode<T> previousNode, nextNode;
		previousNode = nextNode = null;
		T res = null;
		
		if (index == 0) {
			// when you want to remove the first element
			
			// you get the previous and the next elements
			previousNode = front.getPrevious();
			nextNode = front.getNext();
			
			// you get the value
			res = front.getElement();
			
			// you change the values of next and last
			previousNode.setNext(nextNode);
			nextNode.setPrevious(previousNode);
			
			// the next node becomes the front
			front = nextNode;		
		}
		else if (index == (count - 1)) {
			// you try to remove the last one
			
			nextNode = front;
			
			// the previous one is the previous of the one we want to delete
			previousNode = front.getPrevious().getPrevious();
			
			// you get the value
			res = front.getPrevious().getElement();
			
			// you change the values of next and last
			previousNode.setNext(nextNode);
			nextNode.setPrevious(previousNode);
		}
		else {
			DoubleNode<T> node = front;
			
			// we find the previous and the next
			previousNode = getNode(index - 1);
			nextNode = getNode(index + 1);
			
			// you change the values of next and last
			previousNode.setNext(nextNode);
			nextNode.setPrevious(previousNode);
		}
		
		count--;
		return res;
	}

	@Override
	public T remove(T element) {
		T res;
		int index = indexOf(element);
		if (index == -1)
			return null;
		else {
			count--;
			
			DoubleNode<T> node = front;
			for (int i = 0; i < index; i++) {
				node = node.getNext();
			}
			res = node.getElement();
			
			// now that we have the one we can check
			DoubleNode<T> previous = node.getPrevious();
			DoubleNode<T> next = node.getNext();
			
			previous.setNext(next);
			next.setPrevious(previous);
			
			return res;
		}
	}

	@Override
	public void set(int index, T element) throws IndexOutOfBoundsException,
			IllegalArgumentException {

		if (index < 0 || index > count)
			throw new IndexOutOfBoundsException();
		if (element == null)
			throw new IllegalArgumentException();
		
		DoubleNode<T> node = front;
		
		for (int i = 0; i < index; i++) {
			node = node.getNext();
		}
		node.setElement(element);
		
	}

	@Override
	public boolean isEmpty() {
		return (count == 0);
	}

	@Override
	public int size() {
		return count;
	}
	
	private DoubleNode<T> getNode(int index) throws IndexOutOfBoundsException {
		if (index < 0 || index > count) {
			throw new IndexOutOfBoundsException();
		}
		DoubleNode<T> node = front;
		
		for (int i = 0; i < index; i++) {
			node = node.getNext();
		}
		return node;
	}
}
