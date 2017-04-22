/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.main;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author arpitpatel9380
 */
@WebServlet(name = "Appoint", urlPatterns = {"/Appoint"})
public class Appoint extends HttpServlet {

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
            String department=request.getParameter("depart");
            String firstname=request.getParameter("fname");
            String lastname=request.getParameter("lname");
            String email=request.getParameter("email");
            String appdate=request.getParameter("appdate");
            String dob=request.getParameter("dob");
            String sex=request.getParameter("sex");
            String yourmessage=request.getParameter("msg");
            
            
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NewServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet NewServlet at " + department+","+firstname+","+lastname+","+email+","+appdate+","+dob+","+sex+","+yourmessage+"</h1>");
            out.println("</body>");
            out.println("</html>");
            Connection con = null;
             try {
      con = DriverManager.getConnection("jdbc:derby://localhost:1527/Mysite");
        java.sql.Statement sta = con.createStatement(); 
      sta.executeUpdate("INSERT INTO APP.UNTITLED"+" VALUES ('"+department+"','"+firstname+"', '"+lastname+"', '"+email+"', '"+appdate+"','"+dob+"','"+sex+"','"+yourmessage+"')");
      //request.getRequestDispatcher("forgot.html");
     // response.sendRedirect("Home.html");
      sta.close();
      con.close();        
    } catch (Exception e) {
      System.err.println("Exception: "+e.getMessage());
    }
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Appoint</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Appoint at " + request.getContextPath() + "</h1>");
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

}
