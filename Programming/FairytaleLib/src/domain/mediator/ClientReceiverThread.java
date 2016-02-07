package domain.mediator;

import java.io.DataInputStream;
import java.io.IOException;

public class ClientReceiverThread extends Thread {

  /**
   * The way we will be receiving data from the server
   */
  private DataInputStream inFromServer;

  /**
   * The way we are going to use observer
   */
  private ClientModelManager model;

  /**
   * we need the model for 2 things: observer and socket
   * 
   * @param in
   * @param model
   * @throws IOException
   */
  public ClientReceiverThread(DataInputStream in, ClientModelManager model) throws IOException {
    this.model = model;
    inFromServer = in;
  }

  /**
   * Infinite receiving loop
   */
  public void run() {
    while (true) {
      try {
        model.notifyObservers((String) inFromServer.readUTF());
      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
  }
}
