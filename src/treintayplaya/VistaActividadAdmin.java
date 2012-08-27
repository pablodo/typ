/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * VistaActividadAdmin.java
 *
 * Created on 11-oct-2011, 11:56:59
 */
package treintayplaya;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sergio
 */
public class VistaActividadAdmin extends javax.swing.JInternalFrame {
    private static int year;
    private static int month;
    private static ArrayList<Integer> ufIDs = new ArrayList<Integer>();
    private static GregorianCalendar calendar = new GregorianCalendar();
    public static DefaultTableModel modelo = new DefaultTableModel();
    /** Creates new form VistaActividadAdmin */
    public VistaActividadAdmin() {
        this.year = this.calendar.get(GregorianCalendar.YEAR);
        this.month = this.calendar.get(GregorianCalendar.MONTH);
        initComponents();
        actualizarMenu();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpmEstado = new javax.swing.JPopupMenu();
        reservarMenuItem = new javax.swing.JMenuItem();
        confirmarMenuItem = new javax.swing.JMenuItem();
        cerrarMenuItem = new javax.swing.JMenuItem();
        anularMenuItem = new javax.swing.JMenuItem();
        reservaPropietarioMenuItem = new javax.swing.JMenuItem();
        modificarMenuItem = new javax.swing.JMenuItem();
        jToolBar1 = new javax.swing.JToolBar();
        jbtnAnterior = new javax.swing.JButton();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        jlblMesActual = new javax.swing.JLabel();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        jbtnSiguiente = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblVistaMensual = new javax.swing.JTable(){
            public boolean isCellEditable(int row, int col){
                return false;
            }
        };

        jpmEstado.setComponentPopupMenu(jpmEstado);

        reservarMenuItem.setText("Reserva Provisoria");
        reservarMenuItem.setEnabled(false);
        reservarMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reservarMenuItemActionPerformed(evt);
            }
        });
        jpmEstado.add(reservarMenuItem);

        confirmarMenuItem.setText("Confirmar Reserva");
        confirmarMenuItem.setEnabled(false);
        confirmarMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmarMenuItemActionPerformed(evt);
            }
        });
        jpmEstado.add(confirmarMenuItem);

        cerrarMenuItem.setText("Cancelar Contrato");
        cerrarMenuItem.setEnabled(false);
        cerrarMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrarMenuItemActionPerformed(evt);
            }
        });
        jpmEstado.add(cerrarMenuItem);

        anularMenuItem.setText("Anular");
        anularMenuItem.setEnabled(false);
        anularMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anularMenuItemActionPerformed(evt);
            }
        });
        jpmEstado.add(anularMenuItem);

        reservaPropietarioMenuItem.setText("Reserva Propietario");
        reservaPropietarioMenuItem.setEnabled(false);
        jpmEstado.add(reservaPropietarioMenuItem);

        modificarMenuItem.setMnemonic('M');
        modificarMenuItem.setText("Modificar");
        modificarMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarMenuItemActionPerformed(evt);
            }
        });
        jpmEstado.add(modificarMenuItem);

        jpmEstado.getAccessibleContext().setAccessibleParent(jtblVistaMensual);

        setClosable(true);
        setResizable(true);
        setTitle("Vista de Actividad Mensual");
        setMinimumSize(new java.awt.Dimension(1020, 640));

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        jbtnAnterior.setMnemonic('A');
        jbtnAnterior.setText("Anterior");
        jbtnAnterior.setFocusable(false);
        jbtnAnterior.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbtnAnterior.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbtnAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAnteriorActionPerformed(evt);
            }
        });
        jToolBar1.add(jbtnAnterior);
        jToolBar1.add(filler1);

        jlblMesActual.setText(this.getMesActual());
        jToolBar1.add(jlblMesActual);
        jToolBar1.add(filler2);

        jbtnSiguiente.setMnemonic('S');
        jbtnSiguiente.setText("Siguiente");
        jbtnSiguiente.setFocusable(false);
        jbtnSiguiente.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbtnSiguiente.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbtnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSiguienteActionPerformed(evt);
            }
        });
        jToolBar1.add(jbtnSiguiente);

        this.updateTable();
        jtblVistaMensual.setModel(modelo);
        jtblVistaMensual.setCellSelectionEnabled(true);
        jtblVistaMensual.setComponentPopupMenu(jpmEstado);
        jtblVistaMensual.setGridColor(new java.awt.Color(204, 204, 204));
        jtblVistaMensual.getTableHeader().setResizingAllowed(false);
        jtblVistaMensual.getTableHeader().setReorderingAllowed(false);
        jtblVistaMensual.setShowGrid(true);
        jtblVistaMensual.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtblVistaMensualMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jtblVistaMensualMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jtblVistaMensual);
        jtblVistaMensual.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jToolBar1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 996, Short.MAX_VALUE)
            .add(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(jToolBar1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 25, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 522, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void reservarMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reservarMenuItemActionPerformed
        
        if(DatosGlobales.usrNivel == 1 && DatosGlobales.usrEstado == 1 && DatosGlobales.appSesion) {
            AltaAlquiler aAlquiler = new AltaAlquiler(this);
            aAlquiler.selectUF(ufIDs.get(jtblVistaMensual.getSelectedRow()));
            aAlquiler.setFechaInicial(getFechaInicial());
            aAlquiler.setFechaFinal(getFechaFinal());
            AppPrincipal.desktopPane.add(aAlquiler);
            aAlquiler.show();
            aAlquiler.toFront();
        }
    }//GEN-LAST:event_reservarMenuItemActionPerformed

    private void confirmarMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmarMenuItemActionPerformed
        Alquiler alquiler = getSelectedAlquiler();
        if (alquiler.id > 0){
            AltaAlquiler aAlquiler = new AltaAlquiler(this, alquiler, Alquiler.CONFIRMAR);
            AppPrincipal.desktopPane.add(aAlquiler);
            aAlquiler.show();
            aAlquiler.toFront();
        }
    }//GEN-LAST:event_confirmarMenuItemActionPerformed

    private void cerrarMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarMenuItemActionPerformed
        Alquiler alquiler = getSelectedAlquiler();
        if (alquiler.id > 0){
            AltaAlquiler aAlquiler = new AltaAlquiler(this,alquiler, Alquiler.CANCELAR);
            AppPrincipal.desktopPane.add(aAlquiler);
            aAlquiler.show();
            aAlquiler.toFront();
        }
    }//GEN-LAST:event_cerrarMenuItemActionPerformed

    private void anularMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anularMenuItemActionPerformed
        if (validaAnulacion()){
			if (getSelectedAlquiler().borrar()){
                updateTable();
            }

        }
    }//GEN-LAST:event_anularMenuItemActionPerformed

    private void jbtnAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAnteriorActionPerformed
        if (this.month == 0){
            this.month = 11;
            this.year--;
        }else{
            this.month--;
        }
        this.updateDate();
        this.updateTable();
    }//GEN-LAST:event_jbtnAnteriorActionPerformed

    private void jbtnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSiguienteActionPerformed
        if (this.month == 11){
            this.month = 0;
            this.year++;
        }else{
            this.month++;
        }
        this.updateDate();
        this.updateTable();
    }//GEN-LAST:event_jbtnSiguienteActionPerformed

    private void jtblVistaMensualMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtblVistaMensualMouseClicked
        actualizarMenu();
    }//GEN-LAST:event_jtblVistaMensualMouseClicked

    private void jtblVistaMensualMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtblVistaMensualMousePressed
        actualizarMenu();
    }//GEN-LAST:event_jtblVistaMensualMousePressed

    private void modificarMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarMenuItemActionPerformed
        Alquiler alquiler = getSelectedAlquiler();
        if (alquiler.id > 0){
            AltaAlquiler aAlquiler = new AltaAlquiler(this, alquiler);
            AppPrincipal.desktopPane.add(aAlquiler);
            aAlquiler.show();
            aAlquiler.toFront();
        }
    }//GEN-LAST:event_modificarMenuItemActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem anularMenuItem;
    private javax.swing.JMenuItem cerrarMenuItem;
    private javax.swing.JMenuItem confirmarMenuItem;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JButton jbtnAnterior;
    private javax.swing.JButton jbtnSiguiente;
    private javax.swing.JLabel jlblMesActual;
    private javax.swing.JPopupMenu jpmEstado;
    private static javax.swing.JTable jtblVistaMensual;
    private javax.swing.JMenuItem modificarMenuItem;
    private javax.swing.JMenuItem reservaPropietarioMenuItem;
    private javax.swing.JMenuItem reservarMenuItem;
    // End of variables declaration//GEN-END:variables
    
    public static void updateTable() {
        Integer intMaxDay = calendar.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
        Vector columns = getNombreColumnas(intMaxDay + 1);

        Connection cnx = Conexion.getInstance().getConnection();
        String query = "SELECT ufNombre, tufDetalle, tufID, ufID FROM UnidadesFuncionales INNER JOIN TiposUF ON ufTipo = tufID ORDER BY tufAmbientes, tufMetros2, ufNombre";
        try {
            PreparedStatement pstm = cnx.prepareStatement(query);
            ResultSet rst = pstm.executeQuery();
            Vector data = new Vector();
            ufIDs = new ArrayList<Integer>();
            Integer tufID = 0;
            while (rst.next()) {
                if (rst.getInt("tufID") != tufID){
                    tufID = rst.getInt("tufID");
                    Vector row = new Vector();
                    row.add(rst.getString("tufDetalle"));
                    data.add(row);
                    ufIDs.add(0);
                }
                Vector row = new Vector();
                row.add(rst.getString("ufNombre"));
                data.add(row);
                ufIDs.add(rst.getInt("ufID"));
            }
            modelo.setDataVector(data, columns);
            rst.close();
            pstm.close();
        } catch (SQLException ex) {
            Logger.getLogger(VistaActividadAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        cargarAlquileres();
        
    }
    
    private void updateDate(){
        this.calendar.set(this.year, this.month, this.calendar.get(GregorianCalendar.DATE));
        this.jlblMesActual.setText(this.getMesActual());
    }

    private String getMesActual() {
        NumberFormat formatter = NumberFormat.getInstance();
        formatter.setMinimumIntegerDigits(2);
        String strMonth = formatter.format(this.month + 1);
        String strYear = String.valueOf(this.year);
        return strMonth + "/" + strYear;
    }

    private static Vector getNombreColumnas(int cant) {
        Vector columnas = new Vector(cant);
        columnas.add("UF");
        for (Integer x = 1; x < cant; x++){
            columnas.add(x.toString());
        }
        return columnas;
    }
    
    private GregorianCalendar getFechaInicial(){
        int [] columnas = jtblVistaMensual.getSelectedColumns();
        if (columnas.length < 1){
            return null;
        }
        GregorianCalendar c = calendar;
        int day = Integer.valueOf(modelo.getColumnName(columnas[0]));
        c.set(year, month, day);
        return c;
    }
    
    private GregorianCalendar getFechaFinal(){
        int [] columnas = jtblVistaMensual.getSelectedColumns();
        if (columnas.length < 1){
            return null;
        }
        GregorianCalendar c = calendar;
        int day = Integer.valueOf(modelo.getColumnName(columnas[columnas.length-1]));
        c.set(year, month, day);
        return c;
    }
    
    public void marcarCeldasSeleccionadas(String valor){
        for(int celda = 0; celda < jtblVistaMensual.getColumnCount(); celda++) {
            if (jtblVistaMensual.isCellSelected(jtblVistaMensual.getSelectedRow(), celda)) {
                jtblVistaMensual.setValueAt(valor, jtblVistaMensual.getSelectedRow(), celda);
            }
        }
        jtblVistaMensual.setDefaultRenderer(Object.class, new MiRender());
    }

    private static void cargarAlquileres() {
        try{
            Connection cnx = Conexion.getInstance().getConnection();
            for (int row = 0; row < modelo.getRowCount(); row++){
                int ufID = ufIDs.get(row);
                if (ufID > 0){
                    String query = "SELECT dalqFecha, alqID FROM DetAlquileres INNER JOIN Alquileres ON dalqAlq = alqID WHERE alqUF = ? ";
                    PreparedStatement pstm = cnx.prepareStatement(query);
                    pstm.setInt(1, ufID);
                    ResultSet rst = pstm.executeQuery();
                    
                    while(rst.next()){
                        String fecha = rst.getString("dalqFecha");
                        int dia = Integer.parseInt(fecha.substring(8, 10));
                        int mes = Integer.parseInt(fecha.substring(5, 7));
                        
                        if (mes == month + 1) {
                            Alquiler alquiler = new Alquiler(rst.getInt("alqID"));
                            modelo.setValueAt(alquiler, row, dia);
                        }
                    }
                    rst.close();
                    pstm.close();
                }
            }
            
        }catch (SQLException sqle){
            
        }
        jtblVistaMensual.setDefaultRenderer(Object.class, new MiRender());
    }

    private boolean validaAnulacion() {
        Alquiler alquiler = getSelectedAlquiler();
        if (alquiler.id < 1){
            javax.swing.JOptionPane.showMessageDialog(this, "Seleccione una fecha válida.", "Error Fecha", javax.swing.JOptionPane.ERROR_MESSAGE);
            return false;
        }
        int result = javax.swing.JOptionPane.showConfirmDialog(this, "¿Está seguro que desea eliminar el alquiler nro. " + alquiler.id.toString() + "?");
        if (result != javax.swing.JOptionPane.YES_OPTION){
            return false;
        }
        return true;
    }
    
    private Alquiler getSelectedAlquiler(){
        Integer row = jtblVistaMensual.getSelectedRow();
        Integer column = jtblVistaMensual.getSelectedColumn();
        Alquiler alquiler = new Alquiler();
        try{
            alquiler = (Alquiler)jtblVistaMensual.getValueAt(row, column);
        }catch (Exception e){}
        if (alquiler== null)
            alquiler = new Alquiler();
        return alquiler;
    }

    private boolean isReservaEnabled() {
        if(jtblVistaMensual.getSelectedRow() < 0 || jtblVistaMensual.getSelectedColumn() <= 1){
            return false;
        }
        Alquiler alquiler = getSelectedAlquiler();
        if (alquiler.id > 0){
            return false;
        }
        return true;
    }

    private boolean isConfirmarEnabled() {
        if(jtblVistaMensual.getSelectedRow() < 0 || jtblVistaMensual.getSelectedColumn() <= 1){
            return false;
        }
        Alquiler alquiler = getSelectedAlquiler();
        if (alquiler.id < 1){
            return false;
        }
        if (!alquiler.isReserva()){
            return false;
        }
        return true;
    }

    private boolean isCancelarEnabled() {
        if(jtblVistaMensual.getSelectedRow() < 0 || jtblVistaMensual.getSelectedColumn() < 1){
            return false;
        }
        Alquiler alquiler = getSelectedAlquiler();
        if (alquiler.id < 1){
            return false;
        }
        if(!( (alquiler.isReserva()) || alquiler.isConfirmacion()) ){
            return false;
        }
        return true;
    }

    private boolean isAnularEnabled() {
        if(jtblVistaMensual.getSelectedRow() < 0 || jtblVistaMensual.getSelectedColumn() < 1){
            return false;
        }
        Alquiler alquiler = getSelectedAlquiler();
        if (alquiler.id < 1){
            return false;
        }
        return true;
    }
    
    private void actualizarMenu() {
        reservarMenuItem.setEnabled(isReservaEnabled());
        confirmarMenuItem.setEnabled(isConfirmarEnabled());
        cerrarMenuItem.setEnabled(isCancelarEnabled());
        anularMenuItem.setEnabled(isAnularEnabled());
        reservaPropietarioMenuItem.setEnabled(isReservaEnabled());
        modificarMenuItem.setEnabled(isAnularEnabled());
    }
}
