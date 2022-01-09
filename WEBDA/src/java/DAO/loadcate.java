/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DB.DBConnect;
import MODELS.Category;
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
public class loadcate {

    public List<Category> listcate() {
        List<Category> fList = new ArrayList<>();
        try {
            Connection connect = new DBConnect().getInstance().openConnection();
            String querry = "select* from Category where Catestatus=1";
            PreparedStatement ps = connect.prepareStatement(querry);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                fList.add(new Category(rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3)));
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return fList;
    }

    public Category infocate(int CateID) {
        
        try {
            Connection connect = new DBConnect().getInstance().openConnection();
            String querry = "select* from Category where Catestatus=1 and CateID=?";
            PreparedStatement ps = connect.prepareStatement(querry);
            ps.setInt(1, CateID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
               return new Category(rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3));
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;
    }
}
