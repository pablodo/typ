/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package treintayplaya;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pablo
 */
public class AltaContrato extends javax.swing.JInternalFrame {

    /**
     * Creates new form AltaContrato
     */
    private int id;
    java.sql.Connection cnx;
        
    public AltaContrato() {
        this(0);
    }

    public AltaContrato(Integer id) {
        initComponents();
        cnx = Conexion.getInstance().getConnection();
        getRootPane().setDefaultButton(jbtnAceptar);
        this.id = id;
        if (id > 0){
            cargarContrato();
            setTitle("Actualizar Contrato");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlblNombre = new javax.swing.JLabel();
        jtxfTipo = new javax.swing.JTextField();
        jbtnAceptar = new javax.swing.JButton();
        jbtnCancelar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtxaDetalle = new javax.swing.JTextArea();

        setClosable(true);
        setTitle("Alta de Contratos");

        jlblNombre.setText("Tipo de Contrato:");

        jtxfTipo.setDocument(new FixedLengthDocument(40));

        jbtnAceptar.setText("Aceptar");
        jbtnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAceptarActionPerformed(evt);
            }
        });

        jbtnCancelar.setText("Cancelar");
        jbtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCancelarActionPerformed(evt);
            }
        });

        jScrollPane2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Detalle", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(255, 0, 0))); // NOI18N

        jtxaDetalle.setDocument(new FixedLengthDocument(1000));
        jtxaDetalle.setTabSize(4);
        jScrollPane2.setViewportView(jtxaDetalle);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createSequentialGroup()
                        .add(jlblNombre)
                        .add(18, 18, 18)
                        .add(jtxfTipo))
                    .add(jScrollPane2)
                    .add(layout.createSequentialGroup()
                        .add(0, 294, Short.MAX_VALUE)
                        .add(jbtnAceptar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 111, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jbtnCancelar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 107, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jlblNombre)
                    .add(jtxfTipo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE)
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jbtnAceptar)
                    .add(jbtnCancelar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_jbtnCancelarActionPerformed

    private void jbtnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAceptarActionPerformed
        try {
            String query = "insert into Contratos (conTipo, conDetalle) values (?, ?)";
            if (id > 0)
                query = "UPDATE Contratos SET conTipo=?, conDetalle=? WHERE ID=?";
            
            java.sql.PreparedStatement pstm = cnx.prepareStatement(query);
            
            pstm.setString(1, jtxfTipo.getText().trim());
            pstm.setString(2, jtxaDetalle.getText().trim());
            if (id > 0)
                pstm.setInt(3, id);
            
            pstm.executeUpdate();
            pstm.close();
            
            MantenimientoContratos.actualizaTabla();
            
            dispose();
            
        } catch(java.sql.SQLException sqle) {
            sqle.printStackTrace();
        }
    }//GEN-LAST:event_jbtnAceptarActionPerformed

    
    private void cargarContrato() {
        try {
            java.sql.PreparedStatement pstm = cnx.prepareStatement("SELECT * FROM Contratos WHERE ID = ?");
            pstm.setInt(1, id);
            java.sql.ResultSet rst = pstm.executeQuery();
            
            rst.next();
            jtxfTipo.setText(rst.getString("conTipo"));
            jtxaDetalle.setText(rst.getString("conDetalle"));
            rst.close();
            pstm.close();
        } catch (SQLException ex) {
            Logger.getLogger(AltaContrato.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jbtnAceptar;
    private javax.swing.JButton jbtnCancelar;
    private javax.swing.JLabel jlblNombre;
    private javax.swing.JTextArea jtxaDetalle;
    private javax.swing.JTextField jtxfTipo;
    // End of variables declaration//GEN-END:variables

}