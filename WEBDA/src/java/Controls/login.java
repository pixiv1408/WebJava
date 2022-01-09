/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controls;

import DAO.DAO;
import DAO.loadcate;
import DAO.loadfood;
import MODELS.Account;
import MODELS.Category;
import MODELS.Customer;
import MODELS.Foods;
import MODELS.TopFood;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.security.auth.message.callback.PrivateKeyCallback;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author DELL
 */
@WebServlet(name = "login", urlPatterns = {"/login"})
public class login extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    public static boolean checklogin = false;
    private static Account account;

    public static void setAccount(Account account) {
        login.account = account;
    }

    public static Account getAccount() {
        return account;
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

                String user = request.getParameter("user");
                String pass = request.getParameter("pass");
                Account ac = new DAO().getlogin(user, pass);

                if (ac == null) {
                    System.out.println("Dang nhap that bai");
                    request.setAttribute("Mess", "Sai tài khoản hoặc mật khẩu");
                    request.setAttribute("checklogin", checklogin);
                    request.getRequestDispatcher("Login.jsp").forward(request, response);

                } else {
                    HttpSession session = request.getSession();
                    session.setAttribute("checkacc", ac);

                    System.out.println("Dang nhap thanh cong");
                    checklogin = true;
                    account = ac;
                    request.setAttribute("checklogin", checklogin);
                    Customer cus = new DAO().getcus(login.getAccount().getAccCusID());
                    request.setAttribute("customer", cus);
                    request.setAttribute("account", getAccount());

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
