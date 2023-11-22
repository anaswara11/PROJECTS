
package project;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Variables {

    static String Address = null;
    static String BloodGroup = null;
    static String Lastdate = null;
    static String Username = "admin";
    static String Password = "password";
    static Connection myconnectionobj = null;
    static Statement mystatementobj = null;
    static ResultSet my = null;
    static  int ID;

    public Variables(String Address, String BloodGroup) {
        Variables.Address = Address;
        Variables.BloodGroup = BloodGroup;

    }

    public static void main(String args[]) {

    }
}
