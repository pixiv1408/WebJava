/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controls;

import DAO.DAO;
import DAO.Loadcart;
import DAO.loadOdetail;
import DAO.loadOrder;
import DAO.loadcate;
import MODELS.Cart;
import MODELS.Category;
import MODELS.Foods;
import MODELS.Order;
import MODELS.TopFood;
import MODELS.detailhistory;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.DecimalFormat;
import java.time.LocalDate;
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
@WebServlet(name = "Buynow", urlPatterns = {"/Buynowintodetailfood"})
public class Buynowintodetailfood extends HttpServlet {

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
            int fid = Integer.parseInt(request.getParameter("fid"));
            int amount = Integer.parseInt(request.getParameter("amount"));
            System.out.println(fid+" | "+amount);
             DecimalFormat fm = new DecimalFormat("#,###");
            request.setAttribute("fm", fm);
            if(login.getAccount()==null){
                response.sendRedirect("Login.jsp");
            }
            else{
                int tong=0;
                DAO dao = new DAO();
                dao.insertOrder(login.getAccount().getAccID(),Date.valueOf(LocalDate.now()),tong , 0);
                List<Order> all = new loadOrder().allorder(login.getAccount().getAccCusID());
                int oid = all.get(all.size()-1).getOrderID();
                System.out.println(oid);
                dao.adddetail(oid, fid, amount);
                List<detailhistory> ldt = new loadOdetail().detailhistory(oid);
                for(detailhistory dt: ldt){
                    tong+=dt.getTotal();
                }
                dao.UpdateOrder(tong,oid);
              List<Order> all1 = new loadOrder().allorder(login.getAccount().getAccCusID());
                request.setAttribute("info",all1 );
                request.getRequestDispatcher("notification.jsp").forward(request, response);
                
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
