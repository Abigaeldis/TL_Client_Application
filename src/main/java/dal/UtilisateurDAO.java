package dal;

import bo.Utilisateur;

public interface UtilisateurDAO extends GenericDAO<Utilisateur> {
	Utilisateur validateCredentials(String mail, String motdepasse) throws DALException;
	}

