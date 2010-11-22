/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Autor;
import entity.Comentario;
import entity.Documento;
import entity.PgmMultilinguistico;
import entity.Usuario;
import entity.RedeDeTrabalho;
import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Vector;

/**
 *
 * @author Tiago
 */
public class db_controller {

    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    public Boolean NewUsr(Usuario user) throws Exception {

        String dbsenha;
        try {

            open();
            preparedStatement = connect.prepareStatement("insert into dbmc536b16.Usuario values (default, ?, ?, ?, ?, ?, ?, ?)");
            if (user.getRedeDeTrabalho().getId() != 0) {
                preparedStatement.setInt(7, user.getRedeDeTrabalho().getId());
            } else {
                preparedStatement.setNull(7, Types.INTEGER);
            }
            preparedStatement.setString(3, user.getPais());
            preparedStatement.setString(6, user.getSenha());
            preparedStatement.setString(1, user.getNome());
            preparedStatement.setString(4, user.getLingua());
            preparedStatement.setString(5, user.getEmail());
            preparedStatement.setInt(2, user.getTipo());
            preparedStatement.executeUpdate();

        } catch (Exception e) {
            throw e;
        } finally {
            close();
            return true;
        }
    }

    public Boolean NewCom(Comentario com) throws Exception {

        java.util.Date today = new java.util.Date();
        java.sql.Date sqlToday = new java.sql.Date(today.getTime());

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        String currentDate = dateFormat.format(date);

        try {

            open();
            preparedStatement = connect.prepareStatement("insert into dbmc536b16.Comentario values (default, ?, ?, ?, ?)");

            preparedStatement.setString(1, com.getTexto());
            preparedStatement.setString(2, currentDate);
            preparedStatement.setString(3, com.getAutorCom());
            preparedStatement.setInt(4, com.getIdDocumento());

            preparedStatement.executeUpdate();

        } catch (Exception e) {
            throw e;
        } finally {
            close();
            return true;
        }
    }

    public Boolean NewRede(RedeDeTrabalho rede) throws Exception {

        java.util.Date today = new java.util.Date();
        java.sql.Date sqlToday = new java.sql.Date(today.getTime());

        try {

            open();
            preparedStatement = connect.prepareStatement("insert into dbmc536b16.RedeDeTrabalho values (default, ?, ?, ?)");

            preparedStatement.setString(1, rede.getNome());
            preparedStatement.setString(2, rede.getEmail());
            preparedStatement.setString(3, rede.getUrl());

            preparedStatement.executeUpdate();

        } catch (Exception e) {
            throw e;
        } finally {
            close();
            return true;
        }
    }
        public Boolean NewAutor(Autor autor) throws Exception {

        try {

            open();
            preparedStatement = connect.prepareStatement("insert into dbmc536b16.Autor values (default, ?, ?)");

            preparedStatement.setString(1, autor.getNome());
            preparedStatement.setString(2, autor.getPais());

            preparedStatement.executeUpdate();

        } catch (Exception e) {
            throw e;
        } finally {
            close();
            return true;
        }
    }

    public Boolean NewProg(PgmMultilinguistico prog) throws Exception {


        try {

            open();
            preparedStatement = connect.prepareStatement("insert into dbmc536b16.PgmMultilinguistico values (default, ?, ?, ?)");

            preparedStatement.setString(1, prog.getNome());
            preparedStatement.setString(2, prog.getDescricao());
            preparedStatement.setString(3, prog.getLingua());

            preparedStatement.executeUpdate();

        } catch (Exception e) {
            throw e;
        } finally {
            close();
            return true;
        }
    }

    public int IsUsr(String email, String senha) throws Exception {

        String dbsenha;
        int idUser;

        try {
            open();
            resultSet = statement.executeQuery("select * from dbmc536b16.Usuario where Email='" + email + "'");
        } catch (Exception e) {
            throw e;
        } finally {
            while (resultSet.next()) {
                dbsenha = resultSet.getString("Senha");
                System.out.println("Senha do usuário: " + dbsenha);

                if (dbsenha.equals(senha)) {
                    System.out.println("User OK.");
                    idUser = resultSet.getInt("ID");
                    close();
                    return idUser;
                }

            }
            System.out.println("Not User!");

            close();
            return -1;

        }

    }

