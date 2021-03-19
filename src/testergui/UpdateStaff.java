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
import javax.swing.JOptionPane;

/**
 *
 * @author ayesh
 */
public class UpdateStaff extends javax.swing.JFrame {
    String query=null;
    Connection con=null;
    Statement st=null;
    ResultSet rs=null;
    int id=0;

    public UpdateStaff() {
        initComponents();
        fnameTxt.setEditable(false);
        lnameTxt.setEditable(false);
        nicTxt.setEditable(false);
        addressTxt.setEditable(false);
        phonenoTxt.setEditable(false);
        emailTxt.setEditable(false);
        passwordTxt.setEditable(false);
        dobTxt.setEditable(false);
        raidTxt.setEditable(false);
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
    public void getStaff(){
        try{
             st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
             query="SELECT * FROM staff where StID='" + id + "'";
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
                        dobTxt.setText(rs.getString("DOB"));
                        raidTxt.setText(rs.getString("RaID"+""));
                        StaffData data;
                        data= new StaffData(rs.getInt("StID"),rs.getString("FName"),rs.getString("LName"),rs.getInt("NIC"),rs.getString("DOB"),rs.getString("Address"),rs.getInt("phoneNO"),rs.getString("Password"),rs.getInt("BrID"),rs.getInt("RaID"),rs.getString("Email"));
                        
                    }
                }
                else 
                    JOptionPane.showMessageDialog(null,"invalid Staff ID!");
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
            query="Update Staff set FName=?,LName=?,NIC=?,Address=?,phoneNo=?,Email=?,Password=?,BrID=?,Raid=?,DOB=? where StID='"+id+"'";
            PreparedStatement pst= con.prepareStatement(query);
            pst.setString(1,fnameTxt.getText());
            pst.setString(2, lnameTxt.getText());
            pst.setInt(3,Integer.parseInt(nicTxt.getText()));
            pst.setString(4, addressTxt.getText());
            pst.setInt(5,Integer.parseInt(phonenoTxt.getText()));
            pst.setString(6,emailTxt.getText());
            pst.setString(7, passwordTxt.getText());
            System.out.println(passwordTxt.getText());
            pst.setInt(8,AdminData.brid);
            pst.setInt(9,Integer.parseInt(raidTxt.getText()));
            pst.setString(10,dobTxt.getText());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Sucessfrly Updated!");
            this.dispose();
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    public void delete(){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connectionURL="jdbc:sqlserver://localhost:1433;databaseName=BankingSystem;user=admin;password=admin";
            con=DriverManager.getConnection(connectionURL);
            query="delete from Staff where StID='"+id+"'";
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
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        staffidTxt = new javax.swing.JTextField();
        okBtn = new javax.swing.JButton();
        fnameRBtn = new javax.swing.JRadioButton();
        lnameRBtn = new javax.swing.JRadioButton();
        nicRBtn = new javax.swing.JRadioButton();
        addressRBtn = new javax.swing.JRadioButton();
        phonenoRBtn = new javax.swing.JRadioButton();
        emailRBtn = new javax.swing.JRadioButton();
        passwordRBtn = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        fnameTxt = new javax.swing.JTextField();
        lnameTxt = new javax.swing.JTextField();
        passwordTxt = new javax.swing.JTextField();
        emailTxt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        phonenoTxt = new javax.swing.JTextField();
        nicTxt = new javax.swing.JTextField();
        dobTxt = new javax.swing.JTextField();
        raidTxt = new javax.swing.JTextField();
        addressTxt = new javax.swing.JTextField();
        dobRBtn = new javax.swing.JRadioButton();
        rankidRBtn = new javax.swing.JRadioButton();
        updateBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Make Selection");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        jLabel10.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Staff ID: ");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 90, -1));

        staffidTxt.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jPanel1.add(staffidTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 97, -1));

        okBtn.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        okBtn.setText("Ok");
        okBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okBtnActionPerformed(evt);
            }
        });
        jPanel1.add(okBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 140, -1, -1));

        fnameRBtn.setText("First Name");
        fnameRBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fnameRBtnActionPerformed(evt);
            }
        });
        jPanel1.add(fnameRBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 91, -1));

        lnameRBtn.setText("Last Name");
        lnameRBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lnameRBtnActionPerformed(evt);
            }
        });
        jPanel1.add(lnameRBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 91, -1));

        nicRBtn.setText("CNIC");
        nicRBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nicRBtnActionPerformed(evt);
            }
        });
        jPanel1.add(nicRBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 91, -1));

        addressRBtn.setText("Address");
        addressRBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressRBtnActionPerformed(evt);
            }
        });
        jPanel1.add(addressRBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 90, -1));

        phonenoRBtn.setText("Phone No.");
        phonenoRBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phonenoRBtnActionPerformed(evt);
            }
        });
        jPanel1.add(phonenoRBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 90, -1));

        emailRBtn.setText("Email");
        emailRBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailRBtnActionPerformed(evt);
            }
        });
        jPanel1.add(emailRBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 90, -1));

        passwordRBtn.setText("Password");
        passwordRBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordRBtnActionPerformed(evt);
            }
        });
        jPanel1.add(passwordRBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 90, -1));

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText(" Staff");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 40, -1, -1));

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel3.setText("*First Name:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 120, 100, -1));

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel4.setText("*Last Name:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 150, 100, -1));

        jLabel8.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel8.setText("*Password:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 190, 100, -1));

        jLabel7.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel7.setText("Email:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 230, 90, -1));

        jLabel9.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel9.setText("Address:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 280, 90, -1));

        fnameTxt.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jPanel1.add(fnameTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 120, 139, -1));

        lnameTxt.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jPanel1.add(lnameTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 150, 139, -1));

        passwordTxt.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jPanel1.add(passwordTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 190, 139, -1));

        emailTxt.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jPanel1.add(emailTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 230, 139, -1));

        jLabel5.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel5.setText("Phone No:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 110, -1, -1));

        jLabel6.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel6.setText("CNIC:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 150, 75, -1));

        jLabel11.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel11.setText("DOB:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 190, 75, -1));

        jLabel12.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel12.setText("Rank ID:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 230, 80, -1));

        phonenoTxt.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jPanel1.add(phonenoTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 110, 139, -1));

        nicTxt.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jPanel1.add(nicTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 150, 139, -1));

        dobTxt.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jPanel1.add(dobTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 190, 139, -1));

        raidTxt.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jPanel1.add(raidTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 220, 139, -1));

        addressTxt.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jPanel1.add(addressTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 280, 430, -1));

        dobRBtn.setText("DOB");
        dobRBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dobRBtnActionPerformed(evt);
            }
        });
        jPanel1.add(dobRBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 90, -1));

        rankidRBtn.setText("Rank ID");
        rankidRBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rankidRBtnActionPerformed(evt);
            }
        });
        jPanel1.add(rankidRBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, 90, -1));

        updateBtn.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        updateBtn.setText("Update");
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });
        jPanel1.add(updateBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 340, -1, -1));

        deleteBtn.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        deleteBtn.setText("Delete");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });
        jPanel1.add(deleteBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 340, -1, -1));

        jLabel13.setIcon(new javax.swing.ImageIcon("E:\\4th samester\\DataBase\\Project data\\Interface\\Login\\TransectionBackground.jpg")); // NOI18N
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 30, 590, 360));

        jLabel14.setIcon(new javax.swing.ImageIcon("E:\\4th samester\\DataBase\\Project data\\Interface\\Admin\\addstaff2.jpg")); // NOI18N
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 910, 410));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 910, 420));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void okBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okBtnActionPerformed
        id=Integer.parseInt(staffidTxt.getText());
        this.getStaff();
        updateBtn.setEnabled(true);
        deleteBtn.setEnabled(true);
    }//GEN-LAST:event_okBtnActionPerformed

    private void fnameRBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fnameRBtnActionPerformed
        
        if(fnameRBtn.isSelected()){
            fnameTxt.setEditable(true);
        }
        else{
            fnameTxt.setEditable(false);
        }
    }//GEN-LAST:event_fnameRBtnActionPerformed

    private void lnameRBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lnameRBtnActionPerformed
        
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

    private void dobRBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dobRBtnActionPerformed
        if(dobRBtn.isSelected()){
            dobTxt.setEditable(true);
        }
        else{
            dobTxt.setEditable(false);
        }
    }//GEN-LAST:event_dobRBtnActionPerformed

    private void rankidRBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rankidRBtnActionPerformed
        if(rankidRBtn.isSelected()){
            raidTxt.setEditable(true);
        }
        else{
            raidTxt.setEditable(false);
        }
    }//GEN-LAST:event_rankidRBtnActionPerformed

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
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
        this.delete();
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
            java.util.logging.Logger.getLogger(UpdateStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UpdateStaff().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton addressRBtn;
    private javax.swing.JTextField addressTxt;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JRadioButton dobRBtn;
    private javax.swing.JTextField dobTxt;
    private javax.swing.JRadioButton emailRBtn;
    private javax.swing.JTextField emailTxt;
    private javax.swing.JRadioButton fnameRBtn;
    private javax.swing.JTextField fnameTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton lnameRBtn;
    private javax.swing.JTextField lnameTxt;
    private javax.swing.JRadioButton nicRBtn;
    private javax.swing.JTextField nicTxt;
    private javax.swing.JButton okBtn;
    private javax.swing.JRadioButton passwordRBtn;
    private javax.swing.JTextField passwordTxt;
    private javax.swing.JRadioButton phonenoRBtn;
    private javax.swing.JTextField phonenoTxt;
    private javax.swing.JTextField raidTxt;
    private javax.swing.JRadioButton rankidRBtn;
    private javax.swing.JTextField staffidTxt;
    private javax.swing.JButton updateBtn;
    // End of variables declaration//GEN-END:variables
}
