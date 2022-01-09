/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Controls.login;
import DB.DBConnect;
import MODELS.Account;
import MODELS.Cart;
import MODELS.Category;
import MODELS.Customer;
import MODELS.Foods;
import MODELS.Odetail;
import MODELS.Order;
import MODELS.TopFood;
import java.sql.Connection;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.sql.Date;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Scanner;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author DELL
 */
public class NewClass {

    public static void main(String[] args) {
        try {
//            Connection con = new DBConnect().getInstance().openConnection();
//            System.out.println("keets noi thanh cong !");
//            System.out.println(con.getCatalog());
//            System.out.println("---------------------------");
//            List<Account> a = new loadaccount().listacc();
//            for (Account a1 : a) {
//                System.out.println("ID = " + a1.getAccID() + " User = " + a1.getAccUsername() + " Pass = " + a1.getAccPassword() + " CusID = " + a1.getAccCusID());
//            }
//            List<Foods> lf = new loadfood().listfoods();
//            for (Foods f : lf) {
//                System.out.println("FID = " + f.getFoodID() + " FName = " + f.getFoodName() + " Price = " + f.getFoodPrice() + " FCateID = " + f.getFoodCateID() + " FIMG = " + f.getFoodIMG() + " Describe = " + f.getFoodDescribe());
//            }
//            List<Category> lcate = new loadcate().listcate();
//            for (Category c : lcate) {
//                System.out.println("CID = " + c.getCateID() + " CName = " + c.getCateName());
//            }
//            TopFood top = new DAO().topfood();
//
//            System.out.println("id: " + top.getFID() + "name:" + top.getFName());
//            System.out.println("----------------------------");
//            Scanner sc = new Scanner(System.in);
//            System.out.println("nhap ten : ");
//            String ten = sc.nextLine();
//            List<Foods> lfs = new Search().foodsearch(ten);
//            for (Foods fs : lfs) {
//                System.out.println("FID = " + fs.getFoodID() + " FName = " + fs.getFoodName() + " Price = " + fs.getFoodPrice() + " FCateID = " + fs.getFoodCateID() + " FIMG = " + fs.getFoodIMG() + " Describe = " + fs.getFoodDescribe());
//            }
//            List<Foods> t = new loadfood().listfoods();
//            System.out.println("nhap ten : ");
//            String ten1 = sc.nextLine();
//            Search s1 = new Search();
//
//            //  System.out.println("kết quả:" + s1.checkname(ten1));
//            System.out.println(" thu bycate:----------------------------------");
//            System.out.println("nhap maCID : ");
//            String CID = sc.nextLine();
//            List<Foods> lbc = new DAO().listfoodsbycate(CID);
//            for (Foods fs : lbc) {
//                System.out.println("FID = " + fs.getFoodID() + " FName = " + fs.getFoodName() + " Price = " + fs.getFoodPrice() + " FCateID = " + fs.getFoodCateID() + " FIMG = " + fs.getFoodIMG() + " Describe = " + fs.getFoodDescribe());
//            }
//            String username = "Admin";
//            String password = "1234";
//
//
//
//            Account ac = new DAO().getlogin(username, password);
//            if (ac == null) {
//                System.out.println("Dang nhap that bai");
//
//            } else {
//                System.out.println("Dang nhap thanh cong");
//            }
//            String u = "COUNTDOWN";
//
//
//        Customer cus = new DAO().getcus(1);
//            System.out.println("id:"+cus.getCusID()+"Name:"+cus.getCusName());
//            List<Order> lod = new loadOrder().listOrder(2);
//            for (Order od : lod) {
//                System.out.println("ID: " + od.getOrderID() + " CusID: " + od.getOderCusID() + " DATE: " + od.getOrderDate() + " now: " + LocalDateTime.now().toLocalDate() + " Cart: " + od.isOrderCart());
//            }
//
//            List<Odetail> lodetail = new loadOdetail().listOdetail();
//            for (Odetail ode : lodetail) {
//                System.out.println("ID: " + ode.getOdetailID()+ " ORDERID: " + ode.getOdetailOrderID()+ " fOODID " + ode.getOdetailFoodID() + " AMOUNT " + ode.getOdetailAmount());
//            }
//             List<Cart> lct = new Loadcart().loadcart(2);
//                     for(Cart c :lct){
//                         System.out.println("id:");
//                     }
//
//////  
//List<Order> lod12 = new loadOrder().listOrder(1);
//for(Order o :lod12){
//    
//    System.out.println();
List<Foods> lf = new loadfood().listfoods();
            System.out.println(lf.size());
//
//
//System.out.println( lod12.size());
//double amount = 2000000;
//DecimalFormat twoPlaces = new DecimalFormat("#,###");
//System.out.println(twoPlaces.format(amount));









        } catch (Exception e) {

       }
   }
}
