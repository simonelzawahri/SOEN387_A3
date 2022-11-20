<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %><%--
  Created by IntelliJ IDEA.
  User: shanshan
  Date: 11/13/2022
  Time: 4:22 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="ISO-8859-1">
  <title>Insert title here</title>

</head>
<body>
<%--<h1>Course successfully created!</h1>--%>
<% String message = (String) request.getAttribute("alertMsg");
    int id = (int) request.getAttribute("id");
%>

<script type="text/javascript">
  msg = "<%=message%>";
  alert(msg);
</script>
</body>

<form method="post">
  <table border="2">
    <tr>
      <td>ID</td>
      <td>Course Code</td>
      <td>Semester</td>
    </tr>
    <%
      try {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost/soen387_a1";
        String username = "root";
        String query = "select * from stu_courses where stu_id = " + id;
        Connection conn = DriverManager.getConnection(url, username, "");
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
    %>
    <tr>
      <td><%=rs.getInt("stu_id") %>
      </td>
      <td><%=rs.getInt("course_code") %>
      </td>
      <td><%=rs.getInt("semester") %>
      </td>
    </tr>
    <%
      }
    %>
  </table>
  <%
      rs.close();
      stmt.close();
      conn.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  %>

</form>
</html>

