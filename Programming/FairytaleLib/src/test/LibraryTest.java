package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import util.AlreadyBookedException;
import util.ItemNotFoundException;
import util.NotBookedException;
import domain.model.*;

public class LibraryTest {
  Library lib;

  @Before
  public void setUp() throws Exception {
    lib = Library.getInstance();
  }

  @Test
  public void testGetInstance() {
    Library lib2 = Library.getInstance();

    assertEquals(lib.getListItem().size(), lib2.getListItem().size());
    lib.addItem(new Book(0, "aa", "aa"));

    assertEquals(lib.getListItem().size(), lib2.getListItem().size());
  }

  @Test
  public void testAddItem() {
    lib.addItem(new Book(0, "aa", "aa"));

    assertTrue(lib.getListItem().size() == 1);
    assertEquals(0, lib.getListItem().get(0).getIsbn());
    assertEquals("aa", lib.getListItem().get(0).getAuthor());
    assertEquals("aa", lib.getListItem().get(0).getTitle());
  }

  @Test
  public void testRemoveItem() throws ItemNotFoundException {
    lib.addItem(new Book(0, "aa", "aa"));
    
    int count = lib.getListItem().size();
    
    lib.removeItem(0);
    count--;
    
    assertEquals(count, lib.getListItem().size());
  }

  @Test(expected = ItemNotFoundException.class)
  public void testRemoveItem2() throws ItemNotFoundException {
    lib.removeItem(9000);
  }

  @Test
  public void testReturnItem() throws AlreadyBookedException, NotBookedException,
      ItemNotFoundException {
    Item item = new Book(10, "aa", "aa");
    lib.addItem(item);

    lib.createReservation(new Lecturer("aa", "aa"), 10);
    lib.returnItem(10);

    assertEquals(false, item.getIsBooked());

    for (Reservation res : lib.getListReservation()) {
      if (res.getItem().getIsbn() == 10) {
        fail();
      }
    }
  }

  @Test(expected = NotBookedException.class)
  public void testReturnItem2() throws NotBookedException, ItemNotFoundException {
    Item item = new Book(0, "aa", "aa");
    lib.addItem(item);

    lib.returnItem(0);
  }

  @Test(expected = ItemNotFoundException.class)
  public void testReturnItem3() throws ItemNotFoundException, NotBookedException {
    lib.returnItem(9000);
  }

  @Test
  public void testCreateReservation() throws AlreadyBookedException, ItemNotFoundException {
    Item item = new Book(15, "aa", "aa");
    lib.addItem(item);

    lib.createReservation(new Lecturer("aa", "aa"), 15);

    assertEquals(true, item.getIsBooked());
    
    Boolean correct = false;
    
    for (Reservation res : lib.getListReservation()) {

      if (res.getItem().getIsbn() == 15) {
        // test if person if the same
        if (res.getPerson() instanceof Lecturer && (res.getPerson().getName().compareTo("aa") == 0)
            && (res.getPerson().getMail().compareTo("aa") == 0)) {
          correct = true;
        }
      }
    }

    if (!correct)
      fail();
  }
  
  @Test(expected=AlreadyBookedException.class)
  public void testCreateReservation2() throws AlreadyBookedException, ItemNotFoundException {
    Item a = new Book(0,"a","a");
    lib.addItem(a);
    a.setIsBooked(true);
    
    lib.createReservation(new Lecturer("a","a"), 0);
  }
  
  @Test(expected=ItemNotFoundException.class)
  public void testCreateReservation3() throws AlreadyBookedException, ItemNotFoundException {
    lib.createReservation(new Lecturer("a","a"), 9999);
  }
}
