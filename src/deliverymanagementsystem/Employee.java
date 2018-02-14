/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deliverymanagementsystem;


import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class Employee {
    Connection conn;
    PreparedStatement pst;
    ResultSet rs;
    
    
    //register
    private String typeuser;
    private String firstname;
    private String lastname;
    private String ictxt;
    private String gender;
    private String phoneno;
    private String email;
    private String username;
    private String password;

    public Employee() {
        this.conn = jdbc.sqlite();
    }

   
    
    public void registerStaff(){
        
        try{
            
            
            if(getTypeuser().equals("Clerk")){
                   String sql = "Insert into ClerkDetails(FirstName,LastName,IdentityCardNo,Gender,Phone,Email,Username,Password)values(?,?,?,?,?,?,?,?)";
                   
                   
                   pst = conn.prepareStatement(sql);
                   pst.setString(1,firstname);
                   pst.setString(2,lastname);
                   pst.setString(3,ictxt);
                   pst.setString(4,gender);
                   pst.setString(5,phoneno);
                   pst.setString(6,email);
                   pst.setString(7,username);
                   pst.setString(8,password);
                   
                   pst.execute();
                   pst.close();
                   JOptionPane.showMessageDialog(null, "Saved!");
            }
            else{
                 String sql = "Insert into ManagerDetails(FirstName,LastName,IdentityCardNo,Gender,Phone,Email,Username,Password)values(?,?,?,?,?,?,?,?)";
                  
                 
                  pst = conn.prepareStatement(sql);
                   pst.setString(1,firstname);
                   pst.setString(2,lastname);
                   pst.setString(3,ictxt);
                   pst.setString(4,gender);
                   pst.setString(5,phoneno);
                   pst.setString(6,email);
                   pst.setString(7,username);
                   pst.setString(8,password);
                   
                   pst.execute();
                   pst.close();
                   JOptionPane.showMessageDialog(null, "Saved!");
            }
            }
            
        catch(Exception e){
        JOptionPane.showMessageDialog(null, e);
       
        }
    }
    public void generateDaily(String date, JTable dailyreportTable){
    
    try{
    
    DefaultTableModel model = (DefaultTableModel)dailyreportTable.getModel();
    String sql = "Select Currentdate,SUM(Amount) AS sum,COUNT(OrderNo) AS orders from OrderDetails where Currentdate=?";
    pst = conn.prepareStatement(sql);
    
    pst.setString(1,date);
    
    rs=pst.executeQuery();
    
    while(rs.next()){
         dailyreportTable.setModel(model); 
        
        model.addRow(new Object [] {
            rs.getString("Currentdate"),
            rs.getString("sum"),
            rs.getString("orders"), 
            });
        
    }
    JOptionPane.showMessageDialog(null, "Data found!");
            pst.execute();
            pst.close();
    }
    catch(Exception e){
        e.printStackTrace();
    }
    
    finally{
            try{
                pst.close();
                
            }
            catch(Exception e ){
            }
        }
    }
    

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }
    
    String month;
    
    public void generateMonthly(String month, JTable monthlyreport){
    
    try{
    
    DefaultTableModel model = (DefaultTableModel)monthlyreport.getModel();
    String sql = "Select Month,SUM(Amount) AS sum,COUNT(OrderNo) AS orders from OrderDetails where Month=?";
    pst = conn.prepareStatement(sql);
    
    pst.setString(1,month);
    
    rs=pst.executeQuery();
    
    while(rs.next()){
         monthlyreport.setModel(model); 
        
        model.addRow(new Object [] {
            rs.getString("Month"),
            rs.getString("orders"), 
            rs.getString("sum"),
            });
        
    }
    JOptionPane.showMessageDialog(null, "Data found!");
            pst.execute();
            pst.close();
    }
    catch(Exception e){
        e.printStackTrace();
    }
    
    finally{
            try{
                pst.close();
                
            }
            catch(Exception e ){
            }
        }
    }    
    public String getFirstname() {
    return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getIctxt() {
        return ictxt;
    }

    public void setIctxt(String ictxt) {
        this.ictxt = ictxt;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
            
           
    public String getTypeuser() {
        return typeuser;
    }

    public void setTypeuser(String typeuser) {
        this.typeuser = typeuser;
    }

   
    
    //admin login
    private String NameField;
    private String PasswordField;

    
    public void adminLogin(){
          
        try{
           
        String sql ="select * from AdminLogin where Username=? and Password=?";
        
        
        pst = conn.prepareStatement(sql);
        pst.setString(1,getNameField());
        pst.setString(2,getPasswordField());
     
        rs = pst.executeQuery();
        
        if(rs.next()){
            JOptionPane.showMessageDialog(null, "Login Succcessful");
            
            pst.close();
            new AdminMenu().setVisible(true);
            new AdminLoginFrame().dispose();
            }
        else {
        }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "One of the fields is empty!");
            e.printStackTrace();
        } 
         finally{
                try{
                pst.close();
                
                }
                catch(Exception e ){
                }
                }
    }    
        public String getNameField() {
        return NameField;
    }

    public void setNameField(String NameField) {
        this.NameField = NameField;
    }

    public String getPasswordField() {
        return PasswordField;
    }

    public void setPasswordField(String PasswordField) {
        this.PasswordField = PasswordField;
    }
    
    
    //Clerk Login
    public void clerkLogin(){
      String sql ="select * from ClerkDetails where Username=? and Password=?";
        try{
        pst = conn.prepareStatement(sql);
        pst.setString(1,getNameField());
        pst.setString(2,getPasswordField());
     
        rs = pst.executeQuery();
        if(rs.next()){
            JOptionPane.showMessageDialog(null, "Login Succcessful");
            new DeliverySystem().setVisible(true);
            new ClerkLoginFrame().dispose();
            pst.close();
            
        }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
         finally{
                try{
                pst.close();
                
                }
                catch(Exception e ){
                }
                }
    } 
    
    //manager Login
    
    public void managerLogin(){
    String sql ="select * from ManagerDetails where Username=? and Password=?";
        try{
        pst = conn.prepareStatement(sql);
        pst.setString(1,NameField);
        pst.setString(2,PasswordField);
     
        rs = pst.executeQuery();
        if(rs.next()){
            JOptionPane.showMessageDialog(null, "Login Succcessful");
            new ManagerMenu().setVisible(true);
            new ManagerLoginFrame().dispose();
            pst.close();
                
        }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
         finally{
                try{
                pst.close();
                
                }
                catch(Exception e ){
                }
                }
    }
}
