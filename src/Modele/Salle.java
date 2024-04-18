package Modele;

public class Salle {
    private int id;
    private int capacite;
    private int nombrePlaces;
    private int numero;

    int siege [][];

    public Salle(int id, int capacite, int nombrePlaces, int numero) {
        this.id = id;
        this.capacite = capacite;
        this.nombrePlaces = nombrePlaces;
        this.numero = numero;
    }

    // Getters et setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    public int getNombrePlaces() {
        return nombrePlaces;
    }

    public void setNombrePlaces(int nombrePlaces) {
        this.nombrePlaces = nombrePlaces;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero){
        this.numero = numero;
    }
}
