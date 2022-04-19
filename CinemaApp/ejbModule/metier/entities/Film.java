package metier.entities;
import java.io.Serializable;
import java.lang.String;
import java.util.Collection;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Film
 *
 */
@Entity
@Table(name="FILM")
@NamedQueries({  
@NamedQuery(name = "findAllFilms", query = "SELECT f FROM Film f"),
@NamedQuery(name = "findFilmById", query = "SELECT f FROM Film f WHERE f.id =  :fid")

})  
public class Film implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String nom;
	@OneToMany(mappedBy="film")
	private Collection<SalleProg> salleprog;
	private static final long serialVersionUID = 1L;

	public Film() {
		super();
	}   
	public Film(int id,String nom) {
		this.id=id;
		this.nom=nom;
	}
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	public Collection<SalleProg> getSalleProg(){
		return salleprog;
	}
	public void setSalleProg(Collection<SalleProg> salleprog) {
		this.salleprog=salleprog;
	}
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Film[id=").append(getId()).append(", name=").
		append(getNom()).append("]");
		return sb.toString();
	}
}
