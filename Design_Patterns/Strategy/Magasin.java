package Strategy;

import java.util.ArrayList;

public class Magasin {
	
    private IStrategie strategie = new Standard();

    /**
     * @associates <{strategie.Article}>
     */
    private static ArrayList<Article> listeArticle = new ArrayList<Article>();
    private static Magasin magasin;
    private static int matricule = 0;

    public void listerTarifs() {
        ArrayList<Article> liste = getListeArticle();
        for (final Article a : liste) {
            System.out.println(a.getCode() + "; " + a.getNom() + "; prix d'achat : " + a.getPrix() + "; prix de vente : " + this.getStrategie().getPrixDeVente(a) + "; " + a.getCategorie().getDescription());
        }
    }

    public static ArrayList<Article> getListeArticle() {
        ArrayList<Article> clone = listeArticle;
        return clone;
    }


    public static void setListeArticle(ArrayList<Article> liste) {
        listeArticle = liste;
    }

    public static Magasin getInstance() {
        return new Magasin();
    }

    public IStrategie getStrategie() {
        return strategie;
    }

    public void changerStrategie(int numero ) {
        if (numero == 1) {
            // standard
            strategie = new Standard();
        }
        else if (numero == 2) {
            // destockage
            strategie = new Destockage();
        }
        else if (numero == 3) {
            // soldes
            strategie = new Soldes();
        }
        else {
            // benef max
            strategie = new BenefMax();
        }
    }


    public static int getMatr() {
        return matricule;
    }

    public static void setMatr(int matr) {
        matricule = matr;
    }


    public void creerArticle(String nom, double prix, Categorie categ) {
        Article a = new Article(getMatr(), nom, prix, categ);
        ArrayList<Article> liste = getListeArticle();
        liste.add(a);
        setListeArticle(liste);
        setMatr(getMatr() + 1);
    }

    public static Magasin getMagasin() {
      return magasin;
    }

    public static void setMagasin(Magasin magasin) {
      Magasin.magasin = magasin;
    }
}
