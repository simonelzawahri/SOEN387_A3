package com.example.soen387_a2;

import com.example.soen387_a2.DAO.CourseDAO;
import com.example.soen387_a2.bean.Course;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/CreateCourse")
public class AdminCreateCourseServlet extends HttpServlet{


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        //get user input
        int code = Integer.parseInt(request.getParameter("course_code"));
        String title = request.getParameter("course_title");
        String semester = request.getParameter("course_semester");
        String days = request.getParameter("course_days");
        String time = request.getParameter("course_time");
        String instructor = request.getParameter("course_instructor");
        String room = request.getParameter("course_room");
        String start = request.getParameter("course_startdate");
        String end = request.getParameter("course_enddate");
        int instructorId = Integer.parseInt(request.getParameter("course_instructorid"));

        //if user entered instructorID != to theirs
        int x = (int) request.getSession().getAttribute("id");
        if(instructorId != x){
            response.sendRedirect("admin_create_course.jsp?invalidInstructorID=yes");
        }

        //create course obj
        Course course = new Course();
        course.setCode(code);
        course.setTitle(title);
        course.setSemester(semester);
        course.setDays(days);
        course.setTime(time);
        course.setInstructor(instructor);
        course.setRoom(room);
        course.setStartDate(start);
        course.setEndDate(end);
        course.setInstructorId(instructorId);

        CourseDAO dao = new CourseDAO();

        try {
            //if course code doesnt exist -> insert course in db -> redirect user to create course page
            if(!dao.courseCodeExists(course)){
                //if course created successfully, redirect to create course page
                if (dao.createCourse(course) > 0) {
                    response.sendRedirect("admin_create_course.jsp?createCourseSuccess=yes");
                }
            } else {
                //else course code already exists
                response.sendRedirect("admin_create_course.jsp?courseCodeAlreadyExists=yes");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }





}
