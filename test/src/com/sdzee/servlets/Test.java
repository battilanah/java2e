package com.sdzee.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.joda.time.DateTime;

import com.sdzee.beans.Coyote;

public class Test extends HttpServlet {

	

	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
			
		/* Cr�ation et initialisation du message. */
		String paramAuteur = request.getParameter( "auteur" );
		String message = "Transmission de variables : OK ! " + paramAuteur;
			
		/* Cr�ation du bean et initialisation de ses propri�t�s */
		Coyote premierBean = new Coyote();
		premierBean.setNom( "Coyote" );
		premierBean.setPrenom( "Wile E." );
			
		/* Cr�ation de la liste et insertion de quatre �l�ments */
		List<Integer> premiereListe = new ArrayList<Integer>();
		premiereListe.add( 27 );
		premiereListe.add( 12 );
		premiereListe.add( 138 );
		premiereListe.add( 6 );
			
		/** On utilise ici la libraire Joda pour manipuler les dates, pour deux raisons :
		 *    - c'est tellement plus simple et limpide que de travailler avec les objets Date ou Calendar !
		 *    - c'est (probablement) un futur standard de l'API Java.
		 */
		DateTime dt = new DateTime();
		Integer jourDuMois = dt.getDayOfMonth();
			
		/* Stockage du message, du bean, de la liste et du jour du mois dans l'objet request */
		request.setAttribute( "test", message );
		request.setAttribute( "coyote", premierBean );
		request.setAttribute( "liste", premiereListe );
		request.setAttribute( "jour", jourDuMois );
			
		/* Transmission de la paire d'objets request/response � notre JSP */
		this.getServletContext().getRequestDispatcher( "/WEB-INF/test.jsp" ).forward( request, response );
	}
}

