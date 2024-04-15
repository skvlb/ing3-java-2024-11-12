package modele.DAO;
import modele.Programmation;

import java.util.List;

public interface ProgrammationDAO {
    int ajouterProgrammation(Programmation programmation);
    void supprimerProgrammation(int programmationId);

}
