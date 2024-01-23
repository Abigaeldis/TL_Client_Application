package bll;

import java.util.List;

import bo.Message;
import dal.DALException;
import dal.GenericDAO;
import dal.MessageDAOJdbcImpl;

public class MessageBLL {
	private GenericDAO<Message> dao;
	
	public MessageBLL() throws BLLException {
		try {
			dao = new MessageDAOJdbcImpl();
		} catch (DALException e) {
			throw new BLLException("Echec de la connexion", e);
		}
	}
	
	public List<Message> selectAll() throws BLLException {
		try {
			return dao.selectAll();
		} catch (DALException e) {
			throw new BLLException("", e);
		}
	}
	
	public Message selectById(int id) throws BLLException {
		try {
			return dao.selectById(id);
		} catch (DALException e) {
			throw new BLLException("Echec de la recuperation du message d'id " + id, e);
		}
	}
	
	public Message insert(Message message) throws BLLException {
		BLLException blleException = new BLLException();

		if (message.getTitre().length() < 2) {
			blleException.ajouterErreur("Le titre du message doit faire au moins 2 caractères");
		}
		
		if (message.getTitre().length() > 50) {
			blleException.ajouterErreur("Le titre du message doit faire au maximum 50 caractères");
		}
		
		if (message.getCorpsMessage().length() < 2) {
			blleException.ajouterErreur("Le corps de votre message doit faire au moins 2 caractères");
		}
		
		if (message.getCorpsMessage().length() > 300) {
			blleException.ajouterErreur("Le corps de votre message doit faire au maximum 300 caractères");
		}
		
		if (blleException.getErreurs().size() > 0) {
			throw blleException;
		}
		
		try {
			dao.insert(message);
		} catch (DALException e) {
			throw new BLLException("Echec de l'insertion", e);
		}
		return message;
	}
	
	public void update(Message message) throws BLLException {
		try {
			dao.update(message);
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
}
