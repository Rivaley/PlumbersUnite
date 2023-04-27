package com.example.plumbersunite;

import java.sql.*;

public class addressBusinessObject {
    private int id;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private int zip;
    public addressBusinessObject() {
        id=0;
        address1="";
        address2="";
        city="";
        state="";
        zip=0;
    }
    public addressBusinessObject(int Aid, String A1, String A2, String C, String S, int Z) {
        id=Aid;
        address1=A1;
        address2=A2;
        city=C;
        state=S;
        zip=Z;
    }
    public void selectDB(int i) {
        id=i;
        try{
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection c1 = DriverManager.getConnection("jdbc:ucanaccess:/C:/Users/Ndure/PlumbersUDatabase1.accdb");
            Statement stmt = c1.createStatement();
            String sql = "Select * from address where add_id = '"+getid()+"'";
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println(sql);
            rs.next();
            address1 = rs.getString(2);
            address2 = rs.getString(3);
            city = rs.getString(4);
            state = rs.getString(5);
            zip = rs.getInt(6);
            c1.close();
        } catch(Exception e) {
            System.out.println(e);
        }
    }
    public void insertDB(int Aid, String A1, String A2, String C, String S, int Z) {
        id=Aid;
        address1=A1;
        address2=A2;
        city=C;
        state=S;
        zip=Z;
        try{
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection c1 = DriverManager.getConnection("jdbc:ucanaccess:/C:/Users/Ndure/PlumbersUDatabase1.accdb");
            Statement stmt = c1.createStatement();
            String sql = "Insert into address values('"+getid()+"','"+getaddress1()+"','"+getaddress2()+"','"+getcity()+"','"+getstate()+"','"+getzip()+"')";
            System.out.println(sql);
            int n1 = stmt.executeUpdate(sql);
            if (n1==1)
                System.out.println("INSERT SUCCESSFUL!");
            else
                System.out.println("INSERT FAILED");
            c1.close();
        } catch(Exception e) {
            System.out.println(e);
        }
    }
    public void deleteDB() {
        try{
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection c1 = DriverManager.getConnection("jdbc:ucanaccess:/C:/Users/Ndure/PlumbersUDatabase1.accdb");
            Statement stmt = c1.createStatement();
            String sql = "Delete from Employees where add_id='"+getid()+"'";
            System.out.println(sql);
            int n = stmt.executeUpdate(sql);
            if (n==1)
                System.out.println("DELETE SUCCESSFUL!");
            else
                System.out.println("DELETE FAILED");
            c1.close();
        } catch(Exception e) {
            System.out.println(e);
        }
    }
    public void updateDB() {
        try{
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection c1 = DriverManager.getConnection("jdbc:ucanaccess:/C:/Users/Ndure/PlumbersUDatabase1.accdb");
            Statement stmt = c1.createStatement();
            String sql = "Update Employees set add_1='"+getaddress1()+"',"+" add_2='"+getaddress2()+"',"+" add_city='"+getcity()+"',"+" add_state='"+getstate()+"',"+" add_zip='"+getzip()+" where add_id='"+getid()+"'";
            System.out.println(sql);
            int n =stmt.executeUpdate(sql);
            if (n==1)
                System.out.println("UPDATE SUCCESSFUL!");
            else
                System.out.println("UPDATE FAILED");
            c1.close();
        } catch(Exception e) {
            System.out.println(e);
        }
    }
    
    public int getid() {return id;}
    public void setid(int Aid) {id=Aid;}
    
    public String getaddress1() {return address1;}
    public void setaddress1(String A1) {address1=A1;}
    
    public String getaddress2() {return address2;}
    public void setaddress2(String A2) {address2=A2;}
    
    public String getcity() {return city;}
    public void setcity(String C) {city=C;}
    
    public String getstate() {return state;}
    public void setstate(String S) {state=S;}
    
    public int getzip() {return zip;}
    public void setzip(int Z) {zip=Z;}
    
    public void display() {
        System.out.println("Id: " + id);
        System.out.println("Address1: " + address1);
        System.out.println("Address2: " + address2);
        System.out.println("City: " + city);
        System.out.println("State: " + state);
        System.out.println("Zip: " + zip);
    }
}