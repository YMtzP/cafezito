/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.Image;
import java.awt.Toolkit;

/**
 *
 * @author Alexis Salvador
 */
public class PantallaMenuMesero extends javax.swing.JFrame {

    /**
     * Creates new form PantallaMenuMesero
     */
    public PantallaMenuMesero() {
        initComponents();
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagenes/icon_cafezito.png"));
        setIconImage(icon);
        DialogoPregunta.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        DialogoPregunta = new javax.swing.JDialog(this,true);
        jPanel7 = new javax.swing.JPanel();
        LblPreguntaensaje = new javax.swing.JLabel();
        BtnActualizarno = new javax.swing.JButton();
        BtnActualizarsi = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        BtnModificarOrden = new javax.swing.JButton();
        BtnTomarOrden = new javax.swing.JButton();
        BtnCerrarSesion = new javax.swing.JButton();
        jLabel77 = new javax.swing.JLabel();

        DialogoPregunta.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        DialogoPregunta.setTitle("Mensaje de confirmación");
        DialogoPregunta.setBackground(new java.awt.Color(47, 20, 0));
        DialogoPregunta.setBounds(new java.awt.Rectangle(0, 0, 387, 152));
        DialogoPregunta.setMinimumSize(new java.awt.Dimension(360, 152));
        DialogoPregunta.setResizable(false);

        jPanel7.setBackground(new java.awt.Color(47, 20, 0));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 204), 2));
        jPanel7.setMinimumSize(new java.awt.Dimension(362, 145));

        LblPreguntaensaje.setFont(new java.awt.Font("AppleGothic", 0, 16)); // NOI18N
        LblPreguntaensaje.setForeground(new java.awt.Color(255, 255, 102));
        LblPreguntaensaje.setText("¿Desea Cerrar su Sesión?");

        BtnActualizarno.setBackground(new java.awt.Color(255, 255, 153));
        BtnActualizarno.setFont(new java.awt.Font("AppleGothic", 0, 16)); // NOI18N
        BtnActualizarno.setForeground(new java.awt.Color(47, 20, 0));
        BtnActualizarno.setText("No");

        BtnActualizarsi.setBackground(new java.awt.Color(255, 255, 153));
        BtnActualizarsi.setFont(new java.awt.Font("AppleGothic", 0, 16)); // NOI18N
        BtnActualizarsi.setForeground(new java.awt.Color(47, 20, 0));
        BtnActualizarsi.setText("Si");

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/question.png"))); // NOI18N

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel5)
                .addGap(43, 43, 43)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(BtnActualizarsi, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(BtnActualizarno, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(LblPreguntaensaje))
                .addContainerGap(97, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(LblPreguntaensaje)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BtnActualizarno)
                            .addComponent(BtnActualizarsi))))
                .addContainerGap(58, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout DialogoPreguntaLayout = new javax.swing.GroupLayout(DialogoPregunta.getContentPane());
        DialogoPregunta.getContentPane().setLayout(DialogoPreguntaLayout);
        DialogoPreguntaLayout.setHorizontalGroup(
            DialogoPreguntaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        DialogoPreguntaLayout.setVerticalGroup(
            DialogoPreguntaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DialogoPreguntaLayout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Menú - Cafezito");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BtnModificarOrden.setBackground(new java.awt.Color(3, 1, 0));
        BtnModificarOrden.setFont(new java.awt.Font("Tamil MN", 0, 18)); // NOI18N
        BtnModificarOrden.setForeground(new java.awt.Color(255, 255, 255));
        BtnModificarOrden.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/editarOrden.png"))); // NOI18N
        BtnModificarOrden.setText("Gestionar Orden");
        BtnModificarOrden.setMaximumSize(new java.awt.Dimension(205, 82));
        BtnModificarOrden.setMinimumSize(new java.awt.Dimension(205, 82));
        getContentPane().add(BtnModificarOrden, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 250, 260, 80));

        BtnTomarOrden.setBackground(new java.awt.Color(3, 1, 0));
        BtnTomarOrden.setFont(new java.awt.Font("Tamil MN", 0, 18)); // NOI18N
        BtnTomarOrden.setForeground(new java.awt.Color(255, 255, 255));
        BtnTomarOrden.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/tomar_orden.png"))); // NOI18N
        BtnTomarOrden.setText("Tomar Orden");
        getContentPane().add(BtnTomarOrden, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 160, 260, 80));

        BtnCerrarSesion.setBackground(new java.awt.Color(255, 255, 204));
        BtnCerrarSesion.setFont(new java.awt.Font("Tamil MN", 0, 18)); // NOI18N
        BtnCerrarSesion.setForeground(new java.awt.Color(3, 1, 0));
        BtnCerrarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/logout.png"))); // NOI18N
        BtnCerrarSesion.setText("Cerrar Sesión");
        getContentPane().add(BtnCerrarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 350, 260, 80));

        jLabel77.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/MenuM.jpg"))); // NOI18N
        getContentPane().add(jLabel77, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 470));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(PantallaMenuMesero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaMenuMesero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaMenuMesero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaMenuMesero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PantallaMenuMesero().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton BtnActualizarno;
    public javax.swing.JButton BtnActualizarsi;
    public javax.swing.JButton BtnCerrarSesion;
    public javax.swing.JButton BtnModificarOrden;
    public javax.swing.JButton BtnTomarOrden;
    public javax.swing.JDialog DialogoPregunta;
    public javax.swing.JLabel LblPreguntaensaje;
    private javax.swing.JLabel jLabel5;
    public javax.swing.JLabel jLabel77;
    private javax.swing.JPanel jPanel7;
    // End of variables declaration//GEN-END:variables
}
