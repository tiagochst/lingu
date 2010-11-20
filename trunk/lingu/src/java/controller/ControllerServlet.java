/*
 * Controlador geral
 * Extends - Conecta ao banco de dados
 * Funções: Upload de documento
 * Método post:
 * - Cadastro de documento
 * - Cadastro de usuário
 */
package controller;

import controller.db_controller;
import entity.Autor;
import entity.Comentario;
import entity.Documento;
import entity.PgmMultilinguistico;
import entity.RedeDeTrabalho;
import entity.Usuario;
import java.io.File;

import java.util.logging.Level;
import java.util.logging.Logger;


import javax.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

import java.util.Locale;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.struts.upload.*;

/**
 *
 * @author Tiago
 */
public class ControllerServlet extends HttpServlet {

    String loginUsuario = "mc436";
    String senhaUsuario = "mc436";
    File newFile = null;

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
            out.println("<h1>YES Servlet ControllerServlet at " + request.getContextPath() + "</h1>");
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
        if (request.getParameter("user") != null) {
            address = "response.jsp";
        } else {
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
        Comentario com = new Comentario();
        RedeDeTrabalho rede2 = new RedeDeTrabalho();
        Documento doc = new Documento();
        PgmMultilinguistico prog = new PgmMultilinguistico();
        Autor autor = new Autor();
        db_controller db = new db_controller();
        String[] IDProg, IDAut;
        String address = null, ag, browser;
        Locale defaultLocale = Locale.getDefault();
        /*Login 
         * Email - E-mail do usuário
         * Senha - Senha do usuário
         */
        if (request.getParameter("Senha") != null) {
            user.setEmail(request.getParameter("Email").toString());
            user.setSenha(request.getParameter("Senha").toString());

            try {
                if (db.IsUsr(user.getEmail(), user.getSenha())) {
                    System.out.println("Usuário aceito!");
                    address = "index.jsp";
                } else {
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

        } /*
         * Função: Cadastro de Documento
         * Insere parametros do form em um objeto
         * a ser passado ao BD
         * Include:
         * - db.NewDoc
         */ else if (request.getParameter("LinguaOficial") != null) {
            doc.setAssunto(request.getParameter("Assunto").toString());
            doc.setDescricao(request.getParameter("Descricao").toString());
            doc.setLinguaOficial(request.getParameter("LinguaOficial").toString());
            doc.setLinguaUtilizador(request.getParameter("LinguaUtilizador").toString());
            doc.setPais(request.getParameter("Pais").toString());
            doc.setTipo(Integer.parseInt(request.getParameter("Tipo")));
            doc.setLinguaPalavrasChaves(request.getParameter("LinguaChave").toString());
            doc.setLinguaDescricao(request.getParameter("LinguaDescricao").toString());
            doc.setTitulo(request.getParameter("Titulo").toString());
            doc.setPalavrasChaves(request.getParameter("Chaves").toString());
            IDProg = request.getParameterValues("MultiLing");
            doc.setIp(request.getLocalAddr());
            ag = request.getHeader("User-Agent");
            ag = ag.toLowerCase();
            if (ag.contains("msie")) {
                browser = "IE";
            } else if (ag.contains("opera")) {
                browser = "Opera";
            } else if (ag.contains("chrome")) {
                browser = "Chrome";
            } else if (ag.contains("firefox")) {
                browser = "Firefox";
            } else {
                browser = "Safari";
            }
            doc.setNavegador(browser);
            doc.setSo(System.getProperty("os.name"));
            doc.setLocal(defaultLocale.getDisplayCountry());
            IDAut = request.getParameterValues("Autor");


            try {


                String contextRoot = getServletContext().getRealPath("/");
                int dotPos = newFile.getName().lastIndexOf(".");
                String extension = newFile.getName().substring(dotPos);
                doc.setExtensao(extension);
                doc.setId(db.NewDoc(doc, IDProg, IDAut));
                newFile.renameTo(new File(contextRoot + "upload/" + doc.getId() + extension));

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
	    user.setSenha(request.getParameter("SenhaUsr").toString());
	    user.setTipo(0) ;
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

        } else if (ServletFileUpload.isMultipartContent(request)) {
            fileUpload(request);
            address = "uploadinfo.jsp";
        } else if (request.getParameter("Comentario") != null) {

            com.setTexto(request.getParameter("Comentario").toString());
            if (request.getParameter("NomeComentario").toString() == null) {
                com.setAutorCom("Anônimo");
            } else {
                com.setAutorCom(request.getParameter("NomeComentario").toString());
            }

            String docId = request.getParameter("DocId");
            com.setIdDocumento(Integer.parseInt(docId));
            try {
                db.NewCom(com);
            } catch (Exception ex) {
                Logger.getLogger(ControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

            address = "detalhes.jsp?doc=" + docId;
        } else if (request.getParameter("NomeRede") != null) {

            rede2.setNome(request.getParameter("NomeRede").toString());
            rede2.setEmail(request.getParameter("EmailRede").toString());
            rede2.setUrl(request.getParameter("UrlRede").toString());

            try {
                db.NewRede(rede2);
            } catch (Exception ex) {
                Logger.getLogger(ControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

            address = "cadastro.jsp";
        }
        else if (request.getParameter("NomeProg") != null) {

            prog.setNome(request.getParameter("NomeProg").toString());
            prog.setLingua(request.getParameter("Lingua").toString());
            prog.setDescricao(request.getParameter("Descricao").toString());

            try {
                db.NewProg(prog);
            } catch (Exception ex) {
                Logger.getLogger(ControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

            address = "index.jsp";
        }



        RequestDispatcher dispatcher =
                request.getRequestDispatcher(address);
        dispatcher.forward(request, response);
    }

    public boolean confereErroLogin(String usuario, String senha) {

        if ((usuario.equals(loginUsuario)) && (senha.equals(senhaUsuario))) {
            return false;
        } else {
            return true;
        }

    }

    /*
     * Função de upload de documento
     * Descrição: Insere arquivo de upload na pasta build/upload 
     * Parametros: nenhum
     * Saida: Boolean - verdadeiro se inserido com sucesso,falso caso contrario
     */
    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private boolean fileUpload(HttpServletRequest request) {
        if (ServletFileUpload.isMultipartContent(request)) {
// Create a factory for disk-based file items
            DiskFileItemFactory factory = new DiskFileItemFactory();

// Set factory constraints
            factory.setSizeThreshold(4096);
            factory.setRepository(new File("/tmp"));

// Create a new file upload handler
            ServletFileUpload upload = new ServletFileUpload(factory);

// Set overall request size constraint
            upload.setSizeMax(1000000);

// Parse the request
            List items = null;
            try {
                items = upload.parseRequest(request);
            } catch (FileUploadException ex) {
                Logger.getLogger(ControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

            Iterator i = items.iterator();
            FileItem fi = (FileItem) i.next();
            // filename on the client
            String contextRoot = getServletContext().getRealPath("/");

            String fileName = fi.getName();
            try {
                newFile = new File(contextRoot + "upload/", fileName);
                fi.write(newFile);
            } catch (Exception ex) {
                Logger.getLogger(ControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
            }


        }
        return true;
    }
}
