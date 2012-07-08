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
public class MantenimientoBancos extends javax.swing.JInternalFrame {

    /**
     * Creates new form MantenimientoBancos
     */
    public static javax.swing.table.DefaultTableModel modelo;
    public static java.sql.Connection cnx;
    private boolean actualizar;
    private ArrayList<Integer> ids;
    
    public MantenimientoBancos() {
        modelo = new javax.swing.table.DefaultTableModel();
        cnx = Conexion.getInstance().getConnection();
        initComponents();
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
        jtblBancos = new javax.swing.JTable(){     public boolean isCellEditable(int row, int col){         return false;     } };
        jlblBanco = new javax.swing.JLabel();
        jtxfBanco = new javax.swing.JTextField();
        jbtnAgregar = new javax.swing.JButton();
        jbtnBorrar = new javax.swing.JButton();
        jbtnActualizar = new javax.swing.JButton();
        jbtnCerrar = new javax.swing.JButton();
        jbtnOK = new javax.swing.JButton();

        setTitle("Listado de Bancos");

        jtblBancos.setModel(modelo);
        jtblBancos.setGridColor(new java.awt.Color(204, 204, 204));
        cargaTabla();
        jScrollPane1.setViewportView(jtblBancos);

        jlblBanco.setText("Banco:");

        jtxfBanco.setEnabled(false);

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

        jbtnActualizar.setMnemonic('t');
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

        jbtnOK.setMnemonic('e');
        jbtnOK.setText("Aceptar");
        jbtnOK.setEnabled(false);
        jbtnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnOKActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jScrollPane1)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                                .add(jbtnAgregar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 117, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(jbtnBorrar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 114, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(jbtnActualizar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 115, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(layout.createSequentialGroup()
                                .add(jlblBanco, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 70, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(jtxfBanco, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 383, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(jbtnOK, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                            .add(jbtnCerrar, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 246, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jtxfBanco, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jbtnOK)
                    .add(jlblBanco))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 21, Short.MAX_VALUE)
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
        altaBanco(true);
        jtxfBanco.requestFocus();
    }//GEN-LAST:event_jbtnAgregarActionPerformed

    private void jbtnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnBorrarActionPerformed
        int row = jtblBancos.getSelectedRow();
        if (row < 0){
            return;
        }
        try {
            java.sql.PreparedStatement pstm = cnx.prepareStatement("DELETE FROM Bancos WHERE bancoID = ?");
            pstm.setInt(1, ids.get(row));
            pstm.executeUpdate();
            cargaTabla();
        } catch (SQLException ex) {
            Logger.getLogger(MantenimientoBancos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbtnBorrarActionPerformed

    private void jbtnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnActualizarActionPerformed
        if (jtblBancos.getSelectedRow() < 0){
            return;
        }
        actualizar = true;
        altaBanco(true);
        jtxfBanco.requestFocus();
    }//GEN-LAST:event_jbtnActualizarActionPerformed

    private void jbtnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnOKActionPerformed
        String nombre = jtxfBanco.getText().trim();
        if (nombre.equals("")){
            altaBanco(false);
            return;
        }
        try {
            String query = "INSERT INTO Bancos (bancoNombre) VALUES (?)";
            if (actualizar)
                query = "UPDATE Bancos SET bancoNombre = ? WHERE bancoID = ?";
            java.sql.PreparedStatement pstm = cnx.prepareCall(query);
            pstm.setString(1, nombre);
            if (actualizar)
                pstm.setInt(2, ids.get(jtblBancos.getSelectedRow()));
            pstm.execute();
            pstm.close();
            altaBanco(false);
            cargaTabla();
        } catch (SQLException ex) {
            Logger.getLogger(MantenimientoBancos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbtnOKActionPerformed

    public void cargaTabla() {
        try {

            java.sql.Statement stm = cnx.createStatement();

            java.sql.ResultSet rst = stm.executeQuery("SELECT bancoID, bancoNombre FROM Bancos ORDER BY bancoNombre");

            ids = new ArrayList<Integer>();
            modelo = new javax.swing.table.DefaultTableModel();
            jtblBancos.setModel(modelo);
            Object[] headers = {"Banco"};
            modelo.setColumnIdentifiers(headers);
            
            while(rst.next()) {
                ids.add(rst.getInt("bancoID"));
                Object[] fila = {rst.getString("bancoNombre")};
                modelo.addRow(fila);
            }
            rst.close();
            stm.close();
        } catch (java.sql.SQLException sqle) {
            sqle.printStackTrace();
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnActualizar;
    private javax.swing.JButton jbtnAgregar;
    private javax.swing.JButton jbtnBorrar;
    private javax.swing.JButton jbtnCerrar;
    private javax.swing.JButton jbtnOK;
    private javax.swing.JLabel jlblBanco;
    private javax.swing.JTable jtblBancos;
    private javax.swing.JTextField jtxfBanco;
    // End of variables declaration//GEN-END:variables

    private void altaBanco(boolean option) {
        jtxfBanco.setEnabled(option);
        jbtnOK.setEnabled(option);
        jtblBancos.setEnabled(! option);
        jtxfBanco.setText("");
    }
}