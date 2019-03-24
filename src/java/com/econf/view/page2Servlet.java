/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.econf.view;

import com.econf.model.UserCred;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author user
 */
public class page2Servlet extends HttpServlet {

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
        
        UserCred userCred = (UserCred) request.getAttribute("userCred");
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Request Application Form</title>");
            out.println("<body bgcolor='white'>");
            
            out.println("<h1>Request Application Form</h1>");
            out.println("Welcome " +userCred.getUser()+ "<br/>");
                        
            out.println("<br/>");
            out.println("<table  width='1' cellspacing='5' cellpadding='1'>");
                out.println("<tbody>");
                    out.println("<tr>");
                        out.println("<td>Course Name</td>");
                        out.println("<td>Request Date From</td>");
                        out.println("<td>Request Date To</td>");
                    out.println("</tr>");    
                    out.println("<tr>");
                        out.println("<td><input type='text' name='course' /><br/></td>");
                        out.println("<td><input type='date' name='dateFrom' /><br/></td>");
                        out.println("<td><input type='date' name='dateTo' /><br/></td>");
                    out.println("</tr>");    
                    out.println("<tr>");
                        out.println("<td>Place</td>");
                        out.println("<td>Promoter</td>");
                        out.println("<td>Course Objective</td>");
                    out.println("</tr>");   
                    out.println("<tr>");
                        out.println("<td><input type='text' name='place' /><br/></td>");
                        out.println("<td><input type='text' name='promoter' /><br/></td>");
                        out.println("<td><input type='text' name='objecive' /><br/></td>");
                    out.println("</tr>"); 
                out.println("</tbody>"); 
            out.println("</table>");
            out.println("<p> Purpose of Application </p>"); 
            out.println("<td><input type='checkbox' name='attend' value='ON' />Attend");
            out.println("<td><input type='checkbox' name='paperwork' value='ON' />Presenting Paperwork");
            //<a href='index.html'>Home</a>");           
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
