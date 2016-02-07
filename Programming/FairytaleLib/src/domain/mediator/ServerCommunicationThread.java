package domain.mediator;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import java.util.Observable;
import java.util.Observer;

public class ServerCommunicationThread extends Thread implements Observer {

  /**
   * 
   */
  private DataInputStream inFromClient;
  private DataOutputStream outToClient;

  private String clientIP;

  private ServerModelManager model;

  /**
   * Allows us to communicate with the client through the ClientReceiverThread class
   * 
   * @param clientSocket the socket that just got created from the client connection
   * @throws IOException
   */
  public ServerCommunicationThread(Socket clientSocket, ServerModelManager model)
      throws IOException {
    this.model = model;
    inFromClient = new DataInputStream(clientSocket.getInputStream());
    outToClient = new DataOutputStream(clientSocket.getOutputStream());

    clientIP = clientSocket.getInetAddress().getHostName();
    if (!clientIP.equals(clientSocket.getInetAddress().getHostAddress()))
      clientIP += " / " + clientSocket.getInetAddress().getHostAddress();
    if (clientIP.equals("127.0.0.1"))
      clientIP = "localhost";

    this.start();
  }

  /**
   * Method that runs when you start the server Infinite loop
   */
  public void run() {
    try {
      model.addObserver(this);

      Thread.sleep(1000);

      while (true) {
        byte messageType = inFromClient.readByte();

        switch (messageType) {
          case 0: // book: string
            model.book(inFromClient.readUTF());
            break;
          case 1: // remove: int
            model.remove(inFromClient.readInt());
            break;
          case 2: // search isbn: int
            model.searchByIsbn(inFromClient.readInt());
            break;
          case 3: // add: string
            model.add(inFromClient.readUTF());
            break;
          case 4: // list item case
            model.itemList();
            break;
          case 5: // search by name : string
            model.searchByName(inFromClient.readUTF());
            break;
          case 6: // return item
            model.returnItem(inFromClient.readInt());
            break;
        }
      }

    } catch (SocketException e) {

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * The way the ServerModelManager will send information to the client
   */
  @Override
  public void update(Observable arg0, Object arg1) {
    try {
      String message = (String) arg1;
      send(message);
    } catch (Exception e) {
      model.deleteObserver(this);
    }
  }

  private void send(String message) throws Exception {
    outToClient.writeUTF(message);
  }
}
