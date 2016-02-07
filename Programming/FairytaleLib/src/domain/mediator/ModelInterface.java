package domain.mediator;

public interface ModelInterface {

	public void book(String information);
	
	public void returnItem(int isbn);

	public void remove(int isbn);

	public void searchByIsbn(int isbn);

	public void add(String informations);

	public void itemList();

	public void searchByName(String name);

}
