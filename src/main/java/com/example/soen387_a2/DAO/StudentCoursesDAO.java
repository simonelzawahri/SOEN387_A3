package com.example.soen387_a2.DAO;

import com.example.soen387_a2.bean.Course;
import com.example.soen387_a2.bean.Student;
import com.example.soen387_a2.bean.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;


public class StudentCoursesDAO {


    protected Connection getConnection(){
        Connection conn;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/soen387__a1", "root", "");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return conn;
    }


    public ArrayList<Course> getCoursesByStudentID(int id){
        String stmt = "SELECT * FROM student_courses WHERE ID=?";
        ArrayList<Course> courses = new ArrayList<Course>();
        try {
            //establish connection
            Connection conn = getConnection();
            //create statement using connection object
            PreparedStatement ps = conn.prepareStatement(stmt);
            ps.setInt(1, id);
            //execute query
            ResultSet rs = ps.executeQuery();
            //read data from ResultSet and store courses in ArrayList of Course obj
            while(rs.next()){
                //read data from ResultSet
                int course_code = Integer.parseInt(rs.getString("Code"));
                String semester = rs.getString("semester");
                //set data to Course obj and add to ArrayList
                Course c = new Course();
                c.setCode(course_code);
                c.setSemester(semester);
                courses.add(c);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        //use CourseDAO to get Course data for each course
        CourseDAO courseDAO = new CourseDAO();
        for (Course c: courses) {
            c.setTitle( courseDAO.selectCourseByCourseCode(c.getCode()).getTitle() );
            c.setDays( courseDAO.selectCourseByCourseCode(c.getCode()).getDays() );
            c.setTime( courseDAO.selectCourseByCourseCode(c.getCode()).getTime() );
            c.setInstructor( courseDAO.selectCourseByCourseCode(c.getCode()).getInstructor() );
            c.setRoom( courseDAO.selectCourseByCourseCode(c.getCode()).getRoom() );
            c.setStartDate( courseDAO.selectCourseByCourseCode(c.getCode()).getStartDate() );
            c.setEndDate( courseDAO.selectCourseByCourseCode(c.getCode()).getEndDate() );
            c.setInstructorId( courseDAO.selectCourseByCourseCode(c.getCode()).getInstructorId() );
        }
        return courses;
    }



    public ArrayList<Student> getStudentsByCourseCode(int code, String semester){
        String stmt = "SELECT * FROM student_courses WHERE Code=? AND Semester=?";
        ArrayList<Student> students = new ArrayList<Student>();
        try {
            //establish connection
            Connection conn = getConnection();
            //create statement using connection object
            PreparedStatement ps = conn.prepareStatement(stmt);
            ps.setInt(1, code);
            ps.setString(2, semester);
            //execute query
            ResultSet rs = ps.executeQuery();
            //read data from ResultSet and store students in ArrayList of Student obj
            while(rs.next()){
                //read data from ResultSet
                int id = Integer.parseInt(rs.getString("ID"));
//                int code = Integer.parseInt(rs.getString("Code"));
//                String semester = rs.getString("semester");
                //set data to Student obj and add to ArrayList
                Student s = new Student();
                s.setId(id);
                students.add(s);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        //use UserDAO to get Student data for each student
        UserDAO dao = new UserDAO();
        for (Student s: students) {
            s.setFirstName( dao.selectUser(s.getId()).getFirstName() );
            s.setLastName( dao.selectUser(s.getId()).getLastName() );
            s.setAddress( dao.selectUser(s.getId()).getAddress() );
            s.setEmail( dao.selectUser(s.getId()).getEmail() );
            s.setPhone( dao.selectUser(s.getId()).getPhone() );
            s.setDob( dao.selectUser(s.getId()).getDob() );
        }
        return students;
    }


    public ArrayList<Course> getMyCourses(int id, String semester){
        String stmt = "SELECT * FROM student_courses WHERE ID=? AND Semester=?";
        ArrayList<Course> courses = new ArrayList<Course>();
        try {
            //establish connection
            Connection conn = getConnection();
            //create statement using connection object
            PreparedStatement ps = conn.prepareStatement(stmt);
            ps.setInt(1, id);
            ps.setString(2, semester);
            //execute query
            ResultSet rs = ps.executeQuery();
            //read data from ResultSet
            while(rs.next()){
                //read data from ResultSet
                int rs_code = Integer.parseInt(rs.getString("Code"));
                String rs_semester = rs.getString("Semester");
                //set data to course object
                Course course = new Course();
                course.setCode(rs_code);
                course.setSemester(rs_semester);
                courses.add(course);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        //use CourseDAO to get course data
        CourseDAO dao = new CourseDAO();
        for (Course c: courses) {
            c.setTitle( dao.selectCourseByCourseCode(c.getCode()).getTitle() );
            c.setDays( dao.selectCourseByCourseCode(c.getCode()).getDays() );
            c.setTime( dao.selectCourseByCourseCode(c.getCode()).getTime() );
            c.setInstructor( dao.selectCourseByCourseCode(c.getCode()).getInstructor() );
            c.setRoom( dao.selectCourseByCourseCode(c.getCode()).getRoom() );
            c.setStartDate( dao.selectCourseByCourseCode(c.getCode()).getStartDate() );
            c.setEndDate( dao.selectCourseByCourseCode(c.getCode()).getEndDate() );
            c.setInstructorId( dao.selectCourseByCourseCode(c.getCode()).getInstructorId() );
        }
        return courses;
    }



    public int addCourse(int id, int code, String semester){
        //check if course and semester combo is in db
        CourseDAO dao = new CourseDAO();
        Course c = dao.selectCourseByCourseCode(code);
        if(c.getCode() == code && c.getSemester().equals(semester) ){
            //check if student is already enrolled in course that semester
            ArrayList<Course> myCourses = getMyCourses(id, semester);
            for (Course co: myCourses) {
                if(co.getCode() == code){
                    return 2;
                }
            }
            //add course
            String stmt = "INSERT INTO student_courses (ID, Code, Semester) VALUES (?, ?, ?);";
            int result = 0;
            try{
                //establish connection
                Connection conn = getConnection();
                //create statement using connection object
                PreparedStatement ps = conn.prepareStatement(stmt);
                ps.setInt(1, id);
                ps.setInt(2, code);
                ps.setString(3, semester);
                //execute query
                result = ps.executeUpdate();
                return 1;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } else {
            return 0;
        }
    }





















    public static Date selectStartDate(Course course) throws ClassNotFoundException, SQLException {
        String SELECT_StartDATE = "SELECT StartDate FROM course WHERE code = ? ";
        return getCourseDate(course, SELECT_StartDATE);
    }
    public static Date selectEndDate(Course course) throws ClassNotFoundException, SQLException {
        String SELECT_EndDATE = "SELECT EndDate FROM course WHERE code = ? ";
        return getCourseDate(course, SELECT_EndDATE);
    }

    private static Date getCourseDate(Course course, String SELECT_DATE) throws ClassNotFoundException {
        ResultSet resultSet = null;

        int result = 0;
        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/soen387_a1", "root", "");

             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_DATE)) {
            preparedStatement.setInt(1, course.getCode());

            System.out.println(preparedStatement);

            resultSet = preparedStatement.executeQuery();

            ResultSetMetaData rsmd = resultSet.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            while (resultSet.next()) {
                for (int i = 1; i <= columnsNumber; i++) {
                    if (i > 1) System.out.print(",  ");
                    String columnValue = resultSet.getString(i);
                    System.out.print(columnValue + " " + rsmd.getColumnName(i));
                }
                System.out.println("");
            }

//            Date date=new java.sql.Date(resultSet.getDate(1).getTime());

            Timestamp timestamp = resultSet.getTimestamp(1);
            Date date = null;
            if (timestamp != null) {
                date = new Date(timestamp.getTime());
            }
            if(date == null ){
                System.out.println("NULL DATE");
            }
            //System.out.println(date);
            return date;

        } catch (SQLException e) {
            printSQLException(e);
        }
        return null;
    }

    public int getTermCount(User user, Course course) throws ClassNotFoundException {
        String SELECT_SEMESTER_SQL = "SELECT semester, COUNT( semester ) x " +
                "FROM stu_courses GROUP BY semester HAVING x > 0";
        int counter = 0;
        Class.forName("com.mysql.jdbc.Driver");
        ResultSet resultSet = null;

        try (Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/soen387_a1", "root", "");

             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SEMESTER_SQL)) {

            System.out.println(preparedStatement);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                System.out.println("TERM COUNTER : " + resultSet.getInt("x"));
                counter =  resultSet.getInt("x") + 1;
            }

        } catch (SQLException e) {
            printSQLException(e);
        }
        return counter;

    }
    public int updateStudentCourse(User user, Course course) throws ClassNotFoundException {
        String INSERT_COURSE_SQL = "INSERT INTO stu_courses" +
                "  (stu_id, course_code, Semester) VALUES " +
                " (?, ?, ?);";
        int result = 0;
        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/soen387_a1", "root", "");

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_COURSE_SQL)) {
            preparedStatement.setInt(1, user.getId());
            preparedStatement.setInt(2, course.getCode());
            preparedStatement.setString(3, course.getSemester());


            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            result = preparedStatement.executeUpdate();

            //selectDate(course);
        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
        return result;
    }
    public int deleteStudentCourse(User user, Course course) throws ClassNotFoundException {
        String DROP_COURSE_SQL = "DELETE FROM stu_courses WHERE " +
                "course_code =" + course.getCode() + " AND stu_id =" + user.getId();

        int result = 0;
        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/soen387_a1", "root", "");

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(DROP_COURSE_SQL)) {

            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            result = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
        return result;
    }
//    public int selectStudentCourse(User user, Course course) throws ClassNotFoundException {
//        String SELECT_COURSE_SQL = "INSERT INTO stu_courses" +
//                "  (stu_id, course_code, Semester) VALUES " +
//                " (?, ?, ?);";
//
//        int result = 0;
//        Class.forName("com.mysql.jdbc.Driver");
//
//        try (Connection connection = DriverManager
//                .getConnection("jdbc:mysql://localhost:3306/soen387_a1", "root", "");
//
//             // Step 2:Create a statement using connection object
//             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_COURSE_SQL)) {
//            preparedStatement.setInt(1, user.getId());
//            preparedStatement.setInt(2, course.getCode());
//            preparedStatement.setInt(3, course.getSemester());
//
//
//            System.out.println(preparedStatement);
//            // Step 3: Execute the query or update query
//            result = preparedStatement.executeUpdate();
//
//        } catch (SQLException e) {
//            // process sql exception
//            printSQLException(e);
//        }
//        return result;
//    }
    private static void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

    public static void modifyObject(HttpServletRequest request, HttpServletResponse response, Course course, User student) throws IOException {
        int id = Integer.parseInt(request.getParameter("stu_id"));
        int code = Integer.parseInt(request.getParameter("course_code"));
        String semester = request.getParameter("course_semester");

        course.setCode(code);
        student.setId(id);
        course.setSemester(semester);

    }



}