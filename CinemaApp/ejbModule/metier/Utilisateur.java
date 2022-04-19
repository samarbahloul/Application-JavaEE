package metier;

import javax.ejb.Remote;

import metier.entities.Compte;

@Remote
public interface Utilisateur {
	public void init(String name, String passwd); 
	public String getName(); 
	public float solde();
	public void debite(float f); 
	public void addCompte(Compte c);
	public void retirer(float f);
}
