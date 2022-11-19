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
    </form>

<%--    <%--%>
<%--        if(request.getParameter("error") == "incorrectPass"){--%>
<%--            PrintWriter outt = response.getWriter();--%>
<%--            outt.println("INCORRECT PASSWORD ");--%>
<%--        }--%>
<%--    %>--%>
</div>



</body>
</html>
