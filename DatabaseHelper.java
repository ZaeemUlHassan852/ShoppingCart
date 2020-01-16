/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databasecode;

import business.Product;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author hp
 */

public class DatabaseHelper{
    private static final String file ="thefile.accdb";
    
    private static Statement getConnectiontatement() throws ClassNotFoundException, SQLException{
        
        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        String url = "jdbc:ucanaccess://C://Program Files//Apache Software Foundation//Tomcat 9.0//webapps//CS506_2019//src//main//webapp//assets"+file;
        
        Connection con = DriverManager.getConnection(url);
        
        Statement statement = con.createStatement();
        return statement;
    }
    
     public static ArrayList<Product> fetchProductsData(){
            ArrayList<Product> dataList = new ArrayList();
            try{
                Statement st = getConnectionStatement();
                
                String sql = "SELECT * Product" + "ORDER BY Product";
                ResultSet rs = st.executeQuery(sql);
                
                while(rs.next()){
                    String product =rs.getString("Product");
                    String price = rs.getString("Price");
                    String id = rs.getString("ID");
                    int ID = Integer.parseInt(id);
                    
                    Product p_product = new Product (ID, product,price);
                    dataList.add(p_product);
                }
                st.close();
                rs.close();
            }
            catch(SQLException ex){
                        System.out.println("SQLException: " + ex.toString());
                        }
            return dataList;
        }
        
        public static void insertOrderDetail(int id, int pid, int qty){
            try{
                Statement st = getConnectionStatement();
                String sql = "INSERT INTO OrderDetail" + "(OrderID, ProductID, Quantity)" + "Values ('" +id+ "','" +pid+ "','" +qty+ "')";
                st.executeUpdate(sql);
                st.close();
            }catch(SQLException ex){
                        System.out.println("SQLException: " + ex.toString());
                        }
        }
        
        public static void addOrder(String date, int noItems, double subTotal, double grandTotal, double shipping, String address){
            try{
                Statement st = getConnectionStatement();
                String sqll = "INSERT INTO Orders" + "(Date, NoItems, SubTotal, Shipping, GrandTotal, Address)" + "Values ('" +date+ "','" +noItems+ "','" +subTotal+ "','" +shipping+"','" +grandTotal+"','" +address+   "')";
                st.executeUpdate(sqll);
                st.close();
            }catch(SQLException ex){
                        System.out.println("SQLException: " + ex.toString());
                        }
            }

    private static Statement getConnectionStatement() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        }