    /* Busca documento pelo título, palavra-chave, descrição e autor. */
    Vector SearchAll(String str) throws SQLException, Exception {

        String dbTitulo, dbAssunto, dbDescricao, dbChaves, dbAutor;
        String test = str.toLowerCase();
        Vector resultDoc = new Vector();
        Vector auxResult = new Vector();

        try {
            open();
            resultSet = statement.executeQuery("SELECT * FROM dbmc536b16.Documento LEFT JOIN (dbmc536b16.AutorDoc,dbmc536b16.Autor) ON (dbmc536b16.Documento.id=dbmc536b16.AutorDoc.IDDoc and dbmc536b16.Autor.ID=dbmc536b16.AutorDoc.IDAutor) WHERE dbmc536b16.AutorDoc.IDDoc;");
        } catch (Exception e) {
            throw e;
        } finally {
            while (resultSet.next()) {
                dbTitulo = resultSet.getString("Titulo");
                System.out.println(dbTitulo);
                dbAssunto = resultSet.getString("Assunto");
                System.out.println(dbAssunto);
                dbDescricao = resultSet.getString("Descricao");
                System.out.println(dbDescricao);
                dbChaves = resultSet.getString("PalavrasChaves");
                System.out.println(dbChaves);
                dbAutor = resultSet.getString("Nome");

                Documento docFound = new Documento(resultSet.getInt("ID"), null, resultSet.getInt("Tipo"),
                        resultSet.getInt("NumAcessos"), null, null, null, resultSet.getDate("DataInsercao"),
                        null);

                if (dbTitulo.toLowerCase().contains(test)) {
                    docFound.incNota();
                }

                if (dbAssunto.toLowerCase().contains(test)) {
                    docFound.incNota();
                }

                if (dbDescricao.toLowerCase().contains(test)) {
                    docFound.incNota();
                }

                if (dbChaves.toLowerCase().contains(test)) {
                    docFound.incNota();
                }

                if (dbAutor.toLowerCase().contains(test)) {
                    docFound.incNota();
                }

                if (docFound.getNota() > 0) {
                    docFound.setTitulo(dbTitulo);
                    docFound.setAssunto(dbAssunto);
                    docFound.setDescricao(dbDescricao);
                    docFound.setPalavrasChaves(dbChaves);
                    resultDoc.addElement(docFound);
                }
            }

            for (int i = 0; i < resultDoc.size(); i++) {
                Documento auxDoc = (Documento) resultDoc.elementAt(i);
                if (auxResult.size() == 0) {
                    auxResult.addElement(auxDoc);
                } else {
                    int j;
                    for (j = 0; j < auxResult.size(); j++) {
                        if (auxDoc.getNota() > ((Documento) auxResult.elementAt(j)).getNota()) {
                            auxResult.add(j, auxDoc);
                            break;
                        }
                    }
                    if (j == auxResult.size()) {
                        auxResult.addElement(auxDoc);
                    }
                }
            }

            if (resultDoc == null) {
                System.out.println("Não encontrou nada!");
            }

            close();
            return auxResult;
        }
    }

