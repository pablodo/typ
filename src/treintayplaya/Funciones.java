/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package treintayplaya;

import java.awt.Component;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author administrador
 */
public class Funciones {
    
    public static void cargarComboTabla(ComboTabla combo, String query, String campoNombre, String campoId){
        try {
            java.sql.Connection cnx = Conexion.getInstance().getConnection();
            java.sql.Statement stm = cnx.createStatement();
            java.sql.ResultSet rst = stm.executeQuery(query);
            
            while (rst.next()){
                String nombre = rst.getString(campoNombre);
                Integer id = rst.getInt(campoId);
                combo.addItem(nombre, id);
            }
            rst.close();
            stm.close();
        } catch (SQLException ex) {
            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static boolean validaTextField(Component parentComponent, JTextField obj, String name){
        if (obj.getText() == null || "".equals(obj.getText())){
            String msg = "Ingrese " + name + '.';
            String msgTitle = "Error en " + name + '.';
            JOptionPane.showMessageDialog(parentComponent, msg, msgTitle, JOptionPane.ERROR_MESSAGE);
            obj.requestFocusInWindow();
            return false;
        }
        return true;
    }
}
