package dal;

import bo.Utilisateur;

public interface UtilisateurDAO extends GenericDAO<Utilisateur> {
	Utilisateur validateCredentials(String nom, String motdepasse) throws DALException;
	}

