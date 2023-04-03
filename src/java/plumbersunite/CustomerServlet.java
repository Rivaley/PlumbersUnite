package com.example.plumbersunite;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;


@WebServlet(name = "CustomerServlet", value = "/Customer_Servlet")
public class CustomerServlet extends HttpServlet {
    public void LoginDB(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        response.setContentType("text/html;charset=UTF-8");
        int Custid;
        String CustPassword;
        int DBCustID;
        String DBPass;
        try {
            Custid= Integer.parseInt(request.getParameter("cust_username"));
            CustPassword=request.getParameter("cust_password");
            System.out.println("User ID Retrieved: "+Custid);
            System.out.println("User Password Retrieved: "+CustPassword);

            CustomerBO c1;
            c1=new CustomerBO();
            c1.SelectDB(Custid);
            DBCustID=c1.getCustomer_ID();
            DBPass="Password";
            if (Custid==DBCustID& CustPassword.equals(DBPass)){
                System.out.println("Login Successful");
                RequestDispatcher rd=request.getRequestDispatcher("/customer_account.html");
                rd.forward(request,response);


            }else {
                System.out.println("Login Unsuccessful");
                RequestDispatcher rd=request.getRequestDispatcher("/customer_login");
                rd.forward(request,response);


            }
        }catch (ServletException|IOException e){
            System.out.println(e);
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    LoginDB(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    LoginDB(request,response);
    }
}