    /* Busca avançada de documento . */
    Vector AdvSearch(Documento doc, Autor aut) throws SQLException, Exception {

        String dbTitulo = null, titulo = null, pais = null, oficial = null, util = null, autor = null;

        if (doc.getTitulo() != null) {
            titulo = doc.getTitulo().toLowerCase();
            System.out.println(titulo);
        }
        if (doc.getPais() != null) {
            pais = doc.getPais().toLowerCase();
            System.out.println(pais);
        }
        if (doc.getLinguaOficial() != null) {
            oficial = doc.getLinguaOficial().toLowerCase();
        }
        if (doc.getLinguaUtilizador() != null) {
            util = doc.getLinguaUtilizador().toLowerCase();
        }
        if (aut.getNome() != null) {
            autor = aut.getNome().toLowerCase();
        }
        Vector resultDoc = new Vector();

        try {
            open();
            resultSet = statement.executeQuery("SELECT * FROM dbmc536b16.Documento LEFT JOIN (dbmc536b16.AutorDoc,dbmc536b16.Autor) ON (dbmc536b16.Documento.id=dbmc536b16.AutorDoc.IDDoc and dbmc536b16.Autor.ID=dbmc536b16.AutorDoc.IDAutor) WHERE dbmc536b16.AutorDoc.IDDoc  is not Null;");
        } catch (Exception e) {
            throw e;
        } finally {
            while (resultSet.next()) {
                dbTitulo = resultSet.getString("Titulo").toLowerCase();
                System.out.println(dbTitulo);


                System.out.println("Encontrou!");
                Documento docFound = new Documento(resultSet.getInt("ID"), resultSet.getString("Titulo"),
                        resultSet.getInt("Tipo"), resultSet.getInt("NumAcessos"),
                        null, null, null, resultSet.getDate("DataInsercao"), null);
                docFound.setAssunto(resultSet.getString("Assunto"));
                docFound.setDescricao(resultSet.getString("Descricao"));
                docFound.setPalavrasChaves(resultSet.getString("PalavrasChaves").toLowerCase());
                docFound.setPais(resultSet.getString("Pais"));
                docFound.setLinguaOficial(resultSet.getString("LinguaOficial"));
                docFound.setLinguaUtilizador(resultSet.getString("LinguaUtilizador"));
                if (doc.getTitulo() == null || docFound.getTitulo().toLowerCase().contains(titulo)) {
                    if (doc.getPais() == null || docFound.getPais().toLowerCase().contains(pais)) {
                        if (doc.getLinguaOficial() == null || docFound.getLinguaOficial().toLowerCase().contains(oficial)) {
                            if (doc.getLinguaUtilizador() == null || docFound.getLinguaUtilizador().toLowerCase().contains(util)) {
                                if (aut.getNome() == null || resultSet.getString("Nome").toLowerCase().contains(autor)) {
                                    if (doc.getTipo() == 8 || resultSet.getInt("Tipo") == doc.getTipo()) {
                                        resultDoc.addElement(docFound);
                                    }
                                }
                            }
                        }
                    }
                }
            }

            if (resultDoc == null) {
                System.out.println("Não encontrou nada!");
            }

            close();
            return resultDoc;

        }
    }

    public Integer NewDoc(Documento doc, String[] IDProg, String[] IDAutor, Integer DocResp, String[] DocLig) throws Exception {

        java.util.Date today = new java.util.Date();
        java.sql.Date sqlToday = new java.sql.Date(today.getTime());
        String dbsenha;
        Integer ID = null;
        try {

            open();
            preparedStatement = connect.prepareStatement("insert into dbmc536b16.Documento values (default, ?, ?, ?, ?, ?, ?, ?,?,?,?,?,?,?,?,?,?,?)");

            preparedStatement.setString(1, doc.getTitulo());
            preparedStatement.setInt(2, doc.getTipo());
            preparedStatement.setString(3, doc.getAssunto());
            preparedStatement.setString(4, doc.getDescricao());
            preparedStatement.setString(5, doc.getLinguaDescricao());
            preparedStatement.setString(6, doc.getPais());
            preparedStatement.setInt(7, 0);
            preparedStatement.setString(8, doc.getLinguaOficial());
            preparedStatement.setString(9, doc.getLinguaUtilizador());
            preparedStatement.setString(10, doc.getPalavrasChaves());
            preparedStatement.setString(11, doc.getLinguaPalavrasChaves());
            preparedStatement.setString(12, doc.getSo());
            preparedStatement.setString(13, doc.getIp());
            preparedStatement.setString(14, doc.getNavegador());
            preparedStatement.setDate(15, sqlToday);
            preparedStatement.setString(16, doc.getLocal());
            preparedStatement.setString(17, doc.getExtensao());
            preparedStatement.executeUpdate();


            resultSet = statement.executeQuery("select * from dbmc536b16.Documento order by ID DESC limit 1");
            resultSet.next();
            ID = Integer.parseInt(resultSet.getString("ID"));


            if (IDAutor != null) {
                for (int i = 0; i < IDAutor.length; i++) {
                    preparedStatement = connect.prepareStatement("insert into dbmc536b16.AutorDoc values (" + Integer.parseInt(IDAutor[i]) + "," + ID + ")");
                    preparedStatement.executeUpdate();
                }
            }


            if (IDProg != null) {
                for (int i = 0; i < IDProg.length; i++) {
                    preparedStatement = connect.prepareStatement("insert into dbmc536b16.DocPgmMult values (" + ID + "," + Integer.parseInt(IDProg[i]) + ")");
                    preparedStatement.executeUpdate();
                }
            }

            /*Documento ligado a documento*/
            if (DocLig != null) {
                for (int i = 0; i < DocLig.length; i++) {
                    preparedStatement = connect.prepareStatement("insert into dbmc536b16.DocLigado values (" + ID + "," + Integer.parseInt(DocLig[i]) + ",?)");
                    preparedStatement.setNull(1, Types.INTEGER);
                    preparedStatement.executeUpdate();
                }
            }
            /*Documento resposta*/
            preparedStatement = connect.prepareStatement("insert into dbmc536b16.DocResposta values (" + ID + "," + DocResp + ")");
            preparedStatement.executeUpdate();


        } catch (Exception e) {
            System.out.println("ERRO!" + e);
            throw e;
        } finally {
            close();
            return ID;

        }
    }

