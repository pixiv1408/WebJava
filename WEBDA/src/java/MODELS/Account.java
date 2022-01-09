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
public class Account {

    public Account() {

    }

    public int getAccID() {
        return AccID;
    }

    public String getAccUsername() {
        return AccUsername;
    }

    public String getAccPassword() {
        return AccPassword;
    }

    public int getAccCusID() {
        return AccCusID;
    }

    public void setAccID(int AccID) {
        this.AccID = AccID;
    }

    public void setAccUsername(String AccUsername) {
        this.AccUsername = AccUsername;
    }

    public void setAccPassword(String AccPassword) {
        this.AccPassword = AccPassword;
    }

    public void setAccCusID(int AccCusID) {
        this.AccCusID = AccCusID;
    }
    private int AccID;
    private String AccUsername;
    private String AccPassword;
    private int AccCusID;

    @Override
    public String toString() {
        return "Account{" + "AccID=" + AccID + ", AccUsername=" + AccUsername + ", AccPassword=" + AccPassword + ", AccCusID=" + AccCusID + '}';
    }

    public Account(int AccID, String AccUsername, String AccPassword, int AccCusID) {
        this.AccID = AccID;
        this.AccUsername = AccUsername;
        this.AccPassword = AccPassword;
        this.AccCusID = AccCusID;

    }

}
