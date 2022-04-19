package metier.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: SalleProg
 *
 */
@Entity
@Table(name="SALLEPROG")
@NamedQueries({  
@NamedQuery(name = "findAllSalleProg", query = "SELECT sp FROM SalleProg sp")
})
public class SalleProg implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id_salleprog;
	@ManyToOne
	private Film film;
	@OneToMany(mappedBy="salleprog")
	private Collection<Seance> seance;
	@OneToOne(mappedBy="salleprog")
	private Salle salle;
	private static final long serialVersionUID = 1L;
	
	public Salle getSalle(){
		return salle;
	}
	public void setSalle(Salle s){
		this.salle=s;
	}

	public Film getFilm() {
		return film;
	}
	public void setFilm(Film film) {
		this.film=film;
	}

	public SalleProg() {
		super();
	}   
	public int getId() {
		return this.id_salleprog;
	}

	public void setId(int id) {
		this.id_salleprog = id;
	}
   
}
