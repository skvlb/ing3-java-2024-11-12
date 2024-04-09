package Modele.DAO;
import java.sql.SQLException;
import Modele.Billet;

public interface BilletDAO {
    void ajouterBillet(Billet billet) throws SQLException;
}
