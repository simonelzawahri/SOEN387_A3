package com.example.soen387_a2;



import com.example.soen387_a2.DAO.UserDAO;
import com.example.soen387_a2.bean.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        //read user input
        int loginID = Integer.parseInt(req.getParameter("loginID"));
        String loginPass = req.getParameter("loginPass");

        UserDAO dao = new UserDAO();
        User user = new User();

        if(dao.checkID(loginID)){
            //if user is in db -> verify password
            user = dao.selectUser(loginID);
            if(user.getPassword().equals(loginPass)){
                //user authenticated -> start session
                HttpSession session = req.getSession();
                //get user data and set in session
                session.setAttribute("id", user.getId() );
                session.setAttribute("pass", user.getPassword() );
                session.setAttribute("fname", user.getFirstName() );
                session.setAttribute("lname", user.getLastName() );
                session.setAttribute("address", user.getAddress() );
                session.setAttribute("email", user.getEmail() );
                session.setAttribute("phone", user.getPhone() );
                session.setAttribute("dob", user.getDob() );
                session.setAttribute("admin", user.getAdmin() );
                //send to welcome
                res.sendRedirect("index.jsp");
            } else {
                res.sendRedirect("login.jsp?errorIncorrectPassword=yes");
            }
        } else {
            res.sendRedirect("login.jsp?errorUserNotFound=yes");
        }

    }
}
