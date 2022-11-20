<%@ page import="com.mysql.jdbc.Connection" %>
<%@ page import="java.text.DateFormat" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.text.SimpleDateFormat" %>
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
<% String message = (String) request.getAttribute("alertMsg");%>

<script type="text/javascript">
    msg = "<%=message%>";
    alert(msg);
</script>
</body>

<%--<form method="post">--%>
<%--    <table border="2">--%>
<%--        <tr>--%>
<%--            <td>Course Code</td>--%>
<%--            <td>Title</td>--%>
<%--            <td>Semester</td>--%>
<%--            <td>Days</td>--%>
<%--            <td>Time</td>--%>
<%--            <td>Instructor</td>--%>
<%--            <td>Room</td>--%>
<%--            <td>StartDate</td>--%>
<%--            <td>EndDate</td>--%>
<%--            <td>InstructorID</td>--%>
<%--        </tr>--%>
<%--        <%--%>
<%--            try {--%>
<%--                Class.forName("com.mysql.jdbc.Driver");--%>
<%--                String url = "jdbc:mysql://localhost/soen387_a1";--%>
<%--                String username = "root";--%>
<%--                String query = "select * from course";--%>
<%--                java.sql.Connection conn = DriverManager.getConnection(url, username, "");--%>
<%--                Statement stmt = conn.createStatement();--%>
<%--                ResultSet rs = stmt.executeQuery(query);--%>
<%--                DateFormat formatter = new SimpleDateFormat("hh:mm:ss.ssss");--%>

<%--                while (rs.next()) {--%>
<%--        %>--%>
<%--        <tr>--%>
<%--            <td><%=rs.getInt("Code") %>--%>
<%--            </td>--%>
<%--            <td><%=rs.getString("Title") %>--%>
<%--            </td>--%>
<%--            <td><%=rs.getInt("Semester") %>--%>
<%--            </td>--%>
<%--            <td><%=rs.getString("Days") %>--%>
<%--            </td>--%>
<%--            <td><%=(Date)formatter.parse(rs.getString("Time")) %>--%>
<%--            </td>--%>
<%--            <td><%=rs.getString("Instructor") %>--%>
<%--            </td>--%>
<%--            <td><%=rs.getString("Room") %>--%>
<%--            </td>--%>
<%--            <td><%=rs.getString("StartDate") %>--%>
<%--            </td>--%>
<%--            <td><%=rs.getString("EndDate") %>--%>
<%--            </td>--%>
<%--            <td><%=rs.getInt("InstructorID") %>--%>
<%--            </td>--%>
<%--        </tr>--%>
<%--        <%--%>
<%--            }--%>
<%--        %>--%>
<%--    </table>--%>
<%--    <%--%>
<%--            rs.close();--%>
<%--            stmt.close();--%>
<%--            conn.close();--%>
<%--        } catch (Exception e) {--%>
<%--            e.printStackTrace();--%>
<%--        }--%>
<%--    %>--%>

<%--</form>--%>
</html>

