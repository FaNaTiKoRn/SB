/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sb_jtorres;
//import java.sql.*;

import java.sql.Connection;  
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

//import javax.swing.JOptionPane;

/**
 *
 * @author FaNaTiKoRn
 */
public class SB_JTorres {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // TODO code application logic here
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String connectionURL = "jdbc:sqlserver://WOLVERINE\\SQLEXPRESS:1433;databaseName=CaC;user=sa;password=sa2017;";
        Connection cnx = DriverManager.getConnection(connectionURL);
        Statement st = cnx.createStatement();
        ResultSet rs = st.executeQuery("select * from CaC");
        /* // o bien...
        Connection cnx = null;
        public String db = "CaC";
        public String url = "WOLVERINE\\SQLEXPRESS"+db;
        public String user = "sa";
        public String pass = "sa2017";
        cnx = DriverManager.getConnection(url, user, pass);
        */
        
       
       while (rs.next())
       {
           int ID = rs.getInt(1);
           String nombre = rs.getString(2);
           String apellido = rs.getString(3);
           System.out.println("ID:" + ID + " - Nombre:" + nombre + " - Apellido:" + apellido);
       }
       
       //Statement instruccion = con.createStatement();
      // instruccion.execute("insert into CoC values ('Pepe','Papá')");
    }                                                 
}
