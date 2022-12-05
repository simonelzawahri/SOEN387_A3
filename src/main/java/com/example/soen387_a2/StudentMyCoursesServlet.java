package com.example.soen387_a2;
import com.example.soen387_a2.DAO.CourseDAO;
import com.example.soen387_a2.DAO.StudentCoursesDAO;
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

@WebServlet("/MyCourses")
public class StudentMyCoursesServlet extends HttpServlet{
      protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          StudentCoursesDAO dao = new StudentCoursesDAO();
          ArrayList<Course> courses = dao.getMyCourses( (int) request.getSession().getAttribute("id"), request.getParameter("semester"));
          request.getSession().setAttribute("list", courses);
          response.sendRedirect("student_my_courses.jsp?gotit=t");


      }



//    public StudentMyCoursesServlet() {
//
//    }
//    //private static final long serialVersionUID = 1;
//
//    Connection connection = null;
//    ResultSet resultSet = null;
//    PreparedStatement preparedStatement = null;
//    String query = null;
//    boolean isID = false;
//
//    public void init() {
//        try{
//            Class.forName("com.mysql.jdbc.Driver");
//            connection = DriverManager
//                    .getConnection("jdbc:mysql://localhost:3306/soen387_a1", "root", "");
//        } catch (ClassNotFoundException | SQLException e) {
//            throw new RuntimeException(e);
//        }
//
//
//    }
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
//        response.setContentType("text/html;charset=UTF-8");
//        PrintWriter out = response.getWriter();
//
//        int stu_id = Integer.parseInt(request.getParameter("stu_id"));
//        query = "select * from stu_courses WHERE stu_id = " + stu_id;
//
//        try {
//            preparedStatement = connection.prepareStatement(query);
//            resultSet = preparedStatement.executeQuery();
//
//            while(resultSet.next()) {
//                out.println("<tr>");
//                out.println("<td>"+resultSet.getString(1) + "</td>");
//                out.println("<td>"+resultSet.getString(2) + "</td>");
//                out.println("<td>"+resultSet.getString(3) + "</td>");
//                out.println("</tr>");
//
//            }
//
//            out.println("</table></br><hr></div></body></html>");
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//
//    }

}
