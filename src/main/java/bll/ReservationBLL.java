package bll;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import bo.Reservation;
import bo.Restaurant;
import bo.Table;
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
			Restaurant restaurant) throws BLLException {

		BLLException blleException = new BLLException();
		if (nbPersonne < 1) {
			blleException.ajouterErreur("Veuillez choisir un nombre de personnes supérieur ou égal à 1.");
		}
		
		if (date.isBefore(LocalDateTime.now())) {
			blleException.ajouterErreur("Veuillez choisir une date à venir et non passée.");
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
