/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package treintayplaya;

/**
 *
 * @author sergio
 */
public class TreintayPlaya {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                //new AccesoUsuarios().setVisible(true);
                new Reservas().setVisible(true);
            }
        });

    }
}
