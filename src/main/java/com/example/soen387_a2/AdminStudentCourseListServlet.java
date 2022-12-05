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



//
//
//
//        response.setContentType("text/html;charset=UTF-8");
//        PrintWriter out = response.getWriter();
//
//        if(request.getParameter("stu_id") != null){
//            isID = true;
//            int stu_id = Integer.parseInt(request.getParameter("stu_id"));
//            query = "select * from stu_courses WHERE stu_id = " + stu_id;
//        }else{
//            int course_code = Integer.parseInt(request.getParameter("course_code"));
//            query = "select * from stu_courses WHERE course_code = " + course_code;
//        }
//
//        try {
//            preparedStatement = connection.prepareStatement(query);
//            resultSet = preparedStatement.executeQuery();
//
//            if(isID) out.println("<html><body><div align=\"center\"><h2>The student has following courses registered : </h2>");
//            else out.println("<html><body><div align=\"center\"><h2>The course has following students enrolled : </h2>");
//            out.println("<hr></br><table cellspacing='0' cellpadding='5' border='1'>");
//            out.println("<tr>");
//            out.println("<td><b>Student ID</b></td>");
//            out.println("<td><b>Course Code</b></td>");
//            out.println("<td><b>Semester</b></td>");
//            out.println("</tr>");
//
//            //iterate course resultset of course objs
//            while(resultSet.next()) {
//                out.println("<tr>");
//                out.println("<td>"+resultSet.getString(1) + "</td>");
//                out.println("<td>"+resultSet.getString(2) + "</td>");
//                out.println("<td>"+resultSet.getString(3) + "</td>");
//                out.println("</tr>");
//            }
//
//            out.println("</table></br><hr></div></body></html>");
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//


    }

}
