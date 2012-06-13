/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package treintayplaya;

import java.util.Vector;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author administrador
 */
public class ModeloAlquiler extends AbstractTableModel{

    Vector data;
    Vector headers;
    
    public ModeloAlquiler(){
        data = new Vector();
        headers = new Vector();
    }
    
    public ModeloAlquiler(Vector data, Vector headers){
        setDataVector(data, headers);
    }
        
    @Override
    public Object getValueAt(int row, int column) {
        Vector rowVector = (Vector)data.elementAt(row);
        return rowVector.elementAt(column);
    }
    
    @Override
    public void setValueAt(Object value, int row, int column) {
        Vector rowVector = (Vector)data.elementAt(row);
        rowVector.setElementAt((Alquiler)value, column);
        fireTableCellUpdated(row, column);
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return headers.size();
    }
    
    private void setDataVector(Vector data, Vector headers) {
        this.data = nonNullVector(data);
        this.headers = nonNullVector(headers);
        justifyRows(0, getRowCount());
        fireTableStructureChanged();
    }
    
    private void justifyRows(int from, int to) {
        // Sometimes the DefaultTableModel is subclassed
        // instead of the AbstractTableModel by mistake.
        // Set the number of rows for the case when getRowCount
        // is overridden.
        data.setSize(getRowCount());

        for (int i = from; i < to; i++) {
            if (data.elementAt(i) == null) {
                data.setElementAt(new Vector(), i);
            }
            ((Vector)data.elementAt(i)).setSize(getColumnCount());
        }
    }
    
    private static Vector nonNullVector(Vector v) {
        return (v != null) ? v : new Vector();
    }
   
    
}
