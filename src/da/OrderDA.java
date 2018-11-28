/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package da;
import domain.Orderdetail;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Yong
 */
public class OrderDA {
    private String host = "jdbc:derby://localhost:1527/order";
    private String user = "nbuser";
    private String password = "nbuser";
    private String tableName = "Orderdetail";
    private Connection conn;
    private PreparedStatement stmt;
    
     public OrderDA() {
        createConnection();
    }
     
      public Orderdetail getRecord(String ORDERID) {
        String queryStr = "SELECT * FROM " + tableName + " WHERE ORDERID = ?";
        Orderdetail orderRecord = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, ORDERID);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                orderRecord = new Orderdetail(rs.getString("ORDERID"), rs.getString("INVOICEID"), rs.getString("CUSTOMERID"), rs.getString("CUSTOMERNAME"), rs.getString("FLOWERTYPE"), rs.getString("ORDERDATE"), rs.getString("DELIVERYDATE"), rs.getInt("QUANTITY"), rs.getDouble("PRICE"), rs.getString("ADDRESS"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return orderRecord;
    }
      
         public void addRecord(Orderdetail addOrder){
           
            try{
                    String insertStr="INSERT INTO "+tableName+" VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                    stmt=conn.prepareStatement(insertStr);
                    stmt.setString(1, addOrder.getOrderid());
                    stmt.setString(2, addOrder.getInvoiceid());
                    stmt.setString(3, addOrder.getCustomerid());
                    stmt.setString(4, addOrder.getCustomername());
                    stmt.setString(5, addOrder.getFlowertype());
                    stmt.setString(6, addOrder.getOrderdate());
                    stmt.setString(7, addOrder.getDeliverydate());
                    stmt.setInt(8, addOrder.getQuantity());
                    stmt.setDouble(9, addOrder.getPrice());
                    stmt.setString(10, addOrder.getAddress());
                    stmt.executeUpdate();
                    JOptionPane.showMessageDialog(null, "New Order Added!");
                                      
                }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
            }
    }
         
          public List<Orderdetail> getAllRecord(){
   
        String queryStr = "SELECT * FROM " + tableName;
        List<Orderdetail> orderList= new ArrayList<Orderdetail>();
        Orderdetail OrderR = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
               OrderR = new Orderdetail(rs.getString("ORDERID"), rs.getString("INVOICEID"), rs.getString("CUSTOMERID"), rs.getString("CUSTOMERNAME"), rs.getString("FLOWERTYPE"), rs.getString("ORDERDATE"), rs.getString("DELIVERYDATE"), rs.getInt("QUANTITY"), rs.getDouble("PRICE"), rs.getString("ADDRESS"));
               orderList.add(OrderR);
            } 
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return orderList;
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
