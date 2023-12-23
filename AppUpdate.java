package demo;

import java.sql.Date;

public class AppUpdate {
    public static void main(String[] args) {
        // Vous devez créer une instance de votre DAO ici
        ProduitDao produitDao = new ProduitDaoImpl(); 

        int productIdToUpdate = 7;  // ID du produit à mettre à jour

        // Obtenez le produit existant pour afficher ses détails avant la mise à jour (facultatif)
        Produit existingProduit = produitDao.getByID(productIdToUpdate);
        if (existingProduit != null) {
            System.out.println("Détails du produit avant la mise à jour:");
            afficherDetailsProduit(existingProduit);
        }

        // Créez un objet Produit avec les nouvelles données
        Produit updatedProduit = new Produit(
                productIdToUpdate,
                "gourde",
                false,  // Est disponible
                new Date(124, 8, 8),  // Date de péremption (année - 1900, mois, jour)
                new Date(123, 5, 5),  // Date d'ajout (année - 1900, mois, jour)
                15  // Prix
        );

        // Utilisez la méthode updateProduit du DAO pour mettre à jour le produit
        produitDao.updateProduit(updatedProduit, productIdToUpdate);

        // Affichez les détails mis à jour du produit (facultatif)
        Produit updatedDetails = produitDao.getByID(productIdToUpdate);
        if (updatedDetails != null) {
            System.out.println("Détails du produit après la mise à jour:");
            afficherDetailsProduit(updatedDetails);
        }
    }

    private static void afficherDetailsProduit(Produit produit) {
        System.out.println("ID: " + produit.getId());
        System.out.println("Nom: " + produit.getNom());
        System.out.println("Est disponible: " + produit.isEstDispo());
        System.out.println("Date de péremption: " + produit.getPeremption());
        System.out.println("Date d'ajout: " + produit.getDateAjout());
        System.out.println("Prix: " + produit.getPrix());
        System.out.println();
    }
}
