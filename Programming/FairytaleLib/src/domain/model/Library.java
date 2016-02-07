package domain.model;

import java.util.ArrayList;

import util.AlreadyBookedException;
import util.ItemNotFoundException;
import util.NotBookedException;

/**
 * Singleton class containing items, reservations,
 * and persons.
 */
public class Library {

  /**
   * Only instance of the Library class.
   */
  private static Library instance;

  /**
   * Unique identifier that will help
   * to make every id unique.
   */
  private int nextIsbn;

  /**
   * List of every person that has already
   * booked an item in this library.
   */
  private ArrayList<Person> listPerson;

  /**
   * List of all the current reservations.
   */
  private ArrayList<Reservation> listReservation;

  /**
   * List of every item possessed by the library,
   * booked or not.
   */
  private ArrayList<Item> listItem;

  /**
   * Private constructor to make sure that nobody
   * can create one without using the getInstance()
   * method.
   */
  private Library() {
    this.nextIsbn = 0;
    listPerson = new ArrayList<Person>();
    listReservation = new ArrayList<Reservation>();
    listItem = new ArrayList<Item>();
  }
  
  /**
   * Static method that will be used to create
   * the only instance of the Library class.
   * It only gets instantiated when needed.
   * @return the unique Library instance
   */
  public static Library getInstance() {
    if (instance == null)
      instance = new Library();

    return instance;
  }

  /**
   * Method adding an item to the library
   * @param item item to be added to the library
   */
  public void addItem(Item item) {
    listItem.add(item);
  }

  /**
   * Method removing an item from the library using
   * its unique identifier.
   * 
   * @param isbn identifier of the item to be deleted
   * @throws ItemNotFoundException case where the inputed
   *    id wasn't correct.
   */
  public void removeItem(int isbn) throws ItemNotFoundException {
    // false will cause an error
    Boolean exists = false;
    
    // iterating over the list to find the right item
    for (Item item : listItem) {
      if (item.getIsbn() == isbn) {
        listItem.remove(item);
        exists = true;
        break;
      }
    }
    
    // case where the item wasn't in the list
    if (!exists)    
      throw new ItemNotFoundException();
  }

  /**
   * Method allowing you to return an item, destroying the reservation
   * it's currently part of and reseting its state to not booked
   * 
   * @param isbn unique identifier of the item
   * @throws NotBookedException case where the item wasn't booked before
   * @throws ItemNotFoundException case where the item couldn't be fine
   */
  public void returnItem(int isbn) throws NotBookedException, ItemNotFoundException {
    // item that corresponds to the isbn
    Item target = null;
    
    // loop iterating on every item to find
    // the corresponding item.
    for (Item item : listItem) {
      if (item.getIsbn() == isbn) {
        target = item;
      }
    }

    // case where the loop couldn't find the
    // corresponding item.
    if (target == null) {
      throw new ItemNotFoundException();
    } 
    else {  // case where the item was found
      // if the item's state is the correct one
      if (target.getIsBooked()) {
        // if this item is present in the reservation list
        // it means that it is currently booked.
        for (Reservation res : listReservation) {
          if (res.getItem().equals(target)) {
            // in which case we remove this reservation
            listReservation.remove(res);
            break;
          }
        }
        // and reset its state to not booked
        target.setIsBooked(false);
      } 
      else { // case where the operation wasn't successful because the item wasn't booked before
        throw new NotBookedException();
      }
    }

  }

  /**
   * Method allowing you to associate a person to an item within a reservation.
   * The item needs to be free before being borrowed.
   * 
   * @param person person reserving the item
   * @param isbn identifier of the item to be booked
   * @throws AlreadyBookedException if the item is already booked
   * @throws ItemNotFoundException if the item is not found
   */
  public void createReservation(Person person, int isbn) throws AlreadyBookedException, ItemNotFoundException {
    // item that corresponds to the isbn
    Item res = null;
    
    // should stay to false, else an AlreadyBookedException is raised
    boolean borrowed = false;
    
    // should be true, else an ItemNotFoundException is raised
    boolean found = false;

    // iteration through the list of item to find if an item
    // with the good identifier exists, and if its state is
    // the good one
    for (Item item : listItem) {
      if (item.getIsbn() == isbn) {
        res = item;
        found = true;
        if (res.getIsBooked())
          borrowed = true;
      }
    }

    // case where the for loop was unsuccessful to find the item
    if (!found)
      throw new ItemNotFoundException();
    
    if (!borrowed) {             // case where the item is found and on the right state
      // if the person isn't on the server yet, we add him
      if (!listPerson.contains(person))
        listPerson.add(person);

      // creating and adding a reservation to the list
      listReservation.add(new Reservation(person, res));
      
      // if didn't raise an exception, set the item state to booked
      res.setIsBooked(true);
    } else {                    // case where the item had already been booked
      throw new AlreadyBookedException();
    }
  }

  /**
   * Returns the unique id
   * @return unique id
   */
  public int getNextIsbn() {
    return this.nextIsbn;
  }

  public ArrayList<Person> getListPerson() {
    return this.listPerson;
  }

  public ArrayList<Item> getListItem() {
    return this.listItem;
  }

  public ArrayList<Reservation> getListReservation() {
    return this.listReservation;
  }

  public void setIsbn(int isbn) {
    this.nextIsbn = isbn;
  }

  public void setListPerson(ArrayList<Person> list) {
    this.listPerson = list;
  }

  public void setListItem(ArrayList<Item> list) {
    this.listItem = list;
  }

  public void setListReservation(ArrayList<Reservation> list) {
    this.listReservation = list;
  }



}
