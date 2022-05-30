package com.LiZhihui.controller;

import com.LiZhihui.dao.OrderDao;
import com.LiZhihui.dao.UserDao;
import com.LiZhihui.model.Order;
import com.LiZhihui.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "AccountDetailsServlet", value = "/accountDetails")
public class AccountDetailsServlet extends HttpServlet {
    Connection con=null;
    @Override
    public void init() throws ServletException {
        super.init();
        con=(Connection) getServletContext().getAttribute("con");
    }

    @Override
    public void destroy() {
        super.destroy();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if(session!=null && session.getAttribute("user")!=null){
            User user = (User) session.getAttribute("user");
            int id = (int) user.getId();
            UserDao dao = new UserDao();
            try {
                user = dao.findById(con,id);
                request.setAttribute("user",user);
                OrderDao orderDao = new OrderDao();
                List<Order> orderList = orderDao.findByUserId(con, id);
                request.setAttribute("orderList",orderList);
                request.getRequestDispatcher("WEB-INF/views/accountDetails.jsp").forward(request,response);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }else{
            response.sendRedirect("login");
        }
    }//end doGet

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request,response);
    }
}
