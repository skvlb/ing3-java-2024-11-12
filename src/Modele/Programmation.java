package Modele;
import java.sql.Date;
import java.sql.Time;
public class Programmation {
    private int id;
    private int filmId;
    private int salleId;
    private Time heureDebut;
    private Time heureFin;
    private Date date;

    // Constructeur
    public Programmation(int id,int filmId, int salleId,Time heureDebut,Time heureFin,Date date) {
        this.id=id;
        this.filmId = filmId;
        this.salleId = salleId;
        this.heureDebut = heureDebut;
        this.heureFin = heureFin;
        this.date=date;
    }

    // Getters et setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFilmId() {
        return filmId;
    }

    public int GetFilmNom()
    {
        return 0; //a faire pour avoir le nom plutot que l'id dans la panier
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public int getSalleId() {
        return salleId;
    }

    public void setSalleId(int salleId) {
        this.salleId = salleId;
    }

    public Time getHeureDebut() {
        return heureDebut;
    }

    public void setHeureDebut(Time heureDebut) {
        this.heureDebut = heureDebut;
    }

    public Time getHeureFin() {
        return heureFin;
    }

    public void setHeureFin(Time heureFin) {
        this.heureFin = heureFin;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
