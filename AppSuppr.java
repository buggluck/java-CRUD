package demo;

public class AppSuppr {
    public static void main(String[] args) {
        ProduitDaoImpl dao = new ProduitDaoImpl();
        dao.deleteProduit(10);
    }
}