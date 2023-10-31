package BLOODBANK1;

import java.awt.*;
import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.colorchooser.AbstractColorChooserPanel;
public class Login extends JFrame{
    JLabel idLabel;
    JLabel passLabel;
	JLabel background;
	JLabel headerLabel;
	JLabel devInfo;
    JTextField id;
    JPasswordField pass;
    JButton submit;
   public Login(){
		setTitle("Blood Bank Management System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		this.background = new JLabel(new ImageIcon(""));
		this.init();
		add(background);
		background.setVisible(true);  
        this.pack();
		this.setSize(700,400);
		this.setLocationRelativeTo(null);
    }
    public void init(){
		headerLabel = new JLabel();
		this.headerLabel.setText("Blood Bank Management System");
		this.headerLabel.setBounds(190,1,370,150);
		this.headerLabel.setFont(new Font("Geomanist", Font.BOLD, 20));
		headerLabel.setForeground(Color.red);
		add(headerLabel);
		idLabel = new JLabel();
		this.idLabel.setText("Username");
		this.idLabel.setBounds(190,110,100,50);
		this.idLabel.setFont(new Font(null, Font.BOLD, 20));
		idLabel.setForeground(Color.black);
		add(idLabel);
        passLabel=new JLabel("Password");
		this.passLabel.setBounds(190,165,100,50);
		this.passLabel.setFont(new Font(null, Font.BOLD, 20));
		passLabel.setForeground(Color.black);
		add(passLabel);
		devInfo = new JLabel();
		this.devInfo.setText("");
		this.devInfo.setBounds(130,300,1000,30);
		this.devInfo.setFont(new Font("Geomanist", Font.PLAIN, 15));
		devInfo.setForeground(Color.white);
		add(devInfo);
		id=new JTextField();
		this.id.setBounds(300,125,200,30);
		add(id);
		pass=new JPasswordField();
		this.add(pass);
		this.pass.setBounds(300,175,200,30);
		this.id.setVisible(true);
       this.submit=new JButton("Login");
	   this.submit.setBounds(400,230,100,25);
	   add(submit);
       submit.addActionListener(this::submitActionPerformed);
       id=new JTextField();
		this.id.setBounds(300,125,200,30);
		add(id);
		pass=new JPasswordField();
		this.add(pass);
		this.pass.setBounds(300,175,200,30);
		this.id.setVisible(true);
       this.submit=new JButton("Login");
	   this.submit.setBounds(400,230,100,25);
	   add(submit);
       submit.addActionListener(this::submitActionPerformed);
    } 
public class DBConnection {
    public Connection con;
    String url ="jdbc:mysql://localhost:3306/bloodbankmanagement";
    String db = "Bloodbank1";
    String user = "root";
    String pass = "";
    
    public Connection mkDataBase() throws SQLException{
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
}
   public void submitActionPerformed(java.awt.event.ActionEvent evt){
   if(id.getText().equals("admin1") && pass.getText().equals("admin1")){
     this.hide();
     Frame2new fn=new Frame2new();
     fn.showButtonDemo();
   }
   else{
    JOptionPane.showMessageDialog(null, "Invalid password!");
   }
   }
}
