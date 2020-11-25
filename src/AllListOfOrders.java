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
public class AllListOfOrders extends javax.swing.JFrame {
 String select,s,odate,cdate,string_t_id,string_t_id1,get_id,get_name,order_date,deadline,str_order_id,completed,emergency,extra_des,filename;
 int t_id1,t_id,i,order,search_by,custom_id,tailor_id;
 float fees,height,waist,shoulder,arm,chest,thighs,wrist,neck;
 
 
    /**
     * Creates new form TailorOrders
     */
    public AllListOfOrders() {
        initComponents();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        jTextField2.setVisible(false);
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
        TailorOrders todr = new TailorOrders();
        todr.jTextField1.setText(s);
        dispose();
        todr.setVisible(true);
        Object[] row = new Object[7];
        for(int i=0;i<list.size();i++){
            row[0] = list.get(i).get_order_id();
            row[1] = list.get(i).get_customer_id();
            row[2] = list.get(i).get_tailor_id();
            row[3] = list.get(i).get_order_date();
            row[4] = list.get(i).get_complete_date();
            row[5] = list.get(i).completed();
            row[6] = list.get(i).emergency();
        }
    }
    public void table_selected_item() {
        DefaultTableModel model = (DefaultTableModel) jTable_Display_Orders.getModel();
        i = jTable_Display_Orders.getSelectedRow();
        order = (int) model.getValueAt(i, 0);
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
                odrinfo.jTextField17.setText(result.getString("Party_Casual"));
                odrinfo.jTextField19.setText(String.valueOf(result.getInt("CatalogId")));
                odrinfo.jTextField18.setText(result.getString("DressType"));
                if (result.getString("ExtraDescribe") != null) {
                    odrinfo.jTextArea1.setText(result.getString("ExtraDescribe"));
                } else {
                    odrinfo.jTextArea1.setText("not given");
                }
                ImageIcon imageIcon = new ImageIcon(new ImageIcon(result.getString("ImagePath")).getImage().getScaledInstance(odrinfo.lbl_img.getWidth(),odrinfo.lbl_img.getHeight(),Image.SCALE_SMOOTH));
        odrinfo.lbl_img.setIcon(imageIcon);

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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_Display_Orders = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
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
        jTextField1.setBounds(440, 90, 130, 40);

        jTable_Display_Orders.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTable_Display_Orders.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "OrderId", "CustomerId", "TailorId", "Date_of_order", "Deadline", "Complete", "Emergency"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable_Display_Orders.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_Display_OrdersMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_Display_Orders);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(40, 220, 780, 250);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tailordbconnect/rsz_1back_small.png"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel2);
        jLabel2.setBounds(20, 630, 77, 40);

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setText("Exit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(780, 10, 67, 31);

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Your tailor ID:");
        jLabel3.setOpaque(true);
        jPanel1.add(jLabel3);
        jLabel3.setBounds(280, 90, 160, 40);

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tailordbconnect/logout-md.jpg"))); // NOI18N
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel4);
        jLabel4.setBounds(740, 640, 110, 40);

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("All List of Orders");
        jLabel5.setOpaque(true);
        jPanel1.add(jLabel5);
        jLabel5.setBounds(300, 10, 250, 60);

        jLabel6.setBackground(new java.awt.Color(0, 0, 0));
        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Search by:");
        jLabel6.setOpaque(true);
        jPanel1.add(jLabel6);
        jLabel6.setBounds(150, 150, 160, 30);

