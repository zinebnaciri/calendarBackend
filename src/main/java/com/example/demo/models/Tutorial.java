package com.example.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tutorials")
public class Tutorial {

  @Id
  @Column(name = "id")
  private int id;

  @Column(name = "Nom")
  private String Nom;

  @Column(name = "Prenom")
  private String Prenom;
  

  @Column(name = "CNE")
  private String CNE;
  

  @Column(name = "Filiere")
  private String Filiere;
  

  @Column(name = "Semester")
  private String Semester;

  @Column(name = "Email")
  private String Email;

  public Tutorial() {

  }

public Tutorial(int id, String nom, String prenom, String cNE, String filiere, String semester, String email) {
	super();
	this.id = id;
	Nom = nom;
	Prenom = prenom;
	CNE = cNE;
	Filiere = filiere;
	Semester = semester;
	Email = email;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getNom() {
	return Nom;
}

public void setNom(String nom) {
	Nom = nom;
}

public String getPrenom() {
	return Prenom;
}

public void setPrenom(String prenom) {
	Prenom = prenom;
}

public String getCNE() {
	return CNE;
}

public void setCNE(String cNE) {
	CNE = cNE;
}

public String getFiliere() {
	return Filiere;
}

public void setFiliere(String filiere) {
	Filiere = filiere;
}

public String getSemester() {
	return Semester;
}

public void setSemester(String semester) {
	Semester = semester;
}

public String getEmail() {
	return Email;
}

public void setEmail(String email) {
	Email = email;
}

  
}
