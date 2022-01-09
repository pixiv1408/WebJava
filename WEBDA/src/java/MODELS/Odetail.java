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
public class Odetail {
    private int OdetailID;
    private int OdetailOrderID;
    private int OdetailFoodID;
    private int OdetailAmount;
 

    public Odetail() {
    }

    public Odetail(int OdetailID, int OdetailOrderID, int OdetailFoodID, int OdetailAmount) {
        this.OdetailID = OdetailID;
        this.OdetailOrderID = OdetailOrderID;
        this.OdetailFoodID = OdetailFoodID;
        this.OdetailAmount = OdetailAmount;

    }

    public int getOdetailID() {
        return OdetailID;
    }

    public int getOdetailOrderID() {
        return OdetailOrderID;
    }

    public int getOdetailFoodID() {
        return OdetailFoodID;
    }

    public int getOdetailAmount() {
        return OdetailAmount;
    }



    public void setOdetailID(int OdetailID) {
        this.OdetailID = OdetailID;
    }

    public void setOdetailOrderID(int OdetailOrderID) {
        this.OdetailOrderID = OdetailOrderID;
    }

    public void setOdetailFoodID(int OdetailFoodID) {
        this.OdetailFoodID = OdetailFoodID;
    }

    public void setOdetailAmount(int OdetailAmount) {
        this.OdetailAmount = OdetailAmount;
    }


    
}
