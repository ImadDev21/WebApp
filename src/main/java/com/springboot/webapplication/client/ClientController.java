package com.springboot.webapplication.client;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.Month;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

@RestController
//@RequestMapping(value = "/")
public class ClientController{
	private final ClientService clientservice;
	
	
	@Autowired
	public ClientController (ClientService clientservice) {
		//this.clientservice = new ClientService();
		this.clientservice = clientservice;
	}
	
	@RequestMapping("/show")
	public List<Client> getClient(){
		return clientservice.getClient();
	}
	
	@RequestMapping("/create")
	public String create(String email, String id) {
		return clientservice.create(email, id);
	}
	
	@RequestMapping("/delete")
	public String delete(long id) {
		return clientservice.delete(id);
	}
	
	@RequestMapping("/update")
	public String update(long id) {
		return clientservice.update(id);
	}

}
