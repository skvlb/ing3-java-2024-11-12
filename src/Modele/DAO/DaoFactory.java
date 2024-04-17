package modele.DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DaoFactory {
    private String url;
    private String username;
    private String password;

    private static final String DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";

    private DaoFactory(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public static DaoFactory getInstance() {
        try {
            Class.forName(DRIVER_CLASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new IllegalStateException("Le driver JDBC n'a pas été trouvé", e);
        }

        DaoFactory instance = new DaoFactory(
                "jdbc:mysql://localhost:3306/cinema", "root", "");
        return instance;
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    // Récupération du Dao
    public FilmDAO getFilmDAO() {
        return new FilmDaoImpl(this);
    }
    public BilletDAO getBilletDAO() {
        return new BilletDaoImpl(this);
    }
    public ProgrammationDAO getProgrammationDAO(){
        return new ProgrammationDaoImpl(this);
    }
    public UtilisateurDAO getUtilisateurDAO(){
        return new UtilisateurDaoImpl(this);
    }
}

