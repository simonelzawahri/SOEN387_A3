<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="header.jsp"/>


<div class="mainCreateCourse">

    <%
        out.println("<h1>You have following courses registered: </h1>");
        out.println("<hr></br><table cellspacing='0' cellpadding='5' border='1'>");
        out.println("<tr>");
        out.println("<td><b>Student ID</b></td>");
        out.println("<td><b>Course Code</b></td>");
        out.println("<td><b>Semester</b></td>");
        out.println("</tr>");




        out.print(request.getAttribute("id"));

    %>

</div>

<div class="myCourse" action = "<%= request.getContextPath() %>/MyCourse">
</div>



</body>
</html>
