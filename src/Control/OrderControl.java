/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;


import da.OrderDA;
import domain.Orderdetail;
import java.util.List;

public class OrderControl {
    private OrderDA order;

    public OrderControl() {
        order = new OrderDA();
    }

    public Orderdetail getRecord(String username) {
        return order.getRecord(username);
    }
    
      
    public List <Orderdetail> getAllRecord() {
         return order.getAllRecord();
    }
     
       public void addRecord(Orderdetail addOrder){
        order.addRecord(addOrder);
    }
    

    
     public Orderdetail selectRecord(String id) {
        return order.getRecord(id);
    }

   

 
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hui Chen Xin
 */

    
    
