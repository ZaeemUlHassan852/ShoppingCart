/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaservlets;

import business.Product;
import databasecode.DatabaseHelper;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**
 *
 * @author hp
 */
public class ShoppingCartServlet extends HttpServlet {

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
        
        String title = "Shopping Cart";
        
        ArrayList<Product> dataList = DatabaseHelper.fetchProductsData();
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>"+title+"</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<table width=\"600\" border=\"1\" align=\"center\" cellpadding=\"10\" cellspacing=\"1\">");
            out.println("<caption><h2>"+title+"</h2></caption>");
            out.println("<tr>");
            out.println("<th>No</th>");
            out.println("<th>products</th>");
            out.println("<th>Quantity</th>");
            out.println("/tr");
            
            for(Product p_product:dataList){
                String product = p_product.getProduct();
                String price = p_product.getPrice();
                int id = p_product.getId();
                out.println("<form action=\"CheckOut\" method=\"post\">");
                out.println("<tr>");
                out.println("<td align=\"center\">" +id+ "</td>");
                out.println("<td align=\"center\">" +product+ "</td>");
                out.println("<td align=\"center\">" +price+ "</td>");
                out.println("<input type=\"hidden\" id=\"productID\" name=\"productID\" value="+id+">");
                out.println("<input type=\"hidden\" id=\"price\" name=\"price\" value="+price+">");
                out.println("<td align=\"center\"><input type=\"text\" id=\"quantity\" name=\"quantity\" placeholder=\"0\" size=\"5\" value='0'></td>");
                out.println("</tr>");
            }
            out.println("<tr>");
            out.println("<td align=\"center\" colspan=\"2\"><input type=\"submit\" value=\"CheckOut\"></td>");
            out.println("</form>");
            out.println("<form action=\"info.html\" method=\"post\">");
            out.println("<td align=\"center\" colspan=\"2\"><input type=\"submit\" value=\"LogOut\"></td>");
            out.println("</tr>");
            out.println("</form>");
            out.println("</table>");
            out.println("<h1>Servlet ShoppingCartServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
            out.close();
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
