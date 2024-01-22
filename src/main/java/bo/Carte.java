package bo;

public class Carte {
	private int id;
	private String nom;
	
	/*
	 * Constructeurs
	 */
	
	public Carte() {
	}

	public Carte(int id, String nom) {
		this.id = id;
		this.nom = nom;

	}
	
	public Carte(String nom) {
		this.nom = nom;
	}

	/*
	 * Getters et Setters
	 */
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}



	@Override
	public String toString() {
		return "Carte n°" + id + " : " + nom;
	}

	
	
	
	

	
	
	
}
