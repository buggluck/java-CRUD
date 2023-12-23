package demo;

import java.sql.Date;

public class Produit {
	
    private static int id;
    private String nom;
    private boolean enStock;
    private final Date datePeremption;
    private final Date dateAjout;
    private double prix;

    public Produit(int id, String nom, boolean enStock, Date datePeremption, Date dateAjout, double prix) {
        Produit.id = id;
        this.nom = nom;
        this.enStock = enStock;
        this.datePeremption = datePeremption;
        this.dateAjout = dateAjout;
        this.prix = prix;
    }

    public static int getId() {
        return id;
    }

    // ... (les autres méthodes d'accès)

    public boolean isEstDispo() {
        return enStock;
    }

    public Date getDatePeremption() {
        return datePeremption;
    }

    public String getPeremption() {
        return datePeremption.toString();
    }

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public Date getDateAjout() {
		return dateAjout;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
}
