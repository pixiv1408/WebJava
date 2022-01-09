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
@WebServlet(name = "Foodedit", urlPatterns = {"/Foodedit"})
public class Foodedit extends HttpServlet {

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
            } else if (login.getAccount().getAccID() == 1) {
                String efname = request.getParameter("efname");
                String efimg = request.getParameter("efimg");
                double efprice = Double.parseDouble(request.getParameter("efprice"));
                String efdescribe = request.getParameter("efdescribe");
                int fcate = Integer.parseInt(request.getParameter("fcate"));
                String FID = request.getParameter("FID");
                if (efdescribe == "" || efname == "" || efimg == "" || efprice == 0) {
                    request.setAttribute("Mess", "Không thể để trống bất cứ thông tin nào !!");
                    request.getRequestDispatcher("Upinfo").forward(request, response);
                } else {
                    DAO dao = new DAO();
                    dao.updatefood(efname, efprice, efimg, efdescribe, fcate, FID);
                    request.getRequestDispatcher("Manager").forward(request, response);
                }
            } else {
                response.sendRedirect("Home");
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
