/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package treintayplaya;

/**
 *
 * @author administrador
 */
public class Configuracion {
    public boolean baseLocal;
    public String baseURL;
    public String baseUsr;
    public String basePass;
    public boolean mailingActivado;
    public String email;
    public String emailPassword;
    
    public Configuracion(){
        this.baseLocal = true;
        this.baseURL = "sergioioppolo.com.ar/sdioppolo_typ";
        this.baseUsr = "sdioppolo_root";
        this.basePass = "sdi7346DB";
        if (this.baseLocal){
            this.baseURL = "localhost/typ";
            this.baseUsr = "root";
            this.basePass = "1234";
        }
        mailingActivado = false;
    }
}
