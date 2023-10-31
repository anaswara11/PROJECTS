package BLOODBANK1;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class DeleteDonor {
   private JFrame mainFrame;
   private JLabel headerLabel;
   private JPanel controlPanel;
   private JLabel id,name,price,quantity;
   private static int count = 0;
   GridLayout experimentLayout = new GridLayout(1,1);
    ResultSet rs;
   public static void main(String[] args){
      UpdateDonor  swingControlDemo = new UpdateDonor();
      swingControlDemo.showButtonDemo();
   }
   private void prepareGUI(){
      mainFrame = new JFrame("Delete Donor Details");
      mainFrame.setSize(700,400);
	  mainFrame.getContentPane().setBackground(Color.red);
      mainFrame.setLayout(new GridLayout(3, 1));
      mainFrame.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
            mainFrame.setVisible(false);
            try{
                pst = con.mkDataBase().prepareStatement("DELETE FROM bloodbankmanagement where name = ?");
                pst.setString(1,tf2.getText());
               pst.execute();
                JOptionPane.showMessageDialog(null, "Item Deleted " + tf2.getText());
                mainFrame.setVisible(false);
            }catch(Exception ex){
                System.out.println(ex);
                System.out.println("EEEE");
                JOptionPane.showMessageDialog(null, "Item not found : " + tf2.getText());
            }finally{
                
            }
         }
      });
      headerLabel = new JLabel("", JLabel.CENTER);
      controlPanel = new JPanel();
      controlPanel.setLayout(new FlowLayout());
      mainFrame.add(headerLabel);
      mainFrame.add(controlPanel);
      mainFrame.setVisible(true);
   }
   public void showButtonDemo(){
		headerLabel.setText("Blood Bank Management System");
		headerLabel.setFont(new Font(null, Font.BOLD, 27));
		headerLabel.setForeground(Color.white);
        name = new JLabel("Enter Donor Name");
        JTextField tf2=new JTextField();
        tf2.setSize(100,30);
        JButton okButton = new JButton("DELETE");
      okButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            PreparedStatement pst;
            DBConnection con = new DBConnection();
            try{
                pst = con.mkDataBase().prepareStatement("DELETE FROM bloodbankmanagement where name = ?");
                pst.setString(1,tf2.getText());
               pst.execute();
                JOptionPane.showMessageDialog(null, "Item Deleted " + tf2.getText());
                mainFrame.setVisible(false);
            }catch(Exception ex){
                System.out.println(ex);
                System.out.println("EEEE");
                JOptionPane.showMessageDialog(null, "Item not found : " + tf2.getText());
            }finally{
                
            }
         }
      });
      JPanel jp = new JPanel();
      jp.add(name);
      jp.add(tf2);
      jp.setSize(700,400);
      jp.setLayout(experimentLayout);
      controlPanel.add(jp);
      jp.add(okButton);
      mainFrame.setVisible(true);
	  mainFrame.setLocationRelativeTo(null);
   }
}