        jTextField2.setBackground(new java.awt.Color(0, 0, 0));
        jTextField2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(255, 255, 255));
        jTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(jTextField2);
        jTextField2.setBounds(480, 150, 160, 30);

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setText("Search");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(640, 150, 130, 30);

        jComboBox1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jComboBox1.setMaximumRowCount(10);
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Full list", "OrderID", "CustomerID", "Not Completed", "Emergency", "Party Dress", "Casual Dress", " " }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBox1);
        jComboBox1.setBounds(310, 150, 150, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tailordbconnect/tailor.jpeg"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 860, 890);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 859, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 690, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
           System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        dispose();
        TailorOrders to = new TailorOrders();
        to.jTextField1.setText(jTextField1.getText());
        to.setVisible(true);
        
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        dispose();
        new TailorDBsigninjFrame().setVisible(true);
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jTable_Display_OrdersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_Display_OrdersMouseClicked
       table_selected_item();
    }//GEN-LAST:event_jTable_Display_OrdersMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        DefaultTableModel model = (DefaultTableModel) jTable_Display_Orders.getModel();
        int rowCount = model.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            model.removeRow(i);
        }
        ArrayList<Orders> orderList = new ArrayList();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=TailorDBproject;selectMethod=cursor", "sa", "123456");
            Statement statement = connection.createStatement();
            if ((jComboBox1.getSelectedItem().toString()).equals("OrderID")) {
                ResultSet resultSet = statement.executeQuery("SELECT * FROM Orders WHERE OrderID = " + Integer.parseInt(jTextField2.getText()) + " and TailorId = " + jTextField1.getText() + "");
                while (resultSet.next()) {
                    Orders orders;
                    orders = new Orders(resultSet.getInt("OrderID"), resultSet.getInt("CustomerId"), resultSet.getInt("TailorId"), resultSet.getDate("OrderDate").toString(), resultSet.getDate("CompletingDate").toString(), resultSet.getString("Completed"), resultSet.getString("Emergency_make"), resultSet.getBytes("Image"));
                    orderList.add(orders);
                    ArrayList<Orders> list = orderList;

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
                    orderList.clear();
                }
            } else if ((jComboBox1.getSelectedItem().toString()).equals("CustomerID")) {
                ResultSet resultSet = statement.executeQuery("SELECT * FROM Orders WHERE CustomerId = " + Integer.parseInt(jTextField2.getText()) + " and TailorId = " + jTextField1.getText() + "");
                while (resultSet.next()) {
                    Orders orders;
                    orders = new Orders(resultSet.getInt("OrderID"), resultSet.getInt("CustomerId"), resultSet.getInt("TailorId"), resultSet.getDate("OrderDate").toString(), resultSet.getDate("CompletingDate").toString(), resultSet.getString("Completed"), resultSet.getString("Emergency_make"), resultSet.getBytes("Image"));
                    orderList.add(orders);
                    ArrayList<Orders> list = orderList;

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
                    orderList.clear();

                }
            } else if ((jComboBox1.getSelectedItem().toString()).equals("Emergency")) {
                ResultSet resultSet = statement.executeQuery("SELECT * FROM Orders WHERE Emergency_make = 'YES' and TailorId = " + jTextField1.getText() + "");
                while (resultSet.next()) {
                    Orders orders;
                    orders = new Orders(resultSet.getInt("OrderID"), resultSet.getInt("CustomerId"), resultSet.getInt("TailorId"), resultSet.getDate("OrderDate").toString(), resultSet.getDate("CompletingDate").toString(), resultSet.getString("Completed"), resultSet.getString("Emergency_make"), resultSet.getBytes("Image"));
                    orderList.add(orders);
                    ArrayList<Orders> list = orderList;

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
                    orderList.clear();
                }

            } else if ((jComboBox1.getSelectedItem().toString()).equals("Not Completed")) {
                ResultSet resultSet = statement.executeQuery("SELECT * FROM Orders WHERE Completed = 'NO' and TailorId = " + jTextField1.getText() + "");
                while (resultSet.next()) {
                    Orders orders;
                    orders = new Orders(resultSet.getInt("OrderID"), resultSet.getInt("CustomerId"), resultSet.getInt("TailorId"), resultSet.getDate("OrderDate").toString(), resultSet.getDate("CompletingDate").toString(), resultSet.getString("Completed"), resultSet.getString("Emergency_make"), resultSet.getBytes("Image"));
                    orderList.add(orders);
                    ArrayList<Orders> list = orderList;

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
                    orderList.clear();
                }
            }
                else if((jComboBox1.getSelectedItem().toString()).equals("Party Dress")){
                    ResultSet resultSet = statement.executeQuery("SELECT * FROM Orders WHERE Party_Casual = 'Party' and TailorId = "+jTextField1.getText()+"");
                    while (resultSet.next()) {
                        Orders orders;
                            orders = new Orders(resultSet.getInt("OrderID"), resultSet.getInt("CustomerId"), resultSet.getInt("TailorId"), resultSet.getDate("OrderDate").toString(), resultSet.getDate("CompletingDate").toString(), resultSet.getString("Completed"), resultSet.getString("Emergency_make"), resultSet.getBytes("Image"));
                            orderList.add(orders);
                            ArrayList<Orders> list = orderList;

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
                            orderList.clear();
                    }
                }
                 else if((jComboBox1.getSelectedItem().toString()).equals("Casual Dress")){
                    ResultSet resultSet = statement.executeQuery("SELECT * FROM Orders WHERE Party_Casual = 'Casual' and TailorId = "+jTextField1.getText()+"");
                    while (resultSet.next()) {
                        Orders orders;
                            orders = new Orders(resultSet.getInt("OrderID"), resultSet.getInt("CustomerId"), resultSet.getInt("TailorId"), resultSet.getDate("OrderDate").toString(), resultSet.getDate("CompletingDate").toString(), resultSet.getString("Completed"), resultSet.getString("Emergency_make"), resultSet.getBytes("Image"));
                            orderList.add(orders);
                            ArrayList<Orders> list = orderList;

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
                            orderList.clear();
                    }
                }
                 else if((jComboBox1.getSelectedItem().toString()).equals("Full list")){
                     ResultSet resultSet = statement.executeQuery("SELECT * FROM Orders WHERE TailorId ="+Integer.parseInt(jTextField1.getText())+"");
                    while (resultSet.next()) {
                        Orders orders;
                            orders = new Orders(resultSet.getInt("OrderID"), resultSet.getInt("CustomerId"), resultSet.getInt("TailorId"), resultSet.getDate("OrderDate").toString(), resultSet.getDate("CompletingDate").toString(), resultSet.getString("Completed"), resultSet.getString("Emergency_make"), resultSet.getBytes("Image"));
                            orderList.add(orders);
                            ArrayList<Orders> list = orderList;

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
                            orderList.clear();
                    }
                 }
            } catch (Exception e) {
                e.printStackTrace();
            }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        if(jComboBox1.getSelectedItem().equals("OrderID")){
            jTextField2.setVisible(true);
        }
        else if(jComboBox1.getSelectedItem().equals("CustomerID")){
             jTextField2.setVisible(true);
        }
        else if(jComboBox1.getSelectedItem().equals("Emergency")){
             jTextField2.setVisible(false);
        }
        else if(jComboBox1.getSelectedItem().equals("Not Completed")){
             jTextField2.setVisible(false);
        }
        else if(jComboBox1.getSelectedItem().equals("Full list")){
             jTextField2.setVisible(false);
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

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
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jTable_Display_Orders;
    public javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
