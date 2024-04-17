package modele.DAO;
import modele.Programmation;

import java.util.List;

public interface ProgrammationDAO {
    void ajouterProgrammation(Programmation programmation);
    void supprimerProgrammation(int programmationId);
    public List<Programmation> getProgrammationParIdFilm(int idFilm);
    public List<Programmation> getProgrammationParNomFilm(String nomFilm);
}
