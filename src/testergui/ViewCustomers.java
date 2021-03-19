
package testergui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

public class ViewCustomers extends javax.swing.JFrame {
    Connection con=null;
    Statement st=null;
    ResultSet rs=null;
    String query=null;

    public ViewCustomers() {
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
    public ArrayList<CustomerViewData> details(){
        ArrayList<CustomerViewData> datailsList = new ArrayList<CustomerViewData>();
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connectionURL="jdbc:sqlserver://localhost:1433;databaseName=BankingSystem;user=admin;password=admin";
            con=DriverManager.getConnection(connectionURL);
            query= "Select * from Customer";
            st=con.createStatement();
            rs= st.executeQuery(query);
            CustomerViewData data;
            while(rs.next()){
                data= new CustomerViewData(rs.getInt("CuID"),rs.getString("FName"),rs.getString("LName"),rs.getInt("NIC"),rs.getString("Address"),rs.getInt("phoneNO"),rs.getString("Email"),rs.getString("Password"),rs.getInt("BrID"));
                //data=new TransectionData(rs.getInt("AccIdFrom"),rs.getInt("AccIDTo"),rs.getInt("Amount"),rs.getString("TrDate"),rs.getString("TrType"));
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
        ArrayList<CustomerViewData> List = details();
        DefaultTableModel model = (DefaultTableModel)CustromerTable.getModel();
        Object[] row = new Object[9];
        for(int i=0;i<List.size();i++){
            row[0]=List.get(i).cuid;
            row[1]=List.get(i).fname;
            row[2]=List.get(i).lName;
            row[3]=List.get(i).NIC;
            row[4]=List.get(i).address;
            row[5]=List.get(i).phoneno;
            row[6]=List.get(i).Email;
            row[7]=List.get(i).pasword;
            row[8]=List.get(i).brid;
            model.addRow(row);
            
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        CustromerTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        AddNewCustomerBtn = new javax.swing.JButton();
        updateCustomerBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        CustromerTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "First Name", "Last Name", "NIC", "Address", "Phone No", "Email", "Password", "Branch"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(CustromerTable);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 793, 263));

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Customers");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(343, 39, 171, -1));

        AddNewCustomerBtn.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        AddNewCustomerBtn.setText("Add New Customer");
        AddNewCustomerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddNewCustomerBtnActionPerformed(evt);
            }
        });
        getContentPane().add(AddNewCustomerBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 400, -1, -1));

        updateCustomerBtn.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        updateCustomerBtn.setText("Update Customer");
        updateCustomerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateCustomerBtnActionPerformed(evt);
            }
        });
        getContentPane().add(updateCustomerBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 400, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon("E:\\4th samester\\DataBase\\Project data\\Interface\\Admin\\addstaff2.jpg")); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 880, 450));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AddNewCustomerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddNewCustomerBtnActionPerformed
        // TODO add your handling code here:
        new AddCustomer().setVisible(true);
    }//GEN-LAST:event_AddNewCustomerBtnActionPerformed

    private void updateCustomerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateCustomerBtnActionPerformed
        new UpdateCustomer().setVisible(true);
    }//GEN-LAST:event_updateCustomerBtnActionPerformed

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
            java.util.logging.Logger.getLogger(ViewCustomers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewCustomers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewCustomers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewCustomers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewCustomers().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddNewCustomerBtn;
    private javax.swing.JTable CustromerTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton updateCustomerBtn;
    // End of variables declaration//GEN-END:variables
}
