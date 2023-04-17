package com.example.plumbersunite;

import java.sql.*;

public class employeeBusinessObject {
    private String username;
    private String pwd;
    private String fname;
    private String lname;
    private int phone;
    private String email;
    private String deptName;
    private int scheduleId;
    public employeeBusinessObject() {
        username="";
        pwd="";
        fname="";
        lname="";
        phone=0;
        email="";
        deptName="";
        scheduleId=0;
    }
    public employeeBusinessObject(String Un, String Pw, String Fn, String Ln, int Ph, String Em, String Dn, int Sid) {
        username=Un;
        pwd=Pw;
        fname=Fn;
        lname=Ln;
        phone=Ph;
        email=Em;
        deptName=Dn;
        scheduleId=Sid;
    }
    public void selectDB(String i) {
        username=i;
        try{
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection c1 = DriverManager.getConnection("jdbc:ucanaccess:/C:/Users/Ndure/PlumbersUDatabase1.accdb");
            Statement stmt = c1.createStatement();
            String sql = "Select * from employees where emp_username = '"+getusername()+"'";
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println(sql);
            rs.next();
            pwd = rs.getString(2);
            fname = rs.getString(3);
            lname = rs.getString(4);
            phone = rs.getInt(5);
            email = rs.getString(6);
            deptName = rs.getString(7);
            scheduleId = rs.getInt(8);
            c1.close();
        } catch(Exception e) {
            System.out.println(e);
        }
    }
    public void insertDB(String Un, String Pw, String Fn, String Ln, int Ph, String Em, String Dn, int Sid) {
        username=Un;
        pwd=Pw;
        fname=Fn;
        lname=Ln;
        phone=Ph;
        email=Em;
        deptName=Dn;
        scheduleId=Sid;
        try{
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection c1 = DriverManager.getConnection("jdbc:ucanaccess:/C:/Users/Ndure/PlumbersUDatabase1.accdb");
            Statement stmt = c1.createStatement();
            String sql = "Insert into employees values('"+getusername()+"','"+getpwd()+"','"+getfname()+"','"+getlname()+"','"+getphone()+"','"+getemail()+"','"+getdeptName()+"','"+getscheduleId()+"')";
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
            String sql = "Delete from employees where emp_username='"+getusername()+"'";
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
            String sql = "Update employees set emp_pwd='"+getpwd()+"',"+" emp_fname='"+getfname()+"',"+" emp_lname='"+getlname()+"',"+" emp_phone='"+getphone()+"',"+" emp_email='"+getemail()+"',"+" dept_name='"+getdeptName()+"',"+" schedule_id='"+getscheduleId()+" where emp_username='"+getusername()+"'";
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

    public String getusername() {return username;}
    public void setusername(String Un) {username=Un;}
    
    public String getpwd() {return pwd;}
    public void setpwd(String Pw) {pwd=Pw;}
    
    public String getfname() {return fname;}
    public void setfname(String Fn) {fname=Fn;}
    
    public String getlname() {return lname;}
    public void setlname(String Ln) {lname=Ln;}
    
    public int getphone() {return phone;}
    public void setphone(int Ph) {phone=Ph;}
    
    public String getemail() {return email;}
    public void setemail(String Em) {email=Em;}
    
    public String getdeptName() {return deptName;}
    public void setdeptName(String Dn) {deptName=Dn;}
    
    public int getscheduleId() {return scheduleId;}
    public void setscheduleId(int Sid) {scheduleId=Sid;}
    
    public void display() {
        System.out.println("Username: " + username);
        System.out.println("Pwd: " + pwd);
        System.out.println("Fname: " + fname);
        System.out.println("Lname: " + lname);
        System.out.println("Phone: " + phone);
        System.out.println("Email: " + email);
        System.out.println("DeptName: " + deptName);
        System.out.println("ScheduleId: " + scheduleId);
    }
}
