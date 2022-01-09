/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DB.DBConnect;
import MODELS.IDOdetail;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class loadIDDetail {

    public List<IDOdetail> listDetailID(int OrderID) {
        List<IDOdetail> od = new ArrayList<>();
        try {
            Connection connect = new DBConnect().getInstance().openConnection();
            String querry = "select  OdetailID, OdetailFoodID from OrderDetail where OdetailOrderID=?";
            PreparedStatement ps = connect.prepareStatement(querry);
            ps.setInt(1, OrderID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                od.add(new IDOdetail(rs.getInt(1),
                        rs.getInt(2)));
                
            }
        } catch (Exception e) {
            e.printStackTrace();
            
        }
        return od;
    }
    
}
