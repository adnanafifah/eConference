/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.econf.controller;

import com.econf.model.LoginDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author user
 */
public class FirstServlet1 extends HttpServlet {

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
            
            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String n=request.getParameter("username");  
            String p=request.getParameter("userpass");  
            String t=request.getParameter("usertype");
            //out.print(n + p);
        try {
            
            if(LoginDao.validate(n, p, t)){
                switch(t){
                    case "Pemohon":
                        RequestDispatcher rd1=request.getRequestDispatcher("/application.view");
                        rd1.forward(request,response);
                        break;
                    case "KPP":
                        RequestDispatcher rd2=request.getRequestDispatcher("/comment_kpp.view");
                        rd2.forward(request,response);
                        break;
                    case "PJI":
                        RequestDispatcher rd3=request.getRequestDispatcher("/comment_pji.view");
                        rd3.forward(request,response);
                        break;
                    case "PPSM":
                        RequestDispatcher rd4=request.getRequestDispatcher("/comment_ppsm.view");
                        rd4.forward(request,response);
                        break;
                    case "DEKAN":
                        RequestDispatcher rd5=request.getRequestDispatcher("/comment_dean.view");
                        rd5.forward(request,response);
                        break;
                }
            }
            else{
                out.print("Sorry username or password error");
                RequestDispatcher rd=request.getRequestDispatcher("index.html");
                rd.include(request,response);  
            }
        } catch (SQLException ex) {
            Logger.getLogger(FirstServlet1.class.getName()).log(Level.SEVERE, null, ex);
        }
          
            out.close();
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
