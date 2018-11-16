/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sb_jtorres;

/**
 *
 * @author u6064778
 */
public class Conexion {
    
    String base;
    String server;
    String user;
    String password;

    Conexion(String db, String server, String user, String pass) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    Conexion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void getDatosConexion(String base, String server, String user, String password) {
        this.base = base;
        this.server = server;
        this.user = user;
        this.password = password;
    }
/*
    public String[] setDatosConexion() {
        return String[] {base, server, user, password};
    }
*/
}
