/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package treintayplaya;

import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author sergio
 */
public class ConsultaInquilinos extends javax.swing.JInternalFrame {

    /**
     * Creates new form ConsultaInquilinos
     */
    
    public static javax.swing.table.DefaultTableModel modelo;
    public static java.sql.Connection cnx;
    private static ArrayList<Integer> cliIDs;
    
    public ConsultaInquilinos() {
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
        jTable1 = new javax.swing.JTable(){
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        jbtnAgregar = new javax.swing.JButton();
        jbtnBorrar = new javax.swing.JButton();
        jbtnActualizar = new javax.swing.JButton();
        jbtnCerrar = new javax.swing.JButton();

        setClosable(true);
        setTitle("Consulta de Clientes");

        jTable1.setModel(modelo);
        jTable1.setGridColor(new java.awt.Color(204, 204, 204));
        jTable1.getTableHeader().setReorderingAllowed(false);
        actualizaTablaClientes();
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
                    .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 972, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(0, 0, Short.MAX_VALUE)
                        .add(jbtnAgregar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 115, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jbtnBorrar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 112, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jbtnActualizar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 107, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jbtnCerrar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 105, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 420, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jbtnAgregar)
                    .add(jbtnBorrar)
                    .add(jbtnActualizar)
                    .add(jbtnCerrar))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCerrarActionPerformed
        dispose();
    }//GEN-LAST:event_jbtnCerrarActionPerformed

    private void jbtnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAgregarActionPerformed
        AltaInquilinos aCliente = new AltaInquilinos();
        AppPrincipal.desktopPane.add(aCliente);
        aCliente.show();

    }//GEN-LAST:event_jbtnAgregarActionPerformed

    private void jbtnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnBorrarActionPerformed
        if (validaModificarCliente()){
            try {

                java.sql.PreparedStatement pstm = cnx.prepareStatement("DELETE FROM Clientes WHERE cliID = ?");

                pstm.setInt(1, cliIDs.get(jTable1.getSelectedRow()));

                int result = pstm.executeUpdate();

                if(result == 1) {
                    cliIDs.remove(jTable1.getSelectedRow());
                    modelo.removeRow(jTable1.getSelectedRow());
                }

            } catch (java.sql.SQLException sqle) {
                sqle.printStackTrace();
            }
        }
    }//GEN-LAST:event_jbtnBorrarActionPerformed

    private void jbtnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnActualizarActionPerformed
        if(validaModificarCliente()){
            Integer cliID = cliIDs.get(jTable1.getSelectedRow());
            AltaInquilinos aCliente = new AltaInquilinos(cliID);
            AppPrincipal.desktopPane.add(aCliente);
            aCliente.show();
        }
    }//GEN-LAST:event_jbtnActualizarActionPerformed

    public static void actualizaTablaClientes() {
        try {

            java.sql.Statement stm = cnx.createStatement();

            java.sql.ResultSet rst = stm.executeQuery("select cliID, cliApellido, cliNombre, cliTelefono, cliCelular, cliEmail from Clientes order by cliApellido");
            cliIDs = new ArrayList<Integer>();
            modelo = new javax.swing.table.DefaultTableModel();
            Object[] headers = {"Apellido",
                                "Nombre",
                                "Teléfono",
                                "Celular",
                                "Email"};
            modelo.setColumnIdentifiers(headers);
            jTable1.setModel(modelo);
            while(rst.next()) {
                Vector row = new Vector();
                row.add(rst.getString("cliApellido"));
                row.add(rst.getString("cliNombre"));
                row.add(rst.getString("cliTelefono"));
                row.add(rst.getString("cliCelular"));
                row.add(rst.getString("cliEmail"));
                cliIDs.add(rst.getInt("cliID"));
                modelo.addRow(row);
            }
        } catch (java.sql.SQLException sqle) {
            sqle.printStackTrace();
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JTable jTable1;
    private javax.swing.JButton jbtnActualizar;
    private javax.swing.JButton jbtnAgregar;
    private javax.swing.JButton jbtnBorrar;
    private javax.swing.JButton jbtnCerrar;
    // End of variables declaration//GEN-END:variables

    private boolean validaModificarCliente() {
        if(jTable1.getSelectedRow() < 0){
            JOptionPane.showMessageDialog(this, "Seleccione el cliente.");
            return false;
        }
        return true;
    }
}
