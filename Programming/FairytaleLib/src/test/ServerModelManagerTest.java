package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import util.AlreadyBookedException;
import util.ItemNotFoundException;
import domain.mediator.ServerModelManager;
import domain.model.*;

public class ServerModelManagerTest {

  ServerModelManager serv;
  
  @Before
  public void setUp() throws Exception {
    serv = new ServerModelManager();
  }

  @Test
  public void testBook() {
    String information = "alvaro=azerty=student=0";
    Item item = new Book(0,"aa","aa");
    Library.getInstance().addItem(item);
    
    serv.book(information);
    
    assertTrue(item.getIsBooked());
    
    Boolean ok = false;
    for (Reservation res: serv.getLibrary().getListReservation()) {
      if (res.getItem().getIsbn() == 0) {
        if (res.getPerson().getName().compareTo("alvaro") == 0)
          if (res.getPerson().getMail().compareTo("azerty") == 0)
            if (res.getPerson() instanceof Student)
              ok = true;
      }
    }
    if (!ok) fail();
  }

  @Test
  public void testReturnItem() throws AlreadyBookedException, ItemNotFoundException {
    int isbn = 1;
    Item item = new Book(isbn, "aa", "aa");
    Library.getInstance().addItem(item);
    Library.getInstance().createReservation(new Student("aa", "aa"), isbn);
    
    serv.returnItem(isbn);
    
    assertEquals(false, item.getIsBooked());
  }

  @Test
  public void testRemove() {
    serv.getLibrary().addItem(new Book(3, "aa", "aa"));
    serv.remove(3);
    
    for(Item item: serv.getLibrary().getListItem()) {
      if (item.getIsbn() == 3)
        fail();
    }
  }

  @Test
  public void testAdd() {
    String informationCd = "cd=aze=aze=20/06/1994";
    
    assertTrue(serv.getLibrary().getListItem().size() == 0);
    serv.add(informationCd);
    
    for(Item item: serv.getLibrary().getListItem()) {
      if (item instanceof Cd) {
        Cd cd = (Cd) item;  
      }
    }
  }

}
