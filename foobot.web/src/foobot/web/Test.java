package foobot.web;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import foobot.ejb.Foobot;

/**
 * Servlet implementation class Test
 */
@WebServlet("/Test")

public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB private Foobot ejb;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ejb.importDataFromServer("hi@eamv.dk", "iversens", LocalDateTime.of(2016, 5, 10, 10, 0, 0), LocalDateTime.of(2016, 5, 11, 20, 0, 0));
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
