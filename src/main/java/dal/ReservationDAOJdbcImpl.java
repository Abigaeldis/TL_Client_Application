package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import bll.BLLException;
import bll.RestaurantBLL;
import bll.TableBLL;
import bll.UtilisateurBLL;
import bo.Reservation;
import bo.Restaurant;
import bo.Table;
import bo.Utilisateur;

// CRUD
public class ReservationDAOJdbcImpl implements GenericDAO<Reservation> {
	private static final String TABLE_NAME = " reservations ";
	
	private static final String DELETE = "DELETE FROM"+ TABLE_NAME +" WHERE id = ?";
	private static final String UPDATE = "UPDATE "+ TABLE_NAME +" SET date = ?, statut = ?,nb_personne = ?,id_utilisateur = ?, id_table = ?, id_restaurant = ? WHERE id = ?";
	private static final String INSERT = "INSERT INTO "+ TABLE_NAME +" (date, statut, nb_personne,id_utilisateur, id_restaurant) VALUES (?,?,?,?,?)";
	private static final String SELECT_BY_ID = "SELECT * FROM "+ TABLE_NAME +" WHERE id = ?";
	private static final String SELECT = "SELECT * FROM "+ TABLE_NAME;
	
	public ReservationDAOJdbcImpl() throws DALException {
	}
	
	public List<Reservation> selectAll() throws DALException {
		List<Reservation> reservations = new ArrayList<>();
		
		try (Connection cnx = ConnectionProvider.getConnection()){
			PreparedStatement ps = cnx.prepareStatement(SELECT);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Reservation reservation = new Reservation();
				reservation.setId(rs.getInt("id"));
				reservation.setDate(rs.getTimestamp("date").toLocalDateTime());
				reservation.setStatut(rs.getString("statut"));
				reservation.setNbPersonne(rs.getInt("nb_personne"));
				
				int idUtilisateur = rs.getInt("id_utilisateur");
				UtilisateurBLL utilisateurBll = new UtilisateurBLL();
				Utilisateur utilisateur = utilisateurBll.selectById(idUtilisateur);
				reservation.setUtilisateur(utilisateur);
				
				int idTable = rs.getInt("id_table");
				TableBLL tableBll = new TableBLL();
				Table table = tableBll.selectById(idTable);
				reservation.setTable(table);
				
				int idRestaurant = rs.getInt("id_restaurant");
				RestaurantBLL restaurantBll = new RestaurantBLL();
				Restaurant restaurant = restaurantBll.selectById(idRestaurant);
				reservation.setRestaurant(restaurant);
				
				reservations.add(reservation);
			}
		} catch (SQLException | BLLException e) {
			throw new DALException("Impossible de recuperer les informations", e);
		}
		return reservations;
	}
	
	public Reservation selectById(int id) throws DALException {
		Reservation reservation = null;
		try (Connection cnx = ConnectionProvider.getConnection()){
			PreparedStatement ps = cnx.prepareStatement(SELECT_BY_ID);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				reservation = new Reservation();
				reservation.setId(rs.getInt("id"));
				reservation.setDate(rs.getTimestamp("date").toLocalDateTime());
				reservation.setStatut("En attente");
				reservation.setNbPersonne(rs.getInt("nb_personne"));
				
				int idUtilisateur = rs.getInt("id_utilisateur");
				UtilisateurBLL utilisateurBll = new UtilisateurBLL();
				Utilisateur utilisateur = utilisateurBll.selectById(idUtilisateur);
				reservation.setUtilisateur(utilisateur);
				
				int idTable = rs.getInt("id_table");
				TableBLL tableBll = new TableBLL();
				Table table = tableBll.selectById(idTable);
				reservation.setTable(table);
				
				int idRestaurant = rs.getInt("id_restaurant");
				RestaurantBLL restaurantBll = new RestaurantBLL();
				Restaurant restaurant = restaurantBll.selectById(idRestaurant);
				reservation.setRestaurant(restaurant);
			}
		} catch (SQLException | BLLException e) {
			throw new DALException("Impossible de recuperer les informations pour l'id "+ id, e);
		}
		return reservation;
	}
	
	public void insert(Reservation reservation) throws DALException {
		try (Connection cnx = ConnectionProvider.getConnection()){
			// L'ajout de RETURN_GENERATED_KEYS permet de récupérer l'id généré par la base
			PreparedStatement ps = cnx.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setTimestamp(1, Timestamp.valueOf(reservation.getDate()));
			ps.setString(2, "En attente");
			ps.setInt(3, reservation.getNbPersonne());
			ps.setInt(4, reservation.getUtilisateur().getId());
			ps.setInt(5, reservation.getRestaurant().getId());
			ps.executeUpdate();
			
			// Le bloc suivant permet de faire la récupération de l'id
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) { // Va chercher dans le resultat, la première ligne
				int id = rs.getInt(1); // plus précisément, le int à la première colonne
				reservation.setId(id);
			}
		} catch (SQLException e) {
			throw new DALException("Impossible d'inserer les donnees.", e);
		}
	}
	
	public void update(Reservation reservation) throws DALException {
		try (Connection cnx = ConnectionProvider.getConnection()){
			PreparedStatement ps = cnx.prepareStatement(UPDATE);
			ps.setTimestamp(1, Timestamp.valueOf(reservation.getDate()));
			ps.setString(2, reservation.getStatut());
			ps.setInt(3, reservation.getNbPersonne());
			ps.setInt(4, reservation.getUtilisateur().getId());
			ps.setInt(5, reservation.getTable().getId());
			ps.setInt(6, reservation.getRestaurant().getId());
			ps.setInt(7, reservation.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new DALException("Impossible de mettre a jour les informations pour l'id "+ reservation.getId(), e);
		}
	}
	
	public void delete(int id) throws DALException {
		try (Connection cnx = ConnectionProvider.getConnection()){
			PreparedStatement ps = cnx.prepareStatement(DELETE);
			ps.setInt(1, id);
			int nbLignesSupprimees = ps.executeUpdate();
			if (nbLignesSupprimees == 0) {
				throw new DALException("Echec de suppression de la réservation d'id " + id, null);
			}
		} catch (SQLException e) {
			throw new DALException("Impossible de supprimer la réservation d'id "+ id, e);
		}
	}
}
