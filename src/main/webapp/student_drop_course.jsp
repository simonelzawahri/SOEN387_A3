
<jsp:include page="header.jsp"/>

<div class="mainDropCourse">

  <h1>Drop an existing course: </h1>
  <form action="<%= request.getContextPath() %>/DropStudentCourse" method="post">

    <label for="Id">Student ID:</label>
    <input type = "number" name = "stu_id" id = "Id" /><br/>
    <label for="Code">Course Code:</label>
    <input type = "number" name = "course_code" id = "Code" /><br/>
    <br>
    <label for="Semester">Semester:</label>
    <input type = "string" name = "course_semester" id = "Semester" /><br/>
    <br>
    <p>Enter desired date for testing purpose</p>
    <input type = "date" name = "date_input" id = "date_input" />
    <input type = "submit" name = "submit" value = "Drop" id="button"/>

  </form>
</div>


</body>
</html>
