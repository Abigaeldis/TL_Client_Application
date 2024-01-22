package dal;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/*
 * Classe utilitaire pour mutualiser la connexion à la base de données
 * De cette manière, il n'est pas nécessaire de copier coller le code de connexion dans chaque DAO
 */

public abstract class ConnectionProvider {
	private static Connection cnx;
	public static Connection getConnection() throws DALException {
		try {
			Context context = new InitialContext();
			String id_env = System.getenv("USER_SQLSERVER");
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/"+ id_env);
			cnx = dataSource.getConnection();
			return cnx;
		} catch (SQLException e) {
			throw new DALException("Erreur de connexion � la base de donn�es", e);
		} catch (NamingException e) {
			e.printStackTrace();
		}
		return null;
	}
}
