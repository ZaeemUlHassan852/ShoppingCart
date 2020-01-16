/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
/**
 *
 * @author hp
 */

public class Order{
    Date date;
    int noOfItems;
    double subTotal;
    double grandTotal;
    double shipping;
    String address;

    public void setDate(Date date) {
        this.date = date;
    }

    public void setNoOfItems(int noOfItems) {
        this.noOfItems = noOfItems;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public void setGrandTotal(double grandTotal) {
        this.grandTotal = grandTotal;
    }

    public void setShipping(double shipping) {
        this.shipping = shipping;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    public Order (Date date,int noOfItems,double subTotal,double grandTotal,double shipping, String address ){
        this.date=date;
        this.noOfItems=noOfItems;
        this.subTotal=subTotal;
        this.grandTotal=grandTotal;
        this.shipping=shipping;
        this.address=address;
    }
    
    public Date getDate(){
        return date;
    }
    
    public int noOfItems(){
        return noOfItems;
    }
    
    public double subtotal(){
        return subTotal;
    }
    
    public double grandtotal(){
        return grandTotal;
    }
    
    public double shipping(){
        return shipping;
    }
    
    public String address(){
        return address;
    }
}
