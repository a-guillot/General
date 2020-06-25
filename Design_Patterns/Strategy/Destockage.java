package Strategy;

public class Destockage extends Standard {
	
    public double getPrixDeVente(Article a) {
    	
        double prix = super.getPrixDeVente(a) * 0.85;
        return prix;
        
    }

}
