package Composite;

public abstract class Objet {

	  private char caractere;

	  public char getCaractere()
	  {
	    return this.caractere;
	  }

	  public void setCaractere(char caractere)
	  {
	    this.caractere = caractere;
	  }

	  public abstract void action();

	  public abstract int getGold();

	  public abstract int getMonstre();
	  
}
