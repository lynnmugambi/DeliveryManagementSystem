/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deliverymanagementsystem;

import javax.swing.JTable;

/**
 *
 * @author Mwendwa Mugambi
 */
public interface Interface {
 void order();
 void search(String ordernum);
 void addRate();
 void displayrateTable(JTable rateTable);
 void generateInvoice(String ordernum);
 void searchid(String MemIdField);
 int getRate();
 int getQuota();
 void searchStanding(JTable standingTable,String memberidfield);
 public void delete(String orderid);
}
