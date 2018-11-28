/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package da;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import domain.Promotion;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author AL
 */
public class PromotionDA {
     private String host = "jdbc:derby://localhost:1527/FlowerDB";
    private String user = "nbuser";
    private String password = "nbuser";
    private String tableName = "Promotion";
    private Connection conn;
    private PreparedStatement stmt;
    
    public PromotionDA(){
    createConnection();
    }
    
     public void addRecord(Promotion p){
           
            try{
                    String insertStr="INSERT INTO "+tableName+" VALUES(?, ?, ?, ? )";
                    stmt=conn.prepareStatement(insertStr);
                    stmt.setString(1, p.getPromotionname());
                    stmt.setString(2, p.getPromotionmonth());
                    stmt.setString(3, p.getPromotiondetail());
                    stmt.setString(4,p.getPromotiontc());
                    stmt.executeUpdate();
                    
                }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
            }
    }
     
         public List<Promotion> getAllRecord() {
            String queryStr = "SELECT * FROM " + tableName;
            List<Promotion> pList=new ArrayList<Promotion>();
            Promotion pRecord = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()) {                
                pRecord = new Promotion(rs.getString("PROMOTIONNAME"), rs.getString("PROMOTIONMONTH"),rs.getString("PROMOTIONDETAIL"), rs.getString("PROMOTIONTC") );
                pList.add(pRecord);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return pList;
    }
         
          public Promotion getAllSelectedRecordViaMonth(String month) {
            String queryStr = "SELECT * FROM " + tableName+" WHERE PROMOTIONMONTH = ? ";
            Promotion pRecord = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, month);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()) {                
                pRecord = new Promotion(rs.getString("PROMOTIONNAME"), rs.getString("PROMOTIONMONTH"),rs.getString("PROMOTIONDETAIL"), rs.getString("PROMOTIONTC") );
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "getAllSeletedRecord ERROR",JOptionPane.ERROR_MESSAGE);
        }
        return pRecord;
    }
    
     private void createConnection() {
        try {
            conn = DriverManager.getConnection(host, user, password);
            System.out.println("***TRACE: Connection established.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
}
