package com.example.soen387_a2;
import com.example.soen387_a2.DAO.CourseDAO;
import com.example.soen387_a2.bean.Course;

import javax.servlet.annotation.WebServlet;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;

@WebServlet("/BrowseCourses")
public class StudentBrowseCoursesServlet extends HttpServlet{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CourseDAO dao = new CourseDAO();
        ArrayList<Course> courses = dao.selectCoursesBySemester(request.getParameter("semester"));
        request.getSession().setAttribute("list", courses);
        response.sendRedirect("student_browse_courses.jsp?gotit=t");
    }

    //
//  Connection connection = null;
//  ResultSet resultSet = null;
//  PreparedStatement preparedStatement = null;
//  String query = null;
//
//  public void init() {
//      try{
//          Class.forName("com.mysql.jdbc.Driver");
//          connection = DriverManager
//                  .getConnection("jdbc:mysql://localhost:3306/soen387_a1", "root", "");
//      } catch (ClassNotFoundException | SQLException e) {
//          throw new RuntimeException(e);
//      }
//    }
//
//    protected void doGet(
//            HttpServletRequest request,
//            HttpServletResponse response
//    ) throws ServletException, IOException {
//        doPost(request, response);
//    }
//
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws IOException {
//
//              response.setContentType("text/html;charset=UTF-8");
//              PrintWriter out = response.getWriter();
//
//              query = "select * FROM Course";
//
//              try {
//
//                  preparedStatement = connection.prepareStatement(query);
//                  resultSet = preparedStatement.executeQuery();
//
//                  out.println("<html><body><div align=\"center\"><h2>Courses: </h2>");
//                  out.println("<hr></br><table cellspacing='0' cellpadding='5' border='1'>");
//                  out.println("<tr>");
//                  out.println("<td><b>Course Code</b></td>");
//                  out.println("<td><b>Semester</b></td>");
//                  out.println("</tr>");
//
//                  while(resultSet.next()) {
//                      out.println("<tr>");
//                      out.println("<td>"+resultSet.getString(1) + "</td>");
//                      out.println("<td>"+resultSet.getString(2) + "</td>");
//                      out.println("<td>"+resultSet.getString(3) + "</td>");
//                      out.println("</tr>");
//                    }
//
//              out.println("</table></br><hr></div></body></html>");
//            } catch (SQLException e) {
//              throw new RuntimeException(e);
//            }
//    }


}
