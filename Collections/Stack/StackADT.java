package Stack;

import util.EmptyCollectionException;

/**
 * Defines the interfaces to a stack data structure
 * 
 * @author Andréas
 *
 */
public interface StackADT<T> {

  /**
   * Adds one element to the top of the stack
   * 
   * @param T element
   */
  public void push(T element);

  /**
   * Returns and returns the top element of this stack
   * 
   * @return T element removed from the top of the stack
   * @throws EmptyCollectionException
   */
  public T pop() throws EmptyCollectionException;

  /**
   * Returns without removing the top element of this stack
   * 
   * @return T element on top of the stack
   * @throws EmptyCollectionException
   */
  public T peek() throws EmptyCollectionException;

  /**
   * Returns true if this stack contains no element
   * 
   * @return boolean whether or not the stack is empty
   */
  public boolean isEmpty();

  /**
   * Returns the number of element in this stack
   * 
   * @return int number of element in this stack
   */
  public int size();

  /**
   * Returns a string representation of this stack
   * 
   * @return String representation on this stack
   */
  public String toString();
}
