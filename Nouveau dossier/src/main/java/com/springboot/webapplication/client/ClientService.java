package com.springboot.webapplication.client;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

//@Component
@Service
public class ClientService{
	private final UserDao userDao;
	
	@Autowired
	public ClientService(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public List<Client> getClient(){
		return userDao.findAll();
	}
	
	public String create(String email, String id) {
		Client client;
		try {
			// we will add an email control later (email must be unique)
			client = new Client("Mohamed", "Fathi", email, Integer.parseInt(id), LocalDate.of(2000, Month.MARCH, 5));
			userDao.save(client);
		} catch (Exception ex) {
			return "Client not found";
		}
		return client.getNom() + " account is succesfully created";
	}
	
	public String delete(long id) {
		try {
			// if we delete a client it must be redirected to home page (like logout)--add it later
			Client client = userDao.getById(id);
			userDao.delete(client);
		} catch(Exception ex) {
			return "Error precess D failed";
		}
		return "Client succesfully deleted";
	}		

	public String update(long id) {
		try {
		Client client = userDao.getById(id);
		// if the new email is not match the old one then we update it else we have an ERROR
		if (!(client.getEmail().equals(" ")) ) {
			client.setEmail("ThisNewEmail@gmail.com");
			userDao.save(client);
		}
		else return "New email matches the old one";
		} catch (Exception ex) {
			return "Error process UP failed";
		}
		return "Client succesfully updated";
	}

	/*boolean search(@Param("Username") String username, @Param("Password") String password){
		Client client = new Client(username, password);
		return userDao.existsById(client.getId());
	}*/



}
