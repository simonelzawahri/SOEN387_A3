
<jsp:include page="header.jsp"/>

<div class="mainHome">
    <h1><%= "Hello Homepage" %></h1>
    <%
        if ( !(session.getAttribute("id")==null) ) {
            out.print("<p>Welcome back, " + session.getAttribute("fname") + " " + session.getAttribute("lname") + "</p>");
        }
    %>

    <section style="text-align: left">
        DESIGN PATTERN ---> MVC
        <br>
        MODEL ---> BEAN
        <br>
        CONTROLLER ---> SERVLET
        <br>
        VIEW ---> JSP
        <br>
        INHERITANCE MAPPING ---> SINGLE TABLE INHERITANCE
        <br>
    </section>


</div>


</body>
</html>