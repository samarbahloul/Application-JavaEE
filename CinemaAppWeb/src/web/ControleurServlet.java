package web;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.CinemaLocal;
@WebServlet(name="cs",urlPatterns= {"/controleur"})
public class ControleurServlet extends HttpServlet{
	@EJB
	private CinemaLocal metier;
	@Override
	protected void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
		request.getRequestDispatcher("VueCinema.jsp").forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
		
	}
}
