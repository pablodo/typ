/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package treintayplaya;

import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author administrador
 */
public class Configuracion {
	public static Configuracion instance = null;
    public String baseURL;
    public String baseUsr;
    public String basePass;
    public boolean mailingActivado;
    public String email;
    public String emailCCO;
    public String emailPassword;
	public Properties properties;
	public String asunto;
    
    public Configuracion(){
		properties = new Properties();
		try {
			properties.load(Configuracion.class.getClassLoader().getResourceAsStream("treintayplaya/config.properties"));
			baseURL = properties.getProperty("baseURL", "dtc.hypersys-hosting2.com.ar/30yplaya_db");
			baseUsr = properties.getProperty("baseUsr", "db_30yplaya");
			basePass = properties.getProperty("basePass", "30ypl4y42012");
			mailingActivado = "true".equals(properties.getProperty("mailingActivado", "false")) ? true:false;
			asunto = properties.getProperty("asunto", "");
		} catch (Exception ex) {
			String msj = "Error al cargar la configuración del sistema. El sistema deberá cerrarse.\n\n";
			if (ex.getMessage() != null) msj += ex.getMessage();
			JOptionPane.showMessageDialog(null, msj.trim(), "Error", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(Configuracion.class.getName()).log(Level.SEVERE, null, ex);
			System.exit(0);
		}
		java.sql.Connection cnx = Conexion.getNewConnection(baseURL, baseUsr, basePass);
        try {
            java.sql.Statement stm = cnx.createStatement();
            java.sql.ResultSet rst = stm.executeQuery("SELECT AES_DECRYPT(emailPassword,'typ2012') as emailPassword, email, emailCCo, mailing FROM Configuracion");
            if (rst.next()){
                email = rst.getString("email");
                emailCCO = rst.getString("emailCCO");
                emailPassword = rst.getString("emailPassword");
                mailingActivado = rst.getInt("mailing") == 1;
            }
            rst.close();
            stm.close();
        } catch (SQLException ex) {
            Logger.getLogger(Configuracion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

	public static synchronized Configuracion getInstance(){
		if (instance == null){
			instance = new Configuracion();
			Logger.getLogger(Configuracion.class.getName()).log(Level.INFO, instance.toString());
		}
		return instance;
	}

	@Override
	public String toString(){
		return "\nbaseURL: " + baseURL + "\n" +
			     "baseUsr: " + baseUsr + "\n" +
			     "email:   " + email   + "\n" +
			     "mail:    " + String.valueOf(mailingActivado) + "\n";
	}
}
