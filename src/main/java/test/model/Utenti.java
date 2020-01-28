package test.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the utenti database table.
 * 
 */
@Entity
@NamedQuery(name="Utenti.findAll", query="SELECT u FROM Utenti u")
public class Utenti implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String cognome;

	private String nome;

	public Utenti() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCognome() {
		return this.cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}