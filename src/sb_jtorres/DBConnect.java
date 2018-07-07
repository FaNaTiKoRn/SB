/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
In general, to process any SQL statement with JDBC, you follow these steps:

    1.- Establishing a connection.
    2.- Create a statement.
    3.- Execute the query.
    4.- Process the ResultSet object.
    5.- Close the connection.
*/
package sb_jtorres;
import java.sql.*;
import java.util.*;
/*
import java.sql.Connection;  
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
*/
import javax.swing.JOptionPane;

/**
 *
 * @author FaNaTiKoRn
 */
public class DBConnect {
    /*private String db = "CaC";
    private String url = "WOLVERINE\\SQLEXPRESS:1433"+db;
    private String user = "sa";
    private String pass = "sa2017";
*/
   public Connection Conectar() throws SQLException{
        // Class.forName("org.gjt.mm.mysql.Driver"); //Para MySQL
       
        return cnx;
   }
}
