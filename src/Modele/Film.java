package modele;

public class Film {
    private int id;
    private String titre;
    private int duree;
    private String auteur;
    private String image;
    public Film(int id,String titre,int duree,String auteur,String image){
        this.id=id;
        this.titre=titre;
        this.duree=duree;
        this.auteur=auteur;
        this.image=image;
    }

    // Getters et setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }
    public String getImagePath() {
        return image;
    }

}
