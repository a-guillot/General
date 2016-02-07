package domain.mediator;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class ClientModelManager extends Observable implements ModelInterface {

  /**
   * Used to connect to the server
   */
  private Proxy proxy;

  /**
   * List of client views
   */
  private ArrayList<Observer> observers;

  /**
   * Creates the instance and connects to the server
   */
  public ClientModelManager() {
    observers = new ArrayList<Observer>();
    proxy = new Proxy(this);
    proxy.login();
  }
  
  /**
   * Destroys every observer
   */
  public void logout() {
    this.deleteObservers();
  }

  /**
   * Removes an item from the library
   */
  public void remove(int isbn) {
    proxy.remove(isbn);
  }

  /**
   * Searches an item on the library
   */
  public void searchByIsbn(int isbn) {
    proxy.searchByIsbn(isbn);
  }

  /**
   * Adds an item to the library
   */
  public void add(String informations) {
    proxy.add(informations);
  }

  /**
   * Lists everything that is on the server
   */
  public void itemList() {
    proxy.itemList();
  }

  /** 
   * Searches an item with its name
   * Can have multiple results
   */
  public void searchByName(String name) {
    proxy.searchByName(name);
  }

  /**
   * Books an item for a duration depending on
   * the type of user and the age of the item
   */
  @Override
  public void book(String information) {
    proxy.book(information);
  }

  /**
   * Returns an item to the library
   */
  @Override
  public void returnItem(int isbn) {
    proxy.returnItem(isbn);
  }

  /**
   * Adds an observer
   */
  public void addObserver(Observer o) {
    observers.add(o);
  }

  /**
   * Notifies every observer that is in the list
   */
  public void notifyObservers(Object arg) {
    for (Observer o : observers)
      o.update(this, arg);
  }

  /**
   * Deletes one particular observer
   */
  public void deleteObserver(Observer o) {
    observers.remove(o);
  }

  /**
   * Deletes every observer
   */
  public void deleteObservers() {
    observers.clear();
  }

  public Proxy getProxy() {
    return proxy;
  }
}
