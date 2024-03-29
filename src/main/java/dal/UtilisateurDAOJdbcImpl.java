package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bll.BLLException;
import bll.RestaurantBLL;
import bo.Restaurant;
import bo.Utilisateur;

// CRUD
public class UtilisateurDAOJdbcImpl implements UtilisateurDAO {
	private static final String TABLE_NAME = "utilisateurs";
	private static final String DELETE = "DELETE FROM "+ TABLE_NAME +" WHERE id = ?";
	private static final String UPDATE = "UPDATE "+ TABLE_NAME +" SET nom = ?, prenom = ?, mail = ?, motdepasse = ?, telephone = ?, adresse = ? WHERE id = ?";
	private static final String INSERT = "INSERT INTO "+ TABLE_NAME +" (nom, prenom, mail, motdepasse, telephone, adresse) VALUES (?,?,?,?,?,?)";
	private static final String SELECT_BY_ID = "SELECT * FROM "+ TABLE_NAME +" WHERE id = ?";
	private static final String SELECT = "SELECT * FROM "+ TABLE_NAME;
	private static final String SELECT_BY_NOM_AND_MOTDEPASSE = "SELECT * FROM "+ TABLE_NAME +" WHERE mail = ? AND motdepasse = ?";
	
	private Connection cnx;
	
	public UtilisateurDAOJdbcImpl() throws DALException {
		cnx = ConnectionProvider.getConnection();
	}
	
	public List<Utilisateur> selectAll() throws DALException {
		List<Utilisateur> utilisateurs = new ArrayList<>(); 
		
		try {
			PreparedStatement ps = cnx.prepareStatement(SELECT);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Utilisateur utilisateur = new Utilisateur();
				utilisateur.setId(rs.getInt("id"));
				utilisateur.setNom(rs.getString("nom"));
				utilisateur.setPrenom(rs.getString("prenom"));
				utilisateur.setMail(rs.getString("mail"));
				utilisateur.setMotdepasse(rs.getString("motdepasse"));
				utilisateur.setTelephone(rs.getString("telephone"));
				utilisateur.setAdresse(rs.getString("adresse"));
				utilisateur.setRole(rs.getString("role"));		
				
				int idRestaurant = rs.getInt("id_restaurant");
				RestaurantBLL restaurantBll = new RestaurantBLL();
				Restaurant restaurant = restaurantBll.selectById(idRestaurant);
				utilisateur.setRestaurant(restaurant);
				utilisateurs.add(utilisateur);
			}
		} catch (SQLException | BLLException e) {
			throw new DALException("Impossible de recuperer les informations", e);
		}
		return utilisateurs;
	}
	
	public Utilisateur selectById(int id) throws DALException {
		Utilisateur utilisateur = null;
		try {
			PreparedStatement ps = cnx.prepareStatement(SELECT_BY_ID);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				utilisateur = new Utilisateur();
				utilisateur.setId(rs.getInt("id"));
				utilisateur.setNom(rs.getString("nom"));
				utilisateur.setPrenom(rs.getString("prenom"));
				utilisateur.setMail(rs.getString("mail"));
				utilisateur.setMotdepasse(rs.getString("motdepasse"));
				utilisateur.setTelephone(rs.getString("telephone"));
				utilisateur.setAdresse(rs.getString("adresse"));
				utilisateur.setRole(rs.getString("role"));	
				
				int idRestaurant = rs.getInt("id_restaurant");
				RestaurantBLL restaurantBll = new RestaurantBLL();
				Restaurant restaurant = restaurantBll.selectById(idRestaurant);
				utilisateur.setRestaurant(restaurant);
			}
		} catch (SQLException | BLLException e) {
			throw new DALException("Impossible de recuperer les informations pour l'id "+ id, e);
		}
		return utilisateur;
	}
	
	public void insert(Utilisateur utilisateur) throws DALException {
		try {
			// L'ajout de RETURN_GENERATED_KEYS permet de récupérer l'id généré par la base
			PreparedStatement ps = cnx.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, utilisateur.getNom());
			ps.setString(2, utilisateur.getPrenom());
			ps.setString(3, utilisateur.getMail());
			ps.setString(4, utilisateur.getMotdepasse());
			ps.setString(5, utilisateur.getTelephone());
			ps.setString(6, utilisateur.getAdresse());
			ps.executeUpdate();
			
			// Le bloc suivant permet de faire la récupération de l'id
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) { // Va chercher dans le resultat, la première ligne
				int id = rs.getInt(1); // plus précisément, le int à la première colonne
				utilisateur.setId(id);
			}
		} catch (SQLException e) {
			throw new DALException("Impossible d'inserer les donnees.", e);
		}
	}
	
	public void update(Utilisateur utilisateur) throws DALException {
		try {
			PreparedStatement ps = cnx.prepareStatement(UPDATE);
			ps.setString(1, utilisateur.getNom());
			ps.setString(2, utilisateur.getPrenom());
			ps.setString(3, utilisateur.getMail());
			ps.setString(4, utilisateur.getMotdepasse());
			ps.setString(5, utilisateur.getTelephone());
			ps.setString(6, utilisateur.getAdresse());
			ps.setInt(7, utilisateur.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new DALException("Impossible de mettre a jour les informations pour l'id "+ utilisateur.getId(), e);
		}
	}
	
	public void delete(int id) throws DALException {
		try {
			PreparedStatement ps = cnx.prepareStatement(DELETE);
			ps.setInt(1, id);
			 ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("Impossible de supprimer le composant d'id "+ id, e);
		}
	}
	
	public Utilisateur validateCredentials(String mail, String motdepasse) throws DALException {
	    Utilisateur utilisateur = null;
	    try {
	        try (PreparedStatement ps = cnx.prepareStatement(SELECT_BY_NOM_AND_MOTDEPASSE)) {
	            ps.setString(1, mail);
	            ps.setString(2, motdepasse);
	            ResultSet rs = ps.executeQuery();
	            if (rs.next()) {
	                utilisateur = new Utilisateur();
	                utilisateur.setId(rs.getInt("id"));
					utilisateur.setNom(rs.getString("nom"));
					utilisateur.setNom(rs.getString("prenom"));
					utilisateur.setMail(rs.getString("mail"));
					utilisateur.setMotdepasse(rs.getString("motdepasse"));
					utilisateur.setTelephone(rs.getString("telephone"));
					utilisateur.setAdresse(rs.getString("adresse"));
					utilisateur.setRole(rs.getString("role"));	
	            }
	        }
	    } catch (SQLException e) {
	        throw new DALException("Error validating credentials", e);
	    }
	    return utilisateur;
	}
}
