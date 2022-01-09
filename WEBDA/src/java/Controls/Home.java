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
import DAO.Search;
import DAO.loadaccount;
import DAO.loadcate;
import DAO.loadfood;
import MODELS.Account;
import MODELS.Cart;
import MODELS.Category;
import MODELS.Customer;
import MODELS.Foods;
import MODELS.TopFood;
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
@WebServlet(name = "Home", urlPatterns = {"/Home"})
public class Home extends HttpServlet {

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
        //get data 

        List<Category> lc = new loadcate().listcate();
        List<Foods> lf = new loadfood().listfoods();
        if (lf.size() != 0) {
            TopFood top = new DAO().topfood();
            DecimalFormat fm = new DecimalFormat("#,###");

            request.setAttribute("listCategory", lc);
            request.setAttribute("listFoods", lf);
            request.setAttribute("topfood", top);
            request.setAttribute("account", getAccount());
            request.setAttribute("checklogin", checklogin);
            request.setAttribute("fm", fm);

            if (getAccount() != null) {
                Customer cus = new DAO().getcus(login.getAccount().getAccCusID());
                List<Cart> lct = new Loadcart().loadcart(login.getAccount().getAccCusID());
                request.setAttribute("customer", cus);
                request.setAttribute("listcart", lct);

            }
            
        }
        request.getRequestDispatcher("Home.jsp").forward(request, response);
        

        

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
