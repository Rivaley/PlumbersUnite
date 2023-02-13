package com.example.plumbersunite;

import java.io.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {

    protected void ProcessRequest(HttpServletRequest request,HttpServletResponse response)throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        String adminid=request.getParameter("admin_username");
        String adminpassword=request.getParameter("admin_password");

        try {
            if (adminid.equals("1234")&adminpassword.equals("admin")){
                out.println("Welcome Admin");
                RequestDispatcher rs = request.getRequestDispatcher("index.html");
                rs.forward(request,response);

            }else {
                out.println("Invalid Login");
                RequestDispatcher rs= request.getRequestDispatcher("admin_login.html");
                rs.include(request,response);

            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException {
        ProcessRequest(request,response);
    }

    public void destroy() {
    }
}
