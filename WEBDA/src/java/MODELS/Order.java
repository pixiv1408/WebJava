/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODELS;

import java.time.LocalDateTime;
import java.util.Date;


/**
 *
 * @author DELL
 */
public class Order {
    private int OrderID;
    private int OderCusID;
    private Date OrderDate;
    private double OrderTotal;
    private boolean OrderCart;

    public void setOrderDate(Date OrderDate) {
        this.OrderDate = OrderDate;
    }

    public Date getOrderDate() {
        return OrderDate;
    }

    public Order() {
    }

    public Order(int OrderID, int OderCusID, Date OrderDate, double OrderTotal, boolean OrderCart) {
        this.OrderID = OrderID;
        this.OderCusID = OderCusID;
        this.OrderDate = OrderDate;
        this.OrderTotal = OrderTotal;
        this.OrderCart = OrderCart;
    }



    public void setOrderID(int OrderID) {
        this.OrderID = OrderID;
    }

    public void setOderCusID(int OderCusID) {
        this.OderCusID = OderCusID;
    }



    public void setOrderTotal(double OrderTotal) {
        this.OrderTotal = OrderTotal;
    }

    public void setOrderCart(boolean OrderCart) {
        this.OrderCart = OrderCart;
    }

    public int getOrderID() {
        return OrderID;
    }

    public int getOderCusID() {
        return OderCusID;
    }



    public double getOrderTotal() {
        return OrderTotal;
    }

    public boolean isOrderCart() {
        return OrderCart;
    }
    
}
