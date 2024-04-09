package modele;
import java.sql.Time;
public class Programmation {
    private int id;
    private int filmId;
    private int salleId;
    private Time heureDebut;
    private Time heureFin;

    // Constructeur
    public Programmation(int id, int filmId, int salleId, Time heureDebut, Time heureFin) {
        this.id = id;
        this.filmId = filmId;
        this.salleId = salleId;
        this.heureDebut = heureDebut;
        this.heureFin = heureFin;
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

}
