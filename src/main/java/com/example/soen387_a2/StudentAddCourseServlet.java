package com.example.soen387_a2;

import com.example.soen387_a2.DAO.StudentCoursesDAO;
import com.example.soen387_a2.bean.Course;
import com.example.soen387_a2.bean.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@WebServlet("/AddCourse")
public class StudentAddCourseServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        StudentCoursesDAO dao = new StudentCoursesDAO();
        int added = dao.addCourse((int) request.getSession().getAttribute("id"), Integer.parseInt(request.getParameter("code")), request.getParameter("semester") );
        if(added == 1){
            response.sendRedirect("student_add_course.jsp?success=t");
        } else if (added == 0){
            response.sendRedirect("student_add_course.jsp?failed=t");
        } else if (added == 2){
            response.sendRedirect("student_add_course.jsp?alreadyRegistered=t");
        }

    }





}