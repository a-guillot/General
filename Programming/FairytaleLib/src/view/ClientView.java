package view;

import java.util.InputMismatchException;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

import controller.ClientController;

public class ClientView implements Observer {

  private static final String DELIMITER = "=";
  
  private Scanner in;
  
  /**
   * Used to send information to the rest of the application
   */
  private ClientController controller;

  public ClientView() {
    in = new Scanner(System.in);
  }

  /**
   * Gives a menu and reads an int from the console
   * @return the chosen one
   */
  private int menu() {
    System.out.println("Fairytale Library");
    System.out.println("--------------");
    System.out.println("1) List every item");
    System.out.println("2) Search by ISBN");
    System.out.println("3) Search by name");
    System.out.println("4) Add an item");
    System.out.println("5) Remove an item");
    System.out.println("6) Book an item");
    System.out.println("7) Return an item");
    System.out.println("8) Quit");
    System.out.println();
    System.out.print("Select an item 1-8: ");
    int selection = in.nextInt();
    in.nextLine();
    return selection;
  }

  /**
   * Executes the action that the user wants
   * @param control controller that will handle the info
   */
  public void start(ClientController control) {
    this.controller = control;
    int menuSelection;
    do {
      menuSelection = menu();

      switch (menuSelection) {
        case 1: // print
          printLibrary();
          break;
        case 2: // search by isbn
          searchByIsbn();
          break;
        case 3: // search by name
          searchByName();
          break;
        case 4: // add an item
          add();
          break;
        case 5: // remove an item
          remove();
          break;
        case 6: // book an item
          book();
          break;
        case 7:
          returnItem();
          break;
        case 8: // quit
          System.out.println("quitting");
          break;
      }
    } while (menuSelection != 8);

  }

  /**
   * Prints the list of every item
   */
  public void printLibrary() {
    controller.itemList();
  }

  /**
   * Searches an item on the server
   */
  public void searchByIsbn() {
    System.out.println("Write the ISBN you want to look for");
    int isbn = -1;
    try {
      isbn = in.nextInt();
    } catch (InputMismatchException ex) {
      System.out.println("Please type an integer.");
    }
    controller.searchByIsbn(isbn);
  }

  /**
   * Search item on the server by name
   */
  public void searchByName() {
    System.out.println("Write the name of the item you are looking for");
    controller.searchByName(in.nextLine());
  }

  /**
   * Adds an item to the server
   */
  public void add() {
    String res = "";
    
    System.out.println("Decide which type of item you want to add:");
    System.out.println("Type 1 for a book");
    System.out.println("Type 2 for an article");
    System.out.println("Type 3 for a CD");
    System.out.println("Type 4 for a DVD");
    
    int type = in.nextInt();
    switch (type) {
      case 1:
        res += "book" + DELIMITER;
        break;
      case 2:
        res += "article" + DELIMITER;
        break;
      case 3:
        res += "cd" + DELIMITER;
        break;
      case 4:
        res += "dvd" + DELIMITER;
        break;
    }
    
    System.out.println("write the author's name:");
    String author = in.nextLine();
    res += author + DELIMITER;
    
    System.out.println("write the title:");
    String title = in.nextLine();
    res += title + DELIMITER;
    
    switch (type) {
      case 2:
        System.out.println("write the name of the magazine");
        String magazine = in.nextLine();
        res += magazine;
        break;
        
      case 3:
        System.out.println("enter the day:");
        int day = in.nextInt();
        System.out.println("enter month number:");
        int month = in.nextInt();
        System.out.println("enter year:");
        int year = in.nextInt();
        String date = day + "/" + month + "/" + year;
        res += date;
        break;
        
      case 4:
        System.out.println("enter the day:");
        day = in.nextInt();
        System.out.println("enter month number:");
        month = in.nextInt();
        System.out.println("enter year:");
        year = in.nextInt();
        date = day + "/" + month + "/" + year;
        res += date;
        break;        
    }
    controller.add(res);
  }

  /**
   * remove an item from the server
   */
  public void remove() {
    System.out.println("print the isbn you cant to remove");
    int isbn = in.nextInt();
    controller.removeItem(isbn);
  }

  /**
   * book an item with a person and a unique id
   */
  public void book() {
    System.out.println("name of the client");
    String name = in.nextLine();
    
    System.out.println("mail of the client");
    String mail = in.nextLine();
    
    System.out.println("type: student of lecturer");
    String type = in.nextLine();
    
    System.out.println("type the isbn of the item to be booked");
    String isbn = in.nextLine();
    
    controller.book(name + DELIMITER + mail + DELIMITER + type + DELIMITER + isbn);
  }

  /**
   * return an item to the library
   */
  public void returnItem() {
    System.out.println("Select the isbn of item you want to return");
    controller.returnItem(in.nextInt());
    
  }

  /**
   * Deletes itself if not connected anymore
   */
  @Override
  public void update(Observable arg0, Object arg1) {
    try {
      String message = (String) arg1;
      System.out.println(message);
    } catch (Exception e) {
      ((Observable)arg0).deleteObserver(this);
    }
  }
}
