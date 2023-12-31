/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.awt.Component;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

public class SearchInfo extends javax.swing.JFrame {

    
   String Area;
   String Group;

    public SearchInfo(String Area, String Group) {
        try{
        initComponents();
       
        setTitle("Search Result Page");
        this.Area = Area;
        this.Group = Group;
        System.out.println(this.Area );
        System.out.println(this.Group);
         String sql = "SELECT * FROM `regdoner` WHERE `BLOOD_GROUP` = \""+ this.Group +"\" AND `AREA` = \""+this.Area+"\""; 
          DefaultTableModel dft = (DefaultTableModel)SearchTable.getModel();
            Class.forName("com.mysql.jdbc.Driver");    
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost/blooddonation","root","");  
       
            Statement stmt=con.createStatement();  
            ResultSet rs=stmt.executeQuery(sql); 
            
            
            while(rs.next())  {
               String s = rs.getString(2)+"<>"+ rs.getString(3)+"<>"+ rs.getString(6)+"<>"+ rs.getString(8);
               String[] raw = s.split("<>");
               dft.addRow(raw);
            }
                con.close();  
            }catch(Exception e){ 
                System.out.println(e);
            }  
    }
    
    
    /**
     * Creates new form SearchInfo
     */
    public SearchInfo() {

        initComponents();
        setTitle("Search Result Page");
        connect();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        SearchPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        SearchTable = new javax.swing.JTable();
        ReturnButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        SearchPanel.setPreferredSize(new java.awt.Dimension(766, 630));

        SearchTable.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        SearchTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Sex", "Blood Group", "Contact NO"
            }
        ));
        jScrollPane1.setViewportView(SearchTable);

        ReturnButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        ReturnButton.setText("Return");
        ReturnButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReturnButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout SearchPanelLayout = new javax.swing.GroupLayout(SearchPanel);
        SearchPanel.setLayout(SearchPanelLayout);
        SearchPanelLayout.setHorizontalGroup(
            SearchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SearchPanelLayout.createSequentialGroup()
                .addGap(0, 608, Short.MAX_VALUE)
                .addComponent(ReturnButton, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
            .addGroup(SearchPanelLayout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        SearchPanelLayout.setVerticalGroup(
            SearchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SearchPanelLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 541, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(ReturnButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(SearchPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(SearchPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void connect() {
        String query;
        query = " SELECT NAME,AREA,BLOOD_GROUP,MOBILE_NO from ADMIN1.BLOODINFO where STATUS='true' and BLOOD_GROUP = '" + Variables.BloodGroup + "'" + "and AREA ='" + Variables.Address + "'";

        try {

            Variables.myconnectionobj = DriverManager.getConnection("jdbc:derby://localhost:1527/BloodBank1", "admin1", "admin");
            Variables.mystatementobj = Variables.myconnectionobj.createStatement();
            Variables.my = Variables.mystatementobj.executeQuery(query);
            SearchTable.setModel(DbUtils.resultSetToTableModel(Variables.my));

        } catch (SQLException ex) {
            //ex.printStackTrace();
        }
    }
    private void ReturnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReturnButtonActionPerformed
        // TODO add your handling code here:
        Search one = new Search();
        one.setVisible(true);
        dispose();
    }//GEN-LAST:event_ReturnButtonActionPerformed

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
            java.util.logging.Logger.getLogger(SearchInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SearchInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SearchInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SearchInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SearchInfo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ReturnButton;
    private javax.swing.JPanel SearchPanel;
    private javax.swing.JTable SearchTable;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
