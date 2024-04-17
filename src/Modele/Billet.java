package Modele;

public class Billet {
    private int id_billet;
    private int id_client;
    private int id_programmation;
    private double prix;
    private boolean annulation;
    public Billet(int id_billet, int id_client, int id_programmation,double prix,boolean annulation){
        this.id_billet=id_billet;
        this.id_client=id_client;
        this.id_programmation=id_programmation;
        this.prix=prix;
        this.annulation=annulation;

    }

    public int getId_billet() {
        return id_billet;
    }


    public int getId_client() {
        return id_client;
    }
    public int getId_programmation(){
        return id_programmation;
    }

    public double getPrix() {
        return prix;
    }

    public boolean isAnnulation() {
        return annulation;
    }
}

