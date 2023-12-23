package demo;

import java.util.List;

public interface ProduitDao {
    public List<Produit> getAllProduits();
    public Produit getByID(int id);
    public void createProduit(Produit produit);
    public void updateProduit(Produit produit,int id);
	void deleteProduit(int id);
}
