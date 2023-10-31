package BLOODBANK1;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import java.awt.Color;
public class Home {
   private JFrame mainFrame;
   private JLabel headerLabel;
   private JLabel statusLabel;
   private JPanel controlPanel;
   public static void main(String[] args){
      Frame2new  swingControlDemo = new Frame2new();
      swingControlDemo.showButtonDemo();
   }
   private void prepareGUI(){
      mainFrame = new JFrame("Blood Bank Management System");
      mainFrame.setBounds(100,100,700,400);
      mainFrame.setLayout(new GridLayout(3,1));
	 mainFrame.getContentPane().setBackground(Color.red);
      mainFrame.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
            System.exit(0);
         }
      });
      headerLabel = new JLabel("", JLabel.CENTER);
      statusLabel = new JLabel("",JLabel.CENTER);
      statusLabel.setSize(350,300);
      controlPanel = new JPanel();
      controlPanel.setLayout(new GridLayout(1,5));
      mainFrame.add(headerLabel);
      mainFrame.add(controlPanel);
      mainFrame.add(statusLabel);
      mainFrame.setVisible(true);
   }
   
   public void showButtonDemo(){
		headerLabel.setText("Blood Bank Management System");
		this.headerLabel.setFont(new Font(null, Font.BOLD, 27));
		headerLabel.setForeground(Color.white);
		JButton fkButton = new JButton("Donors");
		JButton billButton = new JButton("Blood Donations");
		JButton afButton = new JButton("Add Donor");
		JButton ufButton = new JButton("Update Donor");
		JButton dlButton = new JButton("Delete Donor");
        fkButton.addActionListener(new ActionListener()
{
         public void actionPerformed(ActionEvent e) {
           ItemInfo ii=new ItemInfo();
             try {
                 ii.showButtonDemo();
             } catch (SQLException ex) {
                 Logger.getLogger(Frame2new.class.getName()).log(Level.SEVERE, null, ex);
             }
         }
});
      controlPanel.add(ufButton);
      controlPanel.add(afButton);
	  controlPanel.add(billButton);
      controlPanel.add(fkButton);
	  controlPanel.add(dlButton);
      mainFrame.setVisible(true);
	  mainFrame.setLocationRelativeTo(null);
   }
   
   public void viewButtonDemo(){
		headerLabel.setText("Blood Bank Management System");
		this.headerLabel.setFont(new Font(null, Font.BOLD, 27));
		headerLabel.setForeground(Color.white);
		JButton fkButton = new JButton("Donors");
		JButton billButton = new JButton("Blood Donations");
		JButton afButton = new JButton("Add Donor");
		JButton ufButton = new JButton("Update Donor");
		JButton dlButton = new JButton("Delete Donor");
        fkButton.addActionListener(new ActionListener()
{
         public void actionPerformed(ActionEvent e) {
           ItemInfo ii=new ItemInfo();
             try {
                 ii.showButtonDemo();
             } catch (SQLException ex) {
                 Logger.getLogger(Frame2new.class.getName()).log(Level.SEVERE, null, ex);
             }
         }
});
}

