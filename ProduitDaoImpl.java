package demo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProduitDaoImpl implements ProduitDao {
    ConnectionMain connectionMain;

    public ProduitDaoImpl() {
        this.connectionMain = new ConnectionMain();
    }
    Statement stmt;
    List<Produit> listProduits = new ArrayList<>();
	private int resultSet;

	// Méthode pour récupérer tous les produits de la base de données
    @Override
    public List<Produit> getAllProduits() {
        String request = "SELECT * FROM PRODUIT";
        List<Produit> listProduits = new ArrayList<>();
        try (Connection connection = ConnectionMain.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(request)) {

            while (resultSet.next()) {
                Produit produit = new Produit(
                        resultSet.getInt("id"),
                        resultSet.getString("nom"),
                        resultSet.getBoolean("estDispo"),
                        resultSet.getDate("datePeremption"),
                        resultSet.getDate("dateAjout"),
                        resultSet.getInt("Prix")
                );
                listProduits.add(produit);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listProduits;
    }

 // Méthode pour récupérer un seul produit grâce à son id
    @Override
    public Produit getByID(int id) {
        String request = "SELECT * FROM PRODUIT WHERE id = " + id + ";";
        ResultSet resultSet;
        Produit produit = null;
        try {
            resultSet = ConnectionMain.getConnection().createStatement().executeQuery(request);

            if (resultSet.next()) {
                produit = new Produit(
                    resultSet.getInt("id"),
                    resultSet.getString("nom"),
                    resultSet.getBoolean("estDispo"),
                    resultSet.getDate("Peremption"),
                    resultSet.getDate("dateAjout"),
                    resultSet.getInt("Prix")
                );

                // Afficher les détails du produit dans la console
                System.out.println("Produit ID: " + Produit.getId());
                System.out.println("Nom: " + produit.getNom());
                System.out.println("Disponible: " + produit.isEstDispo());
                System.out.println("Date de péremption: " + produit.getPeremption());
                System.out.println("Date d'ajout: " + produit.getDateAjout());
                System.out.println("Prix: " + produit.getPrix());
            }

            ConnectionMain.getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return produit;
    }

 // Méthode pour créer un produit
    @Override
    public void createProduit(Produit produit) {
        String request = "INSERT INTO produit (id, nom, estdispo, peremption, DateAjout, Prix) VALUES (" +
                Produit.getId() + ",'" + produit.getNom() + "'," + produit.isEstDispo() + ",'" +
                produit.getDatePeremption() + "', '" + produit.getDateAjout() + "', " + produit.getPrix() + ");";

        try {
            ConnectionMain.getConnection().createStatement().executeUpdate(request);
            ConnectionMain.getConnection().close();
			System.out.println("CREATE SUCCESS! Produit ID: " + Produit.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    	
    //Méthode UPDATE un produit.
    @Override
    public void updateProduit(Produit produit, int id) {
        String request = "UPDATE PRODUIT SET nom = '" + produit.getNom() +
                "', Estdispo = " + produit.isEstDispo() +
                ", peremption = '" + produit.getPeremption() + "'" +
                ", prix = " + produit.getPrix() +
                " WHERE id = " + id + ";";

        try (Connection connection = ConnectionMain.getConnection();
             Statement statement = connection.createStatement()) {

            int rowsAffected = statement.executeUpdate(request);

            if (rowsAffected > 0) {
                System.out.println("Produit mis à jour avec succès!");
            } else {
                System.out.println("Aucun produit mis à jour. Vérifiez l'ID.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Méthode pour DELETE un produit
    @Override
    public void deleteProduit(int id) {
        String request = "DELETE FROM PRODUIT WHERE id = " + id + ";";
        try (Connection connection = ConnectionMain.getConnection();
             Statement statement = connection.createStatement()) {

            statement.executeUpdate(request);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    

	public int getResultSet() {
		return resultSet;
	}

	public void setResultSet(int resultSet) {
		this.resultSet = resultSet;
	}
		
}

