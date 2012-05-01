/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package treintayplaya;

/**
 *
 * @author administrador
 */
public class Alquiler{
    final static int RESERVAR=0;
    final static int CONFIRMAR=1;
    final static int CANCELAR=2;
    Integer id = 0;
    String nombre = "";
    String apellido = "";
    Integer tipo = 0;
    
    @Override
    public String toString(){
        return "";
    }

    boolean isReserva() {
        return tipo == RESERVAR;
    }
    boolean isConfirmacion() {
        return tipo == CONFIRMAR;
    }
    boolean isCancelacion() {
        return tipo == CANCELAR;
    }
}
