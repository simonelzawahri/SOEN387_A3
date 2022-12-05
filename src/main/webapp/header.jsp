<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>


<%
  //if user visits page without logging in -> redirect to login
  if(session.getAttribute("loginid")==null ){
    response.sendRedirect("login.jsp");
  }
%>

<!DOCTYPE html>
<html>
<head>
  <meta charset="ISO-8859-1">
  <title>Home</title>
  <link rel="stylesheet" href="index.css">
</head>

<body>

<header>
  <div class="nav">
    <a href="index.jsp"><img src="../images/transparentlogo.png" width="400" height="120"></a>
    <div class="nav-links">
      <ul>
        <li><a href="index.jsp">Home</a></li>
        <%
          if ( !(session.getAttribute("admin")==null) ) {
            String x = session.getAttribute("admin").toString();
            //if admin
            if(Integer.parseInt(x) == 1 ){
              out.print("<li><a href=\"admin_create_course.jsp\">Create a Course</a></li>");
              out.print("<li><a href=\"admin_student_course_list.jsp\">Student course-list</a></li>");
              out.print("<li><a href=\"admin_course_student_list.jsp\">Course student-list</a></li>");
            } //if student
            else if(Integer.parseInt(x) == 0 ){
              out.print("<li><a href=\"student_browse_courses.jsp\">Browse Courses</a></li>");
              out.print("<li><a href=\"student_my_courses.jsp\">My Courses</a></li>");
              out.print("<li><a href=\"student_add_course.jsp\">Add Course</a></li>");
              out.print("<li><a href=\"student_drop_course.jsp\">Drop Course</a></li>");
            }
            out.print("<li><a href=\"logout.jsp\">Logout</a></li>");
          } else {
            out.print("<li><a href=\"login.jsp\">Login</a></li>");
            out.print("<li><a href=\"signup.jsp\">Signup</a></li>");
          }


        %>
      </ul>
    </div>
  </div>
</header>