package BLOODBANK1;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class UpdatDonor {
   private JFrame mainFrame;
   private JLabel headerLabel;
   private JLabel statusLabel;
   private JPanel controlPanel;
   private JLabel id,name,price,quantity;
   private static int count = 0;
   GridLayout experimentLayout = new GridLayout(0,2);
    ResultSet rs;
    
   public static void main(String[] args){
      UpdateDonor  swingControlDemo = new UpdateDonor();
      swingControlDemo.showButtonDemo();
   }
   private void prepareGUI(){
      mainFrame = new JFrame("Update Donor Details");
      mainFrame.setSize(700,400);
      mainFrame.setLayout(new GridLayout(3, 1));
	  mainFrame.getContentPane().setBackground(Color.red);
      mainFrame.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
            mainFrame.setVisible(false);
         }
      });
      headerLabel = new JLabel("", JLabel.CENTER);
      statusLabel = new JLabel("",JLabel.CENTER);
      statusLabel.setSize(350,400);
      controlPanel = new JPanel();
      controlPanel.setLayout(new FlowLayout());
      mainFrame.add(headerLabel);
      mainFrame.add(controlPanel);
      mainFrame.add(statusLabel);
      mainFrame.setVisible(true);
   }
   public void showButtonDemo(){
      headerLabel.setText("Blood Bank Management System");
	  headerLabel.setFont(new Font(null, Font.BOLD, 27));
	  headerLabel.setForeground(Color.white);
        name = new JLabel("Enter Donor Name");
        JTextField tf2=new JTextField();
        tf2.setSize(100,30);
        price = new JLabel("Enter Blood Group");
        JTextField tf3=new JTextField();
        tf3.setSize(100,30);
        quantity = new JLabel("Enter Quantity");
        JTextField tf4=new JTextField();
        tf4.setSize(100,30);
        JButton okButton = new JButton("UPDATE");
      okButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            PreparedStatement pst;
            DBConnection con = new DBConnection();
            try{
                pst = con.mkDataBase().prepareStatement("UPDATE bloodbankmanagement SET quantity= ?, bloodgroup=? where name = ?");
                pst.setString(3, tf2.getText());
                pst.setDouble(2, Double.parseDouble(tf3.getText()));
                pst.setInt(1, Integer.parseInt(tf4.getText()));
                pst.execute();
                JOptionPane.showMessageDialog(null, "Done Updating " + tf2.getText());
                mainFrame.setVisible(false);
                
            }catch(Exception ex){
                System.out.println(ex);
                System.out.println("Error");
                JOptionPane.showMessageDialog(null, "Inserting Error : " + tf2.getText());
            }finally{
                
            }
         }
      });
      JPanel jp = new JPanel();
      jp.add(name);
      jp.add(tf2);
      jp.add(bloodgroup);
      jp.add(tf3);
      jp.add(quantity);
      jp.add(tf4);
      jp.setSize(200,200);
      jp.setLayout(experimentLayout);
      controlPanel.add(jp);
      jp.add(okButton);
      mainFrame.setVisible(true);
	  mainFrame.setLocationRelativeTo(null);
   }
}