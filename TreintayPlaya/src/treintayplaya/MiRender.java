/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package treintayplaya;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author sergio
 */
public class MiRender extends DefaultTableCellRenderer {
    
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
            
            for(int i = 0; i < table.getRowCount(); i++)
                if(column == 0)
                    table.setBackground(new Color(240, 240, 240));
            
            
            if((row % 2) == 0)
                setBackground(Color.white);
            else
                setBackground(new Color(240,240,240));
            
            table.setForeground(Color.black);
            setHorizontalAlignment(LEFT);
            
            if(String.valueOf(table.getValueAt(row, column)).equals(">>")) {
                setBackground(Color.yellow);
                table.setForeground(Color.black);
                setHorizontalAlignment(0);
            }
            
            if(String.valueOf(table.getValueAt(row, column)).equals("^^")) {
                setBackground(Color.green);
                table.setForeground(Color.black);
                setHorizontalAlignment(0);
            }
            
            if(String.valueOf(table.getValueAt(row, column)).equals("00")) {
                setBackground(Color.blue);
                table.setForeground(Color.white);
                setHorizontalAlignment(0);
            }

            if(String.valueOf(table.getValueAt(row, column)).equals("")) {
                if((row % 2) == 0)
                    setBackground(Color.white);
                else
                    setBackground(new Color(240,240,240));

                table.setForeground(Color.black);
                setHorizontalAlignment(0);
            }

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
