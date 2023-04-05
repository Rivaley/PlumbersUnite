package com.example.plumbersunite;

import java.sql.*;

public class CustomerBO {
    private int Customer_ID;
    private String Cust_FirstName;
    private String Cust_LastName;
    private String Cust_Phone;
    private String Cust_Email;
    private int Cust_AddressID;
    private String Cust_Username;
    private String Cust_Password;
    public CustomerBO(){
        Customer_ID=0;
        Cust_FirstName="";
        Cust_LastName="";
        Cust_Phone="";
        Cust_Email="";
        Cust_AddressID=0;
        Cust_Username="";
        Cust_Password="";
    }
    public CustomerBO(int cust_id,String cust_fn,String cust_ln,String cust_pn,String cust_ema,int cust_add,String cust_user,String cust_pass ){
        Customer_ID=cust_id;
        Cust_FirstName=cust_fn;
        Cust_LastName=cust_ln;
        Cust_Phone=cust_pn;
        Cust_Email=cust_ema;
        Cust_AddressID=cust_add;
        Cust_Username=cust_user;
        Cust_Password=cust_pass;
    }

    public void SelectDB(int i){
        Customer_ID=i;
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection conn= DriverManager.getConnection("jdbc:ucanaccess://C:/Users/Ndure/plumbersdb.accdb");
            System.out.println("Database Connected");
            Statement stmt=conn.createStatement();
            ResultSet rs=stmt.executeQuery("SELECT  * FROM customers WHERE customer_id="+i);
            if (rs.next()){
                setCustomer_ID(rs.getInt(1));
                setCust_FirstName(rs.getString(2));
                setCust_LastName(rs.getString(3));
                setCust_Phone(rs.getString(4));
                setCust_Email(rs.getString(5));
                setCust_AddressID(rs.getInt(6));

            }else {
                System.out.println("Connection Closed");
                conn.close();
            }
        }catch (ClassNotFoundException| SQLException e){


        }
    }
    public void InsertDB(int cust_id,String cust_fn,String cust_ln,String cust_pn,String cust_ema,int cust_add){
        Customer_ID=cust_id;
        Cust_FirstName=cust_fn;
        Cust_LastName=cust_ln;
        Cust_Phone=cust_pn;
        Cust_Email=cust_ema;
        Cust_AddressID=cust_add;
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection conn=DriverManager.getConnection("jdbc:ucanaccess:/C:/Users/Ndure/Downloads/plumbers_db.accdb");
            Statement stmt=conn.createStatement();
            String sql="INSERT INTO customers values ('\"+getCustomer_ID()+\"','\"+getCust_FirstName()+\"','\"+getCust_LastName()+\"','\"+getCust_Phone()+\"','\"+getCust_Email()+\"','\"+getCust_AddressID()+\"'";
            System.out.println(sql);
            ResultSet n1=stmt.executeQuery(sql);
            if (n1.equals(1)){
                System.out.println("Insert Successful");
            }else {
                System.out.println("Insert Failed");
            }


        }catch (Exception e){}
    }
    public void DeleteDB(){
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection conn=DriverManager.getConnection("jdbc:ucanaccess:/C:/Users/Ndure/plumbersdb.accdb");
            Statement stmt= conn.createStatement();
            String sql="Delete from customers WHERE employee_id="+getCustomer_ID()+"";
            System.out.println(sql);
            int n=stmt.executeUpdate(sql);
            if (n==1){
                System.out.println("Delete Successful");
            }else {
                System.out.println("Delete Unsuccessful");
            }
        }catch (Exception e){
            System.out.println(e);
        }

    }
     public void UpdateDB(){
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection conn=DriverManager.getConnection("jdbc:ucanaccess:/C:/Users/Ndure/plumbersdb.accdb");
            Statement stmt=conn.createStatement();
            String sql="Update customers set customer_id='"+getCustomer_ID()+"',"+"customer_fname='"+getCust_FirstName()+"',"+"customer_lname='"+getCust_LastName()+"',"+"customer_phone='"+getCust_Phone()+"',"+"customer_email='"+getCust_Email()+"'";
            System.out.println(sql);
            int n=stmt.executeUpdate(sql);
            if (n==1){
                System.out.println("Update Successful");
            }else {
                System.out.println("Update Failed");
                conn.close();
            }
        }catch (Exception e){
            System.out.println(e);
        }

    }
    public void setCustomer_ID(int cust_id){
        Customer_ID=cust_id;
    }
    public int getCustomer_ID(){
        return Customer_ID;
    }
    public void setCust_FirstName(String cust_fn){
        Cust_FirstName=cust_fn;
    }
    public String getCust_FirstName(){
        return Cust_FirstName;
    }
    public void setCust_LastName(String cust_ln){
        Cust_LastName=cust_ln;
    }
    public String getCust_LastName(){
        return Cust_LastName;
    }
    public void setCust_Phone(String cust_pn){
        Cust_Phone=cust_pn;
    }
    public String getCust_Phone(){
        return Cust_Phone;
    }
    public void setCust_Email(String cust_ema){
        Cust_Email=cust_ema;
    }
    public String getCust_Email(){
        return Cust_Email;
    }
    public void setCust_AddressID(int cust_add){
        Cust_AddressID=cust_add;
    }
    public int getCust_AddressID(){
        return Cust_AddressID;
    }
    public void setCust_Username(String cust_user){
        Cust_Username=cust_user;
    }
    public String getCust_Username(){
        return Cust_Username;
    }
    public void setCust_Password(String cust_pass){
        Cust_Password=cust_pass;
    }
    public String getCust_Password(){
        return Cust_Password;
    }
}
