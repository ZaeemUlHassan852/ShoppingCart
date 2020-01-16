/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaservlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import databasecode.DatabaseHelper;

/**
 *
 * @author hp
 */
public class CheckOutServlet extends HttpServlet {

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
        int ID=0, pid=0, qty=0, qty1=0, items=0; 
        double subTotal=0;
        
        String values []= request.getParameterValues("quantity");
        String id []= request.getParameterValues("productID");
        String price []= request.getParameterValues("price");
        
        int n= values.length;
        int i;
        
        for(i=0; i<n; i++){
            qty = Integer.parseInt(values(i));
            if(qty>0){
                ID=i+1;
                pid = Integer.parseInt(values(i));
                qty1=qty;
                items = items + qty1;
                subTotal +=(double)qty1 * Double.parseDouble(price(i));
                
                DatabaseHelper.insertOrderDetail(ID,pid,qty1);
            }
        }
        
        
        double shipping = ((items/5)+1)*0.5;
        double grandTotal = subTotal + shipping;
        response.setContentType("text/html;charset=UTF-8");
        String title = "CheckOut";
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CheckOutServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<table width=\"600\" border=\"1\" align=\"center\" cellpadding=\"10\" cellspacing=\"1\">");
            out.println("<caption><h2>"+title+"</h2></caption>");
            out.println("<tr>");
            out.println("<td>No of Products</td>");
            out.println("<td>"+ID+"</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>No of Items</td>");
            out.println("<td>"+items+"</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>SubTotal</td>");
            out.println("<td>"+subTotal+"</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>Shipping Charges</td>");
            out.println("<td>"+shipping+"</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>GrandTotal</td>");
            out.println("<td>"+grandTotal+"</td>");
            out.println("</tr>");
            out.println("<br>");
            out.println("<form action=\"extra\" method=\"post\">");
            out.println("<tr>");
            out.println("<td>Shipping Address</td>");
            out.println("<td><input type=\"text\" id=\"address\" name=\"address\" placeholder=\"Your address\"></td>");
            out.println("<input type=\"hidden\" id=\"items\" name=\"items\" value="+items+">");
            out.println("<input type=\"hidden\" id=\"subTotal\" name=\"subTotal\" value="+subTotal+">");
            out.println("<input type=\"hidden\" id=\"shipping\" name=\"shipping\" value="+shipping+">");
            out.println("<input type=\"hidden\" id=\"grandTotal\" name=\"grandTotal\" value="+grandTotal+">");
            out.println("</tr>");
            out.println("<br>");
            out.println("<tr>");
            out.println("<td align=\"center\" colspan=\"2\"><input type=\"submit\" value=\"Place Order\"></td>");
            out.println("</form>");
            out.println("<form action=\"ShoppingCart\" method=\"post\">");
            out.println("<td align=\"center\" colspan=\"2\"><input type=\"submit\" value=\"Go Back\"></td>");
            out.println("</tr>");
            out.println("</table>");
            out.println("<h1>Servlet CheckOutServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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

    private String values(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private String price(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
