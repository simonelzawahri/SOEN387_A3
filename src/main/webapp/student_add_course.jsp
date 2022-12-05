
<jsp:include page="header.jsp"/>

<div class="mainAddCourse">
    <h1>Add a course</h1>
    <form action="<%= request.getContextPath() %>/StudentAddCourse" method="post">
        <br>
        <label for="Code">Course Code:</label>
        <input type = "number" name = "code" id = "code" />
        <br>
        <br>
        <label for="semester">Semester:</label>
        <select name="semester" id="semester" required>
            <option value="">Select one:</option>
            <option value="fall">Fall</option>
            <option value="winter">Winter</option>
            <option value="summer">Summer</option>
        </select>
        <br>
        <br>
        <input type = "submit" name = "submit" value = "Add" id="button"/>
    </form>

    <%
        if(request.getParameter("success") != null){
            out.print("<p style='color: green; font-weight: 600;'>Course Added Successfully!</p>");
        } else if(request.getParameter("failed") != null){
            out.print("<p style='color: red; font-weight: 600;'>Course Not Found in this semester.<br>Please verify Info.</p>");
        } else if(request.getParameter("alreadyRegistered") != null){
            out.print("<p style='color: red; font-weight: 600;'>Already registered for this course in this semester.</p>");
        }
    %>

</div>


</body>
</html>
