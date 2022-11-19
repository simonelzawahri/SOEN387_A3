
<jsp:include page="header.jsp"/>


<div class="mainCreateCourse">
    <h1>Create a new course: </h1>
    <form action="<%= request.getContextPath() %>/createCourse" method="post">
        <%
            //REPLACE PHP
        %>

        <div>
            <p>Key in the course detail:</p>
            <label for="Code">Course Code:</label>
            <input type = "number" name = "course_code" id = "Code" /><br/>
            <br>
            <label for="Title">Course Title:</label>
            <input type = "text" name = "course_title" id = "Title" /><br/>
            <br>
            <label for="Semester">Semester:</label>
            <input type = "text" name = "course_semester" id = "Semester" /><br/>
            <br>
            <label for="Days">Days:</label>
            <input type = "text" name = "course_days" id = "Days" /><br/>
            <br>
            <label for="Time">Time:</label>
            <input type = "text" name = "course_time" id = "Time" /><br/>
            <br>
            <label for="Instructor">Instructor:</label>
            <input type = "text" name = "course_instructor" id = "Instructor" /><br/>
            <br>
            <label for="Room">Room:</label>
            <input type = "number" name = "course_room" id = "Room" /><br/>
            <br>
            <label for="StartDate">Start Date:</label>
            <input type = "date" name = "course_startdate" id = "StartDate" /><br/>
            <br>
            <label for="EndDate">End Date:</label>
            <input type = "date" name = "course_enddate" id = "EndDate" /><br/>
            <br>
            <label for="InstructorID">Instructor ID:</label>
            <input type = "number" name = "course_instructorid" id = "InstructorID" /><br/>
            <br>
            <input type = "submit" name = "submit" value = "Create" id="button" />
        </div>
        <br>
    </form>
</div>




</body>
</html>
