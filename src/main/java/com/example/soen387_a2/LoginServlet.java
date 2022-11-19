package com.example.soen387_a2;



import com.example.soen387_a2.Dao.UserDAO;
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

        UserDAO u = new UserDAO();
        User user = new User();

        //check if user is in db
        if(u.check(loginID, loginPass)){
            HttpSession session = req.getSession();
            //get user data and save in session
            user = u.selectUser(loginID, loginPass);
            session.setAttribute("id", user.getId() );
            session.setAttribute("pass", user.getPassword() );
            session.setAttribute("fname", user.getFirstName() );
            session.setAttribute("lname", user.getLastName() );
            session.setAttribute("address", user.getAddress() );
            session.setAttribute("email", user.getEmail() );
            session.setAttribute("phone", user.getPhone() );
            session.setAttribute("dob", user.getDob() );
            session.setAttribute("admin", user.getAdmin() );
            res.sendRedirect("welcome.jsp");
        } else {
            res.sendRedirect("login.jsp");

        }


//        //get user from db
//        UserDAO u = new UserDAO();
//        User dbu = u.selectUser(loginID);
//
//        //check creds with db user
//        if(dbu.getId() == loginID && dbu.getPassword().equals(loginPass)){
//            //start session and set session variables
//            HttpSession session = req.getSession();
//            session.setAttribute("id", dbu.getId());
//            session.setAttribute("pass", dbu.getPassword());
//            session.setAttribute("fname", dbu.getFirstName());
//            session.setAttribute("lname", dbu.getLastName());
//            session.setAttribute("address", dbu.getAddress());
//            session.setAttribute("email", dbu.getEmail());
//            session.setAttribute("phone", dbu.getPhone());
//            session.setAttribute("dob", dbu.getDob());
//            session.setAttribute("admin", dbu.getAdmin());
//            res.sendRedirect("index.jsp");
//        } else if ( !(dbu.getId() == loginID && dbu.getPassword().equals(loginPass)) ){
//            res.sendRedirect("login.jsp?error=incorrectPass");
//        }

//        PrintWriter out = res.getWriter();
//        out.println("You entered: \n" + loginID + "\n" + loginPass);

    }
}
