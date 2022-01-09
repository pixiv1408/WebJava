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
import MODELS.Cart;
import MODELS.Foods;
import MODELS.IDOdetail;
import MODELS.Order;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;

import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.jstl.core.Config;
import java.sql.Date;

/**
 *
 * @author DELL
 */
@WebServlet(name = "Addcart", urlPatterns = {"/Addcart"})
public class Addcart extends HttpServlet {

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
            if (login.getAccount() == null) {
                request.getRequestDispatcher("jsp").forward(request, response);
            } else {
                double tong = 0;
                int oid = 0;
                String AFID = request.getParameter("AFID");
                int FOODID = Integer.parseInt(AFID);
                DAO dao = new DAO();
                List<Order> lod = new loadOrder().listOrder(login.getAccount().getAccCusID());
                if (lod.size() == 0) {
                    dao.insertOrder(login.getAccount().getAccCusID(), Date.valueOf(LocalDate.now()), tong, 1);
                    List<Order> lod1 = new loadOrder().listOrder(login.getAccount().getAccCusID());
                    for (Order o : lod1) {
                        oid = o.getOrderID();
                        dao.adddetail(oid, FOODID, 1);
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
                        if (FOODID == lid.getIDfood()) {
                            checkex += 1;
                        }
                    }
                    if (checkex > 0) {
                        dao.pluscount(1, oid, FOODID);
                    }
                    if (checkex == 0) {
                        dao.adddetail(oid, FOODID, 1);
                    }
                }
                List<Cart> lct = new Loadcart().loadcart(login.getAccount().getAccCusID());
                for (Cart c : lct) {
                    tong += c.getTotal();
                }
                dao.UpdateOrder(tong, oid);
                request.setAttribute("MESS", "Thêm vào giỏ hàng thành công ");
                request.getRequestDispatcher("Home").forward(request, response);
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
