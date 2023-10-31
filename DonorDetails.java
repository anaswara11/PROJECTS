package BLOODBANK1;


import java.awt.*;
import java.awt.event.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;
public class DonorDetails {
   private JFrame mainFrame;
   private JLabel headerLabel;
   private JPanel controlPanel;
   public static void main(String[] args) throws SQLException{
      ItemInfo  swingControlDemo = new ItemInfo();
      swingControlDemo.showButtonDemo();
   }
   private void prepareGUI(){
      mainFrame = new JFrame("Donor Details");
      mainFrame.setSize(700,400);
	  mainFrame.getContentPane().setBackground(Color.red);
      mainFrame.setLayout(new FlowLayout());
      mainFrame.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
         }
      });
      headerLabel = new JLabel("", JLabel.CENTER);
      controlPanel = new JPanel();
      controlPanel.setSize(700,400);
      controlPanel.setLayout(new FlowLayout());
      mainFrame.add(headerLabel);
      mainFrame.add(controlPanel);
      //mainFrame.add(statusLabel);
      mainFrame.setVisible(true);
   }
   public void showButtonDemo() throws SQLException{
      headerLabel.setText("Blood Bank Management System");
	  headerLabel.setFont(new Font(null, Font.BOLD, 25));
      String[] columnNames = {"Donor ID","Donor Name",
                        "Blood Group",
                        "Quantity"
                        };
      Object[][] data = new Object[100][4];
      
     PreparedStatement pst;
       ResultSet rs;
            DBConnection con = new DBConnection();
            try{
                pst = con.mkDataBase().prepareStatement("select * from bloodbankmanagement");
                rs = pst.executeQuery();
                int i=0;
                while(rs.next()){
                    data[i][0] = rs.getInt("id");
                    data[i][1] = rs.getString("name");
                    data[i][2] = rs.getDouble("bloodgroup");
                    data[i][3] =  rs.getInt("quantity");
                    i++;
                }
                mainFrame.setVisible(false);
            }catch(Exception ex){
                System.out.println(ex);
                System.out.println("Error");
                JOptionPane.showMessageDialog(null, "Error !");
            }
        JTable table = new JTable(data, columnNames);
        table.setSize(400, 400);
		table.setVisible(true);
	  //  table.setEnabled(false);
      controlPanel.add(new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER));
      //controlPanel.add(table);
      mainFrame.setVisible(true);
	  mainFrame.setLocationRelativeTo(null);
	  JTable table = new JTable(data, columnNames);
        table.setSize(400, 400);
		table.setVisible(true);
	  //  table.setEnabled(false);
      controlPanel.add(new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER));
      //controlPanel.add(table);
      mainFrame.setVisible(true);
	  mainFrame.setLocationRelativeTo(null);
   }
   
   JLabel totalP = new JLabel();
   Object data[][] = new Object[100][3];
   int i = 0;
   ViewDonor(){
       JPanel jp1 = new JPanel();
		setBackground(Color.red);
		//jp1.getContentPane().setBackground(Color.orange);
       this.setLayout(new GridLayout(2,2));
       JLabel a = new JLabel("Donor Name : ");
       jp1.add(a);
       JLabel b = new JLabel("Quantity : ");
       jp1.add(b);
       quantity = new JTextField(50);
       jp1.add(quantity);
       JButton ok = new JButton("OK");
       JPanel jp2 = new JPanel();
       jp2.setSize(700, 400);
       jp1.add(ok);
       ok.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            PreparedStatement pst;
            DBConnection con = new DBConnection();
            ResultSet rs;
            try{
                pst = con.mkDataBase().prepareStatement("select f_prize from bloodbankmanagement where name = ?");
                pst.setString(1, f.getText());
                rs = pst.executeQuery();
            }
            catch(Exception ex){
                System.out.println(ex);
            }
         }
      });
//       jp2.setLayout(new GridLayout(1,1));
       jp2.setLayout(new FlowLayout());
       jp2.add(totalP);
       jp2.add(new JScrollPane(cart, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER));
       addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
             int count = 1;
            double vat = 15;
         }
      });
       this.add(jp1);
       this.add(jp2);
       this.setSize(600,550);
	    this.setLocationRelativeTo(null);
       this.setVisible(true);
   }
}
}
