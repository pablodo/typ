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
public class Alquiler{
    final static int RESERVAR=0;
    final static int CONFIRMAR=1;
    final static int CANCELAR=2;
    final static int MODIFICAR=3;
    Integer id = 0;
    String nombre = "";
    String apellido = "";
    Integer tipo = 0;
    String dni = "";
    String fecha_in = "";
    String fecha_out = "";
    String uf = "";
    
    public Alquiler(){
        
    }

    public Alquiler(int id) {
        this.id = id;
        cargarAlquiler();
    }
    
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

    private void cargarAlquiler() {
        try {
            java.sql.Connection cnx = Conexion.getInstance().getConnection();
            String query = "SELECT * FROM Alquileres INNER JOIN UnidadesFuncionales ON alqUF = ufID INNER JOIN Clientes ON alqCliente = cliID WHERE alqID = ?";
            java.sql.PreparedStatement pstm = cnx.prepareStatement(query);
            pstm.setInt(1, id);
            java.sql.ResultSet rst = pstm.executeQuery();
            
            rst.next();
            nombre = rst.getString("cliNombre");
            apellido = rst.getString("cliApellido");
            dni = rst.getString("cliDNI");
            tipo = rst.getInt("alqEstado");
            fecha_in = FechasFormatter.getFechaFromMySQL(rst.getString("alqFIN"));
            fecha_out = FechasFormatter.getFechaFromMySQL(rst.getString("alqFOUT"));
            uf = rst.getString("ufNombre");
            
            
            rst.close();
            pstm.close();
        } catch (SQLException ex) {
            Logger.getLogger(Alquiler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
