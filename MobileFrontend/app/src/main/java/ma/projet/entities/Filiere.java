package ma.projet.entities;

public class Filiere {

    private int id;
    private String code;
    private String nom;

    public Filiere(int id, String code, String nom) {
        this.id = id;
        this.code = code;
        this.nom = nom;
    }


    public Filiere(String code, String libelle) {
        this.code = code;
        this.nom = libelle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String libelle) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Filiere{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", libelle='" + nom + '\'' +
                '}';
    }
}
