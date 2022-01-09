/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DB.DBConnect;
import MODELS.Order;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class loadOrder {

    public List<Order> listOrder(int CusID) {

        List<Order> Olist = new ArrayList<>();
        try {
            Connection connect = new DBConnect().getInstance().openConnection();
            String querry = "select* from Orders where OderCusID=? and OrderCart=1";
            PreparedStatement ps = connect.prepareStatement(querry);
            ps.setInt(1, CusID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Olist.add(new Order(rs.getInt(1),
                        rs.getInt(2),
                        rs.getDate(3),
                        rs.getDouble(4),
                        rs.getBoolean(5)));
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return Olist;
    }

    public List<Order> listhistory(int CusID) {

        List<Order> Olist = new ArrayList<>();
        try {
            Connection connect = new DBConnect().getInstance().openConnection();
            String querry = "select* from Orders where OderCusID=? and OrderCart=0 order by OrderID DESC ";
            PreparedStatement ps = connect.prepareStatement(querry);
            ps.setInt(1, CusID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Olist.add(new Order(rs.getInt(1),
                        rs.getInt(2),
                        rs.getDate(3),
                        rs.getDouble(4),
                        rs.getBoolean(5)));
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return Olist;
    }

    public List<Order> allorder(int CUSID) {

        List<Order> Olist = new ArrayList<>();
        try {
            Connection connect = new DBConnect().getInstance().openConnection();
            String querry = "select* from Orders where OderCusID=?";
            PreparedStatement ps = connect.prepareStatement(querry);
            ps.setInt(1, CUSID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Olist.add(new Order(rs.getInt(1),
                        rs.getInt(2),
                        rs.getDate(3),
                        rs.getDouble(4),
                        rs.getBoolean(5)));
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return Olist;
    }

}
