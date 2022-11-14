<%--
  Created by IntelliJ IDEA.
  User: shanshan
  Date: 11/13/2022
  Time: 4:23 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>course register page</title>
</head>
<body>
<div align="center">
    <h1>Employee Register Form</h1>
    <form action="<%= request.getContextPath() %>/createCourse" method="post">

        <p>Key in the course detail:</p>
        <label for="Code">Course Code:</label>
        <input type = "number" name = "course_code" id = "Code" /><br/>
        <br>
        <label for="Title">Course Title:</label>
        <input type = "string" name = "course_title" id = "Title" /><br/>
        <br>
        <label for="Semester">Semester:</label>
        <input type = "string" name = "course_semester" id = "Semester" /><br/>
        <br>
        <label for="Days">Days:</label>
        <input type = "string" name = "course_days" id = "Days" /><br/>
        <br>
        <label for="Time">Time:</label>
        <input type = "string" name = "course_time" id = "Time" /><br/>
        <br>
        <label for="Instructor">Instructor:</label>
        <input type = "string" name = "course_instructor" id = "Instructor" /><br/>
        <br>
        <label for="Room">Room:</label>
        <input type = "number" name = "course_room" id = "Room" /><br/>
        <br>
        <label for="StartDate">Start Date:</label>
        <input type = "date" name = "course_startdate" id = "StartDate" /><br/>
        <br>
        <label for="EndDate">End Date:</label>
        <input type = "date" name = "course_enddate" id = "EndDate" /><br/>
        <br>
        <label for="InstructorID">Instructor ID:</label>
        <input type = "number" name = "course_instructorid" id = "InstructorID" /><br/>
        <br>
        <input type = "submit" name = "submit" value = "Create" id="button"/>
    </form>
</div>
</body>
</html>