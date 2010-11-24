/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import entity.Autor;
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
            Autor aut = new Autor();
	    String address;
            Integer adv =0;
            Vector resultDoc;
	    /* Busca por título do documento. */
	    if (request.getParameter("Titulo") != null) {
                adv = 1;
		doc.setTitulo(request.getParameter("Titulo").toString());
                 adv=1;
	    }
            /* Busca por palavra-chave. */
            if (request.getParameter("Tudo") != null) {
                doc.setDescricao(request.getParameter("Tudo").toString());
            }
	    /* Busca por autor do documento. */
	    if (request.getParameter("Autor") != null && !request.getParameter("Autor").equals("")) {
                adv=1;
		aut.setNome(request.getParameter("Autor").toString());
	    }
	    /* Busca por título do documento. */
	    if (request.getParameter("Pais") != null && !request.getParameter("Pais").equals("")) {
                  adv=1;
		doc.setPais(request.getParameter("Pais").toString());
	    }
                /* Busca por título do documento. */
	    if (request.getParameter("LinguaOficial") != null && !request.getParameter("LinguaOficial").equals("")) {
                  adv=1;
		doc.setLinguaOficial(request.getParameter("LinguaOficial").toString());
	    }
                /* Busca por ligua do utilizador. */
	    if (request.getParameter("LinguaUtilizador") != null && !request.getParameter("LinguaUtilizador").equals("")) {
                  adv=1;
		doc.setLinguaUtilizador(request.getParameter("LinguaUtilizador").toString());
	    }
     if (request.getParameter("Tipo") != null && !request.getParameter("Tipo").equals("")) {
                doc.setTipo(Integer.parseInt(request.getParameter("Tipo")));

                    adv=1;
           }


	    try {
                if(adv==1){
                     System.out.println("Busca avançada iniciada");
                     resultDoc = db.AdvSearch(doc,aut);
                        
                }
                else{
                    resultDoc = db.SearchAll(doc.getDescricao());
                }
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
