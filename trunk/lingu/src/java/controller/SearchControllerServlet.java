/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import entity.Documento;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ra060210
 */
@WebServlet(name="SearchControllerServlet", urlPatterns={"/SearchControllerServlet"})
    public class SearchControllerServlet extends HttpServlet {
   
	/** 
	 * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	    response.setContentType("text/html;charset=UTF-8");
	    PrintWriter out = response.getWriter();

	    try {
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Servlet SearchControllerServlet</title>");  
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Servlet SearchControllerServlet at " + request.getContextPath () + "</h1>");
		out.println("</body>");
		out.println("</html>");
	    } finally { 
		out.close();
	    }
	} 

	// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
	/** 
	 * Handles the HTTP <code>GET</code> method.
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	@Override
	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	    processRequest(request, response);
	} 

	/** 
	 * Handles the HTTP <code>POST</code> method.
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	@Override
	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	    //processRequest(request, response);

	    db_controller db = new db_controller();
	    Documento doc = new Documento();

	    String address;

	    /* Busca por título do documento. */
	    if (request.getParameter("Titulo") != null) {
		doc.setTitulo(request.getParameter("Titulo").toString());
	    }

	    try {
		Vector resultDoc = db.SearchTitle(doc);
		request.setAttribute("Resultado", resultDoc);
		address = "resultado.jsp";

	    } catch (Exception ex) {

		System.out.println("Erro na busca!");
		address = "erroBusca.jsp";
		Logger.getLogger(ControllerServlet.class.getName()).log(Level.SEVERE, null, ex);

	    }

	    RequestDispatcher dispatcher = request.getRequestDispatcher(address);
	    dispatcher.forward(request, response);
	}

	/** 
	 * Returns a short description of the servlet.
	 * @return a String containing servlet description
	 */
	@Override
	    public String getServletInfo() {
	    return "Short description";
	}// </editor-fold>

    }
