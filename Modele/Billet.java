package Modele;

public class Billet {
    private int id_billet;
    private int id_client;
    private int id_film;
    private int id_salle;

    private double prix;
    private boolean annulation;
    public Billet(int id_billet, int id_client, int id_film,int id_salle,double prix,boolean annulation){
        this.id_billet=id_billet;
        this.id_client=id_client;
        this.id_film=id_film;
        this.id_salle=id_salle;
        this.prix=prix;
        this.annulation=annulation;

    }

    public int getId_billet() {
        return id_billet;
    }


    public int getId_client() {
        return id_client;
    }


    public int getId_film() {
        return id_film;
    }

    public double getPrix() {
        return prix;
    }

    public int getId_salle() {
        return id_salle;
    }

    public boolean isAnnulation() {
        return annulation;
    }
}

