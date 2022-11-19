
<jsp:include page="header.jsp"/>

<div class="mainCourseStudentList">
    ADMIN COURSE STUDENT LIST
    <form method = "post" action = "admin_course_student_list_action.php">
        <%
            //REPLACE PHP
        %>
        <div>
            <p>Key in the course ID to search registered student:</p>
            <label for="courseCode">Course Code:</label>
            <input type = "number" name = "course_code" id = "courseCode" />
            <br>
            <br>
            <input type = "submit" name = "submit" value = "Search" id="button"/>
        </div>
        <br/>
    </form>


</div>

</body>
</html>
