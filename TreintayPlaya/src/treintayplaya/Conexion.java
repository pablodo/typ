/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package treintayplaya;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author administrador
 */
public class Conexion {
    private static Conexion instance = null;
    public Connection cnx = null;
    
    public Conexion(){
        updateConnection();
    }
    
    private void updateConnection(){
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            
            Configuracion conf = new Configuracion();
            String baseURL = conf.baseURL;
            String baseUsr = conf.baseUsr;
            String basePass = conf.basePass;
            cnx = java.sql.DriverManager.getConnection("jdbc:mysql://" + baseURL, baseUsr, basePass);
        } catch (SQLException ex) {
            
        } catch (ClassNotFoundException ex) {
            System.out.println("Error en la conexion");
        }

    }
    
    public static synchronized Conexion getInstance() {
        if (instance == null) {
            instance = new Conexion();
        }
        return instance;
    }

    public Connection getConnection() {
        if (cnx == null) {
            this.updateConnection();
        }
        try {
            if (cnx.isClosed()) {
                this.updateConnection();
            }
        } catch (SQLException ex) {
            return null;
        }
        return cnx;
    }
    
}
