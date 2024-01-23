package bo;

import java.time.LocalDateTime;

public class Reservation {
	private int id;
	private LocalDateTime date;
	private String statut;
	private int nbPersonne;
	private Utilisateur utilisateur;
	private Table table;
	private Restaurant restaurant;
	
	public Reservation() {
	}

	public Reservation(LocalDateTime date, int nbPersonne, Utilisateur utilisateur, Restaurant restaurant) {
		this.date = date;
		this.nbPersonne = nbPersonne;
		this.utilisateur = utilisateur;
		this.restaurant = restaurant;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public int getNbPersonne() {
		return nbPersonne;
	}

	public void setNbPersonne(int nbPersonne) {
		this.nbPersonne = nbPersonne;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Table getTable() {
		return table;
	}

	public void setTable(Table table) {
		this.table = table;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	@Override
	public String toString() {
		return "Reservation [id=" + id + ", date=" + date + ", statut=" + statut + ", nbPersonne=" + nbPersonne
				+ ", utilisateur=" + utilisateur + ", table=" + table + ", restaurant=" + restaurant + "]";
	}
}
