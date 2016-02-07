package BinaryTree;

import java.util.Iterator;

public interface BinaryTreeADT<T> {

	/**
	 * Returns a reference to the root element
	 * @return the root
	 */
	public T getRoot();
	
	/**
	 * Returns true if no element
	 * @return true if no element
	 */
	public boolean isEmpty();
	
	/**
	 * Returns the number of elements in this binary tree
	 * @return number of elements
	 */
	public int size();
	
	/**
	 * Returns true if the tree contains this element
	 * @param target element to be searched
	 * @return true if the parameter is found
	 */
	public boolean contains(T target);
	
	/**
	 * Returns a reference to the specified element if it
	 * is found in this binary tree. Exception if not found
	 * @param targetElement the element being sought
	 * @return the reference to this element
	 */
	public T find(T targetElement);
	
	/**
	 * Performs an inorder traversal on this binary tree by calling an
	 * overloaded, recursive inorder method that starts with the root
	 * @return an iterator of this tree
	 */
	public Iterator<T> iteratorInOrder();
	
	/**
	 * Performs a preorder traversal on this binary tree by calling an
	 * overloaded, recursive preorder method that starts with the root
	 * @return an iterator of this tree
	 */
	public Iterator<T> iteratorPreOrder();
	
	/**
	 * Performs a postorder traversal on this binary tree by calling an
	 * overloaded, recursive postorder method that starts with the root
	 * @return an iterator of this tree
	 */
	public Iterator<T> iteratorPostOrder();
}
