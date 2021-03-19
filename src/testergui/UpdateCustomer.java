/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testergui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author ayesh
 */
public class UpdateCustomer extends javax.swing.JFrame {
    String query=null;
    Connection con=null;
    Statement st=null;
    ResultSet rs=null;
    int id=0;
    public UpdateCustomer() {
        initComponents();
        fnameTxt.setEditable(false);
        lnameTxt.setEditable(false);
        nicTxt.setEditable(false);
        addressTxt.setEditable(false);
        phonenoTxt.setEditable(false);
        emailTxt.setEditable(false);
        passwordTxt.setEditable(false);
        updateBtn.setEnabled(false);
        deleteBtn.setEnabled(false);
        try{Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String connectionURL="jdbc:sqlserver://localhost:1433;databaseName=BankingSystem;user=admin;password=admin";
            con=DriverManager.getConnection(connectionURL);
            this.setVisible(true);
            this.setLocationRelativeTo(null);
            //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    public void getCustomer(){
        try{
             st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
             query="SELECT * FROM customer where CuID='" + id + "'";
             rs = st.executeQuery(query);
                boolean empty = true;
                if (rs.next()){
                    empty = false;
                    if(id==0){
                        JOptionPane.showMessageDialog(null,"Enter id!");
                    }
                    else{
                        fnameTxt.setText(rs.getString("FName"));
                        lnameTxt.setText(rs.getString("LName"));
                        nicTxt.setText(rs.getInt("NIC")+"");
                        addressTxt.setText(rs.getString("Address"));
                        phonenoTxt.setText(rs.getInt("phoneNO")+"");
                        emailTxt.setText(rs.getString("Email"));
                        passwordTxt.setText(rs.getString("Password"));
                        CustomerViewData data;
                        data= new CustomerViewData(rs.getInt("CuID"),rs.getString("FName"),rs.getString("LName"),rs.getInt("NIC"),rs.getString("Address"),rs.getInt("phoneNO"),rs.getString("Email"),rs.getString("Password"),rs.getInt("BrID"));
                    }
                }
                else 
                    JOptionPane.showMessageDialog(null,"invalid Customer ID!");
        }
        catch(Exception e)
        {
            System.out.println("error with connection "+e);
        }
    }
    public void update(){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connectionURL="jdbc:sqlserver://localhost:1433;databaseName=BankingSystem;user=admin;password=admin";
            con=DriverManager.getConnection(connectionURL);
            query="Update Customer set FName=?,LName=?,NIC=?,Address=?,phoneNo=?,Email=?,Password=?,BrID=? where CuID='"+id+"'";
            PreparedStatement pst= con.prepareStatement(query);
            pst.setString(1,fnameTxt.getText());
            pst.setString(2, lnameTxt.getText());
            pst.setInt(3,Integer.parseInt(nicTxt.getText()));
            pst.setString(4, addressTxt.getText());
            pst.setInt(5,Integer.parseInt(phonenoTxt.getText()));
            pst.setString(6,emailTxt.getText());
            pst.setString(7, passwordTxt.getText());
            pst.setInt(8,AdminData.brid);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Sucessfrly Updated!");
            this.dispose();
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    public void deleteRecord(){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connectionURL="jdbc:sqlserver://localhost:1433;databaseName=BankingSystem;user=admin;password=admin";
            con=DriverManager.getConnection(connectionURL);
            query="delete from Customer where Cuid='"+id+"'";
            PreparedStatement pst= con.prepareStatement(query);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Sucessfrly Deleted!");
            this.dispose();
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        fnameRBtn = new javax.swing.JRadioButton();
        lnameRBtn = new javax.swing.JRadioButton();
        nicRBtn = new javax.swing.JRadioButton();
        addressRBtn = new javax.swing.JRadioButton();
        phonenoRBtn = new javax.swing.JRadioButton();
        emailRBtn = new javax.swing.JRadioButton();
        passwordRBtn = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        fnameTxt = new javax.swing.JTextField();
        lnameTxt = new javax.swing.JTextField();
        passwordTxt = new javax.swing.JTextField();
        nicTxt = new javax.swing.JTextField();
        phonenoTxt = new javax.swing.JTextField();
        emailTxt = new javax.swing.JTextField();
        addressTxt = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        updateBtn = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        customeridTxt = new javax.swing.JTextField();
        okBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        fnameRBtn.setText("First Name");
        fnameRBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fnameRBtnActionPerformed(evt);
            }
        });
        jPanel3.add(fnameRBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 91, -1));

        lnameRBtn.setText("Last Name");
        lnameRBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lnameRBtnActionPerformed(evt);
            }
        });
        jPanel3.add(lnameRBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 91, -1));

        nicRBtn.setText("CNIC");
        nicRBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nicRBtnActionPerformed(evt);
            }
        });
        jPanel3.add(nicRBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 91, -1));

        addressRBtn.setText("Address");
        addressRBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressRBtnActionPerformed(evt);
            }
        });
        jPanel3.add(addressRBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 90, -1));

        phonenoRBtn.setText("Phone No.");
        phonenoRBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phonenoRBtnActionPerformed(evt);
            }
        });
        jPanel3.add(phonenoRBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 90, -1));

        emailRBtn.setText("Email");
        emailRBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailRBtnActionPerformed(evt);
            }
        });
        jPanel3.add(emailRBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 90, -1));

        passwordRBtn.setText("Password");
        passwordRBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordRBtnActionPerformed(evt);
            }
        });
        jPanel3.add(passwordRBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, 90, -1));

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Make Selection");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, -1, -1));

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel2.setText("Email: ");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(598, 256, 89, -1));

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel3.setText("Address:");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(283, 303, 89, -1));

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel4.setText("First Name");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(283, 162, 89, -1));

        jLabel5.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel5.setText("Phone No.:");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(598, 209, 89, -1));

        jLabel6.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel6.setText("Last Name:");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(283, 209, 89, -1));

        jLabel7.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel7.setText("CNIC");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(598, 162, 89, -1));

        jLabel8.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel8.setText("Password:");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(283, 256, 89, -1));

        fnameTxt.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jPanel3.add(fnameTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(402, 159, 157, -1));

        lnameTxt.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jPanel3.add(lnameTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(402, 206, 157, -1));

        passwordTxt.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jPanel3.add(passwordTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(402, 253, 157, -1));

        nicTxt.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jPanel3.add(nicTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(705, 159, 134, -1));

        phonenoTxt.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jPanel3.add(phonenoTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(705, 206, 134, -1));

        emailTxt.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jPanel3.add(emailTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(705, 253, 134, -1));

        addressTxt.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jPanel3.add(addressTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(402, 300, 440, -1));

        jLabel9.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        jLabel9.setText("Customer Data");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 70, -1, -1));

        updateBtn.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        updateBtn.setText("Update");
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });
        jPanel3.add(updateBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 380, -1, -1));

        jLabel10.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Customer ID: ");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));

        customeridTxt.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jPanel3.add(customeridTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 97, -1));

        okBtn.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        okBtn.setText("Ok");
        okBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okBtnActionPerformed(evt);
            }
        });
        jPanel3.add(okBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 170, -1, -1));

        deleteBtn.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        deleteBtn.setText("Delete");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });
        jPanel3.add(deleteBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 380, -1, -1));

        jLabel11.setIcon(new javax.swing.ImageIcon("E:\\4th samester\\DataBase\\Project data\\Interface\\Login\\TransectionBackground.jpg")); // NOI18N
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 30, 600, 400));

        jLabel12.setIcon(new javax.swing.ImageIcon("E:\\4th samester\\DataBase\\Project data\\Interface\\Admin\\addstaff2.jpg")); // NOI18N
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 890, 460));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fnameRBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fnameRBtnActionPerformed
        // TODO add your handling code here:
        if(fnameRBtn.isSelected()){
            fnameTxt.setEditable(true);
        }
        else{
            fnameTxt.setEditable(false);
        }
    }//GEN-LAST:event_fnameRBtnActionPerformed

    private void lnameRBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lnameRBtnActionPerformed
        // TODO add your handling code here:
        if(lnameRBtn.isSelected()){
            lnameTxt.setEditable(true);
        }
        else{
            lnameTxt.setEditable(false);
        }
    }//GEN-LAST:event_lnameRBtnActionPerformed

    private void nicRBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nicRBtnActionPerformed
        if(nicRBtn.isSelected()){
           nicTxt.setEditable(true);
        }
        else{
            nicTxt.setEditable(false);
        }
    }//GEN-LAST:event_nicRBtnActionPerformed

    private void addressRBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addressRBtnActionPerformed
        if(addressRBtn.isSelected()){
            addressTxt.setEditable(true);
        }
        else{
            addressTxt.setEditable(false);
        }
    }//GEN-LAST:event_addressRBtnActionPerformed

    private void phonenoRBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phonenoRBtnActionPerformed
        if(phonenoRBtn.isSelected()){
            phonenoTxt.setEditable(true);
        }
        else{
            phonenoTxt.setEditable(false);
        }
    }//GEN-LAST:event_phonenoRBtnActionPerformed

    private void emailRBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailRBtnActionPerformed
        if(emailRBtn.isSelected()){
            emailTxt.setEditable(true);
        }
        else{
            emailTxt.setEditable(false);
        }
    }//GEN-LAST:event_emailRBtnActionPerformed

    private void passwordRBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordRBtnActionPerformed
        if(passwordRBtn.isSelected()){
           passwordTxt.setEditable(true);
        }
        else{
            passwordTxt.setEditable(false);
        }
    }//GEN-LAST:event_passwordRBtnActionPerformed

    private void okBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okBtnActionPerformed
        id=Integer.parseInt(customeridTxt.getText());
        this.getCustomer();
        updateBtn.setEnabled(true);
        deleteBtn.setEnabled(true);
    }//GEN-LAST:event_okBtnActionPerformed

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        // TODO add your handling code here:
        if(fnameTxt.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Enter First Name!");
        }
        else if(lnameTxt.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Enter Last Name!");
        }
        else if(passwordTxt.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Enter Password!");
        }
        else if(nicTxt.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Enter CNIC!");
        }
        else{
            this.update();
        }
    }//GEN-LAST:event_updateBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        // TODO add your handling code here:
        this.deleteRecord();
    }//GEN-LAST:event_deleteBtnActionPerformed

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
            java.util.logging.Logger.getLogger(UpdateCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UpdateCustomer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton addressRBtn;
    private javax.swing.JTextField addressTxt;
    private javax.swing.JTextField customeridTxt;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JRadioButton emailRBtn;
    private javax.swing.JTextField emailTxt;
    private javax.swing.JRadioButton fnameRBtn;
    private javax.swing.JTextField fnameTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton lnameRBtn;
    private javax.swing.JTextField lnameTxt;
    private javax.swing.JRadioButton nicRBtn;
    private javax.swing.JTextField nicTxt;
    private javax.swing.JButton okBtn;
    private javax.swing.JRadioButton passwordRBtn;
    private javax.swing.JTextField passwordTxt;
    private javax.swing.JRadioButton phonenoRBtn;
    private javax.swing.JTextField phonenoTxt;
    private javax.swing.JButton updateBtn;
    // End of variables declaration//GEN-END:variables
}
