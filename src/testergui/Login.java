
package testergui;
import java.util.Date;
import java.awt.Color;
import java.awt.Font;
import java.awt.font.TextAttribute;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.util.*;
import javax.swing.*;
import java.text.SimpleDateFormat;  
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;


public class Login extends javax.swing.JFrame {
    String query=null;
    Connection con=null;
    Statement st=null;
    ResultSet rs=null;
    String id=null;
    String password=null;
    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
        try{Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String connectionURL="jdbc:sqlserver://localhost:1433;databaseName=BankingSystem;user=admin;password=admin";
            con=DriverManager.getConnection(connectionURL);
            this.setVisible(true);
            this.setLocationRelativeTo(null);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
             jPanel2.setBackground(new Color(0,0,0,100));
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
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jid = new javax.swing.JTextField();
        jpassword = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        loginBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sign up");
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(0, 102, 204));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(622, 0, -1, -1));

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 48)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("LogIn");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, 193, 57));

        jLabel5.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Password");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 280, 170, 21));

        jid.setBackground(new java.awt.Color(204, 204, 255));
        jid.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jid.setForeground(new java.awt.Color(51, 51, 51));
        jid.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        jid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jidActionPerformed(evt);
            }
        });
        jPanel1.add(jid, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 220, 193, 36));

        jpassword.setBackground(new java.awt.Color(204, 204, 255));
        jpassword.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        jPanel1.add(jpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 310, 193, 35));

        jLabel7.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Login ID");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 190, 190, 21));

        jComboBox1.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CUSTOMER", "ADMIN", "STAFF" }));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });
        jPanel1.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 120, 100, 30));

        loginBtn.setBackground(new java.awt.Color(153, 153, 255));
        loginBtn.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        loginBtn.setText("Login");
        loginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginBtnActionPerformed(evt);
            }
        });
        jPanel1.add(loginBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 400, 190, -1));

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("login type: ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 120, 90, 30));

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("X");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 0, -1, -1));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 360, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 420, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 360, 420));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon("E:\\4th samester\\DataBase\\Project data\\Interface\\Login\\background3.jpg")); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 490));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 754, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(579, 490));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jidActionPerformed
public void loginby()
{
     id=jid.getText();
     
     password=jpassword.getText();
    if(jComboBox1.getSelectedItem().toString().equals("CUSTOMER"))
        {
            query="SELECT * FROM customer where CuID='" + id + "'and Password='" + password + "'";
            CustomerData.cuid=Integer.parseInt(jid.getText());
        }
            else if(jComboBox1.getSelectedItem().toString().equals("ADMIN"))
        {
            query="SELECT * FROM Admin where AdID='" + id + "'and Password='" + password + "'";
            AdminData.adid=Integer.parseInt(jid.getText());
            System.out.println("AdID "+AdminData.adid);
        }
            else if(jComboBox1.getSelectedItem().toString().equals("STAFF"))
        {
            query="SELECT * FROM Staff where StID='" + id + "'and Password='" + password + "'";
            Staff.stid=Integer.parseInt(jid.getText());
            
        }
}
    public void loginNow()
{
     try{
             st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
             
                loginby();
                rs = st.executeQuery(query);
                boolean empty = true;
                if (rs.next())
                {
                    empty = false;
                 
                if(id==null)
                {
                    JOptionPane.showMessageDialog(null,"Enter id!");
                }
                else if(password.equals(""))
                {
                    JOptionPane.showMessageDialog(null,"Enter Password!");
                }
                else
                {
                     if(jComboBox1.getSelectedItem().toString().equals("CUSTOMER"))
                     {
                        this.setVisible(false);
                        Customer h=new Customer();
                        h.setVisible(true);
                        h.pack();
                        h.setLocationRelativeTo(null);
                        h.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        this.dispose();
                     }
                     else if(jComboBox1.getSelectedItem().toString().equals("ADMIN"))
                     {
                         this.setVisible(false);
                        AdminConsol h=new AdminConsol();
                        h.setVisible(true);
                        h.pack();
                        h.setLocationRelativeTo(null);
                        h.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        this.dispose();
                     }
                     else if(jComboBox1.getSelectedItem().toString().equals("STAFF"))
                     {
                         this.setVisible(false);
                         StuffConsol h= new StuffConsol();
                         h.setVisible(true);
                         h.pack();
                         h.setLocationRelativeTo(null);
                         h.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                         this.dispose();
                         
                     }
                }
            }
            else 
                    JOptionPane.showMessageDialog(null,"invalid username or password!");
        }
        catch(Exception e)
        {
            System.out.println("error with connection "+e);
        }
}
    private void loginBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginBtnActionPerformed
        // TODO add your handling code here:
        if((jid.getText()).equals("")){
            JOptionPane.showMessageDialog(null,"Enter id!");
        }
        else if((jpassword.getText()).equals("")){
            JOptionPane.showMessageDialog(null,"Enter Password!");
        }
        else{
            loginNow();
        }
    }//GEN-LAST:event_loginBtnActionPerformed

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        // TODO add your handling code here:
         if(jComboBox1.getSelectedItem().toString().equals("CUSTOMER"))
        {
            jLabel7.setText("Customer ID:");
        }
            else if(jComboBox1.getSelectedItem().toString().equals("ADMIN"))
        {
            jLabel7.setText("Admin ID");
        }
         else if(jComboBox1.getSelectedItem().toString().equals("STAFF"))
        {
            jLabel7.setText("Staff ID");
        }
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField jid;
    private javax.swing.JPasswordField jpassword;
    private javax.swing.JButton loginBtn;
    // End of variables declaration//GEN-END:variables
}
