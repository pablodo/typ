/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package treintayplaya;

import java.sql.SQLException;

/**
 *
 * @author sergio
 */
public class AltaInquilinos extends javax.swing.JInternalFrame {
    
    private Integer cliID;
    private AltaAlquiler altaAlquiler = null;
    private java.sql.Connection cnx;
    /**
     * Creates new form AltaInquilinos
     */
    public AltaInquilinos() {
        this(null, 0);
    }
    
    public AltaInquilinos(Integer cliID) {
        this(null, cliID);
    }
    
    public AltaInquilinos(AltaAlquiler altaAlquiler){
        this(altaAlquiler, 0);
    }

    public AltaInquilinos(AltaAlquiler altaAlquiler, Integer cliID) {     
        initComponents();
        this.cliID = cliID;
        this.altaAlquiler = altaAlquiler;
        if (cliID > 0 && this.altaAlquiler == null){
            setTitle("Modificar inquilino");
            cargarCliente(cliID);
        }
        getRootPane().setDefaultButton(jbtnAceptar);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlblDNI = new javax.swing.JLabel();
        jftfDNI = new javax.swing.JFormattedTextField();
        jlblApellido = new javax.swing.JLabel();
        jtxfApellido = new javax.swing.JTextField();
        jlblNombre = new javax.swing.JLabel();
        jtxfNombre = new javax.swing.JTextField();
        jlblTelefono = new javax.swing.JLabel();
        jlblCelular = new javax.swing.JLabel();
        jlblEmail = new javax.swing.JLabel();
        jtxfEmail = new javax.swing.JTextField();
        jbtnAceptar = new javax.swing.JButton();
        jbtnCancelar = new javax.swing.JButton();
        jtxfTelefono = new javax.swing.JTextField();
        jtxfCelular = new javax.swing.JTextField();

        setClosable(true);
        setTitle("Alta de Inquilinos");

        jlblDNI.setText("DNI:");

        try {
            jftfDNI.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jftfDNI.setFocusLostBehavior(javax.swing.JFormattedTextField.PERSIST);

        jlblApellido.setText("Apellido:");

        jlblNombre.setText("Nombre:");

        jlblTelefono.setText("Teléfono:");

        jlblCelular.setText("Celular:");

        jlblEmail.setText("Email:");

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

        jtxfTelefono.setDocument(new FixedLengthDocument(50));

        jtxfCelular.setDocument(new FixedLengthDocument(50));

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jlblDNI, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 111, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jlblApellido, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 102, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jlblNombre, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 102, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jlblEmail, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 94, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jlblCelular, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 94, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jlblTelefono, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 94, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(jbtnAceptar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 89, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jbtnCancelar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 95, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(jtxfNombre)
                    .add(jtxfApellido)
                    .add(jtxfTelefono)
                    .add(jtxfCelular)
                    .add(jtxfEmail)
                    .add(jftfDNI, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(12, 12, 12)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jlblDNI)
                    .add(jftfDNI, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jtxfApellido, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jlblApellido))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jlblNombre)
                    .add(jtxfNombre, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jtxfTelefono, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jlblTelefono))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jtxfCelular, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jlblCelular))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jtxfEmail, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jlblEmail))
                .add(9, 9, 9)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jbtnAceptar)
                    .add(jbtnCancelar))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_jbtnCancelarActionPerformed

    private void jbtnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAceptarActionPerformed
        try {
            cnx = Conexion.getInstance().getConnection();
            cnx.setAutoCommit(false);
            int result = insertCliente();
            if(result == 1) {
                if (this.altaAlquiler == null){
                    ConsultaInquilinos.actualizaTablaClientes();
                }else{
                    cliID = getUltimoCliente();
                    if (cliID > 0){
                        altaAlquiler.cargarInquilinos();
                        ((ComboTabla)altaAlquiler.jcbxCliente).setSelectedItemById(cliID);
                    }else{
                        throw new java.sql.SQLException();
                    }
                }
            }
        } catch(java.sql.SQLException sqle) {
            sqle.printStackTrace();
            try {
                cnx.rollback();
            } catch (SQLException ex) {}
        }finally{
            try {
                cnx.setAutoCommit(true);
            } catch (SQLException ex) {}
        }
        dispose();
    }//GEN-LAST:event_jbtnAceptarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbtnAceptar;
    private javax.swing.JButton jbtnCancelar;
    private javax.swing.JFormattedTextField jftfDNI;
    private javax.swing.JLabel jlblApellido;
    private javax.swing.JLabel jlblCelular;
    private javax.swing.JLabel jlblDNI;
    private javax.swing.JLabel jlblEmail;
    private javax.swing.JLabel jlblNombre;
    private javax.swing.JLabel jlblTelefono;
    private javax.swing.JTextField jtxfApellido;
    private javax.swing.JTextField jtxfCelular;
    private javax.swing.JTextField jtxfEmail;
    private javax.swing.JTextField jtxfNombre;
    private javax.swing.JTextField jtxfTelefono;
    // End of variables declaration//GEN-END:variables

    private void cargarCliente(Integer cliID) {
        try{
            cnx = Conexion.getInstance().getConnection();
            String query = "SELECT * FROM Clientes WHERE cliID = ?";
            java.sql.PreparedStatement pstm = cnx.prepareStatement(query);
            pstm.setInt(1, cliID);
            java.sql.ResultSet rst = pstm.executeQuery();
            
            rst.next();
            jtxfApellido.setText(rst.getString("cliApellido"));
            jtxfNombre.setText(rst.getString("cliNombre"));
            jtxfEmail.setText(rst.getString("cliEmail"));
            jftfDNI.setText(rst.getString("cliDNI"));
            jtxfCelular.setText(rst.getString("cliCelular").replaceAll("-", ""));
            jtxfTelefono.setText(rst.getString("cliTelefono"));
            
        }catch(java.sql.SQLException sqle){
            sqle.printStackTrace();
        }
    }

    private int insertCliente() throws SQLException {
        String query = "insert into Clientes (cliDNI, cliApellido, cliNombre, cliTelefono, cliCelular, cliEmail) values (?, ?, ?, ?, ?, ?)";
        if (cliID > 0)
            query = "UPDATE Clientes SET cliDNI=?, cliApellido=?, cliNombre=?, cliTelefono=?, cliCelular=?, cliEmail=? WHERE cliID=?";
        java.sql.PreparedStatement pstm = cnx.prepareStatement(query);
            
        pstm.setString(1, jftfDNI.getText());
        pstm.setString(2, jtxfApellido.getText());
        pstm.setString(3, jtxfNombre.getText());
        pstm.setString(4, jtxfTelefono.getText());
        pstm.setString(5, jtxfCelular.getText());
        pstm.setString(6, jtxfEmail.getText());
        if (cliID > 0)
            pstm.setInt(7, cliID);
        return pstm.executeUpdate();
    }

    private Integer getUltimoCliente() throws SQLException {
        java.sql.Statement stm = cnx.createStatement();
        java.sql.ResultSet rst = stm.executeQuery("SELECT LAST_INSERT_ID() as id FROM Clientes");
        rst.next();
        cliID = rst.getInt("id");
        return cliID;
    }
}
