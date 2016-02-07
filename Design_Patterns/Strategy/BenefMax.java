package Strategy;

public class BenefMax implements IStrategie {

	@Override
	public double getPrixDeVente(Article a) {

        double prix = 0;
        if (a.getPrix() < 100) {
            prix = a.getPrix() + (a.getPrix() * 0.2);
        }
        else {
            prix = a.getPrix() + (a.getPrix() * 0.15);
        }
        return prix;
        
	}

}
