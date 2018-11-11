/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sb_jtorres;
//import java.sql.*;
import windows.DBConnectW;
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
        //DBConnect conn = new DBConnect();//
        DBConnectW conectar = new DBConnectW();
        conectar.setVisible(true);
        //conn.Conectar();//
        //ServletRequest.getLocalName();
        //ServletRequest.getLocalAddr();// devuelve la IP.
        //ServletRequest.getLocalPort() devuelve el puerto.
        //Statement instruccion = cnx.createStatement();
        //instruccion.execute("insert into CaC values ('Pepe','Papá')");
        //instruccion.execute("delete from CaC where nombre = 'Pepe'");
    }                                                 
}
