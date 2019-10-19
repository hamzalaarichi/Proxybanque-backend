package ma.jit.proxybanque.spring.web.models;


import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE_EMPLOYE", discriminatorType = DiscriminatorType.STRING, length = 1)
public abstract class Employer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String nom, prenom, username, email, adresse;
	@JsonIgnore
	private String password;
	@ManyToOne
	@JoinColumn(name = "CODE_AGENCE")
	@JsonIgnoreProperties("employes")
	private Agence agence;
	protected String type;
	protected int idResponsable;

	public Employer() {
		this.setType();
	}

	public Employer(int id) {
		this();
		this.id = id;
	}

	public Employer(String nom, String prenom, String username, String password, String email, String adresse) {
		this();
		this.nom = nom;
		this.prenom = prenom;
		this.username = username;
		this.password = password;
		this.email = email;
		this.adresse = adresse;
	}

	public Employer(int id, String nom, String prenom, String username, String password, String email, String adresse) {
		this(nom, prenom, username, password,email, adresse);
		this.id = id;
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

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Agence getAgence() {
		return agence;
	}

	public void setAgence(Agence agence) {
		this.agence = agence;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public String getType() {
		return type;
	}

	public int getIdResponsable() {
		return idResponsable;
	}
	
	public abstract void setType();
	public abstract void setIdResponsable(int idReponsable);
	
}
