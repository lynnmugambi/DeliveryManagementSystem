/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deliverymanagementsystem;

import java.sql.*;
import javax.swing.*;

public class jdbc {
Connection conn = null;
 
public static Connection sqlite(){
try{

    Class.forName("org.sqlite.JDBC");
    Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\db\\Main");
    System.out.println("Connection Established");
    return conn;   
}

catch(ClassNotFoundException | SQLException e){
    JOptionPane.showMessageDialog(null, e);
}

return null;
}


public static void main(String args[])
{
    jdbc.sqlite();
}

}

