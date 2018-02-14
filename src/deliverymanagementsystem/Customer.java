/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deliverymanagementsystem;

import java.awt.HeadlessException;
import javax.swing.*;
import java.sql.*;
import java.util.Random;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Mwendwa Mugambi
 */
public class Customer extends delivery_functions{
    /*Connection conn;
    PreparedStatement pst;
    ResultSet rs;*/
    
    private String MemIdLabel;
    private String MemNameField;
    private String MemNumField;
    private String MemIcField;
    private String MemEmailField;
    private String MemAddrField;
    private String Cityfield;
    private String StateField;
    private String MemPckcombobox;
    private String MemIdField;
    private String MemIDfield;
    private double OustField;
    private double BalField;
    private double AmntField;
    Employee e;
    

    public String getPayID() {
        return payID;
    }

    public void setPayID(String payID) {
        this.payID = payID;
    }
    private String payID;

    public String getMemIDfield() {
        return MemIDfield;
    }

    public void setMemIDfield(String MemIDfield) {
        this.MemIDfield = MemIDfield;
    }

    public double getOustField() {
        return OustField;
    }

    public void setOustField(double OustField) {
        this.OustField = OustField;
    }

    public double getBalField() {
        return BalField;
    }

    public void setBalField(double BalField) {
        this.BalField = BalField;
    }

    public double getAmntField() {
        return AmntField;
    }

    public void setAmntField(double AmntField) {
        this.AmntField = AmntField;
    }

    
   

