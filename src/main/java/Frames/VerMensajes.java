/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import MongoBD.BaseDatos;
import MongoBD.Mensaje;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/** Ventana para ver mensajes
 *
 * @author José Miguel
 */
public class VerMensajes extends javax.swing.JDialog {

    private String opcionVistaMensajes;
    private int saltarMensajes;
    
    private DefaultTableModel dtmTabMensajes = new DefaultTableModel();
    
    /**
     * Creates new form FormVerMensajes
     */
    public VerMensajes(java.awt.Frame parent, boolean modal, String opcion) {
        super(parent, modal);
        initComponents();        
        this.opcionVistaMensajes = opcion;
        setModeloTabla();
        saltarMensajes = 0;
        
        // Modificamos el texto de las etiquetas dependiendo de la opción a listar.
        switch (opcionVistaMensajes) {
            case "Todos":
                lblTitulo.setText("Todos tus mensajes");
                deshabilitarObjectos();
                buscarMensajes();                
                break;
            case "Seguidos":
                lblTitulo.setText("Mensajes de los usuarios a los que sigues");
                deshabilitarObjectos();
                buscarMensajes();           
                break;
            case "Hashtag":
                lblTitulo.setText("Mensajes con el hashtag");
                lblInfo.setText("Hashtag: ");
                btnAnterior.setEnabled(false);
                btnPosterior.setEnabled(false);
        }
        
    }
    
    // Diseñamos el modelo de tabla que recogerá y de la que se extraerá los mensajes
    private void setModeloTabla() {
        String[] cabecera = {"Nombre","Usuario","Mensaje","Data"};
        dtmTabMensajes.setColumnIdentifiers(cabecera);
        tabMensaxes.setModel(dtmTabMensajes);       
        
    }
    
    private void deshabilitarObjectos() {
        lblInfo.setText("");
        lblInfo.setEnabled(false);
        txtBuscar.setEnabled(false);
        btnBuscar.setEnabled(false);
        btnAnterior.setEnabled(false);
        btnPosterior.setEnabled(false);
    }
    
    
    private void buscarMensajes() {
        
        ArrayList<Mensaje> mensajes = new ArrayList<>();
        
        switch (opcionVistaMensajes) {
            case "Todos": 
                mensajes = Logear.db.getMensajes(saltarMensajes, 5);
                break;
            case "Seguidos":
                mensajes = Logear.db.getMensajesUsuarios(saltarMensajes, 5, Menu.usuario.getSigue());
                break;
            case "Hashtag":
                mensajes = Logear.db.getMensajesHashtag(saltarMensajes, 5, txtBuscar.getText());
    }
        
        Object[] fila = new Object[4];
        dtmTabMensajes.setRowCount(0);
        int ultimaFila = Math.min(5,mensajes.size());
        for (int i=0; i<ultimaFila; i++) {
            fila[0] = mensajes.get(i).getNombreUsuario();
            fila[1] = mensajes.get(i).getUserUsuario();
            fila[2] = mensajes.get(i).getTexto();
            fila[3] = mensajes.get(i).getData();
            dtmTabMensajes.addRow(fila);
        }
        
        tabMensaxes.setModel(dtmTabMensajes);
        
        // Se hacen comprobaciones para ver si se habilita el botón de ir atrás
        if (saltarMensajes == 0) {            
            // Si estamos en el primero, no se puede ir atrás
            btnAnterior.setEnabled(false);
            
        } else {
            // Aquí si se puede ir atrás
            btnAnterior.setEnabled(true);
        }
        
        // Vamos a comprobar si habilitamos el botón ir adelante
        if (mensajes.size() <= 5) {
            // Si es el último mensaje se deshabilita
            btnPosterior.setEnabled(false);
        } else {
            // Aquí si se permite ir a mensajes posteriores
            btnPosterior.setEnabled(true);
        }
        
        mensajes = null;
                
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
        tabMensaxes = new javax.swing.JTable();
        btnAnterior = new javax.swing.JButton();
        btnPosterior = new javax.swing.JButton();
        lblTitulo = new javax.swing.JLabel();
        lblInfo = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tabMensaxes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tabMensaxes.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tabMensaxes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tabMensaxes);

        btnAnterior.setText("<<");
        btnAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnteriorActionPerformed(evt);
            }
        });

        btnPosterior.setText(">>");
        btnPosterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPosteriorActionPerformed(evt);
            }
        });

        lblTitulo.setBackground(new java.awt.Color(255, 255, 255));
        lblTitulo.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(204, 0, 0));
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText(" Ver mensajes");

        lblInfo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblInfo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblInfo.setText("Mensaje:");

        txtBuscar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtBuscar.setToolTipText("");

        btnBuscar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 922, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnAnterior))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPosterior))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblInfo)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAnterior)
                    .addComponent(btnPosterior))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPosteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPosteriorActionPerformed
        // Para ir a mensajes posteriores, añadimos 5 al número de mensajes a saltar
        saltarMensajes += 5;
        buscarMensajes();
    }//GEN-LAST:event_btnPosteriorActionPerformed

    private void btnAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnteriorActionPerformed
        // Para ir a mensajes anteriores, restamos 5 al número de mensajes a saltar
        saltarMensajes -= 5;
        buscarMensajes();
    }//GEN-LAST:event_btnAnteriorActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        saltarMensajes=0;
        buscarMensajes();
    }//GEN-LAST:event_btnBuscarActionPerformed

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
            java.util.logging.Logger.getLogger(VerMensajes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VerMensajes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VerMensajes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VerMensajes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                VerMensajes dialog = new VerMensajes(new javax.swing.JFrame(), true, args[0]);
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
    private javax.swing.JButton btnAnterior;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnPosterior;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblInfo;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTable tabMensaxes;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}