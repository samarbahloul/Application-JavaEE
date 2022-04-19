import java.lang.reflect.Proxy;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import metier.Cinema;

import metier.Utilisateur;
import metier.UtilisateurBean;
import metier.entities.Compte;
import metier.entities.Film;
import metier.entities.Seance;

public class ClientRemote {
	public static void main(String[] args){
		try {
			Properties p=new Properties();
			p.put(Context.URL_PKG_PREFIXES,"org.jboss.ejb.client.naming");
			
			

			String appName=""; 
			//Nom projet EJB
			String moduleName="CinemaApp"; 
			//Nom du Session Bean
			String distinctName="Bk"; 
			//chemin complet de l'interface java
			String viewClassName=Cinema.class.getName();
		    System.out.println(viewClassName); 
		    Context ctx= new InitialContext();
	    //String ejbRemoteJNDIName="ejb:"+appName+"/"+moduleName+"/"+distinctName+"!"+viewClassName; 
	    Cinema stub=(Cinema) ctx.lookup("ejb:/CinemaApp/BK!metier.Cinema");
	    //System.out.println(ejbRemoteJNDIName); 
	    System.out.println("stub= "+stub); 
	   
	   Film F1=new Film();
	   F1.setNom("Action");
	   stub.addFilm(F1);
	   Film F2=new Film();
	   F2.setNom("Horreur");
	   stub.addFilm(F2);
	   System.out.println("Affichage de tous les films");
	   List<Film> films=stub.list();
	   for(Film cp:films) System.out.println(cp.toString());
	   System.out.println("Film d'id 1");

	   Film f=stub.findFilm(1);
	   System.out.println(f);
		Utilisateur remote;
		
		 
		   Context context =new InitialContext();
		   remote=(Utilisateur) context.lookup("ejb:/CinemaApp/util!metier.Utilisateur");
		   System.out.println("remote:"+remote);
		   Compte c1=new Compte();
		   c1.setName("samar");
		   c1.setPassword("123");
		   c1.setSolde(170);
		   System.out.println(c1);
		   remote.addCompte(c1);
		   Compte c2=new Compte();
		   c2.setName("samar");
		   c2.setPassword("abc");
		   c2.setSolde(170);
		   remote.addCompte(c2);
		   UtilisateurBean utilisateur = new UtilisateurBean();
		   remote.init("samar", "123");
		   remote.debite(70);
			float solde=remote.solde();
			System.out.println(solde);
		   System.out.println("solde apres debit");
		   System.out.println(c1);
		   remote.retirer(100);
		   float sld=remote.solde();
		   System.out.println(sld);
		   
		   Seance seance=new Seance();
		   Date date = null;
		    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		    String date1 = "22/01/2022";
		    try {
		    	date = (Date) simpleDateFormat.parse(date1);
		      } catch (ParseException e) {
		        e.printStackTrace();
		      }
		 seance.setHoraire(date);
		 seance.setPlaces(8);
		 seance.setTarif(15);
		 System.out.println(seance);
		} catch (NamingException e) {
			e.printStackTrace();
		}

		
	}
}
