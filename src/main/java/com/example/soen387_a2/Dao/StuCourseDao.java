package com.example.soen387_a2.Dao;

import com.example.soen387_a2.bean.Course;
import com.example.soen387_a2.bean.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

/**
 * student can select OR drop a course
 */
public class StuCourseDao {

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
            preparedStatement.setInt(3, course.getSemester());


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
        int semester = Integer.parseInt(request.getParameter("course_semester"));

        course.setCode(code);
        student.setId(id);
        course.setSemester(semester);

    }



}