package com.example.soen387_a2;

import com.example.soen387_a2.Dao.CourseDao;
import com.example.soen387_a2.bean.Course;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/createCourse")
public class CreateCourseServlet extends HttpServlet{

    //private static final long serialVersionUID = 1;
    private CourseDao courseDao;

    public void init() {
        courseDao = new CourseDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        int code = Integer.parseInt(request.getParameter("course_code"));
        String title = request.getParameter("course_title");
        int semester = Integer.parseInt(request.getParameter("course_semester"));
        int days = Integer.parseInt(request.getParameter("course_days"));
        String time = request.getParameter("course_time");
        String instructor = request.getParameter("course_instructor");

        String room = request.getParameter("course_room");
        String startDate = request.getParameter("course_startdate");
        String endDate = request.getParameter("course_enddate");
        int instructorId = Integer.parseInt(request.getParameter("course_instructorid"));

        Course course = new Course();
        course.setCode(code);
        course.setTitle(title);
        course.setSemester(semester);
        course.setDays(days);
        course.setTime(time);
        course.setInstructor(instructor);
        course.setRoom(room);
        course.setStartDate(startDate);
        course.setEndDate(endDate);
        course.setInstructorId(instructorId);


        try {
            courseDao.createCourse(course);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        //response.sendRedirect("responseStatusStudent.jsp");

        request.setAttribute("alertMsg", "Course successfully created!");
        //System.out.println(request.getAttribute("alertMsg"));
        RequestDispatcher rd=request.getRequestDispatcher("/responseStatusAdmin.jsp");
        try {
            rd.include(request, response);
            //System.out.println("success");
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }
    }
}
