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
public class Category {
    public Category(){
        
    }
    private  int CateID;
    private  String CateName;
    private int Catestatus;

    public int getCatestatus() {
        return Catestatus;
    }

    public void setCatestatus(int Catestatus) {
        this.Catestatus = Catestatus;
    }

    public void setCateID(int CateID) {
        this.CateID = CateID;
    }

    public void setCateName(String CateName) {
        this.CateName = CateName;
    }


    

    public int getCateID() {
        return CateID;
    }

    public  String getCateName() {
        return CateName;
    }
    public Category(int CID, String CName,int Cstatus ){
        this.CateID= CID;
        this.CateName =CName;
        this.Catestatus = Cstatus;
        
    }
    
}
