package com.example.soen387_a2;
import com.example.soen387_a2.DAO.StudentCoursesDAO;
import com.example.soen387_a2.bean.Course;

import javax.servlet.annotation.WebServlet;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/StudentCourseList")
public class AdminStudentCourseListServlet extends HttpServlet{


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        //use DAO to get courses given studentID and return ArrayList of Course obj
        StudentCoursesDAO dao = new StudentCoursesDAO();
        ArrayList<Course> courses = dao.getCoursesByStudentID(Integer.parseInt(request.getParameter("stu_id")));
        request.getSession().setAttribute("list", courses);
        response.sendRedirect("admin_student_course_list.jsp?gotit=t");


    }

}
