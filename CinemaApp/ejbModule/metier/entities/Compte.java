package metier.entities;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Compte
 *
 */
@Entity
@Table(name="COPMTES")
@NamedQueries({  
@NamedQuery(name = "findAllComptes", query = "SELECT c FROM Compte c"),
@NamedQuery(name = "findCompteByName", query = "SELECT c FROM Compte c WHERE c.name =  :cname"),  
@NamedQuery(name = "findCompteById", query = "SELECT c FROM Compte c WHERE c.id =  :cid")  
})  

public class Compte implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String password;
	private float solde;
	private static final long serialVersionUID = 1L;

	public Compte() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}   
	public float getSolde() {
		return this.solde;
	}

	public void setSolde(float solde) {
		this.solde = solde;
	}
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Compte[id=").append(getId()).append(", name=").
		append(getName()).append(", solde=").append(getSolde()).append("]");
		return sb.toString();
	}
   
}
