<%@page import="com.example.plumbersunite.appointmentBusinessObject"%>
<%@page import="java.sql.*"%>
<%
    String service = request.getParameter("serviceName");
    try {
        Class.forName("com.mysql.jdbc.Driver");
    } catch (Exception e) {
        e.printStackTrace();
    }
    Connection connection;
    Statement statement;
    ResultSet resultSet;
%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <link rel="stylesheet" href="style.css">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <title>Manage Jobs</title>
  </head>


  <body>

<!-- Nav Bar -->
<nav class = "navbar navbar-expand-lg bg-light navbar-light"> 
  <div class = "container">
  <a href="#" class="navbar-brand">Plumbers Unite Admin</a>

  <button class="navbar-toggler" type ="button" data-bs-toggle="collapse" data-bs-target="#navmenu"> 
      <span class="navbar-toggler-icon"></span>
  </button>



  <div class="collapse navbar-collapse" id="navmenu">
      <ul class="navbar-nav ms-auto">
          <li class="nav-item">
          <a href="#" class="nav-link">Schedule</a>
          </li>

          <li class="nav-item">
              <a href="#" class="nav-link">Techs</a>
              </li>

          <li class="nav-item">
              <a href="admin_manage-jobs.html" class="nav-link">Jobs</a>
              </li>
              <li class="nav-item">
                  <a href="#" class="nav-link">My Account</a>
                  </li>
      </ul>
  </div>
</div>
</nav>

<!-- main container-->
<div class="container">
          <%
          try {
          connection = DriverManager.getConnection("https://github.com/Rivaley/PlumbersUnite/raw/main/src/plumbers_db.accdb", "root", "");
          statement = connection.createStatement();
          String service_name = null;
          %>
        
    <div class="container w-75" id="manage_jobs">
        <h1 style="margin-top:80px ; margin-bottom:40px">Manage Jobs</h1>

        <!-- Search Jobs-->
        <form>
           <div class="d-flex form-group w-100" style="margin:20px;">
            <label for="job_search">Search Jobs</label>
            <input type="text" class="form-control" id="search_jobs" placeholder="Enter job ID #" name=<%=service_name%>>
            <button type="submit" class="btn btn-primary m-2" id="btn_searchjobs">Submit</button>
            </div>
  
        </form>

    </div>

          <%
          service_name = request.getParameter("service_name");
          String sql= "select * from appointment where service_name = " + service_name;
          resultSet = statement.executeQuery(sql);
          while(resultSet.next()){
          %>

          <!-- Open Jobs-->
    <div class="container w-75" id="open_jobs">
      <h3 style="margin-top:80px ; margin-bottom:40px ; text-align: center; color:rgb(235, 162, 162);">Open Jobs</h3>
    <table class="table table-striped text-center">
      <thead>
        <tr>
          <th scope="col">Date / Time Frame</th>
          <th scope="col">Service</th>
          <th scope="col">Plumber</th>
          <th scope="col">Job ID</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td id ="job_datetime" style="vertical-align: middle;"><%=resultSet.getString("appt_date")%> from <%=resultSet.getString("appt_start")%> to <%=resultSet.getString("appt_end")%></th>
          <td id="job_name" style="vertical-align: middle;"><%=resultSet.getString("service_name")%></td>
          <td id="job_plumber" style="vertical-align: middle;">
            <select class="form-control">
                <%
                    Connection con = DriverManager.getConnection("https://github.com/Rivaley/PlumbersUnite/raw/main/src/plumbers_db.accdb", "root", "");
                    Statement stmt = connection.createStatement();
                    String sql2 = "Select emp_username from appointment";
                    ResultSet rs = stmt.executeQuery(sql2);
                    rs.next();
                    %>
              <option id = "plumber_1"><%=rs.getString(1)%></option>
              <option id = "plumber_2"><%=rs.getString(2)%></option>
              <option id = "plumber_3"><%=rs.getString(3)%></option>
              <option id = "plumber_4"><%=rs.getString(4)%></option>
              <option id = "plumber_5"><%=rs.getString(5)%></option>

            </select>
            </td>
          <td id="job_id" style="vertical-align: middle;"><%=resultSet.getString("appt_id")%></td>
          <td id="assign_plumber" width="40px">
            <button type="submit" class="btn btn-primary m-5" id="btn_assignplumber">Assign Plumber</button>
          </td>
        </tr>

      </tbody>
    </table>

  </div>

  <!-- Scheduled Jobs-->
  <div class="container w-75" id="scheduled_jobs">
    <h3 style="margin-top:80px ; margin-bottom:40px; text-align: center; color: rgb(140, 230, 190)">Scheduled Jobs</h3>
  <table class="table table-hover text-center">
    <thead>
      <tr>
        <th scope="col">Date / Time Frame</th>
        <th scope="col">Service</th>
        <th scope="col">Plumber</th>
        <th scope="col">Job ID</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td id ="job_datetime" style="vertical-align: middle;"><%=resultSet.getString("appt_date")%> from <%=resultSet.getString("appt_start")%> to <%=resultSet.getString("appt_end")%></th>
        <td id="job_name" style="vertical-align: middle;"><%=resultSet.getString("service_name")%></td>
        <td id="job_plumber" style="vertical-align: middle;"><%=resultSet.getString("emp_username")%></td>
        <td id="job_id" style="vertical-align: middle;"><%=resultSet.getString("appt_id")%></td>
        <td id="manage_apt" width="40px">
          <button type="submit" class="btn btn-primary m-5" id="btn_manageapt">Manage Appointment</button>
        </td>
      </tr>

    </tbody>
  </table>
        <%
        }
        connection.close();
        } catch (Exception e) {
        e.printStackTrace();
        }
        %>

</div>



</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
  </body>
</html>
