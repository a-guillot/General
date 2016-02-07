package Strategy;

public class Program {

	public static void main(String[] args) {

        Magasin m = Magasin.getInstance();
        
        // création des trois catégories :
        Categorie video = new Categorie(0, "Vidéo", "A");
        Categorie informatique = new Categorie(1, "Informatique", "B");
        Categorie loisirs = new Categorie(2, "Loisirs", "C");
        
        // création des trois produits souhaités :
        m.creerArticle("videoproj", 100, video);
        m.creerArticle("Ordi portable XXX", 600, informatique);
        m.creerArticle("Jeu StreetBattle 5", 40, loisirs);
        
        System.out.println("Stratégie standard");
        m.listerTarifs();
        
        System.out.println("Stratégie destockage");
        m.changerStrategie(2);
        m.listerTarifs();
        
        System.out.println("Stratégie soldes");
        m.changerStrategie(3);
        m.listerTarifs();
        
        System.out.println("Stratégie BenefMax");
        m.changerStrategie(4);
        m.listerTarifs();

	}

}
