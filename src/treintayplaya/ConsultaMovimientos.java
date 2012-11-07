/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package treintayplaya;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sergio
 */
public class ConsultaMovimientos extends javax.swing.JInternalFrame {

    /**
     * Creates new form mantenimientoBancos
     */
    public static javax.swing.table.DefaultTableModel modelo;
    public static java.sql.Connection cnx;
    private ArrayList<Integer> ids;
    private boolean actualizar;
    
    public ConsultaMovimientos() {
        modelo = new javax.swing.table.DefaultTableModel();
        cnx = Conexion.getInstance().getConnection();
        initComponents();
        altaMovimiento(false);
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
        jtblMovimientos = new javax.swing.JTable(){     public boolean isCellEditable(int row, int col){         return false;     } };
        jbtnAgregar = new javax.swing.JButton();
        jbtnBorrar = new javax.swing.JButton();
        jbtnActualizar = new javax.swing.JButton();
        jbtnCerrar = new javax.swing.JButton();
        jpnlAltaMovimiento = new javax.swing.JPanel();
        jlblImporte = new javax.swing.JLabel();
        jlblDestino = new javax.swing.JLabel();
        jcbxDestino = new javax.swing.JComboBox();
        jbtnOK = new javax.swing.JButton();
        jftfImporte = new javax.swing.JFormattedTextField();
        jlblFecha = new javax.swing.JLabel();
        jdcFecha = new com.toedter.calendar.JDateChooser();
        jlblDetalle = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtaDetalle = new javax.swing.JTextArea();
        jbtnCancelar = new javax.swing.JButton();

        setClosable(true);
        setTitle("Consulta de movimientos");

        jtblMovimientos.setModel(modelo);
        jtblMovimientos.setGridColor(new java.awt.Color(204, 204, 204));
        modelo.addColumn("Tipo de Unidad Funcional");
        modelo.addColumn("M2.");
        modelo.addColumn("Ambientes");
        modelo.addColumn("Ubicación");

        cargaTabla();
        jScrollPane1.setViewportView(jtblMovimientos);

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

        jpnlAltaMovimiento.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jpnlAltaMovimiento.setEnabled(false);

        jlblImporte.setText("Importe:");

        jlblDestino.setText("A favor de:");

        jcbxDestino.setMaximumRowCount(2);
        jcbxDestino.setModel(new javax.swing.DefaultComboBoxModel(new String[]{Movimientos.destinos[1], Movimientos.destinos[2]}));

        jbtnOK.setMnemonic('e');
        jbtnOK.setText("Aceptar");
        jbtnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnOKActionPerformed(evt);
            }
        });

        jftfImporte.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));
        jftfImporte.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jftfImporte.setValue(0);

        jlblFecha.setText("Fecha:");

        jdcFecha.setDateFormatString("dd/MM/yyyy HH:mm:ss");

        jlblDetalle.setText("Detalle:");

        jtaDetalle.setColumns(20);
        jtaDetalle.setDocument(new FixedLengthDocument(30));
        jtaDetalle.setRows(5);
        jScrollPane2.setViewportView(jtaDetalle);

        jbtnCancelar.setMnemonic('n');
        jbtnCancelar.setText("Cancelar");
        jbtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCancelarActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jpnlAltaMovimientoLayout = new org.jdesktop.layout.GroupLayout(jpnlAltaMovimiento);
        jpnlAltaMovimiento.setLayout(jpnlAltaMovimientoLayout);
        jpnlAltaMovimientoLayout.setHorizontalGroup(
            jpnlAltaMovimientoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jpnlAltaMovimientoLayout.createSequentialGroup()
                .addContainerGap()
                .add(jpnlAltaMovimientoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jlblDetalle, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 59, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jlblFecha)
                    .add(jlblDestino))
                .add(jpnlAltaMovimientoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jpnlAltaMovimientoLayout.createSequentialGroup()
                        .add(14, 14, 14)
                        .add(jpnlAltaMovimientoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jpnlAltaMovimientoLayout.createSequentialGroup()
                                .add(jScrollPane2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                .add(jbtnOK, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 117, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(jpnlAltaMovimientoLayout.createSequentialGroup()
                                .add(566, 566, 566)
                                .add(jbtnCancelar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 117, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                        .add(18, 18, 18))
                    .add(jpnlAltaMovimientoLayout.createSequentialGroup()
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jpnlAltaMovimientoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(jdcFecha, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                            .add(jcbxDestino, 0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .add(33, 33, 33)
                        .add(jlblImporte, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jftfImporte, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 223, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(154, 154, 154))))
        );
        jpnlAltaMovimientoLayout.setVerticalGroup(
            jpnlAltaMovimientoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jpnlAltaMovimientoLayout.createSequentialGroup()
                .addContainerGap()
                .add(jpnlAltaMovimientoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.CENTER)
                    .add(jlblFecha)
                    .add(jftfImporte, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jlblImporte)
                    .add(jdcFecha, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jpnlAltaMovimientoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jcbxDestino, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jlblDestino))
                .add(12, 12, 12)
                .add(jpnlAltaMovimientoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(jlblDetalle)
                    .add(jpnlAltaMovimientoLayout.createSequentialGroup()
                        .add(jbtnOK)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jbtnCancelar))
                    .add(jScrollPane2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(0, 0, Short.MAX_VALUE)
                        .add(jbtnAgregar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 117, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jbtnBorrar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 114, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jbtnActualizar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 115, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jbtnCerrar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 117, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 804, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jpnlAltaMovimiento, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jpnlAltaMovimiento, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 158, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
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
        altaMovimiento(true);
        jftfImporte.requestFocus();
    }//GEN-LAST:event_jbtnAgregarActionPerformed

    private void jbtnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnOKActionPerformed
        if (! valida()) return;
        try {
            String fecha = FechasFormatter.getFechaToMySQL(jdcFecha.getCalendar());
            Double importe = Double.valueOf(String.valueOf(jftfImporte.getValue()));;
            int destino = jcbxDestino.getSelectedIndex() + 1;
            String detalle = jtaDetalle.getText();
            int id = 0;
            if (actualizar)
                id = ids.get(jtblMovimientos.getSelectedRow());

            boolean result = Movimientos.guardarMovimiento(id, fecha, importe, destino, detalle); 
            
            cargaTabla();
            altaMovimiento(false);
        } catch (java.sql.SQLException sqle) {
            sqle.printStackTrace();
        }
    }//GEN-LAST:event_jbtnOKActionPerformed

    private void jbtnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnBorrarActionPerformed
        try {
            String query = "DELETE FROM Movimientos WHERE movID = ?";
            java.sql.PreparedStatement pstm = cnx.prepareCall(query);
            pstm.setInt(1, ids.get(jtblMovimientos.getSelectedRow()));
            pstm.execute();
            cargaTabla();
            pstm.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaMovimientos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbtnBorrarActionPerformed

    private void jbtnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnActualizarActionPerformed
        Integer row = jtblMovimientos.getSelectedRow();
        if (row < 0){
            return;
        }
        actualizar = true;
        altaMovimiento(true);

		jdcFecha.setCalendar(FechasFormatter.getFechaCalendar(jtblMovimientos.getValueAt(row, 0).toString()));
		try {
			jftfImporte.setText(jtblMovimientos.getValueAt(row, 1).toString());
			jftfImporte.commitEdit();
		} catch (ParseException ex) {
			Logger.getLogger(ConsultaMovimientos.class.getName()).log(Level.SEVERE, null, ex);
		}
        jcbxDestino.setSelectedItem(jtblMovimientos.getValueAt(row, 2).toString());
		jtaDetalle.setText(jtblMovimientos.getValueAt(row, 3).toString());
    }//GEN-LAST:event_jbtnActualizarActionPerformed

	private void jbtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCancelarActionPerformed
		actualizar = false;
		altaMovimiento(false);
		jtblMovimientos.requestFocus();
	}//GEN-LAST:event_jbtnCancelarActionPerformed

    public void cargaTabla() {
        try {
            java.sql.Statement stm = cnx.createStatement();
			String query = "SELECT * FROM Movimientos " +
                           "LEFT JOIN Alquileres ON movAlqID = alqID " +
                           "LEFT JOIN UnidadesFuncionales ON alqUF = ufID " +
                           "ORDER BY movFecha DESC";
            java.sql.ResultSet rst = stm.executeQuery(query);
            
            ids = new ArrayList<Integer>();
            modelo = new javax.swing.table.DefaultTableModel();
            jtblMovimientos.setModel(modelo);
            Object[] headers = {"Fecha", 
								"Importe",
                                "A favor de",
								"Detalle",
                                "Estado",
                                "UF"};
            modelo.setColumnIdentifiers(headers);
            while(rst.next()) {
                ids.add(rst.getInt("movID"));
				Double importe = rst.getDouble("movImporte");
                String estado = "Sin liquidar";
                if (rst.getInt("movLiquidacion") > 0){
                    estado = "Liquidado";
                }
                Object [] fila = {FechasFormatter.getFechaFromMySQL(rst.getString("movFecha")),
								  Funciones.formatNumber(importe),
                                  Movimientos.destinos[rst.getInt("movDestino")],
								  rst.getString("movDetalle"),
                                  estado,
                                  rst.getString("ufNombre")
                                 };
                modelo.addRow(fila);
            }
            rst.close();
            stm.close();
        } catch (java.sql.SQLException sqle) {
            sqle.printStackTrace();
		}
    }
    
    private void altaMovimiento(boolean option){
		jdcFecha.setEnabled(option);
        jftfImporte.setEnabled(option);
        jcbxDestino.setEnabled(option);
        jbtnOK.setEnabled(option);
		jbtnCancelar.setEnabled(option);
        jtblMovimientos.setEnabled(! option);
		jdcFecha.setCalendar(new GregorianCalendar());
		jftfImporte.setValue(0);
        jcbxDestino.setSelectedIndex(-1);
		jtaDetalle.setEnabled(option);
		jtaDetalle.setText("");
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jbtnActualizar;
    private javax.swing.JButton jbtnAgregar;
    private javax.swing.JButton jbtnBorrar;
    private javax.swing.JButton jbtnCancelar;
    private javax.swing.JButton jbtnCerrar;
    private javax.swing.JButton jbtnOK;
    private javax.swing.JComboBox jcbxDestino;
    private com.toedter.calendar.JDateChooser jdcFecha;
    private javax.swing.JFormattedTextField jftfImporte;
    private javax.swing.JLabel jlblDestino;
    private javax.swing.JLabel jlblDetalle;
    private javax.swing.JLabel jlblFecha;
    private javax.swing.JLabel jlblImporte;
    private javax.swing.JPanel jpnlAltaMovimiento;
    private javax.swing.JTextArea jtaDetalle;
    private javax.swing.JTable jtblMovimientos;
    // End of variables declaration//GEN-END:variables

    private boolean valida() {
        if (! Funciones.validaTextField(this, jftfImporte, "Importe")) return false;
        if (! Funciones.validaCombo(this, jcbxDestino, "Destino")) return false;
        return true;
    }
}
