package domain.mediator;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ServerConnectionThread extends Thread {

  private static final int MAX_CLIENTS = 2;

  public static int number_clients;
  
  ServerModelManager model;

  /**
   * Server socket
   */
  private ServerSocket serverSocket;

  private ArrayList<Socket> socketList;

  public ServerConnectionThread(ServerModelManager model) {
    socketList = new ArrayList<Socket>();
    number_clients = 0;
    this.model = model;
  }

  /**
   * Setup the infinite loop that will add and manage client sockets.
   * Makes sure that there is no more than 2 clients
   */
  public void run() {
    while (true) {
      
      for (Socket s : socketList) {
        if (s.isClosed()) {
          socketList.remove(s);
          number_clients--;
        }
      }
      
      if (number_clients < MAX_CLIENTS) {
        Socket clientSocket;
        try {
          clientSocket = serverSocket.accept();
          socketList.add(clientSocket);
          number_clients++;
          (new Thread(new ServerCommunicationThread(clientSocket, model))).start();
        } catch (IOException e) {
          e.printStackTrace();

        }
      }
    }
  }
}
