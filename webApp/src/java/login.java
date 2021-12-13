/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author kavi
 */
@WebServlet(urlPatterns = {"/login"})
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
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
         PrintWriter out=response.getWriter(); 
        String user=request.getParameter("user");
        String pass=request.getParameter("pass");       
        String P=pass.toString();
        Connection con=null;
        Statement st=null;
        ResultSet rs=null;
             
        try
            {
              Class.forName("org.apache.derby.jdbc.ClientDriver");
              con=DriverManager.getConnection("jdbc:derby://localhost:1527/a","kavi","123");
              st=con.createStatement();
             rs=st.executeQuery("Select * from KAVI.LOGIN where USERNAME='"+user+"' and PASSWORD='" + P +"' "); 
             
             if(rs.next())
             {
                 response.sendRedirect("index.jsp");
             }
             else
             {
                 out.println("<!DOCTYPE html>");
                 out.println("<html>");
                 out.println("<head>");
                 out.println("<title>ERROR</title>");            
                 out.println("</head>");
                 out.println("<body bgcolor='PaleGreen'>");
                 out.println("<center><h1>LOGIN FAILED</h1>");
                 out.println("<a href='index.html'>HOME PAGE</a></center>");
                 out.println("</body>");
                 out.println("</html>");
             }
            
            }

        catch(Exception e)
        {
            System.out.println(e);
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