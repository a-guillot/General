package Strategy;

public class Program {

	public static void main(String[] args) {

        Magasin m = Magasin.getInstance();
        
        // cr�ation des trois cat�gories :
        Categorie video = new Categorie(0, "Vid�o", "A");
        Categorie informatique = new Categorie(1, "Informatique", "B");
        Categorie loisirs = new Categorie(2, "Loisirs", "C");
        
        // cr�ation des trois produits souhait�s :
        m.creerArticle("videoproj", 100, video);
        m.creerArticle("Ordi portable XXX", 600, informatique);
        m.creerArticle("Jeu StreetBattle 5", 40, loisirs);
        
        System.out.println("Strat�gie standard");
        m.listerTarifs();
        
        System.out.println("Strat�gie destockage");
        m.changerStrategie(2);
        m.listerTarifs();
        
        System.out.println("Strat�gie soldes");
        m.changerStrategie(3);
        m.listerTarifs();
        
        System.out.println("Strat�gie BenefMax");
        m.changerStrategie(4);
        m.listerTarifs();

	}

}
