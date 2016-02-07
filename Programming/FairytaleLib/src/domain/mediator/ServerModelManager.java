package domain.mediator;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Observable;
import java.util.Observer;

import util.AlreadyBookedException;
import util.ItemNotFoundException;
import util.NotBookedException;
import domain.model.*;

public class ServerModelManager extends Observable implements ModelInterface {

  private static final String DELIMITER = "=";
  /**
   * The access to the model classes
   */
  private Library library;
  
  /**
   * A list of observer for the implementation 
   * of the Observer Design Pattern.
   */
  ArrayList<Observer> observers;

  /**
   * Constructor of the class ServerModelManager
   * that starts a ServerConnectionThread to which
   * clients are going to connect.
   */
  public ServerModelManager() {
    library = Library.getInstance();
    observers = new ArrayList<Observer>();
    
    (new Thread(new ServerConnectionThread(this))).start();
  }


  /**
   * Method that will book an item from the library.
   * Decodes the information to make it understandable
   * and creates a reservation from the obtained info.
   * 
   * @param information String that contains the info
   *    about the person booking, and the isbn of the
   *    item this person wanted to book.
   */
  public void book(String information) {
    Person p;
    
    // the delimiter of our encoded sentence is =
    // example: andreas=mail@mail.com=student=10
    String[] info = information.split(DELIMITER);

    // person fields
    String name = info[0];
    String mail = info[1];
    
    // person subclass
    String type = info[2];
    
    // isbn of the item to be booked
    int isbn = Integer.parseInt(info[3]);

    // creation of the person with the corresponding rank
    if (type.equals("student"))
      p = new Student(name, mail);
    else
      p = new Lecturer(name, mail);

    // creation of the reservation
    try {                                   // successful case
      library.createReservation(p, isbn);
      this.notifyObservers("Reservation created for the item number " + isbn + ".");
    } 
    catch (AlreadyBookedException e) {      // unsuccessful case where the item is already booked
      this.notifyObservers("The reservation of the item number " + isbn + " failed because this item was already booked!");
    } 
    catch (ItemNotFoundException e) {       // unsuccessful case where the item doesn't exist
      this.notifyObservers("The reservation failed: " + isbn + " item not found!");
    }
  }

  /**
   * Method that will return an item to the library
   * with the help of the unique identifier to
   * select the corresponding item.
   */
  @Override
  public void returnItem(int isbn) {
    try {       // successful case
      library.returnItem(isbn);
      this.notifyObservers("The item number " + isbn + "has been successfully returned.");
    }           // unsuccessful case where the item was not booked
    catch (NotBookedException e) {
      this.notifyObservers("It wasn't possible to return the item number " + isbn + " because it's still in the library!");
    }           // unsuccessful case where item was not found
    catch (ItemNotFoundException e) {
      this.notifyObservers("Couldn't return the item number " + isbn + " because it doesn't exist.Z");
    }
  }

  /**
   * Method removing an item from the library
   * with the help of the unique identifier
   */
  public void remove(int isbn) {
    try {                               // case where the deletion was successful.
      library.removeItem(isbn);
      this.notifyObservers("The item number " + isbn + " has been successfully removed. RIP!");
    } catch (ItemNotFoundException e) { // case where the item was nowhere to be found.
      this.notifyObservers("Couldn't delete item number " + isbn + " because it doesn't exist");
    }
  }


  /**
   * Method returning if an item corresponding
   * to this identifier exists.
   * If it does, send the information of this item.
   */
  public void searchByIsbn(int isbn) {
    // tests if the item was found
    Boolean found = false;
    
    // either not found or the information
    String res = "";

    // among every item
    for (Item item : library.getListItem()) {
      if (item.getIsbn() == isbn) {
        found = true;
        // if we find it we add its info to the string
        res += item.toString() + "\n";
        break;
      }
    }

    if (!found) // error message
      this.notifyObservers("No items matched the isbn of " + isbn);
    else // successful case
      this.notifyObservers(res);
  }

  /**
   * Uses an encoded string to add an
   * item to the library
   */
  public void add(String informations) {
    // item to be added
    Item item;
    
    // the delimitation character is =
    // book: book=JK Rowling=HarryPotter
    // magazine: magazine=author=title=magazine
    // cd/dvd: cd=author=title=23/06/1993
    String[] info = informations.split(DELIMITER);

    String type = info[0];

    // make sure isbn stays unique
    int isbn = library.getNextIsbn();
    library.setIsbn(library.getNextIsbn() + 1);

    String author = info[1];
    String title = info[2];

    switch (type) {
      case "book":
        item = new Book(isbn, author, title);
        break;

      case "article":
        String magazine = info[3];
        item = new Article(isbn, author, title, magazine);
        break;

      case "cd":    // date parsing using calendar
        Calendar date = Calendar.getInstance();
        String[] dates = info[3].split("/");
        int day = Integer.parseInt(dates[0]);
        int month = Integer.parseInt(dates[1]);
        int year = Integer.parseInt(dates[2]);

        date.set(year, month, day);
        item = new Cd(isbn, author, title, date);
        break;

      case "dvd":   // date parsing using calendar
        date = Calendar.getInstance();
        dates = info[3].split("/");
        day = Integer.parseInt(dates[0]);
        month = Integer.parseInt(dates[1]);
        year = Integer.parseInt(dates[2]);

        date.set(year, month, day);
        item = new Dvd(isbn, author, title, date);
        break;

      default:
        item = null;
        break;
    }
    // note that the isbn is the only constraint,
    // so we can have multiple items with same
    // authors, titles, etc...
    library.addItem(item);
    this.notifyObservers("An item has been successfully added:\n" + item.toString());
  }

  /**
   * Returns the list of every item on the server
   * using its tostring method
   */
  public void itemList() {
    String res = "Type - ISBN - author - title\n";

    for (Item item : library.getListItem()) {
      res += item.toString() + "\n";
    }

    this.notifyObservers(res);
  }


  /**
   * Look for matches with the title as a key.
   * Can return multiple results.
   */
  public void searchByName(String name) {
    // number of results
    int numberFound = 0;
    
    String res = "";

    // for each item
    for (Item item : library.getListItem()) {
      // true if contains the name within its title
      if (item.getTitle().indexOf(name) > -1) {
        numberFound++;
        res += item.toString() + "\n";
      }
    }

    // number of items found + their information
    this.notifyObservers(numberFound + " matches:\n" + res);
  }

  public Library getLibrary() {
    return library;
  }

  /**
   * Adds an observer to this observable
   */
  public void addObserver(Observer o) {
    observers.add(o);
  }
  
  /**
   * allows you to communicate with your
   * observers
   */
  public void notifyObservers(Object arg) {
    for (Observer o: observers)
      o.update(this, arg);
  }
  
  /**
   * deletes one particular observer.
   * useful in case of a lost connection
   */
  public void deleteObserver(Observer o) {
    observers.remove(o);
  }
  
  public int countObservers() {
    return observers.size();
  }
}








