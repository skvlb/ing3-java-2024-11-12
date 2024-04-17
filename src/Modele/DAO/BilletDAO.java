package Modele.DAO;
import java.sql.SQLException;
import java.util.List;

import Modele.Billet;

public interface BilletDAO {
    void ajouterBillet(Billet billet);
    void supprimerBillet(int billetId);
    List<Billet> listerBillets();

}
