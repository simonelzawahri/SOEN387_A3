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

@WebServlet("/StudentAddCourse")
public class StudentAddCourseServlet extends HttpServlet {

    public StudentAddCourseServlet() {

    }

    //private static final long serialVersionUID = 1;
    private StudentCoursesDAO studentCoursesDao;
    private User student;
    private Course course;

    String currentDate;
    Date courseDate = null;
    java.util.Date inputDate;
    java.util.Date courseDateRange;
    int counter = 0;
    public void init() {
        studentCoursesDao = new StudentCoursesDAO();
        student = new User();
        course = new Course();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        studentCoursesDao.modifyObject(request, response, course, student);

        try {
            counter = studentCoursesDao.getTermCount(student,course);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        if(counter > 4){
            System.out.println("hit 5 course limit");

            request.setAttribute("alertMsg", "You hava added 5 courses for this term, can't add more!");
            request.setAttribute("id", student.getId());
            RequestDispatcher rd=request.getRequestDispatcher("/responseStatusStudent.jsp");
            try {
                rd.include(request, response);
            } catch (ServletException e) {
                throw new RuntimeException(e);
            }
            return;
        }

        // check for date
        // courseDate: 10-12
        // inputDate: 10-19 || 10-11
        try {
            System.out.println("course code :: "+course.getCode());
            courseDate = studentCoursesDao.selectStartDate(course);

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        cal.setTime(courseDate);
        cal.add(Calendar.DAY_OF_MONTH, 7);

        System.out.println("7 days after course start date : "+ sdf.format(cal.getTime()));
        courseDateRange = cal.getTime();
        currentDate = request.getParameter("date_input");


        try {
            inputDate = sdf.parse(currentDate);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        int result = courseDate.compareTo(inputDate); // positive if cd > id
        int result1 = courseDateRange.compareTo(inputDate);
        // invalid : case id < cd || case id > cdr
        if(result > 0 || result1 < 0) {
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
                studentCoursesDao.updateStudentCourse(student, course);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            //response.sendRedirect("responseStatusStudent.jsp");
            request.setAttribute("alertMsg", "Course successfully registered!");
            request.setAttribute("id", student.getId());
            System.out.println("ID ::  " + student.getId());
            RequestDispatcher rd=request.getRequestDispatcher("/responseStatusStudent.jsp");
            try {
                rd.include(request, response);
            } catch (ServletException e) {
                throw new RuntimeException(e);
            }
        }





    }


}