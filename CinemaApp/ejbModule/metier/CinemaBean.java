package metier;

import java.util.List;
import java.util.Set;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import metier.entities.Compte;
import metier.entities.Film;
import metier.entities.SalleProg;
import metier.entities.Seance;
@Stateless(name="BK")
public class CinemaBean implements Cinema,CinemaLocal{
	@PersistenceContext  
	 private EntityManager em = null;   
	 private int film_id;
	 public CinemaBean() {  
	 super();  
	 }  
	 @TransactionAttribute(TransactionAttributeType.REQUIRED)  

	@Override
	public List<Film> list(){
		 Query q = em.createNamedQuery("findAllFilms");
		 //List<Film> res = (List<Film>)q.getResultList(); 
		 return  q.getResultList();
	}


	@Override
	public Set<Film> findByPattern(String pattern) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Film findFilm(int id) { 
		//Query q = em.createNamedQuery("findCompteById");  
		//q.setParameter("fid",film_id);  
		//Film film = (Film)(q.getSingleResult());  
		Film film=new Film();
		film=em.find(Film.class,id);
		 return film;  
	}

	@Override
	public void reserve(Seance seance, Utilisateur u){
		int nb=seance.getPlaces();
		if (nb>0) {
			if(u.solde()>seance.getTarif()) {
				u.debite(seance.getTarif());
				nb--;
			}
			else {
				System.out.println("Solde insuffisant");
			}
		}
		else {
			System.out.println("nombre insuffisant de places");
		}
		
	}

	@Override
	public Set<SalleProg> getAllSalleProg() {
		 Query q = em.createNamedQuery("findAllSalleProg");
		 List<SalleProg> res = (List<SalleProg>)q.getResultList(); 
		 return (Set<SalleProg>) res;
	}

	@Override
	public Film createFilm(String name) {
		Film film = null;
		film.setNom(name);
		em.persist(film);
		return film;
	}

	@Override
	public void update(Film f) {
		em.refresh(f);
		
	}

	@Override
	public float getTarif() {
		Seance s = new Seance();
		return s.getTarif();
		
	
	}
	@Override
	public void addFilm(Film f) {
		em.persist(f);
	}

}
