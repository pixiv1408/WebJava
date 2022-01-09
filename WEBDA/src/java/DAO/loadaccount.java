/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DB.DBConnect;
import MODELS.Account;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class loadaccount {

    public List<Account> listacc() {
        List<Account> fList = new ArrayList<>();
        try {
            Connection connect = new DBConnect().getInstance().openConnection();
            String querry = "select* from Account";
            PreparedStatement ps = connect.prepareStatement(querry);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                fList.add(new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4)));
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return fList;
    }
}
