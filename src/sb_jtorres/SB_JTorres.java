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
//import java.util.*;
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
        //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        //String server = "WOLVERINE\\MSSQL14.SQLEXPRESS:1433"; //HKEY_LOCAL_MACHINE\SOFTWARE\Microsoft\Microsoft SQL Server\Instance Names\SQL
        String server = "WOLVERINE\\MSSQL14.SQLEXPRESS:1433";
        String db = "CaC";
        String user = "sa";
        String pass = "sa2017";
        String connectionURL = "jdbc:sqlserver://" + server + ";databaseName=" + db + ";user=" + user + ";password=" + pass + ";";
        Connection cnx = DriverManager.getConnection(connectionURL);//Conectado
        Statement st = null;
        st = cnx.createStatement();
        ResultSet rs = st.executeQuery("select * from CaC");
        /* // o bien...
        Connection cnx = null;

        cnx = DriverManager.getConnection(url, user, pass);
        */

        while (rs.next())
        {
           int ID = rs.getInt(1);
           String nombre = rs.getString(2);
           String apellido = rs.getString(3);
           System.out.println("ID:" + ID + " - Nombre:" + nombre + " - Apellido:" + apellido);
        }
        //ServletRequest.getLocalName()
        //ServletRequest.getLocalAddr() returns IP.
        //ServletRequest.getLocalPort() returns puerto.
       
        Statement instruccion = cnx.createStatement();
        //instruccion.execute("insert into CaC values ('Pepe','Papá')");
        //instruccion.execute("delete from CaC where nombre = 'Pepe'");
    }                                                 
}
