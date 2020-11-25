/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mr. Quader
 */
public class PartyOrders {
     private int par_id,order_id,customer_id;
    private String design;
    public PartyOrders(int par_id,int order_id,int customer_id)
    {
        this.par_id = par_id;
        this.order_id = order_id;
        this.customer_id = customer_id;
    }

    
     public int get_cas_id(){
         return par_id;
     }
     public int get_order_id(){
         return order_id;
     }
     public int get_customer_id(){
         return customer_id;
     }
}
