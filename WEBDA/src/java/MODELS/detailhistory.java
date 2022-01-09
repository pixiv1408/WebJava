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
public class detailhistory {
    private String Fname;
    private String Fimg;
    private int Amount;
    private Double Total;

    public detailhistory() {
    }

    public detailhistory(String Fname, String Fimg, int Amount, Double Total) {
        this.Fname = Fname;
        this.Fimg = Fimg;
        this.Amount = Amount;
        this.Total = Total;
    }

    public String getFname() {
        return Fname;
    }

    public void setFname(String Fname) {
        this.Fname = Fname;
    }

    public String getFimg() {
        return Fimg;
    }

    public void setFimg(String Fimg) {
        this.Fimg = Fimg;
    }

    public int getAmount() {
        return Amount;
    }

    public void setAmount(int Amount) {
        this.Amount = Amount;
    }

    public Double getTotal() {
        return Total;
    }

    public void setTotal(Double Total) {
        this.Total = Total;
    }
    
    
}
