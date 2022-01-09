/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controls;

import static Controls.login.checklogin;
import static Controls.login.getAccount;
import DAO.DAO;
import DAO.Loadcart;
import MODELS.Cart;
import MODELS.Customer;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DELL
 */
@WebServlet(name = "Cart", urlPatterns = {"/Cuscart"})
public class Cuscart extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            if (login.getAccount() == null) {
                response.sendRedirect("Login.jsp");
            } else {
                double tong = 0;
                double vat = 0;
                Customer cus = new DAO().getcus(login.getAccount().getAccCusID());
                List<Cart> lct = new Loadcart().loadcart(login.getAccount().getAccCusID());
                request.setAttribute("account", login.getAccount());
                request.setAttribute("checklogin", login.checklogin);
                request.setAttribute("listcart", lct);
                for (Cart c : lct) {
                    tong += c.getTotal();
                }
                vat = (tong * 0.1);
                DecimalFormat fm = new DecimalFormat("#,###");
                request.setAttribute("fm", fm);
                
                request.setAttribute("total", tong);
                request.setAttribute("vat", vat);
                request.setAttribute("MESS", "Bạn có muốn thanh toán giỏ hàng không? \n bấm Đồng ý để thanh toán");

                if (getAccount() != null) {

                    request.setAttribute("Customer", cus);
                }

                request.getRequestDispatcher("Cart.jsp").forward(request, response);
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
