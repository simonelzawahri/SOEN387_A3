
<jsp:include page="header.jsp"/>


<div class="mainCreateCourse">
    <h1>Create a new course: </h1>
    <form method="post" action="<%= request.getContextPath() %>/CreateCourse" >
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
            <input type = "text" name = "course_room" id = "Room" /><br/>
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


        <%

            if (request.getParameter("courseCodeAlreadyExists") != null){
                out.print("<p style='color: red; font-weight: 600;'>Course Code Already Exists!<br> Enter a unique Course Code.</p>");
            }
            if (request.getParameter("invalidInstructorID") != null){
                out.print("<p style='color: red; font-weight: 600;'>Invalid Instructor ID!<br> Please enter your unique ID.</p>");
            }
            if (request.getParameter("createCourseSuccess") != null){
                out.print("<p style='color: green; font-weight: 600;'>Course created successfully!<br></p>");
            }



        %>
    </form>
</div>




</body>
</html>
