package Strategy;

public class Categorie {

    private String nom;

    /**
     * @attribute
     */
    private String description;
    
    /**
     * @attribute
     */
    private int id;

    public Categorie(int id, String nom, String Description) {
        this.nom = nom;
        this.description = Description;
    }

    public String getNom() {
        return this.nom;
    }

    public String getDescription() {
        return this.description;
    }


    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDescription(String desc) {
        this.description = desc;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
