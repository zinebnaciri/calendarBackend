package com.example.demo.models;

import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
public class Filiere {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String nom;
	private String code;
	 @OneToMany(mappedBy = "filiere", cascade = CascadeType.ALL)
	    private List<User> users;
	 
	 public List<User> getUsers() {
		return users;
	}



	public Filiere(int id, String nom, String code) {
		super();
		this.id = id;
		this.nom = nom;
		this.code = code;
	}



	public void setUsers(List<User> users) {
		this.users = users;
	}



	public Filiere(int id) {
	        this.id = id;
	    }
	 
	 

	


	public Filiere(int id, String nom, String code, List<User> users) {
		super();
		this.id = id;
		this.nom = nom;
		this.code = code;
		this.users = users;
	}



	public Filiere() {
		super();
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	

}
