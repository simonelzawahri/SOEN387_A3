<%--<%@ page import="java.io.PrintWriter" %>--%>
<jsp:include page="header.jsp"/>

<div class="mainLogin">
    <h1>Login</h1>
    <form method="POST" action="<%= request.getContextPath() %>/login" id="LoginForm">
        <label for="loginID">ID: </label>
        <input type="text" name="loginID" id="loginID" required>
        <br>
        <label for="loginPass">Password: </label>
        <input type="password" name="loginPass" id="loginPass" required>
        <br>
        <input type="submit" name="submit" value="Login" id="button">
        <%
            if(request.getParameter("errorIncorrectPassword") != null){
                out.print("<p style='color: red; font-weight: 600;'>Incorrect Password!<br>Try again.</p>");
            }
            if(request.getParameter("errorUserNotFound") != null){
                out.print("<p style='color: red; font-weight: 600;'>ID not Found!<br>Try again.</p>");
            }
        %>
    </form>

</div>



</body>
</html>
