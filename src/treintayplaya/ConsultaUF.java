/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package treintayplaya;

import java.util.ArrayList;

/**
 *
 * @author sergio
 */
public class ConsultaUF extends javax.swing.JInternalFrame {

    /**
     * Creates new form ConsultaUF
     */
    
    public static javax.swing.table.DefaultTableModel modelo;
    public static java.sql.Connection cnx;
    private static ArrayList<Integer> ids;
    
    public ConsultaUF() {
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
        jTable1 = new javax.swing.JTable(){     public boolean isCellEditable(int row, int col){         return false;     } };
        jbtnAgregar = new javax.swing.JButton();
        jbtnBorrar = new javax.swing.JButton();
        jbtnActualizar = new javax.swing.JButton();
        jbtnCerrar = new javax.swing.JButton();

        setClosable(true);
        setTitle("Consulta de Unidades Funcionales");

        jTable1.setModel(modelo);
        jTable1.setGridColor(new java.awt.Color(204, 204, 204));
        modelo.addColumn("Uindad Funcional");
        modelo.addColumn("Tipo de Unidad");
        modelo.addColumn("Apellido");
        modelo.addColumn("Nombre");
        modelo.addColumn("Teléfono");
        modelo.addColumn("Celular");
        modelo.addColumn("Email");

        actualizaTablaUF();
        jScrollPane1.setViewportView(jTable1);

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

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 957, Short.MAX_VALUE)
                        .addContainerGap())
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(0, 0, Short.MAX_VALUE)
                        .add(jbtnAgregar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 111, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(jbtnBorrar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 108, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jbtnActualizar)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jbtnCerrar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 106, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(11, 11, 11))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 473, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jbtnAgregar)
                    .add(jbtnBorrar)
                    .add(jbtnActualizar)
                    .add(jbtnCerrar))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCerrarActionPerformed
        dispose();
    }//GEN-LAST:event_jbtnCerrarActionPerformed

    private void jbtnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAgregarActionPerformed
        AltaUF aUF = new AltaUF();
        AppPrincipal.desktopPane.add(aUF);
        aUF.show();
    }//GEN-LAST:event_jbtnAgregarActionPerformed

    private void jbtnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnActualizarActionPerformed
        int row = jTable1.getSelectedRow();
        if (row < 0) return;
        AltaUF aUF = new AltaUF(ids.get(row));
        AppPrincipal.desktopPane.add(aUF);
        aUF.show();
        
    }//GEN-LAST:event_jbtnActualizarActionPerformed

    private void jbtnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnBorrarActionPerformed
        int row = jTable1.getSelectedRow();
        if (row < 0) return;
        try {

            java.sql.PreparedStatement pstm = cnx.prepareStatement("delete from UnidadesFuncionales where ufID = ?");

            pstm.setInt(1, ids.get(row));
            
            pstm.executeUpdate();
            
            pstm.close();
            actualizaTablaUF();
        } catch (java.sql.SQLException sqle) {
            sqle.printStackTrace();
        }
    }//GEN-LAST:event_jbtnBorrarActionPerformed

    public static void actualizaTablaUF() {
        try {

            java.sql.Statement stm = cnx.createStatement();

            java.sql.ResultSet rst = stm.executeQuery("select ufID, ufNombre, tufDetalle, propApellido, propNombre, propTelefono, propCelular, propEmail from UnidadesFuncionales LEFT JOIN Propietarios ON propUF = ufID LEFT JOIN TiposUF ON ufTipo = tufID order by ufID, ufNombre");

            ids = new ArrayList<Integer>();
            modelo = new javax.swing.table.DefaultTableModel();
            Object[] headers = {"Unidad Funcional", "Detalle", "Apellido", "Nombre", "Teléfono", "Celular", "Email"};
            modelo.setColumnIdentifiers(headers);
            jTable1.setModel(modelo);
            while(rst.next()) {
                ids.add(rst.getInt("ufID"));
                Object [] fila = {rst.getString("ufNombre"),
                                  rst.getString("tufDetalle"),
                                  rst.getString("propApellido"),
                                  rst.getString("propNombre"),
                                  rst.getString("propTelefono"),
                                  rst.getString("propCelular"),
                                  rst.getString("propEmail")};
                modelo.addRow(fila);
            }
        } catch (java.sql.SQLException sqle) {
            sqle.printStackTrace();
        }
        VistaActividadAdmin.updateTable();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JTable jTable1;
    private javax.swing.JButton jbtnActualizar;
    private javax.swing.JButton jbtnAgregar;
    private javax.swing.JButton jbtnBorrar;
    private javax.swing.JButton jbtnCerrar;
    // End of variables declaration//GEN-END:variables
}
