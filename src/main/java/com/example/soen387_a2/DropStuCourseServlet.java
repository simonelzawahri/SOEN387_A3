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
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;


@WebServlet("/dropStudentCourse")
public class DropStuCourseServlet extends HttpServlet {
    public DropStuCourseServlet() {

    }

    //private static final long serialVersionUID = 1;
    private StuCourseDao StuCourseDao;
    private User student;
    private Course course;

    String currentDate;
    Date courseDate = null;
    java.util.Date inputDate;

    public void init() {
        StuCourseDao = new StuCourseDao();
        student = new User();
        course = new Course();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        StuCourseDao.modifyObject(request, response, course, student);

        try {
            courseDate = StuCourseDao.selectEndDate(course);

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        currentDate = request.getParameter("date_input");

        try {
            inputDate = sdf.parse(currentDate);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        int result = courseDate.compareTo(inputDate); // positive if cd > id

        if(result < 0 ) {
            System.out.println("Your date input is invalid");

            request.setAttribute("alertMsg", "Your date input is invalid!");
            request.setAttribute("id", student.getId());
            RequestDispatcher rd=request.getRequestDispatcher("/responseStatusStudent.jsp");
            try {
                rd.include(request, response);
            } catch (ServletException e) {
                throw new RuntimeException(e);
            }
        }
        else {
            try {
                StuCourseDao.deleteStudentCourse(student, course);
            } catch (Exception e) {
                e.printStackTrace();
            }
            //response.sendRedirect("responseStatusStudent.jsp");
            request.setAttribute("alertMsg", "Course successfully dropped!");
            request.setAttribute("id", student.getId());
            RequestDispatcher rd=request.getRequestDispatcher("/responseStatusStudent.jsp");
            try {
                rd.include(request, response);
            } catch (ServletException e) {
                throw new RuntimeException(e);
            }
        }
        }



    }




