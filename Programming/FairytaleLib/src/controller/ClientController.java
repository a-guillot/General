package controller;

import view.ClientView;
import controller.ClientController;
import domain.mediator.ClientModelManager;
import domain.model.Item;

public class ClientController {

  private ClientView clientView;

  private ClientModelManager clientModelManager;

  public ClientController(ClientModelManager model, ClientView view) {
    clientView = view;
    clientModelManager = model;
  }
  
  public void add(String res) {
    // type=author=title=magazine or date
    clientModelManager.add(res);
  }

  public void removeItem(int isbn) {
    clientModelManager.remove(isbn);
  }

  public void searchByName(String name) {
    clientModelManager.searchByName(name);
  }

  public void itemList() {
    clientModelManager.itemList();
  }

  public void searchByIsbn(int isbn) {
    clientModelManager.searchByIsbn(isbn);
  }

  public void book(String string) {
    clientModelManager.book(string);
  }

  public void returnItem(int isbn) {
    clientModelManager.returnItem(isbn);
  }

}
