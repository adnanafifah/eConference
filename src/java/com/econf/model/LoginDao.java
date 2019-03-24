/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.econf.model;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class LoginDao {

    /**
     *
     * @param name
     * @param pass
     * @return
     * @throws SQLException
     */
    public static boolean validate(String name, String pass, String type) 
            throws SQLException{  
    boolean status=false;  
    try{ 
        Class.forName("com.mysql.jdbc.Driver");
        Connection con;
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_econf","root","root");
        
    PreparedStatement ps;
    ps=con.prepareStatement("select * from tbl_staff where id_staff=? and user_pass=? and user_type=?");  
    ps.setString(2,name);
    ps.setString(13,type); 
    ps.setString(14,pass);    
    
    ResultSet rs=ps.executeQuery();  
    status=rs.next(); 
    
    } catch (ClassNotFoundException ex) {  
            Logger.getLogger(LoginDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    return status;  
    }
}
