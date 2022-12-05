package com.example.soen387_a2;

import com.example.soen387_a2.DAO.StudentCoursesDAO;
import com.example.soen387_a2.bean.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/CourseStudentList")
public class AdminCourseStudentListServlet extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //use DAO to get students given course code and return ArrayList of Student obj
        StudentCoursesDAO dao = new StudentCoursesDAO();
        ArrayList<Student> students = dao.getStudentsByCourseCode(Integer.parseInt(request.getParameter("code")), request.getParameter("semester"));

        request.getSession().setAttribute("list", students);

        response.sendRedirect("admin_course_student_list.jsp?gotit=t");

    }


}
