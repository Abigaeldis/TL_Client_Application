package bll;

import java.time.LocalDate;
import java.util.List;

import bo.Employe;
import dal.DALException;
import dal.EmployeDAO;

public class EmployeBLL {
	private EmployeDAO dao;
	
	public EmployeBLL() throws BLLException {
		try {
			dao = new EmployeDAO();
		} catch (DALException e) {
			throw new BLLException("Echec de la connexion", e);
		}
	}
	
	public List<Employe> selectAll() throws BLLException {
		/*
		 * Dans la mesure o� le BLL n'a aucune donn�e � v�rifier dans le cas d'un SELECT
		 * On se contente de transmettre la requ�te au DAO
		 */
		try {
			return dao.selectAll();
		} catch (DALException e) {
			throw new BLLException("Echec de la r�cup�ration des employ�s", e);
		}
	}
	
	public Employe selectById(int id) throws BLLException {
		try {
			return dao.selectById(id);
		} catch (DALException e) {
			throw new BLLException("Echec de la r�cup�ration de l'employ� d'id " + id, e);
		}
	}
	
	public void insert(int id, String nom, String prenom, LocalDate dateNaissance, float salaire) throws BLLException {
		/*
		 * Plein de contr�les certainement tr�s pertinents sur les donn�es
		 */
		Employe employe = new Employe(id, nom, prenom, dateNaissance, salaire);
		try {
			dao.insert(employe);
		} catch (DALException e) {
			throw new BLLException("Echec de l'insertion", e);
		}
	}
	
	public void update(Employe employe) throws BLLException {
		/*
		 * Des contr�les tr�s pertinents
		 */
		try {
			dao.update(employe);
		} catch (DALException e) {
			throw new BLLException("Echec de la mise � jour", e);
		}
	}
	
	public void delete(int id) throws BLLException {
		try {
			dao.delete(id);
		} catch (DALException e) {
			throw new BLLException("Echec de la suppression", e);
		}
	}
}
