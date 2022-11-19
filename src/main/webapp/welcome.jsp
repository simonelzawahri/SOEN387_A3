
<jsp:include page="header.jsp"/>

<%
    //if user visits page without logging in -> redirect to login
    if(session.getAttribute("id")==null ){
        response.sendRedirect("login.jsp");
    }
%>

<div class="mainWelcome">
    WELCOME, ${fname} ${lname}


</div>



</body>
</html>
