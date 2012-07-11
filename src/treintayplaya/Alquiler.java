/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package treintayplaya;

import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import treintayplaya.Tags.Tag;

/**
 *
 * @author administrador
 */
public class Alquiler{
    final static int RESERVAR=0;
    final static int CONFIRMAR=1;
    final static int CANCELAR=2;
    final static int MODIFICAR=3;
	Double reservaCobrada;
	Double reservaMinima;
    Integer id = 0;
    @Tag String nombre = "";
	@Tag String apellido = "";
    @Tag Integer tipo = 0;
    @Tag String dni = "";
    @Tag String fecha_in = "";
    @Tag String fecha_out = "";
    @Tag String uf = "";
    @Tag String email = "";
    @Tag String email_propietario = "";
    @Tag String cuenta= "";
    @Tag String tipo_cuenta= "";
    @Tag Integer cantidad_personas = 0;
    @Tag Integer desayunos = 0;
    @Tag Integer desayunos_imputados = 0;
    @Tag Integer adultos = 0;
    @Tag Integer menores = 0;
    @Tag Integer bebes = 0;
    @Tag String total = "0.00";
    @Tag String reserva_cobrada = "0.00";
    @Tag String reserva_minima = "0.00";
    @Tag String total_imputado = "0.00";
    
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
            String query = "SELECT * FROM Alquileres " + 
                           "INNER JOIN UnidadesFuncionales ON alqUF = ufID " + 
                           "INNER JOIN Clientes ON alqCliente = cliID " +
                           "LEFT JOIN Propietarios as p1 ON p1.propUF = ufID " +
                           "LEFT JOIN Propietarios as p2 ON p2.propID = alqCuentaPropID " +
                           "WHERE alqID = ?";
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
            email = rst.getString("cliEmail");
            email_propietario = rst.getString("propEmail");
			reservaCobrada = rst.getDouble("alqImporteReserva");
            reserva_cobrada = Funciones.formatNumber(reservaCobrada);
			reservaMinima = rst.getDouble("alqImporteMinReserva");
            reserva_minima = Funciones.formatNumber(reservaMinima);
            total = Funciones.formatNumber(rst.getDouble("alqTotal"));
            total_imputado = Funciones.formatNumber(rst.getDouble("alqTotal") - rst.getDouble("alqDifImputacion"));
            desayunos = rst.getInt("alqDesayunos");
            desayunos_imputados = rst.getInt("alqDesayunosImp");
            adultos = rst.getInt("alqOcupantesA");
            menores = rst.getInt("alqOcupantesM");
            bebes = rst.getInt("alqOcupantesB");
            cantidad_personas = adultos + menores + bebes;
			cuenta = rst.getString("p2.propNCuenta");
			tipo_cuenta = rst.getString("p2.propTCuenta");
            
            limpiar();
            rst.close();
            pstm.close();
        } catch (SQLException ex) {
            Logger.getLogger(Alquiler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void limpiar() {
        for (Field field: getClass().getFields()){
            try {
                if (field.get(this) == null){
                    field.set(this, "");
                }
            } catch (IllegalArgumentException ex) {
                Logger.getLogger(Alquiler.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(Alquiler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
