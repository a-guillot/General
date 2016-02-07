package domain.model;

public class Book extends Item {

  public Book(int isbn, String author, String title) {
    super(isbn, author, title);
  }

  @Override
  public String toString() {
    return this.getClass().getSimpleName() + " - " + super.getIsbn() + " - " + super.getAuthor()
        + " - " + super.getTitle();
  }

}
