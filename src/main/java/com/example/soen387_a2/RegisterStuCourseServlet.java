package com.example.soen387_a2;

import com.example.soen387_a2.Dao.StuCourseDao;
import com.example.soen387_a2.bean.Course;
import com.example.soen387_a2.bean.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/registerStudentCourse")
public class RegisterStuCourseServlet extends HttpServlet {

    public RegisterStuCourseServlet() {

    }

    //private static final long serialVersionUID = 1;
    private StuCourseDao StuCourseDao;
    private User student;
    private Course course;

    public void init() {
        StuCourseDao = new StuCourseDao();
        student = new User();
        course = new Course();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        StuCourseDao.modifyTable(request, response, course, student);

        try {
            StuCourseDao.updateStudentCourse(student, course);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        //response.sendRedirect("responseStatus.jsp");
        request.setAttribute("alertMsg", "Course successfully registered!");
        RequestDispatcher rd=request.getRequestDispatcher("/responseStatus.jsp");
        try {
            rd.include(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }
    }


}