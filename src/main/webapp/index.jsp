
<jsp:include page="header.jsp"/>

<div class="mainHome">
    <h1><%= "Hello Homepage" %></h1>
    <%
        if ( !(session.getAttribute("id")==null) ) {
            out.print("<p>Welcome back, " + session.getAttribute("fname") + " " + session.getAttribute("lname") + "</p>");
        }
    %>



</div>


</body>
</html>