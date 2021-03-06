/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import MongoBD.BaseDatos;
import MongoBD.Usuario;


/** Ventana del menú principal del usuario
 *
 * @author José Miguel
 */
public class Menu extends javax.swing.JDialog {

    protected static Usuario usuario;
    
    /**
     * Creates new form FormMenu
     */
    public Menu(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        usuario = Logear.db.getUsuario(Logear.nickUsuario);
    }
    /* Lanzamos uno de los formularios para ver los mensajes
        recibiendo como parámetro que mensajes queremos ver (todos, de usuarios o por hashtag)*/
    private void verMensajes(String opcion) {
        
        
        VerMensajes verMensajes = new VerMensajes(new javax.swing.JFrame(), true, opcion);
        verMensajes.setVisible(true);}
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnVerMensajes = new javax.swing.JButton();
        btnVerMensajesUsuarios = new javax.swing.JButton();
        btnVerMensajesHashtag = new javax.swing.JButton();
        btnEscribirMensaje = new javax.swing.JButton();
        btnBuscarUsuarios = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Menú usuario");

        btnVerMensajes.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnVerMensajes.setText("Ver mensajes");
        btnVerMensajes.setActionCommand("btnVerMensaxes");
        btnVerMensajes.setName("btnVerMensajes"); // NOI18N
        btnVerMensajes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerMensajes_click(evt);
            }
        });

        btnVerMensajesUsuarios.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnVerMensajesUsuarios.setText("Ver mensajes usuarios seguidos");
        btnVerMensajesUsuarios.setActionCommand("btnVerMensaxesUsuario");
        btnVerMensajesUsuarios.setName("btnVerMensajesUsuarios"); // NOI18N
        btnVerMensajesUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerMensajesUsuarios_click(evt);
            }
        });

        btnVerMensajesHashtag.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnVerMensajesHashtag.setText("Buscar mensajes por hashtag");
        btnVerMensajesHashtag.setActionCommand("btnVerMensaxesHashtag");
        btnVerMensajesHashtag.setName("btnVerMensajesHashtag"); // NOI18N
        btnVerMensajesHashtag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerMensajesHashtag_click(evt);
            }
        });

        btnEscribirMensaje.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnEscribirMensaje.setText("Escribir mensaje");
        btnEscribirMensaje.setToolTipText("");
        btnEscribirMensaje.setActionCommand("btnEscribirMensaxe");
        btnEscribirMensaje.setName("btnEscribirMensaje"); // NOI18N
        btnEscribirMensaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEscribirMensaje_click(evt);
            }
        });

        btnBuscarUsuarios.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnBuscarUsuarios.setText("Buscar usuarios");
        btnBuscarUsuarios.setToolTipText("");
        btnBuscarUsuarios.setActionCommand("btnBuscarUsuarios");
        btnBuscarUsuarios.setName("btnBuscarUsuarios"); // NOI18N
        btnBuscarUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarUsuarios_click(evt);
            }
        });

        btnCerrar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnCerrar.setText("Cerrar");
        btnCerrar.setName("btnCerrar"); // NOI18N
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrar_click(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(128, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(140, 140, 140))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnBuscarUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEscribirMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnVerMensajesHashtag, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnVerMensajesUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnVerMensajes, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(254, 254, 254)
                        .addComponent(btnCerrar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1)
                .addGap(40, 40, 40)
                .addComponent(btnVerMensajes, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnVerMensajesUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnVerMensajesHashtag, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(btnEscribirMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(btnBuscarUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(btnCerrar)
                .addGap(26, 26, 26))
        );

        btnEscribirMensaje.getAccessibleContext().setAccessibleName("Escribir Mensaxe");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVerMensajes_click(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerMensajes_click
        
        // Abrimos la opción para ver todos los mensajes
        verMensajes("Todos");
        

    }//GEN-LAST:event_btnVerMensajes_click

    private void btnVerMensajesUsuarios_click(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerMensajesUsuarios_click
        // Actualizamos los datos del usuario, por si se empezó a seguir a alguien nuevo
        usuario = Logear.db.getUsuario(Logear.nickUsuario);
        
        // Abrimos la opción para ver los mensajes de los usuarios a los que se sigue
        verMensajes("Seguidos");
    }//GEN-LAST:event_btnVerMensajesUsuarios_click

    private void btnVerMensajesHashtag_click(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerMensajesHashtag_click
        // Abrimos la opción para ver mensajes por hashtag
        verMensajes("Hasgtag");
    }//GEN-LAST:event_btnVerMensajesHashtag_click

    private void btnEscribirMensaje_click(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEscribirMensaje_click
                        
        // Abrimos el formulario para escribir mensajes
        EscribirMensaje escribirMensaje = new EscribirMensaje(new javax.swing.JFrame(), true);
        escribirMensaje.setVisible(true);
    }//GEN-LAST:event_btnEscribirMensaje_click

    private void btnBuscarUsuarios_click(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarUsuarios_click
        
// Amosamos o formulario para buscar usuarios
        BuscarUsuarios buscarUsuarios = new BuscarUsuarios(new javax.swing.JFrame(), true);
        buscarUsuarios.setVisible(true);
    }//GEN-LAST:event_btnBuscarUsuarios_click

    private void btnCerrar_click(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrar_click
        this.dispose();
    }//GEN-LAST:event_btnCerrar_click

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Menu dialog = new Menu(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarUsuarios;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnEscribirMensaje;
    private javax.swing.JButton btnVerMensajes;
    private javax.swing.JButton btnVerMensajesHashtag;
    private javax.swing.JButton btnVerMensajesUsuarios;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
