
import java.util.*;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */
class Orders {
    private int customer_id,order_id,tailor_id;
    private String orderDate,complete_date,completed,emergency;
    private byte[] picture;
    
    public Orders(int order_id,int customer_id,int tailor_id,String orderDate,String complete_date,String completed,String emergency,byte[] picture)
    {
        this.customer_id = customer_id;
        this.order_id = order_id;
        this.orderDate = orderDate;
        this.complete_date = complete_date;
        this.tailor_id = tailor_id;
        this.completed = completed;
        this.emergency = emergency;
        this.picture = picture;
    }

    
     public int get_customer_id(){
         return customer_id;
     }
     public int get_order_id(){
         return order_id;
     }
     public int get_tailor_id(){
         return tailor_id;
     }
     public String get_order_date(){
         return orderDate;
     }
     public String get_complete_date(){
         return complete_date;
     }
     public String completed(){
         return completed;
     }
     public String emergency(){
         return emergency;
     }
     public byte[] getImage(){
         return picture;
     }

}
