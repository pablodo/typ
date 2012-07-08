/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package treintayplaya;

import java.awt.Component;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

/**
 *
 * @author administrador
 */
public class Funciones {
    
    public static void cargarComboTabla(ComboTabla combo, String query, String campoNombre, String campoId){
        try {
            combo.removeAllItems();
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
    
    public static boolean validaCombo(Component parentComponent, JComboBox obj, String name){
        if (obj.getSelectedIndex() < 0){
            String msg = "Seleccione " + name + '.';
            String msgTitle = "Error en " + name + '.';
            JOptionPane.showMessageDialog(parentComponent, msg, msgTitle, JOptionPane.ERROR_MESSAGE);
            obj.requestFocusInWindow();
            return false;
        }
        return true;
    }
    
    public static boolean validaComboTabla(Component parentComponent, ComboTabla obj, String name){
        if (obj.getSelectedIndex() < 0 || obj.getSelectedId() <= 0){
            String msg = "Seleccione " + name + '.';
            String msgTitle = "Error en " + name + '.';
            JOptionPane.showMessageDialog(parentComponent, msg, msgTitle, JOptionPane.ERROR_MESSAGE);
            obj.requestFocusInWindow();
            return false;
        }
        return true;
    }

    public static void cargarComboTablaEspecial(ComboTabla combo, String query, String campoNombre, String campoId, String campoEspecial, String[] valoresEspeciales) {
        try {
            java.sql.Connection cnx = Conexion.getInstance().getConnection();
            java.sql.Statement stm = cnx.createStatement();
            java.sql.ResultSet rst = stm.executeQuery(query);
            
            int especialAnterior = 0;
            while (rst.next()){
                int especial = rst.getInt(campoEspecial);
                if (especial != especialAnterior){
                    combo.addItem(valoresEspeciales[especial],true);
                    especialAnterior = especial;
                }
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
    
    public static String formatNumber(Double number, String format){
        NumberFormatter formatter = new NumberFormatter(new DecimalFormat(format));
        String result = "";
        try {
            result = formatter.valueToString(number);
        } catch (ParseException ex) {
            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result.trim();
    }

    public static String formatNumber(Double number) {
        return formatNumber(number, "###,###,##0.00");
    }
    
}
