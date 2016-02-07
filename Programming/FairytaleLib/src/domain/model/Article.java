package domain.model;

public class Article extends Item {

	private String magazine;
	
	public Article(int isbn, String author, String title, String magazine) {
		super(isbn, author, title);
		this.magazine = magazine;
	}

	public String getMagazine() {
		return this.magazine;
	}

	public void setMagazine(String magazine) {
		this.magazine = magazine;
	}

  @Override
  public String toString() {
    return this.getClass().getSimpleName() + " - " + super.getIsbn() + " - " + super.getAuthor() + " - " + super.getTitle();
  }
}
