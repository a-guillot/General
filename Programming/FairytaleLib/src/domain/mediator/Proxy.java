package domain.mediator;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Proxy implements ModelInterface {

  private static int PORT = 901;

  private static String HOST = "localhost";

  private Socket clientSocket;

  private DataInputStream inFromServer;
  private DataOutputStream dOut;
  
  public Proxy(ClientModelManager model) {
    this.login();

    try {
      inFromServer = (DataInputStream) this.getSocket().getInputStream();
      dOut = new DataOutputStream(clientSocket.getOutputStream());
      (new Thread(new ClientReceiverThread(inFromServer, model))).start();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Create the socket to the client
   */
  public void login() {
    try {
      clientSocket = new Socket(HOST, PORT);
    } catch (UnknownHostException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * destroy the socket
   */
  public void logout() {
    try {
      clientSocket.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Removes an item from the library
   */
  public void remove(int isbn) {
    try {
      dOut.writeByte(1);
      dOut.writeInt(isbn);
      dOut.flush();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }


  /**
   * adds an item to the lib
   */
  public void add(String informations) {
    try {
      dOut.writeByte(3);
      dOut.writeUTF(informations);
      dOut.flush();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }


  /**
   * Lists every item of the library
   */
  public void itemList() {
    try {
      dOut.writeByte(4);
      dOut.flush();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Books an item
   */
  @Override
  public void book(String information) {
    try {
      dOut.writeByte(0);
      dOut.writeUTF(information);
      dOut.flush();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Returns an item
   */
  @Override
  public void returnItem(int isbn) {
    try {
      dOut.writeByte(6);
      dOut.writeInt(isbn);
      dOut.flush();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Searches by isbn
   */
  @Override
  public void searchByIsbn(int isbn) {
    try {
      dOut.writeByte(2);
      dOut.writeInt(isbn);
      dOut.flush();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Searches by name
   */
  @Override
  public void searchByName(String name) {
    try {
      dOut.writeByte(5);
      dOut.writeUTF(name);
      dOut.flush();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public Socket getSocket() {
    return clientSocket;
  }

}
