/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

/**
 *
 * @author Jose_Morales
 */
public class PantallaCobrarOrden extends javax.swing.JFrame {

    /**
     * Creates new form PantallaCobrarOrden
     */
    public PantallaCobrarOrden() {
        initComponents();
        DialogMsjCobrarOrden.setLocationRelativeTo(null);
        vistaTicket.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        DialogMsjCobrarOrden = new javax.swing.JDialog(this, true);
        jPanel1 = new javax.swing.JPanel();
        btnAceptarOrdenCobrada = new javax.swing.JButton();
        lblMensajeCobrarOrden = new javax.swing.JLabel();
        vistaTicket = new javax.swing.JDialog(this,true);
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        hojaTicket = new javax.swing.JTextArea();
        jPanel24 = new javax.swing.JPanel();
        jPanel29 = new javax.swing.JPanel();
        CbxNumeroMesaOrden = new javax.swing.JComboBox<>();
        TxtCobrarNumeroOrden = new javax.swing.JTextField();
        BtnCobrarBuscarOrden = new javax.swing.JButton();
        RbtnNumeroOrdenCobrar = new javax.swing.JRadioButton();
        RbtnNumeroMesaCobrar = new javax.swing.JRadioButton();
        jPanel30 = new javax.swing.JPanel();
        jLabel50 = new javax.swing.JLabel();
        jPanel31 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        TblCobrar = new javax.swing.JTable();
        LblTotalCobrar = new javax.swing.JLabel();
        LblTotalCobrar1 = new javax.swing.JLabel();
        LblCambioCobrar = new javax.swing.JLabel();
        BtnCobrar = new javax.swing.JButton();
        txtRecibidoCobrar = new javax.swing.JTextField();
        BtnRegresarCobrar = new javax.swing.JButton();
        jLabel91 = new javax.swing.JLabel();

        DialogMsjCobrarOrden.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        DialogMsjCobrarOrden.setTitle("Mensaje");
        DialogMsjCobrarOrden.setBackground(new java.awt.Color(47, 20, 0));
        DialogMsjCobrarOrden.setBounds(new java.awt.Rectangle(0, 0, 300, 145));

        jPanel1.setBackground(new java.awt.Color(47, 20, 0));

        btnAceptarOrdenCobrada.setText("Aceptar");
        btnAceptarOrdenCobrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarOrdenCobradaActionPerformed(evt);
            }
        });

        lblMensajeCobrarOrden.setFont(new java.awt.Font("Berlin Sans FB", 0, 16)); // NOI18N
        lblMensajeCobrarOrden.setForeground(new java.awt.Color(204, 204, 0));
        lblMensajeCobrarOrden.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMensajeCobrarOrden.setText("jLabel1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(107, 107, 107)
                .addComponent(btnAceptarOrdenCobrada, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lblMensajeCobrarOrden, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 23, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lblMensajeCobrarOrden, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAceptarOrdenCobrada)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout DialogMsjCobrarOrdenLayout = new javax.swing.GroupLayout(DialogMsjCobrarOrden.getContentPane());
        DialogMsjCobrarOrden.getContentPane().setLayout(DialogMsjCobrarOrdenLayout);
        DialogMsjCobrarOrdenLayout.setHorizontalGroup(
            DialogMsjCobrarOrdenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        DialogMsjCobrarOrdenLayout.setVerticalGroup(
            DialogMsjCobrarOrdenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        vistaTicket.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        vistaTicket.setTitle("Ticket de venta");
        vistaTicket.setBounds(new java.awt.Rectangle(0, 0, 440, 350));

        hojaTicket.setColumns(20);
        hojaTicket.setRows(5);
        jScrollPane1.setViewportView(hojaTicket);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 487, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout vistaTicketLayout = new javax.swing.GroupLayout(vistaTicket.getContentPane());
        vistaTicket.getContentPane().setLayout(vistaTicketLayout);
        vistaTicketLayout.setHorizontalGroup(
            vistaTicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        vistaTicketLayout.setVerticalGroup(
            vistaTicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cobrar Orden");
        setResizable(false);

        jPanel24.setBackground(new java.awt.Color(47, 20, 0));

        jPanel29.setBackground(new java.awt.Color(47, 20, 0));
        jPanel29.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true), "Buscar Por", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Monotype Corsiva", 0, 24), new java.awt.Color(255, 255, 204))); // NOI18N

        CbxNumeroMesaOrden.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        CbxNumeroMesaOrden.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5" }));

        TxtCobrarNumeroOrden.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N

        BtnCobrarBuscarOrden.setBackground(new java.awt.Color(193, 65, 0));
        BtnCobrarBuscarOrden.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        BtnCobrarBuscarOrden.setForeground(new java.awt.Color(255, 255, 255));
        BtnCobrarBuscarOrden.setText("Buscar");

        RbtnNumeroOrdenCobrar.setBackground(new java.awt.Color(47, 20, 0));
        buttonGroup1.add(RbtnNumeroOrdenCobrar);
        RbtnNumeroOrdenCobrar.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        RbtnNumeroOrdenCobrar.setForeground(new java.awt.Color(255, 255, 102));
        RbtnNumeroOrdenCobrar.setText("Número Orden:");
        RbtnNumeroOrdenCobrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RbtnNumeroOrdenCobrarActionPerformed(evt);
            }
        });

        RbtnNumeroMesaCobrar.setBackground(new java.awt.Color(47, 20, 0));
        buttonGroup1.add(RbtnNumeroMesaCobrar);
        RbtnNumeroMesaCobrar.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        RbtnNumeroMesaCobrar.setForeground(new java.awt.Color(255, 255, 102));
        RbtnNumeroMesaCobrar.setText("Número Mesa:");

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel29Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(RbtnNumeroOrdenCobrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtCobrarNumeroOrden, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel29Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(RbtnNumeroMesaCobrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CbxNumeroMesaOrden, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27)
                .addComponent(BtnCobrarBuscarOrden, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel29Layout.createSequentialGroup()
                        .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CbxNumeroMesaOrden, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(RbtnNumeroMesaCobrar))
                        .addGap(11, 11, 11)
                        .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TxtCobrarNumeroOrden, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(RbtnNumeroOrdenCobrar)))
                    .addGroup(jPanel29Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(BtnCobrarBuscarOrden)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel30.setBackground(new java.awt.Color(179, 66, 7));

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 11, Short.MAX_VALUE)
        );

        jLabel50.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logopeque.png"))); // NOI18N

        jPanel31.setBackground(new java.awt.Color(47, 20, 0));
        jPanel31.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true), "Datos de la Orden", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Monotype Corsiva", 0, 24), new java.awt.Color(255, 255, 204))); // NOI18N

        TblCobrar.setBackground(new java.awt.Color(255, 255, 153));
        TblCobrar.setFont(new java.awt.Font("Berlin Sans FB", 0, 11)); // NOI18N
        TblCobrar.setForeground(new java.awt.Color(51, 0, 0));
        TblCobrar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Cantidad", "Precio Unitario", "Subtotal"
            }
        ));
        jScrollPane5.setViewportView(TblCobrar);

        LblTotalCobrar.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        LblTotalCobrar.setForeground(new java.awt.Color(255, 255, 102));
        LblTotalCobrar.setText("Total: $00.00");

        LblTotalCobrar1.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        LblTotalCobrar1.setForeground(new java.awt.Color(255, 255, 102));
        LblTotalCobrar1.setText("Recibido: $");

        LblCambioCobrar.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        LblCambioCobrar.setForeground(new java.awt.Color(255, 255, 102));
        LblCambioCobrar.setText("Cambio: $");

        BtnCobrar.setBackground(new java.awt.Color(255, 255, 153));
        BtnCobrar.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        BtnCobrar.setForeground(new java.awt.Color(51, 0, 0));
        BtnCobrar.setText("Cobrar");

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5)
                    .addGroup(jPanel31Layout.createSequentialGroup()
                        .addComponent(LblTotalCobrar)
                        .addGap(18, 18, 18)
                        .addComponent(LblTotalCobrar1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtRecibidoCobrar, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(LblCambioCobrar)
                        .addGap(49, 49, 49)
                        .addComponent(BtnCobrar, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LblTotalCobrar)
                    .addComponent(LblTotalCobrar1)
                    .addComponent(LblCambioCobrar)
                    .addComponent(BtnCobrar)
                    .addComponent(txtRecibidoCobrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        BtnRegresarCobrar.setBackground(new java.awt.Color(255, 255, 153));
        BtnRegresarCobrar.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        BtnRegresarCobrar.setForeground(new java.awt.Color(51, 0, 0));
        BtnRegresarCobrar.setText("Regresar");

        jLabel91.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/bottomBanner.png"))); // NOI18N

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel24Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel24Layout.createSequentialGroup()
                        .addComponent(jLabel50)
                        .addGap(129, 129, 129))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel24Layout.createSequentialGroup()
                        .addComponent(jLabel91, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(37, 37, 37))))
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(BtnRegresarCobrar)
                    .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addComponent(jLabel50)
                .addGap(8, 8, 8)
                .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BtnRegresarCobrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel91, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RbtnNumeroOrdenCobrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RbtnNumeroOrdenCobrarActionPerformed
         // TODO add your handling code here:
    }//GEN-LAST:event_RbtnNumeroOrdenCobrarActionPerformed

    private void btnAceptarOrdenCobradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarOrdenCobradaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAceptarOrdenCobradaActionPerformed

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
            java.util.logging.Logger.getLogger(PantallaCobrarOrden.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaCobrarOrden.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaCobrarOrden.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaCobrarOrden.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PantallaCobrarOrden().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton BtnCobrar;
    public javax.swing.JButton BtnCobrarBuscarOrden;
    public javax.swing.JButton BtnRegresarCobrar;
    public javax.swing.JComboBox<String> CbxNumeroMesaOrden;
    public javax.swing.JDialog DialogMsjCobrarOrden;
    public javax.swing.JLabel LblCambioCobrar;
    public javax.swing.JLabel LblTotalCobrar;
    public javax.swing.JLabel LblTotalCobrar1;
    public javax.swing.JRadioButton RbtnNumeroMesaCobrar;
    public javax.swing.JRadioButton RbtnNumeroOrdenCobrar;
    public javax.swing.JTable TblCobrar;
    public javax.swing.JTextField TxtCobrarNumeroOrden;
    public javax.swing.JButton btnAceptarOrdenCobrada;
    private javax.swing.ButtonGroup buttonGroup1;
    public javax.swing.JTextArea hojaTicket;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane5;
    public javax.swing.JLabel lblMensajeCobrarOrden;
    public javax.swing.JTextField txtRecibidoCobrar;
    public javax.swing.JDialog vistaTicket;
    // End of variables declaration//GEN-END:variables
}
