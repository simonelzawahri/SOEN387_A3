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
  <nav>
    <a href="index.jsp">Home</a>
    <a href="login.jsp">Login</a>
    <a href="signup.jsp">Signup</a>

    <%
      if ( !(session.getAttribute("admin")== null) ) {
        String x = session.getAttribute("admin").toString();
        //if admin
        if(Integer.parseInt(x) == 1 ){
          out.print("<a href=\"createCoursePage.jsp\">Create a Course</a>");
          out.print("<a href=\"admin_student_course_list.jsp\">Get Student course-list</a>");
          out.print("<a href=\"admin_course_student_list.jsp\">Get Course student-list</a>");
        }
        //if student
        if(Integer.parseInt(x) == 0 ){
          out.print("<a href=\"student_add_course.jsp\">Add Course</a>");
          out.print("<a href=\"student_drop_course.jsp\">Drop Course</a>");
          out.print("<a href=\"xxx.jsp\">Another thing</a>");
        }

      }

    %>


  </nav>
</header>