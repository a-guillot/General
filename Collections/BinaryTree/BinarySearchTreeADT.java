package BinaryTree;

public interface BinarySearchTreeADT<T> extends BinaryTreeADT<T> {

  /**
   * Adds the specified element at the proper location.
   * @param element element to be added
   */
  public void addElement(T element);
  
  /**
   * Removes and returns the specified element from the tree.
   * @param targetElement element to be removed
   * @return the element removed
   */
  public T removeElement(T targetElement);
  
  /**
   * Removes all occurences of the specified element to this tree.
   * @param targetElement element to be removed
   */
  public void removeAllOccurences(T targetElement);
  
  /**
   * Removes and returns the smallest element from this tree.
   * @return the smallest element from the tree
   */
  public T removeMin();
  
  /**
   * Removes and returns the largest element from the tree.
   * @return the largest element
   */
  public T removeMax();
  
  /**
   * Returns a reference to the smallest element.
   * @return reference of the smallest
   */
  public T findMin();
  
  /**
   * Returns a ref to the largest.
   * @return reference to the largest   
   */
  public T findMax();
  
}
