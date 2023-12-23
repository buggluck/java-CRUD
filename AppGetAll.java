package demo;

import java.util.ArrayList;
import java.util.List;

public class AppGetAll {
    public static void main(String[] args) {
        List<Produit> listProduits = new ArrayList<>();
        ProduitDaoImpl dao = new ProduitDaoImpl();
        listProduits = dao.getAllProduits();
        System.out.println( "la liste des produits possède "+ listProduits.size() + " membres");
        for( Produit p : listProduits) {

            System.out.println(p.toString());

        }

    }
}
