
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */
public class Show_catalog_customer extends javax.swing.JFrame {
int t_id,i;
String string_t_id;
    /**
     * Creates new form Show_catalog_customer
     */
    public Show_catalog_customer() {
        initComponents();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
    }
    public ArrayList<Orders> orderList(){
        ArrayList<Orders> orderList = new ArrayList();
        try{
             Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=TailorDBproject;selectMethod=cursor", "sa", "123456");
                Statement statement = connection.createStatement();
                string_t_id = jTextField3.getText();
                t_id = Integer.parseInt(string_t_id);
                ResultSet resultSet = statement.executeQuery("SELECT * FROM Orders WHERE CustomerId = "+t_id+"");
                Orders orders;
                while(resultSet.next()){
                    orders = new Orders(resultSet.getInt("OrderID"),resultSet.getInt("CustomerId"), resultSet.getInt("TailorId"),resultSet.getDate("OrderDate").toString(),resultSet.getDate("CompletingDate").toString(),resultSet.getString("Completed"),resultSet.getString("Emergency_make"),resultSet.getBytes("Image"));
                    orderList.add(orders);
                }
                
                 
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return orderList;
    }
    
    public void show_orders(){
        ArrayList<Orders> list = orderList();
        CustomerOrders todr = new CustomerOrders();
        todr.jTextField1.setText(jTextField3.getText());
        DefaultTableModel model = (DefaultTableModel) todr.jTable_Display_Orders.getModel();
        Object[] row = new Object[7];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).get_order_id();
            row[1] = list.get(i).get_customer_id();
            row[2] = list.get(i).get_tailor_id();
            row[3] = list.get(i).get_order_date();
            row[4] = list.get(i).get_complete_date();
            row[5] = list.get(i).completed();
            row[6] = list.get(i).emergency();
            model.addRow(row);
        }
        dispose();
        todr.setVisible(true);
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
        lbl_img = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setLayout(null);
        jPanel1.add(lbl_img);
        lbl_img.setBounds(150, 90, 610, 570);

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Your Customer ID:");
        jLabel4.setOpaque(true);
        jPanel1.add(jLabel4);
        jLabel4.setBounds(20, 20, 180, 30);

        jTextField3.setEditable(false);
        jTextField3.setBackground(new java.awt.Color(0, 0, 0));
        jTextField3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField3.setForeground(new java.awt.Color(255, 255, 255));
        jTextField3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField3.setBorder(null);
        jPanel1.add(jTextField3);
        jTextField3.setBounds(200, 20, 140, 30);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tailordbconnect/rsz_1back_small.png"))); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel3MousePressed(evt);
            }
        });
        jPanel1.add(jLabel3);
        jLabel3.setBounds(40, 610, 80, 40);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tailordbconnect/logout-md.jpg"))); // NOI18N
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel6MousePressed(evt);
            }
        });
        jPanel1.add(jLabel6);
        jLabel6.setBounds(790, 610, 110, 40);

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setText("Exit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(810, 30, 67, 31);

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(0, 0, 0));
        jTextField1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(255, 255, 255));
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(jTextField1);
        jTextField1.setBounds(500, 20, 220, 30);

        jLabel7.setBackground(new java.awt.Color(0, 0, 0));
        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Dress Name");
        jLabel7.setOpaque(true);
        jPanel1.add(jLabel7);
        jLabel7.setBounds(390, 20, 110, 30);

        jLabel8.setBackground(new java.awt.Color(0, 0, 0));
        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Catalog ID");
        jLabel8.setOpaque(true);
        jPanel1.add(jLabel8);
        jLabel8.setBounds(390, 50, 110, 30);

        jTextField4.setEditable(false);
        jTextField4.setBackground(new java.awt.Color(0, 0, 0));
        jTextField4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField4.setForeground(new java.awt.Color(255, 255, 255));
        jTextField4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(jTextField4);
        jTextField4.setBounds(500, 50, 220, 30);

        jLabel9.setBackground(new java.awt.Color(0, 0, 0));
        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Order ID");
        jLabel9.setOpaque(true);
        jPanel1.add(jLabel9);
        jLabel9.setBounds(20, 50, 160, 30);

        jTextField5.setEditable(false);
        jTextField5.setBackground(new java.awt.Color(0, 0, 0));
        jTextField5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField5.setForeground(new java.awt.Color(255, 255, 255));
        jTextField5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField5.setBorder(null);
        jPanel1.add(jTextField5);
        jTextField5.setBounds(180, 50, 160, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tailordbconnect/custom-tailoring.jpg"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 930, 690);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 911, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 675, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MousePressed
        CustomerOrders cus = new CustomerOrders();
         ArrayList<Orders> list = orderList();
        cus.jTextField1.setText(jTextField3.getText());
        DefaultTableModel model = (DefaultTableModel) cus.jTable_Display_Orders.getModel();
        Object[] row = new Object[7];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).get_order_id();
            row[1] = list.get(i).get_customer_id();
            row[2] = list.get(i).get_tailor_id();
            row[3] = list.get(i).get_order_date();
            row[4] = list.get(i).get_complete_date();
            row[5] = list.get(i).completed();
            row[6] = list.get(i).emergency();
            model.addRow(row);
        }
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=TailorDBproject;selectMethod=cursor", "sa", "123456");
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM Orders WHERE [OrderID]=" + jTextField5.getText() + "");
            while (result.next()) {
                cus.jTextField11.setText(Integer.toString(result.getInt("OrderID")));
                cus.jTextField12.setText(Integer.toString(result.getInt("TailorId")));
                cus.jTextField14.setText(Integer.toString(result.getInt("CatalogId")));
                cus.jTextField15.setText(result.getString("DressType"));
                cus.jTextField16.setText(result.getString("Party_Casual"));
                cus.jTextField2.setText(String.valueOf(result.getFloat("Height")));
                cus.jTextField4.setText(String.valueOf(result.getFloat("Neck")));
                cus.jTextField5.setText(String.valueOf(result.getFloat("Waist")));
                cus.jTextField3.setText(String.valueOf(result.getFloat("Shoulder")));
                cus.jTextField6.setText(String.valueOf(result.getFloat("Chest")));
                cus.jTextField7.setText(String.valueOf(result.getFloat("Thighs")));
                cus.jTextField8.setText(String.valueOf(result.getFloat("Arm")));
                cus.jTextField9.setText(String.valueOf(result.getFloat("Wrist")));
                cus.jTextField10.setText(String.valueOf(result.getFloat("fee")));
                cus.jTextArea1.setText(result.getString("ExtraDescribe"));
                cus.lbl_img.setVisible(true);
                cus.jLabel18.setVisible(true);
                ImageIcon imageIcon = new ImageIcon(new ImageIcon(result.getString("ImagePath")).getImage().getScaledInstance(cus.lbl_img.getWidth(), cus.lbl_img.getHeight(), Image.SCALE_SMOOTH));
                cus.lbl_img.setIcon(imageIcon);
                cus.jButton2.setVisible(true);
                cus.jButton4.setVisible(true);
            }
            dispose();
            cus.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jLabel3MousePressed

    private void jLabel6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MousePressed
        dispose();
        new TailorDBsigninjFrame().setVisible(true);
    }//GEN-LAST:event_jLabel6MousePressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(Show_catalog_customer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Show_catalog_customer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Show_catalog_customer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Show_catalog_customer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Show_catalog_customer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JTextField jTextField1;
    public javax.swing.JTextField jTextField3;
    public javax.swing.JTextField jTextField4;
    public javax.swing.JTextField jTextField5;
    public javax.swing.JLabel lbl_img;
    // End of variables declaration//GEN-END:variables
}
