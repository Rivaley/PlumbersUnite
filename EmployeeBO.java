package com.example.plumbersunite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

    public class EmployeeBO {
        private String password;
        private String id;
        private String fname;
        private String lname;
        private int phone;
        private String area;
        private int deptId;
        private String scheduleId;

        public EmployeeBO(){
            id="";
            fname="";
            lname="";
            phone=0;
            area="";
            deptId=0;
            scheduleId="";
            password="";


        }
        public EmployeeBO(String Eid, String Efn, String Eln, int Eph, String Ea, int Did, String Sid){
            id=Eid;
            fname=Efn;
            lname=Eln;
            phone=Eph;
            area=Ea;
            deptId=Did;
            scheduleId=Sid;
        }
        public  void LoginDB(String i){
            id=i;
            try {
                Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                Connection conn= DriverManager.getConnection("jdbc:ucanaccess:/C:/Users/Ndure/PlumbersUDatabase1.accdb");
                Statement stmt= conn.createStatement();
                String sql="Select * from Technicians where TechID="+i;
                 ResultSet rs=stmt.executeQuery(sql);

                 rs.next();

                 conn.close();

            }catch (Exception e){


            }
        }
        public void SelectDB(String i){
            id=i;
            try {
                Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                Connection conn= DriverManager.getConnection("jdbc:ucanaccess:/C:/Users/Ndure/PlumbersUDatabase1.accdb");
                Statement stmt=conn.createStatement();
                String sql="Select * from Technicians where TechID= "+ i;
                ResultSet rs=stmt.executeQuery(sql);
                System.out.println(sql);
                if (rs.next()){
                    fname=rs.getString(2);
                    phone=rs.getInt(3);
                    area=rs.getString(4);
                    deptId=rs.getInt(5);



                }else{
                    conn.close();
                }


            }catch (Exception e){


            }

        }
        public void InsertDB(String Eid,String Efn,String Eln,int Eph,String Ea,int Did,String Sid){
            id=Eid;
            fname=Efn;
            lname=Eln;
            phone=Eph;
            area=Ea;
            deptId=Did;
            scheduleId=Sid;
            try {
                Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                Connection conn= DriverManager.getConnection("jdbc:ucanaccess:/C:/Users/Ndure/PlumbersUDatabase1.accdb");
                Statement stmt= conn.createStatement();
                String sql="Insert into Technicians values('"+getId()+","+getFname()+","+getPhone()+","+getArea()+ ',' +getDeptId()+")";
                System.out.println(sql);
                int n1=stmt.executeUpdate(sql);
                if (n1==1){
                    System.out.println("Insert Successful");

                }else {
                    System.out.println("Insert Failed");
                    conn.close();
                }
            }catch (Exception e){
                System.out.println(e);

            }

        }
        public void DeleteDB(){
            try {
                Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                Connection conn= DriverManager.getConnection("jdbc:ucanaccess:/C:/Users/Ndure/PlumbersUDatabase1.accdb");
                Statement stmt=conn.createStatement();
                String sql="Delete from Technicians where TechID="+getId()+"";
                System.out.println(sql);
                int n =stmt.executeUpdate(sql);
                if (n==1){
                    System.out.println("Delete Successful");
                }else{
                    System.out.println("Delete Unsuccessful");
                }

            }catch (Exception e){
                System.out.println(e);
            }

        }
        public void setPassword(String Epa){
            password=Epa;
        }
        public String getPassword(){
            return password;
        }
        public void setId(String Eid){
            id=Eid;
        }
        public String getId(){
            return id;
        }
        public void setFname(String Efn){
            fname=Efn;
        }
        public String getFname(){
            return fname;
        }
        public void setLname(String Eln){
            lname=Eln;
        }
        public String getLname(){
            return lname;
        }
        public void setPhone(int Eph){
            phone=Eph;
        }
        public int getPhone(){
            return phone;
        }
        public void setArea(String Ea){
            area=Ea;
        }
        public String getArea(){
            return area;
        }
        public void setDeptId(int Did){
            deptId=Did;
        }
        public int getDeptId(){
            return deptId;
        }
        public void setScheduleId(String Sid){
            scheduleId=Sid;
        }
        public String getScheduleId(){
            return scheduleId;
        }
    }
