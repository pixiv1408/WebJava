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
public class Customer {
    public Customer(){
        
    }
    private int CusID;
    private String CusName;
    private String CusEmail;
    private String CusPhone;
    private String CusAddress;

    public Customer(int CusID, String CusName, String CusEmail, String CusPhone, String CusAddress) {
        this.CusID = CusID;
        this.CusName = CusName;
        this.CusEmail = CusEmail;
        this.CusPhone = CusPhone;
        this.CusAddress = CusAddress;
    }

    public void setCusID(int CusID) {
        this.CusID = CusID;
    }

    public void setCusName(String CusName) {
        this.CusName = CusName;
    }

    public void setCusEmail(String CusEmail) {
        this.CusEmail = CusEmail;
    }

    public void setCusPhone(String CusPhone) {
        this.CusPhone = CusPhone;
    }

    public void setCusAddress(String CusAddress) {
        this.CusAddress = CusAddress;
    }

    public int getCusID() {
        return CusID;
    }

    public String getCusName() {
        return CusName;
    }

    public String getCusEmail() {
        return CusEmail;
    }

    public String getCusPhone() {
        return CusPhone;
    }

    public String getCusAddress() {
        return CusAddress;
    }
    
}
