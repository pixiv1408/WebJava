/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import static DB.DBinfo.driverName;
import static DB.DBinfo.pass;
import static DB.DBinfo.url;
import static DB.DBinfo.user;

/**
 *
 * @author DELL
 */
public class DBConnect {

    public DBConnect() {
    }
    private static DBConnect instance;

    public static void setInstance(DBConnect instance) {
        DBConnect.instance = instance;
    }

    public static DBConnect getInstance() {
        if (instance == null) {
            instance = new DBConnect();
        }
        return instance;
    }

    public Connection openConnection() throws Exception {
        Class.forName(driverName);
        Connection con = DriverManager.getConnection(url, user, pass);
        return con;

    }
}
