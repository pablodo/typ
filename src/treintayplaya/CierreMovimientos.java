/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package treintayplaya;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.*;

/**
 *
 * @author sergio
 */
public class CierreMovimientos extends javax.swing.JInternalFrame {

    /**
     * Creates new form mantenimientoBancos
     */
    public static java.sql.Connection cnx;
    private ArrayList<Integer> ids;
    private String[] headers = {"Fecha", 
								"Importe",
								"Importe con Descuentos",
                                "A favor de",
								"Cuenta",
								"Comisión",
								"Detalle"};
	private String[] totalesHeaders = {"En Comercializadora",
									   "No imputado",
									   "Sin comisión",
									   "Comisiones",
									   "En el Propietario",
									   "A Pagar",
									   "A Cobrar",
									   "Ganancia"};
	private String[] historicoHeaders = {"Fecha saldado", 
										 "En Comercializadora",
  									     "No imputado",
									     "Sin comisión",
									     "Comisiones",
									     "En el Propietario",
									     "A Pagar",
									     "A Cobrar",
									     "Ganancia"};
    
    public CierreMovimientos() {
        cnx = Conexion.getInstance().getConnection();
        initComponents();
        habilitarMovimientos(false);
        jtblMovimientos.setDefaultRenderer(Object.class, new RenderMovimientos());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")  
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbtnCerrar = new javax.swing.JButton();
        jpnlMovimientos = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblMovimientos = new javax.swing.JTable(){     public boolean isCellEditable(int row, int col){         return false;     } };
        lblMovimientos = new javax.swing.JLabel();
        jbtnSaldar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtblTotales = new javax.swing.JTable(){     public boolean isCellEditable(int row, int col){         return false;     } };
        jScrollPane3 = new javax.swing.JScrollPane();
        jtblHistorico = new javax.swing.JTable(){     public boolean isCellEditable(int row, int col){         return false;     } };
        lblHistorico = new javax.swing.JLabel();
        lblPropietario = new javax.swing.JLabel();
        jcbxPropietarios = new treintayplaya.ComboTabla();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Consulta de movimientos");

        jbtnCerrar.setMnemonic('C');
        jbtnCerrar.setText("Cerrar");
        jbtnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCerrarActionPerformed(evt);
            }
        });

        jpnlMovimientos.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jpnlMovimientos.setEnabled(false);

        jtblMovimientos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_NEXT_COLUMN);
        jtblMovimientos.setGridColor(new java.awt.Color(204, 204, 204));
        jScrollPane1.setViewportView(jtblMovimientos);

        lblMovimientos.setText("Movimientos");

        jbtnSaldar.setMnemonic('S');
        jbtnSaldar.setText("Saldar movimientos");
        jbtnSaldar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSaldarActionPerformed(evt);
            }
        });

        jtblTotales.setGridColor(new java.awt.Color(204, 204, 204));
        jScrollPane2.setViewportView(jtblTotales);

        jtblHistorico.setGridColor(new java.awt.Color(204, 204, 204));
        jScrollPane3.setViewportView(jtblHistorico);

        lblHistorico.setText("Histórico");

        org.jdesktop.layout.GroupLayout jpnlMovimientosLayout = new org.jdesktop.layout.GroupLayout(jpnlMovimientos);
        jpnlMovimientos.setLayout(jpnlMovimientosLayout);
        jpnlMovimientosLayout.setHorizontalGroup(
            jpnlMovimientosLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jpnlMovimientosLayout.createSequentialGroup()
                .addContainerGap()
                .add(jpnlMovimientosLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jpnlMovimientosLayout.createSequentialGroup()
                        .add(0, 0, Short.MAX_VALUE)
                        .add(jbtnSaldar))
                    .add(jScrollPane2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 888, Short.MAX_VALUE)
                    .add(jScrollPane1)
                    .add(jScrollPane3)
                    .add(jpnlMovimientosLayout.createSequentialGroup()
                        .add(jpnlMovimientosLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(lblHistorico)
                            .add(lblMovimientos))
                        .add(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jpnlMovimientosLayout.setVerticalGroup(
            jpnlMovimientosLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jpnlMovimientosLayout.createSequentialGroup()
                .addContainerGap()
                .add(lblHistorico)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 95, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(lblMovimientos)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 69, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jbtnSaldar)
                .addContainerGap())
        );

        lblPropietario.setText("Propietario:");

        Funciones.cargarComboTablaApellidoNombre((ComboTabla)jcbxPropietarios, "SELECT * FROM Propietarios WHERE propUF > 0 ORDER BY propApellido", "propApellido", "propNombre", "propID");
        jcbxPropietarios.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbxPropietariosItemStateChanged(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(0, 0, Short.MAX_VALUE)
                        .add(jbtnCerrar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 117, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(layout.createSequentialGroup()
                        .add(lblPropietario)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jcbxPropietarios, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 326, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(0, 0, Short.MAX_VALUE))
                    .add(jpnlMovimientos, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lblPropietario)
                    .add(jcbxPropietarios, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jpnlMovimientos, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jbtnCerrar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCerrarActionPerformed
        dispose();
    }//GEN-LAST:event_jbtnCerrarActionPerformed

    private void jbtnSaldarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSaldarActionPerformed
        String where = " WHERE";
        for (Integer id: ids){
            if(id > 0){
                where += " movID=" + String.valueOf(id);
                if (ids.indexOf(id) < ids.size()-1){
                    where += " OR";
                }
            }
        }
        String query = "UPDATE Movimientos SET movSaldado=1, movFechaSaldado=?, movPropietarioSaldado=?" + where;
        try {
            java.sql.PreparedStatement pstm = cnx.prepareStatement(query);
            pstm.setString(1, FechasFormatter.getFechaString(new GregorianCalendar()));
            pstm.setInt   (2, ((ComboTabla)jcbxPropietarios).getSelectedId());
            int result = pstm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CierreMovimientos.class.getName()).log(Level.SEVERE, null, ex);
        }
        habilitarMovimientos(false);
		jtblHistorico.setModel(new DefaultTableModel());
        jcbxPropietarios.setSelectedIndex(-1);
        jcbxPropietarios.requestFocus();
    }//GEN-LAST:event_jbtnSaldarActionPerformed

	private void jcbxPropietariosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbxPropietariosItemStateChanged
        if (jcbxPropietarios.getSelectedIndex() < 0){
            return;
        }
		int propID = ((ComboTabla)jcbxPropietarios).getSelectedId();
		if (propID > 0){
			cargaTablas(propID, true);
			cargaTablas(propID, false);
			habilitarMovimientos(jtblMovimientos.getRowCount() > 0);
		}else{
			habilitarMovimientos(false);
		}
	}//GEN-LAST:event_jcbxPropietariosItemStateChanged

	public void cargaTablas(int propID, boolean historico) {
		DefaultTableModel modeloHistorico = null;
		DefaultTableModel modelo = null;
        try {
			String query = "SELECT * FROM Movimientos " +
					"INNER JOIN Alquileres ON movAlqID = alqID " +
					"INNER JOIN UnidadesFuncionales ON alqUF = ufID " +
					"LEFT JOIN Propietarios as p1 ON alqCuentaImpPropID = p1.propID " +
					"LEFT JOIN Propietarios as p2 ON alqUF = p2.propUF " +
					"WHERE (p1.propID = ? OR p2.propID = ?) AND alqEstado = 2 AND movSaldado = ? AND movAlqID != 0 ";
			if (historico){
				query += "AND movPropietarioSaldado = ? GROUP BY movID ORDER BY alqID, movFechaSaldado, movFecha DESC";
				modeloHistorico = limpiarTabla(jtblHistorico, historicoHeaders);
			}else{
				query += "GROUP BY movID ORDER BY alqID, movFecha DESC";
				ids = new ArrayList<Integer>();
				modelo = limpiarTabla(jtblMovimientos, headers);
			}
            java.sql.PreparedStatement pstm = cnx.prepareStatement(query);
			pstm.setInt(1, propID);
			pstm.setInt(2, propID);
            if (historico){
                pstm.setInt(3, 1);
                pstm.setInt(4, propID);
            }else{
                pstm.setInt(3, 0);
            }
            java.sql.ResultSet rst = pstm.executeQuery();
			TotalMovimientos totales = new TotalMovimientos();
			Importe importe = new Importe();
			String fechaSaldadoAnt = "";
			int alqIDAnt = 0;

			while(rst.next()) {
                int movPropID = rst.getInt("alqCuentaImpPropID");

                if (movPropID > 0 && movPropID != propID){
                    //Si tiene una cuenta de deposito, y no es la del propietario actual, que siga de largo
                    continue;
                }

				int alqID = rst.getInt("alqID");
				int destino = rst.getInt("movDestino");
				importe.setImporte(rst.getDouble("movImporte"));
				importe.porcentajeComision = rst.getDouble("ufPrecio");
				String fechaSaldado = FechasFormatter.getFechaFromMySQL(rst.getString("movFechaSaldado"));
				
				boolean agregarHistorico = historico && ! fechaSaldadoAnt.equals(fechaSaldado) && ! fechaSaldadoAnt.equals("");
				if (agregarHistorico){
					totales.fechaSaldado = fechaSaldadoAnt;
					totales.calcularTotales();
					modeloHistorico.addRow(totales.toRow());
					totales = new TotalMovimientos();
				}
				fechaSaldadoAnt = fechaSaldado;
				if (alqID != alqIDAnt){
					alqIDAnt = alqID;
					importe.sinComision = rst.getDouble("alqImporteSinComision");
					importe.diferenciaImputacion = rst.getDouble("alqDifImputacion");
					totales.sinComision += importe.sinComision;
					totales.noImputado += importe.diferenciaImputacion;
					if(! historico){
						String[] row = {"Alquiler " + String.valueOf(alqID),
										"Total: " + Funciones.formatNumber(rst.getDouble("alqTotal")),
										"No imputado: " + importe.getDiferenciaImputacion(),
										"Sin comisión: " + importe.getSinComision(),
										"Comision(%): " + Funciones.formatNumber(importe.porcentajeComision, "#0.00")
										};
						modelo.addRow(row);
						ids.add(0);
					}
				}
				importe.actualizar();
				//Movimientos
				totales.comisiones += importe.comision;
				if (! historico){
					ids.add(rst.getInt("movID"));
					Object [] fila = {FechasFormatter.getFechaFromMySQL(rst.getString("movFecha")),
									  importe.getImporte(),
									  importe.getImporteConDescuentos(),
									  Movimientos.destinos[destino],
									  rst.getString("propNCuenta"),
									  importe.getComision(),
									  rst.getString("movDetalle")};
					modelo.addRow(fila);
				}
				if (destino == 1)
					totales.comercializadora += importe.importe;
				if (destino == 2)
					totales.propietario += importe.importe;
			}
			if (historico){
				totales.fechaSaldado = fechaSaldadoAnt;
				totales.calcularTotales();
				modeloHistorico.addRow(totales.toRow());
			}else{
				totales.calcularTotales();
				jtblTotales.setModel(new DefaultTableModel(new Object[][]{totales.toRow()}, totalesHeaders)); 
			}
            rst.close();
            pstm.close();
        } catch (java.sql.SQLException sqle) {
            sqle.printStackTrace();
        }
    }
    
    private void habilitarMovimientos(boolean option){
        jtblMovimientos.setEnabled(option);
		jtblTotales.setEnabled(option);
		jbtnSaldar.setEnabled(option);
        if (! option){
            jtblMovimientos.setModel(new DefaultTableModel());
            jtblTotales.setModel(new DefaultTableModel());
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton jbtnCerrar;
    private javax.swing.JButton jbtnSaldar;
    private javax.swing.JComboBox jcbxPropietarios;
    private javax.swing.JPanel jpnlMovimientos;
    private javax.swing.JTable jtblHistorico;
    private javax.swing.JTable jtblMovimientos;
    private javax.swing.JTable jtblTotales;
    private javax.swing.JLabel lblHistorico;
    private javax.swing.JLabel lblMovimientos;
    private javax.swing.JLabel lblPropietario;
    // End of variables declaration//GEN-END:variables

    private boolean valida() {
        return true;
    }

	private DefaultTableModel limpiarTabla(JTable tabla, String[] headers) {
		DefaultTableModel modelo = new DefaultTableModel();
		tabla.setModel(modelo);
		modelo.setColumnIdentifiers(headers);
		return modelo;
	}

    private class RenderMovimientos extends DefaultTableCellRenderer implements TableCellRenderer {
         
        @Override
        public Component getTableCellRendererComponent(JTable table,
                                                       Object value, 
                                                       boolean isSelected,
                                                       boolean hasFocus,
                                                       int row, 
                                                       int column) {
            
                setEnabled(table == null || table.isEnabled());
                TableColumnModel tcm = table.getColumnModel();
                TableColumn columnaCero = tcm.getColumn(0);
                columnaCero.setPreferredWidth(150);
                
                Object rowValue = table.getValueAt(row, 0);
                if (rowValue != null){
                    Font font = table.getFont();
                    if (rowValue.toString().startsWith("Alquiler")){
                        setBackground(new Color(100, 255,100));
                        font = font.deriveFont(Font.BOLD);
                    }else{
                        setBackground(Color.WHITE);
                        font = font.deriveFont(Font.PLAIN);
                    }
                    table.setFont(font);
                }
                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);         
                
                return this;
        }
    }

	private class TotalMovimientos{
		public double comercializadora = 0.0;
		public double propietario = 0.0;
		public double comisiones = 0.0;
		public double noImputado = 0.0;
		public double sinComision = 0.0;
		public double aPagar = 0.0;
		public double aCobrar = 0.0;
		public double ganancia = 0.0;
		public String fechaSaldado = "";

		public String getComercializadora(){
			return Funciones.formatNumber(comercializadora);
		}
		public String getPropietario(){
			return Funciones.formatNumber(propietario);
		}
		public String getComisiones(){
			return Funciones.formatNumber(comisiones);
		}
		public String getNoImputado(){
			return Funciones.formatNumber(noImputado);
		}
		public String getSinComision(){
			return Funciones.formatNumber(sinComision);
		}
		public String getAPagar(){
			return Funciones.formatNumber(aPagar);
		}
		public String getACobrar(){
			return Funciones.formatNumber(aCobrar);
		}
		public String getGanancia(){
			return Funciones.formatNumber(ganancia);
		}
		public void calcularTotales(){
			ganancia = comisiones + noImputado;
			aCobrar = comisiones - comercializadora;
			if (aCobrar < 0) aCobrar = 0.0;
			aPagar = comercializadora - comisiones - noImputado;
			if (aPagar < 0) aPagar = 0.0;
		}
		public Object[] toRow() {
			ArrayList list = new ArrayList();
			if (! fechaSaldado.equals(""))
				list.add(fechaSaldado);
			list.add(getComercializadora());
			list.add(getNoImputado());
			list.add(getSinComision());
			list.add(getComisiones());
			list.add(getPropietario());
			list.add(getAPagar());
			list.add(getACobrar());
			list.add(getGanancia());
			return list.toArray();
		}
	}

	private class Importe{
		public double importe = 0.0;
		public double sinComision = 0.0;
		public double conDescuentos = 0.0;
		public double diferenciaImputacion = 0.0;
		public double comision = 0.0;
		public double porcentajeComision = 0.0;

		public void actualizar() {
			//Saco la imputacion a los movimientos
			if (diferenciaImputacion > 0){
				if (conDescuentos >= diferenciaImputacion){
					conDescuentos -= diferenciaImputacion;
					diferenciaImputacion = 0.0;
				}else{
					conDescuentos = 0.0;
					diferenciaImputacion -= conDescuentos;
				}
			}
			//Saco el importe sin comision
			if (sinComision > 0){
				if (conDescuentos >= sinComision){
					conDescuentos -= sinComision;
					sinComision = 0.0;
				}else{
					conDescuentos = 0.0;
					sinComision -= conDescuentos;
				}
			}
			comision = conDescuentos / 100 * porcentajeComision;
		}

		public void setImporte(Double importe){
			this.importe = importe;
			this.conDescuentos = importe;
		}
		public String getDiferenciaImputacion() {
			return Funciones.formatNumber(diferenciaImputacion);
		}
		public String getSinComision() {
			return Funciones.formatNumber(sinComision);
		}
		private String getImporte() {
			return Funciones.formatNumber(importe);
		}
		private String getImporteConDescuentos() {
			return Funciones.formatNumber(conDescuentos);
		}
		private String getComision(){
			return Funciones.formatNumber(comision);
		}
	}
}
