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
public class TopFood {

    public String getFName() {
        return FName;
    }

    public double getFPrice() {
        return FPrice;
    }

    public String getFIMG() {
        return FIMG;
    }

    public String getFDescribe() {
        return FDescribe;
    }

    public int getFID() {
        return FID;
    }
    public TopFood(){
        
    }
  
  

       
    public void setFID(int FID) {
        this.FID = FID;
    }
    public void setFName(String FName) {
        this.FName = FName;
    }

    public void setFPrice(double FPrice) {
        this.FPrice = FPrice;
    }

    public void setFIMG(String FIMG) {
        this.FIMG = FIMG;
    }

    public void setFDescribe(String FDescribe) {
        this.FDescribe = FDescribe;
    }
      public TopFood(int Fid ,String Fname,double Fprice,String Fimg,String Fdescribe){
        this.FID = Fid;
        this.FName = Fname;
        this.FPrice = Fprice;
        this.FIMG = Fimg;
        this.FDescribe = Fdescribe;
        
    }
        private int FID;

    private String FName;
    private Double FPrice;
    private String FIMG;
    private String FDescribe;
    
}
