package bll;

import java.time.LocalDateTime;
import java.util.List;

import bo.Utilisateur;
import dal.DALException;
import dal.UtilisateurDAO;
import dal.UtilisateurDAOJdbcImpl;
import jakarta.servlet.http.HttpServletRequest;

public class UtilisateurBLL {
	private UtilisateurDAO dao;
	
	public UtilisateurBLL() throws BLLException {
		try {
			dao = new UtilisateurDAOJdbcImpl();
		} catch (DALException e) {
			throw new BLLException("Echec de la connexion", e);
		}
	}
	
	public List<Utilisateur> selectAll() throws BLLException {
		try {
			return dao.selectAll();
		} catch (DALException e) {
			throw new BLLException("Echec de la recuperation des utilisateurs", e);
		}
	}
	
	public Utilisateur selectById(int id) throws BLLException {
		try {
			return dao.selectById(id);
		} catch (DALException e) {
			throw new BLLException("Echec de la recuperation de la utilisateur d'id " + id, e);
		}
	}
	
	public Utilisateur insert(String nom, String prenom, String mail, String motdepasse, String telephone, String adresse) throws BLLException {
		BLLException blleException = new BLLException();
		if (nom == "" || nom == null) {
			blleException.ajouterErreur("Veuillez compléter le nom.");
		}
		
		if (prenom == "" || prenom == null) {
			blleException.ajouterErreur("Veuillez compléter le prénom.");
		}
		
		if (mail == "" || mail == null) {
			blleException.ajouterErreur("Veuillez compléter le mail.");
		}
		
		if (motdepasse == "" || motdepasse == null) {
			blleException.ajouterErreur("Veuillez compléter le mot de passe.");
		}
		
		if (blleException.getErreurs().size() > 0) {
			throw blleException;
		}		
		
		Utilisateur utilisateur = new Utilisateur(nom, prenom, mail, motdepasse, telephone, adresse);
		try {
			dao.insert(utilisateur);
		} catch (DALException e) {
			throw new BLLException("Echec de l'insertion", e);
		}
		return utilisateur;
	}
	
	public void update(Utilisateur utilisateur) throws BLLException {
		BLLException blleException = new BLLException();
		if (utilisateur.getNom() == "" || utilisateur.getNom() == null) {
			blleException.ajouterErreur("Veuillez compléter le nom.");
		}
		
		if (utilisateur.getPrenom() == "" || utilisateur.getPrenom() == null) {
			blleException.ajouterErreur("Veuillez compléter le prénom.");
		}
		
		if (utilisateur.getMail() == "" || utilisateur.getMail() == null) {
			blleException.ajouterErreur("Veuillez compléter le mail.");
		}
		
		if (utilisateur.getMotdepasse() == "" || utilisateur.getMotdepasse() == null) {
			blleException.ajouterErreur("Veuillez compléter le mot de passe.");
		}
		
		if (blleException.getErreurs().size() > 0) {
			throw blleException;
		}		
		
		try {
			dao.update(utilisateur);
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
	
	public Utilisateur authenticateUser(String mail, String motdepasse, HttpServletRequest request) throws BLLException {
	    try {
	        return dao.validateCredentials(mail, motdepasse);
	    } catch (DALException e) {
	        throw new BLLException("Error authenticating user", e);
	    }
	}


}
