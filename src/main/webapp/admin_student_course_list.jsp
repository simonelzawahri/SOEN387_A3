
<jsp:include page="header.jsp"/>


<div class="mainStudentCourseList">
    ADMIN STUDENT COURSE LIST
    <form method = "post" action = "../admin_reportByCourse.php">
        <%
            //REPLACE PHP
        %>
        <div>
            <p>Key in the student ID to search registered courses:</p>
            <label for="studentCode">Student ID:</label>
            <input type = "number" name = "stu_id" id = "studentCode" />
            <br>
            <br>
            <input type = "submit" name = "submit" value = "Search" id="button"/>
        </div>
        <br>
    </form>

</div>



</body>
</html>
