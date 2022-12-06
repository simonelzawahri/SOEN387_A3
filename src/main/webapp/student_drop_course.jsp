
<jsp:include page="header.jsp"/>

<div class="mainDropCourse">

  <h1>Drop a course</h1>
  <form action="<%= request.getContextPath() %>/DropCourse" method="post">
    <br>
    <label for="code">Course Code:</label>
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
    <input type = "submit" name = "submit" value = "Drop" id="button"/>
  </form>

  <%
    if(request.getParameter("success") != null){
      out.print("<p style='color: green; font-weight: 600;'>Course Successfully Dropped!</p>");
    } else if(request.getParameter("courseDoesNotExist") != null){
      out.print("<p style='color: red; font-weight: 600;'>Course does not exist in this semester.<br>Please verify Info.</p>");
    } else if(request.getParameter("notRegistered") != null){
      out.print("<p style='color: red; font-weight: 600;'>You are not registered for this course in this semester.</p>");
    }
  %>


</div>


</body>
</html>
