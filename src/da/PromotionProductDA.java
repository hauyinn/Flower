/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package da;

import domain.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author AL
 */
public class PromotionProductDA {
     private String host = "jdbc:derby://localhost:1527/FlowerDB";
    private String user = "nbuser";
    private String password = "nbuser";
    private String tableName = "Promotionproduct";
    private Connection conn;
    private PreparedStatement stmt;
    
    public PromotionProductDA(){
    createConnection();
    }
    
    public void addRecord(Promotionproduct p){
           
            try{
                    String insertStr="INSERT INTO "+tableName+" VALUES(?, ?, ?, ? )";
                    stmt=conn.prepareStatement(insertStr);
                    stmt.setString(1, p.getPromotiomitemid());
                    stmt.setString(2, p.getProductname());
                    stmt.setString(3, p.getPromotionname());
                    stmt.setDouble(4,p.getDiscountprice());
                    stmt.executeUpdate();
                    
                }catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Add Record Error: " +ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
            }
    }
    

     
         public List<Promotionproduct> getAllSelectedRecord(String promotionName) {
            String queryStr = "SELECT * FROM " + tableName+" WHERE PROMOTIONNAME = ? ";
            List<Promotionproduct> pList=new ArrayList<Promotionproduct>();
            Promotionproduct pRecord = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, promotionName);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()) {                
                pRecord = new Promotionproduct(rs.getString("PROMOTIOMITEMID"), rs.getString("PRODUCTNAME"),rs.getString("PROMOTIONNAME"), rs.getDouble("DISCOUNTPRICE") );
                pList.add(pRecord);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "getAllSeletedRecord ERROR",JOptionPane.ERROR_MESSAGE);
        }
        return pList;
    }
         
                  public List<Promotionproduct> getAllSelectedRecordViaMonth(String month) {
            String queryStr = "SELECT * FROM " + tableName+" WHERE PROMOTIONMONTH = ? ";
            List<Promotionproduct> pList=new ArrayList<Promotionproduct>();
            Promotionproduct pRecord = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, month);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()) {                
                pRecord = new Promotionproduct(rs.getString("PROMOTIOMITEMID"), rs.getString("PRODUCTNAME"),rs.getString("PROMOTIONNAME"), rs.getDouble("DISCOUNTPRICE") );
                pList.add(pRecord);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "getAllSeletedRecord ERROR",JOptionPane.ERROR_MESSAGE);
        }
        return pList;
    }
         
            public double getDiscount(String productName,String promotionName) {
            String queryStr = "SELECT * FROM " + tableName+" WHERE productName = "+productName+" AND promotionName = "+promotionName;
            double disP=0.0;
            Promotionproduct pRecord = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()) {                
                pRecord = new Promotionproduct(rs.getString("PROMOTIOMITEMID"), rs.getString("PRODUCTNAME"),rs.getString("PROMOTIONNAME"), rs.getDouble("DISCOUNTPRICE") );
                disP=pRecord.getDiscountprice();
            }
           
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Get Discount ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return disP;
    }
         
         
     public List<Promotionproduct> getAllRecord() {
            String queryStr = "SELECT * FROM " + tableName;
            List<Promotionproduct> pList=new ArrayList<Promotionproduct>();
            Promotionproduct pRecord = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()) {                
                pRecord = new Promotionproduct(rs.getString("PROMOTIOMITEMID"), rs.getString("PRODUCTNAME"),rs.getString("PROMOTIONNAME"), rs.getDouble("DISCOUNTPRICE") );
                pList.add(pRecord);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "getAllRecord ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return pList;
    }
    
        private void createConnection() {
        try {
            conn = DriverManager.getConnection(host, user, password);
            System.out.println("***TRACE: Connection established.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Connection ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
}
