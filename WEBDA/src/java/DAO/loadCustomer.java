/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DB.DBConnect;
import MODELS.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class loadCustomer {

    public List<Customer> listcus() {
        List<Customer> CList = new ArrayList<>();
        try {
            Connection connect = new DBConnect().getInstance().openConnection();
            String querry = "select* from Customers";
            PreparedStatement ps = connect.prepareStatement(querry);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CList.add(new Customer(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5)));
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return CList;
    }
}
