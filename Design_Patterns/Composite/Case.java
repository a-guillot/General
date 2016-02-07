package Composite;

public class Case extends Element {
	
	  private boolean discovered = false;

	  private Objet objet;
	  private Position position;


	  public Case(Position position, Objet objet)
	  {
	    this.setPosition(position);
	    this.setObjet(objet);
	  }

	  public void setPosition(Position position)
	  {
	    this.objet = null;
	    this.position = position;
	  }

	  public Position getPosition()
	  {
	    return this.position;
	  }

	  public void setDiscovered(boolean discovered)
	  {
	    this.discovered = discovered;
	  }

	  public boolean isDiscovered()
	  {
	    return this.discovered;
	  }

	  public void setObjet(Objet objet)
	  {
	    this.objet = objet;
	  }

	  @Override
	  public Objet getObjet()
	  {
	    return this.objet;
	  }

	  // deux fonctions récursives

	  @Override
	  public int nombreOr()
	  {
	    // dans la case, retourne le nombre d'or qu'elle contient
	    return this.getObjet().getGold();
	  }

	  @Override
	  public int nombreMonstres()
	  {
	    // dans la case, retourne s'il y a un monstre
	    return this.getObjet().getMonstre();
	  }

}
