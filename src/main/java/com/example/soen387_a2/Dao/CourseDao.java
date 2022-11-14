package com.example.soen387_a2.Dao;


import com.example.soen387_a2.bean.Course;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class CourseDao {
    // register a course by administrator
    public int createCourse(Course course) throws ClassNotFoundException {
        String INSERT_USERS_SQL = "INSERT INTO course" +
                "  (Code, Title, Semester, Days, Time, Instructor, Room, StartDate, EndDate, InstructorID) VALUES " +
                " (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

        int result = 0;
        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/soen387_a1", "root", "");

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setInt(1, course.getCode());
            preparedStatement.setString(2, course.getTitle());
            preparedStatement.setInt(3, course.getSemester());
            preparedStatement.setInt(4, course.getDays());
            preparedStatement.setString(5, course.getTime());
            preparedStatement.setString(6, course.getInstructor());
            preparedStatement.setString(7, course.getRoom());
            preparedStatement.setString(8, course.getStartDate());
            preparedStatement.setString(9, course.getEndDate());
            preparedStatement.setInt(10, course.getInstructorId());

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