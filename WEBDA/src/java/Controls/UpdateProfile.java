/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controls;

import DAO.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DELL
 */
@WebServlet(name = "UpdateProfile", urlPatterns = {"/UpdateProfile"})
public class UpdateProfile extends HttpServlet {

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
        request.setCharacterEncoding("UTF-8");

        try (PrintWriter out = response.getWriter()) {
            if (login.getAccount() == null) {
                response.sendRedirect("Login.jsp");
            } else {
                String email = request.getParameter("email");
                String Phone = request.getParameter("phone");
                String address = request.getParameter("address");
                String pass = request.getParameter("pass");

                if (!pass.equals(login.getAccount().getAccPassword()) || pass == "") {
                    request.setAttribute("Mess", "Mật khẩu đã nhập không chính xác");
                    System.out.println(pass + "-" + login.getAccount().getAccPassword());
                    request.getRequestDispatcher("Customerinfo").forward(request, response);
                } else if (email == "" || Phone == "" || address == "") {
                    request.setAttribute("Mess", "Thông tin nhập vào không đầy đủ");
                    System.out.println(email + "-" + Phone + "-" + address);

                    request.getRequestDispatcher("Customerinfo").forward(request, response);

                } else {
                    DAO dao = new DAO();
                    dao.UpdateProfile(email, Phone, address, login.getAccount().getAccCusID());
                    request.setAttribute("Mess", "Cập nhật thành công");

                    request.getRequestDispatcher("Customerinfo").forward(request, response);

                }
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
