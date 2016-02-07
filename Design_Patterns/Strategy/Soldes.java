package Strategy;

public class Soldes extends Standard {

    public double getPrixDeVente(Article a) {
    	
        double prix = 0;
        
        if (a.getCategorie().getNom() == "A") {
            prix = super.getPrixDeVente(a) * 0.9;
        }
        else if (a.getCategorie().getNom() == "B") {
            prix = super.getPrixDeVente(a) * 0.8;
        }
        else {
            prix = super.getPrixDeVente(a) * 0.7;
        }
        
        return prix;
        
    }
}
