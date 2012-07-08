/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package treintayplaya;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pablo
 */
public class ContratosFactory {
    
    public static String createContrato(Integer contratoID, Alquiler alquiler) {
        String contrato = getContrato(contratoID);
        return Tags.replaceTags(contrato, alquiler, Tags.tags_alquiler);
    }
    
    

    private static String getContrato(Integer contratoID) {
        String contrato = "";
        try {
            java.sql.Connection cnx = Conexion.getInstance().getConnection();
            java.sql.PreparedStatement pstm = cnx.prepareStatement("SELECT * FROM Contratos WHERE ID = ?");
            pstm.setInt(1, contratoID);
            java.sql.ResultSet rst = pstm.executeQuery();
            rst.next();
            contrato = rst.getString("conDetalle");
            rst.close();
            pstm.close();
        } catch (SQLException ex) {
            Logger.getLogger(ContratosFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return contrato;
    }
    
}
