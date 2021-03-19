
package testergui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

public class ViewStaff extends javax.swing.JFrame {
    Connection con=null;
    Statement st=null;
    ResultSet rs=null;
    String query=null;

    public ViewStaff() {
        initComponents();
        this.showUser();
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
    public ArrayList<StaffData> details(){
        ArrayList<StaffData> datailsList = new ArrayList<StaffData>();
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connectionURL="jdbc:sqlserver://localhost:1433;databaseName=BankingSystem;user=admin;password=admin";
            con=DriverManager.getConnection(connectionURL);
            query= "Select * from StaffDetails";
            st=con.createStatement();
            rs= st.executeQuery(query);
            StaffData data;
            while(rs.next()){
                data= new StaffData(rs.getInt("StID"),rs.getString("FName"),rs.getString("LName"),rs.getInt("NIC"),rs.getString("DOB"),rs.getString("Address"),rs.getInt("phoneNO"),rs.getString("Password"),rs.getInt("BrID"),rs.getString("RName"));
                datailsList.add(data);
                
            }
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        return datailsList;
    }
    public void showUser(){
        ArrayList<StaffData> List = details();
        DefaultTableModel model = (DefaultTableModel)StaffTable.getModel();
        Object[] row = new Object[10];
        for(int i=0;i<List.size();i++){
            row[0]=List.get(i).stid;
            row[1]=List.get(i).fname;
            row[2]=List.get(i).lname;
            row[3]=List.get(i).nic;
            row[4]=List.get(i).dob;
            row[5]=List.get(i).address;
            row[6]=List.get(i).phoneno;
            //row[7]=List.get(i).email;
            row[7]=List.get(i).password;
            row[8]=List.get(i).brid;
            row[9]=List.get(i).rank;
            model.addRow(row);
            
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        StaffTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        AddNewStaffBtn = new javax.swing.JButton();
        AddNewStaffBtn1 = new javax.swing.JButton();
        AddNewStaffBtn2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        StaffTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Staff ID", "First Name", "Last Name", "NIC", "DOB", "Address", "PhoneNo", "Password", "Branch ID", "Rank ID"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(StaffTable);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 96, 790, 252));

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Staff ");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 30, 125, 37));

        AddNewStaffBtn.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        AddNewStaffBtn.setText("Add New Staff");
        AddNewStaffBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddNewStaffBtnActionPerformed(evt);
            }
        });
        jPanel1.add(AddNewStaffBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 370, -1, -1));

        AddNewStaffBtn1.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        AddNewStaffBtn1.setText("Add New Staff");
        AddNewStaffBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddNewStaffBtn1ActionPerformed(evt);
            }
        });
        jPanel1.add(AddNewStaffBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 370, -1, -1));

        AddNewStaffBtn2.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        AddNewStaffBtn2.setText("Add New Staff");
        AddNewStaffBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddNewStaffBtn2ActionPerformed(evt);
            }
        });
        jPanel1.add(AddNewStaffBtn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 370, -1, -1));

        jButton1.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jButton1.setText("Update Staff ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 370, 120, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon("E:\\4th samester\\DataBase\\Project data\\Interface\\Admin\\addstaff2.jpg")); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 880, 420));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 880, 420));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AddNewStaffBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddNewStaffBtnActionPerformed
        // TODO add your handling code here:
        new AddStaff();
    }//GEN-LAST:event_AddNewStaffBtnActionPerformed

    private void AddNewStaffBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddNewStaffBtn1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AddNewStaffBtn1ActionPerformed

    private void AddNewStaffBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddNewStaffBtn2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AddNewStaffBtn2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        new UpdateStaff().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(ViewStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewStaff().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddNewStaffBtn;
    private javax.swing.JButton AddNewStaffBtn1;
    private javax.swing.JButton AddNewStaffBtn2;
    private javax.swing.JTable StaffTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
