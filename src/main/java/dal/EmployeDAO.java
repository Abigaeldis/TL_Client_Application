package dal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import bo.Employe;

// CRUD
public class EmployeDAO {
	private static final String DELETE = "DELETE FROM employes WHERE id = ?";
	private static final String UPDATE = "UPDATE employes SET nom = ?, prenom = ?, date_naissance = ?, salaire = ? WHERE id = ?";
	private static final String INSERT = "INSERT INTO employes (id, nom, prenom, date_naissance, salaire, id_service) VALUES (?,?,?,?,?,'DIRGE')";
	private static final String SELECT_BY_ID = "SELECT * FROM employes WHERE id = ?";
	private static final String SELECT = "SELECT * FROM employes";
	
	private Connection cnx;
	
	public EmployeDAO() throws DALException {
		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/toto");
			cnx = dataSource.getConnection();
		} catch (SQLException e) {
			throw new DALException("Erreur de connexion � la base de donn�es", e);
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public List<Employe> selectAll() throws DALException {
		List<Employe> employes = new ArrayList<>(); 
		// alt + shift + r pour renommer partout
		
		try {
			PreparedStatement ps = cnx.prepareStatement(SELECT);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Employe employe = new Employe();
				employe.setId(rs.getInt("id"));
				employe.setNom(rs.getString("nom"));
				employe.setPrenom(rs.getString("prenom"));
				employe.setSalaire(rs.getFloat("salaire"));
				employe.setDateNaissance(rs.getDate("date_naissance").toLocalDate());
				
				employes.add(employe);
			}
		} catch (SQLException e) {
			throw new DALException("Impossible de r�cup�rer les informations", e);
		}
		return employes;
	}
	
	public Employe selectById(int id) throws DALException {
		Employe employe = null;
		try {
			PreparedStatement ps = cnx.prepareStatement(SELECT_BY_ID);
			ps.setInt(1, id); // Remplace le '?' num�ro 1 par la valeur de l'id
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				employe = new Employe();
				employe.setId(rs.getInt("id"));
				employe.setNom(rs.getString("nom"));
				employe.setPrenom(rs.getString("prenom"));
				employe.setSalaire(rs.getFloat("salaire"));
				employe.setDateNaissance(rs.getDate("date_naissance").toLocalDate());
			}
		} catch (SQLException e) {
			throw new DALException("Impossible de r�cup�rer les informations pour l'id "+ id, e);
		}
		return employe;
	}
	
	public void insert(Employe employe) throws DALException {
		try {
			PreparedStatement ps = cnx.prepareStatement(INSERT);
			ps.setInt(1, employe.getId());
			ps.setString(2, employe.getNom());
			ps.setString(3, employe.getPrenom());
			ps.setDate(4, Date.valueOf(employe.getDateNaissance()));
			ps.setFloat(5, employe.getSalaire());
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new DALException("Impossible d'ins�rer les donn�es.", e);
		}
	}
	
	public void update(Employe employe) throws DALException {
		try {
			PreparedStatement ps = cnx.prepareStatement(UPDATE);
			ps.setString(1, employe.getNom());
			ps.setString(2, employe.getPrenom());
			ps.setDate(3, Date.valueOf(employe.getDateNaissance()));
			ps.setFloat(4, employe.getSalaire());
			ps.setInt(5, employe.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new DALException("Impossible de mettre � jour les informations pour l'id "+ employe.getId(), e);
		}
	}
	
	public void delete(int id) throws DALException {
		try {
			PreparedStatement ps = cnx.prepareStatement(DELETE);
			ps.setInt(1, id);
			int nbLignesSupprimees = ps.executeUpdate();
			if (nbLignesSupprimees == 0) {
				throw new DALException("Echec de suppression de l'employ� d'id " + id, null);
			}
		} catch (SQLException e) {
			throw new DALException("Impossible de supprimer l'employ� d'id "+ id, e);
		}
	}
}
