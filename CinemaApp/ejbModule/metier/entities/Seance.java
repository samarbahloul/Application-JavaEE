package metier.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Seance
 *
 */
@Entity
@Table(name="SEANCE")

public class Seance implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private Date horaire;
	private int places;
	private float tarif;
	@ManyToOne
	private SalleProg salleprog;
	private static final long serialVersionUID = 1L;

	public Seance() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public Date getHoraire() {
		return this.horaire;
	}

	public void setHoraire(Date horaire) {
		this.horaire = horaire;
	}   
	public int getPlaces() {
		return this.places;
	}

	public void setPlaces(int places) {
		this.places = places;
	}   
	public float getTarif() {
		return this.tarif;
	}

	public void setTarif(float tarif) {
		this.tarif = tarif;
	}
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Seance[id=").append(getId()).append(", horaire=").
		append(getHoraire()).append(", places=").
		append(getPlaces()).append(", tarif=").
		append(getTarif()).append("]");
		return sb.toString();
	}
   
}
