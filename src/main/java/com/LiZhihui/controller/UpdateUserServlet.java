package com.LiZhihui.controller;

import com.LiZhihui.dao.UserDao;
import com.LiZhihui.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

@WebServlet(name = "UpdateUserServlet", value = "/updateUser")
public class UpdateUserServlet extends HttpServlet {

    Connection con;

    @Override
    public void init() throws ServletException {
        con=(Connection) getServletContext().getAttribute("con");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //forward to WEB-INF/views/updateUser.jsp
        request.getRequestDispatcher("/WEB-INF/views/updateUser.jsp").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //get all the parameters
        Long id = Long.valueOf(request.getParameter("id"));
        String username = request.getParameter("Username");
        String password = request.getParameter("password");
        String email = request.getParameter("Email");
        Date Birthdate = Date.valueOf(request.getParameter("Birthdate"));
        String gender=request.getParameter("gender");
        //create a user model
        User user = new User();
        user.setId(id);
        user.setUsername(username);
        user.setPassword((password));
        user.setEmail(email);
        user.setBirthdate(Birthdate);
        user.setGender(gender);
        //set 6 values to the user model
        UserDao userDao = new UserDao();
        try {
            int result = userDao.updateUser(con, user);
            if(result>0){
                HttpSession session = request.getSession();
                session.setAttribute("user",user);
//                request.getRequestDispatcher("/WEB-INF/views/userInfo.jsp").forward(request, response);
                request.getRequestDispatcher("accountDetails").forward(request,response);
            }else{
                request.getRequestDispatcher("/WEB-INF/views/updateUser.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
