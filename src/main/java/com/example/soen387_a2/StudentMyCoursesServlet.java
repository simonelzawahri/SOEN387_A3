package com.example.soen387_a2;
import com.example.soen387_a2.DAO.CourseDAO;
import com.example.soen387_a2.DAO.StudentCoursesDAO;
import com.example.soen387_a2.bean.Course;

import javax.servlet.annotation.WebServlet;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;

@WebServlet("/MyCourses")
public class StudentMyCoursesServlet extends HttpServlet{
      protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          StudentCoursesDAO dao = new StudentCoursesDAO();
          ArrayList<Course> courses = dao.getMyCourses( (int) request.getSession().getAttribute("id"), request.getParameter("semester"));
          request.getSession().setAttribute("list", courses);
          response.sendRedirect("student_my_courses.jsp?gotit=t");


      }


}
