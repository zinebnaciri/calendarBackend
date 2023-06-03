package com.example.demo.models;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.Collection;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
public class ModuleEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
  	
  	private String nom;
  	
  	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	  @JoinColumn(name = "filiere_id", nullable = false)
	  @OnDelete(action = OnDeleteAction.CASCADE)
	  @JsonIgnore
	  private Filiere filiere;
  	
  	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	  @JoinColumn(name = "semestre_id", nullable = false)
	  @OnDelete(action = OnDeleteAction.CASCADE)
	  @JsonIgnore
	  private Semester semestre;
	
  	
  	
  	
  	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Collection<Enseignant> getEnseignants() {
		return enseignants;
	}

	public void setEnseignants(Collection<Enseignant> enseignants) {
		this.enseignants = enseignants;
	}

	@ManyToMany(mappedBy = "modules", fetch= FetchType.EAGER)
  	private Collection<Enseignant> enseignants = new ArrayList<>();



	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Filiere getFiliere() {
		return filiere;
	}

	public void setFiliere(Filiere filiere) {
		this.filiere = filiere;
	}

	public Semester getSemestre() {
		return semestre;
	}

	public void setSemestre(Semester semestre) {
		this.semestre = semestre;
	}
	
	

}
