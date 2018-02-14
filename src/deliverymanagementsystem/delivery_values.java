/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deliverymanagementsystem;

import java.sql.Date;

import javax.swing.*;

/**
 *
 * @author Mwendwa Mugambi
 */
public class delivery_values {
    //neworder variables
    
    String custTypeComboBox;
    String MemIdField;
    String sendername;
    String senderphone;
    String senderaddr;
    String sendercity;
    String senderstate;
    String senderemail;
    String recipientname;
    String recieverphone;
    String recieveraddr;
    String recievercity;
    String recieverstate;
    String recieveremail;
    int weightordertxt;
    String pckgcomboBox;
    String rateComboBox;
    int GrosstotalLabel;
    String ordernum;
    double grandtotalLabel;
    String currentdate;
    String deliverydate;
    String InstrComboBox;
    String orderoptions;
    double taxLabel;
    double ratelabel;
    int quotalabel;
    String month;
    String memberidfield;
    

    public String getMemberidfield() {
        return memberidfield;
    }

    public void setMemberidfield(String memberidfield) {
        this.memberidfield = memberidfield;
    }
    
    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }
    
    public int getQuotalabel() {
        return quotalabel;
    }

    public void setQuotalabel(int quotalabel) {
        this.quotalabel = quotalabel;
    }

    public double getRatelabel() {
        return ratelabel;
    }

    public void setRatelabel(double ratelabel) {
        this.ratelabel = ratelabel;
    }
  
    public double getTaxLabel() {
        return taxLabel;
    }

    public void setTaxLabel(double taxLabel) {
        this.taxLabel = taxLabel;
    }

    public String getCustTypeComboBox() {
        return custTypeComboBox;
    }

    public void setCustTypeComboBox(String custTypeComboBox) {
        this.custTypeComboBox = custTypeComboBox;
    }

    public String getMemIdField() {
        return MemIdField;
    }

    public void setMemIdField(String MemIdField) {
        this.MemIdField = MemIdField;
    }

    public String getSendername() {
        return sendername;
    }

    public void setSendername(String sendername) {
        this.sendername = sendername;
    }

    public String getSenderphone() {
        return senderphone;
    }

    public void setSenderphone(String senderphone) {
        this.senderphone = senderphone;
    }

    public String getSenderaddr() {
        return senderaddr;
    }

    public void setSenderaddr(String senderaddr) {
        this.senderaddr = senderaddr;
    }

    public String getSendercity() {
        return sendercity;
    }

    public void setSendercity(String sendercity) {
        this.sendercity = sendercity;
    }

    public String getSenderstate() {
        return senderstate;
    }

    public void setSenderstate(String senderstate) {
        this.senderstate = senderstate;
    }

    public String getSenderemail() {
        return senderemail;
    }

    public void setSenderemail(String senderemail) {
        this.senderemail = senderemail;
    }

    public String getRecipientname() {
        return recipientname;
    }

    public void setRecipientname(String recipientname) {
        this.recipientname = recipientname;
    }

    public String getRecieverphone() {
        return recieverphone;
    }

    public void setRecieverphone(String recieverphone) {
        this.recieverphone = recieverphone;
    }

    public String getRecieveraddr() {
        return recieveraddr;
    }

    public void setRecieveraddr(String recieveraddr) {
        this.recieveraddr = recieveraddr;
    }

    public String getRecievercity() {
        return recievercity;
    }

    public void setRecievercity(String recievercity) {
        this.recievercity = recievercity;
    }

   public String getRecieverstate() {
        return recieverstate;
    }

    public void setRecieverstate(String recieverstate) {
        this.recieverstate = recieverstate;
    }
   

    public String getRecieveremail() {
        return recieveremail;
    }

    public void setRecieveremail(String recieveremail) {
        this.recieveremail = recieveremail;
    }

    public int getWeightordertxt() {
        return weightordertxt;
    }

    public void setWeightordertxt(int weightordertxt) {
        this.weightordertxt = weightordertxt;
    }

    public String getPckgcomboBox() {
        return pckgcomboBox;
    }

    public void setPckgcomboBox(String pckgcomboBox) {
        this.pckgcomboBox = pckgcomboBox;
    }

    public String getRateComboBox() {
        return rateComboBox;
    }

    public void setRateComboBox(String rateComboBox) {
        this.rateComboBox = rateComboBox;
    }

    public int getGrosstotalLabel() {
        return GrosstotalLabel;
    }

    public void setGrosstotalLabel(int GrosstotalLabel) {
        this.GrosstotalLabel = GrosstotalLabel;
    }

    public String getOrdernum() {
        return ordernum;
    }

    public void setOrdernum(String ordernum) {
        this.ordernum = ordernum;
    }

    public double getGrandtotalLabel() {
        return grandtotalLabel;
    }

    public void setGrandtotalLabel(double grandtotalLabel) {
        this.grandtotalLabel = grandtotalLabel;
    }

    public String getCurrentdate() {
        return currentdate;
    }

    public void setCurrentdate(String currentdate) {
        this.currentdate = currentdate;
    }

    public String getDeliverydate() {
        return deliverydate;
    }

    public void setDeliverydate(String deliverydate) {
        this.deliverydate = deliverydate;
    }

    public String getInstrComboBox() {
        return InstrComboBox;
    }

    public void setInstrComboBox(String InstrComboBox) {
        this.InstrComboBox = InstrComboBox;
    }

    public String getOrderoptions() {
        return orderoptions;
    }

    public void setOrderoptions(String orderoptions) {
        this.orderoptions = orderoptions;
    }
    
    
    //standingorder
    
    //invoice
     String textSearchID;

    public String getTextSearchID() {
        return textSearchID;
    }

    public void setTextSearchID(String textSearchID) {
        this.textSearchID = textSearchID;
    }
    
   //rate
     String packagecombo;
     int limitfield;
     float pricefield;
     JTable rateTable;

    public JTable getRateTable() {
        return rateTable;
    }

    public void setRateTable(JTable rateTable) {
        this.rateTable = rateTable;
    }

    public String getPackagecombo() {
        return packagecombo;
    }

    public void setPackagecombo(String packagecombo) {
        this.packagecombo = packagecombo;
    }

    public int getLimitfield() {
        return limitfield;
    }

    public void setLimitfield(int limitfield) {
        this.limitfield = limitfield;
    }

    public float getPricefield() {
        return pricefield;
    }

    public void setPricefield(float pricefield) {
        this.pricefield = pricefield;
    }
    
    
    
}
