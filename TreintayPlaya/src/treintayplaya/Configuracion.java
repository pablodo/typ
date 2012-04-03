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
    
    public Configuracion(){
        this.baseLocal = true;
        this.baseURL = "sergioioppolo.com.ar/sdioppolo_typ";
        if (this.baseLocal)
            this.baseURL = "localhost/TreintaYPlaya";
    }
}
