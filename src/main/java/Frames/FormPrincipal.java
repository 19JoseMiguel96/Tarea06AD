/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;


/** Ventana principal de la app
 *
 * @author José Miguel
 */
public class FormPrincipal extends javax.swing.JFrame {

    
    // Título para los JOptionPane
    public static final String ATENCION = "¡ATENCIÓN!";
    
    /**
     * Creates new form Main
     */
    public FormPrincipal() {
        initComponents();        
    }
    
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
            java.util.logging.Logger.getLogger(FormPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormPrincipal().setVisible(true);
            }
        });
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnLog = new javax.swing.JButton();
        btnRegistro = new javax.swing.JButton();
        btnFin = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setSize(new java.awt.Dimension(400, 350));

        btnLog.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnLog.setText("Iniciar sesión");
        btnLog.setActionCommand("btnLog");
        btnLog.setName("btnLog"); // NOI18N
        btnLog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLog_click(evt);
            }
        });

        btnRegistro.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnRegistro.setText("Registro");
        btnRegistro.setActionCommand("btnRexistro");
        btnRegistro.setName("btnRegistro"); // NOI18N
        btnRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistro_click(evt);
            }
        });

        btnFin.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnFin.setText("Salir");
        btnFin.setActionCommand("btnFin");
        btnFin.setName("btnFin"); // NOI18N
        btnFin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFin(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 0, 0));
        jLabel1.setText("Inicio MongoBD");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLog, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jLabel1))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(169, 169, 169)
                        .addComponent(btnFin)))
                .addContainerGap(139, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addComponent(btnRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLog, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(btnFin)
                .addGap(37, 37, 37))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistro_click(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistro_click
        // Se crea y lanza el formulario de registro
        Registro registro = new Registro(this, true);
        registro.setVisible(true);
        
    }//GEN-LAST:event_btnRegistro_click

    private void btnLog_click(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLog_click
        // Se crea y lanza el formulario de logeo
        Logear logueo = new Logear(this, true);
        logueo.setVisible(true);
    }//GEN-LAST:event_btnLog_click

    private void btnFin(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFin
        // Remtar aplicación
        System.exit(0);
    }//GEN-LAST:event_btnFin
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFin;
    private javax.swing.JButton btnLog;
    private javax.swing.JButton btnRegistro;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}