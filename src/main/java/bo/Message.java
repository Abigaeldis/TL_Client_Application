package bo;

public class Message {
	private int id;
	private String titre;
	private String corpsMessage;
	private Restaurant restaurant;
	private Utilisateur utilisateur;
	
	public Message() {}

	public Message(String titre, String corpsMessage, Restaurant restaurant, Utilisateur utilisateur) {
		super();
		this.titre = titre;
		this.corpsMessage = corpsMessage;
		this.restaurant = restaurant;
		this.utilisateur = utilisateur;
	}

	public Message(int id, String titre, String corpsMessage, Restaurant restaurant, Utilisateur utilisateur) {
		super();
		this.id = id;
		this.titre = titre;
		this.corpsMessage = corpsMessage;
		this.restaurant = restaurant;
		this.utilisateur = utilisateur;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getCorpsMessage() {
		return corpsMessage;
	}

	public void setCorpsMessage(String corpsMessage) {
		this.corpsMessage = corpsMessage;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", titre=" + titre + ", corpsMessage=" + corpsMessage + ", restaurant="
				+ restaurant + ", utilisateur=" + utilisateur + "]";
	}
	
	
	
}
