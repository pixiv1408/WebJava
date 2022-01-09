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
public class Foods {
    public Foods(){
        
    }


    private  int FoodID;
    private  String FoodName;
    private  double FoodPrice;
    private  int FoodCateID;
    private  String FoodIMG;

    public void setFoodID(int FoodID) {
        this.FoodID = FoodID;
    }

    public void setFoodName(String FoodName) {
        this.FoodName = FoodName;
    }

    public void setFoodPrice(double FoodPrice) {
        this.FoodPrice = FoodPrice;
    }

    public void setFoodCateID(int FoodCateID) {
        this.FoodCateID = FoodCateID;
    }

    public void setFoodIMG(String FoodIMG) {
        this.FoodIMG = FoodIMG;
    }

    public void setFoodDescribe(String FoodDescribe) {
        this.FoodDescribe = FoodDescribe;
    }



    public  String getFoodIMG() {
        return FoodIMG;
    }
    private  String FoodDescribe;



    public  int getFoodID() {
        return FoodID;
    }

    public String getFoodName() {
        return FoodName;
    }

    public  double getFoodPrice() {
        return FoodPrice;
    }

    public int getFoodCateID() {
        return FoodCateID;
    }

    public  String getFoodDescribe() {
        return FoodDescribe;
    }


    
    public Foods(int FID, String FName,double FPrice,int FCateID,String FImg,String FDescribe){
        this.FoodID= FID;
        this.FoodName= FName;
        this.FoodPrice=FPrice;
        this.FoodCateID = FCateID;
        this.FoodIMG = FImg;
        this.FoodDescribe = FDescribe;
    }
    
    
    
}
