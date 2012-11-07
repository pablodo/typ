/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package treintayplaya;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author pablo
 */
public class Movimientos {
	private static Connection cnx = Conexion.getInstance().cnx;
    public static String[] destinos = {"", "Comercializadora", "Propietario"};
	public static String[] saldados = {"No", "Si"};

	public static boolean guardarMovimiento(Integer id, String fecha, Double importe, int destino, String detalle) throws SQLException {
        return guardarMovimiento(id, fecha, importe, destino, detalle, 0, 0, 0);
    }

	public static boolean guardarMovimiento(Integer id, String fecha, Double importe, int destino, 
                                            String detalle, int alquilerId, int operacion) throws SQLException {
        return guardarMovimiento(id, fecha, importe, destino, detalle, alquilerId, operacion, 0);
    }
	public static boolean guardarMovimiento(Integer id, String fecha, Double importe, int destino, 
                                            String detalle, int alquilerId, int operacion, int propID) throws SQLException {
        String query = "INSERT INTO Movimientos (movAlqID, movFecha, movImporte, movDestino, movDetalle, " +
                       "movLiquidacion, movPropietario, movOperacion) VALUES(?, ?, ?, ?, ?, 0, ?, ?)";	
        if (id > 0){
            query = "UPDATE Movimientos SET movFecha=?, movImporte=?, movDestino=?, movDetalle=?, movPropietario=? " +
                    "WHERE movID=?";	
        }
		java.sql.PreparedStatement pstm = cnx.prepareStatement(query);
        if (id < 1){
            pstm.setInt   (1, alquilerId);
            pstm.setString(2, fecha);
            pstm.setDouble(3, importe);
            pstm.setInt   (4, destino);
            pstm.setString(5, detalle);
            pstm.setInt   (6, propID);
            pstm.setInt   (7, operacion);
        }else{
            pstm.setString(1, fecha);
            pstm.setDouble(2, importe);
            pstm.setInt   (3, destino);
            pstm.setString(4, detalle);
            pstm.setInt   (5, propID);
            pstm.setInt   (6, id);
        }
		return pstm.execute();
	}
}
