/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deliverymanagementsystem;
import java.awt.HeadlessException;
import java.io.*;
import java.sql.*;
import java.util.Random;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;



public class delivery_functions extends delivery_values implements Interface{
    Connection conn;
    PreparedStatement pst;
    ResultSet rs;
    int weight;
    
    
    public delivery_functions() {
    this.conn = jdbc.sqlite();    
    weight = getWeightordertxt();
    }
    
    @Override
    public void order(){
    try{
    String sql = "Insert into OrderDetails(ClientType,MemberID,OrderNo,sName,sPhone,sAddress,sCity,sState,sEmail,rName,rPhone,rAddress,rCity,rState,rEmail,OrderWeight,PackageType,RateValue,GrossTotal,Tax,Amount,Currentdate,Deliverydate,SendingInst,OrderOpt,Month) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    
    pst = conn.prepareStatement(sql);
    
    pst.setString(1,custTypeComboBox);
    pst.setString(2,MemIdField);
    pst.setString(3,ordernum);
    pst.setString(4,sendername);
    pst.setString(5,senderphone);
    pst.setString(6,senderaddr);
    pst.setString(7,sendercity);
    pst.setString(8,senderstate);
    pst.setString(9,senderemail);
    pst.setString(10,recipientname);
    pst.setString(11,recieverphone);
    pst.setString(12,recieveraddr);
    pst.setString(13,recievercity);
    pst.setString(14,recieverstate);
    pst.setString(15,recieveremail);
    pst.setInt(16,weightordertxt);
    pst.setString(17,pckgcomboBox);
    pst.setDouble(18,ratelabel);
    pst.setInt(19,GrosstotalLabel);
    pst.setDouble(20,taxLabel);
    pst.setDouble(21,grandtotalLabel);
    pst.setString(22,currentdate);
    pst.setString(23,deliverydate);
    pst.setString(24,InstrComboBox);
    pst.setString(25,orderoptions);
    pst.setString(26,month);
    
    pst.execute();
    pst.close();
    JOptionPane.showMessageDialog(null, "Order has been made");
    
    }
    catch(SQLException | HeadlessException e){
    JOptionPane.showMessageDialog(null, e);
    e.printStackTrace();
    //JOptionPane.showMessageDialog(null, );(to show exception id one of the fields are empty)
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
    public void search(String orderid){
    try
        {              
            String sql = "select * from OrderDetails where OrderNo = ?";
            pst = conn.prepareStatement(sql);
            
            pst.setString(1, orderid);
            rs = pst.executeQuery();

            if (rs.next()){
           
            setRecipientname1(rs.getString("rName"));
            setRecieverphone1(rs.getString("rPhone"));
            setRecieveraddr1(rs.getString("rAddress"));
            setRecievercity1(rs.getString("rCity"));
            setRecieveremail1(rs.getString("rEmail"));
            setRecieverstate1(rs.getString("rState"));
                            
            pst.execute();
            pst.close();
            }
      
        }       
        catch (SQLException err)
        {           
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
    
    @Override
    public void searchStanding(JTable standingTable, String memberidfield){
    try
        {              
        DefaultTableModel model = (DefaultTableModel)standingTable.getModel();
        String sql = "Select OrderNo,rName,rAddress,OrderOpt,MemberID from OrderDetails where MemberID=? and OrderOpt ='Standing Order'";
        
        pst = conn.prepareStatement(sql);
        pst.setString(1, memberidfield);
        
        rs = pst.executeQuery();
        
        while(rs.next()){ 
 
        String orderno = rs.getString("OrderNo");
        String memno = rs.getString("MemberID");
        String ordopt = rs.getString("OrderOpt");
        String rname = rs.getString("rName");
        String raddr = rs.getString("rAddress");
        
        standingTable.setModel(model);
        model.addRow(new Object[]{orderno,memno,ordopt,rname,raddr});
        
        }
 JOptionPane.showMessageDialog(null, "Data found!");
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
    
    @Override
    public void delete(String orderid){
        
    try{
        String sql = "Delete from OrderDetails where OrderNo=?";
    
        pst = conn.prepareStatement(sql);
        pst.setString(1, orderid);
        pst.execute();
        pst.close();
        JOptionPane.showMessageDialog(null, "Order deleted!");
        
    }
    catch(SQLException | HeadlessException e){
    e.printStackTrace();
    }
    }

    
    public void update(){
    
        try {
            String sql = "Update OrderDetails set rName=?,rPhone=?,rAddress=?,rCity=?,rState=?,rEmail=?,Currentdate=?,Deliverydate=?,SendingInst=?,OrderOpt=?,Month=? where OrderNo=?";
            
            pst = conn.prepareStatement(sql);
    
            pst.setString(1,recipientname1);    
            pst.setString(2,recieverphone1);          
            pst.setString(3,recieveraddr1);            
            pst.setString(4,recievercity1);           
            pst.setString(5,recieverstate1);           
            pst.setString(6,recieveremail1);           
            pst.setString(7,currentdate1);
            pst.setString(8,deliverydate1);           
            pst.setString(9,InstrComboBox1);
            pst.setString(10,orderoptions);           
            pst.setString(11,month1);
            pst.setString(12, orderid);
            
            pst.executeUpdate();
            pst.close();
            
            JOptionPane.showMessageDialog(null, "Order Updated!");
            

        } catch (SQLException | HeadlessException ex) {
            ex.printStackTrace();
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
    public void addRate(){
    
        try
        {
        
        String sql = "Update rateTable set dLimit=?,Rate=? where Package=?";
    
            pst = conn.prepareStatement(sql);
            
            pst.setInt(1,limitfield);
            pst.setFloat(2, pricefield);
            pst.setString(3, packagecombo);
            
            pst.execute();
            pst.close();
            
            JOptionPane.showMessageDialog(null, "Updated Successfully !");  
        }       
        catch (SQLException err)
        { 
            JOptionPane.showMessageDialog(null,err);
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
    
    @Override
    public void displayrateTable(JTable rateTable){
        try{
        DefaultTableModel model = (DefaultTableModel)rateTable.getModel();
        String sql = "Select * from rateTable";
        
        pst = conn.prepareStatement(sql);
        rs = pst.executeQuery();
        
        while(rs.next()){
        String opackage = rs.getString("Package");
        int dlimit = rs.getInt("dLimit");
        double ppkg =rs.getDouble("Rate");
      
        model.addRow(new Object[]{opackage,dlimit,ppkg});
        }
        
        pst.execute();
        pst.close();       
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
    
    @Override
    public void generateInvoice(String ordernum){
        
   
        String invoice_no = createRandom_no();
        
        try(PrintWriter outputFile = new PrintWriter(new FileWriter("C:\\db\\Invoice" + invoice_no + ".txt"))){
            
            String sql = "Select * from OrderDetails where OrderNo=?"; 
            pst = conn.prepareStatement(sql);
            
            pst.setString(1, ordernum);
            
            rs = pst.executeQuery();
            
            rs.next();
            
            String ornum = rs.getString("OrderNo");
            String memnum = rs.getString("MemberID");
            String dDate = rs.getString("Deliverydate");
            String sname = rs.getString("sName");
            String sphone = rs.getString("sPhone");
            String semail = rs.getString("sEmail");
            String packagex =rs.getString("PackageType");
            String state = rs.getString("rState");
            String cdate = rs.getString("Currentdate");
            Double amount = rs.getDouble("Amount");
                      
            pst.execute();
            pst.close();
            
            conn.close();
            
            outputFile.println("				 MYSOFT Sdn Bhd                                     ");
            outputFile.println("------------------------------------------------------------------------------------");
            outputFile.println("			Address : Lot 2, Sri Petaling, Malaysia,                    ");
            outputFile.println("				  57722, Bukit Jalil, KL                            ");
            outputFile.println("------------------------------------------------------------------------------------");
            outputFile.println("------------------------------------------------------------------------------------\n");
            outputFile.println("Invoice No.	: ## " + invoice_no                                                  );
            outputFile.println("Order ID.	: ## " + ornum                                                       );
            outputFile.println("___________________________________                                                 ");
            outputFile.println();
            outputFile.println("Sender Information				                                    ");
            outputFile.println("******************				                                    ");
            outputFile.println();
            outputFile.println("Customer ID	: " + memnum                                                         );
            outputFile.println("Name    	: " + sname                                                          );
            outputFile.println("Contact No	: " + sphone );
            outputFile.println("Email    	: " + semail );
            outputFile.println("_____________________________________________________________________________________");
            outputFile.println();
            outputFile.println("Package		: " +packagex + "\t\tDestination State\t: " + state       );
            outputFile.println("-------------------------------------------------------------------------------------");
            outputFile.println("Date Sent	: "+ cdate  + "\t\tDate Received\t: " +dDate           );
            outputFile.println();
            outputFile.println();
            outputFile.println("\t\t\tTotal Cost	: "+ amount    );
            outputFile.println("_____________________________________________________________________________________");
            outputFile.println();
            outputFile.println("				www.mysoft.com.my");
            outputFile.println("			Thank you for choosing MYSOFT - Your'e best delivery service!!");
            outputFile.println("			For enquiry please call : 012-95554411");
            outputFile.println("			        Have a good day ahead!");
        
             JOptionPane.showMessageDialog(null, "Invoice for Order No. " + ordernum + "has been generated \n File has been saved with Invoice no. as " + invoice_no + ".txt .");
        }
        
        catch (Exception err){
            
            err.printStackTrace();
        }
         
    }
    
    
    @Override
    public void searchid(String MemIdField){
    
    try
        {              
            String sql = "select * from CustomerDetails where MemberID = ?";
            pst = conn.prepareStatement(sql);
          
            pst.setString(1, MemIdField);
            
            rs = pst.executeQuery();
            
           if (rs.next()) {
                System.out.println("member found");
                
                String add2 = rs.getString("Name");
                setSendername(add2);
                String add3 = rs.getString("Phone");
                setSenderphone(add3);
                String add5 = rs.getString("Address");
                setSenderaddr(add5);
                String add6 = rs.getString("Email");
                setSenderemail(add6);
                String add7 = rs.getString("City");
                setSendercity(add7);
                String add8 = rs.getString("State");
                setSenderstate(add8);
                String add4 = rs.getString("Package");
                setRateComboBox(add4);
                       
                pst.close();
            }
            
            else{
            JOptionPane.showMessageDialog(null, "Not a member");
            }
          
        }catch(SQLException | HeadlessException e){
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
    @Override
    public int getRate(){
    
        try{
        
        String query = "select Rate,dLimit from rateTable where Package = ?";
            
        pst = conn.prepareStatement(query); 
        pst.setString(1,rateComboBox);
        
        rs = pst.executeQuery();
        
        while (rs.next()){
        
        String type = getPckgcomboBox();
        int ppkg = rs.getInt("Rate");
  
        if(type.equals("Parcel")){
            int ppkg2 = 2*ppkg;
            return ppkg2;
            
        }
        else{
            return ppkg;
        } 
        
        }
        pst.close();
                }
        
        catch (SQLException err)
        {           
            err.printStackTrace();           
        } 
        
        finally{
                try{
               
               pst.close();
                }
                catch(Exception e ){
                }
                }
       return 0; 
    }
@Override
    public int getQuota(){
    
        try{
        
        String query = "select * from rateTable where Package = ?";
            
        pst = conn.prepareStatement(query); 
        pst.setString(1,rateComboBox);
        
        rs = pst.executeQuery();
        
        while (rs.next()){
        
        String type = getPckgcomboBox();
        int quota = rs.getInt("dLimit");
        
        pst.close();
        return quota;
        }
        }        

        catch (SQLException err)
        {           
            err.printStackTrace();           
        } 
         finally{
                try{
                pst.close();
                
                }
                catch(Exception e ){
                }
                }
        return 0;
    }
    
    public int getGross(int weight, int getRate){
        
        
        int gross = weight * getRate;
        
        return gross;
    }
    
    public double getTax(int getGross){
        
    double taxrate = (double) 0.5;
    double tax = (double)(taxrate*getGross);
    
    return tax;
    }
                        
    public double getTotal(int getGross, double getTax) {
        double total = (double)(getTax + getGross);
        
        return total;
    }
        
 
    public double calcPackagePrice(int weight, int quota, int getGross,double getTax){
                    
        if( weight > quota) {
            
            int extra = weight - quota; 
            
            JOptionPane.showMessageDialog(null, "The parcel to be delivered "
                    + "exceeded " + quota +"kg,\n\n"+ extra + "kg of parcel will be"
                    + " subjected to extra charge");
            
   
            int e_cost = (extra * 7) ;
            int new_cost =e_cost + getGross;
            setGrosstotalLabel(new_cost);            
            
            double tax = getTax;
            setTaxLabel(getTax);
            
            double total_cost = (double)(new_cost + getTax);
            setGrandtotalLabel(total_cost);
            
            return total_cost;
        }
        
        else if (quota >= weight ){
            
            setGrosstotalLabel(getGross);
            
            double tax = getTax;
            setTaxLabel(getTax);
            
            double total_cost = (double)(getGross + getTax);
            setGrandtotalLabel(total_cost);
            
            return total_cost;
        }
        return 0;
       
    }
   
    
    public String createRandom_no() {
        
        Random r = new Random();
        int id_no = r.nextInt(9999-1000) + 1000;
        String id = Integer.toString(id_no);
        
        return id;
        
    }
    
    String orderid;
    String recipientname1;
    String recieverphone1;
     String recieveraddr1;
     String recievercity1;
     String recieverstate1;
     String month1;
     String recieveremail1;
     String currentdate1;
     String deliverydate1;
     String InstrComboBox1;

    public String getRecipientname1() {
        return recipientname1;
    }

    public void setRecipientname1(String recipientname1) {
        this.recipientname1 = recipientname1;
    }

    public String getRecieverphone1() {
        return recieverphone1;
    }

    public void setRecieverphone1(String recieverphone1) {
        this.recieverphone1 = recieverphone1;
    }

    public String getRecieveraddr1() {
        return recieveraddr1;
    }

    public void setRecieveraddr1(String recieveraddr1) {
        this.recieveraddr1 = recieveraddr1;
    }

    public String getRecievercity1() {
        return recievercity1;
    }

    public void setRecievercity1(String recievercity1) {
        this.recievercity1 = recievercity1;
    }

    public String getRecieverstate1() {
        return recieverstate1;
    }

    public void setRecieverstate1(String recieverstate1) {
        this.recieverstate1 = recieverstate1;
    }

    public String getMonth1() {
        return month1;
    }

    public void setMonth1(String month1) {
        this.month1 = month1;
    }
    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public String getRecieveremail1() {
        return recieveremail1;
    }

    public void setRecieveremail1(String recieveremail1) {
        this.recieveremail1 = recieveremail1;
    }

    public String getCurrentdate1() {
        return currentdate1;
    }

    public void setCurrentdate1(String currentdate1) {
        this.currentdate1 = currentdate1;
    }

    public String getDeliverydate1() {
        return deliverydate1;
    }

    public void setDeliverydate1(String deliverydate1) {
        this.deliverydate1 = deliverydate1;
    }

    public String getInstrComboBox1() {
        return InstrComboBox1;
    }

    public void setInstrComboBox1(String InstrComboBox1) {
        this.InstrComboBox1 = InstrComboBox1;
    }

}


class UniqueOrderNumber {

    private String ordernum;

    public void setOrderNum() {
        Random x = new Random();
        this.ordernum = Integer.toString(x.nextInt(1000000));
        System.out.println(ordernum);
    }

    public String getOrderNum() {
        return this.ordernum;
    }
}


