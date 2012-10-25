/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * AppPrincipal.java
 *
 * Created on 11-oct-2011, 9:31:54
 */
package treintayplaya;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sergio
 */
public class AppPrincipal extends javax.swing.JFrame {
    public final static MailSender mailSender = new MailSender(Configuracion.getInstance());

    /** Creates new form AppPrincipal */
    public AppPrincipal() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        jlblAppUsuario = new javax.swing.JLabel();
        AppMenuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        saveMenuItem = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        exitMenuItem = new javax.swing.JMenuItem();
        usrMenu = new javax.swing.JMenu();
        loginMenuItem = new javax.swing.JMenuItem();
        logoutMenuItem = new javax.swing.JMenuItem();
        admMenu = new javax.swing.JMenu();
        consultasMenu = new javax.swing.JMenu();
        jmiVistaMensual = new javax.swing.JMenuItem();
        jmiClientes = new javax.swing.JMenuItem();
        jmiPropietarios = new javax.swing.JMenuItem();
        jmiUF = new javax.swing.JMenuItem();
        jmiUsrWeb = new javax.swing.JMenuItem();
        mantenimientoMenu = new javax.swing.JMenu();
        jmiBancos = new javax.swing.JMenuItem();
        jmiTCuentas = new javax.swing.JMenuItem();
        jmiFormasPago = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        jmiTiposUF = new javax.swing.JMenuItem();
        jmiContratos = new javax.swing.JMenuItem();
        movimientosMenu = new javax.swing.JMenu();
        jmiABMLMovimientos = new javax.swing.JMenuItem();
        jmiCerrarMovimientos = new javax.swing.JMenuItem();
        propMenu = new javax.swing.JMenu();
        jmiPropResumenes = new javax.swing.JMenuItem();
        listadosMenu = new javax.swing.JMenu();
        jmniDeudores = new javax.swing.JMenuItem();
        jmniEntrantes = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        tagsMenuItem = new javax.swing.JMenuItem();
        contentMenuItem = new javax.swing.JMenuItem();
        aboutMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Treinta y Playa - Sistema de Gestión");
        setMinimumSize(new java.awt.Dimension(920, 600));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        desktopPane.setAutoscrolls(true);
        desktopPane.setMinimumSize(new java.awt.Dimension(400, 300));

        jPanel1.setPreferredSize(new java.awt.Dimension(400, 50));

