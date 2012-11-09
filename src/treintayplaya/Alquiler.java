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
	final static int PROPIETARIO=4;
	Double dblTotal;
	Double dblTotalImputado;
	Double dblSaldoPendiente;
	Double dblSaldoPendienteImputado;
	Double reservaCobrada;
	Double reservaMinima;
	Double importeCancelado;
    Double diferenciaImputacion;
    Integer operador = 0;
    Integer id = 0;
	String nombre_propietario = "";
	String apellido_propietario = "";
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
    @Tag String forma_de_pago = "";
    @Tag String forma_de_pago_imputada = "";
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
    @Tag String cuit= "";
    @Tag String cuit_imputado= "";
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
    @Tag String importe_cancelado = "0.00";
    @Tag String importe_cancelado_imputado = "0.00";
    @Tag String saldo_pendiente = "0.00";
    @Tag String saldo_pendiente_imputado = "0.00";
    
    public Alquiler(){
        
    }

    public Alquiler(int id) {
        this.id = id;
        cargarAlquiler();
    }

    public Alquiler(java.sql.ResultSet rst) throws SQLException {
        this.id = rst.getInt("alqID");
		this.tipo = rst.getInt("alqEstado");
        this.operador = rst.getInt("alqOperador");
		this.nombre = rst.getString("cliNombre");
		this.apellido = rst.getString("cliApellido");
		this.nombre_propietario = rst.getString("propNombre");
		this.apellido_propietario = rst.getString("propApellido");
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
    boolean isPropietario() {
        return tipo == PROPIETARIO;
    }

    private void cargarAlquiler() {
        try {
            java.sql.Connection cnx = Conexion.getInstance().getConnection();
            String query = "SELECT * FROM Alquileres " + 
                           "INNER JOIN UnidadesFuncionales ON alqUF = ufID " + 
                           "LEFT JOIN Propietarios as p ON propUF = ufID " + 
                           "LEFT JOIN Clientes ON alqCliente = cliID " +
                           "LEFT JOIN FormasPago as fp1 ON alqFormaPagoOpe = fp1.fpID " +
                           "LEFT JOIN FormasPago as fp2 ON alqFormaPagoImp = fp2.fpID " +
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
            fecha_in = FechasFormatter.getFechaSimpleString(rst.getString("alqFIN"));
            fecha_out = FechasFormatter.getFechaSimpleString(rst.getString("alqFOUT"));
            fecha_vencimiento = FechasFormatter.getFechaSimpleString(rst.getString("alqVencimiento"));
            uf = rst.getString("ufNombre");
            email = rst.getString("cliEmail");
            email_propietario = rst.getString("p2.propEmail");
			if (email_propietario == null){
				email_propietario = rst.getString("p.propEmail");
			}
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

            forma_de_pago = rst.getString("fp1.fpNombre");
			cuenta = rst.getString("p1.propNCuenta");
			cbu = rst.getString("p1.propCBU");
			tipo_cuenta = rst.getString("t1.tcNombre");
			banco = rst.getString("b1.bancoNombre");
			cuit = rst.getString("p1.propCUIT");
			titular_cuenta = rst.getString("p1.propTitularCuenta");

            forma_de_pago_imputada = rst.getString("fp2.fpNombre");
			cuenta_imputada = rst.getString("p2.propNCuenta");
			cbu_imputado = rst.getString("p2.propCBU");
			tipo_cuenta_imputada = rst.getString("t2.tcNombre");
			banco_imputado = rst.getString("b2.bancoNombre");
			cuit_imputado = rst.getString("p2.propCUIT");
			titular_cuenta_imputada = rst.getString("p2.propTitularCuenta");

			nombre_propietario = rst.getString("p2.propNombre");
			apellido_propietario = rst.getString("p2.propApellido");
            
            rst.close();
            pstm.close();
            
            if (tipo == CANCELAR) {
                query = "SELECT movImporte FROM Movimientos WHERE movAlqID = ? ORDER BY movID DESC LIMIT 1";
                pstm = cnx.prepareStatement(query);
                pstm.setInt(1, id);
                rst = pstm.executeQuery();

                rst.next();
                importeCancelado = rst.getDouble("movImporte");
                importe_cancelado = Funciones.formatNumber(importeCancelado);
                importe_cancelado_imputado = Funciones.formatNumber(importeCancelado - diferenciaImputacion);
                rst.close();
                pstm.close();
            }
            limpiar();
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
						   "LEFT JOIN DetAlquileres ON alqID = dalqAlq "+
						   "LEFT JOIN Movimientos ON alqID = movAlqID "+
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
