package demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionMain {

    private static String jdbcUrl = "jdbc:h2:tcp://localhost/~/exofinal";
    private static String login = "admin";
    private static String mdp = "1234";

    // Connexion unique pour toute l'application
    private static Connection connection;

    // Constructeur privé pour empêcher l'instanciation directe
    ConnectionMain() {
        // Ne rien faire ici
    }

    // Méthode pour obtenir la connexion
    public static Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(jdbcUrl, login, mdp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    // Méthode pour fermer la connexion
    public static void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Connexion fermée !!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
