package Modele.DAO;
import java.sql.Date;
import java.util.List;

import Modele.Programmation;

public interface ProgrammationDAO {
    void ajouterProgrammation(Programmation programmation);
    void supprimerProgrammation(int programmationId);
    public List<Programmation> getProgrammationParIdFilm(int idFilm);
    public List<Programmation> getProgrammationParNomFilm(String nomFilm);
    public List<Programmation> getHorairesParIdFilmEtDate(int idFilm, Date date);//commentaire push
}