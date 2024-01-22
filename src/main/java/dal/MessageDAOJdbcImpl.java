package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bll.BLLException;
import bll.RestaurantBLL;
import bo.Message;
import bo.Restaurant;
import bo.Utilisateur;

// CRUD
public class MessageDAOJdbcImpl implements GenericDAO<Message> {
	private static final String TABLE_NAME = " messages ";
	
	private static final String DELETE = "DELETE FROM"+ TABLE_NAME +" WHERE id = ?";
	private static final String UPDATE = "UPDATE "+ TABLE_NAME +" SET titre = ?, corps_message = ?, id_restaurant = ?, id_utilisateur = ? WHERE id = ?";
	private static final String INSERT = "INSERT INTO "+ TABLE_NAME +" (titre, corps_message, id_restaurant, id_utilisateur) VALUES (?,?,?,?)";
	private static final String SELECT_BY_ID = "SELECT * FROM "+ TABLE_NAME +" WHERE id = ?";
	private static final String SELECT = "SELECT * FROM "+ TABLE_NAME;
	
	private Connection cnx;
	
	
	public MessageDAOJdbcImpl() throws DALException {
		cnx = ConnectionProvider.getConnection();
	}
	
	
	////////////////////////////////////////////////////////////////////////
	
	
	public List<Message> selectAll() throws DALException {
		List<Message> messages = new ArrayList<>(); 
		// alt + shift + r pour renommer partout
		
		try {
			PreparedStatement ps = cnx.prepareStatement(SELECT);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Message message = new Message();
				message.setId(rs.getInt("id"));
				message.setTitre(rs.getString("titre"));
				message.setCorpsMessage(rs.getString("corps_message"));
				int idRestaurant = rs.getInt("id_restaurant");
				RestaurantBLL restaurantBll = new RestaurantBLL();
				Restaurant restaurant = restaurantBll.selectById(idRestaurant);
				message.setRestaurant(restaurant);
				int idUtilisateur = rs.getInt("id_utilisateur");
				UtilisateurBLL utilisateurBll = new UtilisateurBLL();
				Utilisateur utilisateur = utilisateurBll.selectById(idUtilisateur);
				message.setUtilisateur(utilisateur);
				messages.add(message);
			}
		} catch (SQLException | BLLException e) {
			throw new DALException("Impossible de recuperer les informations", e);
		}
		return messages;
	}
	
	public Message selectById(int id) throws DALException {
		Message message = null;
		try {
			PreparedStatement ps = cnx.prepareStatement(SELECT_BY_ID);
			ps.setInt(1, id); // Remplace le '?' numero 1 par la valeur de l'id
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				message = new Message();
				message.setId(rs.getInt("id"));
				message.setTitre(rs.getString("titre"));
				message.setCorpsMessage(rs.getString("corps_message"));
				int idRestaurant = rs.getInt("id_restaurant");
				RestaurantBLL restaurantBll = new RestaurantBLL();
				Restaurant restaurant = restaurantBll.selectById(idRestaurant);
				message.setRestaurant(restaurant);
				int idUtilisateur = rs.getInt("id_utilisateur");
				UtilisateurBLL utilisateurBll = new UtilisateurBLL();
				Utilisateur utilisateur = utilisateurBll.selectById(idUtilisateur);
				message.setUtilisateur(utilisateur);
			}
		} catch (SQLException | BLLException e) {
			throw new DALException("Impossible de recuperer le message d'id "+ id, e);
		}
		return message;
	}
	
	public void insert(Message message) throws DALException {
		try {
			// L'ajout de RETURN_GENERATED_KEYS permet de récupérer l'id généré par la base
			PreparedStatement ps = cnx.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, message.getTitre());
			ps.setString(2, message.getCorpsMessage());
			ps.setInt(3, message.getRestaurant().getId());
			ps.setInt(4, message.getUtilisateur().getId());
			ps.executeUpdate();
			// Le bloc suivant permet de faire la récupération de l'id
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) { // Va chercher dans le resultat, la première ligne
				int id = rs.getInt(1); // plus précisément, le int à la première colonne
				message.setId(id);
			}
		} catch (SQLException e) {
			throw new DALException("Impossible d'inserer les donnees.", e);
		}
	}
	
	public void update(Message message) throws DALException {
		try {
			PreparedStatement ps = cnx.prepareStatement(UPDATE);
			ps.setString(1, message.getTitre());
			ps.setString(2, message.getCorpsMessage());
			ps.setInt(3, message.getRestaurant().getId());
			ps.setInt(4, message.getUtilisateur().getId());
			ps.setInt(5, message.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new DALException("Impossible de mmodifier le message d'id "+ message.getId(), e);
		}
	}
	
	public void delete(int id) throws DALException {
		try {
			PreparedStatement ps = cnx.prepareStatement(DELETE);
			ps.setInt(1, id);
			int nbLignesSupprimees = ps.executeUpdate();
			if (nbLignesSupprimees == 0) {
				throw new DALException("Echec de suppression du message d'id " + id, null);
			}
		} catch (SQLException e) {
			throw new DALException("Impossible de supprimer le message d'id "+ id, e);
		}
	}
}
