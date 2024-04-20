package Modele;

public class Siege {
    private int idSiege;
    private String emailUtilisateur;
    private int placePrise;
    private int idSalle;

    public Siege(int idSiege, String emailUtilisateur, int placePrise, int idSalle) {
        this.idSiege = idSiege;
        this.emailUtilisateur = emailUtilisateur;
        this.placePrise = placePrise;
        this.idSalle = idSalle;
    }

    public int getIdSiege() {
        return idSiege;
    }

    public void setIdSiege(int idSiege) {
        this.idSiege = idSiege;
    }

    public String getEmailUtilisateur() {
        return emailUtilisateur;
    }

    public void setEmailUtilisateur(String emailUtilisateur) {
        this.emailUtilisateur = emailUtilisateur;
    }

    public int getPlacePrise() {
        return placePrise;
    }

    public void setPlacePrise(int placePrise) {
        this.placePrise = placePrise;
    }

    public int getIdSalle() {
        return idSalle;
    }

    public void setIdSalle(int idSalle) {
        this.idSalle = idSalle;
    }
}

