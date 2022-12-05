<%@ page import="com.example.soen387_a2.bean.Student" %>
<%@ page import="java.util.ArrayList" %>
<jsp:include page="header.jsp"/>

<div class="mainCourseStudentList">
    <h1>Course Student List</h1>
    <form method = "post" action="<%= request.getContextPath() %>/CourseStudentList">
        <div>
            <p>Enter course ID to generate student list:</p>
            <label for="courseCode">Course Code:</label>
            <input type = "number" name = "courseCode" id = "courseCode" />
            <br>
            <br>
            <input type = "submit" name = "submit" value = "Search" id="button"/>
        </div>
        <br/>
    </form>

    <div class="table">
        <%
            if(request.getParameter("gotit") != null){
                ArrayList<Student> students = (ArrayList<Student>) request.getSession().getAttribute("list");
                //print students
                out.print("    <table>\n" +
                        "        <tr>\n" +
                        "            <th>Student ID</th>\n" +
                        "            <th>First Name</th>\n" +
                        "            <th>Last Name</th>\n" +
                        "            <th>Address</th>\n" +
                        "            <th>Email</th>\n" +
                        "            <th>Phone</th>\n" +
                        "            <th>DOB</th>\n" +
                        "        </tr>\n");
                for (Student s: students) {
                    out.print("        <tr>\n" +
                            "            <td>" + s.getId() +"</td>\n" +
                            "            <td>" + s.getFirstName() +"</td>\n" +
                            "            <td>" + s.getLastName() +"</td>\n" +
                            "            <td>" + s.getAddress() +"</td>\n" +
                            "            <td>" + s.getEmail() +"</td>\n" +
                            "            <td>" + s.getPhone() +"</td>\n" +
                            "            <td>" + s.getDob() +"</td>\n" +
                            "        </tr>\n");
                }
                out.print("    </table>\n");
            }
        %>
    </div>


</div>

</body>
</html>
