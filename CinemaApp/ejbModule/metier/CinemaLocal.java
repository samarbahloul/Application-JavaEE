package metier;

import java.util.List;
import java.util.Set;

import javax.ejb.Local;

import metier.entities.Film;
import metier.entities.SalleProg;
import metier.entities.Seance;
@Local
public interface CinemaLocal {
		 // Lister l'ensemble de films disponible au cinema.  
		 public List<Film> list();  
		 // Trouver les films correspondants au pattern donn� en entr�e.  
		 public Set<Film> findByPattern (String pattern);  
		 // Trouver un film � partir d'un id.  
		 public Film findFilm (int id);  
		 // R�server une s�ance pour un utilisateur.  
		 public void reserve (Seance seance, Utilisateur u);  
		 public Set<SalleProg> getAllSalleProg();  
		 public Film createFilm (String name);  
		 public void update (Film f);  
		 public float getTarif(); 

	}

