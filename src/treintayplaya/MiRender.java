/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package treintayplaya;

import java.awt.Color;
import java.awt.Component;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author sergio
 */
public class MiRender extends DefaultTableCellRenderer implements TableCellRenderer {

	private static Color sabados = new Color(255, 230, 200);
	private static Color invalido = new Color(250, 200, 190);

    @Override
    public Component getTableCellRendererComponent(JTable table,
                                                   Object value, 
                                                   boolean isSelected,
                                                   boolean hasFocus,
                                                   int row, 
                                                   int column) {
        
            setEnabled(table == null || table.isEnabled());
            TableColumnModel tcm = table.getColumnModel();
            TableColumn columnaCero = tcm.getColumn(0);
            columnaCero.setPreferredWidth(600);
            
            if((row % 2) == 0)
                setBackground(Color.white);
            else
                setBackground(new Color(240,240,240));
            
            table.setForeground(Color.black);
            setHorizontalAlignment(LEFT);

            if (value instanceof Alquiler){
                setHorizontalAlignment(0);
                setText("");
                if(((Alquiler)value).isReserva()) {
                    setBackground(Color.YELLOW);
                    table.setForeground(Color.black);
                }
                if(((Alquiler)value).isConfirmacion()) {
                    setBackground(Color.green);
                    table.setForeground(Color.black);
                }
                if(((Alquiler)value).isCancelacion()) {
                    setBackground(Color.cyan);
                    table.setForeground(Color.white);
                }
                if(((Alquiler)value).isPropietario()) {
                    setBackground(Color.ORANGE);
                    table.setForeground(Color.white);
					setToolTipText(((Alquiler)value).apellido_propietario + ", " + ((Alquiler)value).nombre_propietario);
                }else{
					setToolTipText(((Alquiler)value).apellido + ", " + ((Alquiler)value).nombre);
				}
            }else{
                setText(String.valueOf(value));
                setToolTipText(null);

				if (column > 0){
					int mes = VistaActividadAdmin.month;
					int year = VistaActividadAdmin.year;
					GregorianCalendar calendar = new GregorianCalendar(year, mes, column);
					if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY){
						setBackground(sabados);
					}
				}
            }

			if (VistaActividadAdmin.ufIDs.get(row) == 0){
				setBackground(invalido);
			}	
            
            super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);         
            
            return this;
    }
    
}