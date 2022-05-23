package com.springboot.webapplication.client;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import org.springframework.lang.NonNull;

@Entity
@Table(name = "clients")
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NonNull
	private String nom, prenom, email;
	
	@NonNull
	private int age;
	
	@NonNull
	private LocalDate Date_naissance;
	
	public Client(Long id, String nom, String prenom, String email, int age, LocalDate date_naissance) {
		this.id = id; 
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.age = age;
		Date_naissance = date_naissance;
	}
	
	public Client(String nom, String prenom, String email, int age, LocalDate date_naissance) {
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.age = age;
		Date_naissance = date_naissance;
	}

	public Client (String nom, String prenom){
		this.nom = nom;
		this.prenom = prenom;
	}
	
	public Client (Long id) {
		this.id = id;
	}
	
	public Client() {
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public LocalDate getDate_naissance() {
		return Date_naissance;
	}
	public void setDate_naissance(LocalDate date_naissance) {
		Date_naissance = date_naissance;
	}
	
}
