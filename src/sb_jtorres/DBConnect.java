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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
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
   public String Conectar() throws ClassNotFoundException, SQLException{
        //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); //Para SQLServer
        Class.forName("com.mysql.jdbc.Driver"); //Para MySQL
        //String server = "WOLVERINE\\MSSQL14.SQLEXPRESS:1433";  // MsSQL SERVER
        String db = "SB_JTorres";
        String server = "127.0.0.1/" + db;  // MySQL SERVER //Servidor + DB
        String user = "root"; //'sa' para MsSQLServer //'adm' (abc123) para PHPMySQLServer // bejerman (tiMCLmu27qtQwD) para ambas plataformas
        String pass = "";
        //String connectionURL = "jdbc:sqlserver://" + server + ";databaseName=" + db + ";user=" + user + ";password=" + pass + ";"; //Conexión a MsSQLServer
        String connectionURL = "jdbc:mysql://" + server; //Conexión a PHPMySQLServer
        Connection cnx = DriverManager.getConnection(connectionURL,user,pass);//Conectado
        //cnx.setAutoCommit(false);
        //cnx.commit();
        //cnx.rollback();
        Statement st = null;
        st = cnx.createStatement();
        ResultSet rs = st.executeQuery("select * from usu");
        /* // o bien...
        Connection cnx = null;
        cnx = DriverManager.getConnection(url, user, pass);
        */
        while (rs.next())
        {
           int usu_id = rs.getInt(1);
           String usu_codigo = rs.getString(2);
           String usu_clave = rs.getString(3);
           String usu_nombre = rs.getString(4);
           int usu_status = rs.getInt(5);
           System.out.println("ID:" + usu_id + " - Nombre:" + usu_nombre + " - Código:" + usu_codigo + " - clave:" + usu_clave + " - Estado:" + usu_status);
        }
        //st = cnx.createStatement();
        rs.close();
        cnx.close();
        return db;
   }
   public void Desconectar()
   {
   /*
       
       public void cierraConexion() {
    try {
        Conector.close();
    } catch (SQLException sqle) {
        JOptionPane.showMessageDialog(null, "Error al cerrar conexion", "Error", JOptionPane.ERROR_MESSAGE);
        Logger.getLogger(ConexionDAO.class.getName()).log(Level.SEVERE, null, sqle);
    }
    }
       
       */
   
   /*
       public void cierraConsultas() {
    try {
        if (Rs != null) {
            Rs.close();
        }
        if (St != null) {
            St.close();
        }
        if (Conector != null) {
            Conector.close();
        }
    } catch (SQLException sqle) {
        JOptionPane.showMessageDialog(null, "Error cerrando la conexion!", "Error", JOptionPane.ERROR_MESSAGE);
        Logger.getLogger(LicoreriasDAO.class.getName()).log(Level.SEVERE, null, sqle);
    }
}
       */
  
   }
}
