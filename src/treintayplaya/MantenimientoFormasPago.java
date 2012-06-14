/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package treintayplaya;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sergio
 */
public class MantenimientoFormasPago extends javax.swing.JInternalFrame {

    /**
     * Creates new form mantenimientoBancos
     */
    public static javax.swing.table.DefaultTableModel modelo;
    public static java.sql.Connection cnx;
    private ArrayList<Integer> ids;
    private boolean actualizar;
    private String[] destinos = {"Comercializadora", "Propietario"};
    
    public MantenimientoFormasPago() {
        modelo = new javax.swing.table.DefaultTableModel();
        cnx = Conexion.getInstance().getConnection();
        initComponents();
        altaFormaPago(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")  
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtblFormasPago = new javax.swing.JTable(){     public boolean isCellEditable(int row, int col){         return false;     } };
        jbtnAgregar = new javax.swing.JButton();
        jbtnBorrar = new javax.swing.JButton();
        jbtnActualizar = new javax.swing.JButton();
        jbtnCerrar = new javax.swing.JButton();
        jpnlAltaFormaPago = new javax.swing.JPanel();
        jlblNombre = new javax.swing.JLabel();
        jtxfNombre = new javax.swing.JTextField();
        jlblDestino = new javax.swing.JLabel();
        jcbxDestino = new javax.swing.JComboBox();
        jbtnOK = new javax.swing.JButton();

        setClosable(true);
        setTitle("Listado de Formas de Pago");

        jtblFormasPago.setModel(modelo);
        jtblFormasPago.setGridColor(new java.awt.Color(204, 204, 204));
        modelo.addColumn("Tipo de Unidad Funcional");
        modelo.addColumn("M2.");
        modelo.addColumn("Ambientes");
        modelo.addColumn("Ubicación");

        cargaTabla();
        jScrollPane1.setViewportView(jtblFormasPago);

        jbtnAgregar.setMnemonic('A');
        jbtnAgregar.setText("Agregar");
        jbtnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAgregarActionPerformed(evt);
            }
        });

        jbtnBorrar.setMnemonic('B');
        jbtnBorrar.setText("Borrar");
        jbtnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnBorrarActionPerformed(evt);
            }
        });

        jbtnActualizar.setMnemonic('T');
        jbtnActualizar.setText("Actualizar");
        jbtnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnActualizarActionPerformed(evt);
            }
        });

        jbtnCerrar.setMnemonic('C');
        jbtnCerrar.setText("Cerrar");
        jbtnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCerrarActionPerformed(evt);
            }
        });

        jpnlAltaFormaPago.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jpnlAltaFormaPago.setEnabled(false);

        jlblNombre.setText("Nombre:");

        jlblDestino.setText("A favor de:");

        jcbxDestino.setMaximumRowCount(2);
        jcbxDestino.setModel(new javax.swing.DefaultComboBoxModel(destinos));

        jbtnOK.setMnemonic('e');
        jbtnOK.setText("Aceptar");
        jbtnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnOKActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jpnlAltaFormaPagoLayout = new org.jdesktop.layout.GroupLayout(jpnlAltaFormaPago);
        jpnlAltaFormaPago.setLayout(jpnlAltaFormaPagoLayout);
        jpnlAltaFormaPagoLayout.setHorizontalGroup(
            jpnlAltaFormaPagoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jpnlAltaFormaPagoLayout.createSequentialGroup()
                .addContainerGap()
                .add(jpnlAltaFormaPagoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jlblNombre, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 117, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jlblDestino))
                .add(37, 37, 37)
                .add(jpnlAltaFormaPagoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(jtxfNombre)
                    .add(jcbxDestino, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 344, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(jbtnOK, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 117, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jpnlAltaFormaPagoLayout.setVerticalGroup(
            jpnlAltaFormaPagoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jpnlAltaFormaPagoLayout.createSequentialGroup()
                .add(0, 14, Short.MAX_VALUE)
                .add(jpnlAltaFormaPagoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jpnlAltaFormaPagoLayout.createSequentialGroup()
                        .add(jpnlAltaFormaPagoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jlblNombre)
                            .add(jtxfNombre, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(jpnlAltaFormaPagoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jlblDestino)
                            .add(jcbxDestino, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                    .add(jbtnOK))
                .addContainerGap())
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jScrollPane1)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(0, 332, Short.MAX_VALUE)
                        .add(jbtnAgregar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 117, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jbtnBorrar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 114, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jbtnActualizar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 115, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jbtnCerrar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 117, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(jpnlAltaFormaPago, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 246, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jpnlAltaFormaPago, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 14, Short.MAX_VALUE)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jbtnAgregar)
                    .add(jbtnBorrar)
                    .add(jbtnActualizar)
                    .add(jbtnCerrar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCerrarActionPerformed
        dispose();
    }//GEN-LAST:event_jbtnCerrarActionPerformed

    private void jbtnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAgregarActionPerformed
        actualizar = false;
        altaFormaPago(true);
        jtxfNombre.requestFocus();
    }//GEN-LAST:event_jbtnAgregarActionPerformed

    private void jbtnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnOKActionPerformed
        if (! valida()) return;
        try {
            String query = "insert into FormasPago (fpNombre, fpDestino) values (?, ?)";
            if (actualizar)
                query = "UPDATE FormasPago SET fpNombre=?, fpDestino=? WHERE fpID=?";
            
            java.sql.PreparedStatement pstm = cnx.prepareStatement(query);
            
            pstm.setString(1, jtxfNombre.getText());
            pstm.setInt   (2, jcbxDestino.getSelectedIndex() + 1);

            if (actualizar)
                pstm.setInt(3, ids.get(jtblFormasPago.getSelectedRow()));
            
            int result = pstm.executeUpdate();
            
            if (result == 1) {
                cargaTabla();
            }
            pstm.close();
            altaFormaPago(false);
            
        } catch (java.sql.SQLException sqle) {
            sqle.printStackTrace();
        }
    }//GEN-LAST:event_jbtnOKActionPerformed

    private void jbtnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnBorrarActionPerformed
        try {
            String query = "DELETE FROM FormasPago WHERE fpID = ?";
            java.sql.PreparedStatement pstm = cnx.prepareCall(query);
            pstm.setInt(1, ids.get(jtblFormasPago.getSelectedRow()));
            pstm.execute();
            cargaTabla();
            pstm.close();
        } catch (SQLException ex) {
            Logger.getLogger(MantenimientoFormasPago.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbtnBorrarActionPerformed

    private void jbtnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnActualizarActionPerformed
        Integer row = jtblFormasPago.getSelectedRow();
        if (row < 0){
            return;
        }
        actualizar = true;
        altaFormaPago(true);
        jtxfNombre.setText(jtblFormasPago.getValueAt(row, 0).toString());
        jcbxDestino.setSelectedItem(jtblFormasPago.getValueAt(row, 1).toString());
    }//GEN-LAST:event_jbtnActualizarActionPerformed

    public void cargaTabla() {
        try {
            java.sql.Statement stm = cnx.createStatement();

            java.sql.ResultSet rst = stm.executeQuery("SELECT fpID, fpNombre, fpDestino FROM FormasPago ORDER BY fpDestino, fpNombre");
            
            ids = new ArrayList<Integer>();
            modelo = new javax.swing.table.DefaultTableModel();
            jtblFormasPago.setModel(modelo);
            Object[] headers = {"Forma de pago", 
                                "A favor de"};
            modelo.setColumnIdentifiers(headers);
            while(rst.next()) {
                ids.add(rst.getInt("fpID"));
                Object [] fila = {rst.getString("fpNombre"),
                                  destinos[rst.getInt("fpDestino")-1]
                                 };

                modelo.addRow(fila);
            }
            
            rst.close();
            stm.close();
        } catch (java.sql.SQLException sqle) {
            sqle.printStackTrace();
        }
    }
    
    private void altaFormaPago(boolean option){
        jtxfNombre.setEnabled(option);
        jcbxDestino.setEnabled(option);
        jbtnOK.setEnabled(option);
        jtblFormasPago.setEnabled(! option);
        jtxfNombre.setText("");
        jcbxDestino.setSelectedIndex(-1);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnActualizar;
    private javax.swing.JButton jbtnAgregar;
    private javax.swing.JButton jbtnBorrar;
    private javax.swing.JButton jbtnCerrar;
    private javax.swing.JButton jbtnOK;
    private javax.swing.JComboBox jcbxDestino;
    private javax.swing.JLabel jlblDestino;
    private javax.swing.JLabel jlblNombre;
    private javax.swing.JPanel jpnlAltaFormaPago;
    private javax.swing.JTable jtblFormasPago;
    private javax.swing.JTextField jtxfNombre;
    // End of variables declaration//GEN-END:variables

    private boolean valida() {
        if (! Funciones.validaTextField(this, jtxfNombre, "Nombre")) return false;
        if (! Funciones.validaCombo(this, jcbxDestino, "Destino")) return false;
        return true;
    }
}
