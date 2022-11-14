package com.example.soen387_a2.Dao;

import com.example.soen387_a2.bean.Course;
import com.example.soen387_a2.bean.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * student can select OR drop a course
 */
public class StuCourseDao {
    public int registerStudentCourse(User user, Course course) throws ClassNotFoundException {
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

        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
        return result;
    }
    public int dropStudentCourse(User user, Course course) throws ClassNotFoundException {
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
    private void printSQLException(SQLException ex) {
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
}