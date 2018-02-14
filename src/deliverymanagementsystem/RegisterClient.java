/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deliverymanagementsystem;
import java.util.*;
import java.sql.*;
import javax.swing.*;

/**
 *
 * @author Mwendwa Mugambi
 */
public class RegisterClient extends javax.swing.JFrame {

    /**
     * Creates new form RegisterClient
     */
    public RegisterClient() {
        initComponents();
        jdbc.sqlite();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PckgbuttonGroup = new javax.swing.ButtonGroup();
        RegisterClientFrame = new javax.swing.JInternalFrame();
        MemNameLabel = new javax.swing.JLabel();
        MemNumLabel = new javax.swing.JLabel();
        MemEmailLabel = new javax.swing.JLabel();
        MemAddrLabel = new javax.swing.JLabel();
        PckSelectLabel = new javax.swing.JLabel();
        SaveButton = new javax.swing.JButton();
        CancelButton = new javax.swing.JButton();
        MemNameField = new javax.swing.JTextField();
        MemNumField = new javax.swing.JTextField();
        MemEmailField = new javax.swing.JTextField();
        MemAddrField = new javax.swing.JTextField();
        MemIdLabel = new javax.swing.JLabel();
        MemIcLabel = new javax.swing.JLabel();
        MemIcField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        Cityfield = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        StateField = new javax.swing.JTextField();
        MemPckcombobox = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        RegisterClientFrame.setTitle("Member Registration");
        RegisterClientFrame.setVisible(true);

        MemNameLabel.setText("Name: ");

        MemNumLabel.setText("Contact Number:");

        MemEmailLabel.setText("E-mail: ");

        MemAddrLabel.setText("Delivery Address:");

        PckSelectLabel.setText("Member Package:");

        SaveButton.setForeground(new java.awt.Color(0, 102, 0));
        SaveButton.setText("Save");
        SaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveButtonActionPerformed(evt);
            }
        });

        CancelButton.setForeground(java.awt.Color.red);
        CancelButton.setText("Cancel");
        CancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelButtonActionPerformed(evt);
            }
        });

        MemNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MemNameFieldActionPerformed(evt);
            }
        });

        MemIcLabel.setText("IC/ Passport No.");

        jLabel1.setText("City: ");

        jLabel2.setText("State:");

        StateField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StateFieldActionPerformed(evt);
            }
        });

        MemPckcombobox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Basic", "Premium", "Gold" }));

        jLabel3.setText("MemberID:");

        javax.swing.GroupLayout RegisterClientFrameLayout = new javax.swing.GroupLayout(RegisterClientFrame.getContentPane());
        RegisterClientFrame.getContentPane().setLayout(RegisterClientFrameLayout);
        RegisterClientFrameLayout.setHorizontalGroup(
            RegisterClientFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RegisterClientFrameLayout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(RegisterClientFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(PckSelectLabel)
                    .addGroup(RegisterClientFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(RegisterClientFrameLayout.createSequentialGroup()
                            .addGroup(RegisterClientFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(RegisterClientFrameLayout.createSequentialGroup()
                                    .addComponent(MemNameLabel)
                                    .addGap(106, 106, 106))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, RegisterClientFrameLayout.createSequentialGroup()
                                    .addGroup(RegisterClientFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(MemNumLabel, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(RegisterClientFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(MemNameField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(MemNumField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(MemIdLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(RegisterClientFrameLayout.createSequentialGroup()
                            .addGroup(RegisterClientFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(MemEmailLabel)
                                .addComponent(MemIcLabel)
                                .addComponent(MemAddrLabel)
                                .addComponent(jLabel2))
                            .addGap(55, 55, 55)
                            .addGroup(RegisterClientFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(MemEmailField, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(MemIcField, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(MemAddrField, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Cityfield, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(StateField, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(MemPckcombobox, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(0, 0, Short.MAX_VALUE))))
                .addContainerGap(81, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RegisterClientFrameLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(SaveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(CancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );
        RegisterClientFrameLayout.setVerticalGroup(
            RegisterClientFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RegisterClientFrameLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(RegisterClientFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(MemIdLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(RegisterClientFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MemNameLabel)
                    .addComponent(MemNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(RegisterClientFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MemNumField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MemNumLabel))
                .addGap(18, 18, 18)
                .addGroup(RegisterClientFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(MemIcField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MemIcLabel))
                .addGap(18, 18, 18)
                .addGroup(RegisterClientFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MemEmailLabel)
                    .addComponent(MemEmailField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(RegisterClientFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MemAddrLabel)
                    .addComponent(MemAddrField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(RegisterClientFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(Cityfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(RegisterClientFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(StateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(RegisterClientFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PckSelectLabel)
                    .addComponent(MemPckcombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(RegisterClientFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SaveButton)
                    .addComponent(CancelButton))
                .addGap(31, 31, 31))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(RegisterClientFrame)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(RegisterClientFrame)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void StateFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StateFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_StateFieldActionPerformed

    private void MemNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MemNameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MemNameFieldActionPerformed

    private void CancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelButtonActionPerformed
        // TODO add your handling code here:
        new DeliverySystem().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_CancelButtonActionPerformed

    private void SaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveButtonActionPerformed
        // TODO add your handling code here:
        Customer c = new Customer();
        c.setMemIdLabel(MemIdLabel.getText());
        c.setMemNameField(MemNameField.getText());
        c.setMemNumField(MemNumField.getText());
        c.setMemIcField(MemIcField.getText());
        c.setMemAddrField(MemAddrField.getText());
        c.setMemEmailField(MemEmailField.getText());
        c.setCityfield(Cityfield.getText());
        c.setStateField(StateField.getText());
        c.setMemPckcombobox(MemPckcombobox.getSelectedItem().toString());
        
        c.registerClient();
    }//GEN-LAST:event_SaveButtonActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        
        UniqueCustomerNumber uin = new UniqueCustomerNumber();
        uin.setCustNum();
        MemIdLabel.setText(uin.getCustNum());
    }//GEN-LAST:event_formWindowOpened

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
            java.util.logging.Logger.getLogger(RegisterClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegisterClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegisterClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegisterClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegisterClient().setVisible(true);
            }
        }); 
    
    }
    
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CancelButton;
    private javax.swing.JTextField Cityfield;
    private javax.swing.JTextField MemAddrField;
    private javax.swing.JLabel MemAddrLabel;
    private javax.swing.JTextField MemEmailField;
    private javax.swing.JLabel MemEmailLabel;
    private javax.swing.JTextField MemIcField;
    private javax.swing.JLabel MemIcLabel;
    private javax.swing.JLabel MemIdLabel;
    private javax.swing.JTextField MemNameField;
    private javax.swing.JLabel MemNameLabel;
    private javax.swing.JTextField MemNumField;
    private javax.swing.JLabel MemNumLabel;
    private javax.swing.JComboBox MemPckcombobox;
    private javax.swing.JLabel PckSelectLabel;
    private javax.swing.ButtonGroup PckgbuttonGroup;
    private javax.swing.JInternalFrame RegisterClientFrame;
    private javax.swing.JButton SaveButton;
    private javax.swing.JTextField StateField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}

