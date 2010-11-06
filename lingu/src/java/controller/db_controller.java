/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.Properties;
import java.util.*;
;
import java.io.*;

import java.sql.BatchUpdateException;
import java.sql.DatabaseMetaData;
import java.sql.SQLWarning;

/**
 *
 * @author Tiago
 */
public class db_controller {
    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

public Boolean NewUsr(String nome,String senha,String tipo,String email,
        String rg,String pais, String dia,String mes,String  ano)
	throws Exception {
	String dbsenha;
	try {
            open();
        preparedStatement = connect
	.prepareStatement("insert into  sgct.USUARIO values (default, ?, ?, ?, ? , ?, ?,?)");
		// "myuser, webpage, datum, summery, COMMENTS from feedback.COMMENTS");
			// Parameters start with 1
			preparedStatement.setString(1,nome );
			preparedStatement.setString(2,senha);
			preparedStatement.setString(3,tipo);
			preparedStatement.setString(6, ano+"-"+mes+"-"+dia);
			preparedStatement.setString(4,email);
			preparedStatement.setString(5, rg);
			preparedStatement.setString(7, pais);

                        preparedStatement.executeUpdate();

	    // Result set get the result of the SQL query
	    resultSet = statement
		.executeQuery("insert * from sgct.USUARIO where NOME='"+nome+"'");
	} catch (Exception e) {
	    throw e;
	} finally {
	 	    close();
		    return true;
		}
    }
    public Boolean IsUsr(String nome,String senha)
	throws Exception {
	String dbsenha;
	try {
            open();
	    // Result set get the result of the SQL query
	    resultSet = statement
		.executeQuery("select * from sgct.USUARIO where NOME='"+nome+"'");
	} catch (Exception e) {
	    throw e;
	} finally {
	    while (resultSet.next()) {
                dbsenha = resultSet.getString("SENHA");
                System.out.println(dbsenha);

		if(dbsenha.equals(senha)){
		    System.out.println("User OK");
		    close();
		    return true;
		}

	    }
             System.out.println("Not User ");

	    close();
            return false;

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
		.getConnection("jdbc:mysql://sql2.ic.unicamp.br:3306/dbmc536b16?"
			       + "user=mc536user16&password=aeyeenai");

	    // Statements allow to issue SQL queries to the database
	    statement = connect.createStatement();
         }
         catch (Exception e) {

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