    public void SetupDocUsuario(int docId, int userId) {

        try {

            open();
            preparedStatement = connect.prepareStatement("insert into dbmc536b16.DocUsuario values (?, ?)");

            preparedStatement.setInt(1, userId);
            preparedStatement.setInt(2, docId);

            preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.println("ERRO!" + e);
        }

    }

    private void writeMetaData(ResultSet resultSet) throws SQLException {
        // 	Now get some metadata from the database
        // Result set get the result of the SQL query

        System.out.println("The columns in the table are: ");

        System.out.println("Table: " + resultSet.getMetaData().getTableName(1));
        for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
            System.out.println("Column " + i + " " + resultSet.getMetaData().getColumnName(i));
        }
    }

    private void writeResultSet(ResultSet resultSet) throws SQLException {
        // ResultSet is initially before the first data set
        while (resultSet.next()) {
            // It is possible to get the columns via name
            // also possible to get the columns via the column number
            // which starts at 1
            // e.g. resultSet.getSTring(2);
            String user = resultSet.getString("EMAIL");
            String website = resultSet.getString("SENHA");
            String summery = resultSet.getString("ID");
            System.out.println("User: " + user);
            System.out.println("Website: " + website);
            System.out.println("Summery: " + summery);
        }
    }

    public Boolean AvaliaArtigo(String comentario, Integer nota, Integer denovo,
            Boolean pos1, Boolean pos2, Boolean pos3, Boolean pos4)
            throws Exception {
        try {
            open();
            preparedStatement = connect.prepareStatement("insert into  sgct.AvaliaArtigo values (default, ?, ?, ?, ? , ?, ?,?)");
            // "myuser, webpage, datum, summery, COMMENTS from feedback.COMMENTS");
            // Parameters start with 1
            preparedStatement.setString(1, comentario);
            preparedStatement.setInt(2, nota);
            preparedStatement.setInt(3, denovo);
            preparedStatement.setBoolean(4, pos1);
            preparedStatement.setBoolean(5, pos2);
            preparedStatement.setBoolean(6, pos3);
            preparedStatement.setBoolean(7, pos4);

            preparedStatement.executeUpdate();

        } catch (Exception e) {
            throw e;
        } finally {
            close();
            return true;
        }
    }

    private void open() {
        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            connect = DriverManager.getConnection("jdbc:mysql://sql2.lab.ic.unicamp.br:3306/dbmc536b16",
                    "mc536user16", "aeyeenai");

            // Statements allow to issue SQL queries to the database
            statement = connect.createStatement();
        } catch (Exception e) {
            System.out.println("Não abriu conexão.");
            System.out.println(e);
        }
    }
    // You need to close the resultSet

    private void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (connect != null) {
                connect.close();
            }
        } catch (Exception e) {
        }
    }
}
