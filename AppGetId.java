package demo;


public class AppGetId {
    public static void main(String[] args) {
    	ProduitDaoImpl dao = new ProduitDaoImpl();
        Produit produit = new Produit(0, null, false, null, null, 0);
        produit = dao.getByID(9);
        
    }
}
