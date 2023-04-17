package com.example.plumbersunite;

import java.sql.*;
import java.sql.Timestamp;
import java.util.Date;

public class appointmentBusinessObject {
    private int id;
    private String empUsername;
    private String custUsername;
    private String serviceName;
    private Date date;
    private Timestamp start;
    private Timestamp end;
    public appointmentBusinessObject() {
        id=0;
        empUsername="";
        custUsername="";
        serviceName="";
        date=new Date(date.getTime());
        start=new Timestamp(start.getTime());
        end=new Timestamp(end.getTime());
    }
    public appointmentBusinessObject(int Aid, String EU, String CU, String SN, Date d, Timestamp s, Timestamp e) {
        id=Aid;
        empUsername=EU;
        custUsername=CU;
        serviceName=SN;
        date=d;
        start=s;
        end=e;
    }
    public void selectDB(int i) {
        id=i;
        try{
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection c1 = DriverManager.getConnection("jdbc:ucanaccess:/C:/Users/Ndure/PlumbersUDatabase1.accdb");
            Statement stmt = c1.createStatement();
            String sql = "Select * from appointment where appt_id = '"+getid()+"'";
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println(sql);
            rs.next();
            empUsername = rs.getString(2);
            custUsername = rs.getString(3);
            serviceName = rs.getString(4);
            date = rs.getDate(5);
            start = rs.getTimestamp(6);
            end = rs.getTimestamp(7);
            c1.close();
        } catch(Exception ex) {
            System.out.println(ex);
        }
    }
    public void insertDB(int Aid, String EU, String CU, String SN, Date d, Timestamp s, Timestamp e) {
        id=Aid;
        empUsername=EU;
        custUsername=CU;
        serviceName=SN;
        date=d;
        start=s;
        end=e;
        try{
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection c1 = DriverManager.getConnection("jdbc:ucanaccess:/C:/Users/Ndure/PlumbersUDatabase1.accdb");
            Statement stmt = c1.createStatement();
            String sql = "Insert into appointment values('"+getid()+"','"+getempUsername()+"','"+getcustUsername()+"','"+getserviceName()+"','"+getdate()+"','"+getstart()+"','"+getend()+"')";
            System.out.println(sql);
            int n1 = stmt.executeUpdate(sql);
            if (n1==1)
                System.out.println("INSERT SUCCESSFUL!");
            else
                System.out.println("INSERT FAILED");
            c1.close();
        } catch(Exception ex) {
            System.out.println(ex);
        }
    }
    public void deleteDB() {
        try{
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection c1 = DriverManager.getConnection("jdbc:ucanaccess:/C:/Users/Ndure/PlumbersUDatabase1.accdb");
            Statement stmt = c1.createStatement();
            String sql = "Delete from appointment where appt_id='"+getid()+"'";
            System.out.println(sql);
            int n = stmt.executeUpdate(sql);
            if (n==1)
                System.out.println("DELETE SUCCESSFUL!");
            else
                System.out.println("DELETE FAILED");
            c1.close();
        } catch(Exception ex) {
            System.out.println(ex);
        }
    }
    public void updateDB() {
        try{
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection c1 = DriverManager.getConnection("jdbc:ucanaccess:/C:/Users/Ndure/PlumbersUDatabase1.accdb");
            Statement stmt = c1.createStatement();
            String sql = "Update appointment set emp_username='"+getempUsername()+"',"+" cust_username='"+getcustUsername()+"',"+" service_name='"+getserviceName()+"',"+" appt_date='"+getdate()+"',"+" appt_start='"+getstart()+"',"+" appt_end='"+getend()+"',"+" where appt_id='"+getid()+"'";
            System.out.println(sql);
            int n =stmt.executeUpdate(sql);
            if (n==1)
                System.out.println("UPDATE SUCCESSFUL!");
            else
                System.out.println("UPDATE FAILED");
            c1.close();
        } catch(Exception ex) {
            System.out.println(ex);
        }
    }

    public int getid() {return id;}
    public void setid(int Aid) {id=Aid;}
    
    public String getempUsername() {return empUsername;}
    public void setempUsername(String EU) {empUsername=EU;}
    
    public String getcustUsername() {return custUsername;}
    public void setcustUsername(String CU) {custUsername=CU;}
    
    public String getserviceName() {return serviceName;}
    public void setserviceName(String SN) {serviceName=SN;}
    
    public Date getdate() {return date;}
    public void setdate(Date d) {date=d;}
    
    public Timestamp getstart() {return start;}
    public void setstart(Timestamp s) {start=s;}
    
    public Timestamp getend() {return end;}
    public void setend(Timestamp e) {end=e;}
    
    public void display() {
        System.out.println("Id: " + id);
        System.out.println("EmpUsername: " + empUsername);
        System.out.println("CustUsername: " + custUsername);
        System.out.println("ServiceName: " + serviceName);
        System.out.println("date: " + date);
        System.out.println("start: " + start);
        System.out.println("end: " + end);
    }
}
