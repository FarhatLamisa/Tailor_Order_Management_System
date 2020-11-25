import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */
public class TailorDBsignupjFrame extends javax.swing.JFrame {
String email,username,address,mobile,password,sql;
    /**
     * Creates new form TailorDBsignupjFrame
     */
    public TailorDBsignupjFrame() {
        initComponents();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        txtemail.setBackground(new java.awt.Color(0,0,0,1));
        txtpass.setBackground(new java.awt.Color(0,0,0,1));
        txtusername.setBackground(new java.awt.Color(0,0,0,1));
        txtmobile.setBackground(new java.awt.Color(0,0,0,1));
        txtaddress.setBackground(new java.awt.Color(0,0,0,1));
        jPanel1.setBackground(new Color(0,0,0,0));
        signupas_combo.setModel(new DefaultComboBoxModel<>(new String[] {
            "--- Sign in as ---", "Tailor", "Customer"
           }));
        
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
        jLabel2 = new javax.swing.JLabel();
        txtemail = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        signup_btn = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        txtpass = new javax.swing.JPasswordField();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtusername = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        mobilelabel = new javax.swing.JLabel();
        txtmobile = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        addressLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtaddress = new javax.swing.JTextArea();
        jSeparator5 = new javax.swing.JSeparator();
        exitbutton = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        signupas_combo = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setUndecorated(true);

        jPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 18)); // NOI18N
        jLabel2.setText("Email**:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(290, 80, 110, 20);

        txtemail.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtemail.setBorder(null);
        jPanel1.add(txtemail);
        txtemail.setBounds(290, 110, 260, 20);

        jLabel3.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 18)); // NOI18N
        jLabel3.setText("Password**:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(290, 320, 130, 30);

        signup_btn.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        signup_btn.setText("Sign-Up");
        signup_btn.setActionCommand("");
        signup_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signup_btnActionPerformed(evt);
            }
        });
        jPanel1.add(signup_btn);
        signup_btn.setBounds(290, 490, 130, 40);

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator1);
        jSeparator1.setBounds(290, 130, 260, 10);

        txtpass.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtpass.setBorder(null);
        jPanel1.add(txtpass);
        txtpass.setBounds(290, 350, 260, 20);

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator2);
        jSeparator2.setBounds(290, 370, 260, 10);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tailordbconnect/Makower-FQ-bundle-sign-up.jpg"))); // NOI18N
        jPanel1.add(jLabel4);
        jLabel4.setBounds(-490, 0, 750, 550);

        jLabel5.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 18)); // NOI18N
        jLabel5.setText("Username**:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(290, 10, 120, 21);

        txtusername.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtusername.setBorder(null);
        jPanel1.add(txtusername);
        txtusername.setBounds(290, 40, 260, 20);

        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator3);
        jSeparator3.setBounds(290, 60, 260, 10);

        mobilelabel.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 18)); // NOI18N
        mobilelabel.setText("Mobile**:");
        jPanel1.add(mobilelabel);
        mobilelabel.setBounds(290, 150, 80, 20);

        txtmobile.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtmobile.setBorder(null);
        jPanel1.add(txtmobile);
        txtmobile.setBounds(350, 180, 200, 20);

        jSeparator4.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator4);
        jSeparator4.setBounds(290, 200, 260, 10);

        addressLabel.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 18)); // NOI18N
        addressLabel.setText("Address*:");
        jPanel1.add(addressLabel);
        addressLabel.setBounds(290, 220, 80, 21);

        txtaddress.setColumns(20);
        txtaddress.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtaddress.setRows(5);
        txtaddress.setBorder(null);
        jScrollPane1.setViewportView(txtaddress);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(290, 250, 380, 50);
        jPanel1.add(jSeparator5);
        jSeparator5.setBounds(290, 300, 380, 10);

        exitbutton.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 18)); // NOI18N
        exitbutton.setText("Exit");
        exitbutton.setActionCommand("");
        exitbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitbuttonActionPerformed(evt);
            }
        });
        jPanel1.add(exitbutton);
        exitbutton.setBounds(750, 20, 63, 29);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Already have an account?");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(430, 510, 160, 15);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 153));
        jLabel7.setText("<html> <body> <u>Sign- in</u> </body> </html>");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel7);
        jLabel7.setBounds(590, 507, 60, 20);

        jLabel8.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 18)); // NOI18N
        jLabel8.setText("Sign up as**:");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(290, 390, 110, 30);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("+880");
        jLabel9.setOpaque(true);
        jPanel1.add(jLabel9);
        jLabel9.setBounds(290, 180, 60, 20);

        signupas_combo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        signupas_combo.setBorder(null);
        jPanel1.add(signupas_combo);
        signupas_combo.setBounds(400, 390, 160, 30);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("* If you are a tailor you don't need to fill up the address");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(290, 460, 360, 15);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("**must be filled up ");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(290, 440, 270, 15);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tailordbconnect/lux-velvet-6031-baby-blue-fabric-2-zoom-big.jpg"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(260, 0, 580, 600);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 835, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 546, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void signup_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signup_btnActionPerformed
    
        if(!(txtusername.getText().length()<=0 || txtemail.getText().length()<=0||txtmobile.getText().length()<=0 || txtpass.getText().length()<=0))
        {
            username = txtusername.getText();
            email = txtemail.getText();
            address = txtaddress.getText();
            mobile = txtmobile.getText();
            password = txtpass.getText();
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=TailorDBproject;selectMethod=cursor", "sa", "123456");
                Statement statement = connection.createStatement();

                if ((email.contains("@gmail.com") || email.contains("@yahoo.com") || email.contains("@outlook.com"))
                        && signupas_combo.getSelectedItem().toString() == "Customer") {
                    ResultSet res = statement.executeQuery("SELECT * FROM Customer WHERE Email = '" + email + "'");
                   if(res.next()) {
                        sql = res.getString("Email");
                        
                    }
                    if ((sql) != (email)) {
                            statement.executeUpdate("insert into Customer values('" + email + "','" + password + "','" + username + "','" + address + "','" + mobile + "')");
                            dispose();
                            new TailorDBsigninjFrame().setVisible(true);
                        } else {
                        System.out.println(sql);
                            JOptionPane.showMessageDialog(null, "This email already has an account!", "Sign up", JOptionPane.INFORMATION_MESSAGE);
                        }
                    

                } else if ((email.contains("@gmail.com") || email.contains("@yahoo.com") || email.contains("@outlook.com"))
                        && signupas_combo.getSelectedItem().toString() == "Tailor") {
                    if (txtaddress.getText().length() <= 0) {
                        ResultSet res = statement.executeQuery("SELECT * FROM Tailor WHERE TailorEmail = '" + email + "'");
                        if (res.next()) {
                            sql = res.getString("TailorEmail");
                        }
                        if (sql != (email)) {
                            statement.executeUpdate("insert into Tailor(TailorEmail,TailorPass,TailorName,TailorContact) values('" + email + "','" + password + "','" + username + "','" + mobile + "')");
                            dispose();
                            new TailorDBsigninjFrame().setVisible(true);
                        } else {
                            JOptionPane.showMessageDialog(null, "This email already has an account!", "Sign up", JOptionPane.INFORMATION_MESSAGE);
                        }

                    } else {
                        ResultSet res = statement.executeQuery("SELECT * FROM Tailor WHERE TailorEmail = '" + email + "'");
                        if(res.next()) {
                            sql = res.getString("TailorEmail");
                        }
                          
                         if ((sql) != (email)) {
                                statement.executeUpdate("insert into Tailor(TailorEmail,TailorPass,TailorName,TailorContact,TailorAddress) values('" + email + "','" + password + "','" + username + "','" + mobile + "','" + address + "')");
                                dispose();
                                new TailorDBsigninjFrame().setVisible(true);
                            } else {
                                JOptionPane.showMessageDialog(null, "This email already has an account!", "Sign up", JOptionPane.INFORMATION_MESSAGE);
                            }
                    }

                } else if (!(email.contains("@gmail.com") || email.contains("@yahoo.com") || email.contains("@outlook.com"))) {
                    JOptionPane.showMessageDialog(null, "Invalid email address", "Email", JOptionPane.QUESTION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Sign up as?", "Sign up", JOptionPane.QUESTION_MESSAGE);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            JOptionPane.showMessageDialog(null, "All the fields must be fulfiled");
        }
    }//GEN-LAST:event_signup_btnActionPerformed

    private void exitbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitbuttonActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_exitbuttonActionPerformed

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        // TODO add your handling code here:
        dispose();
        new TailorDBsigninjFrame().setVisible(true);
    }//GEN-LAST:event_jLabel7MouseClicked

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
            java.util.logging.Logger.getLogger(TailorDBsignupjFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TailorDBsignupjFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TailorDBsignupjFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TailorDBsignupjFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TailorDBsignupjFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addressLabel;
    private javax.swing.JButton exitbutton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JLabel mobilelabel;
    private javax.swing.JButton signup_btn;
    private javax.swing.JComboBox<String> signupas_combo;
    private javax.swing.JTextArea txtaddress;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtmobile;
    private javax.swing.JPasswordField txtpass;
    private javax.swing.JTextField txtusername;
    // End of variables declaration//GEN-END:variables
}
