package com.example.soen387_a2.DAO;


import com.example.soen387_a2.bean.Course;

import java.sql.*;


public class CourseDAO {


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


    public Course selectCourse(int code){
        String stmt = "SELECT * FROM course WHERE Code=?";
        Course course = new Course();
        try {
            //establish connection
            Connection conn = getConnection();
            //create statement using connection object
            PreparedStatement ps = conn.prepareStatement(stmt);
            ps.setInt(1, code);
            //execute query
            ResultSet rs = ps.executeQuery();
            //read data from ResultSet
            while(rs.next()){
                //read data from ResultSet
                int rs_code = Integer.parseInt(rs.getString("Code"));
                String rs_title = rs.getString("Title");
                String rs_semester = rs.getString("Semester");
                String rs_days = rs.getString("Days");
                String rs_time = rs.getString("Time");
                String rs_instructor = rs.getString("Instructor");
                String rs_room = rs.getString("Room");
                String rs_start = rs.getString("StartDate");
                String rs_end = rs.getString("EndDate");
                int rs_instructorID = Integer.parseInt(rs.getString("InstructorID"));
                //set data to course object
                course.setCode(rs_code);
                course.setTitle(rs_title);
                course.setSemester(rs_semester);
                course.setDays(rs_days);
                course.setTime(rs_time);
                course.setInstructor(rs_instructor);
                course.setRoom(rs_room);
                course.setStartDate(rs_start);
                course.setEndDate(rs_end);
                course.setInstructorId(rs_instructorID);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return course;
    }


    public boolean courseCodeExists(Course course) throws ClassNotFoundException {
        String stmt = "SELECT Code FROM course WHERE code=?";
        try{
            //establish connection
            Connection conn = getConnection();
            //create statement using connection object
            PreparedStatement ps = conn.prepareStatement(stmt);
            ps.setInt(1, course.getCode());
            //execute query
            ResultSet rs = ps.executeQuery();
            //read data from ResultSet
            return rs.next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public int createCourse(Course course) throws ClassNotFoundException {
        String stmt = "INSERT INTO course" +
                " (Code, Title, Semester, Days, Time, Instructor, Room, StartDate, EndDate, InstructorID) VALUES " +
                " (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        int result = 0;
        try{
            //establish connection
            Connection conn = getConnection();
            //create statement using connection object
            PreparedStatement ps = conn.prepareStatement(stmt);
            ps.setInt(1, course.getCode());
            ps.setString(2, course.getTitle());
            ps.setString(3, course.getSemester());
            ps.setString(4, course.getDays());
            ps.setString(5, course.getTime());
            ps.setString(6, course.getInstructor());
            ps.setString(7, course.getRoom());
            ps.setString(8, course.getStartDate());
            ps.setString(9, course.getEndDate());
            ps.setInt(10, course.getInstructorId());
            //execute query
            result = ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
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