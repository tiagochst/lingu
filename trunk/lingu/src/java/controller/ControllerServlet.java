/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import controller.db_controller;
import entity.Autor;
import entity.Documento;
import entity.PgmMultilinguistico;
import entity.RedeDeTrabalho;
import entity.Usuario;
import java.util.logging.Level;
import java.util.logging.Logger;


import javax.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
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

	String firstName = request.getParameter("Email").toString();
        String surname = request.getParameter("Senha").toString();

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
        Usuario user = new Usuario();
        Documento doc = new Documento();
        PgmMultilinguistico prog = new PgmMultilinguistico();
        Autor autor = new Autor();
	db_controller db = new db_controller();
        String[] IDProg,IDAut;
        String address,ag,browser;
        Locale defaultLocale = Locale.getDefault();
     
        /*Login 
         * Email - E-mail do usuário
         * Senha - Senha do usuário
         */
        if(request.getParameter("Senha") != null){
           user.setEmail(request.getParameter("Email").toString());
	   user.setSenha(request.getParameter("Senha").toString());

	try {
            if (db.IsUsr(user.getEmail(), user.getSenha())) {
                System.out.println("Usuário aceito!");
                address = "index.jsp";
            }
            else {
                System.out.println("Erro verificação usuário!");
                address = "erroLogin.jsp";
            }

        } catch (Exception ex) {
	    System.out.println("Erro verificação usuário!");
            Logger.getLogger(ControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
            address = "erroLogin.jsp";
        }
           
        RequestDispatcher dispatcher = request.getRequestDispatcher(address);
        dispatcher.forward(request, response);

    }
        /*Cadastro
         *
         */
    else if(request.getParameter("Upload") != null){
        doc.setAssunto(request.getParameter("Assunto").toString());
        doc.setDescricao(request.getParameter("Descricao").toString());
	doc.setLinguaOficial(request.getParameter("LinguaOficial").toString());
        doc.setLinguaUtilizador(request.getParameter("LinguaUtilizador").toString());
        doc.setPais(request.getParameter("Pais").toString()) ;
        doc.setTipo(Integer.parseInt(request.getParameter("Tipo"))) ;
	doc.setLinguaPalavrasChaves(request.getParameter("LinguaChave").toString());
        doc.setLinguaDescricao(request.getParameter("LinguaDescricao").toString());
        doc.setTitulo(request.getParameter("Titulo").toString());
        doc.setPalavrasChaves(request.getParameter("Chaves").toString());
        IDProg = request.getParameterValues("MultiLing");
        doc.setIp(request.getLocalAddr());
        ag = request.getHeader("User-Agent");
        ag = ag.toLowerCase();
        if (ag.contains("msie")) browser = "IE";
        else if (ag.contains("opera")) browser = "Opera";
        else if (ag.contains("chrome")) browser = "Chrome";
        else if (ag.contains("firefox")) browser = "Firefox";
        else  browser = "Safari";
        doc.setNavegador(browser);
        doc.setSo(System.getProperty("os.name"));
        doc.setLocal(defaultLocale.getDisplayCountry());
        IDAut = request.getParameterValues("Autor");


         try {
            db.NewDoc(doc,IDProg,IDAut);
	    System.out.println("Documento cadastrado");
    	    address = "index.jsp";
           

        } catch (Exception ex) {

	    System.out.println("Erro cadastro usuario");
             address = "ErroCadastro.jsp";
            Logger.getLogger(ControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    else if(request.getParameter("Nome") != null){
        RedeDeTrabalho rede = new RedeDeTrabalho(Integer.parseInt(request.getParameter("idRede")));
        user.setNome(request.getParameter("Nome").toString());
	user.setSenha(request.getParameter("Senha").toString());
	user.setTipo(Integer.parseInt(request.getParameter("Tipo"))) ;
	user.setEmail(request.getParameter("Email").toString());
	user.setPais(request.getParameter("Pais").toString()) ;
        user.setLingua(request.getParameter("Lingua").toString());
        user.setRedeDeTrabalho(rede);
   	try {
            db.NewUsr(user);
	    System.out.println("Usuario cadastrado");
    	    address = "index.jsp";


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
