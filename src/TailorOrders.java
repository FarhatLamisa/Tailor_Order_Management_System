
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
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
public class TailorOrders extends javax.swing.JFrame {
 String s,odate,cdate,string_t_id,string_t_id1,get_id,get_name,order_date,deadline,str_order_id,completed,emergency,extra_des,filename;
 int t_id1,t_id,i,order,order_id,custom_id,tailor_id,par_id,cas_id;
 float fees,height,waist,shoulder,arm,chest,thighs,wrist,neck;
 
 
    /**
     * Creates new form TailorOrders
     */
    public TailorOrders() {
        initComponents();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
       jButton4.setVisible(false);
       jButton5.setVisible(false);
    }
    public ArrayList<Orders> orderList(){
        ArrayList<Orders> orderList = new ArrayList();
        try{
             Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=TailorDBproject;selectMethod=cursor", "sa", "123456");
                Statement statement = connection.createStatement();
                string_t_id = jTextField1.getText();
                t_id = Integer.parseInt(string_t_id);
            
                ResultSet resultSet = statement.executeQuery("SELECT * FROM Orders WHERE TailorId = "+t_id+"");
                Orders orders;
               
                while(resultSet.next()){
               
                    odate = resultSet.getDate("OrderDate").toString();
                    cdate = resultSet.getDate("CompletingDate").toString();
                    orders = new Orders(resultSet.getInt("OrderID"),resultSet.getInt("CustomerId"), resultSet.getInt("TailorId"),odate,cdate,resultSet.getString("Completed"),resultSet.getString("Emergency_make"),resultSet.getBytes("Image"));
                    orderList.add(orders);
                   
                }
                
                 
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return orderList;
    }
    
    public void show_orders(){
        ArrayList<Orders> list = orderList();
          s = jTextField1.getText().toString();
          i = Integer.parseInt(s);
         AllListOfOrders alo = new AllListOfOrders();
        alo.jTextField1.setText(s);
        DefaultTableModel model = (DefaultTableModel)alo.jTable_Display_Orders.getModel();
         
        Object[] row = new Object[7];
        for(int i=0;i<list.size();i++){
            row[0] = list.get(i).get_order_id();
            row[1] = list.get(i).get_customer_id();
            row[2] = list.get(i).get_tailor_id();
            row[3] = list.get(i).get_order_date();
            row[4] = list.get(i).get_complete_date();
            row[5] = list.get(i).completed();
            row[6] = list.get(i).emergency();
            model.addRow(row);
            
        }
         alo.setVisible(true);   
    }
    
     public ArrayList<CasualOrders> casual_orderList(){
        ArrayList<CasualOrders> casual_orderList = new ArrayList();
        try{
             Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=TailorDBproject;selectMethod=cursor", "sa", "123456");
                Statement statement = connection.createStatement();
                string_t_id = jTextField1.getText();
                t_id = Integer.parseInt(string_t_id);
            
                ResultSet resultSet = statement.executeQuery("SELECT Orders.CustomerId,Casual_Dress_Orders.Cas_Id,Casual_Dress_Orders.OrderId FROM Orders INNER JOIN Casual_Dress_Orders ON Orders.OrderID=Casual_Dress_Orders.OrderId WHERE TailorId = "+jTextField1.getText()+"");
                CasualOrders orders;
                while(resultSet.next()){
                    orders = new CasualOrders(resultSet.getInt("Cas_Id"), resultSet.getInt("OrderId"),resultSet.getInt("CustomerId"));
                    casual_orderList.add(orders);
                   }
                
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return casual_orderList;
    }
    
    public void casual_show_orders(){
        ArrayList<CasualOrders> list = casual_orderList();
          s = jTextField1.getText().toString();
          i = Integer.parseInt(s);
         CasualDressOrders alo = new CasualDressOrders();
        alo.jTextField1.setText(s);
        DefaultTableModel model = (DefaultTableModel)alo.jTable_Display_Orders.getModel();
         
        Object[] row = new Object[4];
        for(int i=0;i<list.size();i++){
            row[0] = list.get(i).get_cas_id();
            row[1] = list.get(i).get_order_id();
            row[2] = list.get(i).get_customer_id();
           
            model.addRow(row);
            
        }
         alo.setVisible(true);   
    }
    
    public ArrayList<PartyOrders> party_orderList(){
        ArrayList<PartyOrders> party_orderList = new ArrayList();
        try{
             Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=TailorDBproject;selectMethod=cursor", "sa", "123456");
                Statement statement = connection.createStatement();
                string_t_id = jTextField1.getText();
                t_id = Integer.parseInt(string_t_id);
            
                ResultSet resultSet = statement.executeQuery("SELECT Orders.CustomerId,Party_Dress_Orders.Par_Id,Party_Dress_Orders.OrderId FROM Orders INNER JOIN Party_Dress_Orders ON Orders.OrderID=Party_Dress_Orders.OrderId WHERE TailorId = "+jTextField1.getText()+"");
                PartyOrders orders;
                while(resultSet.next()){
                    orders = new PartyOrders(resultSet.getInt("Par_Id"), resultSet.getInt("OrderId"),resultSet.getInt("CustomerId"));
                    party_orderList.add(orders);
                   }
                
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return party_orderList;
    }
    
    public void party_show_orders(){
        ArrayList<PartyOrders> list = party_orderList();
          s = jTextField1.getText().toString();
          i = Integer.parseInt(s);
         PartyDressOrders alo = new PartyDressOrders();
        alo.jTextField1.setText(s);
        DefaultTableModel model = (DefaultTableModel)alo.jTable_Display_Orders.getModel();
         
        Object[] row = new Object[4];
        for(int i=0;i<list.size();i++){
            row[0] = list.get(i).get_cas_id();
            row[1] = list.get(i).get_order_id();
            row[2] = list.get(i).get_customer_id();
        
            model.addRow(row);
            
        }
         alo.setVisible(true);   
    }
    
   public void table_selected_item(){
     
        OrderInfo odrinfo = new OrderInfo();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=TailorDBproject;selectMethod=cursor", "sa", "123456");
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM Orders WHERE [OrderID]=" + order + "");
            while (result.next()) {

                odrinfo.jTextField10.setText(Integer.toString(result.getInt("OrderID")));

                odrinfo.jTextField1.setText(Integer.toString(result.getInt("CustomerId")));

                odrinfo.jTextField12.setText(Integer.toString(result.getInt("TailorId")));

                odrinfo.jTextField3.setText(String.valueOf(result.getFloat("Height")));

                odrinfo.jTextField14.setText(String.valueOf(result.getFloat("Neck")));

                odrinfo.jTextField4.setText(String.valueOf(result.getFloat("Waist")));

                odrinfo.jTextField5.setText(String.valueOf(result.getFloat("Shoulder")));

                odrinfo.jTextField7.setText(String.valueOf(result.getFloat("Chest")));

                odrinfo.jTextField13.setText(String.valueOf(result.getFloat("Thighs")));

                odrinfo.jTextField6.setText(String.valueOf(result.getFloat("Arm")));

                odrinfo.jTextField8.setText(String.valueOf(result.getFloat("Wrist")));

                odrinfo.jTextField9.setText(String.valueOf(result.getFloat("fee")));

                odrinfo.jTextField11.setText(result.getString("CompletingDate"));

                odrinfo.jTextField2.setText(result.getString("OrderDate"));

                odrinfo.jTextField15.setText(result.getString("Completed"));

                odrinfo.jTextField16.setText(result.getString("Emergency_make"));
                odrinfo.jTextField19.setText(String.valueOf(result.getInt("DesignId")));
                odrinfo.jTextField18.setText(result.getString("DressType"));
                if (result.getString("ExtraDescribe") != null) {
                    odrinfo.jTextArea1.setText(result.getString("ExtraDescribe"));
                } else {
                    odrinfo.jTextArea1.setText("not given");
                }

                dispose();
                odrinfo.setVisible(true);
            }

        } catch (Exception e) {
            e.printStackTrace();
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
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setLayout(null);

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(0, 0, 0));
        jTextField1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(255, 255, 255));
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setBorder(null);
        jPanel1.add(jTextField1);
        jTextField1.setBounds(420, 130, 180, 40);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tailordbconnect/rsz_1back_small.png"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel2);
        jLabel2.setBounds(30, 630, 77, 40);

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setText("Exit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(770, 10, 67, 31);

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Your tailor ID:");
        jLabel3.setOpaque(true);
        jPanel1.add(jLabel3);
        jLabel3.setBounds(260, 130, 160, 40);

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tailordbconnect/logout-md.jpg"))); // NOI18N
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel4);
        jLabel4.setBounds(730, 630, 110, 40);

        jButton2.setBackground(new java.awt.Color(0, 0, 0));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Add New Order");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(300, 200, 260, 40);

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Your Orders");
        jLabel5.setOpaque(true);
        jPanel1.add(jLabel5);
        jLabel5.setBounds(310, 50, 250, 60);

        jButton3.setBackground(new java.awt.Color(0, 0, 0));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Show All List Of Orders");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(310, 280, 240, 40);

        jButton4.setBackground(new java.awt.Color(0, 0, 0));
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Show Party Dress Orders");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4);
        jButton4.setBounds(310, 350, 240, 30);

        jButton5.setBackground(new java.awt.Color(0, 0, 0));
        jButton5.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Casual Dress Orders");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5);
        jButton5.setBounds(310, 390, 240, 29);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tailordbconnect/tailor.jpeg"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 860, 890);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 852, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 692, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked

        dispose();
        TailorPanel tp = new TailorPanel();
        get_id = jTextField1.getText();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=TailorDBproject;selectMethod=cursor", "sa", "123456");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT TailorName FROM Tailor WHERE TailorId = " + get_id + "");
            if (resultSet.next()) {
                get_name = resultSet.getString("TailorName");
                tp.jTextField2.setText(get_name);
                tp.jTextField1.setText(get_id);
                tp.setVisible(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        dispose();
        new TailorDBsigninjFrame().setVisible(true);
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
        AddnewOrder add = new AddnewOrder();
        add.jTextField3.setText(jTextField1.getText());
        add.jTextField2.setText("1");
        add.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        dispose();
        show_orders();

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        dispose();
        party_show_orders();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        dispose();
        casual_show_orders();
    }//GEN-LAST:event_jButton5ActionPerformed

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
            java.util.logging.Logger.getLogger(TailorOrders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TailorOrders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TailorOrders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TailorOrders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TailorOrders().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
