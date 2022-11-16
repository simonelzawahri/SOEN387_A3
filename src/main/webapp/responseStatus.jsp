<%--
  Created by IntelliJ IDEA.
  User: shanshan
  Date: 11/13/2022
  Time: 4:22 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="ISO-8859-1">
  <title>Insert title here</title>

</head>
<body>
<%--<h1>Course successfully created!</h1>--%>
<% String message = (String)request.getAttribute("alertMsg");%>

<script type="text/javascript">
  msg = "<%=message%>";
  alert(msg);
</script>
</body>
</html>
