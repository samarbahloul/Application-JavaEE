package metier.entities;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Salle
 *
 */
@Entity
@Table(name="SALLE")


public class Salle implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String adress;
	private int capacite; 
	@OneToOne
	private SalleProg salleprog;
	private static final long serialVersionUID = 1L;
	
	@JoinColumn(name="id_salleprog")
	public SalleProg getsalleprog(){
		return salleprog;
	}
	public void setsalleprog(SalleProg sp){
		this.salleprog=sp;
	}	

	public Salle() {
		super();
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	public String getAdress() {
		return this.adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}   
	public int getCapacite() {
		return this.capacite;
	}

	public void setCapacite(int capacite) {
		this.capacite = capacite;
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}
   
}