        jlblAppUsuario.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlblAppUsuario.setText("Sesión NO Iniciada.");

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(827, Short.MAX_VALUE)
                .add(jlblAppUsuario)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(jlblAppUsuario)
                .add(0, 12, Short.MAX_VALUE))
        );

        fileMenu.setMnemonic('A');
        fileMenu.setText("Archivo");

        saveMenuItem.setMnemonic('E');
        saveMenuItem.setText("Exportar a...");
        saveMenuItem.setEnabled(false);
        fileMenu.add(saveMenuItem);
        fileMenu.add(jSeparator1);

        exitMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        exitMenuItem.setMnemonic('S');
        exitMenuItem.setText("Salir");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        AppMenuBar.add(fileMenu);

        usrMenu.setMnemonic('S');
        usrMenu.setText("Sesión");

        loginMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_MASK));
        loginMenuItem.setMnemonic('i');
        loginMenuItem.setText("Iniciar Sesión");
        loginMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginMenuItemActionPerformed(evt);
            }
        });
        usrMenu.add(loginMenuItem);

        logoutMenuItem.setMnemonic('C');
        logoutMenuItem.setText("Cerrar Sesión");
        logoutMenuItem.setToolTipText("");
        logoutMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutMenuItemActionPerformed(evt);
            }
        });
        usrMenu.add(logoutMenuItem);

        AppMenuBar.add(usrMenu);

        admMenu.setMnemonic('d');
        admMenu.setText("Administradores");
        admMenu.setEnabled(false);

        consultasMenu.setMnemonic('C');
        consultasMenu.setText("Consultas");

        jmiVistaMensual.setMnemonic('V');
        jmiVistaMensual.setText("Vista Mensual");
        jmiVistaMensual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiVistaMensualActionPerformed(evt);
            }
        });
        consultasMenu.add(jmiVistaMensual);

        jmiClientes.setMnemonic('I');
        jmiClientes.setText("Inquilinos");
        jmiClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiClientesActionPerformed(evt);
            }
        });
        consultasMenu.add(jmiClientes);

        jmiPropietarios.setMnemonic('P');
        jmiPropietarios.setText("Propietarios");
        jmiPropietarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiPropietariosActionPerformed(evt);
            }
        });
        consultasMenu.add(jmiPropietarios);

        jmiUF.setMnemonic('F');
        jmiUF.setText("Unidades Funcionales");
        jmiUF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiUFActionPerformed(evt);
            }
        });
        consultasMenu.add(jmiUF);

        jmiUsrWeb.setMnemonic('U');
        jmiUsrWeb.setText("Usuarios Web");
        jmiUsrWeb.setActionCommand("UsuariosWeb");
        jmiUsrWeb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiUsrWebActionPerformed(evt);
            }
        });
        consultasMenu.add(jmiUsrWeb);

        admMenu.add(consultasMenu);

        mantenimientoMenu.setMnemonic('M');
        mantenimientoMenu.setText("Mantenimiento");

        jmiBancos.setMnemonic('B');
        jmiBancos.setText("Bancos");
        jmiBancos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiBancosActionPerformed(evt);
            }
        });
        mantenimientoMenu.add(jmiBancos);

        jmiTCuentas.setMnemonic('C');
        jmiTCuentas.setText("Tipos de Cuentas");
        jmiTCuentas.setActionCommand("TiposCuentas");
        jmiTCuentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiTCuentasActionPerformed(evt);
            }
        });
        mantenimientoMenu.add(jmiTCuentas);

        jmiFormasPago.setMnemonic('F');
        jmiFormasPago.setText("Formas de Pago");
        jmiFormasPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiFormasPagoActionPerformed(evt);
            }
        });
        mantenimientoMenu.add(jmiFormasPago);
        mantenimientoMenu.add(jSeparator4);

        jmiTiposUF.setMnemonic('U');
        jmiTiposUF.setText("Tipos de Unidad Funcional");
        jmiTiposUF.setActionCommand("TiposUF");
        jmiTiposUF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiTiposUFActionPerformed(evt);
            }
        });
        mantenimientoMenu.add(jmiTiposUF);

        jmiContratos.setMnemonic('o');
        jmiContratos.setText("Contratos");
        jmiContratos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiContratosActionPerformed(evt);
            }
        });
        mantenimientoMenu.add(jmiContratos);

        admMenu.add(mantenimientoMenu);

        movimientosMenu.setMnemonic('o');
        movimientosMenu.setText("Movimientos");

        jmiABMLMovimientos.setMnemonic('A');
        jmiABMLMovimientos.setText("Altas, bajas y modificaciones");
        jmiABMLMovimientos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiABMLMovimientosActionPerformed(evt);
            }
        });
        movimientosMenu.add(jmiABMLMovimientos);

        jmiCerrarMovimientos.setMnemonic('C');
        jmiCerrarMovimientos.setText("Cerrar Movimientos");
        jmiCerrarMovimientos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiCerrarMovimientosActionPerformed(evt);
            }
        });
        movimientosMenu.add(jmiCerrarMovimientos);

        admMenu.add(movimientosMenu);

        AppMenuBar.add(admMenu);

        propMenu.setMnemonic('P');
        propMenu.setText("Propietarios");
        propMenu.setEnabled(false);

        jmiPropResumenes.setMnemonic('R');
        jmiPropResumenes.setText("Resumenes");
        propMenu.add(jmiPropResumenes);

        AppMenuBar.add(propMenu);

        listadosMenu.setMnemonic('L');
        listadosMenu.setText("Listados");
        listadosMenu.setEnabled(false);

        jmniDeudores.setMnemonic('D');
        jmniDeudores.setText("Deudores");
        jmniDeudores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmniDeudoresActionPerformed(evt);
            }
        });
        listadosMenu.add(jmniDeudores);

        jmniEntrantes.setMnemonic('E');
        jmniEntrantes.setText("Entrantes");
        jmniEntrantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmniEntrantesActionPerformed(evt);
            }
        });
        listadosMenu.add(jmniEntrantes);

        AppMenuBar.add(listadosMenu);

        helpMenu.setMnemonic('y');
        helpMenu.setText("Ayuda");

        tagsMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.CTRL_MASK));
        tagsMenuItem.setMnemonic('T');
        tagsMenuItem.setText("Tags disponibles");
        tagsMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tagsMenuItemActionPerformed(evt);
            }
        });
        helpMenu.add(tagsMenuItem);

        contentMenuItem.setMnemonic('c');
        contentMenuItem.setText("Contenidos");
        helpMenu.add(contentMenuItem);

        aboutMenuItem.setMnemonic('a');
        aboutMenuItem.setText("A cerca de...");
        aboutMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutMenuItemActionPerformed(evt);
            }
        });
        helpMenu.add(aboutMenuItem);

        AppMenuBar.add(helpMenu);

        setJMenuBar(AppMenuBar);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 976, Short.MAX_VALUE)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, desktopPane, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(desktopPane, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 541, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 30, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        exit();
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void aboutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutMenuItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_aboutMenuItemActionPerformed

    private void loginMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginMenuItemActionPerformed
        LoginUsuarios logUsr = new LoginUsuarios();
        desktopPane.add(logUsr);
        logUsr.show();        
    }//GEN-LAST:event_loginMenuItemActionPerformed

    private void jmiVistaMensualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiVistaMensualActionPerformed
        if(isAdmin()) {
            VistaActividadAdmin vistaAdmin = new VistaActividadAdmin();
            desktopPane.add(vistaAdmin);
            vistaAdmin.show();
        }
    }//GEN-LAST:event_jmiVistaMensualActionPerformed

    private void jmiClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiClientesActionPerformed
        if(isAdmin()) {
            ConsultaInquilinos listaCliente = new ConsultaInquilinos();
            desktopPane.add(listaCliente);
            listaCliente.show();
        }
    }//GEN-LAST:event_jmiClientesActionPerformed

    private void jmiPropietariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiPropietariosActionPerformed
        if(isAdmin()) {
            ConsultaPropietarios listaPropietarios = new ConsultaPropietarios();
            desktopPane.add(listaPropietarios);
            listaPropietarios.show();
        }
    }//GEN-LAST:event_jmiPropietariosActionPerformed

    private void jmiUFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiUFActionPerformed
        if(isAdmin()) {
            ConsultaUF cUF = new ConsultaUF();
            desktopPane.add(cUF);
            cUF.show();
        }
    }//GEN-LAST:event_jmiUFActionPerformed

    private void logoutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutMenuItemActionPerformed
        DatosGlobales.appSesion = false;
        DatosGlobales.usrEmail = "";
        DatosGlobales.usrNivel = -1;
        DatosGlobales.usrEstado = -1;
        
        admMenu.setEnabled(false);
        propMenu.setEnabled(false);
        
        jlblAppUsuario.setText("Sesión NO Iniciada.");
    }//GEN-LAST:event_logoutMenuItemActionPerformed

    private void jmiBancosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiBancosActionPerformed
        if(isAdmin()) {
            MantenimientoBancos mBancos = new MantenimientoBancos();
            desktopPane.add(mBancos);
            mBancos.show();
        }
    }//GEN-LAST:event_jmiBancosActionPerformed

    private void jmiTCuentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiTCuentasActionPerformed
        if(isAdmin()) {
            MantenimientoTipoCuentas mTC = new MantenimientoTipoCuentas();
            desktopPane.add(mTC);
            mTC.show();
        }
    }//GEN-LAST:event_jmiTCuentasActionPerformed

    private void jmiTiposUFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiTiposUFActionPerformed
        if(isAdmin()) {
            MantenimientoTipoUF mTUF = new MantenimientoTipoUF();
            desktopPane.add(mTUF);
            mTUF.show();
        }
    }//GEN-LAST:event_jmiTiposUFActionPerformed

    private void jmiContratosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiContratosActionPerformed
        if(isAdmin()) {
            MantenimientoContratos contratos = new MantenimientoContratos();
            desktopPane.add(contratos);
            contratos.show();
        }
    }//GEN-LAST:event_jmiContratosActionPerformed

    private void jmniDeudoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmniDeudoresActionPerformed
        if(isAdmin()) {
            ListadoAlquileres listado = new ListadoAlquileres(ListadoAlquileres.DEUDORES);
            desktopPane.add(listado);
            listado.show();
        }
    }//GEN-LAST:event_jmniDeudoresActionPerformed

    private void jmiFormasPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiFormasPagoActionPerformed
        if(isAdmin()) {
            MantenimientoFormasPago FormasPago = new MantenimientoFormasPago();
            desktopPane.add(FormasPago);
            FormasPago.show();
        }
    }//GEN-LAST:event_jmiFormasPagoActionPerformed

	private void tagsMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tagsMenuItemActionPerformed
		if (isAdmin()){
			Tags tags= new Tags();
			desktopPane.add(tags);	
			tags.show();
		}
	}//GEN-LAST:event_tagsMenuItemActionPerformed

	private void jmiABMLMovimientosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiABMLMovimientosActionPerformed
		if (isAdmin()){
			ConsultaMovimientos movimientos = new ConsultaMovimientos();
			desktopPane.add(movimientos);
			movimientos.show();
		}
	}//GEN-LAST:event_jmiABMLMovimientosActionPerformed

	private void jmiCerrarMovimientosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiCerrarMovimientosActionPerformed
		if (isAdmin()){
			CierreMovimientos movimientos = new CierreMovimientos();
			desktopPane.add(movimientos);
			movimientos.show();
		}
	}//GEN-LAST:event_jmiCerrarMovimientosActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        exit();
    }//GEN-LAST:event_formWindowClosed

    private void jmiUsrWebActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiUsrWebActionPerformed
		if (isAdmin()){
			ConsultaUsuarios usuarios = new ConsultaUsuarios();
			desktopPane.add(usuarios);
			usuarios.show();
		}
    }//GEN-LAST:event_jmiUsrWebActionPerformed

	private void jmniEntrantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmniEntrantesActionPerformed
		if(isAdmin() || isUsuario()) {
            ListadoAlquileres listado = new ListadoAlquileres(ListadoAlquileres.ENTRANTES);
            desktopPane.add(listado);
            listado.show();
        }
	}//GEN-LAST:event_jmniEntrantesActionPerformed

    public static boolean isAdmin(){
        return DatosGlobales.usrNivel == 1 && DatosGlobales.usrEstado == 1 && DatosGlobales.appSesion;
    }
    public static boolean isUsuario(){
        return DatosGlobales.usrNivel == 2 && DatosGlobales.usrEstado == 1 && DatosGlobales.appSesion;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AppPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AppPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AppPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AppPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new AppPrincipal().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JMenuBar AppMenuBar;
    private javax.swing.JMenuItem aboutMenuItem;
    public static javax.swing.JMenu admMenu;
    private javax.swing.JMenu consultasMenu;
    private javax.swing.JMenuItem contentMenuItem;
    public static javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    public static javax.swing.JLabel jlblAppUsuario;
    private javax.swing.JMenuItem jmiABMLMovimientos;
    private javax.swing.JMenuItem jmiBancos;
    private javax.swing.JMenuItem jmiCerrarMovimientos;
    private javax.swing.JMenuItem jmiClientes;
    private javax.swing.JMenuItem jmiContratos;
    private javax.swing.JMenuItem jmiFormasPago;
    private javax.swing.JMenuItem jmiPropResumenes;
    private javax.swing.JMenuItem jmiPropietarios;
    private javax.swing.JMenuItem jmiTCuentas;
    private javax.swing.JMenuItem jmiTiposUF;
    private javax.swing.JMenuItem jmiUF;
    private javax.swing.JMenuItem jmiUsrWeb;
    private javax.swing.JMenuItem jmiVistaMensual;
    private javax.swing.JMenuItem jmniDeudores;
    private javax.swing.JMenuItem jmniEntrantes;
    public static javax.swing.JMenu listadosMenu;
    private javax.swing.JMenuItem loginMenuItem;
    private javax.swing.JMenuItem logoutMenuItem;
    private javax.swing.JMenu mantenimientoMenu;
    private javax.swing.JMenu movimientosMenu;
    public static javax.swing.JMenu propMenu;
    private javax.swing.JMenuItem saveMenuItem;
    private javax.swing.JMenuItem tagsMenuItem;
    private javax.swing.JMenu usrMenu;
    // End of variables declaration//GEN-END:variables

    private void exit() {
        try {
            Conexion.getInstance().cnx.close();
        } catch (SQLException ex) {
            Logger.getLogger(AppPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.exit(0);
    }
}
