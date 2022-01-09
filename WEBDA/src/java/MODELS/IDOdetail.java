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
public class IDOdetail {
    private int IDOd;
    private int IDfood;

    public IDOdetail(int IDOd, int IDfood) {
        this.IDOd = IDOd;
        this.IDfood = IDfood;
    }

    public int getIDfood() {
        return IDfood;
    }



    public int getIDOd() {
        return IDOd;
    }

    public void setIDOd(int IDOd) {
        this.IDOd = IDOd;
    }

    public IDOdetail(int IDOd) {
        this.IDOd = IDOd;
    }

    public IDOdetail() {
    }
    
    
}
