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

	public static void generarMovimiento(Integer alquilerId, Double importe, int destino) throws SQLException {
		String query = "INSERT INTO Movimientos (movAlqID, movFecha, movImporte, movDestino) " +
  					   "VALUES(?, NOW(), ?, ?)";	
		java.sql.PreparedStatement pstm = cnx.prepareStatement(query);
		pstm.setInt(1, alquilerId);
		pstm.setDouble(2, importe);
		pstm.setInt(3, destino);
		pstm.execute();
	}
}