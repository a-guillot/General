package domain.model;

import java.util.Calendar;

public class Dvd extends Item {

  private Calendar date;

  public Dvd(int isbn, String author, String title, Calendar date) {
    super(isbn, author, title);
    this.date = date;
  }

  @Override
  public String toString() {
    return this.getClass().getSimpleName() + " - " + super.getIsbn() + " - " + super.getAuthor()
        + " - " + super.getTitle();
  }

  public Calendar getDate() {
    return this.date;
  }

  public void setDate(Calendar date) {
    this.date = date;
  }

}
