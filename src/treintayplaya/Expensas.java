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
public class Expensas extends javax.swing.JInternalFrame {

    /**
     * Creates new form mantenimientoBancos
     */
    public static javax.swing.table.DefaultTableModel modelo;
    public static java.sql.Connection cnx;
    private ArrayList<Integer> ids;
    private ArrayList<Integer> propIds;
    private boolean actualizar;
    
    public Expensas() {
        modelo = new javax.swing.table.DefaultTableModel();
        cnx = Conexion.getInstance().getConnection();
        initComponents();
        cargarCombos();
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
        jbtnOK = new javax.swing.JButton();
        jftfImporte = new javax.swing.JFormattedTextField();
        jlblFecha = new javax.swing.JLabel();
        jdcFecha = new com.toedter.calendar.JDateChooser();
        jbtnCancelar = new javax.swing.JButton();
        jlblPropietario = new javax.swing.JLabel();
        jcbxPropietarios = new treintayplaya.ComboTabla();

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

        jbtnCancelar.setMnemonic('n');
        jbtnCancelar.setText("Cancelar");
        jbtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCancelarActionPerformed(evt);
            }
        });

        jlblPropietario.setText("Propietario:");

        org.jdesktop.layout.GroupLayout jpnlAltaMovimientoLayout = new org.jdesktop.layout.GroupLayout(jpnlAltaMovimiento);
        jpnlAltaMovimiento.setLayout(jpnlAltaMovimientoLayout);
        jpnlAltaMovimientoLayout.setHorizontalGroup(
            jpnlAltaMovimientoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jpnlAltaMovimientoLayout.createSequentialGroup()
                .addContainerGap()
                .add(jpnlAltaMovimientoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jlblFecha)
                    .add(jlblPropietario, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 92, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(jpnlAltaMovimientoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jpnlAltaMovimientoLayout.createSequentialGroup()
                        .add(jdcFecha, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 223, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jlblImporte, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jftfImporte, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 223, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(175, 175, 175))
                    .add(jpnlAltaMovimientoLayout.createSequentialGroup()
                        .add(jcbxPropietarios, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 402, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(jbtnOK, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 117, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jbtnCancelar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 117, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(9, 9, 9))))
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
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jpnlAltaMovimientoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jlblPropietario)
                    .add(jcbxPropietarios, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jbtnOK)
                    .add(jbtnCancelar))
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
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jpnlAltaMovimiento, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 92, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
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
            int destino = 2;
            String detalle = "Expensas";
            int propID = jcbxPropietarios.getSelectedId();
            int id = 0;
            int operacion = -1;
            int alqID = 0;
            if (actualizar)
                id = ids.get(jtblMovimientos.getSelectedRow());

            boolean result = Movimientos.guardarMovimiento(id, fecha, importe, destino, detalle, alqID, operacion, propID); 
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
            Logger.getLogger(Expensas.class.getName()).log(Level.SEVERE, null, ex);
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
			Logger.getLogger(Expensas.class.getName()).log(Level.SEVERE, null, ex);
		}
        jcbxPropietarios.setSelectedItemById(propIds.get(row));
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
                           "LEFT JOIN Propietarios ON movPropietario = propID " +
                           "LEFT JOIN UnidadesFuncionales ON propUF = ufID " +
                           "WHERE movOperacion = -1 " +
                           "ORDER BY movFecha DESC";
            java.sql.ResultSet rst = stm.executeQuery(query);
            
            ids = new ArrayList<Integer>();
            propIds = new ArrayList<Integer>();
            modelo = new javax.swing.table.DefaultTableModel();
            jtblMovimientos.setModel(modelo);
            Object[] headers = {"Fecha", 
								"Importe",
                                "Propietario",
                                "UF",
                                "Estado"};
            modelo.setColumnIdentifiers(headers);
            while(rst.next()) {
                ids.add(rst.getInt("movID"));
                propIds.add(rst.getInt("propID"));
				Double importe = rst.getDouble("movImporte");
                String estado = "Sin liquidar";
                if (rst.getInt("movLiquidacion") > 0){
                    estado = "Liquidado";
                }
                Object [] fila = {FechasFormatter.getFechaSimpleString(rst.getString("movFecha")),
								  Funciones.formatNumber(importe),
                                  rst.getString("propApellido") + ", " + rst.getString("propNombre"),
                                  rst.getString("ufNombre"),
                                  estado,
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
        jcbxPropietarios.setEnabled(option);
        jbtnOK.setEnabled(option);
		jbtnCancelar.setEnabled(option);
        jtblMovimientos.setEnabled(! option);
		jdcFecha.setCalendar(new GregorianCalendar());
		jftfImporte.setValue(0);
        jcbxPropietarios.setSelectedIndex(-1);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnActualizar;
    private javax.swing.JButton jbtnAgregar;
    private javax.swing.JButton jbtnBorrar;
    private javax.swing.JButton jbtnCancelar;
    private javax.swing.JButton jbtnCerrar;
    private javax.swing.JButton jbtnOK;
    private treintayplaya.ComboTabla jcbxPropietarios;
    private com.toedter.calendar.JDateChooser jdcFecha;
    private javax.swing.JFormattedTextField jftfImporte;
    private javax.swing.JLabel jlblFecha;
    private javax.swing.JLabel jlblImporte;
    private javax.swing.JLabel jlblPropietario;
    private javax.swing.JPanel jpnlAltaMovimiento;
    private javax.swing.JTable jtblMovimientos;
    // End of variables declaration//GEN-END:variables

    private boolean valida() {
        if (! Funciones.validaTextField(this, jftfImporte, "Importe")) return false;
        if (! Funciones.validaCombo(this, jcbxPropietarios, "Propietario")) return false;
        return true;
    }

    private void cargarCombos() {
        String query = "SELECT propID, concat(propApellido, ', ', propNombre, ' (', ufNombre, ')') as nombre " +
                       "FROM Propietarios INNER JOIN UnidadesFuncionales ON ufID = propUF";
        Funciones.cargarComboTabla(jcbxPropietarios, query, "nombre", "propID");
    }
}
