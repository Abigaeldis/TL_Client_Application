package bo;

public class Utilisateur {
	private int id;
	private String nom;
	private String prenom;
	private String mail;
	private String motdepasse;
	private String telephone;
	private String adresse;
	private String role;
	private Restaurant restaurant;
	
	public Utilisateur() {
		super();
	}
	
	public Utilisateur(String nom, String prenom, String mail, String motdepasse, String telephone, String adresse,
			String role, Restaurant restaurant) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.motdepasse = motdepasse;
		this.telephone = telephone;
		this.adresse = adresse;
		this.role = role;
		this.restaurant = restaurant;
	}
	
	public Utilisateur(int id, String nom, String prenom, String mail, String motdepasse, String telephone,
			String adresse, String role, Restaurant restaurant) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.motdepasse = motdepasse;
		this.telephone = telephone;
		this.adresse = adresse;
		this.role = role;
		this.restaurant = restaurant;
	}
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
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getMotdepasse() {
		return motdepasse;
	}
	public void setMotdepasse(String motdepasse) {
		this.motdepasse = motdepasse;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Restaurant getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}	
	
	


}


