package bll;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import bo.Horaire;
import bo.Reservation;
import bo.Restaurant;
import bo.Utilisateur;
import dal.DALException;
import dal.GenericDAO;
import dal.ReservationDAOJdbcImpl;

public class ReservationBLL {
	private GenericDAO<Reservation> dao;

	public ReservationBLL() throws BLLException {
		try {
			dao = new ReservationDAOJdbcImpl();
		} catch (DALException e) {
			throw new BLLException("Echec de la connexion", e);
		}
	}

	public List<Reservation> selectAll() throws BLLException {
		try {
			return dao.selectAll();
		} catch (DALException e) {
			throw new BLLException("Echec de la recuperation des réservations", e);
		}
	}

	public Reservation selectById(int id) throws BLLException {
		try {
			return dao.selectById(id);
		} catch (DALException e) {
			throw new BLLException("Echec de la recuperation de la réservation d'id " + id, e);
		}
	}

	public Reservation insert(LocalDateTime date, int nbPersonne, Utilisateur utilisateur,
			Restaurant restaurant, List<Horaire> horaires) throws BLLException {

		BLLException blleException = new BLLException();
		if (nbPersonne < 1) {
			blleException.ajouterErreur("Veuillez choisir un nombre de personnes supérieur ou égal à 1.");
		}
		
		if (date.isBefore(LocalDateTime.now())) {
			blleException.ajouterErreur("Veuillez choisir une date à venir et non passée.");
		}
		
		if (!validateHoraire(date,restaurant,horaires)) {
			blleException.ajouterErreur("Veuillez choisir une date et un horaire de réservation parmi les horaires d'ouverture du magasin repris ci-dessous.");
		}
		
		if (blleException.getErreurs().size() > 0) {
			throw blleException;
		}
		
		Reservation reservation = new Reservation(date, nbPersonne, utilisateur, restaurant);
		try {
			validateDate(date);
			dao.insert(reservation);
		} catch (DALException e) {
			throw new BLLException("Echec de l'insertion", e);
		}
		return reservation;
	}

	public boolean validateHoraire(LocalDateTime date, Restaurant restaurant, List<Horaire> horaires) {
		List<Horaire> horairesRestaurant = new ArrayList<>();
		
		for (Horaire current : horaires) {
			if (current.getRestaurant().getNom().equals(restaurant.getNom())) {
				horairesRestaurant.add(current);
			}
		}
		
		String[] jours = {"Lundi","Mardi","Mercredi","Jeudi","Vendredi","Samedi","Dimanche"};
		int jourInt = date.getDayOfWeek().getValue();
		String jourReservation = jours[jourInt-1];
		System.out.println(jourReservation);
		LocalTime horaireReservation = date.toLocalTime();
		System.out.println(horaireReservation);
		for (Horaire current : horairesRestaurant) {
			String jour = current.getJour();
			if (jourReservation.equals(jour)) {
				System.out.println("Jour ok : " + jour);
				LocalTime heureDebut = current.getHeureDeDebut();
				LocalTime heureFin = current.getHeureDeFin();
				if (horaireReservation.isAfter(heureDebut) && horaireReservation.isBefore(heureFin)) {
					System.out.println("Horaire ok  : " + heureDebut + " - " + heureFin);
					return true;
				}
			}
		}
		return false;
	}

	public void update(Reservation reservation) throws BLLException {

		try {
			dao.update(reservation);
		} catch (DALException e) {
			throw new BLLException("Echec de la mise a jour", e);
		}
	}

	public void delete(int id) throws BLLException {
		try {
			dao.delete(id);
		} catch (DALException e) {
			throw new BLLException("Echec de la suppression", e);
		}
	}

	private void validateDate(LocalDateTime date) throws BLLException {
		if (date==null) {
			throw new BLLException("La date doit être remplie.");
		}


	}
}
