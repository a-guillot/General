package domain.model;

import java.util.Calendar;

public class Cd extends Item {

  private Calendar date;

  public Cd(int isbn, String author, String title, Calendar date2) {
    super(isbn, author, title);
    this.date = date2;
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