    public Customer() {
        this.conn = jdbc.sqlite();
    }

    
    
    
    public void registerClient(){
    try{
            
        String sql = "Insert into CustomerDetails(MemberID,Name,Phone,IdentityNo,Email,Address,City,State,Package)values(?,?,?,?,?,?,?,?,?)";
                  
                  pst = conn.prepareStatement(sql);
                   pst.setString(1,MemIdLabel);
                   pst.setString(2,MemNameField);
                   pst.setString(3,MemNumField);
                   pst.setString(4,MemIcField);
                   pst.setString(5,MemEmailField);
                   pst.setString(6,MemAddrField);
                   pst.setString(7,Cityfield);
                   pst.setString(8,StateField);
                   pst.setString(9,MemPckcombobox);
                   
                   pst.execute();
                   pst.close();
                   JOptionPane.showMessageDialog(null, "Saved!");
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
    
    @Override
    public void update(){
    
    try{
            
        String sql = "Update CustomerDetails set Name=?,Phone=?,IdentityNo=?,Email=?,Address=?,City=?,State=?,Package=? where MemberID=?";
                  
                   pst = conn.prepareStatement(sql);
                   
                   pst.setString(1,MemNameField);
                   pst.setString(2,MemNumField);
                   pst.setString(3,MemIcField);
                   pst.setString(4,MemEmailField);
                   pst.setString(5,MemAddrField);
                   pst.setString(6,Cityfield);
                   pst.setString(7,StateField);
                   pst.setString(8,MemPckcombobox);
                   pst.setString(9,MemIdField);
                   
                   pst.executeUpdate();
                   pst.close();
                   JOptionPane.showMessageDialog(null, "Updated!");
        }
        catch(Exception e){
        JOptionPane.showMessageDialog(null, e);
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
    
    public void searchId(String MemIdField){
    
    try
        {              
            String sql = "select * from CustomerDetails where MemberID = ?";
            pst = conn.prepareStatement(sql);
          
            pst.setString(1, MemIdField);
            
            rs = pst.executeQuery();
            
           if (rs.next()) {
                System.out.println("member found");
                
                String add2 = rs.getString("Name");
                setMemNameField(add2);
                String add3 = rs.getString("Phone");
                setMemNumField(add3);
                String add4 = rs.getString("IdentityNo");
                setMemIcField(add4);
                String add5 = rs.getString("Address");
                setMemAddrField(add5);
                String add6 = rs.getString("Email");
                setMemEmailField(add6);
                String add7 = rs.getString("City");
                setCityfield(add7);
                String add8 = rs.getString("State");
                setStateField(add8);
                 
                
                pst.close();
            }
            
            else{
            JOptionPane.showMessageDialog(null, "Not a member");
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
        } finally{
                try{
                pst.close();
                
                }
                catch(Exception e ){
                }
                }
    }  
   
    public void searchClient(JTable custTable, String idtxtbox){
    try
        {              
        DefaultTableModel model = (DefaultTableModel)custTable.getModel();
        String sql = "Select * from CustomerDetails where MemberID = ?";
        
        pst = conn.prepareStatement(sql);
        pst.setString(1, idtxtbox);
        
        rs = pst.executeQuery();
        
        while(rs.next()){ 
            
        //custTable.setModel(model); 
        
        model.addRow(new Object [] {
            rs.getString("MemberID"),
            rs.getString("Name"),
            rs.getString("Phone"), 
            rs.getString("IdentityNo"),
            rs.getString("Email"),
            rs.getString("Address"),
            rs.getString("City"),
            rs.getString("State"),
            rs.getString("Package")});
        
        JOptionPane.showMessageDialog(null, "Data found!");

        }
  
            pst.execute();
            pst.close();
  
        }   
        catch (SQLException err)
        {     
            JOptionPane.showMessageDialog(null, "Member number does not exist!");
            err.printStackTrace();           
        } 
        finally{
            try{
                pst.close();
                
            }
            catch(Exception e ){
            }
        }
    } 
    public void searchallClient(JTable custTable){
    try
        {              
        DefaultTableModel model = (DefaultTableModel)custTable.getModel();
        String sql = "Select * from CustomerDetails ";
        
        pst = conn.prepareStatement(sql);
 
        rs = pst.executeQuery();
        
        while(rs.next()){ 
            
        custTable.setModel(model); 
        
        model.addRow(new Object [] {
            rs.getString("MemberID"),
            rs.getString("Name"),
            rs.getString("Phone"), 
            rs.getString("IdentityNo"),
            rs.getString("Email"),
            rs.getString("Address"),
            rs.getString("City"),
            rs.getString("State"),
            rs.getString("Package")});
        
        

        }
  JOptionPane.showMessageDialog(null, "Data found!");
            pst.execute();
            pst.close();
  
        }   
        catch (SQLException err)
        {     
            JOptionPane.showMessageDialog(null, "Data found!");
        }
        finally{
            try{
                pst.close();
                
            }
            catch(Exception e ){
            }
        }
    } 
    
    
    @Override
    public void delete(String MemIdField){
        
    try{
        String sql = "Delete from CustomerDetails where MemberID=?";
    
        pst = conn.prepareStatement(sql);
        pst.setString(1, MemIdField);
        pst.execute();
        JOptionPane.showMessageDialog(null, "Member deleted!");
    }
    catch(SQLException | HeadlessException err){
    err.printStackTrace();
    }
    }
    
    
    public void searchPayment(String MemIDfield){
    try
        {              
        
        String sql = "Select SUM(Amount) AS TotalAmount from OrderDetails where MemberID = ?";
        
        pst = conn.prepareStatement(sql);
        pst.setString(1, MemIDfield);
        
        rs = pst.executeQuery();
        
        while(rs.next()){ 
            
                System.out.println("member found");
     
                double add3 = rs.getDouble("TotalAmount");
                setOustField(add3);
                String pay = createRandom_no();
                setPayID(pay);
                JOptionPane.showMessageDialog(null, "Data found!");
           }
  
            pst.execute();
            pst.close();
  
        }   
        catch (SQLException err)
        {     
            JOptionPane.showMessageDialog(null, "Member number does not exist!");
            err.printStackTrace();           
        } 
        finally{
            try{
                pst.close();
                
            }
            catch(Exception e ){
            }
        }
    
    }
    public void savePayment(){
        try{
    
        String sql = "Insert into memberPayment(MemberID,TotalDue,TotalPaid,TotalBalance,PayID) values(?,?,?,?,?)";
        
        pst = conn.prepareStatement(sql);
        
        pst.setString(1, MemIDfield);
        pst.setDouble(2, OustField);
        pst.setDouble(3, AmntField);
        pst.setDouble(4, BalField);
        pst.setString(5, payID);
        
        pst.execute();
        pst.close();
        
         JOptionPane.showMessageDialog(null, "Record Saved!");
        }
        
       catch(SQLException e){
    JOptionPane.showMessageDialog(null, e);
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
   
     
     public String getMemIdField() {
        return MemIdField;
    }

    public void setMemIdField(String MemIdField) {
        this.MemIdField = MemIdField;
    }
    public String getMemNameField() {
        return MemNameField;
    }

    public void setMemNameField(String MemNameField) {
        this.MemNameField = MemNameField;
    }

    public String getMemNumField() {
        return MemNumField;
    }

    public void setMemNumField(String MemNumField) {
        this.MemNumField = MemNumField;
    }

    public String getMemIcField() {
        return MemIcField;
    }

    public void setMemIcField(String MemIcField) {
        this.MemIcField = MemIcField;
    }

    public String getMemEmailField() {
        return MemEmailField;
    }

    public void setMemEmailField(String MemEmailField) {
        this.MemEmailField = MemEmailField;
    }

    public String getMemAddrField() {
        return MemAddrField;
    }

    public void setMemAddrField(String MemAddrField) {
        this.MemAddrField = MemAddrField;
    }

    public String getCityfield() {
        return Cityfield;
    }

    public void setCityfield(String Cityfield) {
        this.Cityfield = Cityfield;
    }

    public String getStateField() {
        return StateField;
    }

    public void setStateField(String StateField) {
        this.StateField = StateField;
    }

    public String getMemPckcombobox() {
        return MemPckcombobox;
    }

    public void setMemPckcombobox(String MemPckcombobox) {
        this.MemPckcombobox = MemPckcombobox;
    }
    

    public String getMemIdLabel() {
        return MemIdLabel;
    }

    public void setMemIdLabel(String MemIdLabel) {
        this.MemIdLabel = MemIdLabel;
    }

 public String createRandom_no() {
        
        Random r = new Random();
        int id_no = r.nextInt(9999-1000) + 1000;
        String id = Integer.toString(id_no);
        
        return id;       
 } 
  
}  
    
class UniqueCustomerNumber {

    private String customerID;

    public void setCustNum() {
        Random x = new Random();
        this.customerID = Integer.toString(x.nextInt(10000));
        System.out.println(customerID);
    }

    public String getCustNum() {
        return this.customerID;
    }
    
}
