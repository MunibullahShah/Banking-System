
package testergui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class DonationPage extends javax.swing.JFrame {
    Connection con=null;
    Statement st=null;
    ResultSet rs=null;
    String query=null;
    int balance;
    int balanceto;
    int accid;
    ArrayList<Integer> List = new ArrayList<Integer>();
    public DonationPage() {
        initComponents();
        try{Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String connectionURL="jdbc:sqlserver://localhost:1433;databaseName=BankingSystem;user=admin;password=admin";
            con=DriverManager.getConnection(connectionURL);
            this.getCustomerAccountsList();
            this.setVisible(true);
            this.setLocationRelativeTo(null);
            //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    public void getCustomerAccountsList(){
        
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connectionURL="jdbc:sqlserver://localhost:1433;databaseName=BankingSystem;user=admin;password=admin";
            con=DriverManager.getConnection(connectionURL);
            query="Select * from Account where CuID='"+CustomerData.cuid+"'";
            st=con.createStatement();
            rs = st.executeQuery(query);
            while(rs.next()){
                accidCBox.addItem(rs.getInt("AccID")+"");
                List.add(rs.getInt("AccID"));
            }
            
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    public void addTransection(int amount){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connectionURL="jdbc:sqlserver://localhost:1433;databaseName=BankingSystem;user=admin;password=admin";
            con=DriverManager.getConnection(connectionURL);
            query="Insert into Transection(Amount,TrDate,TrType,AccIDTo,AccIDFrom)values(?,?,?,?,?)";
            PreparedStatement pst= con.prepareStatement(query);
            pst.setString(1, AmountTxt.getText());
            long millis=System.currentTimeMillis();  
            java.sql.Date date=new java.sql.Date(millis);  
            System.out.println(date);
            pst.setDate(2, date);
            pst.setString(3, "Donation");
            pst.setInt(4,1);
            pst.setInt(5, accid);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Donate Successfully!");
            this.dispose();
            
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    public void updateAcc(int id,int amount,int curBalance){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connectionURL="jdbc:sqlserver://localhost:1433;databaseName=BankingSystem;user=admin;password=admin";
            con=DriverManager.getConnection(connectionURL);
            query="Update Account set Balance=? where AccID='"+ id +"'";
            
            int money=curBalance+amount;
            query="Update Account set Balance="+money+" where AccID='"+ id +"'";
            PreparedStatement pst= con.prepareStatement(query);         
            pst.executeUpdate();
            System.out.println("Amount Update"+(amount+balance));
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    public void getbalaceto(){
        try{
            st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            query="select * from Account where accID='"+1+"'";
            rs= st.executeQuery(query);
            if(rs.next()){
                balanceto=rs.getInt("Balance");
                System.out.println("Balance to"+balanceto);
                this.updateAcc(1,Integer.parseInt(AmountTxt.getText()),balanceto);
                this.updateAcc(accid,-(Integer.parseInt(AmountTxt.getText())),balance);
                this.addTransection(Integer.parseInt(AmountTxt.getText()));
            }
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
                }
}
    public void checkBalance(){
        try{
            st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            query="select * from Account where AccID='"+accid+"'";
            rs= st.executeQuery(query);
            if(rs.next()){
                balance=rs.getInt("Balance");
                System.out.println(balance);
                if(Integer.parseInt(AmountTxt.getText())>balance){
                    JOptionPane.showMessageDialog(null,"Balance is insufficient for this transection!");
                }
                else{
                    this.getbalaceto();
                    
                }
            }
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        AmountTxt = new javax.swing.JTextField();
        DonateBtn = new javax.swing.JButton();
        accidCBox = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 30)); // NOI18N
        jLabel1.setText("Donation");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 30, 130, 40));

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel2.setText("Account ID");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 90, -1, -1));

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel3.setText("Amount");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 160, 90, -1));

        AmountTxt.setBackground(new java.awt.Color(255, 204, 255));
        AmountTxt.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        AmountTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AmountTxtActionPerformed(evt);
            }
        });
        jPanel1.add(AmountTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 190, 110, -1));

        DonateBtn.setBackground(new java.awt.Color(255, 204, 255));
        DonateBtn.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        DonateBtn.setText("Donate");
        DonateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DonateBtnActionPerformed(evt);
            }
        });
        jPanel1.add(DonateBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 250, -1, -1));

        jPanel1.add(accidCBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 120, 110, 30));

        jLabel4.setIcon(new javax.swing.ImageIcon("E:\\4th samester\\DataBase\\Project data\\Interface\\Login\\DonationBackground2.jpg")); // NOI18N
        jLabel4.setText("jLabel4");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 300));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AmountTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AmountTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AmountTxtActionPerformed

    private void DonateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DonateBtnActionPerformed
        // TODO add your handling code here:
        if(AmountTxt.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Please enter Amount!");
        }
        else if(Integer.parseInt(AmountTxt.getText())<0){
            JOptionPane.showMessageDialog(null,"Amount must be grater then 0!");
        }
        else{
            accid=List.get(accidCBox.getSelectedIndex());
            //this.setVisible(false);
            this.checkBalance();
        }
        
        /*try{
            st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            query="select * from Account where cuid='"+CustomerData.cuid+"'";
            rs= st.executeQuery(query);
            if(rs.next()){
                accid=rs.getInt("AccID");
                balance=rs.getInt("Balance");
                System.out.println(balance);
                if(Integer.parseInt(AmountTxt.getText())>balance){
                    JOptionPane.showMessageDialog(null,"Balance is insufficient for this transection!");
                }
                else{
                   //System.out.println(Integer.parseInt(ToAccTxt.getText()));
                   this.checkBalance();
                }
            }
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }*/
    }//GEN-LAST:event_DonateBtnActionPerformed

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
            java.util.logging.Logger.getLogger(DonationPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DonationPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DonationPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DonationPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DonationPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AmountTxt;
    private javax.swing.JButton DonateBtn;
    private javax.swing.JComboBox<String> accidCBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
