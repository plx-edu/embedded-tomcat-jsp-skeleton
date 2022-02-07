package app.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {"/about", "/about/"})
public class AboutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		long connTime =  System.nanoTime();
		System.out.println("---------------------------------------");
		System.out.println("::::: Start AboutController(doGet) :::");
		
		System.out.println(":: Backend Calculations Here...");
		
		System.out.println("::::: End AboutController(doGet) :::");
		connTime =  System.nanoTime() - connTime;
		System.out.println(":: Controller Duration: "+ ((double)connTime/1_000_000_000) +"s ::\r");
		System.out.println("---------------------------------------");
		req.getRequestDispatcher("/WEB-INF/jsp/about.jsp").forward(req, resp);
	}// doGet(About)
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("---------------------------------------");
		System.out.println("::::: Start AboutController(doPost) :::");
		
		System.out.println(":: Backend Calculations Here...");
		
		System.out.println("::::: End AboutController(doPost) :::\r");
		System.out.println("---------------------------------------");
	}// doPost(About)
}// - AboutController
