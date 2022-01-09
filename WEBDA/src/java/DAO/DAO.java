/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import static DAO.Search.removeAccent;
import DB.DBConnect;
import MODELS.Account;
import MODELS.Customer;
import MODELS.Foods;
import MODELS.Profile;
import MODELS.TopFood;
import MODELS.getCUSTOMERID;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author DELL
 */
public class DAO {

    public TopFood topfood() {
        TopFood top;
        try {
            Connection connect = new DBConnect().getInstance().openConnection();
            String querry = "exec topfood";
            PreparedStatement ps = connect.prepareStatement(querry);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                top = new TopFood(rs.getInt(1),
                        rs.getString(2),
                        rs.getDouble(3),
                        rs.getString(4),
                        rs.getString(5));
                return top;
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;
    }

    public List<Foods> loadfoodbycate(String CID) {
        List<Foods> lfs = new ArrayList<>();
        List<Foods> lf = new loadfood().listfoods();

        int ID = Integer.parseInt(CID);
        for (Foods f : lf) {

            if (ID == f.getFoodCateID()) {
                lfs.add(f);
            }
        }
        return lfs;
    }

    public List<Foods> listfoodsbycate(String CID) {
        List<Foods> fList = new ArrayList<>();
        if (CID != null) {
            try {
                Connection connect = new DBConnect().getInstance().openConnection();
                String querry = "select* from Foods where FoodStatus=1 and FoodCateID =?";
                PreparedStatement ps = connect.prepareStatement(querry);
                ps.setString(1, CID);
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
        }

        return fList;
    }

    public Account getlogin(String username, String password) {
        //Account acc = new Account();
        if (username != null && password != null) {
            try {
                Connection connect = new DBConnect().getInstance().openConnection();
                String querry = "exec login @username= ?, @password=?";
                PreparedStatement ps = connect.prepareStatement(querry);
                ps.setString(1, username);
                ps.setString(2, password);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    return new Account(rs.getInt(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getInt(4));
                }
            } catch (Exception e) {
                e.printStackTrace();

            }
        }

        return null;
    }

    public int getCUSID() {
        List<Customer> listid = new loadCustomer().listcus();
        return listid.get(listid.size() - 1).getCusID();
    }

    public void insertCUS(String ten, String email, String phone, String address) {
        try {
            Connection connect = new DBConnect().getInstance().openConnection();
            String querry = "insert into Customers values (?,?,?,?)";
            PreparedStatement ps = connect.prepareStatement(querry);
            ps.setString(1, ten);
            ps.setString(2, email);
            ps.setString(3, phone);
            ps.setString(4, address);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public void insertACC(String username, String pass, int cusid) {
        try {
            Connection connect = new DBConnect().getInstance().openConnection();
            String querry = "insert into Account values (?,?,?)";
            PreparedStatement ps = connect.prepareStatement(querry);
            ps.setString(1, username);
            ps.setString(2, pass);
            ps.setInt(3, cusid);

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public Account checkAccExsist(String user) {

        try {
            Connection connect = new DBConnect().getInstance().openConnection();
            String querry = "select* from Account where AccUsername=?";
            PreparedStatement ps = connect.prepareStatement(querry);
            ps.setString(1, user);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4));
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;
    }

    public Foods Fdetail(String FID) {
        try {
            Connection connect = new DBConnect().getInstance().openConnection();
            String querry = "select* from Foods where FoodStatus=1 and FoodID =?";
            PreparedStatement ps = connect.prepareStatement(querry);
            ps.setString(1, FID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new Foods(rs.getInt(1),
                        rs.getString(2),
                        rs.getDouble(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6));
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;
    }

    public Customer getcus(int AID) {
        List<Customer> clist = new loadCustomer().listcus();
        for (Customer cus : clist) {
            if (AID == cus.getCusID()) {
                return cus;
            }
        }
        return null;
    }

    public void deleteFood(String FID) {
        try {
            Connection connect = new DBConnect().getInstance().openConnection();
            String querry = "update Foods set FoodStatus = 0 where FoodID =?";
            PreparedStatement ps = connect.prepareStatement(querry);
            ps.setString(1, FID);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public void faddnew(String fname, double fprice, int fcate, String fimg, String fdescribe, int fstatus) {
        try {
            Connection connect = new DBConnect().getInstance().openConnection();
            String querry = "insert into Foods values (?,?,?,?,?,?)";
            PreparedStatement ps = connect.prepareStatement(querry);
            ps.setString(1, fname);
            ps.setDouble(2, fprice);
            ps.setInt(3, fcate);
            ps.setString(4, fimg);
            ps.setString(5, fdescribe);
            ps.setInt(6, fstatus);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void updatefood(String fname, double fprice, String fimg, String fdescribe, int fcateid, String FID) {
        try {
            Connection connect = new DBConnect().getInstance().openConnection();
            String querry = "update Foods set FoodName=? ,FoodPrice=?,FoodImage=?,FoodDescribe= ?, FoodCateID=? where FoodID = ?";
            PreparedStatement ps = connect.prepareStatement(querry);
            ps.setString(1, fname);
            ps.setDouble(2, fprice);
            ps.setString(3, fimg);
            ps.setString(4, fdescribe);
            ps.setInt(5, fcateid);
            ps.setString(6, FID);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void insertOrder(int CusID, Date Odate, double OrderTotal, int Cart) {
        try {
            Connection connect = new DBConnect().getInstance().openConnection();
            String querry = "insert into Orders values(?,?,?,?  )";
            PreparedStatement ps = connect.prepareStatement(querry);
            ps.setInt(1, CusID);
            ps.setDate(2, (java.sql.Date) Odate);
            ps.setDouble(3, OrderTotal);
            ps.setInt(4, Cart);

            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void adddetail(int OrderID, int FoodID, int Amount) {
        try {
            Connection connect = new DBConnect().getInstance().openConnection();
            String querry = "insert into OrderDetail values(?,?,?,1 )";
            PreparedStatement ps = connect.prepareStatement(querry);
            ps.setInt(1, OrderID);
            ps.setInt(2, FoodID);
            ps.setInt(3, Amount);

            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void pluscount(int amount, int OrderID, int FoodID) {
        try {
            Connection connect = new DBConnect().getInstance().openConnection();
            String querry = "update OrderDetail set OdetailAmount= OdetailAmount+? where OdetailOrderID = ? and OdetailFoodID = ?";
            PreparedStatement ps = connect.prepareStatement(querry);
            ps.setInt(1, amount);
            ps.setInt(2, OrderID);
            ps.setInt(3, FoodID);

            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void UpdateOrder(double OrderTotal, int OrderID) {
        try {
            Connection connect = new DBConnect().getInstance().openConnection();
            String querry = "update Orders set OrderTotal=? where OrderID=?";
            PreparedStatement ps = connect.prepareStatement(querry);

            ps.setDouble(1, OrderTotal);
            ps.setInt(2, OrderID);

            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Subcount(int OrderID, int FoodID) {
        try {
            Connection connect = new DBConnect().getInstance().openConnection();
            String querry = "update OrderDetail set OdetailAmount = OdetailAmount-1 where OdetailOrderID = ? and OdetailFoodID = ?";
            PreparedStatement ps = connect.prepareStatement(querry);

            ps.setInt(1, OrderID);
            ps.setInt(2, FoodID);

            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Delcount(int OrderID, int FoodID) {
        try {
            Connection connect = new DBConnect().getInstance().openConnection();
            String querry = "Delete from OrderDetail  where OdetailOrderID = ? and OdetailFoodID = ? and OdetailAmount<=0";
            PreparedStatement ps = connect.prepareStatement(querry);

            ps.setInt(1, OrderID);
            ps.setInt(2, FoodID);

            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Paycart(double tong, int OrderID) {
        try {
            Connection connect = new DBConnect().getInstance().openConnection();
            String querry = "update Orders set OrderCart= 0 , OrderTotal=? where OrderID = ? and OrderCart = 1";
            PreparedStatement ps = connect.prepareStatement(querry);

            ps.setDouble(1, tong);
            ps.setInt(2, OrderID);

            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Delfoodofcart(int OrderID, int FoodID) {
        try {
            Connection connect = new DBConnect().getInstance().openConnection();
            String querry = "Delete from OrderDetail  where OdetailOrderID = ? and OdetailFoodID = ?";
            PreparedStatement ps = connect.prepareStatement(querry);

            ps.setInt(1, OrderID);
            ps.setInt(2, FoodID);

            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void UpdateProfile(String email, String phone, String address, int CusID) {
        try {
            Connection connect = new DBConnect().getInstance().openConnection();
            String querry = "Update Customers set CusEmail= ? ,CusPhone=?,CusAddress=? where CusID= ?";
            PreparedStatement ps = connect.prepareStatement(querry);

            ps.setString(1, email);
            ps.setString(2, phone);
            ps.setString(3, address);
            ps.setInt(4, CusID);

            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Profile getinfo(int AccID, int CusID) {
        try {
            Connection connect = new DBConnect().getInstance().openConnection();
            String querry = "select a.AccUsername,a.AccPassword,c.CusName,c.CusEmail,c.CusPhone,c.CusAddress from Account a, Customers c where c.CusID=a.AccCusID and a.AccID =? and a.AccCusID=?";
            PreparedStatement ps = connect.prepareStatement(querry);
            ps.setInt(1, AccID);
            ps.setInt(2, CusID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new Profile(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6));
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;
    }

    public void UpdatePass(String newpass, int AccID, String user) {
        try {
            Connection connect = new DBConnect().getInstance().openConnection();
            String querry = "Update Account set AccPassword= ?  where AccID=? and AccUsername=?";
            PreparedStatement ps = connect.prepareStatement(querry);

            ps.setString(1, newpass);
            ps.setInt(2, AccID);
            ps.setString(3, user);

            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void removemulticate(int CateID) {
        try {
            Connection connect = new DBConnect().getInstance().openConnection();
            String querry = "update Category set Catestatus= 0 where CateID = ? ";
            PreparedStatement ps = connect.prepareStatement(querry);

            ps.setInt(1, CateID);

            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deletefoodbycateid(int cateid) {
        try {
            Connection connect = new DBConnect().getInstance().openConnection();
            String querry = "update Foods set FoodStatus = 0 where FoodCateID =?";
            PreparedStatement ps = connect.prepareStatement(querry);
            ps.setInt(1, cateid);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public void Delfoodincart(int OrderID, int FoodID) {
        try {
            Connection connect = new DBConnect().getInstance().openConnection();
            String querry = "Delete from OrderDetail  where OdetailOrderID=? and OdetailFoodID = ? ";
            PreparedStatement ps = connect.prepareStatement(querry);

            ps.setInt(1, OrderID);
            ps.setInt(2, FoodID);

            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void editcate(String name, int CateID) {
        try {
            Connection connect = new DBConnect().getInstance().openConnection();
            String querry = "update Category set CateName= ? where CateID = ? ";
            PreparedStatement ps = connect.prepareStatement(querry);
            ps.setString(1, name);
            ps.setInt(2, CateID);

            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void addnewcate(String catename) {
        try {
            Connection connect = new DBConnect().getInstance().openConnection();
            String querry = "insert into Category values (?,1)";
            PreparedStatement ps = connect.prepareStatement(querry);
            ps.setString(1, catename);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
