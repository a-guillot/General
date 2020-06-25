package Composite;

import java.util.ArrayList;

public class Salle extends Element{

	  private int nbLignes;
	  private int nbColonnes;


	  /**
	   * @attribute
	   */
	  private int niveau;

	  private ArrayList<Position> casesReservees = new ArrayList<Position>();

	  /**
	   * @associates <{uml.Element}>
	   */
	  private Element[][] listeCase = new Element[this.getNbLignes()][this.getNbColonnes()];

	  public Salle(int nbLignes, int nbColonnes, int niveau)
	  {
	    this.setNbLignes(nbLignes);
	    this.setNbColonnes(nbColonnes);
	    this.setNiveau(niveau);
	  }

	  public void setNbLignes(int nbLignes)
	  {
	    this.nbLignes = nbLignes;
	  }

	  public int getNbLignes()
	  {
	    return nbLignes;
	  }

	  public void setNbColonnes(int nbColonnes)
	  {
	    this.nbColonnes = nbColonnes;
	  }

	  public int getNbColonnes()
	  {
	    return nbColonnes;
	  }

	  public void setNiveau(int niveau)
	  {
	    this.niveau = niveau;
	  }

	  public int getNiveau()
	  {
	    return niveau;
	  }

	  public void setListeCase(Element[][] enfants)
	  {
	    this.listeCase = enfants;
	  }

	  public Element[][] getListeCase()
	  {
	    return this.listeCase;
	  }

	  public void setCasesReservees(ArrayList<Position> casesReservees)
	  {
	    this.casesReservees = casesReservees;
	  }

	  public ArrayList<Position> getCasesReservees()
	  {
	    return casesReservees;
	  }

	  @Override
	  public int nombreOr()
	  {
	    // parcourt toutes les cases de cette salle pour trouver le nombre d'or
	    int res = 0;
	    for (final Element[] c : this.getListeCase()) 
	    {
	      for (int i = 0; i < c.length; i++) 
	      {
	        res += c[i].nombreOr();
	      }
	    }
	    return res;
	  }

	  @Override
	  public int nombreMonstres()
	  {
	    // parcourt toutes les cases de cette salle pour trouver le nombre d'or
	    int res = 0;
	    for (int i = 0; i < this.getNbLignes(); i++) 
	    {
	      for (int j = 0; j <this.getNbColonnes(); j++) 
	      {
	        res += this.getListeCase()[i][j].nombreMonstres();
	      }
	    }
	    return res;
	  }

	@Override
	public void setObjet(Objet objet) {
		// TODO Auto-generated method stub
		
	}
}
