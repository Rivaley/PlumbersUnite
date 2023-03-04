package com.example.plumbersunite;

import java.io.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "HelloServlet", value = "/Hello-servlet")
public class HelloServlet extends HttpServlet {

    protected void ProcessLoginRequest(HttpServletRequest request,HttpServletResponse response)throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String adminid = request.getParameter("admin_username");
        String adminpass=request.getParameter("admin_password");
        try {
            if (AdminLogin(adminid,adminpass)){
                EmployeeBO employee=new EmployeeBO();
                employee.setId(adminid);
                employee.setPassword(adminpass);
                HttpSession session=request.getSession();
                session.setAttribute("employee",employee);
                RequestDispatcher rs=request.getRequestDispatcher("admin_account.html");
                rs.forward(request,response);
            }else {
                out.println("Invalid Login<br>");
                RequestDispatcher rs=request.getRequestDispatcher("admin_login.html");
                rs.include(request,response);

            }

        }catch (SQLException ex){
            Logger.getLogger(HelloServlet.class.getName()).log(Level.SEVERE,null,ex);

        }catch (ClassNotFoundException ex){

            Logger.getLogger(HelloServlet.class.getName()).log(Level.SEVERE,null,ex);
        }


    }
    public static boolean AdminLogin(String adminid,String adminpass )throws SQLException,ClassNotFoundException{
        boolean valid=false;
        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        Connection conn=DriverManager.getConnection("jdbc:/C:/Users/Ndure/PlumbersUDatabase1.accdb");
        String sql="Select * from Technicians where TechId=";
        Statement stmt= conn.createStatement();
        ResultSet rs=stmt.executeQuery(sql);
        String did;
        while (rs.next()){
            did= rs.getString(1);

            if (adminid.equals(did)&&adminpass.contains("admin")){
                valid=true;

            }
        }return valid;

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException {
        ProcessLoginRequest(request,response);
    }

    protected void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
        ProcessLoginRequest(request,response);

    }

    public void destroy() {
    }
}
