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
@WebServlet(name = "ChangePass", urlPatterns = {"/ChangePass"})
public class ChangePass extends HttpServlet {

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
                request.getRequestDispatcher("Login.jsp").forward(request, response);
            } else {
                request.setAttribute("info", login.getAccount());
                String oldPass = request.getParameter("oldpass");
                String newPass = request.getParameter("newpass");
                String rePass = request.getParameter("repass");
                String user = request.getParameter("username");
                if (!oldPass.equals(login.getAccount().getAccPassword())) {
                    request.setAttribute("Mess", "Mật khẩu không chính xác");
                } else if (rePass == "" || newPass == "") {
                    request.setAttribute("Mess", "Mật khẩu không hợp lệ");
                } else if (!newPass.equals(rePass)) {
                    request.setAttribute("Mess", "Xác nhận mật khảu không trùng khớp");
                } else {
                    DAO dao = new DAO();
                    dao.UpdatePass(newPass, login.getAccount().getAccID(), user);
                    request.setAttribute("Mess1", "Đổi mật khẩu thành công");
                }
                request.getRequestDispatcher("upaccount").forward(request, response);

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
