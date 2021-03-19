
package testergui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Transection extends javax.swing.JFrame {
    Connection con=null;
    Statement st=null;
    ResultSet rs=null;
    String query=null;
    int balance;
    int balanceto;
    int accid;
    ArrayList<Integer> List = new ArrayList<Integer>();
    public Transection() {
        initComponents();
        this.getCustomerAccountsList();
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
            pst.setString(3, "Normal");
            pst.setInt(4,Integer.parseInt(ToAccTxt.getText()));
            pst.setInt(5, accid);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Successfully Transfered!");
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
            //query="Update Account set Balance=? where AccID='"+ id +"'";
            
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
            query="select * from Account where accID='"+Integer.parseInt(ToAccTxt.getText())+"'";
            rs= st.executeQuery(query);
            if(rs.next()){
                balanceto=rs.getInt("Balance");
                System.out.println("Balance to"+balanceto);
                this.updateAcc(Integer.parseInt(ToAccTxt.getText()),Integer.parseInt(AmountTxt.getText()),balanceto);
                    this.updateAcc(accid,-(Integer.parseInt(AmountTxt.getText())),balance);
                    this.addTransection(Integer.parseInt(AmountTxt.getText()));
            }
            else{
                JOptionPane.showMessageDialog(null,"invalid To Account No.!");
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
                    System.out.println(Integer.parseInt(ToAccTxt.getText()));
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
        jLabel4 = new javax.swing.JLabel();
        ToAccTxt = new javax.swing.JTextField();
        AmountTxt = new javax.swing.JTextField();
        TransferBtn = new javax.swing.JButton();
        accidCBox = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        jLabel1.setText("Transaction");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 31, -1, -1));

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel2.setText("From Account No.");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 101, -1, -1));

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel3.setText("To Account No.");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 145, -1, -1));

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel4.setText("Amount");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 189, -1, -1));

        ToAccTxt.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jPanel1.add(ToAccTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(188, 142, 180, -1));

        AmountTxt.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jPanel1.add(AmountTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(188, 186, 180, -1));

        TransferBtn.setBackground(new java.awt.Color(204, 204, 204));
        TransferBtn.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        TransferBtn.setText("Transfer");
        TransferBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        TransferBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TransferBtnActionPerformed(evt);
            }
        });
        jPanel1.add(TransferBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(314, 248, 80, 30));

        jPanel1.add(accidCBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, 170, 30));

        jLabel5.setIcon(new javax.swing.ImageIcon("E:\\4th samester\\DataBase\\Project data\\Interface\\Login\\TransectionBackground.jpg")); // NOI18N
        jLabel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 440, 320));

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

    private void TransferBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TransferBtnActionPerformed
        if(AmountTxt.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Please enter Amount!");
        }
        else if(Integer.parseInt(AmountTxt.getText())<0){
            JOptionPane.showMessageDialog(null,"Amount must be grater then 0!");
        }
        else if(ToAccTxt.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Please enter Account ID To!");
        }
        else{
            accid=List.get(accidCBox.getSelectedIndex());
            //accid=accidCBox.getSelectedIndex();
            System.out.println(accid);
            this.checkBalance();
        }
        //this.setVisible(false);
        
    }//GEN-LAST:event_TransferBtnActionPerformed

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
            java.util.logging.Logger.getLogger(Transection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Transection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Transection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Transection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Transection().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AmountTxt;
    private javax.swing.JTextField ToAccTxt;
    private javax.swing.JButton TransferBtn;
    private javax.swing.JComboBox<String> accidCBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
