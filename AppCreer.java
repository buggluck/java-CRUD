package demo;

import java.sql.Date;

public class AppCreer {

	public static void main(String[] args) {
        ProduitDaoImpl dao = new ProduitDaoImpl();

        // Utilisez java.sql.Date pour représenter la date
        Date datePeremption = Date.valueOf("2022-08-08");
        Date dateAjout = Date.valueOf("2023-07-05");

        Produit produit = new Produit(10, "lot de fourchettes", true, datePeremption, dateAjout, 04);

        dao.createProduit(produit);
    }
}
