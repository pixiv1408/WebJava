/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODELS;

/**
 *
 * @author DELL
 */
public class Cart {

   private int OrderID;
   private int FoodID;
   private String FoodIMG;
    private String FoodName;
   private double FoodPrice;
   private int Amount; 
   private double Total;
   private double OrderTotal;

    public Cart() {
    }

    public Cart(int OrderID, int FoodID, String FoodIMG, String FoodName, double FoodPrice, int Amount, double Total, double OrderTotal) {
        this.OrderID = OrderID;
        this.FoodID = FoodID;
        this.FoodIMG = FoodIMG;
        this.FoodName = FoodName;
        this.FoodPrice = FoodPrice;
        this.Amount = Amount;
        this.Total = Total;
        this.OrderTotal = OrderTotal;
    }

    public int getOrderID() {
        return OrderID;
    }

    public void setOrderID(int OrderID) {
        this.OrderID = OrderID;
    }

    public int getFoodID() {
        return FoodID;
    }

    public void setFoodID(int FoodID) {
        this.FoodID = FoodID;
    }

    public String getFoodIMG() {
        return FoodIMG;
    }

    public void setFoodIMG(String FoodIMG) {
        this.FoodIMG = FoodIMG;
    }

    public String getFoodName() {
        return FoodName;
    }

    public void setFoodName(String FoodName) {
        this.FoodName = FoodName;
    }

    public double getFoodPrice() {
        return FoodPrice;
    }

    public void setFoodPrice(double FoodPrice) {
        this.FoodPrice = FoodPrice;
    }

    public int getAmount() {
        return Amount;
    }

    public void setAmount(int Amount) {
        this.Amount = Amount;
    }

    public double getTotal() {
        return Total;
    }

    public void setTotal(double Total) {
        this.Total = Total;
    }

    public double getOrderTotal() {
        return OrderTotal;
    }

    public void setOrderTotal(double OrderTotal) {
        this.OrderTotal = OrderTotal;
    }


   
}
