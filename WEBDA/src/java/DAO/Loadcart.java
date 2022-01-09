/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DB.DBConnect;
import MODELS.Cart;
import MODELS.Order;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class Loadcart {
    
    public List<Cart> loadcart(int CusID) {
        List<Cart> lct = new ArrayList<>();
        
        try {
            Connection connect = new DBConnect().getInstance().openConnection();
            String querry = "exec loadcart @CustomerID=?";
            PreparedStatement ps = connect.prepareStatement(querry);
            ps.setInt(1, CusID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lct.add(new Cart(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getDouble(5),
                        rs.getInt(6),
                        rs.getDouble(7),
                        rs.getDouble(8)));
            }
        } catch (Exception e) {
            e.printStackTrace();
            
        }
        
        return lct;
    }
    
}
