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
	Double dblTotal;
	Double dblTotalImputado;
	Double dblSaldoPendiente;
	Double dblSaldoPendienteImputado;
	Double reservaCobrada;
	Double reservaMinima;
    Double diferenciaImputacion;
    Integer id = 0;
    @Tag String nombre = "";
	@Tag String apellido = "";
    @Tag Integer tipo = 0;
    @Tag String dni = "";
    @Tag String fecha_in = "";
    @Tag String fecha_out = "";
    @Tag String fecha_vencimiento = "";
    @Tag String uf = "";
    @Tag String email = "";
    @Tag String email_propietario = "";
    @Tag String cuenta= "";
    @Tag String cuenta_imputada= "";
    @Tag String tipo_cuenta= "";
    @Tag String tipo_cuenta_imputada = "";
    @Tag String cbu= "";
    @Tag String cbu_imputado= "";
    @Tag String banco= "";
    @Tag String banco_imputado= "";
    @Tag String titular_cuenta= "";
    @Tag String titular_cuenta_imputada= "";
    @Tag Integer cantidad_personas = 0;
    @Tag Integer desayunos = 0;
    @Tag Integer desayunos_imputados = 0;
    @Tag Integer adultos = 0;
    @Tag Integer menores = 0;
    @Tag Integer bebes = 0;
    @Tag String total = "0.00";
    @Tag String total_imputado = "0.00";
    @Tag String reserva_cobrada = "0.00";
    @Tag String reserva_cobrada_imputada = "0.00";
    @Tag String reserva_minima = "0.00";
    @Tag String saldo_pendiente = "0.00";
    @Tag String saldo_pendiente_imputado = "0.00";
    
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
                           "LEFT JOIN Propietarios as p1 ON p1.propID = alqCuentaOpePropID " +
                           "LEFT JOIN TCuentas as t1 ON p1.propTCuenta = t1.tcID " +
                           "LEFT JOIN Bancos as b1 ON p1.propBanco = b1.bancoID " +
                           "LEFT JOIN Propietarios as p2 ON p2.propID = alqCuentaImpPropID " +
                           "LEFT JOIN TCuentas as t2 ON p2.propTCuenta = t2.tcID " +
                           "LEFT JOIN Bancos as b2 ON p2.propBanco = b2.bancoID " +
                           "WHERE alqID = ?";
            java.sql.PreparedStatement pstm = cnx.prepareStatement(query);
            pstm.setInt(1, id);
            java.sql.ResultSet rst = pstm.executeQuery();
            
            rst.next();
            diferenciaImputacion = rst.getDouble("alqDifImputacion");
			reservaCobrada = rst.getDouble("alqImporteReserva");
			reservaMinima = rst.getDouble("alqImporteMinReserva");
            dblTotal = rst.getDouble("alqTotal");
            dblTotalImputado = dblTotal - diferenciaImputacion;
            dblSaldoPendiente = dblTotal - reservaCobrada;
            dblSaldoPendienteImputado = dblTotalImputado - reservaCobrada;

            nombre = rst.getString("cliNombre");
            apellido = rst.getString("cliApellido");
            dni = rst.getString("cliDNI");
            tipo = rst.getInt("alqEstado");
            fecha_in = FechasFormatter.getFechaFromMySQL(rst.getString("alqFIN"));
            fecha_out = FechasFormatter.getFechaFromMySQL(rst.getString("alqFOUT"));
            fecha_vencimiento = FechasFormatter.getFechaFromMySQL(rst.getString("alqVencimiento"));
            uf = rst.getString("ufNombre");
            email = rst.getString("cliEmail");
            email_propietario = rst.getString("p2.propEmail");
            reserva_cobrada = Funciones.formatNumber(reservaCobrada);
            reserva_minima = Funciones.formatNumber(reservaMinima);
            total = Funciones.formatNumber(dblTotal);
            total_imputado = Funciones.formatNumber(dblTotalImputado);
            saldo_pendiente = Funciones.formatNumber(dblSaldoPendiente);
            saldo_pendiente_imputado = Funciones.formatNumber(dblSaldoPendienteImputado);
            desayunos = rst.getInt("alqDesayunos");
            desayunos_imputados = rst.getInt("alqDesayunosImp");
            adultos = rst.getInt("alqOcupantesA");
            menores = rst.getInt("alqOcupantesM");
            bebes = rst.getInt("alqOcupantesB");
            cantidad_personas = adultos + menores + bebes;
			cuenta = rst.getString("p1.propNCuenta");
			cbu = rst.getString("p1.propCBU");
			tipo_cuenta = rst.getString("t1.tcNombre");
			banco = rst.getString("b1.bancoNombre");
			titular_cuenta = rst.getString("p1.propTitularCuenta");
			cuenta_imputada = rst.getString("p2.propNCuenta");
			cbu_imputado = rst.getString("p2.propCBU");
			tipo_cuenta_imputada = rst.getString("t2.tcNombre");
			banco_imputado = rst.getString("b2.bancoNombre");
			titular_cuenta_imputada = rst.getString("p2.propTitularCuenta");
            
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

	public boolean borrar() {
		if (id < 1) return false;
        try{
            java.sql.Connection cnx = Conexion.getInstance().getConnection();
            String query = "DELETE Alquileres, DetAlquileres, Movimientos "+
					       "FROM Alquileres "+
						   "INNER JOIN DetAlquileres ON alqID = dalqAlq "+
						   "INNER JOIN Movimientos ON alqID = movAlqID "+
					       "WHERE alqID = ?";
            java.sql.PreparedStatement pstm = cnx.prepareStatement(query);
            pstm.setInt(1, id);
            
            int result = pstm.executeUpdate();
            pstm.close();
            return true;
        }catch(SQLException sqle){
            return false;
        }
	}
}
