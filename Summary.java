
package project;

import java.awt.Component;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import javax.swing.table.DefaultTableModel;
import java.awt.Component;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

public class Summary extends javax.swing.JFrame {

    public Summary() {
        initComponents();
        setTitle("Summry Page");
        try{
            DefaultTableModel dft = (DefaultTableModel)BLOODINFO1.getModel();
            Class.forName("com.mysql.jdbc.Driver");  
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost/blooddonation","root","");  
       
            Statement stmt=con.createStatement();  
            ResultSet rs=stmt.executeQuery("SELECT * FROM `regdoner`"); 
            
            while(rs.next())  {
               String s = rs.getString(2)+"<>"+rs.getString(3) +"<>"+ rs.getString(4)+"<>"+rs.getString(5) +"<>"+ rs.getString(6)+"<>"+rs.getString(7) +"<>"+ rs.getString(8)+"<>"+rs.getString(9);
               String[] raw = s.split("<>");
               dft.addRow(raw);
            }
                con.close();  
            }catch(Exception e){ 
                System.out.println(e);
            }  

        
    }

    public void connect() {

        String query = "select * from ADMIN1.BLOODINFO order by ID";

        try {
            Variables.myconnectionobj = DriverManager.getConnection("jdbc:derby://localhost:1527/BloodBank1", "admin1", "admin");
            Variables.mystatementobj = Variables.myconnectionobj.createStatement();
            Variables.my = Variables.mystatementobj.executeQuery(query);
            BLOODINFO1.setModel(DbUtils.resultSetToTableModel(Variables.my));

        } catch (SQLException ex) {
            //ex.printStackTrace();
        }

    }

    public void Active() {
        try {
            java.util.Date date = new java.util.Date();

            SimpleDateFormat ft = new SimpleDateFormat("YYYY-MM-dd");
            String dateCheck = ft.format(date);
            Variables.myconnectionobj = DriverManager.getConnection("jdbc:derby://localhost:1527/BloodBank1", "admin1", "admin");
            String sql = "update ADMIN1.BLOODINFO set STATUS ='true'where STATUS ='false' and NEXT_DATE_OF_DONATION <= '" + dateCheck + "'";
            Variables.mystatementobj = Variables.myconnectionobj.createStatement();

            Variables.mystatementobj.executeUpdate(sql);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        connect();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Summary = new javax.swing.JPanel();
        Return = new javax.swing.JButton();
        UpdateInfo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        BLOODINFO1 = new javax.swing.JTable();
        DELETE = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Summary.setPreferredSize(new java.awt.Dimension(942, 630));

        Return.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Return.setText("Return");
        Return.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReturnActionPerformed(evt);
            }
        });

        UpdateInfo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        UpdateInfo.setText("Update Info");
        UpdateInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateInfoActionPerformed(evt);
            }
        });

        BLOODINFO1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Sex", "Date Of Birth", "Area", "Group", "last Date Of Donation", "Mobile No", "Next Donation date"
            }
        ));
        jScrollPane1.setViewportView(BLOODINFO1);

        DELETE.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        DELETE.setText("Delete");
        DELETE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DELETEActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout SummaryLayout = new javax.swing.GroupLayout(Summary);
        Summary.setLayout(SummaryLayout);
        SummaryLayout.setHorizontalGroup(
            SummaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SummaryLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 942, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SummaryLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(DELETE, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(Return, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(UpdateInfo)
                .addGap(42, 42, 42))
        );
        SummaryLayout.setVerticalGroup(
            SummaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SummaryLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 567, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(SummaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DELETE)
                    .addComponent(Return)
                    .addComponent(UpdateInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(Summary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Summary, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 656, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReturnActionPerformed
        // TODO add your handling code here:
        Summary.setVisible(false);
        FristPage third = new FristPage();
        third.setVisible(true);
        dispose();

    }//GEN-LAST:event_ReturnActionPerformed

    private void UpdateInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateInfoActionPerformed
        // TODO add your handling code here:
        UpdateInfo one = new UpdateInfo();
        one.setVisible(true);
        dispose();
    }//GEN-LAST:event_UpdateInfoActionPerformed

    private void DELETEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DELETEActionPerformed
        // TODO add your handling code here:
        int flag = 0;
       
        String ID = JOptionPane.showInputDialog("Enter ID:");
        try {
            Class.forName("com.mysql.jdbc.Driver");  
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost/blooddonation","root","");  
            //here sonoo is database name, root is username and password  
            PreparedStatement stmt=con.prepareStatement("DELETE FROM `regdoner` WHERE `ID` = ?");
            stmt.setString(1, ID);

            int i=stmt.executeUpdate();  
            System.out.println(i+" records inserted");  
            con.close(); 
            DefaultTableModel model = (DefaultTableModel) BLOODINFO1.getModel();
            model.setRowCount(0);
             String sql = "SELECT * FROM `regdoner`"; 
          DefaultTableModel dft = model;
          Class.forName("com.mysql.jdbc.Driver");    
          con=DriverManager.getConnection("jdbc:mysql://localhost/blooddonation","root","");  
       
            Statement stmt_insert=con.createStatement();  
            ResultSet rs=stmt_insert.executeQuery(sql); 
            
            
            while(rs.next())  {
               String s = rs.getString(2)+"<>"+rs.getString(3) +"<>"+ rs.getString(4)+"<>"+rs.getString(5) +"<>"+ rs.getString(6)+"<>"+rs.getString(7) +"<>"+ rs.getString(8)+"<>"+rs.getString(9);
               String[] raw = s.split("<>");
               dft.addRow(raw);
            }
                con.close();  
            
        } catch (Exception e) {
            System.out.println(e);
        }
        
        
        
       /* try {
            
            String sql = "Delete from ADMIN1.BLOODINFO where ID =" + ID;
            Statement add = Variables.myconnectionobj.createStatement();

            add.executeUpdate(sql);
            

        } catch (SQLException e) {

            flag = 1;
        }
        connect();
        if (flag == 0) {

            JOptionPane.showMessageDialog(null, "Successfully Deleted.");
            Variables.ID--;
        } else {
            Component GUI = null;
            JOptionPane.showMessageDialog(GUI, "Unsuccessful. Please try again");
        }
*/
    }//GEN-LAST:event_DELETEActionPerformed

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
            java.util.logging.Logger.getLogger(Summary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Summary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Summary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Summary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Summary().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable BLOODINFO1;
    private javax.swing.JButton DELETE;
    private javax.swing.JButton Return;
    private javax.swing.JPanel Summary;
    private javax.swing.JButton UpdateInfo;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
