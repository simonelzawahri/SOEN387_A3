package com.example.soen387_a2;

import com.example.soen387_a2.Dao.UserDAO;
import com.example.soen387_a2.bean.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/signup")
public class SignupServlet extends HttpServlet {

    private static final long serialVersionUID = 1;
    private UserDAO userDAO;

    public void init() {
        userDAO = new UserDAO();
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        //get user input
        int admin = Integer.parseInt(req.getParameter("iam"));
        int id = Integer.parseInt(req.getParameter("id"));
        String firstName = req.getParameter("fname");
        String lastName = req.getParameter("lname");
        String address = req.getParameter("address");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String dob = req.getParameter("dob");
        String pass = req.getParameter("pass");

//        PrintWriter out = res.getWriter();
//        out.print(id+firstName+lastName+phone+dob+pass);

        //create user object
        User user = new User();
        user.setAdmin(admin);
        user.setId(id);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setAddress(address);
        user.setEmail(email);
        user.setPhone(phone);
        user.setDob(dob);
        user.setPassword(pass);

        try {
            //if user id doesnt exist -> insert user in db -> redirect user to login page
            if(!userDAO.idExists(user)){
                //if user created successfully, redirect to login page
                if (userDAO.createUser(user) > 0) {
                    res.sendRedirect("signup.jsp?signupSuccess=yes");
                }
            } else {
                //else user already exists
                res.sendRedirect("signup.jsp?errorIDTaken=yes");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

//        //start session
//        HttpSession sesh = req.getSession();
//        //to set session variables
////        sesh.setAttribute(x, 5);
//        //to get session vaiables
////        sesh.getAttribute(x);
//        //to delete session variables
////        sesh.removeAttribute(x);



    }











}
