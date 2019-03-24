<%-- 
    Document   : list_application
    Created on : Jan 8, 2018, 5:51:47 AM
    Author     : srie
--%>


<%@page import="java.sql.*"%>
<%@page import="javax.sql.rowset.JoinRowSet"%>

<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SENARAI PERMOHONAN</title>
    </head>
    <%
        Statement stmt = null;
        String query = "select name_course.tbl_application, date_submit.tbl_application, id_staff.tbl_staff, " + 
                   "attachment_1.tbl_application, attachment_2.tbl_application, attachment_3.tbl_application, " +
                   "attachment_4.tbl_application, attachment_5.tbl_application, attachment_6.tbl_application, date_submit.tbl_application, " +
                   "status.tbl_comment_kpp, status.tbl_comment_pji, status_meet.tbl_comment_ppsm, status.tbl_comment_dean " +
                   "from tbl_application, tbl_comment_kpp, tbl_comment_pji, tbl_comment_ppsm, tbl_comment_ppsm " +
                   "where id_staff.tbl_staff = id_staff.tbl_application " +
                   "id_staff.tbl_application = id_staff.tbl_comment_kpp and " +
                   "id_staff.tbl_application = id_staff.tbl_comment_pji and " +
                   "id_staff.tbl_application = id_staff.tbl_comment_ppsm and " +
                   "id_staff.tbl_application = id_staff.tbl_comment_dean";
            
    
        Class.forName("com.mysql.jdbc.Driver");
        Connection con;
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_econf","root","root");
        
        stmt = con.createStatement();
        ResultSet rs=stmt.executeQuery(query); 
        
        //Int i = 0;
            
         while (rs.next()) {
             //Int i ++;
            String staff_id = rs.getString("id_staff.tbl_staff"); 
            String course_name = rs.getString("name_course.tbl_application");
            Date submit_date = rs.getDate("date_submit.tbl_application");
            Blob attachment1 = rs.getBlob("attachment_1.tbl_application");
            Blob attachment2 = rs.getBlob("attachment_2.tbl_application"); 
            Blob attachment3 = rs.getBlob("attachment_3.tbl_application"); 
            Blob attachment4 = rs.getBlob("attachment_4.tbl_application"); 
            Blob attachment5 = rs.getBlob("attachment_5.tbl_application"); 
            //Blob attachment6 = rs.getBlob("attachment_6.tbl_application"); 
            Date date_submit = rs.getDate("date_submit.tbl_application");
            String status_kpp = rs.getString("status.tbl_comment_kpp");
            String status_pji = rs.getString("status.tbl_comment_pji");
            String status_ppsm = rs.getString("status_meet.tbl_comment_ppsm");
            String status_dean = rs.getString("status.tbl_comment_dean");
            
        
    %>
        
    <body>
        <table width="100%" align="center" cellpadding="0" cellspacing="0" border="1">			
			<tr>
				<th colspan="10">SENARAI PERMOHONAN</th>
			</tr>			
		</table>
		<table width="100%" align="center" cellpadding="0" cellspacing="0" border="1">			
			<thead>										
				<tr>
					<th width="5%"  >BIL</th>
					<th width="30%" >NAMA KURSUS</th>
					<th>DOKUMEN MAKLUMAT KURSUS</th>	
                                        <th>DOKUMEN GERAN</th>
                                        <th>DOKUMEN KERTAS KERJA</th>
                                        <th>DOKUMEN PENGANJUR</th>
                                        <th>DOKUMEN PENANGGUHAN KELAS</th>
					<th>TARIKH PERMOHONAN</th>
					<th>ULASAN KPP</th>
					<th>ULASAN TD PJI</th>
                                        <th>ULASAN PPSM</th>
                                        <th>KEPUTUSAN</th>
				</tr>				
			</thead>
			<tbody>
				<tr>
                                        <td></td>
                                        <td><% System.out.println(course_name); %></td>
					<td><% System.out.println(submit_date); %></td>						
                                        <td><% if (attachment1 != null) { System.out.println("Maklumat Kursus"); } 
                                            else {System.out.println("Tiada Maklumat Kursus");} %></td>	
                                        <td><% if (attachment2 != null) { System.out.println("Maklumat Geran"); } 
                                            else {System.out.println("Tiada Maklumat Geran");} %></td>
                                        <td><% if (attachment3 != null) { System.out.println("Maklumat Kertas Kerja"); } 
                                            else {System.out.println("Tiada Maklumat Kertas Kerja");} %></td>
                                        <td><% if (attachment4 != null) { System.out.println("Maklumat Penganjur"); } 
                                            else {System.out.println("Tiada Maklumat Penganjur");} %></td>
                                        <td><% if (attachment5 != null) { System.out.println("Maklumat Penangguhan Kelas"); } 
                                            else {System.out.println("Tiada Maklumat Penangguhan Kelas");} %></td>
                                        <td><% System.out.println(date_submit); %></td>
					<td><% System.out.println(status_kpp); %></td>
					<td><% System.out.println(status_pji); %></td>
					<td><% System.out.println(status_ppsm); %></td>
                                        <td><% System.out.println(status_dean); %></td>
                                        <% } %>
				</tr>
                                <tr>
                                    <form action="ApplyServlet.do" method="POST">
                                        <td><input name="staffId" value="<% System.out.println(staff_id); %><"></td>
                                    <td><input type="submit" value="PERMOHONAN BARU"></td>
                                    </form>
                                </tr>            
            		</tbody>
			<tfoot>				
				<tr>																							
				</tr>
			</tfoot>
		</table>
    </body>
</html>
