/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package treintayplaya;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author administrador
 */
public class Configuracion {
    public static boolean baseLocal;
    public static String baseURL;
    public static String baseUsr;
    public static String basePass;
    public static boolean mailingActivado;
    public String email;
    public String emailPassword;
    
    public Configuracion(){
        mailingActivado = false;
        java.sql.Connection cnx = Conexion.getInstance().getConnection();
        try {
            java.sql.Statement stm = cnx.createStatement();
            java.sql.ResultSet rst = stm.executeQuery("SELECT AES_DECRYPT(emailPassword,'typ2012') as emailPassword, email, mailing FROM Configuracion");
            if (rst.next()){
                email = rst.getString("email");
                emailPassword = rst.getString("emailPassword");
                mailingActivado = rst.getInt("mailing") == 1;
            }
            rst.close();
            stm.close();
        } catch (SQLException ex) {
            Logger.getLogger(Configuracion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void cargarDatosDB(){
        baseLocal = false;
        baseURL = "dtc.hypersys-hosting2.com.ar/30yplaya_db";
        baseUsr = "db_30yplaya";
        basePass = "30ypl4y42012";
        if (baseLocal){
            baseURL = "localhost/typ";
            baseUsr = "root";
            basePass = "1234";
        }
    }
}
