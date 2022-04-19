package metier;

import java.util.List;

import javax.ejb.Stateful;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import metier.entities.Compte;
import metier.entities.Film;

@Stateful(name="util")
public class UtilisateurBean implements Utilisateur,UtilisateurLocal {
	@PersistenceContext  
	 private EntityManager em ;  
	 private int user_id;  
	 public UtilisateurBean() {  
	 super();  
	 }  
	 @TransactionAttribute(TransactionAttributeType.REQUIRED)  

	public void init(String name, String passwd) {
		 Query q = em.createNamedQuery("findCompteByName");  
		 q.setParameter("cname",name);  
		 List<Compte> res = (List<Compte>)q.getResultList();  
		 
		 if (res==null || res.size()==0) {  
		 System.out.println("User not found");  
		 }else{  
		 if (res.get(0).getName().equals(name) && res.get(0).getPassword().equals(passwd)){   user_id = res.get(0).getId();  
		 }else {  
			 System.out.println("User not found");  
		 }  
		 }  

		
	}

	public String getName() {
		String nom = null;  
		Query q = em.createNamedQuery("findCompteById");  
		q.setParameter("cid",user_id);  
		List<Compte> res = (List<Compte>)(q.getResultList());  
		if(res.size()==0){  
			 System.out.println("User not found");   
		 }
		else{  
			nom = res.get(0).getName();  
		}  
		  
		 return nom;  

	}

	public float solde() {
		 float sld = 0;  
		 Query q = em.createNamedQuery("findCompteById");  
		 q.setParameter("cid",user_id);  
		 List<Compte> res = (List<Compte>)(q.getResultList());  
		  
		 if(res.size()==0)  
			 System.out.println("User not found");   
		 else  
		 sld = res.get(0).getSolde();
		 return sld;  	  
	}


	public void debite(float f) {
		float solde;  
		 solde = solde();  
		 if( solde+f <= 0 ){  
			 System.out.println("Solde negative");  
		 }
		 else{  
			 Compte compte;  
			 Query q = em.createNamedQuery("findCompteById");  
			 q.setParameter("cid",user_id);  
			 List<Compte> res = (List<Compte>)(q.getResultList());  
			 if(res.size()==0){ 
				 System.out.println("User not found");    
			 }
			 else{  
			 compte = res.get(0);  
			 compte.setSolde(solde+f);  
			 em.merge(compte);  
			 }  
		 }  

		
	}
	public void retirer(float f) {
		float solde;  
		 solde = solde();  
		 if( solde+f <= 0 ){  
			 System.out.println("Solde negative");  
		 }
		 else{  
			 Compte compte;  
			 Query q = em.createNamedQuery("findCompteById");  
			 q.setParameter("cid",user_id);  
			 List<Compte> res = (List<Compte>)(q.getResultList());  
			 if(res.size()==0){ 
				 System.out.println("User not found");    
			 }
			 else{  
			 compte = res.get(0);  
			 compte.setSolde(solde-f);  
			 em.merge(compte);  
			 }  
		 }  

		
	}
	public void addCompte(Compte c) {
		em.persist(c);
	}

}
