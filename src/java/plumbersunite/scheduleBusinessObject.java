package com.example.plumbersunite;

import java.sql.*;

public class scheduleBusinessObject {
    private int id;
    private String dayOfWeek;
    private String shiftStart;
    private String shiftEnd;
    public scheduleBusinessObject() {
        id=0;
        dayOfWeek="";
        shiftStart="";
        shiftEnd="";
    }
    public scheduleBusinessObject(int i, String dow, String SS, String SE) {
        id=i;
        dayOfWeek=dow;
        shiftStart=SS;
        shiftEnd=SE;
    }
    public void selectDB(int i) {
        id=i;
        try{
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection c1 = DriverManager.getConnection("jdbc:ucanaccess:/C:/Users/Ndure/PlumbersUDatabase1.accdb");
            Statement stmt = c1.createStatement();
            String sql = "Select * from schedule where schedule_id = '"+getid()+"'";
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println(sql);
            rs.next();
            dayOfWeek = rs.getString(2);
            shiftStart = rs.getString(3);
            shiftEnd = rs.getString(4);
            c1.close();
        } catch(Exception e) {
            System.out.println(e);
        }
    }
    public void insertDB(int i, String dow, String SS, String SE) {
        id=i;
        dayOfWeek=dow;
        shiftStart=SS;
        shiftEnd=SE;
        try{
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection c1 = DriverManager.getConnection("jdbc:ucanaccess:/C:/Users/Ndure/PlumbersUDatabase1.accdb");
            Statement stmt = c1.createStatement();
            String sql = "Insert into schedule values('"+getid()+"','"+getdayOfWeek()+"','"+getshiftStart()+"','"+getshiftEnd()+"')";
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
            String sql = "Delete from schedule where schedule_id='"+getid()+"'";
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
            String sql = "Update schedule set day_of_week='"+getdayOfWeek()+"',"+" shift_start='"+getshiftStart()+"',"+" shift_end='"+getshiftEnd()+"',"+" where schedule_id='"+getid()+"'";
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
    public void setid(int i) {id=i;}
    
    public String getdayOfWeek() {return dayOfWeek;}
    public void setdayOfWeek(String dow) {dayOfWeek=dow;}
    
    public String getshiftStart() {return shiftStart;}
    public void setshiftStart(String SS) {shiftStart=SS;}
    
    public String getshiftEnd() {return shiftEnd;}
    public void setshiftEnd(String SE) {shiftEnd=SE;}
    
    public void display() {
        System.out.println("Id: " + id);
        System.out.println("DatOfWeek: " + dayOfWeek);
        System.out.println("ShiftStart: " + shiftStart);
        System.out.println("ShiftEnd: " + shiftEnd);
    }
}
