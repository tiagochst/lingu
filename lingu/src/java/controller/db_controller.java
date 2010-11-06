/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import entity.Documento;
import entity.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

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
            if(user.getIDRede()!=0){
                preparedStatement.setInt(7,user.getIDRede() );
            }
            else {
                preparedStatement.setNull(7, Types.INTEGER);
            }
            preparedStatement.setString(3,user.getPais());
            preparedStatement.setString(6,user.getSenha());
            preparedStatement.setString(1,user.getNome());
            preparedStatement.setString(4,user.getLingua());
            preparedStatement.setString(5,user.getEmail());
            preparedStatement.setInt(2,user.getTipo());
            preparedStatement.executeUpdate();
	 
	} catch (Exception e) {
	    throw e;
	} finally {
	 	    close();
		    return true;
		}
    }
    public Boolean IsUsr(String ID,String senha) throws Exception {

	String dbsenha;
	try {
            open();
	    resultSet = statement.executeQuery("select * from dbmc536b16.USUARIO where ID='"+ID+"'");
	} catch (Exception e) {
	    throw e;
	} finally {
	    while (resultSet.next()) {
                dbsenha = resultSet.getString("SENHA");
                System.out.println(dbsenha);

		if(dbsenha.equals(senha)){
		    System.out.println("User OK.");
		    close();
		    return true;
		}

	    }
            System.out.println("Not User!");

	    close();
            return false;

	}

    }

    void SearchTitle(Documento doc) throws SQLException, Exception {

        String dbTitulo;
        String titulo = doc.getTitulo();

	try {
            open();
	    resultSet = statement.executeQuery("select * from dbmc536b16.DOCUMENTO");
	} catch (Exception e) {
	    throw e;
	} finally {
	    while (resultSet.next()) {
                dbTitulo = resultSet.getString("TITULO");
                System.out.println(dbTitulo);

		if(dbTitulo.contains(titulo)){
		    System.out.println("Encontrou!");
                    Documento resultDoc = new Documento(Integer.parseInt(resultSet.getString("ID")), resultSet.getString("TITULO"),
                            Integer.parseInt(resultSet.getString("TIPO")), Integer.parseInt(resultSet.getString("NUMACESSOS")),
                            null, null, null, resultSet.getString("DATAINSERCAO"));
		    close();
		}

	    }

            System.out.println("Não encontrou nada!");
	    close();

	}
    }

    private void writeMetaData(ResultSet resultSet) throws SQLException {
	// 	Now get some metadata from the database
	// Result set get the result of the SQL query

	System.out.println("The columns in the table are: ");

	System.out.println("Table: " + resultSet.getMetaData().getTableName(1));
	for  (int i = 1; i<= resultSet.getMetaData().getColumnCount(); i++){
	    System.out.println("Column " +i  + " "+ resultSet.getMetaData().getColumnName(i));
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

    public Boolean AvaliaArtigo(String comentario,Integer nota,Integer denovo,
                                Boolean pos1,Boolean pos2,Boolean pos3,Boolean pos4)
    	throws Exception {
	try {
            open();
        preparedStatement = connect
	.prepareStatement("insert into  sgct.AvaliaArtigo values (default, ?, ?, ?, ? , ?, ?,?)");
		// "myuser, webpage, datum, summery, COMMENTS from feedback.COMMENTS");
			// Parameters start with 1
			preparedStatement.setString(1,comentario );
			preparedStatement.setInt(2,nota);
			preparedStatement.setInt(3,denovo);
			preparedStatement.setBoolean(4,pos1);
			preparedStatement.setBoolean(5,pos2);
			preparedStatement.setBoolean(6,pos3);
                        preparedStatement.setBoolean(7,pos4);

                        preparedStatement.executeUpdate();

	  } catch (Exception e) {
	    throw e;
	} finally {
	 	    close();
		    return true;
		}
    }



     private void open() {
         try{
	    // This will load the MySQL driver, each DB has its own driver
	    Class.forName("com.mysql.jdbc.Driver");
	    // Setup the connection with the DB
	    connect = DriverManager
		.getConnection("jdbc:mysql://sql2.lab.ic.unicamp.br:3306/dbmc536b16",
			       "mc536user16", "aeyeenai");

	    // Statements allow to issue SQL queries to the database
	    statement = connect.createStatement();
         }
         catch (Exception e) {
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
