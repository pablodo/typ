/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package treintayplaya;

import java.awt.Color;
import java.awt.Component;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JLabel;
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
                    setBackground(Color.yellow);
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
						setBackground(new Color(230,255,150));
					}
				}
            }
            
            
            for(int i = 0; i < table.getRowCount(); i++)
                if(column == 1)
                    table.setBackground(new Color(240, 240, 240));
            
            super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);         
            
            return this;
    }
    
}

//
//package jctable;
//import java.awt.Color;
//import java.awt.Component;
//import java.awt.Font;
//import javax.swing.JTable;
//import javax.swing.table.DefaultTableCellRenderer;
///**
// * @web http://jc-mouse.blogspot.com/
// * @author Mouse
// */
//public class FormatoTabla extends DefaultTableCellRenderer{    
//    Font normal = new Font( "Arial",Font.PLAIN,12 );
//    Font negrilla = new Font( "Helvetica",Font.BOLD,18 );
//    Font cursiva = new Font( "Times new roman",Font.ITALIC,12 );
//
//    @Override 
//    public Component getTableCellRendererComponent ( JTable table, Object value, boolean selected, boolean focused, int row, int column ) 
//    {
//        setEnabled(table == null || table.isEnabled()); 
//        
//        setBackground(Color.cyan);//color de fondo
//        table.setFont(normal);//tipo de fuente
//        table.setForeground(Color.black);//color de texto
//        setHorizontalAlignment(2);//derecha
//                
//        //si la celda esta vacia se reemplaza por el texto "<vacio>" y se rellena la celda de color negro y fuente color blanco
//        if(String.valueOf(table.getValueAt(row,column)).equals("")||String.valueOf(table.getValueAt(row,column)).equals("<vacio>")){            
//            table.setValueAt("<vacio>", row, column);
//            setBackground(Color.black);                         
//            table.setForeground(Color.white);
//            table.setFont(cursiva);
//        }
//        /*--------*/
//        if(String.valueOf(table.getValueAt(row,column)).equals("jc Mouse")){
//            setBackground(Color.red); 
//            table.setFont(negrilla);                
//            setHorizontalAlignment(0);//centro
//        }                        
//        /*--------*/
//        if(String.valueOf(table.getValueAt(row,column)).equals("de")){
//            setBackground(Color.yellow);         
//            table.setFont(negrilla);                
//            setHorizontalAlignment(0);//centro
//        }
//         /*--------*/   
//        if(String.valueOf(table.getValueAt(row,column)).equals("Bolivia")){
//            setBackground(Color.GREEN); 
//            table.setFont(negrilla);                
//            setHorizontalAlignment(0);//centro
//        }        
//        /*--------*/
//        //si la celda contiene números
//        if(isNumber(String.valueOf(table.getValueAt(row,column)))){
//            setBackground(Color.BLUE); 
//            setHorizontalAlignment(4);//izquierda
//        }      
//        
//        super.getTableCellRendererComponent(table, value, selected, focused, row, column);         
//        return this;
// }
//    
// //
// private boolean isNumber(String cadena){
//         try {
//             Double.parseDouble(cadena.replace(",", ""));
//         } catch (NumberFormatException nfe){
//             String newCadena = cadena.replace(".", "").replace(',', '.');
//             try{
//                 Double.parseDouble(newCadena);
//             } catch (NumberFormatException nfe2){
//                 return false;
//             }
//        }
//         return true;
//    }
//
//}
