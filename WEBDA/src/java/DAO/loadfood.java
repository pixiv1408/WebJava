/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DB.DBConnect;
import MODELS.Account;
import MODELS.Foods;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class loadfood {
     public List<Foods> listfoods() {
        List<Foods> fList = new ArrayList<>();
        try {
            Connection connect = new DBConnect().getInstance().openConnection();
            String querry = "select* from Foods where FoodStatus = 1";
            PreparedStatement ps = connect.prepareStatement(querry);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                fList.add(new Foods(rs.getInt(1),
                        rs.getString(2),
                        rs.getDouble(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6)));
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return fList;
    }
    
}
