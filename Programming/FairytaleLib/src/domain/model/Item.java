package domain.model;

public abstract class Item {

  private int isbn;

  private String author;

  private String title;

  private Boolean isBooked;

  public Boolean getIsBooked() {
    return isBooked;
  }

  public void setIsBooked(Boolean isBooked) {
    this.isBooked = isBooked;
  }

  public Item(int isbn, String author, String title) {
    this.isbn = isbn;
    this.author = author;
    this.title = title;
    this.isBooked = false;
  }

  public abstract String toString();

  public int getIsbn() {
    return this.isbn;
  }

  public String getAuthor() {
    return this.author;
  }

  public String getTitle() {
    return this.title;
  }

  public Boolean getState() {
    return this.isBooked;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setState(Boolean state) {
    this.isBooked = state;
  }
}
