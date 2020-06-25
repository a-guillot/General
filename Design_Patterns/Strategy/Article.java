package Strategy;

public class Article {

    private Categorie categorie;

    /**
     * @attribute
     */
    private Integer codeArt;

    /**
     * @attribute
     */
    private String nomArt;

    /**
     * @attribute
     */
    private Double prixVente;

    public Article(int code, String nom, double prix, Categorie categ) {
        this.codeArt = code;
        this.nomArt = nom;
        this.prixVente = prix;
        this.categorie = categ;
    }

    public int getCode() {
        return this.codeArt;
    }


    public String getNom() {
        return this.nomArt;
    }


    public void setCode(Integer code) {
        this.codeArt = code;
    }

    public void setNom(String nom) {
        this.nomArt = nom;
    }

    public double getPrix() {
        return this.prixVente;
    }

    public void setPrix(Double prix) {
        this.prixVente = prix;
    }
    
    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public Categorie getCategorie() {
        return categorie;
    }
}
