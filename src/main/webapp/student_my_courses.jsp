<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="header.jsp"/>


<div class="mainCreateCourse">

    <%
        out.print("<h1>You have following courses registered: </h1>");
        out.print("<hr></br><table cellspacing='0' cellpadding='5' border='1'>");
        out.print("<tr>");
        out.print("<td><b>Student ID</b></td>");
        out.print("<td><b>Course Code</b></td>");
        out.print("<td><b>Semester</b></td>");
        out.print("</tr>");




        out.print(request.getAttribute("id"));

    %>

</div>

<div class="myCourse" action = "<%= request.getContextPath() %>/MyCourse">
</div>



</body>
</html>
