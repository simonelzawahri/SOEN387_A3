package com.example.soen387_a2.Dao;

import com.example.soen387_a2.bean.User;

import java.sql.*;

public class UserDAO {

    protected Connection getConnection(){
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/soen387__a1", "root", "");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return conn;
    }


    public boolean check(int id, String pass)  {
        String stmt = "SELECT id FROM users WHERE ID=? AND Password=?";
        try{
            //establish connection
            Connection conn = getConnection();
            //create statement using connection object
            PreparedStatement ps = conn.prepareStatement(stmt);
            ps.setInt(1, id);
            ps.setString(2, pass);
            //execute query
            ResultSet rs = ps.executeQuery();
            //read data from ResultSet
            return rs.next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public User selectUser(int id, String pass){
        String stmt = "SELECT * FROM users WHERE ID=? AND Password=?";
        User user = new User();
        try {
            //establish connection
            Connection conn = getConnection();
            //create statement using connection object
            PreparedStatement ps = conn.prepareStatement(stmt);
            ps.setInt(1, id);
            ps.setString(2, pass);
            //execute query
            ResultSet rs = ps.executeQuery();
            //read data from ResultSet
            while(rs.next()){
                int rs_id = Integer.parseInt(rs.getString("ID"));
                String rs_pass = rs.getString("Password");
                String rs_fname = rs.getString("FirstName");
                String rs_lname = rs.getString("LastName");
                String rs_address = rs.getString("Address");
                String rs_email = rs.getString("Email");
                String rs_phone = rs.getString("Phone");
                String rs_dob = rs.getString("DOB");
                int rs_admin = Integer.parseInt(rs.getString("Admin"));

                user.setId(rs_id);
                user.setPassword(rs_pass);
                user.setFirstName(rs_fname);
                user.setLastName(rs_lname);
                user.setAddress(rs_address);
                user.setEmail(rs_email);
                user.setPhone(rs_phone);
                user.setDob(rs_dob);
                user.setAdmin(rs_admin);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }


    public boolean idExists(User user) throws ClassNotFoundException {
        String stmt = "SELECT id FROM users WHERE ID=?";
        try{
            //establish connection
            Connection conn = getConnection();
            //create statement using connection object
            PreparedStatement ps = conn.prepareStatement(stmt);
            ps.setInt(1, user.getId());
            //execute query
            ResultSet rs = ps.executeQuery();
            //read data from ResultSet
            return rs.next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

        public int insertUser(User user) throws ClassNotFoundException {
            String stmt = "INSERT INTO users (ID, Password, FirstName, LastName, Address, Email, Phone, DOB, Admin) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
            int result = 0;
            try{
                //establish connection
                Connection conn = getConnection();
                //create statement using connection object
                PreparedStatement ps = conn.prepareStatement(stmt);
                ps.setInt(1, user.getId());
                ps.setString(2, user.getPassword());
                ps.setString(3, user.getFirstName());
                ps.setString(4, user.getLastName());
                ps.setString(5, user.getAddress());
                ps.setString(6, user.getEmail());
                ps.setString(7, user.getPhone());
                ps.setString(8, user.getDob());
                ps.setInt(9, user.getAdmin());
                //execute query
                result = ps.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        return result;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

}
