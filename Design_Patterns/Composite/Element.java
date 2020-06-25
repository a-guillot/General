package Composite;

import java.util.ArrayList;

public abstract class Element {

	  private ArrayList<Salle> listeSalles = new ArrayList<Salle>();

	  public void setListeSalles(ArrayList<Salle> listeSalles)
	  {
	    this.listeSalles = listeSalles;
	  }

	  public ArrayList<Salle> getListeSalles()
	  {
	    return listeSalles;
	  }

	  public abstract int nombreOr();

	  public abstract int nombreMonstres();

	  public Objet getObjet()
	  {
	    return null;
	  }

	  public abstract void setObjet(Objet objet);
}
