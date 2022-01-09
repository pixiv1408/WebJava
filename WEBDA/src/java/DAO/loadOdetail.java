/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DB.DBConnect;
import MODELS.Odetail;
import MODELS.detailhistory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class loadOdetail {
     public List<detailhistory> detailhistory(int OID) {

        List<detailhistory> Odlist = new ArrayList<>();
        try {
            Connection connect = new DBConnect().getInstance().openConnection();
            String querry = "select f.FoodName,f.FoodImage,d.OdetailAmount,total=(f.FoodPrice*d.OdetailAmount) from foods f, OrderDetail d where f.FoodID=d.OdetailFoodID and d.OdetailOrderID= ?";
            PreparedStatement ps = connect.prepareStatement(querry);
            ps.setInt(1, OID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Odlist.add(new detailhistory(rs.getString(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getDouble(4)));
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return Odlist;
    }
   
    
}
