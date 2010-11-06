/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import controller.db_controller;
import java.util.logging.Level;
import java.util.logging.Logger;


import javax.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Tiago
 */

public class ControllerServlet extends HttpServlet {

    String loginUsuario = "mc436";
    String senhaUsuario = "mc436";

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

	String firstName = request.getParameter("user").toString();
        String surname = request.getParameter("password").toString();

        try {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControllerServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>YES Servlet ControllerServlet at " + request.getContextPath () + "</h1>");
	    out.println("<p>Welcome " + firstName + " " + surname + "</p>");
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
 
        String address;
        if (request.getParameter("user") != null)
	    {
		address = "response.jsp";
	    }
	else
	    {
		address = "index.jsp";
	    }
	RequestDispatcher dispatcher =
	    request.getRequestDispatcher(address);
	dispatcher.forward(request, response);

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

	db_controller db = new db_controller();
        String nome,senha; /*Login cadastro*/
	String tipo,email,rg,pais,dia,mes,ano; /*Cadastro*/
        String address;
        /*Login 
         * user - Nome usuario
         * password - Senha usuario
         */
        if(request.getParameter("user") != null){
           nome = request.getParameter("user").toString();
	   senha = request.getParameter("password").toString();

	try {
            db.IsUsr(nome,senha);
	    System.out.println("Usuario verificado");

        } catch (Exception ex) {

	    System.out.println("Erro verificação usuario");
            Logger.getLogger(ControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        processRequest(request, response);

    }
        /*Cadastro
         *
         */
    else if(request.getParameter("Nome") != null){
        nome = request.getParameter("Nome").toString();
	senha = request.getParameter("Senha").toString();
	tipo = request.getParameter("Tipo").toString();
	email = request.getParameter("Email").toString();
	rg = request.getParameter("RG").toString();
	pais = request.getParameter("Pais").toString();
	dia = request.getParameter("Dia").toString();
	mes = request.getParameter("Mes").toString();
	ano = request.getParameter("Ano").toString();

   	try {
            db.NewUsr(nome,senha,tipo,email,rg,pais,dia,mes,ano);
	    System.out.println("Usuario cadastrado");
    	    if(tipo.equals("Palestrante")){
            address = "AreaPalestrante.jsp";
            }
             else{
                   address = "AreaUsuario.jsp";
            }


        } catch (Exception ex) {

	    System.out.println("Erro cadastro usuario");
             address = "ErroCadastro.jsp";
            Logger.getLogger(ControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
	    
	RequestDispatcher dispatcher =
	    request.getRequestDispatcher(address);
	dispatcher.forward(request, response);


        }
    }


    public boolean confereErroLogin(String usuario, String senha){

	if((usuario.equals(loginUsuario)) && (senha.equals(senhaUsuario))){
	    return false;
	}else return true;

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
