/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ar.edu.unlar.paradigmas.patterndao.ui;

import ar.edu.unlar.paradigmas.patterndao.objects.Venta;
import ar.edu.unlar.paradigmas.patterndao.ui.grillas.GrillaVenta;
import java.util.ArrayList;

/**
 *
 * @author sebas
 */
public class PreAbmVenta extends javax.swing.JFrame {
    ArrayList<Venta> data;
    /**
     * Creates new form PreAbmVenta
     */
    public PreAbmVenta() {
        initComponents();
        data=(ArrayList<Venta>) ventaController.getAllObjects();
        grillaVenta = new GrillaVenta(data);
        grillaVenta.fireTableDataChanged();
        jtGrilla.setModel(grillaVenta);
                
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grillaVenta = new ar.edu.unlar.paradigmas.patterndao.ui.grillas.GrillaVenta();
        try {
            ventaController = new ar.edu.unlar.paradigmas.patterndao.controllers.VentaController();
        } catch (java.sql.SQLException e1) {
            e1.printStackTrace();
        } catch (java.lang.ClassNotFoundException e2) {
            e2.printStackTrace();
        }
        jScrollPane1 = new javax.swing.JScrollPane();
        jtGrilla = new javax.swing.JTable();
        jbNuevo = new javax.swing.JButton();
        jbModificar = new javax.swing.JButton();
        jbVer = new javax.swing.JButton();
        jbEliminar = new javax.swing.JButton();
        jbCerrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jtGrilla.setModel(grillaVenta);
        jScrollPane1.setViewportView(jtGrilla);

        jbNuevo.setText("Nuevo");
        jbNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNuevoActionPerformed(evt);
            }
        });

        jbModificar.setText("Modificar");
        jbModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbModificarActionPerformed(evt);
            }
        });

        jbVer.setText("Ver");
        jbVer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbVerActionPerformed(evt);
            }
        });

        jbEliminar.setText("Eliminar");
        jbEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEliminarActionPerformed(evt);
            }
        });

        jbCerrar.setText("Cerrar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 774, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jbNuevo)
                .addGap(18, 18, 18)
                .addComponent(jbModificar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbVer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbEliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbCerrar)
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbNuevo)
                    .addComponent(jbModificar)
                    .addComponent(jbVer)
                    .addComponent(jbEliminar)
                    .addComponent(jbCerrar))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNuevoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbNuevoActionPerformed

    private void jbModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbModificarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbModificarActionPerformed

    private void jbVerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbVerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbVerActionPerformed

    private void jbEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbEliminarActionPerformed

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
            java.util.logging.Logger.getLogger(PreAbmVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PreAbmVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PreAbmVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PreAbmVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PreAbmVenta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private ar.edu.unlar.paradigmas.patterndao.ui.grillas.GrillaVenta grillaVenta;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbCerrar;
    private javax.swing.JButton jbEliminar;
    private javax.swing.JButton jbModificar;
    private javax.swing.JButton jbNuevo;
    private javax.swing.JButton jbVer;
    private javax.swing.JTable jtGrilla;
    private ar.edu.unlar.paradigmas.patterndao.controllers.VentaController ventaController;
    // End of variables declaration//GEN-END:variables
}