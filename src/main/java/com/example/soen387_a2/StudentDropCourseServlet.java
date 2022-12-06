package com.example.soen387_a2;

import com.example.soen387_a2.DAO.StudentCoursesDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DropCourse")
public class StudentDropCourseServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        StudentCoursesDAO dao = new StudentCoursesDAO();
        int drop = dao.dropCourse((int) request.getSession().getAttribute("id"), Integer.parseInt(request.getParameter("code")), request.getParameter("semester") );
        if(drop == 1){
            response.sendRedirect("student_drop_course.jsp?success=t");
        } else if (drop == 0){
            response.sendRedirect("student_drop_course.jsp?courseDoesNotExist=t");
        } else if (drop == 2){
            response.sendRedirect("student_drop_course.jsp?notRegistered=t");
        }
        
        
    }
    
    
    
}
