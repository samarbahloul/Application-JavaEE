package metier;

import javax.ejb.Local;

import metier.entities.Compte;

@Local
public interface UtilisateurLocal {
	public void init(String name, String passwd); 
	public String getName(); 
	public float solde();
	public void debite(float f); 
	public void addCompte(Compte c);
	public void retirer(float f);
}

