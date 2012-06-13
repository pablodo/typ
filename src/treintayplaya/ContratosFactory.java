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
        return replaceTags(contrato, alquiler, getTags(Alquiler.class));
    }
    
    public static String replaceTags(String texto, Object objeto){
        return replaceTags(texto, objeto, getTags(objeto.getClass()));
    }
    
    public static String replaceTags(String texto, Object objeto, ArrayList<String> tags){
        for (int i = 0; i < tags.size(); i++){
            String tag = tags.get(i);
            Object rawValue = getValueByTag(objeto, tag);
            if (rawValue != null){
                String value = String.valueOf(rawValue);
                texto = texto.replaceAll(tag, value);
            }
        }
        return texto;
    }
    
    public static ArrayList<String> getTags(Class clase){
        ArrayList<String> tags = new ArrayList<String>();
        Field[] fields = clase.getDeclaredFields();
        for (int i=0; i < fields.length; i++){
            if (! Modifier.isFinal(fields[i].getModifiers())){
                String field = fields[i].getName();
                String tag = "#" + field.trim().toUpperCase();
                tags.add(tag);
            }
        }
        return tags;
    }
    
    public static Object getValueByTag(Object objeto, String tag){
        Object value = new Object();
        tag = tag.toLowerCase().substring(1, tag.length());
        try {
            value = objeto.getClass().getDeclaredField(tag).get(objeto);
        } catch (Exception ex) {
            Logger.getLogger(ContratosFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
   
        return value;
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
