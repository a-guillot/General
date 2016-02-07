package Strategy;

public class Standard implements IStrategie {

	@Override
	public double getPrixDeVente(Article a) {

        double prix = a.getPrix() + (a.getPrix() * 0.1);
        return prix;
        
	}

}
