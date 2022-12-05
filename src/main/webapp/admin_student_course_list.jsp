<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.soen387_a2.bean.Course" %>
<jsp:include page="header.jsp"/>


<div class="mainStudentCourseList">
    <h1>Student Course List</h1>
    <form method = "post" action="<%= request.getContextPath() %>/StudentCourseList">
        <div>
            <p>Enter student ID to get registered courses:</p>
            <label for="studentCode">Student ID:</label>
            <input type = "number" name = "stu_id" id = "studentCode" />
            <br>
            <br>
            <input type = "submit" name = "submit" value = "Search" id="button"/>
        </div>
        <br>
    </form>

    <div class="table">
        <%
            if(request.getParameter("gotit") != null){
                ArrayList<Course> courses = (ArrayList<Course>) request.getSession().getAttribute("list");
                //print courses
                out.print("    <table>\n" +
                        "        <tr>\n" +
                        "            <th>Course Code</th>\n" +
                        "            <th>Course Title</th>\n" +
                        "            <th>Semester</th>\n" +
                        "            <th>Days</th>\n" +
                        "            <th>Time</th>\n" +
                        "            <th>Instructor</th>\n" +
                        "            <th>Room</th>\n" +
                        "            <th>Start Date</th>\n" +
                        "            <th>End Date</th>\n" +
                        "            <th>InstructorID</th>\n" +
                        "        </tr>\n");
                for (Course c: courses) {
                    out.print("        <tr>\n" +
                            "            <td>" + c.getCode() +"</td>\n" +
                            "            <td>" + c.getTitle() +"</td>\n" +
                            "            <td>" + c.getSemester() +"</td>\n" +
                            "            <td>" + c.getDays() +"</td>\n" +
                            "            <td>" + c.getTime() +"</td>\n" +
                            "            <td>" + c.getInstructor() +"</td>\n" +
                            "            <td>" + c.getRoom() +"</td>\n" +
                            "            <td>" + c.getStartDate() +"</td>\n" +
                            "            <td>" + c.getEndDate() +"</td>\n" +
                            "            <td>" + c.getInstructorId() +"</td>\n" +
                            "        </tr>\n");
                }
                out.print("    </table>\n");
            }
        %>
    </div>



</div>



</body>
</html>
