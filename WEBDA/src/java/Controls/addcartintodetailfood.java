/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controls;

import DAO.DAO;
import DAO.Loadcart;
import DAO.loadIDDetail;
import DAO.loadOrder;
import DAO.loadcate;
import MODELS.Cart;
import MODELS.Category;
import MODELS.Foods;
import MODELS.IDOdetail;
import MODELS.Order;
import MODELS.TopFood;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.List;
//import javax.servlet.Request.
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DELL
 */
@WebServlet(name = "addcartintodetailfood", urlPatterns = {"/addcartintodetailfood"})
public class addcartintodetailfood extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            double tong = 0;
            int oid = 0;
            int fid = Integer.parseInt(request.getParameter("fid"));
            int amount = Integer.parseInt(request.getParameter("amount"));

            if (login.getAccount() == null) {
                request.getRequestDispatcher("Login.jsp").forward(request, response);
            } else {
                DAO dao = new DAO();
                List<Order> lod = new loadOrder().listOrder(login.getAccount().getAccCusID());
                if (lod.size() == 0) {
                    dao.insertOrder(login.getAccount().getAccCusID(), Date.valueOf(LocalDate.now()), tong, 1);
                    List<Order> lod1 = new loadOrder().listOrder(login.getAccount().getAccCusID());
                    for (Order o : lod1) {
                        oid = o.getOrderID();
                        dao.adddetail(oid, fid, amount);
                    }
                } else {

                    for (Order o : lod) {
                        if (o != null) {
                            oid = o.getOrderID();
                        }
                    }
                    List<IDOdetail> lidf = new loadIDDetail().listDetailID(oid);
                    int checkex = 0;
                    for (IDOdetail lid : lidf) {
                        if (fid == lid.getIDfood()) {
                            checkex += 1;
                        }
                    }
                    if (checkex >= 0) {
                        dao.pluscount(amount, oid, fid);
                    }
                    if (checkex == 0) {
                        dao.adddetail(oid, fid, amount);
                    }
                }
                List<Cart> lct = new Loadcart().loadcart(login.getAccount().getAccCusID());
                for (Cart c : lct) {
                    tong += c.getTotal();
                }
                dao.UpdateOrder(tong, oid);
                //------------------------------------------------//
                Foods food = new DAO().Fdetail(String.valueOf(fid));
                List<Category> lc = new loadcate().listcate();
                TopFood top = new DAO().topfood();
                DecimalFormat fm = new DecimalFormat("#,###");
                //------------------------------------------------//
                request.setAttribute("listcart", lct);
                request.setAttribute("fm", fm);
                request.setAttribute("Fdetail", food);
                request.setAttribute("listCategory", lc);
                request.setAttribute("topfood", top);
                request.setAttribute("checklogin", login.checklogin);
                request.setAttribute("account", login.getAccount());
                request.setAttribute("MESS", "Thêm vào giỏ hàng thành công ");
                request.getRequestDispatcher("Detail.jsp").forward(request, response);
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
